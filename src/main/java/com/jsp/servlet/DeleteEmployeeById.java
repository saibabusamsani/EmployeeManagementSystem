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
@WebServlet("/delete")
public class DeleteEmployeeById extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		int empId=Integer.parseInt(req.getParameter("id"));
		EmployeeDao dao=new EmplyeeDaoimp();
		int result=dao.deleteEmployeeById(empId);
		if(result!=0)
		{
			RequestDispatcher rd=req.getRequestDispatcher("/allEmployeeDetailes");
			rd.forward(req, resp);
		}
		else
		{
			RequestDispatcher dispatcher=req.getRequestDispatcher("null.html");
			dispatcher.forward(req, resp);
		}
		
		
	}

}
