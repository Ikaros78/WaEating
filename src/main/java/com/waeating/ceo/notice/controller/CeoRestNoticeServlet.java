package com.waeating.ceo.notice.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.waeating.ceo.notice.model.service.ComNoticeService;
import com.waeating.com.model.dto.ComNoticeDTO;
import com.waeating.common.paging.Pagenation;
import com.waeating.common.paging.SelectCriteria;
import com.waeating.member.model.dto.MemberDTO;

/**
 * Servlet implementation class CeoRestNotice
 */
@WebServlet("/ceo/rest_notice")
public class CeoRestNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDTO member = (MemberDTO) request.getSession().getAttribute("loginMember");
		int comNo = member.getComInfo().getComNo();
		
		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;
		
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}
		
		if(pageNo <= 0) {
			pageNo = 1;
		}
		
		String searchCondition = request.getParameter("searchCondition");
		String searchValue = request.getParameter("searchValue");
		
		Map<String, Object> searchMap = new HashMap<>();
		searchMap.put("searchCondition", searchCondition);
		searchMap.put("searchValue", searchValue);
		searchMap.put("comNo", comNo);
		
		ComNoticeService noticeService = new ComNoticeService();
		int totalCount = noticeService.selectTotalCount(searchMap);
		
		System.out.println("totalBoardCount : " + totalCount);
		
		int limit = 10;
		int buttonAmount = 3;
		
		SelectCriteria selectCriteria = null;
		
		if(searchCondition != null && !"".equals(searchCondition)) {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
		} else {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		}
		
		System.out.println(selectCriteria);
		
		Map<String, Object> search = new HashMap<>();
		search.put("selectCriteria", selectCriteria);
		search.put("comNo", comNo);
		
		List<ComNoticeDTO> comNoticeList = noticeService.selectAllNotice(search);
		
		System.out.println(comNoticeList);
		
		String path = "";
		if(comNoticeList != null) {
			path = "/WEB-INF/views/ceo/notice/ceo_rest_notice.jsp";
			request.setAttribute("selectAllNotice", comNoticeList);
			request.setAttribute("selectCriteria", selectCriteria);
			request.setAttribute("search", search);
		} else {
			path = "/WEB-INF/views/common.errorPage.jsp";
			request.setAttribute("message", "공지 리스트 조회 실패");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}


}
