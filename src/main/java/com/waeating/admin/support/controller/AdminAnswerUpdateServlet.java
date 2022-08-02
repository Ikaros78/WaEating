package com.waeating.admin.support.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.waeating.admin.support.service.AdminSupportService;
import com.waeating.support.model.dto.ReportDTO;

/**
 * Servlet implementation class AdminAnswerUpdateServlet
 */
@WebServlet("/admin/reportAns/update")
public class AdminAnswerUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ReportDTO report = (ReportDTO) request.getSession().getAttribute("report");
		
		String ansNo = String.valueOf(report.getAnswer().getAnsNo());
		String content = request.getParameter("updateContent");
		String date = new SimpleDateFormat("yy-MM-dd").format(new java.sql.Date(System.currentTimeMillis()));
		
		System.out.println(ansNo);
		
		if(content.length() == 0 ) {
			
			response.sendRedirect(request.getContextPath() + "/admin/cancle/session");
		} else {
			
			Map<String, String> updateAnsMap = new HashMap<>();
			updateAnsMap.put("ansNo", ansNo);
			updateAnsMap.put("content", content);
			updateAnsMap.put("date", date);
			
			AdminSupportService supportService = new AdminSupportService();
			int result = supportService.updateAns(updateAnsMap);
			
			if(result > 0) {
				request.getSession().removeAttribute("ifUpdate");
				response.sendRedirect(request.getContextPath() + "/admin/report/detail");
			} else {
				String path = "WEB-INF/views/common/failed.jsp";
				request.setAttribute("message", "문의 답변 정보 수정 실패!");
				request.getRequestDispatcher(path).forward(request, response);
			}
		}
	}

}
