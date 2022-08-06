<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>user_main</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
   
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
     <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/user/user.css">
</head>
<body>
	 <header>
        <nav class="navbar navbar-expand-sm navbar-light bg-white p-3">
          <div class="container-fluid">
            <a class="navbar-brand" href="${ pageContext.servletContext.contextPath }/user/main">
              <img src="${ pageContext.servletContext.contextPath }/resources/images/user/logo_font.png" alt="Logo" style="width:150px;"> 
            </a>
            <ul class="navbar-nav main align-content-end">
              <li class="nav-item dropmenu mt-4">
                <a class="nav-link px-5 fs-5" href="#">공지사항</a>
                <ul class="nav flex-column text-center pt-3" style="width:170px;">
                  <li class="nav-item">
                    <a class="nav-link" href="${ pageContext.servletContext.contextPath }/notice/list">공지사항</a>
                  </li>
                 
                </ul>
              </li>
              <li class="nav-item dropmenu  mt-4">
                <a class="nav-link px-5 fs-5" href="${ pageContext.servletContext.contextPath }/user/matziplist/grade">맛집리스트</a>
                <ul class="nav flex-column text-center pt-3" style="width:190px;">
                  <li class="nav-item">
                    <a class="nav-link" href="${ pageContext.servletContext.contextPath }/user/matziplist/grade">평점별</a>
                  </li>
                  <li class="nav-item">
                      <a class="nav-link" href="${ pageContext.servletContext.contextPath }/user/matziplist/location">지역별</a>
                    </li>
                  <li class="nav-item">
                    <a class="nav-link" href="${ pageContext.servletContext.contextPath }/user/matziplist/category">종류별</a>
                  </li>
                </ul>
              </li>
              <li class="nav-item dropmenu  mt-4">
                <a class="nav-link px-5 fs-5" href="${ pageContext.servletContext.contextPath }/user/reservation/now">나의 예약</a>
                <ul class="nav flex-column text-center pt-3" style="width:178px;">
                  <li class="nav-item">
                    <a class="nav-link" href="${ pageContext.servletContext.contextPath }/user/reservation/finish">이전 예약</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="${ pageContext.servletContext.contextPath }/user/reservation/now">현재 예약</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="${ pageContext.servletContext.contextPath }/user/reservation/cancel">취소한 예약</a>
                  </li>
                </ul>
              </li>
              <li class="nav-item dropmenu  mt-4">
                <a class="nav-link px-5 fs-5" href="${ pageContext.servletContext.contextPath }/user/check/password">마이페이지</a>
                <ul class="nav flex-column pt-3" style="width:188px;">
                  <li class="nav-item">
                    <a class="nav-link" href="${ pageContext.servletContext.contextPath }/user/check/password">회원 정보 수정</a>
                  </li>
                  <li class="nav-item">
                      <a class="nav-link" href="${ pageContext.servletContext.contextPath }/report/main">고객센터</a>
                    </li>
                </ul>
              </li>
              <li class="nav-item">
	            <a class="nav-link px-2 my-1 ms-5" href="#"><c:out value="${ sessionScope.loginMember.name }"/>님</a>
              </li>
              <li class="nav-item">
                <a class="nav-link px-2 my-1 me-3" href="${ pageContext.servletContext.contextPath }/common/logout">로그아웃</a>
              </li>
            </ul>
          </div>
        </nav>
      </header>
</body>
</html>