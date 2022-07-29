package com.waeating.admin.company.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.waeating.admin.company.service.AdminCompanyService;
import com.waeating.admin.member.service.AdminMemberService;
import com.waeating.com.model.dto.ComInfoDTO;

/**
 * Servlet implementation class AdminCompanyDeleteServlet
 */
@WebServlet("/admin/company/delete")
public class AdminCompanyDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ComInfoDTO company = (ComInfoDTO) request.getSession().getAttribute("com"); 
		String comNo = (String) request.getSession().getAttribute("comNo");
		String id = company.getMemberInfo().getId();
		
		System.out.println(id);
		
		AdminCompanyService companyService = new AdminCompanyService();
		AdminMemberService memberService = new AdminMemberService();
		
		int companyResult = companyService.deleteCompany(comNo);
		int memberResult = memberService.deleteMember(id);
		
		if(companyResult > 0 && memberResult > 0) {
			response.sendRedirect(request.getContextPath() + "/admin/company/list");
		} else {
			String path = "WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "업체정보 삭제 실패!");
			request.getRequestDispatcher(path).forward(request, response);
		}
	}

}
