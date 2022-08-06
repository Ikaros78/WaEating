package com.waeating.ceo.restInfo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.waeating.ceo.restInfo.model.service.ComInfoService;
import com.waeating.com.model.dto.ComInfoDTO;
import com.waeating.com.model.dto.ComMenuDTO;
import com.waeating.member.model.dto.MemberDTO;

/**
 * Servlet implementation class CeoRestInfoModifyServlet
 */
@WebServlet("/ceo/rest_restInfo_modify")
public class CeoRestInfoModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		 로그인 정보에서 ComNo 가져오기
		int comNo = 1;

		ComInfoService comInfoService = new ComInfoService();

		ComInfoDTO comInfo = comInfoService.comSelectOneComInfo(comNo);
		List<ComInfoDTO> comMenu = comInfoService.comSelectOneComMenu(comNo);

		String path = "";
		if (comInfo != null) {
			path = "/WEB-INF/views/ceo/restInfo/ceo_rest_restInfo_modify.jsp";
			request.setAttribute("comInfo", comInfo);
			request.setAttribute("comMenuList", comMenu);
		} else {
			path = "/WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("message", "가게 정보 조회 실패");
		}

		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 업체 로그인 정보 가져오기
		String comNo = "1";
		// 업체 정보 수정
		String comName = request.getParameter("comName");
		String category = request.getParameter("category");
		String comAddress = request.getParameter("comAddress");
		String comPhone = request.getParameter("comPhone");
		String waitYn = request.getParameter("waitYn");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		String workTime = startTime + "~" + endTime;
		String holiday = request.getParameter("holiday");

		ComInfoService comInfoService = new ComInfoService();

		Map<String, Object> updateComInfo = new HashMap<>();
		updateComInfo.put("comNo", comNo);
		updateComInfo.put("comName", comName);
		updateComInfo.put("category", category);
		updateComInfo.put("comAddress", comAddress);
		updateComInfo.put("comPhone", comPhone);
		updateComInfo.put("waitYn", waitYn);
		updateComInfo.put("startTime", startTime);
		updateComInfo.put("endTime", endTime);
		updateComInfo.put("workTime", workTime);
		updateComInfo.put("holiday", holiday);

		System.out.println(updateComInfo);

		int comInfoResult = comInfoService.updateComInfo(updateComInfo);

		// 업체 정보 (메뉴) 삭제 및 추가
		int comMenuDeleteResult = comInfoService.deleteComMenu(comNo);

		String[] menuName = request.getParameterValues("menuName");
		String[] price = request.getParameterValues("price");

		List<ComMenuDTO> comMenuList = new ArrayList<>();

		for (int i = 0; i < menuName.length; i++) {

			ComMenuDTO comMenu = new ComMenuDTO();
			comMenu.setMenuName(menuName[i]);
			comMenu.setPrice(Integer.parseInt(price[i]));
			comMenuList.add(comMenu);
		}
		int comMenuInsertResult = comInfoService.insertComMenu(comMenuList);

		String path = "";
		
		if(comInfoResult > 0 && comMenuDeleteResult > 0 && comMenuInsertResult > 0) {
			if (comInfoResult > 0) {
				path = "rest_restInfo";
				response.sendRedirect(path);

			} else {
				path = "/WEB-INF/views/common.errorPage.jsp";
				request.setAttribute("message", "업체 정보 수정 실패");
				request.getRequestDispatcher(path).forward(request, response);
			}

		}

	}
}
