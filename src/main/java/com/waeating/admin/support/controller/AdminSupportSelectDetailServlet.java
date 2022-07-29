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
import com.waeating.support.model.dto.ReportDTO;

/**
 * Servlet implementation class AdminSupportSelectDetailServlet
 */
@WebServlet("/admin/support/detail")
public class AdminSupportSelectDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String reportNo = (String) request.getSession().getAttribute("reportNo");
		
		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("reportNo", reportNo);
		
		AdminSupportService supportService = new AdminSupportService();
		ReportDTO report = supportService.selectReportDetail(searchMap);
		
		System.out.println(report);
		
		String path = "";
		
		if(report != null) {
			path = "/WEB-INF/views/admin/support/supportDetail.jsp";
			
			request.getSession().setAttribute("path", path);
			request.getSession().setAttribute("report", report);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "문의정보 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
