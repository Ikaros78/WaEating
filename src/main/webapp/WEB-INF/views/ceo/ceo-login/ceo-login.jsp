<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>웨잇-팅 업주 로그인</title>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/ceo/ceo-login/ceo-login.css">
</head>
<body>
	<div class="wrap">
        <div class="logo">
            <img src="${ pageContext.servletContext.contextPath }/resources/images/logo_font.png" alt="로고">
        </div>
        <div class="login">
            <form action="${ pageContext.servletContext.contextPath }/ceo/main" method="post">
                <div class="login"></div>
                <input type="text" class="login_box" id="login_id" name="ceoId" placeholder="아이디 입력"> 
                <input type="password" class="login_box" id="login_pw" name="ceoPw" placeholder="비밀번호 입력">
    
                <button type="submit" id="login_btn">로그인</button>
            </form>
        </div>
        <div class="sub">
            <ul>
                <li><a href="${ pageContext.servletContext.contextPath }/member/ceo/signup">회원가입</a></li>
                <li><a href="${ pageContext.servletContext.contextPath }/member/ceo/findid">아이디 찾기</a></li>
                <li><a href="${ pageContext.servletContext.contextPath }/member/ceo/findpw">비밀번호 찾기</a></li>
            </ul>
        </div>
    </div>
</body>
</html>