package com.waeating.admin.company.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.waeating.admin.company.service.AdminCompanyService;
import com.waeating.com.model.dto.ComInfoDTO;
import com.waeating.common.paging.Pagenation;
import com.waeating.common.paging.SelectCriteria;

/**
 * Servlet implementation class CompanySelectListServlet
 */
@WebServlet("/admin/company/list")
public class AdminCompanySelectListServlet extends HttpServlet {
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
		
		AdminCompanyService companyService = new AdminCompanyService();
		int totalCount = companyService.selectTotalCount(searchMap);
		
		int limit = 10;
		int buttonAmount = 5;
		
		SelectCriteria selectCriteria = null;
		
		if(searchCondition != null && !"".equals(searchCondition)) {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
		}else {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		}
		
		List<ComInfoDTO> companyList = companyService.selectCompanyList(selectCriteria);
		
		String path = "";
		if(companyList != null) {
			path = "/WEB-INF/views/admin/company/companyList.jsp";
			request.setAttribute("companyList", companyList);
			request.setAttribute("selectCriteria", selectCriteria);
			request.setAttribute("link", "list");
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "업체정보 목록 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
