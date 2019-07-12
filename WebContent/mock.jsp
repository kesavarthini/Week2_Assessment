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
 
<% ArrayList<Emp> emplist = (ArrayList) request.getAttribute("emplist"); %> <%--Assigning ArrayList object containing Employee data to the local object --%>
 
<strong><a href="<%=request.getContextPath()%>/IteratorExample?type=getDetails">Show Employee Details</a></strong>
<br></br>
 
<table cellspacing="2" cellpadding="2">
 
<tr><th>Employee ID</th><th>Employee Age</th><th>Employee Name</th><th>Employee City</th></tr>
<%
// Iterating through subjectList
 
if(request.getAttribute("EmpList") != null)  // Null check for the object
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