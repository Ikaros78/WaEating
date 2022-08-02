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
import com.waeating.report.model.dto.ReportDTO;
import com.waeating.report.model.service.ReportService;


/**
 * Servlet implementation class CsDetailServlet
 */
@WebServlet("/report/detail")
public class ReportDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       String currentPage = request.getParameter("currentPage");
       int pageNo = 1;
       
       if(currentPage != null && ! "".equals(currentPage)) {
    	   pageNo = Integer.parseInt(currentPage);
       }
       
       if(pageNo <= 0) {
    	   pageNo = 1;
       }
       
       String searchCondition = request.getParameter("searchCondition");
       String searchValue = request.getParameter("searchValue");
       
       Map<String, String> searchMap = new HashMap<>();
       searchMap.put("searchCondition", searchCondition);
	   searchMap.put("searchValue", searchValue);
		
	    ReportService ReportService = new ReportService();
		int totalCount = ReportService.selectTotalCount(searchMap);
		
		System.out.println("totalBoardCount : " + totalCount);
		
		int limit = 10;
		int buttonAmount = 3;
		
		SelectCriteria selectCriteria = null;
		
		if(searchCondition != null && !"".equals(searchCondition)) {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
		} else {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		}
		
		System.out.println(selectCriteria);
		
		List<ReportDTO> reportList = ReportService.selectAllReport(selectCriteria);
		
		System.out.println(reportList);
		
		String path = "";
		if(reportList != null) {
			path = "/WEB-INF/views/report/reportList.jsp";
			request.setAttribute("selectAllNotice", reportList);
			request.setAttribute("selectCriteria", selectCriteria);
		} else {
			path = "/WEB-INF/views/common.errorPage.jsp";
			request.setAttribute("message", "공지 리스트 조회 실패");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}
	

}
