package com.beans;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;

import com.mysql.cj.exceptions.RSAException;

public class EmpDaoImpl implements EmpDao {
	Connection c;

	@Override
	public boolean checkAdmin(Emp emp) {
// TODO Auto-generated method stub
		try {

//Class.forName("com.mysql.jdbc.Driver");

			String name = emp.getName();
			String pwd = emp.getPassword();
//c = DriverManager.getConnection("jdbc:mysql://localhost:3306/assign", "root", "Sapient123");
			PreparedStatement ps = c
					.prepareStatement("select name,password from Emp where name=? and password=? and role=\"admin\"");
			ps.setString(1, name);
			ps.setString(2, pwd);
			System.out.println(name);
			System.out.println(pwd);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println("Account match");
				return true;
			}
//PreparedStatement ps = c.prepareStatement("select uname,pwd from login where uname=? and pwd=?");
			System.out.println("dao");
		} catch (SQLException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void connectDatabase() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/assign", "root", "Sapient123");
// TODO Auto-generated method stub
		} catch (ClassNotFoundException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean insert(Emp emp) {
		try {
			PreparedStatement ps1 = c.prepareStatement("insert into emp values(?,?,?,?,?)");

			ps1.setString(1, emp.getName());
			ps1.setString(2, emp.getPassword());
			ps1.setString(3, emp.getRole());
			ps1.setString(4, emp.getDepartment());
			ps1.setString(5, emp.getEmail());

			int i = ps1.executeUpdate();
			if (i > 0) {
				System.out.println("You are successfully registered...");
				return true;
			}
		} catch (Exception e2) {
			System.out.println(e2);

		}
		return false;

	}

	@Override
	public ArrayList<Emp> display() {
		ArrayList<Emp> emplist = new ArrayList<Emp>();

		try {

			Statement statement = c.createStatement();
			ResultSet resultSet = statement.executeQuery("Select * from emp");
			while (resultSet.next()) {
				Emp emp = new Emp();
				emp.setName(resultSet.getString(1));
				emp.setPassword(resultSet.getString(2));
				emp.setRole(resultSet.getString(3));
				emp.setDepartment(resultSet.getString(4));
				emp.setEmail(resultSet.getString(5));
				emplist.add(emp);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return emplist;
	}

	public Emp getEmp(String name) {
		try {
			PreparedStatement ps1 = c.prepareStatement("select * from emp where name=?");
			ps1.setString(1, name);
			ResultSet resultSet=ps1.executeQuery();
			if(resultSet.next())
			{
				Emp emp=new Emp();
				emp.setName(resultSet.getString(1));
				emp.setPassword(resultSet.getString(2));
				emp.setRole(resultSet.getString(3));
				emp.setDepartment(resultSet.getString(4));
				emp.setEmail(resultSet.getString(5));
				return emp;
			}
		}
		
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;
		}
	

	public boolean delete(String name)
	{
		try {
		
			String delete = "delete from emp where name = ?";

			PreparedStatement preparedStatement = c.prepareStatement(delete);
			preparedStatement.setString(1, name);
			boolean rs = preparedStatement.execute();
			
			if (!rs) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			return false;
		}
			
}
	@Override
	public boolean updateEmp(Emp e) {
		
		try {

			String update = "update emp set name = ?, password = ?, role = ?, department = ?, email = ? where name = ?";

			PreparedStatement preparedStatement = c.prepareStatement(update);
			preparedStatement.setString(1, e.getName());
			preparedStatement.setString(2, e.getPassword());
			preparedStatement.setString(3, e.getRole());
			preparedStatement.setString(4, e.getDepartment());
			preparedStatement.setString(5, e.getEmail());
			preparedStatement.setString(6, e.getName());

			try {
				preparedStatement.execute();
				return true;
			} catch (Exception exp) {
				System.out.println(exp);
				return false;

			}
		}

		catch (Exception exp) {
			System.out.println(exp);
			return false;

		}
		
	}
}
