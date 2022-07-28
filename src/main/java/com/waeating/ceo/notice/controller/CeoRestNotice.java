package com.waeating.ceo.notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.waeating.ceo.notice.model.dto.ComNoticeDTO;
import com.waeating.ceo.notice.model.service.ComNoticeService;

/**
 * Servlet implementation class CeoRestNotice
 */
@WebServlet("/ceo/rest_notice")
public class CeoRestNotice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		HttpSession session = request.getSession();
//		
//		request.getRequestDispatcher("/WEB-INF/views/ceo/notice/ceo_rest_notice.jsp").forward(request, response);
		
		ComNoticeService noticeService = new ComNoticeService();
		List<ComNoticeDTO> comNoticeList = noticeService.selectAllNotice();
		
		System.out.println(comNoticeList);
		
		String path = "";
		if(comNoticeList != null) {
			path = "/WEB-INF/views/ceo/notice/ceo_rest_notice.jsp";
			request.setAttribute("selectAllNotice", comNoticeList);
		} else {
			path = "/WEB-INF/views/common.errorPage.jsp";
			request.setAttribute("message", "공지 조회 실패");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}


}
