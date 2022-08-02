package com.waeating.ceo.review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.waeating.ceo.review.model.service.ComReviewService;
import com.waeating.review.model.dto.ReviewDTO;


/**
 * Servlet implementation class CeoRestReviewDetailModifyServlet
 */
@WebServlet("/ceo/rest_review_detail_modify")
public class CeoRestReviewDetailModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		HttpSession session = request.getSession();
//		
		
		String reviewNo = request.getParameter("reviewNo");
		
		System.out.println(reviewNo);
		
		ComReviewService reviewService = new ComReviewService();
		ReviewDTO selectReview = reviewService.selectOneReview(reviewNo);
		
		System.out.println(selectReview);
		
		String path = "";
		if(selectReview != null) {
			path = "/WEB-INF/views/ceo/review/ceo_rest_review_detail_modify.jsp";
			request.setAttribute("selectOneReview", selectReview);
			request.setAttribute("reviewNo", reviewNo);
			
		} else{
			path = "/WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("message", "리뷰 조회 실패");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
