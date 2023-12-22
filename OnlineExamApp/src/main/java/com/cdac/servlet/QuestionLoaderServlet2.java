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
@WebServlet("/QuestionLoaderServlet2")
public class QuestionLoaderServlet2 extends HttpServlet {

	int qNo;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//logic of checking the answer submitted by the user
		//can be written here also
		QuestionLoader loader = new QuestionLoader();
		List<Question> list = loader.loadQuestions();
		
		if(qNo < list.size()) {
			Question q = list.get(qNo++);
			
			HttpSession session = request.getSession();
			session.setAttribute("currentQ", q);
			
			response.sendRedirect("viewQuestion2.jsp");
		}
		else
			response.sendRedirect("score.jsp");
	}

}
