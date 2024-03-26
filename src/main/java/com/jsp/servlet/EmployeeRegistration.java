package com.jsp.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.Dao.EmployeeDao;
import com.jsp.Dao.EmplyeeDaoimp;
import com.jsp.model.Employee;
@WebServlet("/Registration")
public class EmployeeRegistration extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		double sal=Double.parseDouble(req.getParameter("salary"));
		int deptno=Integer.parseInt(req.getParameter("deptno"));
		
		Employee employee=new Employee();
		employee.setEmpName(name);
		employee.setEmpSalary(sal);
		employee.setEmpdeptno(deptno);
		EmployeeDao dao=new EmplyeeDaoimp();
		int result=dao.addEmployee(employee);
		if(result!=0)
		{
			RequestDispatcher rd=req.getRequestDispatcher("allEmployeeDetailes");
			rd.forward(req, resp);
		}
		else
		{
			RequestDispatcher rd=req.getRequestDispatcher("Registration.html");
			rd.include(req, resp);
		}
		
		
	}

}
