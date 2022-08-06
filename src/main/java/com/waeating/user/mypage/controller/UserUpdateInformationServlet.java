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
 * Servlet implementation class UpdateUserInformationServlet
 */
@WebServlet("/member/user/update/information")
public class UserUpdateInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		request.getRequestDispatcher("/WEB-INF/views/user/user-mypage/user-update.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");
		
		String userId = loginMember.getId();
		String name = request.getParameter("name");
		String pw = request.getParameter("pw");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		MemberDTO requestMember = new MemberDTO();
		requestMember.setId(userId);
		requestMember.setName(name);
		requestMember.setPwd(pw);
		requestMember.setPhone(phone);
		requestMember.setEmail(email);
		
		System.out.println("requestMember : " + requestMember);
		
		UserService userService =  new UserService();
		
		int result = userService.updateUserInformation(requestMember);
		
		System.out.println("result : " + result);
		
		String page = "";
		
		if(result > 0 ) {
			
			page = "/WEB-INF/views/common/success.jsp";
			
			request.setAttribute("success", "updateUser");
		} else {
			
			page = "/WEB-INF/views/common/failed.jsp";
			
			request.setAttribute("message", "정보수정에 실패하셨습니다. 다시 시도해주세요.");
		}
		request.getRequestDispatcher(page).forward(request, response);
		
	}

}
