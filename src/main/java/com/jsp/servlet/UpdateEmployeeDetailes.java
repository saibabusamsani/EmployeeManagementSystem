package com.jsp.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import com.jsp.Dao.EmployeeDao;
import com.jsp.Dao.EmplyeeDaoimp;
import com.jsp.model.Employee;
@WebServlet("/update")
public class UpdateEmployeeDetailes extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("empName");
		String tempSalary=req.getParameter("empSalary");
		String tempDeptno=req.getParameter("empDeptno");
		String tempId=req.getParameter("empId");
		Employee employee=new Employee();
		employee.setEmpId(Integer.parseInt(tempId));
		employee.setEmpName(name);
		employee.setEmpSalary(Double.parseDouble(tempSalary));
		employee.setEmpdeptno(Integer.parseInt(tempDeptno));
		
		EmployeeDao dao=new EmplyeeDaoimp();
		int detailes=dao.updateEmployeeDetailes(employee);
		if(detailes!=0)
		{
			RequestDispatcher dispatcher=req.getRequestDispatcher("/allEmployeeDetailes");
			dispatcher.forward(req, resp);
		}
		else
		{
			RequestDispatcher dispatcher=req.getRequestDispatcher("null.html");
			dispatcher.forward(req, resp);
		}
		
	}
	

}
