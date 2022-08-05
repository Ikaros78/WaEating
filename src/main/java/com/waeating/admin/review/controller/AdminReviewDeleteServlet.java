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

/**
 * Servlet implementation class AdminReviewDeleteServlet
 */
@WebServlet("/admin/review/delete")
public class AdminReviewDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String reviewNo = (String) request.getSession().getAttribute("reviewNo");
		
		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("reviewNo", reviewNo);
		
		AdminReviewService reviewService = new AdminReviewService();
		int reviewResult = reviewService.deleteReview(searchMap);
		
		if(reviewResult > 0) {
			response.sendRedirect(request.getContextPath() + "/admin/review/list");
		} else {
			String path = "WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "리뷰정보 삭제 실패!");
			request.getRequestDispatcher(path).forward(request, response);
		}
		
	}

}
