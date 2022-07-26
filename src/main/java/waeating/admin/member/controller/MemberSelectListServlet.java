package waeating.admin.member.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import waeating.admin.member.service.MemberService;
import waeating.common.paging.Pagenation;
import waeating.common.paging.SelectCriteria;
import waeating.member.model.dto.MemberDTO;

/**
 * Servlet implementation class AccountSelectListServlet
 */
@WebServlet("/admin/member/list")
public class MemberSelectListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberSelectListServlet() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;
		
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}
		
		if(pageNo <= 0) {
			pageNo = 1;
		}
		
		String searchCondition = request.getParameter("searchCondition");
		String searchValue = request.getParameter("searchValue");
		
		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("searchCondition", searchCondition);
		searchMap.put("searchValue", searchValue);
		
		MemberService memberService = new MemberService();
		int totalCount = memberService.selectTotalCount(searchMap);
		
		int limit = 10;
		int buttonAmount = 5;
		
		SelectCriteria selectCriteria = null;
		
		if(searchCondition != null && !"".equals(searchCondition)) {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
		}else {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		}
		
		List<MemberDTO> memberList = memberService.selectMemberList(selectCriteria);
		
		String path = "";
		if(memberList != null) {
			path= "/WEB-INF/views/admin/member/memberList.jsp";
			request.setAttribute("memberList", memberList);
			request.setAttribute("selectCriteria", selectCriteria);
			request.setAttribute("link", "list");
		}else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "게시물 목록 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
