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
import javax.servlet.http.HttpSession;

import com.waeating.common.paging.Pagenation;
import com.waeating.common.paging.SelectCriteria;
import com.waeating.member.model.dto.MemberDTO;
import com.waeating.report.model.dto.ReportDTO;
import com.waeating.report.model.service.ReportService;

/**
 * Servlet implementation class ReportSelectListServlet
 */
@WebServlet("/report/ceo/list")
public class ReportSelectCeoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
		HttpSession session = request.getSession();
		MemberDTO member = (MemberDTO)session.getAttribute("loginMember");
		
		String memId = member.getId();
		
		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;
		
		if(currentPage !=null && ! "".equals(currentPage)) {
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
		
		System.out.println("totalReportCount : " + totalCount);
		
		int limit = 5;
		int buttonAmount =5;
		
		SelectCriteria selectCriteria = null;
		
		if(searchCondition != null && ! "".equals(searchCondition)) {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
			} else {
				selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
			}
		System.out.println(selectCriteria);
		
		/* 두 가지 타입의 객체를 넘겨주기 위해서 Map객체를 생성 */
		Map<String, Object> selectMap = new HashMap<>();
		selectMap.put("memId", memId);
		selectMap.put("selectCriteria", selectCriteria);
		
		List<ReportDTO> reportList = reportService.selectReportList(selectMap);
	
		System.out.println("reportList : " + reportList);
		
		String path = "";
		
		if(reportList != null) {
			path= "/WEB-INF/views/report/ReportCeoList.jsp";
			request.setAttribute("reportList", reportList);
			request.setAttribute("selectCriteria", selectCriteria);
			} else {
				path = "/WEB-INF/views/common/errorPage.jsp";
				request.setAttribute("message", "고객센터 조회에 실패했습니다");
			}
		   request.getRequestDispatcher(path).forward(request, response);
	
	}	
}
