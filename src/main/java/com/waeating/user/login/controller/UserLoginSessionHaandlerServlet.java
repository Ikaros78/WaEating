package com.waeating.user.login.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserLoginSessionHaandlerServlet
 */
@WebServlet("/member/user/login/session")
public class UserLoginSessionHaandlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String memberType = "user";
		
		session.setAttribute("memberType", memberType);
		
		response.sendRedirect(request.getContextPath() + "/member/user/login");
		
	}

}
