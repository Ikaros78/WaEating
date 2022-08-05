<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>웨잇-팅 로그인</title>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/user/user-login/user-login.css">
</head>
<body>
	<div class="wrap">
        <div class="logo">
            <img src="${ pageContext.servletContext.contextPath }/resources/images/logo_font.png" alt="로고">
        </div>
        <div class="login">
            <form action="${ pageContext.servletContext.contextPath }/member/user/login" method="post">
                <div class="login"></div>
                <input type="text" class="login_box" id="login_id" placeholder="아이디 입력" name="userId"> 
                <input type="password" class="login_box" id="login_pw" placeholder="비밀번호 입력" name="userPw">
                <input type="submit" id="login_btn" value="로그인"></input>
            </form>
        </div>
        <div class="sub">
            <ul>
                <li><a href="${ pageContext.servletContext.contextPath }/member/user/signup">회원가입</a></li>
                <li><a href="${ pageContext.servletContext.contextPath }/member/user/findid">아이디 찾기</a></li>
                <li><a href="${ pageContext.servletContext.contextPath }/member/user/findpw">비밀번호 변경</a></li>
            </ul>
        </div>
    </div>
</body>
</html>