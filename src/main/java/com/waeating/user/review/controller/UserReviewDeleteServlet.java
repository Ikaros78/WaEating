package com.waeating.user.review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.waeating.user.review.model.service.ReviewService;

/**
 * Servlet implementation class UserReviewDeleteServlet
 */
@WebServlet("/user/review/delete")
public class UserReviewDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int recordNo = Integer.parseInt(request.getParameter("recordNo")) ;
		
		System.out.println(recordNo);
		
		ReviewService reviewService = new ReviewService();
		int result = reviewService.deleteReview(recordNo);
		
		System.out.println("result : " + result);
		
		String  path = "";
		
		if(result > 0) {
			response.sendRedirect(request.getContextPath() + "/user/reservation/finish");
		}else {
			path = "/WEB-INF/views/common/erroePage.jsp";
			request.setAttribute("message", "리뷰 삭제 실패");
			request.getRequestDispatcher(path).forward(request, response); 
		}
		
	}

}
