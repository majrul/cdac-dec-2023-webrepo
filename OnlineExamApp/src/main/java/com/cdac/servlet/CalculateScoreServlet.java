package com.cdac.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cdac.jdbc.Question;

/**
 * Servlet implementation class CalculateScoreServlet
 */
@WebServlet("/CalculateScoreServlet")
public class CalculateScoreServlet extends HttpServlet {

	int score = 0;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Question q = (Question) session.getAttribute("currentQ");

		if(request.getParameter("op") != null) {
			int op = Integer.parseInt(request.getParameter("op"));
			if(q.getRightAnswer() == op) {
				score ++;
				session.setAttribute("score", score);
			}
		}
		
		response.sendRedirect("QuestionLoaderServlet2");
		
	}

}
