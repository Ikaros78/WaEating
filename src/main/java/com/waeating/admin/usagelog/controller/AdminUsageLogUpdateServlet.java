package com.waeating.admin.usagelog.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.waeating.admin.usagelog.service.AdminUsageLogService;

/**
 * Servlet implementation class AdminUsageLogUpdateServlet
 */
@WebServlet("/admin/usageLog/update")
public class AdminUsageLogUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String recordNo = (String) request.getSession().getAttribute("recordNo");
		String status = request.getParameter("updateStatus");
		String memberNum = request.getParameter("updateMemberNum");
		String requirement = request.getParameter("updateRequirement");
		String memo = request.getParameter("updateMemo");
		
		Map<String, String> updateLogMap = new HashMap<>();
		updateLogMap.put("recordNo", recordNo);
		updateLogMap.put("status", status);
		updateLogMap.put("memberNum", memberNum);
		updateLogMap.put("requirement", requirement);
		updateLogMap.put("memo", memo);
		
		AdminUsageLogService logService = new AdminUsageLogService();
		
		if(status.length() == 0 && memberNum.length() == 0 && requirement.length() == 0 && memo.length() == 0) {
			response.sendRedirect(request.getContextPath() + "/admin/cancle/session");
		} else {
			
			int result = logService.adminUpdateLog(updateLogMap);
			
			if(result > 0) {
				request.getSession().removeAttribute("ifUpdate");
				response.sendRedirect(request.getContextPath() + "/admin/usageLog/detail");
			} else {
				String path = "WEB-INF/views/common/failed.jsp";
				request.setAttribute("message", "이용이력 정보 수정 실패!");
				request.getRequestDispatcher(path).forward(request, response);
			}
		}
	}

}
