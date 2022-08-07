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
 * Servlet implementation class CeoLoginServlet
 */
@WebServlet("/member/ceo/login")
public class CeoLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		request.getRequestDispatcher("/WEB-INF/views/ceo/ceo-login/ceo-login.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String ceoId = request.getParameter("ceoId");
		String ceoPw = request.getParameter("ceoPw");
		String memberType = (String) session.getAttribute("memberType");
		
		System.out.println("ceoId : " + ceoId);
		System.out.println("ceoPw : " + ceoPw);
		System.out.println("memberType : " + memberType);
		
		MemberDTO requestMember = new MemberDTO();
		requestMember.setId(ceoId);
		requestMember.setPwd(ceoPw);
		requestMember.setMemberType(memberType);
		
		ComService comService = new ComService();
		
		MemberDTO loginMember = comService.loginCheck(requestMember);
		System.out.println("loginMember : " + loginMember);
		
		if(loginMember != null) {
			
			session.setAttribute("loginMember", loginMember);
			
			response.sendRedirect(request.getContextPath() + "/ceo/main");
		} else {
			
			request.setAttribute("message", "로그인에 실패하셨습니다. 다시 입력해주세요.");
			request.getRequestDispatcher("/WEB-INF/views/common/failed.jsp").forward(request, response);
		}
		
	}

}
