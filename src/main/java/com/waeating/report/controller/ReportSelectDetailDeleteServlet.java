package com.waeating.report.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.waeating.report.model.service.ReportService;

/**
 * Servlet implementation class ReportSelectDetailDeleteServlet
 */
@WebServlet("/report/delete")
public class ReportSelectDetailDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		int reportNo = Integer.parseInt(request.getParameter("reportNo"));
		
		System.out.println(reportNo);
		
		ReportService reportService = new ReportService();
		int result = reportService.deleteReport(reportNo);
		
		System.out.println("result : " + result);
		
		String path = "";
		
		if(result > 0) {
			path = "report/report";
			response.sendRedirect(path);
			
		} else {
			path = "/WEB-INF/views/common.errorPage.jsp";
			request.setAttribute("message", "문의사항 삭제 실패");
			request.getRequestDispatcher(path).forward(request, response);
		}
		
	}


}