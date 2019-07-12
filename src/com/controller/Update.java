package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beans.EmpDaoImpl;
import com.beans.Emp;

/**
 * Servlet implementation class Update
 */
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		ApplicationContext factory = new ClassPathXmlApplicationContext("beans.xml");
		EmpDaoImpl obj = (EmpDaoImpl) factory.getBean("empimpl");
		Emp emp = new Emp();
		emp.setName(request.getParameter("name"));
		emp.setPassword(request.getParameter("password"));
		System.out.println("PASSWORD : "+request.getParameter("password"));
		emp.setEmail(request.getParameter("email"));
		emp.setDepartment(request.getParameter("department"));
		emp.setRole(request.getParameter("role"));

		

		if (obj.updateEmp(emp)) {

			System.out.println("Successfully updated!");
			response.sendRedirect("Success.jsp");

		} else {
			System.out.println("Error occured while updation!");
			response.sendRedirect("Error.jsp");
		}
		System.out.println(emp.getName());
		
	}
	}
