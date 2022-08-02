package com.waeating.admin.support.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.waeating.admin.support.service.AdminSupportService;

/**
 * Servlet implementation class AdminFAQDeleteServlet
 */
@WebServlet("/admin/faq/delete")
public class AdminFAQDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String faqNo = (String) request.getSession().getAttribute("faqNo");
		
		AdminSupportService supportService = new AdminSupportService();
		
		int result = supportService.deleteFAQ(faqNo);
		
		if(result > 0) {
			request.getSession().removeAttribute("ifUpdate");
			response.sendRedirect(request.getContextPath() + "/admin/faq/list");
		}else {
			String path = "WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "자주 묻는 질문 삭제 실패!");
			request.getRequestDispatcher(path).forward(request, response);
		}
	}

}
