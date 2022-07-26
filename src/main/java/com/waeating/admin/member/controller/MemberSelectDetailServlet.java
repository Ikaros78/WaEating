package com.waeating.admin.member.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.waeating.admin.member.service.MemberService;
import com.waeating.member.model.dto.MemberDTO;

/**
 * Servlet implementation class MemberSelectDetailServlet
 */
@WebServlet("/admin/member/detail")
public class MemberSelectDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memberId = request.getParameter("memberId");
		
		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("memberId", memberId);
		
		MemberService memberService = new MemberService();
		MemberDTO member = memberService.selectMemberDetail(searchMap);
		
		System.out.println(member);
		
		String path ="";
		if(member != null) {
			path= "/WEB-INF/views/admin/member/memberDetail.jsp";
			request.setAttribute("member", member);
		} else {
			path= "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "회원정보 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);

	}

}
