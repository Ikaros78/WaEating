package com.waeating.ceo.mypage.controller;

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
import com.waeating.user.login.model.service.UserService;

/**
 * Servlet implementation class CeoUpdateInformationServlet
 */
@WebServlet("/member/ceo/update/information")
public class CeoUpdateInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		request.getRequestDispatcher("/WEB-INF/views/ceo/ceo-mypage/ceo-update.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		MemberDTO ceo = (MemberDTO) session.getAttribute("loginMember");
		
		String ceoId = ceo.getId();
		String name = request.getParameter("name");
		String pw = request.getParameter("pw");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String business = request.getParameter("business");
		
		ComInfoDTO requestCom = new ComInfoDTO();
		requestCom.setMemberId(ceoId);
		requestCom.setComRegist(business);
		
		MemberDTO requestMember = new MemberDTO();
		requestMember.setId(ceoId);
		requestMember.setName(name);
		requestMember.setPwd(pw);
		requestMember.setPhone(phone);
		requestMember.setEmail(email);
		
		System.out.println("requestMember : " + requestMember);
		
		ComService comService = new ComService();
		
		int resultMember = comService.updateCeoInformation(requestMember);
		int resultCom = comService.updaupdateComRegist(requestCom);
		
		System.out.println("resultMember : " + resultMember);
		System.out.println("resultCom : " + resultCom);
		
		String page = "";
		
		if(resultMember > 0 && resultCom > 0 ) {
			
			MemberDTO loginMember = comService.newCeoInfo(requestMember); 
			
			session.setAttribute("loginMember", loginMember);
			
			page = "/WEB-INF/views/common/success.jsp";
			
			request.setAttribute("success", "updateCeo");
		} else {
			
			page = "/WEB-INF/views/common/failed.jsp";
			
			request.setAttribute("message", "정보 수정에 실패하셨습니다. 다시 시도해주세요.");
		}
		request.getRequestDispatcher(page).forward(request, response);
		
	}

}
