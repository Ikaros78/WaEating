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

import com.waeating.common.paging.Pagenation;
import com.waeating.common.paging.SelectCriteria;
import com.waeating.report.model.service.ReportService;
import com.waeating.report.model.dto.ReportDTO;

/**
 * Servlet implementation class SupportSelectListServlet
 */
@WebServlet("/report/list")
public class ReportSelectListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getSession().getAttribute("ifUpdate") != null){
			request.getSession().removeAttribute("ifUpdate");
		}
		
		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;
		
		if(currentPage != null && !"".equals(currentPage)) {
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
		
		ReportService reportService = new ReportService();
		int totalCount = reportService.selectTotalCount(searchMap);
		
		int limit = 10;
		int buttonAmount = 5;
		
		SelectCriteria selectCriteria = null;
		
		if(searchCondition != null && !"".equals(searchCondition)) {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
		}else {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		}
		
		List<ReportDTO> reportList = reportService.selectAllreport(selectCriteria);
		
		String path = "";
		if(reportList != null) {
			path= "/WEB-INF/views/report/reportList";
			request.setAttribute("reportList", reportList);
			request.setAttribute("selectCriteria", selectCriteria);
		}else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "문의정보 목록 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
