package com.waeating.admin.support.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.waeating.admin.support.service.AdminSupportService;
import com.waeating.support.model.dto.FAQDTO;

/**
 * Servlet implementation class AdminFAQSelectDetailServlet
 */
@WebServlet("/admin/faq/detail")
public class AdminFAQSelectDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String faqNo = (String) request.getSession().getAttribute("faqNo");
		
		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("faqNo", faqNo);
		
		AdminSupportService supportService = new AdminSupportService();
		FAQDTO faq = supportService.selectFAQDetail(searchMap);
		
		String path = "";
		
		if(faq != null) {
			path = "/WEB-INF/views/admin/support/supportFAQDetail.jsp";
			
			request.getSession().setAttribute("path", path);
			request.getSession().setAttribute("faq", faq);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "자주 묻는 질문 정보 조회 실패");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
