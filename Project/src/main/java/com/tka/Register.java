package com.tka;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class Register extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String department = req.getParameter("department");
		String role = req.getParameter("role");
		String pass = req.getParameter("pass");
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch204Project","root","root");
			PreparedStatement ps = c.prepareStatement("insert into employeeP(emp_name,email,department,role,password)values(?,?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, department);
			ps.setString(4, role);
			ps.setString(5, pass);
			int check = ps.executeUpdate();
			
			if(check > 0) {
				PrintWriter out = resp.getWriter();
				out.println("<h1 style = 'color:green'>"+" Employee registered successfully..."+"</h1>");
				out.println("<a href = 'Login.html' <button>Login</button>");
				
				
			}else {
				PrintWriter out = resp.getWriter();
				out.println("<h1 style = 'color:red'>"+" Failed to register the employee.."+"</h1>");
			}
			
					
			
		}catch(Exception e) {
			
		}
	}

}
