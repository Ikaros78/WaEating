<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>웨잇-팅</title>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/main/main.css">
</head>
<body>
	<!-- 일반사용자, 업체사용자, 관리자 선택해서 입장하는 페이지 -->
	
	<div class="wrap">
        <div id="user" class="main">
            <a href="${ pageContext.servletContext.contextPath }/member/user/login/session">
                <img src="${ pageContext.servletContext.contextPath }/resources/images/login-img/user.png" alt="일반회원">
                <p>일반회원</p>
            </a>
        </div>

        <div id="ceo" class="main">
            <a href="${ pageContext.servletContext.contextPath }/member/ceo/login">
                <img src="${ pageContext.servletContext.contextPath }/resources/images/login-img/shop.png" alt="업주">
                <p>업주</p>
            </a>
        </div>
        <div id="admin" class="main">
            <a href="${ pageContext.servletContext.contextPath }/admin/login/session">
                <img src="${ pageContext.servletContext.contextPath }/resources/images/login-img/settings.png" alt="관리자">
                <p>관리자</p>
            </a>
        </div>
    </div>
</body>
</html>