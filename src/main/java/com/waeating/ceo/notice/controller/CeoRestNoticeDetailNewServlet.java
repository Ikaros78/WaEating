package com.waeating.ceo.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.waeating.ceo.notice.model.dto.ComNoticeDTO;
import com.waeating.ceo.notice.model.service.ComNoticeService;

/**
 * Servlet implementation class CeoRestNoticeDetailNewServlet
 */
@WebServlet("/ceo/rest_notice_detail_new")
public class CeoRestNoticeDetailNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		request.getRequestDispatcher("/WEB-INF/views/ceo/notice/ceo_rest_notice_detail_new.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String noticeTitle = request.getParameter("noticeTitle");
		String noticeContent = request.getParameter("noticeContent");
		
		ComNoticeDTO comNotice = new ComNoticeDTO();
		comNotice.setNoticeTitle(noticeTitle);
		comNotice.setNoticeContent(noticeContent);
		
		System.out.println("insert : " + comNotice);
		 
		ComNoticeService comNoticeService = new ComNoticeService();
		int result = comNoticeService.insertComNotice(comNotice);
		
		String path = "";
		
		if(result > 0) {
			response.sendRedirect(request.getContextPath() + "/ceo/rest_notice");
		
		} else {
			path = "/WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("message", "공지 등록에 실패하셨습니다.");
			request.getRequestDispatcher(path).forward(request, response);
		}
		
		
		
	}
	
	

}
