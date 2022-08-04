package com.waeating.admin.review.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.waeating.admin.review.service.AdminReviewService;
import com.waeating.review.model.dto.ReviewDTO;

/**
 * Servlet implementation class AdminReviewSelectDetailServlet
 */
@WebServlet("/admin/review/detail")
public class AdminReviewSelectDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String reviewNo = (String) request.getSession().getAttribute("reviewNo");
		
		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("reviewNo", reviewNo);
		
		AdminReviewService reviewService = new AdminReviewService();
		ReviewDTO review = reviewService.selectReviewDetail(searchMap);
		
		String path = "";
		
		if(review != null) {
			path = "/WEB-INF/views/admin/review/reviewDetail.jsp";
			
			request.getSession().setAttribute("path", path);
			request.getSession().setAttribute("review", review);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "리뷰 정보 조회 실패");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
