package com.waeating.report.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.waeating.ceo.notice.model.dto.ComNoticeDTO;
import com.waeating.ceo.notice.model.service.ComNoticeService;
import com.waeating.common.paging.Pagenation;
import com.waeating.common.paging.SelectCriteria;
import com.waeating.notice.model.dto.NoticeDTO;
import com.waeating.notice.model.service.NoticeService;
import com.waeating.report.model.dto.ReportDTO;
import com.waeating.report.model.service.ReportService;


/**
 * Servlet implementation class CsDetailServlet
 */
@WebServlet("/report/detail")
public class ReportDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
       int no = Integer.parseInt(request.getParameter("no"));
		
		ReportService reportService = new ReportService();
		ReportDTO reportDetail = reportService.selectReportDetail(no);
	    
		System.out.println("noticeDetail : " + reportDetail);
		
		String path = "";
		if(reportDetail != null) {
			path = "/WEB-INF/views/report/reportDetail.jsp";
			request.setAttribute("notice", reportDetail);
		} else {
			path = "WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "공지사항 상세보기에 실패하셨습니다");
		}
		 request.getRequestDispatcher(path).forward(request, response);
      
	}
	

}
