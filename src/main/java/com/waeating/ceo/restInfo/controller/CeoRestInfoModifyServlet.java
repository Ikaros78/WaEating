package com.waeating.ceo.restInfo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CeoRestInfoModifyServlet
 */
@WebServlet("/ceo/rest_restInfo_modify")
public class CeoRestInfoModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getAttribute("comInfo");
		request.getAttribute("comMenuList");
	
		request.getRequestDispatcher("/WEB-INF/views/ceo/restInfo/ceo_rest_restInfo_modify.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

}
