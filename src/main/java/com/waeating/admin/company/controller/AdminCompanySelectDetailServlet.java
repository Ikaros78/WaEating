package com.waeating.admin.company.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.waeating.admin.company.service.AdminCompanyService;
import com.waeating.com.model.dto.ComInfoDTO;

/**
 * Servlet implementation class AdminCompanySelectDetailServlet
 */
@WebServlet("/admin/company/detail")
public class AdminCompanySelectDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String comNo = (String) request.getSession().getAttribute("comNo");
		
		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("comNo", comNo);
		
		AdminCompanyService companyService = new AdminCompanyService();
		ComInfoDTO company = companyService.selectCompanyDetail(searchMap); 
		
		System.out.println(company);
		
		String path = "";
		
		if(company != null) {
			path = "/WEB-INF/views/admin/company/companyDetail.jsp";
			
			request.getSession().setAttribute("path", path);
			request.getSession().setAttribute("com", company);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "업체정보 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
