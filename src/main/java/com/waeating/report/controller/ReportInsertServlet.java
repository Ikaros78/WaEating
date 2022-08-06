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
 * Servlet implementation class ReportInsertServlet
 */
@WebServlet("/report/insert")
public class ReportInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		request.getRequestDispatcher("/WEB-INF/views/report/ReportInsert.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
	   String title = request.getParameter("title=");
	   String Content = request.getParameter("Content");
	 
	   
	   ReportDTO newReport = new ReportDTO();
	   newReport.setTitle(title);
	   newReport.setContent(Content);
	   System.out.println("newReport" + newReport);
	   
	   ReportService reportService = new ReportService();
       int result = reportService.insertReport(newReport);	   	 
       String path = "";
       if(result > 0) {
	   path = "WEB-INF/views/common/success.jsp";
		   request.setAttribute("sucessCode", "insertReport");
	   } else {
		   path = "WEB-INF/views/common/faile.jap";
	   request.setAttribute("message", "문의하기에 실패하셨습니다");	   }
     request.getRequestDispatcher(path).forward(request, response);

 
 }


}
