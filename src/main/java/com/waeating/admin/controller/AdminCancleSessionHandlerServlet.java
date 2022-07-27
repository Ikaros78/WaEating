package com.waeating.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminCancleSessionHandlerServlet
 */
@WebServlet("/admin/cancle/session")
public class AdminCancleSessionHandlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		session.removeAttribute("ifUpdate");
		
		String path = (String) session.getAttribute("path");
		
		request.getRequestDispatcher(path).forward(request, response);
		
		
	}

}
