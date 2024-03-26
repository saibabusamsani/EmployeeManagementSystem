package com.jsp.Dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.jsp.model.Employee;

public class EmplyeeDaoimp implements EmployeeDao
{
	String url="jdbc:mysql://localhost:3306/teca53?user=root&password=12345";
	List<Employee> listEmployee=new ArrayList<Employee>();
			
	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection(url);
			Statement st=connection.createStatement();
			ResultSet resultSet=st.executeQuery("select * from employee");
			if(resultSet.isBeforeFirst())
			{
				while(resultSet.next())
				{
					Employee employee=new Employee();
					employee.setEmpId(resultSet.getInt(1));
					employee.setEmpName(resultSet.getString(2));
					employee.setEmpSalary(resultSet.getDouble(3));
					employee.setEmpdeptno(resultSet.getInt(4));
					listEmployee.add(employee);
					
				}
			}
			else
			{
				System.out.println("no data found");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listEmployee;
		
	}

	@Override
	public List<Employee> getEmployeeDetailesBySalOrDeptno(int deptno) {
		// TODO Auto-generated method stub
		String select="select * from employee where emp_salary=? or emp_depatno=?";
		try {
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement ps=connection.prepareStatement(select);
			ps.setInt(1, deptno);
			ps.setInt(2, deptno);
			ResultSet rs=ps.executeQuery();
			if(rs.isBeforeFirst())
			{
				while(rs.next())
				{
					Employee employee=new Employee();
					employee.setEmpId(rs.getInt(1));
					employee.setEmpName(rs.getString(2));
					employee.setEmpSalary(rs.getDouble(3));
					employee.setEmpdeptno(rs.getInt(4));
					listEmployee.add(employee);
				}
				return listEmployee;
			}
			else
			{
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public Employee getEmployeeById(int id) {
		String select ="select * from employee where emp_id=?";
		try {
			Connection con=DriverManager.getConnection(url);
			PreparedStatement ps=con.prepareStatement(select);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				Employee employee=new Employee();
				employee.setEmpId(rs.getInt(1));
				employee.setEmpName(rs.getString(2));
				employee.setEmpSalary(rs.getDouble(3));
				employee.setEmpdeptno(rs.getInt(4));
				return employee;
				
			}
			else
			{
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public int updateEmployeeDetailes(Employee employee) {
		// TODO Auto-generated method stub
		String update="update employee set emp_name=?,emp_salary=?,emp_depatno=? where emp_id=?";
		try {
			Connection con=DriverManager.getConnection(url);
			PreparedStatement ps=con.prepareStatement(update);
			ps.setString(1,employee.getEmpName());
			ps.setDouble(2,employee.getEmpSalary() );
			ps.setInt(3,employee.getEmpdeptno());
			ps.setInt(4,employee.getEmpId());
			int result=ps.executeUpdate();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}

	@Override
	public int  deleteEmployeeById(int id) {
		String delete="delete from employee where emp_id=?";
		try {
			FileInputStream f=new FileInputStream("C:\\Advance_java\\EmployeeManagerSYstem\\src\\main\\java\\com\\jsp\\file\\application.properties");
			Properties p=new Properties();
			p.load(f);
			String url=p.getProperty("url");
			String username=p.getProperty("username");
			String password=p.getProperty("password");
			Connection con=DriverManager.getConnection(url,username,password);
			PreparedStatement ps=con.prepareStatement(delete);
			ps.setInt(1, id);
			return ps.executeUpdate();
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
		
	}

	@Override
	public int addEmployee(Employee employee) {
		String insert="insert into employee(emp_name,emp_salary,emp_depatno) values(?,?,?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url);
			PreparedStatement ps=con.prepareStatement(insert);
			ps.setString(1, employee.getEmpName());
			ps.setDouble(2, employee.getEmpSalary());
			ps.setInt(3,employee.getEmpdeptno());
			return ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}


	

}
