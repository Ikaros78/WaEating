package com.waeating.ceo.review.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.waeating.ceo.review.model.service.ComReviewService;
import com.waeating.common.paging.Pagenation;
import com.waeating.common.paging.SelectCriteria;
import com.waeating.review.model.dto.ReviewAnsDTO;
import com.waeating.review.model.dto.ReviewDTO;

/**
 * Servlet implementation class CeoRestReview
 */
@WebServlet("/ceo/rest_review")
public class CeoRestReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;
		
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}
		
		if(pageNo <= 0) {
			pageNo = 1;
		}
		
		String searchCondition = "";
		String searchValue = "";
		
		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("searchCondition", searchCondition);
		searchMap.put("searchValue", searchValue);
		
		ComReviewService reviewService = new ComReviewService();
		int totalCount = reviewService.selectTotalCount(searchMap);
		
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
		
		List<ReviewDTO> comReviewList = reviewService.selectAllReview(selectCriteria);
		
		System.out.println(comReviewList);
		
		String path = "";
		if(comReviewList != null) {
			path = "/WEB-INF/views/ceo/review/ceo_rest_review.jsp";
			request.setAttribute("selectAllReview", comReviewList);
			request.setAttribute("selectCriteria", selectCriteria);
			request.setAttribute("totalCount", totalCount);
		} else {
			path = "/WEB-INF/views/common.errorPage.jsp";
			request.setAttribute("message", "리뷰 리스트 조회 실패");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	
	
	

}
