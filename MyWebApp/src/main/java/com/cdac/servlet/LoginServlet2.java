package com.cdac.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login2.cdac")
public class LoginServlet2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");

		//jdbc code
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdac","root","passw0rd");
			String sql = "select count(id) from users where email = ? and password = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, email);
			stmt.setString(2, pwd);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				int count = rs.getInt(1);
				if(count == 1)
					response.sendRedirect("welcome.html");
				else
					response.sendRedirect("login.html");
			}
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}
	}

}
