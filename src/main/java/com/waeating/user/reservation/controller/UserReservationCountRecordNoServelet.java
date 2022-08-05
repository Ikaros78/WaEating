package com.waeating.user.reservation.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.waeating.user.reservation.model.service.ReservationService;

/**
 * Servlet implementation class UserReservationCountRecordNoServelet
 */
@WebServlet("/user/reservation/count_recordNo")
public class UserReservationCountRecordNoServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String comNo = request.getParameter("comNo");
		String recordNo = request.getParameter("recordNo");
		
		System.out.println("comNo :" + comNo);
		System.out.println("recordNo:" +recordNo);
		
		Map<String, String> waitingCountMap = new HashMap<>();
		waitingCountMap.put("comNo", comNo);
		waitingCountMap.put("recordNo", recordNo);
		
		ReservationService reservationService = new ReservationService();
		
//		WaitingRecordDTO waitingRecord = reservationService.selectCountRecord(waitingCountMap);
		int count = reservationService.selectCountRecord(waitingCountMap);
		
		System.out.println("RecordCount :" + count);
		String output = "";
		if(count < 3) {
			
			output = "내 앞에 ' "+ count + "' 팀 남았습니다.  주변에 있어주세요!!  곧 호출됩니다 :)";
		}else {
			output = "내 앞에 ' " + count + " '팀 남았습니다.  조금만 더 기다려 주세요 ㅠ.ㅠ";
		}
		
		response.setContentType("text/plain; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(output);
		
		out.flush();
		out.close();
//		String path = "";
//		
//		if(count >= 0) {
//			
//			path = "/WEB-INF/views/user/user_reservation/user_reservation_now.jsp";
//			request.setAttribute("count", count);
//			
//		}else {
//			path = "/WEB-INF/views/common/erroePage.jsp";
//			request.setAttribute("message", "현재 예약 조회 실패!");
//		}
//		
//		request.getRequestDispatcher(path).forward(request, response);
	}

}
