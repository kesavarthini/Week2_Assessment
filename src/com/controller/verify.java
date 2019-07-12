package com.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beans.Emp;
import com.beans.EmpDao;
import com.beans.EmpDaoImpl;
import java.util.Scanner;


public class verify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public verify() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("beans.xml");
		EmpDaoImpl impl=(EmpDaoImpl)factory.getBean("emp");
		Emp emp =new Emp();
		emp.setName(request.getParameter("username"));
		emp.setPassword(request.getParameter("password"));
		
		if(impl.checkAdmin(emp)==true)
		{
			response.sendRedirect("functionality.html");  
		}
		else {
			System.out.println("Unauthorized access");
		}

}}
