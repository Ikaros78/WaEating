package com.ohgiraffers.waeating.admin.review.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReviewSelectListServlet
 */
@WebServlet("/admin/review/list")
public class ReviewSelectListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String path = "";
		path= "/WEB-INF/views/admin/review/reviewList.jsp";		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
