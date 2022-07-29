package com.waeating.admin.company.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminCompanySelectDetailSessionHandlerServlet
 */
@WebServlet("/admin/company/detail/session")
public class AdminCompanySelectDetailSessionHandlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String comNo = request.getParameter("comNo");
		
		HttpSession session = request.getSession();
		
		session.setAttribute("comNo", comNo);
		
		response.sendRedirect(request.getContextPath() + "/admin/company/detail");
	}

}
