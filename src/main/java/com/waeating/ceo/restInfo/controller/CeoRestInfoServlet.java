package com.waeating.ceo.restInfo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.waeating.ceo.restInfo.model.service.ComInfoService;
import com.waeating.com.model.dto.ComInfoDTO;

/**
 * Servlet implementation class CeoRestInfoServlet
 */
@WebServlet("/ceo/rest_restInfo")
public class CeoRestInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		 로그인 정보에서 ComNo 가져오기
		int comNo = 1;
		
		ComInfoService comInfoService = new ComInfoService();
		
		ComInfoDTO comInfo = comInfoService.comSelectOneComInfo(comNo);
		List<ComInfoDTO> comMenu = comInfoService.comSelectOneComMenu(comNo);
		
		String path = "";
		if(comInfo != null) {
			path = "/WEB-INF/views/ceo/restInfo/ceo_rest_restInfo.jsp";
			request.setAttribute("comInfo", comInfo);
			request.setAttribute("comMenuList", comMenu);
		} else {
			path = "/WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("message", "가게 정보 조회 실패");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
	}
	
	

}
