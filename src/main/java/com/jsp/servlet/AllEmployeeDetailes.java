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
@WebServlet("/allEmployeeDetailes")
public class AllEmployeeDetailes extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EmployeeDao dao=new EmplyeeDaoimp();
		List<Employee> employees=dao.getAllEmployee();
//		System.out.println(employees);
//		PrintWriter writer=resp.getWriter();
//		writer.println(employees);
		HttpSession session=req.getSession();
		session.setAttribute("ListOfEmployees",employees);
		RequestDispatcher dispatcher=req.getRequestDispatcher("AllEmployeeDetailes.jsp");
		dispatcher.forward(req, resp);
		
		
		
	}

}
