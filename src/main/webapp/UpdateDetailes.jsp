<%@page import="com.jsp.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
		<style>
			body{
			height:100vh;
			display: flex;
			align-items: center;
			justify-content: center;
			background-color: green;
	

			} 
			input{
			background-color:black;
			color: white;
			font-weight:bold;
			transform: scale(2);
			border-radius: 10%;
			}
			form{
			display: flex;
			align-items: center;
			justify-content: center;
			flex-direction: column;
			row-gap: 2vw;
			
			}
			h1{
			font-size:4vw;
			margin-bottom: 5vw;
			font-style: italic;
			background:linear-gradient(75deg,pink,purple,blue,skyblue,purple,pink);
			 animation: an 1s infinite;
			 color: transparent;
			 -webkit-background-clip: text;
			}
		 @keyframes an
		 {
			        from{
			            background-size: 1500px;
			            background-position: 1500px;
			        }
			        to{
			            background-position: 0px;
			        }
    	}
    	input{
    	outline: none;
    	border: none;
    	
    	}
    	input:focus{
    	background-color: pink;
    	color:blue;
    	border:2px black solid;
    	}
    	.submit{
    	background-color: red;
    	color:white;
    	transition:all 0.5s;
    	}
    	.submit:hover{
    		font-size: 1vw;
    		background-color: white;
    		color:red;
    	}
			
	</style>
<body>
<%
		Employee emp=(Employee) session.getAttribute("employeeDetailes");
%>
	<center>
	<h1>Update Detailes</h1>
		<form action="update">
			<input value=<%=emp.getEmpId() %> name="empId" hidden="true">
			<input value=<%=emp.getEmpName() %> name="empName">
			
			<input value=<%=emp.getEmpSalary() %> name="empSalary">
			
			<input value=<%=emp.getEmpdeptno() %> name="empDeptno">
			
			<input type="submit" value="submit" class=submit>
		</form>
	</center>
</body>
</html>