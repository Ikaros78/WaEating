package com.waeating.admin.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.waeating.admin.notice.service.AdminNoticeService;

/**
 * Servlet implementation class AdminNoticeDeleteServlet
 */
@WebServlet("/admin/notice/delete")
public class AdminNoticeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String noticeNo = (String) request.getSession().getAttribute("noticeNo");
		
		AdminNoticeService noticeService = new AdminNoticeService();
		
		int result = noticeService.deleteNotice(noticeNo);
		
		if(result > 0) {
			request.getSession().removeAttribute("ifUpdate");
			response.sendRedirect(request.getContextPath() + "/admin/notice/list");
		}else {
			String path = "WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "공지사항 삭제 실패!");
			request.getRequestDispatcher(path).forward(request, response);
		}
	}

}
