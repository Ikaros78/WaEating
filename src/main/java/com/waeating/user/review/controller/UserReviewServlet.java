package com.waeating.user.review.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.waeating.member.model.dto.MemberDTO;
import com.waeating.user.reservation.model.service.ReservationService;
import com.waeating.waitingRecord.model.dto.WaitingRecordDTO;

/**
 * Servlet implementation class UserReviewServlet
 */
@WebServlet("/user/review")
public class UserReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDTO member = (MemberDTO) request.getSession().getAttribute("loginMember");
		String userId = member.getId();
		
		String comNo = request.getParameter("comNo");
		String recordNo = request.getParameter("recordNo");
		
		System.out.println(comNo);
		System.out.println(recordNo);
		System.out.println(userId);
		
		Map<String, String> selectComMap = new HashMap<>();
		selectComMap.put("userId", userId);
		selectComMap.put("comNo", comNo);
		selectComMap.put("recordNo", recordNo);
		
		ReservationService reservationService = new ReservationService();
		
		WaitingRecordDTO waitingRecord = reservationService.selectReservation(selectComMap);
		
		System.out.println(waitingRecord);
		String path = "";
		if(waitingRecord != null) {
			path = "/WEB-INF/views/user/user_review/user_review.jsp" ;
			request.setAttribute("waitingRecord", waitingRecord);
		}else {
			path = "/WEB-INF/views/common/erroePage.jsp";
			request.setAttribute("message", "예약 정보 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
