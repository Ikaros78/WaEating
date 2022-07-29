package com.waeating.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.waeating.member.model.dto.MemberDTO;
import com.waeating.notice.model.dto.NoticeDTO;
import com.waeating.notice.model.service.NoticeService;

/**
 * Servlet implementation class NoticeInsertServlet
 */
@SuppressWarnings("unused")
@WebServlet("/notice/insert")
public class NoticeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	  String path ="/WEB-INF/views/mainNotice/noticeList.jsp";
	  
	  System.out.println(path);
	  
	  request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String noticeTitle = request.getParameter("noticeTitle");
		String noticeContent = request.getParameter("noticeContent");
        
        NoticeDTO newNotice = new NoticeDTO();
        newNotice.setNoticeTitle(noticeTitle);
        newNotice.setNoticeContent(noticeContent);
        
        NoticeService noticeService = new NoticeService();
        int result = noticeService.insertNotice(newNotice);
        
        System.out.println(result);
        
        String path = "";
        if(result > 0) {
        	path = "WEB-INF/views/common/success.jsp";
        	request.setAttribute("successCode", "insertNotice");
        	} else {
        		path = "WEB-INF/views/common/failed.jsp";
        		request.setAttribute("message", "공지사항 등록에 실패하셨습니다");
        	}
           
               request.getRequestDispatcher(path).forward(request,response);
	}

}
