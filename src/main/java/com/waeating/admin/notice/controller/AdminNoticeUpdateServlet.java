package com.waeating.admin.notice.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.waeating.admin.notice.service.AdminNoticeService;
import com.waeating.member.model.dto.MemberDTO;

/**
 * Servlet implementation class AdminNoticeUpdateServlet
 */
@WebServlet("/admin/notice/update")
public class AdminNoticeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		MemberDTO admin = (MemberDTO) request.getSession().getAttribute("loginMember"); 
		String noticeNo = (String) request.getSession().getAttribute("noticeNo");
		String id = admin.getId();
		String title = request.getParameter("updateTitle");
		String content = request.getParameter("updateContent");
		String date = new SimpleDateFormat("yy-MM-dd").format(new java.sql.Date(System.currentTimeMillis()));		
		
		Map<String, String> updateNoticeMap = new HashMap<>();
		updateNoticeMap.put("noticeNo", noticeNo);
		updateNoticeMap.put("id", id);
		updateNoticeMap.put("title", title);
		updateNoticeMap.put("content", content);
		updateNoticeMap.put("date", date);
		
		AdminNoticeService noticeService = new AdminNoticeService();
		
		if(title.length() == 0 && content.length() == 0) {
			response.sendRedirect(request.getContextPath() + "/admin/cancle/session");
		}else {
			
			int noticeResult = noticeService.updateNotice(updateNoticeMap);
			
			if(noticeResult > 0) {
				request.getSession().removeAttribute("ifUpdate");
				response.sendRedirect(request.getContextPath() + "/admin/notice/detail");
			} else {
				String path = "WEB-INF/views/common/failed.jsp";
				request.setAttribute("message", "공지사항 정보 수정 실패!");
				request.getRequestDispatcher(path).forward(request, response);
			}
			
		}
		
	}

}
