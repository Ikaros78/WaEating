package com.waeating.ceo.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.waeating.ceo.notice.model.service.ComNoticeService;
import com.waeating.com.model.dto.ComNoticeDTO;

/**
 * Servlet implementation class CeoRestNoticeDetailModifyServlet
 */
@WebServlet("/ceo/rest_notice_detail_modify")
public class CeoRestNoticeDetailModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		
		ComNoticeDTO comNotice = new ComNoticeService().selectOneNotice(noticeNo);
		
		String path = "";
		
		if(comNotice != null) {
			path = "/WEB-INF/views/ceo/notice/ceo_rest_notice_detail_modify.jsp";
			request.setAttribute("selectOneNotice", comNotice);
		} else {
			path = "/WEB-INF/views/common.errorPage.jsp";
			request.setAttribute("message", "공지 조회 실패");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		String noticeTitle = request.getParameter("noticeTitle");
		String noticeContent = request.getParameter("noticeContent");
		
		ComNoticeDTO comNotice = new ComNoticeDTO();
		comNotice.setNoticeNo(noticeNo);
		comNotice.setNoticeTitle(noticeTitle);
		comNotice.setNoticeContent(noticeContent);
		
		System.out.println(comNotice);
		
		ComNoticeService comNoticeService = new ComNoticeService();
		int result = comNoticeService.updateNotice(comNotice);
		
		System.out.println(result);
		
		String path = "";
		
		if(result > 0) {
			path = "rest_notice";
			response.sendRedirect(path);
			
		} else {
			
			path = "/WEB-INF/views/common.errorPage.jsp";
			request.setAttribute("message", "공지 수정 실패");
			request.getRequestDispatcher(path).forward(request, response);
		}
		
			
			

	}


	
	

}
