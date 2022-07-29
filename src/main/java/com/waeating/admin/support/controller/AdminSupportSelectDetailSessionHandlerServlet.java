package com.waeating.admin.support.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminSupportSelectDetailSessionHandlerServlet
 */
@WebServlet("/admin/support/detail/session")
public class AdminSupportSelectDetailSessionHandlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String reportNo = request.getParameter("reportNo");
		
		HttpSession session = request.getSession();
		
		session.setAttribute("reportNo", reportNo);
		
		response.sendRedirect(request.getContextPath() + "/admin/support/detail");
	}

}
