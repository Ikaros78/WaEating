package com.waeating.user.reservation.controller;

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

import com.waeating.com.model.dto.ComInfoDTO;
import com.waeating.common.paging.Pagenation;
import com.waeating.common.paging.SelectCriteria;
import com.waeating.member.model.dto.MemberDTO;
import com.waeating.user.reservation.model.service.ReservationService;
import com.waeating.waitingRecord.model.dto.WaitingRecordDTO;

/**
 * Servlet implementation class UserReservationNowServlet
 */
@WebServlet("/user/reservation/now")
public class UserReservationNowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		MemberDTO member = (MemberDTO) request.getSession().getAttribute("loginMember");
		String userId = member.getId();
		
		Map<String, String> searchMap = new HashMap<>();
		
		searchMap.put("userId", userId);
	
		
		ReservationService reservationService = new ReservationService();
	

		List<ComInfoDTO> waitingRecord = reservationService.selectNowReservation(searchMap);
		
		
		HttpSession session = request.getSession();
		session.setAttribute("waitingRecord", waitingRecord); 
		
		
		System.out.println("waitingRecord : " + waitingRecord);
		String path = "";
		if(waitingRecord != null) {
			
			path = "/WEB-INF/views/user/user_reservation/user_reservation_now.jsp";
			request.setAttribute("waitingRecord", waitingRecord);
			
		}else {
			path = "/WEB-INF/views/common/erroePage.jsp";
			request.setAttribute("message", "현재 예약 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String comNo = request.getParameter("comNo");
		String recordNo = request.getParameter("recordNo");
		
		MemberDTO member = (MemberDTO) request.getSession().getAttribute("loginMember");
		String userId = member.getId();
				
		System.out.println("comNo :" +comNo);
		System.out.println("recordNo : " +recordNo);
		
		Map<String, String> waitingRecord = new HashMap<>();
		waitingRecord.put("userId", userId);
		waitingRecord.put("comNo", comNo);
		waitingRecord.put("recordNo", recordNo);
		
		System.out.println("updateWaitingRecord : " + waitingRecord);
		
		ReservationService reservationService = new ReservationService();
		
		int result = reservationService.updateReservaiton(waitingRecord);
		String path = "";
		
		if(result > 0) {
			response.sendRedirect(request.getContextPath() + "/user/reservation/cancel");
		}else {
			path = "/WEB-INF/views/common/erroePage.jsp";
			request.setAttribute("message", "예약취소 실패");
			request.getRequestDispatcher(path).forward(request, response);
		}
		
	}

}
