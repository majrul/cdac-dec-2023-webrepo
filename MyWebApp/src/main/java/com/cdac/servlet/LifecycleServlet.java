package com.cdac.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifecycleServlet
 */
@WebServlet(urlPatterns = "/LifecycleServlet", loadOnStartup = 1)
public class LifecycleServlet extends HttpServlet {

	public void init() {
		System.out.println("init of LifecycleServlet called..");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet called..");
	}

	public void destroy() {
		System.out.println("destroy called..");
	}
}
