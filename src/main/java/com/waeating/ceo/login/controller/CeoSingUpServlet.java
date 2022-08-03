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
 * Servlet implementation class CeoSingUpServlet
 */
@WebServlet("/member/ceo/signup")
public class CeoSingUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		request.getRequestDispatcher("/WEB-INF/views/ceo/ceo-login/ceo-sign_up.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		
		String ceoId = request.getParameter("id");
		String ceoName = request.getParameter("name");
		String ceoPw = request.getParameter("pw");
		String memberType = (String) session.getAttribute("memberType");
		String ceoPhone = request.getParameter("phone");
		String ceoEmail = request.getParameter("email");
		String storeName = request.getParameter("store_name");
		String strorePhone = request.getParameter("store_phone");
		String address = request.getParameter("strore_address");
		String category = request.getParameter("category");
		String business = request.getParameter("business");
		
		MemberDTO requestMember = new MemberDTO();
		requestMember.setId(ceoId);
		requestMember.setName(ceoName);
		requestMember.setPwd(ceoPw);
		requestMember.setMemberType(memberType);
		requestMember.setPhone(ceoPhone);
		requestMember.setEmail(ceoEmail);
		
		ComInfoDTO requestCom = new ComInfoDTO();
		requestCom.setMemberId(ceoId);
		requestCom.setComName(storeName);
		requestCom.setCategory(category);
		requestCom.setComPhone(strorePhone);
		requestCom.setComAddress(address);
		requestCom.setComRegist(business);
		
		System.out.println("requestMember : " + requestMember);
		System.out.println("requestCom : " + requestCom);
		
		ComService comService= new ComService();
		
		int resultMember = comService.registMember(requestMember);
		int resultCom = comService.registCom(requestCom);
		
		System.out.println("resultMember 확인 : " + resultMember);
		System.out.println("resultCom 확인 : " + resultCom);
		
		String page = "";
		
		if(resultCom > 0 && resultMember > 0) {
			
			page = "/WEB-INF/views/common/success.jsp";
			
			request.setAttribute("success", "insertCeo");
		} else {
			
			page = "/WEB-INF/views/common/failed.jsp";
			
			request.setAttribute("message", "회원가입에 실패하셨습니다. 다시 시도해주세요.");
		}
		request.getRequestDispatcher(page).forward(request, response);
	}

}
