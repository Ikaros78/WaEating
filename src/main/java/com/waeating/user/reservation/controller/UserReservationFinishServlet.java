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

import com.waeating.com.model.dto.ComInfoDTO;
import com.waeating.common.paging.Pagenation;
import com.waeating.common.paging.SelectCriteria;
import com.waeating.user.reservation.model.service.ReservationService;

/**
 * Servlet implementation class UserReservationFinishServlet
 */
@WebServlet("/user/reservation/finish")
public class UserReservationFinishServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;
		
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}
		
		if(pageNo <= 0) {
			pageNo = 1;
		}
		
		Map<String, String> searchMap = new HashMap<>();
		
		ReservationService reservationService = new ReservationService();
		
		int totalCount = reservationService.selectFinishTotalCount(searchMap);
		System.out.println("totalreservationCount : " + totalCount);
		
		int limit = 4;
		int buttonAmount = 5;
		
		SelectCriteria selectCriteria = null;
		
		selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		
		System.out.println(selectCriteria);
		
		List<ComInfoDTO> waitingRecord = reservationService.selectFinshReservation(selectCriteria);
		
		System.out.println("waitingRecord : " + waitingRecord);
		
		String path = "";
		if(waitingRecord != null) {
			
			path = "/WEB-INF/views/user/user_reservation/user_reservation_finish.jsp";
			request.setAttribute("waitingRecord", waitingRecord);
			request.setAttribute("selectCriteria", selectCriteria);
		}else {
			path = "/WEB-INF/views/common/erroePage.jsp";
			request.setAttribute("message", "이용완료한 예약 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	
	}

}
