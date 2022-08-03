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
		
		
		
		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;
		
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}
		
		if(pageNo <= 0) {
			pageNo = 1;
		}
		
		MemberDTO member = (MemberDTO) request.getSession().getAttribute("loginMember");
		String userId = member.getId();
		
		Map<String, String> searchMap = new HashMap<>();
		
		searchMap.put("userId", userId);
	
		
		ReservationService reservationService = new ReservationService();
		/* 페이징용 */
		int totalCount = reservationService.selectNowTotalCount(searchMap);
		
		/* 웨이팅 정보 불러오기 용 */
		List<WaitingRecordDTO> waitingRecordAll = reservationService.selectWaitingRecordAll(searchMap);
		
		System.out.println("totalreservationCount : " + totalCount);
		
		int limit = 4;
		int buttonAmount = 5;
		
		String searchCondition = "";
		String searchValue = userId;
		
		SelectCriteria selectCriteria = null;
		
		selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount,searchCondition, searchValue);
		
		System.out.println(selectCriteria);
		
		List<ComInfoDTO> waitingRecord = reservationService.selectNowReservation(selectCriteria);
		
		
//		for(WaitingRecordDTO waiting : waitingRecordAll ) {
//			Map<String, String> waitingMap = new HashMap<>();
//			String comNo = String.valueOf(waiting.getComNo());
//			String recordNo = String.valueOf(waiting.getRecordNo());
//			waitingMap.put("comNo", comNo);
//			waitingMap.put("recordNo", recordNo);
//				
//			
////			int countWaitingRecord = reservationService.selectCountRecord();
//		}
//		List<Map<String, String> > waitingList =  
		
		
		System.out.println("waitingRecord : " + waitingRecord);
		
		String path = "";
		if(waitingRecord != null) {
			
			path = "/WEB-INF/views/user/user_reservation/user_reservation_now.jsp";
			request.setAttribute("waitingRecord", waitingRecord);
			request.setAttribute("selectCriteria", selectCriteria);
//			request.setAttribute("countWaitingRecord", countWaitingRecord);
			
		}else {
			path = "/WEB-INF/views/common/erroePage.jsp";
			request.setAttribute("message", "현재 예약 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
