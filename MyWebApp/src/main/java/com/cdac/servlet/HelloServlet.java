package com.cdac.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
//@WebServlet("/hello.cdac") //url pattern or servlet mapping
//If we don't use @WebServlet annotation, then we will have to
//do the Servlet entry in the web.xml file
public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.write("<html><body>");
		out.write("<h1>Welcome to Servlets</h1>");
		LocalDate date = LocalDate.now();
		out.write("<h2>Today's Date is " + date + "</h1>");
		out.write("</body></html>");
	}

}
