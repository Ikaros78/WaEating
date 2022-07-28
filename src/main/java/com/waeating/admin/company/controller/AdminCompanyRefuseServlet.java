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
 * Servlet implementation class AdminCompanyRefuseServlet
 */
@WebServlet("/admin/company/refuse")
public class AdminCompanyRefuseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ComInfoDTO company = (ComInfoDTO) request.getSession().getAttribute("com");
		String comNo = String.valueOf(company.getComNo());
		String recordNo = String.valueOf(company.getRecordList().get(0).getRecordNo());
		
		String reason = request.getParameter("reason");
		System.out.println(reason);
		
		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("comNo", comNo);
		searchMap.put("recordNo", recordNo);
		searchMap.put("reason", reason);
		
		AdminCompanyService companyService = new AdminCompanyService();
		
		int result = companyService.refuseCompanyStatus(searchMap);
		
		if(result > 0) {
			response.sendRedirect(request.getContextPath() + "/admin/company/detail");
		} else {
			String path = "WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "업체 거절 실패!");
			request.getRequestDispatcher(path).forward(request, response);
		}
	}

}
