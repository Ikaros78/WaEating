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
 * Servlet implementation class CeoRestNoticeDetail
 */
@WebServlet("/ceo/rest_notice_detail")
public class CeoRestNoticeDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		
		ComNoticeDTO comNotice = new ComNoticeService().selectOneNotice(noticeNo);
		
		System.out.println("출력 " + comNotice);
		String path = "";
		
		if(comNotice != null) {
			path = "/WEB-INF/views/ceo/notice/ceo_rest_notice_detail.jsp";
			request.setAttribute("selectOneNotice", comNotice);
		} else {
			path = "/WEB-INF/views/common.errorPage.jsp";
			request.setAttribute("message", "공지 조회 실패");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
