package com.waeating.ceo.review.controller;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.waeating.ceo.review.model.service.ComReviewService;

/**
 * Servlet implementation class CeoRestReviewDetailDeleteServlet
 */
@WebServlet("/ceo/rest_review_detail_delete")
public class CeoRestReviewDetailDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		
		System.out.println(reviewNo);
		
		ComReviewService comReviewService = new ComReviewService();
		int result = comReviewService.deleteReviewAns(reviewNo);
		
		System.out.println("result : " + result);
		
		String path = "";
		
		if(result > 0) {
			path = "rest_review";
			response.sendRedirect(path);
		} else {
			path = "/WEB-INF/views/common.errorPage.jsp";
			request.setAttribute("message", "리뷰 삭제 실패");
			request.getRequestDispatcher(path).forward(request, response);
		}
	}

}
