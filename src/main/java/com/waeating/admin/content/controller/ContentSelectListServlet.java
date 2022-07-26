package com.waeating.admin.content.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContentSelectListServlet
 */
@WebServlet("/admin/content/list")
public class ContentSelectListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "";
		path= "/WEB-INF/views/admin/content/contentList.jsp";
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
