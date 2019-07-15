<%@page import="com.beans.EmpDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.beans.EmpDao"%>
<%@page import="com.beans.EmpDaoImpl"%>
<%@page import="com.beans.Emp"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page
	import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
</head>
<body>
	<h1>Update Employee</h1>

	<form action="" method="post">
		<input type="text" name="username" placeholder="name" /> <input
			type="submit" class="login__submit" value="Search" />
	</form>
	<br>
	<br>
	<%!Emp emp = null;%>
	<%
		if ("POST".equalsIgnoreCase(request.getMethod())) {
			ApplicationContext factory = new ClassPathXmlApplicationContext("beans.xml");
			EmpDaoImpl obj = (EmpDaoImpl) factory.getBean("emp");
			emp = obj.getEmp(request.getParameter("username"));
	%>
	<br>
	<br>
	<form action="Update" method="post">
		USERNAME : <input type="text" name="username" placeholder="Username"
			value="<%=emp.getName()%>" readonly /> <br> <br> PASSWORD
		: <input type="text" name="password" placeholder="Password"
			value="<%=emp.getPassword()%>" /> <br> <br> EMAIL : <input
			type="text" name="email" placeholder="Email"
			value="<%=emp.getEmail()%>" /> <br> <br> DEPARTMENT : <input
			type="text" name="department" placeholder="Department"
			value="<%=emp.getDepartment()%>" /> <br> <br> ROLE : <input
			type="text" name="role" placeholder="Role"
			value="<%=emp.getRole()%>" /> <br> <br> <input
			type="submit" value="Update" /> <br> <br> <input
			type="reset" value="Reset" />
	</form>

	<%
		} else {
			System.out.println("Failure");
		}
	%>

</body>
</html>