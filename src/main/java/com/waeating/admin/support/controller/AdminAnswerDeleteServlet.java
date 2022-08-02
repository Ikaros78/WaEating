package com.waeating.admin.support.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.waeating.admin.support.service.AdminSupportService;
import com.waeating.support.model.dto.ReportAnswerDTO;
import com.waeating.support.model.dto.ReportDTO;

/**
 * Servlet implementation class AdminAnswerDeleteServlet
 */
@WebServlet("/admin/reportAns/delete")
public class AdminAnswerDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ReportDTO report = (ReportDTO) request.getSession().getAttribute("report");
		
		String ansNo = String.valueOf(report.getAnswer().getAnsNo());
		
		AdminSupportService supportService = new AdminSupportService();
		
		int result = supportService.deleteAns(ansNo);
		
		if(result > 0) {
			request.getSession().removeAttribute("ifUpdate");
			response.sendRedirect(request.getContextPath() + "/admin/report/detail");
		}else {
			String path = "WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "문의 답변 삭제 실패!");
			request.getRequestDispatcher(path).forward(request, response);
		}
	}

}
