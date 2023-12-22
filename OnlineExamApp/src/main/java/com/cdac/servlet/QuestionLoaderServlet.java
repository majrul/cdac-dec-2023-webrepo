package com.cdac.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cdac.jdbc.Question;
import com.cdac.jdbc.QuestionLoader;

/**
 * Servlet implementation class QuestionLoaderServlet
 */
@WebServlet("/QuestionLoaderServlet")
public class QuestionLoaderServlet extends HttpServlet {

	int qNo;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QuestionLoader loader = new QuestionLoader();
		List<Question> list = loader.loadQuestions();
		
		Question q = list.get(qNo++);
		
		HttpSession session = request.getSession();
		session.setAttribute("currentQ", q);
		
		response.sendRedirect("viewQuestion.jsp");
	}

}
