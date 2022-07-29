<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의사항 상세보기</title>
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
                            <th>고객센터</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                                <ul class="nav nav-stacked">
                                    <li role="presentation"><a href="${ pageContext.servletContext.contextPath }/admin/support/list">문의사항 조회</a></li>
                                    <li role="presentation"><a href="${ pageContext.servletContext.contextPath }/admin/supportFAQ/list">자주 하는 질문</a></li>
                                </ul>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
            
    </div>
</body>
</html>