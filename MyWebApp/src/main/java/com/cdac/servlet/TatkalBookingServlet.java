package com.cdac.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TatkalBookingServlet
 */
//@WebServlet("/TatkalBookingServlet")
public class TatkalBookingServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		LocalTime time = LocalTime.now();
		
		ServletConfig cfg = getServletConfig();
		int startTime = Integer.parseInt(cfg.getInitParameter("startTime"));
		int endTime = Integer.parseInt(cfg.getInitParameter("endTime"));
		
		//if(time.getHour() >= 8 && time.getHour() < 12)
		if(time.getHour() >= startTime && time.getHour() < endTime)
			out.write("<h1>you are on time, please proceed with the booking!</h1>");
		else
			out.write("<h1>you are late, please come tomorrow @10 am to book the ticket</h1>");
	
		ServletContext ctx = getServletContext();
		String copyright = ctx.getInitParameter("copyright");
	
		out.write("<h2>" + copyright + "</h1>");
	}

}
