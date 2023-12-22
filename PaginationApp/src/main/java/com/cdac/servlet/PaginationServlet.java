package com.cdac.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cdac.jdbc.Product;
import com.cdac.jdbc.ProductDataLoader;

/**
 * Servlet implementation class PaginationServlet
 */
@WebServlet("/pagination.cdac")
public class PaginationServlet extends HttpServlet {
	
	int offset;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String move = request.getParameter("move");
		if(move != null) {
			if(move.equals("next"))
				offset += 5;
			else if(move.equals("prev"))
				offset -= 5;
		}
		ProductDataLoader loader = new ProductDataLoader();
		List<Product> list = loader.loadProducts(offset);

		HttpSession session = request.getSession();
		session.setAttribute("listOfProducts", list);
		
		response.sendRedirect("pagination4.jsp");
	}

}
