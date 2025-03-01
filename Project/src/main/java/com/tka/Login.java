package com.tka;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email1 = req.getParameter("email1");
		String password1 = req.getParameter("password1");
		
		resp.setContentType("text/html");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch204Project","root","root");
			PreparedStatement ps = c.prepareStatement("select * from employeeP where email = ? AND password = ?");
			ps.setString(1, email1);
			ps.setString(2, password1);
			
			
			ResultSet rs1 = ps.executeQuery();
			
			if(rs1.next()) {
				PrintWriter out = resp.getWriter();
				out.println("<h1 style = 'color: green'>"+"Login Sucessfully..!"+"</h1> <br><br>");
				
				req.setAttribute("emp_name",rs1.getString(1));
				req.setAttribute("email",rs1.getString(2));
				req.setAttribute("department",rs1.getString(3));
				req.setAttribute("role",rs1.getString(4));
				RequestDispatcher d = req.getRequestDispatcher("/Profile.jsp");
				d.forward(req, resp);			
				
			}else {
				PrintWriter out = resp.getWriter();
				out.println("<h1 style = 'color: red'>"+"Invalid User..."+"</h1> <br><br>");
				out.print("<h1 style = 'color: black'>"+"Register Again..."+"</h1>");
				RequestDispatcher d = req.getRequestDispatcher("/Register.html");
				d.include(req, resp);
			}
			c.close();
			
		}catch(Exception e) {
			
		}
		
	}

}
