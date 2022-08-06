package com.waeating.report.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.waeating.report.model.dto.ReportDTO;
import com.waeating.report.model.service.ReportService;

/**
 * Servlet implementation class ReportSelectUpdateServlet
 */
@WebServlet("/report/update")
public class ReportSelectUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("test" + request.getParameter("report"));
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String reportNo = request.getParameter("reportNo");
		String id = request.getParameter("id");
		String regDate = request.getParameter("regDate");
		java.sql.Date date = java.sql.Date.valueOf(regDate);
		ReportDTO newReport = new ReportDTO();
		newReport.setTitle(title);
		newReport.setContent(content);
		newReport.setReportNo(Integer.parseInt(reportNo));
		newReport.setId(id);
		newReport.setRegDate(date);
		ReportService reportService = new ReportService();
	       int result = reportService.updateReport(newReport);	   	 
	       String path = "";
	       if(result > 0) {
		   path = "/WEB-INF/views/common/success.jsp";
			   request.setAttribute("success", "updateReport");
			   request.setAttribute("no", reportNo);
		   } else {
			   path = "/WEB-INF/views/common/faile.jap";
		   request.setAttribute("message", "문의하기 작성글 수정에 실패하셨습니다");	   }
	     request.getRequestDispatcher(path).forward(request, response);
	}

}
