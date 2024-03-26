package com.jsp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.Dao.EmplyeeDaoimp;
import com.jsp.model.Employee;
@WebServlet("/getEmployeeById")
public class GetEmployeesByID extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int empid=Integer.parseInt(req.getParameter("empid"));
		System.out.println(empid);
		EmplyeeDaoimp dao=new EmplyeeDaoimp();
		Employee employee=dao.getEmployeeById(empid);
		HttpSession session=req.getSession();
		if(employee!=null)
		{
			session.setAttribute("employeeDetailes", employee);
			RequestDispatcher rd=req.getRequestDispatcher("UpdateDetailes.jsp");
			rd.forward(req, resp);
		}
		else
		{
			RequestDispatcher dispatcher=req.getRequestDispatcher("null.html");
			dispatcher.forward(req, resp);
		}
		
	}

}
