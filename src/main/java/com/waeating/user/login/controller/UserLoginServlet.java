package com.waeating.user.login.controller;

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
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/member/user/login")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		request.getRequestDispatcher("/WEB-INF/views/user/user-login/user-login.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String userId = request.getParameter("id");
		String userPw = request.getParameter("pw");
		String memberType = (String) session.getAttribute("memberType");
		
		System.out.println("userId : " + userId);
		System.out.println("userPw : " + userPw);
		System.out.println("memberType : " + memberType);
		
		MemberDTO requestMember = new MemberDTO();
		requestMember.setId(userId);
		requestMember.setPwd(userPw);
		requestMember.setMemberType(memberType);
		
		UserService userService = new UserService();
	
		MemberDTO loginMember = userService.loginCheck(requestMember);
		System.out.println(loginMember);
		
		
		if(loginMember != null) {
			
			session.setAttribute("loginMember", loginMember);
			
			response.sendRedirect("/WEB_INF/views/user/user_main.jsp");
		} else {
			
			request.setAttribute("message", "로그인에 실패하셨습니다. 다시 입력해주세요.");
			request.getRequestDispatcher("/WEB-INF/views/common/failed.jsp").forward(request, response);
		}
	}

}
