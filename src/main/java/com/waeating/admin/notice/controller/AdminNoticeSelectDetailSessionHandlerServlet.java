package com.waeating.admin.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminNoticeSelectDetailSessionHandlerServlet
 */
@WebServlet("/admin/notice/detail/session")
public class AdminNoticeSelectDetailSessionHandlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String noticeNo = request.getParameter("noticeNo");
		
		request.getSession().setAttribute("noticeNo",noticeNo);
		
		response.sendRedirect(request.getContextPath() + "/admin/notice/detail");
	}

}
