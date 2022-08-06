package com.waeating.ceo.reservation.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.waeating.ceo.reservation.model.service.CeoReservationService;
import com.waeating.waitingRecord.model.dto.WaitingRecordDTO;
import com.waeating.waitingRecord.model.dto.WaitingRefuseDTO;

/**
 * Servlet implementation class CeoReservationListRefuseServlet
 */
@WebServlet("/ceo/reservation_list_refuse")
public class CeoReservationListRefuseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String recordNo = request.getParameter("recordNo");
		String useStatus = "cancel";
		String refuseReason = request.getParameter("refuseReason");
		
		WaitingRefuseDTO waitingRefuse = new WaitingRefuseDTO();
		waitingRefuse.setRecordNo(Integer.parseInt(recordNo));
		waitingRefuse.setRefuseReason(refuseReason);
		
		System.out.println("waitingRefuse : " + waitingRefuse);
		CeoReservationService ceoReservationService = new CeoReservationService();
		int insertRefuse = ceoReservationService.insertWaitingRefuse(waitingRefuse);
		
		WaitingRecordDTO waitingRecord = new WaitingRecordDTO();
		waitingRecord.setRecordNo(Integer.parseInt(recordNo));
		waitingRecord.setUseStatus(useStatus);
		int updateRecord = ceoReservationService.updateWaitingRecord(waitingRecord);
		
		String path = "";
		if(insertRefuse > 0 && updateRecord > 0) {
				response.sendRedirect("reservation_list");
		} else {
			path = "/WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("message", "예약 수정 실패");
			request.getRequestDispatcher(path).forward(request, response);
		}
	}

}
