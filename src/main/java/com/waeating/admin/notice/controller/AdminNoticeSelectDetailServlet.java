package com.waeating.admin.notice.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.waeating.admin.notice.service.AdminNoticeService;
import com.waeating.notice.model.dto.NoticeDTO;

/**
 * Servlet implementation class AdminNoticeSelectDetailServlet
 */
@WebServlet("/admin/notice/detail")
public class AdminNoticeSelectDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String noticeNo = (String) request.getSession().getAttribute("noticeNo");
		
		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("noticeNo", noticeNo);
		
		AdminNoticeService noticeService = new AdminNoticeService();
		NoticeDTO notice = noticeService.selectNoticeDetail(searchMap);
		
		String path = "";
		
		if(notice != null) {
			path = "/WEB-INF/views/admin/notice/noticeDetail.jsp";
			
			request.getSession().setAttribute("path", path);
			request.getSession().setAttribute("notice", notice);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "공지사항 정보 조회 실패");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
		
	}

}
