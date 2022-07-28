package com.waeating.admin.company.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminCompanyUpdateServlet
 */
@WebServlet("/admin/company/update")
public class AdminCompanyUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* 업체 회원 정보 */
		String id = (String) request.getSession().getAttribute("memberId");
		String name = request.getParameter("updateName");
		String pwd = request.getParameter("updatePwd");
		String email = request.getParameter("updateEmail");
		String phone = request.getParameter("updatePhone");
		
		/* 업체 정보 */
		String comName = request.getParameter("updateComName");
		String category = request.getParameter("updateCategory");
		String address = request.getParameter("updateComAddress");
		String comPhone = request.getParameter("updateComPhone");
		String regist = request.getParameter("updateComRegist");
		
		/* 업체 이력 정보 */
		String reason = request.getParameter("updateReason");
	}

}
