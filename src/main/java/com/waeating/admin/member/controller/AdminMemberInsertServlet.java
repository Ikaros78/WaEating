package com.waeating.admin.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.waeating.admin.member.service.AdminMemberService;

/**
 * Servlet implementation class AdminMemberInsertServlet
 */
@WebServlet("/admin/member/insert")
public class AdminMemberInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String path = "/WEB-INF/views/admin/member/memberInsert.jsp";
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		Map<String, String> adminMap = new HashMap<>();
		adminMap.put("id", id);
		adminMap.put("pwd", pwd);
		adminMap.put("name", name);
		adminMap.put("email", email);
		adminMap.put("phone", phone);
		
		System.out.println(adminMap);
		
		AdminMemberService memberService = new AdminMemberService();
		int result = memberService.insertAdmin(adminMap);
		
		
		if(result > 0) {
			
			response.setCharacterEncoding("utf-8");
			
			response.setContentType("text/html; charset=UTF-8");
			
			PrintWriter out = response.getWriter();
			out.println("<script>alert('관리자 회원가입에 성공했습니다.'); location.href='list';</script>");
			
			out.flush();
			out.close();
		} else {
			
			String path = "WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "관리자 회원가입 실패!");
			request.getRequestDispatcher(path).forward(request, response);
		}
		
	}

}
