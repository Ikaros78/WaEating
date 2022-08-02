package com.waeating.admin.notice.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class AdminNoticeInsertServlet
 */
@WebServlet("/admin/notice/insert")
public class AdminNoticeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String path = "/WEB-INF/views/admin/notice/noticeInsert.jsp";
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		MemberDTO admin = (MemberDTO) request.getSession().getAttribute("loginMember");
		
		String id = admin.getId();
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String date = new SimpleDateFormat("yy-MM-dd").format(new java.sql.Date(System.currentTimeMillis()));
		
		Map<String, String> insertNoticeMap = new HashMap<>();
		insertNoticeMap.put("id", id);
		insertNoticeMap.put("title", title);
		insertNoticeMap.put("content", content);
		insertNoticeMap.put("date", date);
		
		AdminNoticeService noticeService = new AdminNoticeService();
		
		if(title.length() == 0 || content.length() == 0) {
			
			response.setCharacterEncoding("utf-8");
			
			response.setContentType("text/html; charset=UTF-8");
			
			PrintWriter out = response.getWriter();
			out.println("<script>alert('제목과 내용을 다시 입력하세요.'); location.href='list';</script>");
			
			out.flush();
			out.close();
		} else {
			
			int result = noticeService.insertNotice(insertNoticeMap);
			
			if(result > 0) {
				response.sendRedirect(request.getContextPath() + "/admin/notice/list");
			} else {
				String path = "WEB-INF/views/common/failed.jsp";
				request.setAttribute("message", "공지사항 정보 등록 실패!");
				request.getRequestDispatcher(path).forward(request, response);
			}
		}
	}

}
