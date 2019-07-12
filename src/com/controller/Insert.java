package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beans.Emp;
import com.beans.EmpDaoImpl;

/**
 * Servlet implementation class Insert
 */
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insert() {
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
		EmpDaoImpl impl=(EmpDaoImpl)factory.getBean("emp");
		Emp emp =new Emp();
		emp.setName(request.getParameter("username"));
		emp.setPassword(request.getParameter("password"));
		emp.setRole(request.getParameter("role"));
		emp.setDepartment(request.getParameter("department"));
		emp.setEmail(request.getParameter("email"));
		
		if(impl.insert(emp)==true)
		{
			System.out.println("Insertion successful");
			response.sendRedirect("functionality.html");
		}
		else {
			System.out.println("Failed");
		}

}
	}


