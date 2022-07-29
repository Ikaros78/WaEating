package com.waeating.user.login.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.waeating.member.model.dto.MemberDTO;
import com.waeating.member.model.dto.UserDTO;
import com.waeating.user.login.model.service.UserService;

/**
 * Servlet implementation class UserSignUpServlet
 */
@WebServlet("/member/user/signup")
public class UserSignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		request.getRequestDispatcher("/WEB-INF/views/user/user-login/user-sign_up.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String userId = request.getParameter("id");
		String userName = request.getParameter("name");
		String userPw = request.getParameter("pw");
		String userPhone = request.getParameter("phone");
		String userEmail = request.getParameter("email");
		String userBirth = request.getParameter("birth");
		String userGender = request.getParameter("gender");
		
		UserDTO requestUser = new UserDTO();
		requestUser.setBirth(userBirth);
		requestUser.setGender(userGender);
		requestUser.setUserId(userId);
		
		MemberDTO requestMember = new MemberDTO();
		requestMember.setId(userId);
		requestMember.setName(userName);
		requestMember.setPwd(userPw);
		requestMember.setPhone(userPhone);
		requestMember.setEmail(userEmail);
		
		System.out.println("requestMember : " + requestMember);
		System.out.println("requestUser : " + requestUser);
		
		int resultMember = new UserService().registMember(requestMember);
		int resultUser = new UserService().registUser(requestUser);
		
		System.out.println("resultMember 확인 : " + resultMember);
		System.out.println("resultUser 확인 : " + resultUser);
		
		String page = "";
		
		if(resultUser > 0 && resultMember > 0) {
			
			page = "/WEB-INF/views/common/success.jsp";
			
			request.setAttribute("successCode", "insertMember");
		} else {
			
			page = "/WEB-INF/views/common/failed.jsp";
			
			request.setAttribute("message", "회원가입에 실패하셨습니다. 다시 시도해주세요.");
		}
		request.getRequestDispatcher(page).forward(request, response);
		
	}

}
