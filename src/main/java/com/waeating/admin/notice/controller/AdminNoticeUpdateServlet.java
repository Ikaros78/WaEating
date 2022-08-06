package com.waeating.admin.notice.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.waeating.admin.notice.service.AdminNoticeService;
import com.waeating.member.model.dto.MemberDTO;
import com.waeating.notice.model.dto.NoticeAttachDTO;
import com.waeating.notice.model.dto.NoticeDTO;

/**
 * Servlet implementation class AdminNoticeUpdateServlet
 */
@WebServlet("/admin/notice/update")
public class AdminNoticeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(ServletFileUpload.isMultipartContent(request)) {
			
			String rootLocation = getServletContext().getRealPath("/");
			int maxFileSize = 1024 * 1024 * 10;
			String encodingType = "UTF-8";
			
			System.out.println("파일 저장 ROOT 경로 : " + rootLocation);
			System.out.println("최대 업로드 파일 용량 : " + maxFileSize);
			System.out.println("인코딩 방식 : " + encodingType);
			
			String fileUploadDirectory = rootLocation + "/resources/upload/notice/origin/";
			
			File directory = new File(fileUploadDirectory);
			
			/* 파일 저장경로가 존재하지 않는 경우 디렉토리를 생성한다. */
			if(!directory.exists()) {
				/* 폴더를 한 개만 생성할거면 mkdir, 상위 폴더도 존재하지 않으면 한 번에 생성하란 의미로 mkdirs를 이용한다. */
				System.out.println("폴더 생성 : " + directory.mkdirs());
			}
			
			/* 이게 최종적으로 request를 parsing하고 파일을 저장한 뒤 필요한 내용을 담을 리스트와 맵이다.
			 * 파일에 대한 정보는 리스트에, 다른 파라미터의 정보는 모두 맵에 담을 것이다.
			 * */
			Map<String, String> parameter = new HashMap<>();
			List<Map<String, String>> fileList = new ArrayList<>();
			
			/* 파일을 업로드할 시 최대 크기나 임시 저장할 폴더의 경로 등을 포함하기 위한 인스턴스이다. */
			DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
	        fileItemFactory.setRepository(new File(fileUploadDirectory));
	        fileItemFactory.setSizeThreshold(maxFileSize);
	        
	        /* 서블릿에서 기본 제공하는거 말고 꼭 commons fileupload 라이브러이에 있는 클래스로 임포트 해야 한다. */
	        ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
	        
	        try {
	        	/* request를 파싱하여 데이터 하나 하나를 FileItem 인스턴로 반환한다. */
				List<FileItem> fileItems = fileUpload.parseRequest(request);
				
				for(FileItem item : fileItems) {
					/* 폼 데이터는 isFormField 속성이 true이고, 파일은 isFormField 속성이 false이다. */
					System.out.println(item);
				}
				
				/* 위에서 출력해본 모든 item들을 다 처리할 것이다. */
				for(int i = 0; i < fileItems.size(); i++) {
					FileItem item = fileItems.get(i);
					
					if(!item.isFormField()) {
						
						/* 파일 데이터인 경우 */
						if(item.getSize() > 0) {
							
							/* 파일의 사이즈가 0보다 커야 전송된 파일이 있다는 의미이다. 
							 * 전송된 파일이 있는 경우에만 처리하고, 0인 경우에는 무시하도록 로직을 작성한다.
							 * */
							String filedName = item.getFieldName();
							String originFileName = item.getName();
							
							int dot = originFileName.lastIndexOf(".");
							String ext = originFileName.substring(dot);
							
							String randomFileName = UUID.randomUUID().toString().replace("-", "") + ext;
							
							/* 저장할 파일 정보를 담은 인스턴스를 생성하고 */
							File storeFile = new File(fileUploadDirectory + "/" + randomFileName);
							
							/* 저장한다 */
							item.write(storeFile);
							
							/* 필요한 정보를 Map에 담는다. */
							Map<String, String> fileMap = new HashMap<>();
							fileMap.put("filedName", filedName);
							fileMap.put("originFileName", originFileName);
							fileMap.put("savedFileName", randomFileName);
							
							fileList.add(fileMap);
						}
					} else {
						/* 폼 데이터인 경우 */
						/* 전송된 폼의 name은 getFiledName()으로 받아오고, 해당 필드의 value는 getString()으로 받아온다. 
						 * 하지만 인코딩 설정을 하더라도 전송되는 파라미터는 ISO-8859-1로 처리된다.
						 * 별도로 ISO-8859-1로 해석된 한글을 UTF-8로 변경해주어야 한다.
						 * */
	//					parameter.put(item.getFieldName(), item.getString());
						parameter.put(item.getFieldName(), new String(item.getString().getBytes("ISO-8859-1"), "UTF-8"));
					}
				}
				System.out.println("parameter : " + parameter);
				System.out.println("fileList : " + fileList);
				
				MemberDTO admin = (MemberDTO) request.getSession().getAttribute("loginMember"); 
				String noticeNo = (String) request.getSession().getAttribute("noticeNo");
				String id = admin.getId();
				String title = parameter.get("updateTitle");
				String content = parameter.get("updateContent");
				String date = new SimpleDateFormat("yy-MM-dd").format(new java.sql.Date(System.currentTimeMillis()));		
				
				System.out.println(title);
				System.out.println(content);
				System.out.println(noticeNo);
				
				Map<String, String> updateNoticeMap = new HashMap<>();
				updateNoticeMap.put("noticeNo", noticeNo);
				updateNoticeMap.put("id", id);
				updateNoticeMap.put("title", title);
				updateNoticeMap.put("content", content);
				updateNoticeMap.put("date", date);
				
				Map<String, String> noticeNoMap = new HashMap<>();
				noticeNoMap.put("noticeNo", noticeNo);
				
				/* 업데이트 할 파일 */
				NoticeDTO updateNotice = new NoticeDTO();
				updateNotice.setNoticeNo(Integer.parseInt(noticeNo));
				updateNotice.setAttachList(new ArrayList<NoticeAttachDTO>());
				
				
				List<NoticeAttachDTO> list = updateNotice.getAttachList();
				for(int i = 0; i < fileList.size(); i++) {
					Map<String, String> file = fileList.get(i);
					
					NoticeAttachDTO tempFileInfo = new NoticeAttachDTO();
					tempFileInfo.setOriginName(file.get("originFileName"));
					tempFileInfo.setFileName(file.get("savedFileName"));
					
					list.add(tempFileInfo);
				}
				System.out.println(updateNotice);
				
				AdminNoticeService noticeService = new AdminNoticeService();
				
				if(title.length() == 0 && content.length() == 0 && fileList.size() == 0) {
					response.sendRedirect(request.getContextPath() + "/admin/cancle/session");
				}else if(title.length() == 0 && content.length() == 0 && fileList.size() != 0){
					
					List<NoticeAttachDTO> deleteList = noticeService.selectNoticeAttachList(noticeNoMap);
					
					System.out.println(deleteList);
					if(deleteList.size() > 0) {
						int deleteResult = noticeService.deleteNoticeAttach(noticeNoMap);
						
						if(deleteResult > 0) {
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
							
							int updateResult = noticeService.updateNoticeAttach(updateNotice);
							
							if(updateResult > 0) {
								request.getSession().removeAttribute("ifUpdate");
								response.sendRedirect(request.getContextPath() + "/admin/notice/detail");
							} else {
								String path = "WEB-INF/views/common/failed.jsp";
								request.setAttribute("message", "수정할 첨부파일 등록 실패!");
								request.getRequestDispatcher(path).forward(request, response);
							}
						} else {
							String path = "WEB-INF/views/common/failed.jsp";
							request.setAttribute("message", "기존 첨부파일 삭제 실패!");
							request.getRequestDispatcher(path).forward(request, response);
						}
					}else {
						
						int updateResult = noticeService.updateNoticeAttach(updateNotice);
						
						if(updateResult > 0) {
							request.getSession().removeAttribute("ifUpdate");
							response.sendRedirect(request.getContextPath() + "/admin/notice/detail");
						} else {
							String path = "WEB-INF/views/common/failed.jsp";
							request.setAttribute("message", "수정할 첨부파일 등록 실패!");
							request.getRequestDispatcher(path).forward(request, response);
						}
					}
				}else if(fileList.size() == 0){
					
					int noticeResult = noticeService.updateNotice(updateNoticeMap);
					
					if(noticeResult > 0) {
						
						List<NoticeAttachDTO> deleteList = noticeService.selectNoticeAttachList(noticeNoMap);
						if(deleteList.size() > 0) {
							int deleteResult = noticeService.deleteNoticeAttach(noticeNoMap);
							
							if(deleteResult > 0) {
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
								response.sendRedirect(request.getContextPath() + "/admin/notice/detail");
							} else {
								String path = "WEB-INF/views/common/failed.jsp";
								request.setAttribute("message", "기존 첨부파일 삭제 실패!");
								request.getRequestDispatcher(path).forward(request, response);
							}
						}else {
							request.getSession().removeAttribute("ifUpdate");
							response.sendRedirect(request.getContextPath() + "/admin/notice/detail");
						}
					}else {
						String path = "WEB-INF/views/common/failed.jsp";
						request.setAttribute("message", "공지사항 정보 수정 실패!");
						request.getRequestDispatcher(path).forward(request, response);
					}
				}else {
					
					int noticeResult = noticeService.updateNotice(updateNoticeMap);
					
					if(noticeResult > 0) {
						
						List<NoticeAttachDTO> deleteList = noticeService.selectNoticeAttachList(noticeNoMap);
						if(deleteList.size() > 0) {
							int deleteResult = noticeService.deleteNoticeAttach(noticeNoMap);
							
							if(deleteResult > 0) {
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
								
								int updateResult = noticeService.updateNoticeAttach(updateNotice);
								
								if(updateResult > 0) {
									request.getSession().removeAttribute("ifUpdate");
									response.sendRedirect(request.getContextPath() + "/admin/notice/detail");
								} else {
									String path = "WEB-INF/views/common/failed.jsp";
									request.setAttribute("message", "수정할 첨부파일 등록 실패!");
									request.getRequestDispatcher(path).forward(request, response);
								}
							} else {
								String path = "WEB-INF/views/common/failed.jsp";
								request.setAttribute("message", "기존 첨부파일 삭제 실패!");
								request.getRequestDispatcher(path).forward(request, response);
							}
						}else {
							
							int updateResult = noticeService.updateNoticeAttach(updateNotice);
							
							if(updateResult > 0) {
								request.getSession().removeAttribute("ifUpdate");
								response.sendRedirect(request.getContextPath() + "/admin/notice/detail");
							} else {
								String path = "WEB-INF/views/common/failed.jsp";
								request.setAttribute("message", "수정할 첨부파일 등록 실패!");
								request.getRequestDispatcher(path).forward(request, response);
							}
						}
					} else {
						String path = "WEB-INF/views/common/failed.jsp";
						request.setAttribute("message", "공지사항 정보 수정 실패!");
						request.getRequestDispatcher(path).forward(request, response);
					}
					
				}
			
	        } catch (Exception e) {
	        	//어떤 종류의 Exception이 발생 하더라도실패 시 파일을 삭제해야 한다.
				int cnt = 0;
				for(int i = 0; i < fileList.size(); i++) {
					Map<String, String> file = fileList.get(i);
					
					File deleteFile = new File(fileUploadDirectory + "/" + file.get("savedFileName"));
					boolean isDeleted = deleteFile.delete();
					
					if(isDeleted) {
						cnt++;
					}
				}
				
				if(cnt == fileList.size()) {
					System.out.println("업로드에실패한 모든 사진 삭제 완료!");
					e.printStackTrace();
				} else {
					e.printStackTrace();
				}
	        }	
        }
	}
}
