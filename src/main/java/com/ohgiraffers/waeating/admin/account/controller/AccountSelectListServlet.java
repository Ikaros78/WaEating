package com.ohgiraffers.waeating.admin.account.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AccountSelectListServlet
 */
@WebServlet("/admin/account/list")
public class AccountSelectListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AccountSelectListServlet() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "";
		path= "/WEB-INF/views/admin/account/accountList.jsp";
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
