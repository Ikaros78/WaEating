package com.waeating.user.matziplist.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.waeating.user.matziplist.model.dto.ComInfoDTO;
import com.waeating.user.matziplist.model.service.ComService;

/**
 * Servlet implementation class UserMatziplistAllServlet
 */
@WebServlet("/user/matziplist/all")
public class UserMatziplistAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.getRequestDispatcher("/WEB-INF/views/user/user_matzip/user_matziplist_category.jsp").forward(request, response);
//		
//		ComService comService = new ComService();
//		List<ComInfoDTO> selectCom = comService.selectAllCom();
//		
//		for(ComInfoDTO com : selectCom) {
//			System.out.println(com);
//		}
//		
//		String path = "";
//		
//		if(selectCom != null) {
//			path = "/WEB-INF/views/user/usermatzip/user_matziplist_category.jsp";
//			request.setAttribute("comInfoList", selectCom);
//		}else {
//			path = "/WEB-INF/views/common/erroePage.jsp";
//			request.setAttribute("message", "맛집 리스트 조회 실패!");
//		}
//		
//		request.getRequestDispatcher(path).forward(request, response);
	}

}
