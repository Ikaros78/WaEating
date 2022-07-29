package com.waeating.admin.member.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.waeating.admin.member.service.AdminMemberService;
import com.waeating.member.model.dto.MemberDTO;

/**
 * Servlet implementation class MemberSelectDetailServlet
 */
@WebServlet("/admin/member/detail")
public class AdminMemberSelectDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memberId = (String) request.getSession().getAttribute("memberId");
		
		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("memberId", memberId);
		
		AdminMemberService memberService = new AdminMemberService();
		MemberDTO member = memberService.selectMemberDetail(searchMap);
		
		System.out.println(member);
		
		
		String path ="";
		if(member != null) {
			path = "/WEB-INF/views/admin/member/memberDetail.jsp";
			
			HttpSession session = request.getSession();
			session.setAttribute("path", path);
			session.setAttribute("member", member);
			
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "회원정보 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);

	}

}
