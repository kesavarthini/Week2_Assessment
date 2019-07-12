<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@page import="java.util.ArrayList"%>
 <%@page import="org.springframework.context.ApplicationContext" %>
 <%@page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
 <%@page import="com.beans.Emp" %>
 <%@page import="java.io.*" %>
  <%@page import="java.util.Locale" %>
 <%@page import="com.beans.EmpDaoImpl" %>
<%@page import="java.util.Iterator"%> 
<% Emp emp=null;
  PrintWriter out1 = new PrintWriter(System.out); %>
<h1 font="Times New Roman" align ="Center">Welcome</h1>
	<hr>
	<div class="login-page">
	<div class="form">
    <form class="register-form" action="" method="post">
      <input type="text" placeholder="Name" name="name" />
       <input type="submit" name="b1" value="Search"><br><br><br>
      </form>
    
      <%
	if ("POST".equalsIgnoreCase(request.getMethod())) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("beans.xml");
		EmpDaoImpl obj = (EmpDaoImpl) factory.getBean("emp");
		emp = obj.getEmp(request.getParameter("name"));
		%>
				<table border="1">
		<tr>
			<th>User name</th>
			<th>Password</th>
			<th>Role</th>
			<th>Department</th>
			<th>Email</th>
		</tr>
	
				 <tr>
				    <td> <% out.println(emp.getName()); %></td>
				    <td> <% out.println(emp.getPassword()); %></td>
				    <td> <% out.println(emp.getRole()); %></td>
				    <td> <% out.println(emp.getDepartment()); %></td>
				    <td> <% out.println(emp.getEmail()); %></td>				    
				  </tr>
	</table>
	<br><br>
      <form action = "delete" method="post">
      <input type="hidden" name="name" value="<%=request.getParameter("name")%>" />
      <input type="submit" value="delete">
      </form>
      <% 
		
	  	
	} else {
	  	System.out.println("Failure");
	}
	%>
      
</body>
</html>