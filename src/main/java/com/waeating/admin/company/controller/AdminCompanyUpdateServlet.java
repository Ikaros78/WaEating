package com.waeating.admin.company.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.waeating.admin.company.service.AdminCompanyService;
import com.waeating.admin.member.service.AdminMemberService;
import com.waeating.com.model.dto.ComInfoDTO;

/**
 * Servlet implementation class AdminCompanyUpdateServlet
 */
@WebServlet("/admin/company/update")
public class AdminCompanyUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ComInfoDTO company = (ComInfoDTO) request.getSession().getAttribute("com");
		/* 업체 회원 정보 */
		String id = company.getMemberInfo().getId();
		String name = request.getParameter("updateName");
		String pwd = request.getParameter("updatePwd");
		String email = request.getParameter("updateEmail");
		String phone = request.getParameter("updatePhone");
		
		/* 업체 정보 */
		String comNo = (String) request.getSession().getAttribute("comNo");
		String comName = request.getParameter("updateComName");
		String category = request.getParameter("updateCategory");
		String address = request.getParameter("updateComAddress");
		String comPhone = request.getParameter("updateComPhone");
		String regist = request.getParameter("updateComRegist");
		
		/* 업체 이력 정보 */
		String recordNo = String.valueOf(company.getRecordList().get(0).getRecordNo());
		String status = company.getRecordList().get(0).getStatus();
		String updateStatus = request.getParameter("updateStatus");
		
		boolean noMember = false;
		boolean noCompany = false;
		boolean noReason = false;
		
		Map<String, String> updateRecordMap = new HashMap<>();
		
		if(status.equals("거절")) {
			String reason = request.getParameter("updateReason");
			
			updateRecordMap.put("comNo", comNo);
			updateRecordMap.put("updateStatus", updateStatus);
			updateRecordMap.put("recordNo", recordNo);
			updateRecordMap.put("reason", reason);
			
			if(reason.length() == 0 && status.equals(updateStatus)) {
				/*업체 이력 정보 입력값이 없는 경우*/
				noReason = true;
			}
		}else {
			
			updateRecordMap.put("comNo", comNo);
			updateRecordMap.put("updateStatus", updateStatus);
			updateRecordMap.put("recordNo", recordNo);
			
			if(status.equals(updateStatus)) {
				
				noReason = true;
			}
		}
		
		System.out.println("원래 상태 " + status + " 바뀐 상태 " + updateStatus);
		
		Map<String, String> updateMemberMap = new HashMap<>();
		updateMemberMap.put("id",id);
		updateMemberMap.put("name",name);
		updateMemberMap.put("pwd",pwd);
		updateMemberMap.put("email",email);
		updateMemberMap.put("phone",phone);
		
		Map<String, String> updateCompanyMap = new HashMap<>();
		updateCompanyMap.put("comNo",comNo);
		updateCompanyMap.put("comName",comName);
		updateCompanyMap.put("category",category);
		updateCompanyMap.put("address",address);
		updateCompanyMap.put("comPhone",comPhone);
		updateCompanyMap.put("regist",regist);
		
		
		if(name.length() == 0 && pwd.length() == 0 && email.length() == 0 && phone.length() == 0) {
			/*업체 회원 정보 입력값이 없는 경우*/
			noMember = true; 
		}
		
		if(comName.length() == 0 && category.length() == 0 && address.length() == 0 && comPhone.length() == 0 && regist.length() ==0) {
			/*업체 정보 입력값이 없는 경우*/
			noCompany = true;
		}
		
		AdminCompanyService companyService = new AdminCompanyService();
		AdminMemberService memberService = new AdminMemberService();
		
		String path = "";
		
		if(noMember) {
			if(noCompany) {
				if(noReason) {
					/* 아무런 입력값이 없을 경우 */
					response.sendRedirect(request.getContextPath() + "/admin/cancle/session");
				}else {
					/* 업체 회원 정보와 업체 정보 입력값이 없는 경우 */
					int recordResult = companyService.updateCompanyStatus(updateRecordMap);
					
					if(recordResult > 0) {
						request.getSession().removeAttribute("ifUpdate");
						response.sendRedirect(request.getContextPath() + "/admin/company/detail");
					} else {
						path = "WEB-INF/views/common/failed.jsp";
						request.setAttribute("message", "업체정보 수정 실패!");
						request.getRequestDispatcher(path).forward(request, response);
					}
				}
			}else if(noReason) {
				/* 업체 회원 정보와 업체 이력 정보 입력값이 없는 경우 */
				int companyResult = companyService.updateCompany(updateCompanyMap);
				
				if(companyResult > 0) {
					request.getSession().removeAttribute("ifUpdate");
					response.sendRedirect(request.getContextPath() + "/admin/company/detail");
				} else {
					path = "WEB-INF/views/common/failed.jsp";
					request.setAttribute("message", "업체정보 수정 실패!");
					request.getRequestDispatcher(path).forward(request, response);
				}
			}else {
				/*업체 회원 정보 입력값이 없는 경우*/
				int companyResult = companyService.updateCompany(updateCompanyMap);
				int recordResult = companyService.updateCompanyStatus(updateRecordMap);
				
				if(companyResult > 0 && recordResult > 0) {
					request.getSession().removeAttribute("ifUpdate");
					response.sendRedirect(request.getContextPath() + "/admin/company/detail");
				} else {
					path = "WEB-INF/views/common/failed.jsp";
					request.setAttribute("message", "업체정보 수정 실패!");
					request.getRequestDispatcher(path).forward(request, response);
				}
			}
		}else if(noCompany) {
			
			if(noReason) {
				int memberResult = memberService.updateMember(updateMemberMap);
				
				if(memberResult > 0) {
					request.getSession().removeAttribute("ifUpdate");
					response.sendRedirect(request.getContextPath() + "/admin/company/detail");
				} else {
					path = "WEB-INF/views/common/failed.jsp";
					request.setAttribute("message", "업체정보 수정 실패!");
					request.getRequestDispatcher(path).forward(request, response);
				}
			}else {
				int memberResult = memberService.updateMember(updateMemberMap);
				int recordResult = companyService.updateCompanyStatus(updateRecordMap);
				
				if(memberResult > 0 && recordResult > 0) {
					request.getSession().removeAttribute("ifUpdate");
					response.sendRedirect(request.getContextPath() + "/admin/company/detail");
				} else {
					path = "WEB-INF/views/common/failed.jsp";
					request.setAttribute("message", "업체정보 수정 실패!");
					request.getRequestDispatcher(path).forward(request, response);
				}
			}
			
		}else if(noReason) {
			
			int memberResult = memberService.updateMember(updateMemberMap);
			int companyResult = companyService.updateCompany(updateCompanyMap);
			
			if(memberResult > 0 && companyResult > 0) {
				request.getSession().removeAttribute("ifUpdate");
				response.sendRedirect(request.getContextPath() + "/admin/company/detail");
			} else {
				path = "WEB-INF/views/common/failed.jsp";
				request.setAttribute("message", "업체정보 수정 실패!");
				request.getRequestDispatcher(path).forward(request, response);
			}
			
		}else {
			
			int memberResult = memberService.updateMember(updateMemberMap);
			int companyResult = companyService.updateCompany(updateCompanyMap);
			int recordResult = companyService.updateCompanyStatus(updateRecordMap);
			
			if(memberResult > 0 && companyResult > 0 && recordResult > 0) {
				request.getSession().removeAttribute("ifUpdate");
				response.sendRedirect(request.getContextPath() + "/admin/company/detail");
			} else {
				path = "WEB-INF/views/common/failed.jsp";
				request.setAttribute("message", "업체정보 수정 실패!");
				request.getRequestDispatcher(path).forward(request, response);
			}
		}
	}

}
