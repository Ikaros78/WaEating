package com.waeating.ceo.mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.waeating.ceo.login.model.service.ComService;
import com.waeating.member.model.dto.MemberDTO;
import com.waeating.user.login.model.service.UserService;

/**
 * Servlet implementation class CeoCheckPasswordServlet
 */
@WebServlet("/ceo/check/password")
public class CeoCheckPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		request.getRequestDispatcher("/WEB-INF/views/ceo/ceo-mypage/ceo-checkpw.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
	
		MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");
		String ceoId = loginMember.getId();
		String ceoPwd = request.getParameter("pw");
		String MemberType = (String) session.getAttribute("memberType");
		
		MemberDTO requestMember = new MemberDTO();
		requestMember.setId(ceoId);
		requestMember.setPwd(ceoPwd);
		requestMember.setMemberType(MemberType);
		
		ComService comService = new ComService();
		
		MemberDTO ceoInfo = comService.checkPwdCeo(requestMember);
		System.out.println("ceoInfo : " + ceoInfo);
		
		if(ceoInfo != null) {
			
			response.sendRedirect(request.getContextPath() + "/member/ceo/update/information");
		} else {
			
			request.setAttribute("message", "잘못된 비밀번호입니다. 다시 입력해주세요.");
			request.getRequestDispatcher("/WEB-INF/views/common/failed.jsp").forward(request, response);
		}
	}
}
