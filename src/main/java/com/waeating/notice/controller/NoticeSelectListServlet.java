package com.waeating.notice.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.waeating.common.paging.Pagenation;
import com.waeating.common.paging.SelectCriteria;
import com.waeating.notice.model.dto.NoticeDTO;
import com.waeating.notice.model.service.NoticeService;


@WebServlet("/notice/list")
public class NoticeSelectListServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String currentPage = request.getParameter("currentPage");
	int pageNo = 1;
	
	if(currentPage != null && ! "".equals(currentPage)) {
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
	
	NoticeService NoticeService = new NoticeService();
	int totalCount = NoticeService.selectTotalCount(searchMap);
	
	System.out.println("totalNoticeCount : " + totalCount);
	
	int limit = 5;
	int buttonAmount = 5;
	
	SelectCriteria selectCriteria = null;
	
	if(searchCondition != null && ! "".equals(searchCondition)) {
		selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
	} else {
		selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
	}
	
	System.out.println(selectCriteria);
	
	List<NoticeDTO> noticeList =  NoticeService.selectAllNoticeList(selectCriteria);
	   
	System.out.println("noticeList : " + noticeList);
	    
	String path = "";
	    
	if(noticeList != null) {
	    path= "/WEB-INF/views/mainNotice/noticeList.jsp";
	    request.setAttribute("noticeList", noticeList);
	    request.setAttribute("selectCriteria", selectCriteria);
	} else {
	    path = "/WEB-INF/views/common/failed.jsp";
	    request.setAttribute("message", "공지사항 조회에 실패했습니다");
	}

	request.getRequestDispatcher(path).forward(request, response);
   
   }

}
