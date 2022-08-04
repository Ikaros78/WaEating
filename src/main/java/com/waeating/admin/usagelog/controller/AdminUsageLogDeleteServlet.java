package com.waeating.admin.usagelog.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.waeating.admin.usagelog.service.AdminUsageLogService;

/**
 * Servlet implementation class AdminUsageLogDeleteServlet
 */
@WebServlet("/admin/usageLog/delete")
public class AdminUsageLogDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String recordNo = (String) request.getSession().getAttribute("recordNo");
		
		AdminUsageLogService logService = new AdminUsageLogService();
		
		int result = logService.deleteLog(recordNo);
		
		if(result > 0) {
			request.getSession().removeAttribute("ifUpdate");
			response.sendRedirect(request.getContextPath() + "/admin/usageLog/list");
		}else {
			String path = "WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "이용이력 삭제 실패!");
			request.getRequestDispatcher(path).forward(request, response);
		}
	}

}
