package com.waeating.ceo.review.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.waeating.ceo.review.model.service.ComReviewService;
import com.waeating.review.model.dto.ReviewAnsDTO;
import com.waeating.review.model.dto.ReviewAttachDTO;
import com.waeating.review.model.dto.ReviewDTO;
import com.waeating.user.review.model.service.ReviewService;

/**
 * Servlet implementation class CeoRestReviewDetailNewServlet
 */
@WebServlet("/ceo/rest_review_detail_new")
public class CeoRestReviewDetailNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		
		ComReviewService reviewService = new ComReviewService();
		ReviewDTO selectReview = reviewService.selectOneReview(reviewNo);
		List<ReviewAttachDTO> selectReviewImg = reviewService.selectReviewImg(reviewNo);
		
		System.out.println(selectReview);
		
		String path = "";
		if(selectReview != null) {
			path = "/WEB-INF/views/ceo/review/ceo_rest_review_detail_new.jsp";
			request.setAttribute("selectOneReview", selectReview);
			request.setAttribute("reviewNo", reviewNo);
			request.setAttribute("selectReviewImg", selectReviewImg);
		} else{
			path = "/WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("message", "리뷰 조회 실패");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		String ansContent = request.getParameter("ansContent");
		
		ReviewAnsDTO reviewAns = new ReviewAnsDTO();
		reviewAns.setReviewNo(reviewNo);
		reviewAns.setAnsContent(ansContent);
		
		System.out.println(reviewNo);
		System.out.println(reviewAns);
		
		ComReviewService reviewService = new ComReviewService();
		
		String path = "";
		
		if ( ansContent.length() == 0 ) {
			
			response.setCharacterEncoding("utf-8");
			
			response.setContentType("text/html; charset=UTF-8");
			
			PrintWriter out = response.getWriter();
			out.println("<script>alert('답변을 다시 입력하세요.');</script>");
			
			out.flush();
			out.close();
			
		} else {

			int result = reviewService.insertReviewAns(reviewAns);
			
			if(result > 0) {
				response.sendRedirect(request.getContextPath() + "/ceo/rest_review");
			
			} else {
				path = "/WEB-INF/views/common/errorPage.jsp";
				request.setAttribute("message", "리뷰 등록에 실패하셨습니다.");
				request.getRequestDispatcher(path).forward(request, response);
			}
		}
		
	}


}
