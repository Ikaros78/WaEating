package com.waeating.ceo.restInfo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CeoRestInfoServlet
 */
@WebServlet("/ceo/rest_restInfo")
public class CeoRestInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		request.getRequestDispatcher("/WEB-INF/views/ceo/restInfo/ceo_rest_restInfo.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		request.getRequestDispatcher("/WEB-INF/views/ceo/restInfo/ceo_rest_restInfo.jsp").forward(request, response);
		
	}
	
	

}
