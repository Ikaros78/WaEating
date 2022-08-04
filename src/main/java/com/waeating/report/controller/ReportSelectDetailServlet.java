package com.waeating.report.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.waeating.report.model.dto.ReportDTO;
import com.waeating.report.model.service.ReportService;

/**
 * Servlet implementation class ReportSelectDetailServlet
 */
@WebServlet("/report/detail")
public class ReportSelectDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
   

		int reportNo = Integer.parseInt(request.getParameter("no"));
		
		ReportDTO report = new ReportService().selectOneReport(reportNo);
	    
		System.out.println("reportDetail : " + report);
		
		String path = "";
		if(report != null) {
			path = "/WEB-INF/views/report/reportDetail.jsp";
			request.setAttribute("report", report);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "공지사항 상세보기에 실패하셨습니다");
		}
		 request.getRequestDispatcher(path).forward(request, response);
   
   
   
   
   }




}
