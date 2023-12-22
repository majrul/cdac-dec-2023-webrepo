package com.cdac.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.cdac")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//read the form data
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		
		//now we will go and check in the database is this data valid or invalid
		//jdbc code is missing right now
		//for the time being, let's hardcode and complete the flow 
		if(email.equals("majrul@gmail.com") && pwd.equals("123"))
			response.sendRedirect("welcome.html");
		else
			response.sendRedirect("login.html");
	}

}
