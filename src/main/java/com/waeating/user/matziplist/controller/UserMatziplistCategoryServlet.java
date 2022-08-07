package com.waeating.user.matziplist.controller;

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
import com.waeating.user.matziplist.model.service.ComService;

/**
 * Servlet implementation class UserMatziplistCategoryServlet
 */
@WebServlet("/user/matziplist/category")
public class UserMatziplistCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* 페이징 처리*/
		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;
		
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}
		
		if(pageNo <= 0) {
			pageNo = 1;
		}
		
		String searchCondition = request.getParameter("searchCondition");
		String searchValue = "";
		System.out.println(searchCondition);
		
		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("searchCondition", searchCondition);
		searchMap.put("searchValue", searchValue);
		
		ComService comService = new ComService();	
		
		int totalCount = comService.selectTotalCount(searchMap);		
		System.out.println("totalCount : " + totalCount);
		
		/* 한 페이지에 보여 줄 게시물 수 */
		int limit = 9;		//얘도 파라미터로 전달받아도 된다.
		/* 한 번에 보여질 페이징 버튼의 갯수 */
		int buttonAmount = 5;
		
		SelectCriteria selectCriteria = null;
		
		if(searchCondition != null && !"".equals(searchCondition)) {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
		} else {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		}
		
		System.out.println(selectCriteria);
		
		List<ComInfoDTO> selectCom = comService.selectComByCategory(selectCriteria);
		
		System.out.println("selectCom : " + selectCom);
		
		/* 조회 결과 성공 여부에 따른 뷰 결정*/
		String path = "";
		if(selectCom != null) {
			
			path = "/WEB-INF/views/user/user_matzip/user_matziplist_category.jsp";
			request.setAttribute("selectCom", selectCom);
			request.setAttribute("selectCriteria", selectCriteria);
			
		}else {
			
			path = "/WEB-INF/views/common/erroePage.jsp";
			request.setAttribute("message", "종류별 맛집 리스트 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
		
	}

}
