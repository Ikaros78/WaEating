package com.waeating.ceo.login.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.waeating.ceo.login.model.service.ComService;
import com.waeating.com.model.dto.ComInfoDTO;
import com.waeating.member.model.dto.MemberDTO;

/**
 * Servlet implementation class CeoFindPasswordServlet
 */
@WebServlet("/member/ceo/findpw/email")
public class CeoFindPasswordEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		request.getRequestDispatcher("/WEB-INF/views/ceo/ceo-login/ceo-find_pw-email.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String ceoId = request.getParameter("id");
		String ceoName = request.getParameter("name");
		String email = request.getParameter("email");
		String comName = request.getParameter("store_name");
		String comNum = request.getParameter("store_phone");
		String category = request.getParameter("category");
		
		String pw = request.getParameter("pw");
		
		ComInfoDTO requestCom = new ComInfoDTO();
		requestCom.setComName(comName);
		requestCom.setComPhone(comNum);
		requestCom.setCategory(category);
		
		MemberDTO requestMember = new MemberDTO();
		requestMember.setId(ceoId);
		requestMember.setName(ceoName);
		requestMember.setEmail(email);
		requestMember.setPwd(pw);
		requestMember.setComInfo(requestCom);
		
		ComService comService = new ComService();
		
		MemberDTO checkPwd = comService.checkPwdEmail(requestMember);
		System.out.println("checkPwd: " + checkPwd);
		
		String pwd = checkPwd.getPwd();
		System.out.println("pwd : " + pwd);
		
		String page = "";
		
		if(pwd != null) {
			
			int updateNewPwd = comService.updateNewPwd(requestCom);
			System.out.println("updatePwd : " + updateNewPwd);
			
			page = "/WEB-INF/views/common/success.jsp";
			
			request.setAttribute("success", "updateCeoPwd");
		} else {
			
			page = "/WEB-INF/views/common/failed.jsp";
			
			request.setAttribute("message", "정보가 일치하지 않습니다. 다시 시도해주세요.");
		}
		request.getRequestDispatcher(page).forward(request, response);
		
	}

}
