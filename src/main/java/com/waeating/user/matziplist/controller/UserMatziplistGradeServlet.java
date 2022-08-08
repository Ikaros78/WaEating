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
 * Servlet implementation class UserMatziplistGrade
 */
@WebServlet("/user/matziplist/grade")
public class UserMatziplistGradeServlet extends HttpServlet {
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
		
		ComService comService = new ComService();
		
		int totalCount = comService.selectComCountByGrade();
		System.out.println("totalCount : " + totalCount);
		
		int limit = 9;
		
		int buttonAmount = 5;
		
		SelectCriteria selectCriteria = null;
		
	
		selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		
		
		System.out.println(selectCriteria);
		
		List<ComInfoDTO> selectCom = comService.selectComByGrade(selectCriteria);
		
		System.out.println("selectCom : " + selectCom);
		
		String path = "";
		if(selectCom != null) {
			
			path = "/WEB-INF/views/user/user_matzip/user_matziplist_grade.jsp";
			request.setAttribute("selectCom", selectCom);
			request.setAttribute("selectCriteria", selectCriteria);
			
		}else {
			
			path = "/WEB-INF/views/common/erroePage.jsp";
			request.setAttribute("message", "종류별 맛집 리스트 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		}
	

}
