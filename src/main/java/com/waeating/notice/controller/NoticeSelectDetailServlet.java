package com.waeating.notice.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.waeating.admin.notice.service.AdminNoticeService;
import com.waeating.notice.model.dto.NoticeAttachDTO;
import com.waeating.notice.model.dto.NoticeDTO;
import com.waeating.notice.model.service.NoticeService;

/**
 * Servlet implementation class NoticeSelectDetailServlet
 */
@WebServlet("/notice/detail")
public class NoticeSelectDetailServlet extends HttpServlet {
       
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int no = Integer.parseInt(request.getParameter("no"));
		
		System.out.println("no " + no);
		Map<String, String> searchMap = new HashMap<>();	
		searchMap.put("noticeNo", request.getParameter("no"));
		AdminNoticeService noticeService = new AdminNoticeService();
		NoticeDTO noticeDetail = noticeService.selectNoticeDetail(searchMap);
		System.out.println("noticeDetail : " + noticeDetail);
		String path = "";
		if(noticeDetail != null) {
			path = "/WEB-INF/views/mainNotice/notice_detail.jsp";
			List<NoticeAttachDTO> attachList = noticeService.selectNoticeAttachList(searchMap);
			System.out.println("attachList : " + attachList);
			
			if(attachList != null) {
				request.setAttribute("attachList", attachList);
			}
			request.setAttribute("noticeDetail", noticeDetail);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "공지사항 상세보기에 실패하셨습니다");
		}
		 request.getRequestDispatcher(path).forward(request, response);
	}

}
