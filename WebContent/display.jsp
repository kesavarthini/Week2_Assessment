<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@page import="java.util.ArrayList"%>
 <%@page import="org.springframework.context.ApplicationContext" %>
 <%@page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
 <%@page import="com.beans.Emp" %>
 <%@page import="com.beans.EmpDaoImpl" %>
<%@page import="java.util.Iterator"%> 
 
<% ApplicationContext factory = new ClassPathXmlApplicationContext("beans.xml");
EmpDaoImpl impl=(EmpDaoImpl)factory.getBean("emp");
ArrayList<Emp> emplist= impl.display();

%> <%--Assigning ArrayList object containing Employee data to the local object --%>
 

<br></br>
 
<table border="1" cellspacing="2" cellpadding="2">
 
<tr><th>Employee Name</th><th>Employee Password</th><th>Employee Role</th><th>Employee Department</th><th>Employee Email</th></tr>
<%
// Iterating through subjectList
 
if(emplist!= null)  // Null check for the object
{
 Iterator<Emp> iterator = emplist.iterator();  // Iterator interface
 
 while(iterator.hasNext())  // iterate through all the data until the last record
 {
 Emp empDetails = iterator.next(); //assign individual employee record to the employee class object
 %>
 <tr><td><%=empDetails.getName()%></td>
 <td><%=empDetails.getPassword()%></td>
 <td><%=empDetails.getRole()%></td>
 <td><%=empDetails.getDepartment()%></td>
 <td><%=empDetails.getEmail()%></td>
 </tr>
 <%
 }
}
%>
</table>
 
</body>
</html>