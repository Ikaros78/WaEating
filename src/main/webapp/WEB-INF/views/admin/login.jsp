<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/admin/adminlogin.css">
</head>
<body>
	<div class="wrap">
        <div class="logo">
            <img src="${ pageContext.servletContext.contextPath }/resources/images/logo.png" alt="로고"></a>
        </div>
        <div class="login">
            <form action="${ pageContext.servletContext.contextPath }/admin/login" method="post">
                <div class="login"></div>
                <input type="text" class="login_box" id="login_id" placeholder="아이디 입력" name ="id"> 
                <input type="password" class="login_box" id="login_pw" placeholder="비밀번호 입력" name ="password">
    
                <button type="submit" id="login_btn">로그인</button>
            </form>
        </div>
    </div>
</body>
</html>  