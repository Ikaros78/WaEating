package com.waeating.ceo.login.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.waeating.ceo.login.model.service.ComService;

/**
 * Servlet implementation class CheckUserIdServlet
 */
@WebServlet("/member/ceo/ckeckId")
public class CheckCeoIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String ceoId = request.getParameter("ceoId");
		System.out.println("ceoId : " + ceoId);
		
		ComService comService = new ComService();
		
		int result = comService.dubleCkId(ceoId);
		
		System.out.println("result : " + result);
		
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.print(result);
		
		out.flush();
		out.close();
	} 

}
