package com.waeating.admin.review.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminReviewSelectDetailSessionHandlerServlet
 */
@WebServlet("/admin/review/detail/session")
public class AdminReviewSelectDetailSessionHandlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String reviewNo = request.getParameter("reviewNo");
		
		request.getSession().setAttribute("reviewNo",reviewNo);
		
		response.sendRedirect(request.getContextPath() + "/admin/review/detail");
	}

}
