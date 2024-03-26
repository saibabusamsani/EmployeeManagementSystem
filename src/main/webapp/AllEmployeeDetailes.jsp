<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.jsp.model.Employee" %>
    <%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<style>
body{
background-color: black;

}
table{
margin-top: 3vw;
background-color: blue;
color:white;

}

.ad{
	margin-top:2vw;
}
.add{
		height: 2vw;
		width: 7vw;
		font-size: 1.2vw;
		font-weight: bold;
		background-color: white;
		color: purple;
		border-radius: 10%;
		transition: all 0.5s;
		
	}
	.add:hover
	{
		background-color: purple;
		color: white;
	}
	.inpt1{
		width: 12vw;
		height: 1.5vw;
		
	}
	
</style>
<body>
<%
          List<Employee> employees=(List<Employee>)session.getAttribute("ListOfEmployees");
%>
<center>
<h2 style="color:red">Employee Detailes</h2>

<form action="getEmployeeDetailesBySalOrDeptno" method="post">
		<input type="text" placeholder="search by sal or deptno" name="deptno" class="inpt1">
		<input type="submit" value="submit" class="add">
						
</form>

<form action="Registration.html" class="ad" >
		<input type="submit" value="add new" class="add" >
</form>


<table border="1" cellspacing="0" cellpadding="8" >
<tr>
<th>Employee_id</th>
<th>Employee_name</th>
<th>Employee_sal</th>
<th>Employee_deptno</th>

</tr>

<%for(Employee emp:employees)
	{%>
	<tr>
	<td><%=emp.getEmpId() %></td>
	<td><%=emp.getEmpName() %></td>
	<td><%=emp.getEmpSalary() %></td>
	<td><%=emp.getEmpdeptno() %></td>
	<td>
	<form action="getEmployeeById" method="post">
	<input value=<%=emp.getEmpId() %> hidden="true" name="empid">
	<input type="submit" value="update" class="add">
	</form>
	</td>
	<td>
	<form action="delete">
	<input value=<%=emp.getEmpId() %> name="id" hidden="true">
	<input type="submit" value="delete" class="add">
	</form>
	</td>
	
	</tr>
	 <%}%>

</table>
</center>
</body>
</html>