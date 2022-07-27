package com.waeating.admin.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminMemberSelectDetailSessionHandlerServlet
 */
@WebServlet("/admin/member/detail/session")
public class AdminMemberSelectDetailSessionHandlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memberId = request.getParameter("memberId");
		
		HttpSession session = request.getSession();
		
		session.setAttribute("memberId", memberId);
		
		response.sendRedirect(request.getContextPath() + "/admin/member/detail");
	}

}
