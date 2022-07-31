package com.waeating.admin.support.controller;

import java.io.IOException;
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
 * Servlet implementation class AdminFAQUpdateServlet
 */
@WebServlet("/admin/faq/update")
public class AdminFAQUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MemberDTO admin = (MemberDTO) request.getSession().getAttribute("loginMember"); 
		String faqNo = (String) request.getSession().getAttribute("faqNo");
		String id = admin.getId();
		String title = request.getParameter("updateTitle");
		String content = request.getParameter("updateContent");
		String date = new SimpleDateFormat("yy-MM-dd").format(new java.sql.Date(System.currentTimeMillis()));
		
		System.out.println(date);
		
		Map<String, String> updateFAQMap = new HashMap<>();
		updateFAQMap.put("faqNo", faqNo);
		updateFAQMap.put("id", id);
		updateFAQMap.put("title", title);
		updateFAQMap.put("content", content);
		updateFAQMap.put("date", date);
		
		AdminSupportService supportService = new AdminSupportService();
		
		if(title.length() == 0 && content.length() == 0) {
			response.sendRedirect(request.getContextPath() + "/admin/cancle/session");
		}else {
			
			int faqResult = supportService.updateFAQ(updateFAQMap);
			
			if(faqResult > 0) {
				request.getSession().removeAttribute("ifUpdate");
				response.sendRedirect(request.getContextPath() + "/admin/faq/detail");
			} else {
				String path = "WEB-INF/views/common/failed.jsp";
				request.setAttribute("message", "자주 묻는 질문 정보 수정 실패!");
				request.getRequestDispatcher(path).forward(request, response);
			}
			
		}
	}


}
