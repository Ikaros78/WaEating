package com.waeating.admin.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NoticeSelectListServlet
 */
@WebServlet("/admin/notice/list")
public class NoticeSelectListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "";
		path= "/WEB-INF/views/admin/notice/noticeList.jsp";
		
		request.getRequestDispatcher(path).forward(request, response);
	}
	

}
