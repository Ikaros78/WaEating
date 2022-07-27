package com.waeating.admin.member.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.waeating.admin.member.service.AdminMemberService;

/**
 * Servlet implementation class AdminMemberUpdateServlet
 */
@WebServlet("/admin/member/update")
public class AdminMemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String id = (String) request.getSession().getAttribute("memberId");
		String name = request.getParameter("updateName");
		String pwd = request.getParameter("updatePwd");
		String email = request.getParameter("updateEmail");
		String birth = request.getParameter("updateBirth");
		String gender = request.getParameter("updateGender");
		String phone = request.getParameter("updatePhone");

		System.out.println(id);
		System.out.println(name);
		System.out.println(birth);
		System.out.println(gender);
		
		AdminMemberService memberService = new AdminMemberService();
		
		String path = "";
		
		if(name.length() == 0 && pwd.length() ==0 && email.length() == 0 && birth.length() == 0 && phone.length() == 0 || gender.length() == 2) {
			/* 아무런 입력값이 없거나 성별이 없음인 경우 */
			response.sendRedirect(request.getContextPath() + "/admin/cancle/session");
			
		}else if(name.length() == 0 && pwd.length() ==0 && email.length() == 0 && phone.length() == 0){
			/* member 영역 입력값이 없는 경우 */
			
			Map<String, String> updateUserMap = new HashMap<>();
			updateUserMap.put("id",id);
			updateUserMap.put("birth",birth);
			updateUserMap.put("gender",gender);
			
			int userResult = memberService.updateUser(updateUserMap);
			
			if(userResult > 0) {
				response.sendRedirect(request.getContextPath() + "/admin/member/detail");
				request.getSession().removeAttribute("ifUpdate");
			}else {
				path = "WEB-INF/views/common/failed.jsp";
				request.setAttribute("message", "회원정보 수정 실패!");
				request.getRequestDispatcher(path).forward(request, response);
			}
			
		}else if(gender.length() == 2 && birth.length() == 0) {
			/* user 영역 입력값이 없는 경우 */
			
			Map<String, String> updateMemberMap = new HashMap<>();
			updateMemberMap.put("id",id);
			updateMemberMap.put("name",name);
			updateMemberMap.put("pwd",pwd);
			updateMemberMap.put("email",email);
			updateMemberMap.put("phone",phone);
			
			int memberResult = memberService.updateMember(updateMemberMap);
			
			if(memberResult > 0) {
				response.sendRedirect(request.getContextPath() + "/admin/member/detail");
				request.getSession().removeAttribute("ifUpdate");
			}else {
				path = "WEB-INF/views/common/failed.jsp";
				request.setAttribute("message", "회원정보 수정 실패!");
				request.getRequestDispatcher(path).forward(request, response);
			}
			
		}else {
				
			Map<String, String> updateMemberMap = new HashMap<>();
			updateMemberMap.put("id",id);
			updateMemberMap.put("name",name);
			updateMemberMap.put("pwd",pwd);
			updateMemberMap.put("email",email);
			updateMemberMap.put("phone",phone);
			
			Map<String, String> updateUserMap = new HashMap<>();
			updateUserMap.put("id",id);
			updateUserMap.put("birth",birth);
			updateUserMap.put("gender",gender);
			
			int memberResult = memberService.updateMember(updateMemberMap);
			int userResult = memberService.updateUser(updateUserMap);
			
			if(memberResult > 0 && userResult > 0) {
				response.sendRedirect(request.getContextPath() + "/admin/member/detail");
				request.getSession().removeAttribute("ifUpdate");
			} else {
				path = "WEB-INF/views/common/failed.jsp";
				request.setAttribute("message", "회원정보 수정 실패!");
				request.getRequestDispatcher(path).forward(request, response);
			}
		}
		
	}

}
