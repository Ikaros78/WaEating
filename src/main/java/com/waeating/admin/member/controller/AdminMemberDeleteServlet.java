package com.waeating.admin.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.waeating.admin.member.service.AdminMemberService;

/**
 * Servlet implementation class AdminMemberDeleteServlet
 */
@WebServlet("/admin/member/delete")
public class AdminMemberDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = (String) request.getSession().getAttribute("memberId");
		
		AdminMemberService memberService = new AdminMemberService();
		
		int result = memberService.deleteMember(id);
		
			String path = "";
		if(result > 0) {
			path = "WEB-INF/views/admin/member/memberList.jsp";
			response.sendRedirect(request.getContextPath() + "/admin/member/list");
		} else {
			path = "WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "회원정보 삭제 실패!");
			request.getRequestDispatcher(path).forward(request, response);
		}
		
	}

}
