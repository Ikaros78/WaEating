package com.waeating.ceo.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.waeating.ceo.notice.model.service.ComNoticeService;

/**
 * Servlet implementation class CeoRestNoticeDetailDeleteServlet
 */
@WebServlet("/ceo/rest_notice_detail_delete")
public class CeoRestNoticeDetailDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		
		System.out.println(noticeNo);
		
		ComNoticeService comNoticeService = new ComNoticeService();
		int result = comNoticeService.deleteNotice(noticeNo);
		
		System.out.println("result : " + result);
		
		String path = "";
		
//		if(result > 0) {
//			path = "/WEB-INF/views/ceo/notice/ceo_rest_notice.jsp";
//			
//		} else {
//			path = "/WEB-INF/views/common.errorPage.jsp";
//			request.setAttribute("message", "공지 삭제 실패");
//		}
//		request.getRequestDispatcher(path).forward(request, response);
		
		if(result > 0) {
			path = "rest_notice";
			response.sendRedirect(path);
			
		} else {
			path = "/WEB-INF/views/common.errorPage.jsp";
			request.setAttribute("message", "공지 삭제 실패");
			request.getRequestDispatcher(path).forward(request, response);
		}
		
	}


}
