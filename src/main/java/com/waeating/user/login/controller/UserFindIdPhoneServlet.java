package com.waeating.user.login.controller;

import java.io.IOException;
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
 * Servlet implementation class UserFindIdEmailServlet
 */
@WebServlet("/member/user/findid/phone")
public class UserFindIdPhoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		request.getRequestDispatcher("/WEB-INF/views/user/user-login/user-find_id-phone.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String userName = request.getParameter("name");
		String phone = request.getParameter("phone");
		String memberType = (String) session.getAttribute("memberType");
		String birth = request.getParameter("birth");
		String gender = request.getParameter("gender");
		
		UserDTO requestUser = new UserDTO();
		requestUser.setBirth(birth);
		requestUser.setGender(gender);
		
		MemberDTO requestMember = new MemberDTO();
		requestMember.setName(userName);
		requestMember.setPhone(phone);
		requestMember.setMemberType(memberType);
		requestMember.setUserInfo(requestUser);
		
		UserService userService = new UserService();
		
		MemberDTO findUserId = userService.findIdPhone(requestMember);
		
		String userId = findUserId.getId();
		System.out.println("userId : " + userId);
		
		String page = "";
		
		if(userId != null) {
			
			page = "/WEB-INF/views/common/success.jsp";
			
			request.setAttribute("success", "findId");
			request.setAttribute("userId", userId);
		} else {
			
			page = "/WEB-INF/views/common/failed.jsp";
			
			request.setAttribute("message", "정보가 일치하지 않습니다. 다시 시도해주세요.");
		}
		request.getRequestDispatcher(page).forward(request, response);
	}
}
