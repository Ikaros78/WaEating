package com.waeating.user.reservation.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.waeating.com.model.dto.ComInfoDTO;
import com.waeating.member.model.dto.MemberDTO;
import com.waeating.user.matziplist.model.service.ComService;
import com.waeating.user.reservation.model.service.ReservationService;


/**
 * Servlet implementation class UserReservationServlet
 */
@WebServlet("/user/reservation")
public class UserReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String comNo = request.getParameter("comNo");
		
		HttpSession session = request.getSession();
		
		session.setAttribute("comNo", comNo);
		
		ComService comService = new ComService();
		
		ComInfoDTO selectCom = comService.selectComName(comNo);
		
		System.out.println("selectComName : " + selectCom);
		
		String path = "";
		
		if(selectCom != null) {
			path = "/WEB-INF/views/user/user_reservation/user_reservation.jsp";
			request.setAttribute("selectCom", selectCom);
		}else {
		path = "/WEB-INF/views/common/erroePage.jsp";
		request.setAttribute("message", "식당 이름 조회 실패!");
	}
	
	request.getRequestDispatcher(path).forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDTO member = (MemberDTO) request.getSession().getAttribute("loginMember");
		String userId = member.getId();
		
		String comNo =  (String) request.getSession().getAttribute("comNo");
		String memberNum = request.getParameter("memberNum");
		String requirement = request.getParameter("requirement");
		
		System.out.println("a:"+comNo);
		System.out.println("b:"+memberNum);
		System.out.println("c:"+requirement);
		
		Map<String,String> waitingRecord = new HashMap<>();
		waitingRecord.put("userId", userId);
		waitingRecord.put("comNo", comNo);
		waitingRecord.put("memberNum", memberNum);
		waitingRecord.put("requirement", requirement);
		
	
		
		
		System.out.println("insetWaitingRecord : " + waitingRecord);
		
		ReservationService reservationService = new ReservationService();
		
		int result = reservationService.insertReservation(waitingRecord);
		
		String path = "";
		
		if( result > 0 ) {
			response.sendRedirect(request.getContextPath() + "/user/reservation/now");
			
		}else {
			path = "/WEB-INF/views/common/erroePage.jsp";
			request.setAttribute("message", "예약실패");
			request.getRequestDispatcher(path).forward(request, response);
		}
		
		
	}

}
