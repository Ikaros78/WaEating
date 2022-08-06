package com.waeating.ceo.login.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.waeating.ceo.login.model.service.ComService;
import com.waeating.com.model.dto.ComInfoDTO;
import com.waeating.member.model.dto.MemberDTO;

/**
 * Servlet implementation class CeoFindIdServlet
 */
@WebServlet("/member/ceo/findid/email")
public class CeoFindIdEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		request.getRequestDispatcher("/WEB-INF/views/ceo/ceo-login/ceo-find_id-email.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String ceoName = request.getParameter("name");
		String email = request.getParameter("email");
		String comName = request.getParameter("store_name");
		String comNum = request.getParameter("store_phone");
		String category = request.getParameter("category");
		
		ComInfoDTO requestCom = new ComInfoDTO();
		requestCom.setComName(comName);
		requestCom.setComPhone(comNum);
		requestCom.setCategory(category);
		
		MemberDTO requestMember = new MemberDTO();
		requestMember.setName(ceoName);
		requestMember.setEmail(email);
		requestMember.setComInfo(requestCom);
		
		ComService comService = new ComService();
		
		MemberDTO findCeoId = comService.findIdEmail(requestMember);
		
		String ceoId = findCeoId.getId();
		System.out.println("ceoId : " + ceoId);
		
		String page = "";
		
		
		if(ceoId != null) {
			
			page = "/WEB-INF/views/common/success.jsp";
			
			request.setAttribute("success", "findCeoId");
			request.setAttribute("ceoId", ceoId);
		} else {
			
			page = "/WEB-INF/views/common/failed.jsp";
			
			request.setAttribute("message", "정보가 일치하지 않습니다. 다시 시도해주세요.");
		}
		request.getRequestDispatcher(page).forward(request, response);
	}
}
