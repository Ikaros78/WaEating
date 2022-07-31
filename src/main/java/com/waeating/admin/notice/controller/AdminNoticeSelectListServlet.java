package com.waeating.admin.notice.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.waeating.admin.notice.service.AdminNoticeService;
import com.waeating.common.paging.Pagenation;
import com.waeating.common.paging.SelectCriteria;
import com.waeating.notice.model.dto.NoticeDTO;

/**
 * Servlet implementation class NoticeSelectListServlet
 */
@WebServlet("/admin/notice/list")
public class AdminNoticeSelectListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getSession().getAttribute("ifUpdate") != null){
			request.getSession().removeAttribute("ifUpdate");
		}
		
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
		
		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("searchCondition", searchCondition);
		searchMap.put("searchValue", searchValue);
		
		AdminNoticeService noticeService = new AdminNoticeService();
		int totalCount = noticeService.selectTotalNoticeCount(searchMap);
		
		int limit = 10;
		int buttonAmount = 5;
		
		SelectCriteria selectCriteria = null;
		
		if(searchCondition != null && !"".equals(searchCondition)) {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
		}else {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		}
		
		List<NoticeDTO> noticeList = noticeService.AdminSelectNoticeList(selectCriteria); 
		
		String path = "";
		if(noticeList != null) {
			path= "/WEB-INF/views/admin/notice/noticeList.jsp";
			request.setAttribute("noticeList", noticeList);
			request.setAttribute("selectCriteria", selectCriteria);
			request.setAttribute("link", "list");
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "공지사항 목록 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}
	

}
