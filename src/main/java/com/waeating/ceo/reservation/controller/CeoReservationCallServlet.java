package com.waeating.ceo.reservation.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.waeating.ceo.reservation.model.service.CeoReservationService;
import com.waeating.waitingRecord.model.dto.WaitingRecordDTO;

/**
 * Servlet implementation class CeoReservationYnServlet
 */
@WebServlet("/ceo/reservation_current_call")
public class CeoReservationCallServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String recordNo = request.getParameter("recordNo");
		String useStatus = "called";
		System.out.println(recordNo);
		
		WaitingRecordDTO waitingRecord = new WaitingRecordDTO();
		waitingRecord.setRecordNo(Integer.parseInt(recordNo));
		waitingRecord.setUseStatus(useStatus);
		
		System.out.println(waitingRecord);
		
		CeoReservationService ceoReservationService = new CeoReservationService();
		int result = ceoReservationService.updateWaitingRecord(waitingRecord);
		
		System.out.println("result : " + result);
		
		String path = "";
		if(result > 0) {
			response.sendRedirect("reservation_current");
		} else{
			path = "/WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("message", "예약 수정 실패");
			request.getRequestDispatcher(path).forward(request, response);
		}
		
	}


}
