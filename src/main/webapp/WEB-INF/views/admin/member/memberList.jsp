<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 관리</title>
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
        <jsp:include page ="../common/menubar.jsp"/>
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
                                    <li role="presentation"><a href="#">회원정보 조회</a></li>
                                    <li role="presentation"><a href="#">회원정보 수정</a></li>
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
                        <th width="150px">아이디</th>
                        <th width="100px">이름</th>
                        <th width="300px">이메일</th>
                        <th width="150px">전화번호</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="account" items="${ requestScope.accountList }">
                    <tr>
                    	<td><c:out value="${ account.id }"/></td>
                    	<td><c:out value="${ account.name }"/></td>
                    	<td><c:out value="${ account.email }"/></td>
                    	<td><c:out value="${ account.phone }"/></td>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>    

        <div id="searchContainer">
            <div class="row">
                <div class="col-md-offset-7 col-md-4" align="right">
                        <select class="form-select" id="option">
                            <option value="이름">이름</option>
                            <option value="나이">나이</option>
                            <option value="휴대폰">휴대폰</option>
                            <option value="아이디">아이디</option>
                            <option value="옵션5">옵션5</option>
                        </select>
                        <input type="text">
                        <input type="submit" value="검색">
                </div>
            </div>
        </div>

        <div id="container">
            <!-- 페이지 처리 -->
            <jsp:include page="../common/paging.jsp"/>
        </div>

        
    </div>
</body>
</html>