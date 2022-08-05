package com.waeating.user.mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.waeating.member.model.dto.MemberDTO;
import com.waeating.user.login.model.service.UserService;

/**
 * Servlet implementation class UserCheckPasswordServlet
 */
@WebServlet("/user/check/password")
public class UserCheckPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		request.getRequestDispatcher("/WEB-INF/views/user/user-mypage/user-checkpw.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");
		String userId = loginMember.getId();
		String userPwd = request.getParameter("pw");
		String memberType = (String) session.getAttribute("memberType");
		
		MemberDTO requestMember = new MemberDTO();
		requestMember.setId(userId);
		requestMember.setPwd(userPwd);
		requestMember.setMemberType(memberType);
		
		UserService userService = new UserService();
		
		MemberDTO userInfo = userService.checkPwdUser(requestMember);
		System.out.println("userInfo : " + userInfo);
		
		if(userInfo != null) {
			
			response.sendRedirect(request.getContextPath() + "/member/user/update/information");
		} else {
			
			request.setAttribute("message", "잘못된 비밀번호입니다. 다시 입력해주세요.");
			request.getRequestDispatcher("/WEB-INF/views/common/failed.jsp").forward(request, response);
		}
	}

}
