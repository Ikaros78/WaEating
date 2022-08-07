package com.waeating.report.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.waeating.report.model.service.ReportService;

/**
 * Servlet implementation class ReportSelectDeleteServlet
 */
@WebServlet("/report/ceo/delete")
public class ReportSelectCeoDeleteServler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  reportNo = request.getParameter("reportNum");
		ReportService reportService = new ReportService(); 

		int result = reportService.deleteReport(Integer.parseInt(reportNo));	   	 
        String path = "";
        if (result > 0) {
	    path = "/WEB-INF/views/common/success.jsp";
		   request.setAttribute("success", "deleteCeoReport");
	    } else {
		   path = "/WEB-INF/views/common/faile.jap";
		   request.setAttribute("message", "삭제에 실패하셨습니다");	   
		}
        request.getRequestDispatcher(path).forward(request, response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
