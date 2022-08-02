package com.waeating.admin.support.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.waeating.admin.support.service.AdminSupportService;

/**
 * Servlet implementation class AdminAnswerInsertServlet
 */
@WebServlet("/admin/reportAns/insert")
public class AdminAnswerInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String reportNo = (String) request.getSession().getAttribute("reportNo");
		String content = request.getParameter("insertContent");
		String date = new SimpleDateFormat("yy-MM-dd").format(new java.sql.Date(System.currentTimeMillis()));
		
		Map<String, String> insertAnsMap = new HashMap<>();
		insertAnsMap.put("reportNo", reportNo);
		insertAnsMap.put("content", content);
		insertAnsMap.put("date", date);
		
		AdminSupportService supportService = new AdminSupportService();
		
		if(content.length() == 0) {
			
			/* 수정 필요 */
			response.setContentType("text/html; charset=UTF-8");
			
			PrintWriter out = response.getWriter();
			out.println("<script>alert('내용을 다시 입력해주세요.'); location.href='detail';</script>");
			
			out.flush();
			out.close();
		} else {
			
			int result = supportService.insertAns(insertAnsMap);
			
			if(result > 0) {
				request.getSession().removeAttribute("ifUpdate");
				response.sendRedirect(request.getContextPath() + "/admin/report/detail");
			} else {
				String path = "WEB-INF/views/common/failed.jsp";
				request.setAttribute("message", "문의 답변 정보 등록 실패!");
				request.getRequestDispatcher(path).forward(request, response);
			}
		}
	}

}
