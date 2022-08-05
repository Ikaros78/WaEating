package com.waeating.ceo.reservation.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.waeating.ceo.reservation.model.service.CeoReservationService;
import com.waeating.common.paging.Pagenation;
import com.waeating.common.paging.SelectCriteria;
import com.waeating.waitingRecord.model.dto.WaitingRecordDTO;

/**
 * Servlet implementation class CeoReservationCurrentServlet
 */
@WebServlet("/ceo/reservation_current")
public class CeoReservationCurrentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//request.getRequestDispatcher("/WEB-INF/views/ceo/reservation/ceo_reservation_current.jsp").forward(request, response);
		
		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;
		
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}
		
		if(pageNo <= 0) {
			pageNo = 1;
		}
		
		String searchCondition = "";
		String searchValue = "";
		
		Map<String, Object> searchMap = new HashMap<>();
		searchMap.put("searchCondition", searchCondition);
		searchMap.put("searchValue", searchValue);
		
		CeoReservationService ceoReservatonService = new CeoReservationService();
		int totalCount = ceoReservatonService.selectTotalCount(searchMap);
		
		System.out.println("totalBoardCount : " + totalCount);
		
		int limit = 10;
		int buttonAmount = 1;
		
		SelectCriteria selectCriteria = null;
		
		if(searchCondition != null && !"".equals(searchCondition)) {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
		} else {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		}
		
		System.out.println(selectCriteria);
		
		List<WaitingRecordDTO> waitingRecordList = ceoReservatonService.selectAllWaitingList(selectCriteria);
		
		System.out.println(waitingRecordList);
		
		String path = "";
		if(waitingRecordList != null) {
			path = "/WEB-INF/views/ceo/reservation/ceo_reservation_current.jsp";
			request.setAttribute("waitingRecordList", waitingRecordList);
			request.setAttribute("selectCriteria", selectCriteria);
			request.setAttribute("totalCount", totalCount);
		} else {
			path = "/WEB-INF/views/common.errorPage.jsp";
			request.setAttribute("message", "예약 리스트 조회 실패");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
