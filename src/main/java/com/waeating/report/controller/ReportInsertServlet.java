package com.waeating.report.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.waeating.report.model.dto.ReportDTO;
import com.waeating.report.model.service.ReportService;

/**
 * Servlet implementation class ReportInsertServlet
 */
@WebServlet("/report/insert")
public class ReportInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
      HttpSession session = request.getSession();
		
		request.getRequestDispatcher("/WEB-INF/views/report/reportDetail.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String reportTitle = request.getParameter("reportTitle");
		String reportContent = request.getParameter("reportContent");
		
		ReportDTO report = new ReportDTO();
		report.setReportTitle(reportTitle);
		report.setReportContent(reportContent);
		
		System.out.println("insert : " + report);
		 
		ReportService reportService = new ReportService();
		int result = reportService.insertReport(report);
		
		String path = "";
		
		if(result > 0) {
			response.sendRedirect(request.getContextPath() + "/report/list");
			
		} else {
			path = "/WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("message", "문의사항 등록에 실패하셨습니다.");
			request.getRequestDispatcher(path).forward(request, response);
		}
		
	
	
	}

}
