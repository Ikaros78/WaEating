<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 일반사용자, 업체사용자, 관리자 선택해서 입장하는 페이지 -->
	<a href="${ pageContext.servletContext.contextPath }/admin/login/session">관리자로그인</a>
	<a href="${ pageContext.servletContext.contextPath }/admin/notice/ceoNotice.jsp/session">공지사항</a>
</body>
</html>