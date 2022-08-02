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
import com.waeating.waitingRecord.model.dto.WaitingRecordDTO;

/**
 * Servlet implementation class AdminUsageLogSelectDetailServlet
 */
@WebServlet("/admin/usageLog/detail")
public class AdminUsageLogSelectDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String recordNo = (String) request.getSession().getAttribute("recordNo");
		
		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("recordNo", recordNo);
		
		AdminUsageLogService logService = new AdminUsageLogService();
		WaitingRecordDTO log = logService.adminSelectLogDetail(searchMap);
		
		
		
		String path = "";
		
		if(log != null) {
			path = "/WEB-INF/views/admin/usageLog/usageLogDetail.jsp";
			
			String status = log.getUseStatus();
			if(status.equals("cancel")) {
				String reason = logService.adminSelectRefuseLogDetail(searchMap);
				request.getSession().setAttribute("reason", reason);
			}
			
			request.getSession().setAttribute("path", path);
			request.getSession().setAttribute("log", log);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "이용이력정보 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
