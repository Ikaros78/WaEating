package com.waeating.admin.support.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.waeating.member.model.dto.MemberDTO;

/**
 * Servlet implementation class AdminFAQInsertServlet
 */
@WebServlet("/admin/faq/insertForm")
public class AdminFAQInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDTO admin = (MemberDTO) request.getSession().getAttribute("loginMember"); 
		
		String adminId = admin.getId();
		
		System.out.println(adminId);
		
		
		String path = "/WEB-INF/views/admin/support/supportFAQInsert.jsp";
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
