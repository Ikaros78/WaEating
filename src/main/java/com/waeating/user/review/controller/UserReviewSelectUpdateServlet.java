package com.waeating.user.review.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.waeating.member.model.dto.MemberDTO;
import com.waeating.review.model.dto.ReviewAttachDTO;
import com.waeating.review.model.dto.ReviewDTO;
import com.waeating.user.reservation.model.service.ReservationService;
import com.waeating.user.review.model.service.ReviewService;
import com.waeating.waitingRecord.model.dto.WaitingRecordDTO;

/**
 * Servlet implementation class UserReviewDeleteUpdateServlet
 */
@WebServlet("/user/review/selecteupdate")
public class UserReviewSelectUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MemberDTO member = (MemberDTO) request.getSession().getAttribute("loginMember");
		String userId = member.getId();
		
		String comNo = request.getParameter("comNo");
		String recordNo = request.getParameter("recordNo");
		
		
		Map<String,String> selectComMap = new HashMap<>();		
		
		selectComMap.put("userId",userId);
		selectComMap.put("comNo", comNo);
		selectComMap.put("recordNo", recordNo);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("recordNo", recordNo);
		
		ReservationService reservationService = new ReservationService();
		ReviewService reviewService = new ReviewService();
		
		WaitingRecordDTO waitingRecord = reservationService.selectReservation(selectComMap);
		ReviewDTO review = reviewService.selectReview(selectComMap);
		
		int reviewNo = review.getReviewNo();
		
		List<ReviewAttachDTO> reviewAttach = reviewService.selectReviewImg(reviewNo);
		
		System.out.println("reviw : " + review);
		
		System.out.println(reservationService);
		
		String path = "";
		if(waitingRecord != null) {
			path = "/WEB-INF/views/user/user_review/user_review_deleteupdate.jsp" ;
			request.setAttribute("waitingRecord", waitingRecord);
			request.setAttribute("review", review);
			request.setAttribute("reviewAttach", reviewAttach);
		}else {
			path = "/WEB-INF/views/common/erroePage.jsp";
			request.setAttribute("message", "예약 정보 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}
	
	@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String reviewContent = request.getParameter("reviewContent");
		String recordNo = (String) request.getSession().getAttribute("recordNo");
		String ratings = request.getParameter("ratings");
		
		System.out.println("a :" + reviewContent);
		System.out.println("b :" + recordNo);
		System.out.println("d :" + ratings);
		
		Map<String, String> updateReviewMap = new HashMap<>();
		updateReviewMap.put("reviewContent", reviewContent);
		updateReviewMap.put("recordNo", recordNo);
		updateReviewMap.put("ratings", ratings);
		
		System.out.println("updateReviewMap : " + updateReviewMap);
		
		ReviewService reviewService = new ReviewService();
		
		int result = reviewService.updateReview(updateReviewMap);
		
		String path = "";
		
		if(result > 0) {
			response.sendRedirect(request.getContextPath() + "/user/reservation/finish");
		} else {
			path = "/WEB-INF/views/common/erroePage.jsp";
			request.setAttribute("message", "리뷰 수정 실패");
			request.getRequestDispatcher(path).forward(request, response);
		}
		
	}

}
