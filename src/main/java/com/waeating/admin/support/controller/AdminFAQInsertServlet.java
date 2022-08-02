package com.waeating.admin.support.controller;

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

import com.waeating.admin.support.service.AdminSupportService;
import com.waeating.member.model.dto.MemberDTO;

/**
 * Servlet implementation class AdminFAQInsertServlet
 */
@WebServlet("/admin/faq/insert")
public class AdminFAQInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/admin/support/supportFAQInsert.jsp";
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDTO admin = (MemberDTO) request.getSession().getAttribute("loginMember");
		
		String id = admin.getId();
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String date = new SimpleDateFormat("yy-MM-dd").format(new java.sql.Date(System.currentTimeMillis()));
		
		Map<String, String> insertFAQMap = new HashMap<>();
		insertFAQMap.put("id", id);
		insertFAQMap.put("title", title);
		insertFAQMap.put("content", content);
		insertFAQMap.put("date", date);
		
		AdminSupportService supportService = new AdminSupportService();
		
		if(title.length() == 0 || content.length() == 0) {
			
			response.setContentType("text/html; charset=UTF-8");
			
			PrintWriter out = response.getWriter();
			out.println("<script>alert('제목과 내용을 다시 입력해주세요.'); location.href='list';</script>");
			
			out.flush();
			out.close();
		} else {
			
			int result = supportService.insertFAQ(insertFAQMap);
			
			if(result > 0) {
				response.sendRedirect(request.getContextPath() + "/admin/faq/list");
			} else {
				String path = "WEB-INF/views/common/failed.jsp";
				request.setAttribute("message", "자주 묻는 질문 정보 등록 실패!");
				request.getRequestDispatcher(path).forward(request, response);
			}
		}
		
	}
	
	

}
