<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/admin/style.css">
<script src="${ pageContext.servletContext.contextPath }/resources/js/event.js"></script>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

    <!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>
<body>
	<div id="header">
            <div class="col-md-10">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="active"><a href="${ pageContext.servletContext.contextPath }/admin/main">Home</a></li>
                    <li role="presentation"><a href="${ pageContext.servletContext.contextPath }/admin/member/list">회원 관리</a></li>
                    <li role="presentation"><a href="${ pageContext.servletContext.contextPath }/admin/company/list">업체 관리</a></li>
                    <li role="presentation"><a href="${ pageContext.servletContext.contextPath }/admin/review/list">리뷰글 관리</a></li>
                    <li role="presentation"><a href="${ pageContext.servletContext.contextPath }/admin/report/list">고객센터 관리</a></li>
                    <li role="presentation"><a href="${ pageContext.servletContext.contextPath }/admin/notice/list">공지사항 관리</a></li>
                    <li role="presentation"><a href="${ pageContext.servletContext.contextPath }/admin/usageLog/list">이용이력 관리</a></li>
                </ul>
            </div>
            <c:if test="${ !empty sessionScope.loginMember }">
	            <div class="col-md-1">
	                <button type="button" class="btn btn-primary" id="logout">로그아웃</button>
	            </div>
            </c:if>
            <c:if test="${ empty sessionScope.loginMember }">
	            <div class="col-md-1">
	                <button type="button" class="btn btn-primary" id="adminLogin">로그인</button>
	            </div>
            </c:if>
   </div> 
</body>
</html>