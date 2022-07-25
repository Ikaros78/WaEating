package com.waeating.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminLoginSessionHandlerServlet
 */
@WebServlet("/admin/login/session")
public class AdminLoginSessionHandlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberType = "admin";
		
		HttpSession session = request.getSession();
		session.setAttribute("memberType", memberType);
		
		System.out.println(request.getContextPath());
		
		response.sendRedirect(request.getContextPath() + "/admin/login");
	}


}
