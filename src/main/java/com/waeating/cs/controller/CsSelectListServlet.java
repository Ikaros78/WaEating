package com.waeating.cs.controller;

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
import com.waeating.cs.model.dto.CsDTO;
import com.waeating.cs.model.service.CsService;
import com.waeating.notice.model.dto.NoticeDTO;

/**
 * Servlet implementation class CsSelectListServlet
 */
@WebServlet("/cs/list")
public class CsSelectListServlet extends HttpServlet {
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
	searchMap.put(searchCondition, searchCondition);
	searchMap.put("searchValue", searchValue);
	
	CsService CsService = new CsService();
	int totalCount = CsService.selectTotalCount(searchMap);
	
	System.out.println("totalCsCount : " + totalCount);
	
	int limit = 5;
	int buttonAmount = 5;
	
	SelectCriteria selectCriteria = null;
	
	if(searchCondition != null && ! "".equals(searchCondition)) {
		selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
	} else {
		selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
	}
	
	System.out.println(selectCriteria);
	
	List<CsDTO> CsList =  CsService.selectAllCsList(selectCriteria);
	   
	System.out.println("CsList : " + CsList);
	    
	String path = "";
	    
	if(CsList != null) {
	    path= "";
	    request.setAttribute("CsList", CsList);
	    request.setAttribute("selectCriteria", selectCriteria);
	} else {
	    path = "/WEB-INF/views/common/failed.jsp";
	    request.setAttribute("message", "고객센터 조회에 실패하였습니다");
	}

	request.getRequestDispatcher(path).forward(request, response);
	
	
	
	}


}
