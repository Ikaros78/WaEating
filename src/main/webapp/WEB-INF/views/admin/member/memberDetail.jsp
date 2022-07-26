<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 상세 정보</title>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/admin/style.css">
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

    <!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>
<body>
 	<div id="wrap">
 		<jsp:include page="../common/menubar.jsp"/>
		<div id="body">
            <div class="col-md-2">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>회원 관리</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                                <ul class="nav nav-stacked">
                                    <li role="presentation"><a href="${ pageContext.servletContext.contextPath }/admin/member/list">회원정보 조회</a></li>
                                    <li role="presentation"><a href="#">회원정보 등록</a></li>
                                </ul>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div class="col-md-9">
                <table class="table table-bordered">
                	<thead>
	                	<tr>
	                		<td class="col-md-2">기본정보</td>
	                		<td>상세정보</td>
	                	</tr>
                	</thead>
                    <tbody>
                        <tr>
                            <td>이름</td>
                            <td><c:out value="${ member.name }"/></td>
                        </tr>
                        <tr>
                            <td>아이디</td>
                            <td><c:out value="${ member.id }"/></td>
                        </tr>
                        <tr>
                            <td>비밀번호</td>
                            <td><c:out value="${ member.pwd }"/></td>
                        </tr>
                        <tr>
                            <td>이메일</td>
                            <td><c:out value="${ member.email }"/></td>
                        </tr>
                        <tr>
                            <td>생년월일</td>
                            <td><c:out value="${ member.userInfo.birth }"/></td>
                        </tr>
                        <tr>
                            <td>성별</td>
                            <td><c:out value="${ member.userInfo.gender }"/></td>
                        </tr>
                        <tr>
                            <td>휴대폰번호</td>
                            <td><c:out value="${ member.phone }"/></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>

        <div id="container">

            <div class="col-md-9 col-md-offset-2" align="right">
                <button type="button" class="btn btn-primary">수정</button>
                <button type="button" class="btn btn-danger">삭제</button>
                <button type="button" class="btn btn-default">목록으로</button>
            </div>
        </div>   
        
    </div>
</body>
</html>