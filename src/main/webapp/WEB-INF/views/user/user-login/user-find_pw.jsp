<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<link rel="stylesheet" href="find-pw.css">
</head>
<body>
	<div class="wrap">
        <label for="find_id">비밀번호 찾기</label>
        <div id="f_phone" class="find">
            <a href="../find-detail/find-pw-phone.html">
                <img src="../img/phone2.png" alt="">
                <p>전화번호로 찾기</p>
            </a>
        </div>
        <div id="f_email" class="find">
            <a href="../find-detail/find-pw-email.html">
                <img src="../img/email.png" alt="">
                <p>이메일로 찾기</p>
            </a>
        </div>
        <a href="../login/login.html"><button type="button" id="backBtn">뒤로가기</button></a>
    </div>
</body>
</html>