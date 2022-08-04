package com.waeating.admin.review.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.waeating.admin.review.service.AdminReviewService;
import com.waeating.common.paging.Pagenation;
import com.waeating.common.paging.SelectCriteria;
import com.waeating.review.model.dto.ReviewDTO;

/**
 * Servlet implementation class ReviewSelectListServlet
 */
@WebServlet("/admin/review/list")
public class AdminReviewSelectListServlet extends HttpServlet {
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
		
		AdminReviewService reviewService = new AdminReviewService();
		int totalCount = reviewService.selectTotalReviewCount(searchMap);
		
		int limit = 10;
		int buttonAmount = 5;
		
		SelectCriteria selectCriteria = null;
		
		if(searchCondition != null && !"".equals(searchCondition)) {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
		}else {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		}
		
		List<ReviewDTO> reviewList = reviewService.AdminSelectReviewList(selectCriteria);
		
		String path = "";
		if(reviewList != null) {
			path = "/WEB-INF/views/admin/review/reviewList.jsp";
			request.setAttribute("reviewList",reviewList);
			request.setAttribute("selectCriteria", selectCriteria);
			request.setAttribute("link", "list");
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "리뷰 목록 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
		
	}

}
