package com.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.Dao.EmployeeDao;
import com.jsp.Dao.EmplyeeDaoimp;
import com.jsp.model.Employee;
@WebServlet("/getEmployeeDetailesBySalOrDeptno")
public class AllEmployeeDetailesBasedOnSalOrDeptno extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int deptno=Integer.parseInt(req.getParameter("deptno"));
		EmployeeDao dao=new EmplyeeDaoimp();
		List<Employee> salOrDeptno=dao.getEmployeeDetailesBySalOrDeptno(deptno);
		HttpSession session=req.getSession();
		if(salOrDeptno!=null)
		{
			session.setAttribute("ListOfEmployees", salOrDeptno);
			RequestDispatcher dispatcher=req.getRequestDispatcher("AllEmployeeDetailes.jsp");
			dispatcher.forward(req, resp);
			
		}
		else
		{
			RequestDispatcher dispatcher=req.getRequestDispatcher("null.html");
			dispatcher.forward(req, resp);
		}
		

	}

}
