<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/user/user-login/user-find_id.css">
</head>
<body>
	<div class="wrap">
        <label for="find_id"></label>
        <div id="f_phone" class="find">
            <a href="${ pageContext.servletContext.contextPath }/member/user/findid/phone">
                <img src="${ pageContext.servletContext.contextPath }/resources/images/login-img/phon2.png" alt="전화번호로 찾기">
                <p>전화번호로 찾기</p>
            </a>
        </div>
        <div id="f_email" class="find">
            <a href="${ pageContext.servletContext.contextPath }/member/user/findid/email">
                <img src="${ pageContext.servletContext.contextPath }/resources/images/login-img/email.png" alt="이메일로 찾기">
                <p>이메일로 찾기</p>
            </a>
        </div>
        <a href="${ pageContext.servletContext.contextPath }/member/user/login"><button type="button" id="backBtn">뒤로가기</button></a>
    </div>
</body>
</html>