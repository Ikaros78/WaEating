package com.waeating.user.matziplist.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.waeating.common.paging.SelectCriteria;
import com.waeating.user.matziplist.model.dto.ComInfoDTO;
import com.waeating.user.matziplist.model.service.ComService;

/**
 * Servlet implementation class UserMatziplistCategoryServlet
 */
@WebServlet("/user/matziplist/category")
public class UserMatziplistCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
		//request.getRequestDispatcher("/WEB-INF/views/user/user_matzip/user_matziplist_category.jsp").forward(request, response);
		
		String selList = request.getParameter("sellist");
		System.out.println("selList : " + selList);
		String categoryName ="";
		if(selList == null) {
			selList = "korea";
		}
		
		switch(selList) {
		case "korea" : categoryName = "한식";
					   break;
		case "china" : categoryName = "중식";
					   break;
		case "japan" : categoryName = "일식";
					   break;
		case "snack" : categoryName = "분식";
					   break;
		case "america" : categoryName = "양식";
					   break;
		case "cafe" : categoryName = "카페";
					   break;
		case "etc" : categoryName = "기타";
					   break;
			
		}
		
		System.out.println(categoryName);
		
		
		
		
		ComService comService = new ComService();	
		
		List<ComInfoDTO> selectCom = comService.selectComByCategory(categoryName);
		
		
		
		/* 조회 결과 성공 여부에 따른 뷰 결정*/
		String path = "";
		if(selectCom != null) {
			
			path = "/WEB-INF/views/user/user_matzip/user_matziplist_category.jsp";
			request.setAttribute("selectCom", selectCom);
			
		}else {
			
			path = "/WEB-INF/views/common/erroePage.jsp";
			request.setAttribute("message", "종류별 맛집 리스트 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	
	}

}
