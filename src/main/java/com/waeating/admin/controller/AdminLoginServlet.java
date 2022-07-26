package com.waeating.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.waeating.admin.service.AdminService;
import com.waeating.member.model.dto.MemberDTO;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/admin/login")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
<<<<<<< HEAD
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
				
		request.getRequestDispatcher("/WEB-INF/views/admin/login.jsp").forward(request, response);
	}




	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String adminId = request.getParameter("id");
		String pwd = request.getParameter("password");
		String memberType = (String) session.getAttribute("memberType");
		
		System.out.println("adminId : " + adminId);
		System.out.println("password : " + pwd);
		System.out.println("memberTye : " + memberType);
		
		MemberDTO requestMember = new MemberDTO();
		requestMember.setId(adminId);
		requestMember.setPwd(pwd);
		requestMember.setMemberType(memberType);
		
		AdminService adminService = new AdminService();
		
		MemberDTO loginMember = adminService.loginCheck(requestMember);
		System.out.println(loginMember);
		
		if(loginMember != null) {
			
			session.setAttribute("loginMember", loginMember);
			
			response.sendRedirect(request.getContextPath());
		} else {
			
			request.setAttribute("message", "로그인 실패");
			request.getRequestDispatcher("/WEB-INF/views/common/failed.jsp").forward(request, response);
=======

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
				
		request.getRequestDispatcher("/WEB-INF/views/admin/login.jsp").forward(request, response);
	}




	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String adminId = request.getParameter("id");
		String pwd = request.getParameter("password");
		String memberType = (String) session.getAttribute("memberType");
		
		System.out.println("adminId : " + adminId);
		System.out.println("password : " + pwd);
		System.out.println("memberTye : " + memberType);
		
		MemberDTO requestMember = new MemberDTO();
		requestMember.setId(adminId);
		requestMember.setPwd(pwd);
		requestMember.setMemberType(memberType);
		
		AdminService adminService = new AdminService();
		
		MemberDTO loginMember = adminService.loginCheck(requestMember);
		System.out.println(loginMember);
		
		if(loginMember != null) {
			
			session.setAttribute("loginMember", loginMember);
			
			response.sendRedirect(request.getContextPath());
		} else {
			
			request.setAttribute("message", "로그인 실패");
			request.getRequestDispatcher("/WEB-INF/views/common/failed.jsp").forward(request, response);



	
>>>>>>> refs/remotes/origin/master
		}
	}

}
