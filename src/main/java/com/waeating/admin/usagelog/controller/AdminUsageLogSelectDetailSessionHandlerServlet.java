package com.waeating.admin.usagelog.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminUsageLogSelectDetailSessionHandlerServlet
 */
@WebServlet("/admin/usageLog/detail/session")
public class AdminUsageLogSelectDetailSessionHandlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String recordNo = request.getParameter("recordNo");
		
		request.getSession().setAttribute("recordNo", recordNo);
		
		response.sendRedirect(request.getContextPath() + "/admin/usageLog/detail");
	}

}
