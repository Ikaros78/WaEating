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
@WebServlet("/member/user/findpw/phone")
public class UserFindPasswordPhoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		request.getRequestDispatcher("/WEB-INF/views/user/user-login/user-find_pw-phone.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String userId = request.getParameter("id");
		String userName = request.getParameter("name");
		String phone = request.getParameter("phone");
		String memberType = (String) session.getAttribute("memberType");
		String birth = request.getParameter("birth");
		String gender = request.getParameter("gender");
		
		String pw = request.getParameter("pw");
		
		UserDTO requestUser = new UserDTO();
		requestUser.setBirth(birth);
		requestUser.setGender(gender);
		
		MemberDTO requestMember = new MemberDTO();
		requestMember.setId(userId);
		requestMember.setName(userName);
		requestMember.setPhone(phone);
		requestMember.setMemberType(memberType);
		requestMember.setUserInfo(requestUser);
		
		requestMember.setPwd(pw);
		System.out.println("pw : " + pw);
		
		UserService userService = new UserService();
		
		MemberDTO checkPwd =  userService.checkPwdPhone(requestMember);
		System.out.println("checkPwd: " + checkPwd);
		String pwd = checkPwd.getPwd();
		System.out.println("pwd: " + pwd);
		
		String page = "";
		
		if(pwd != null) {
			
			int updateNewPwd = userService.updateNewPwd(requestMember);
			System.out.println("updatePwd : " + updateNewPwd);
			
			page = "/WEB-INF/views/common/success.jsp";
			
			request.setAttribute("success", "updatePwd");
		} else {
			
			page = "/WEB-INF/views/common/failed.jsp";
			
			request.setAttribute("message", "정보가 일치하지 않습니다. 다시 시도해주세요.");
		}
		request.getRequestDispatcher(page).forward(request, response);
			
	}

}
