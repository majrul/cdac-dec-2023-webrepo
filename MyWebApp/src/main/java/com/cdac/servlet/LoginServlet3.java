package com.cdac.servlet;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login3.cdac")
public class LoginServlet3 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		
		if(email.equals("majrul@gmail.com") && pwd.equals("123")) {
			String rememberMe = request.getParameter("rememberMe");
			if(rememberMe != null && rememberMe.equals("yes")) {
				String data = Base64.getEncoder().encode((email + ":" + pwd).getBytes()).toString();
				Cookie cookie = new Cookie("loginData", data);
				cookie.setMaxAge(60*60*24*30); //seconds
				response.addCookie(cookie);
			}
			response.sendRedirect("welcome.html");
		}
		else
			response.sendRedirect("login.html");
	}

}
