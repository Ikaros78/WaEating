package com.waeating.admin.notice.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.waeating.admin.notice.service.AdminNoticeService;
import com.waeating.notice.model.dto.NoticeAttachDTO;

/**
 * Servlet implementation class AdminNoticeDeleteServlet
 */
@WebServlet("/admin/notice/delete")
public class AdminNoticeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String noticeNo = (String) request.getSession().getAttribute("noticeNo");
		
		AdminNoticeService noticeService = new AdminNoticeService();
		
		Map<String, String> noticeNoMap = new HashMap<>();
		noticeNoMap.put("noticeNo", noticeNo);
		List<NoticeAttachDTO> deleteList = noticeService.selectNoticeAttachList(noticeNoMap);
		
		int result = noticeService.deleteNotice(noticeNo);
		
		if(result > 0) {
			
			if(deleteList.size() > 0) {
				
				String rootLocation = getServletContext().getRealPath("/");
				String fileUploadDirectory = rootLocation + "/resources/upload/notice/origin/";
				
				int cnt = 0;
				for(int i = 0; i < deleteList.size(); i++) {
					NoticeAttachDTO file = deleteList.get(i);
						
					File deleteFile = new File(fileUploadDirectory + "/" + file.getFileName());
					boolean isDeleted = deleteFile.delete();
						
					if(isDeleted) {
						cnt++;
					}
				}
				if(cnt == deleteList.size()) {
					System.out.println("기존 모든 사진 삭제 완료!");
				}
				request.getSession().removeAttribute("ifUpdate");
				response.sendRedirect(request.getContextPath() + "/admin/notice/list");
			}else {
				request.getSession().removeAttribute("ifUpdate");
				response.sendRedirect(request.getContextPath() + "/admin/notice/list");
			}
		}else {
			String path = "WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "공지사항 삭제 실패!");
			request.getRequestDispatcher(path).forward(request, response);
		}
	}

}
