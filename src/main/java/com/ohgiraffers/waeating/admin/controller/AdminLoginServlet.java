package com.ohgiraffers.waeating.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ohgiraffers.waeating.admin.service.AdminService;
import com.ohgiraffers.waeating.member.model.dto.MemberDTO;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/admin/login")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		request.getRequestDispatcher("/WEB-INF/views/admin/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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

		String path = "";
		if (loginMember != null) {

			session.setAttribute("loginMember", loginMember);
			path = "/WEB-INF/views/admin/main.jsp";

			/* response.sendRedirect(path); */ // 안되는중
			request.getRequestDispatcher(path).forward(request, response); // 가능
		} else {

			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "로그인 실패");
			request.getRequestDispatcher(path).forward(request, response);
		}
	}

}
