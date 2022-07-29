package com.waeating.ceo.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.waeating.ceo.notice.model.dto.ComNoticeDTO;
import com.waeating.ceo.notice.model.service.ComNoticeService;

/**
 * Servlet implementation class CeoRestNoticeDetailModifyUpdateServlet
 */
@WebServlet("/ceo/rest_notice_detail_modify_update")
public class CeoRestNoticeDetailModifyUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		String noticeTitle = request.getParameter("noticeTitle");
		String noticeContent = request.getParameter("noticeContent");
		
		ComNoticeDTO comNotice = new ComNoticeDTO();
		comNotice.setNoticeTitle(noticeTitle);
		comNotice.setNoticeContent(noticeContent);
		
//		int result = new ComNoticeService().updateNotice(comNotice);
		
//		String path = "";
//		
//		if(result > 0) {
//			path = "/WEB-INF/views/ceo/notice/ceo_rest_notice_detail_modify.jsp";
////			request.setAttribute("updateNotice", comNotice);
//		} else {
//			path = "/WEB-INF/views/common.errorPage.jsp";
//			request.setAttribute("message", "공지 수정 실패");
//		}
		
//		request.getRequestDispatcher(path).forward(request, response);
	}


}
