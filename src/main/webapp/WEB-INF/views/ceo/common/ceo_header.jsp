<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>업체</title>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/ceo/style.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<header>
    <nav class="navbar navbar-expand-sm navbar-light bg-white p-3">
      <div class="container-fluid">
        <a class="navbar-brand" href="${ pageContext.servletContext.contextPath }/ceo/main">
          <img src="${ pageContext.servletContext.contextPath }/resources/images/ceo/logo.png" alt="Logo" style="width:150px;"> 
        </a>
        <ul class="navbar-nav main align-content-end">
          <li class="nav-item dropmenu mt-4">
            <a class="nav-link px-5 fs-5" href="#">공지사항</a>
            <ul class="nav flex-column text-center pt-3" style="width:170px;">
              <li class="nav-item">
                <a class="nav-link" href="${ pageContext.servletContext.contextPath }/notice/ceolist">공지사항</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">자주 묻는 질문</a>
              </li>
            </ul>
          </li>
          <li class="nav-item dropmenu mt-4">
            <a class="nav-link px-5 fs-5" href="${ pageContext.servletContext.contextPath }/ceo/reservation_current">예약관리</a>
            <ul class="nav flex-column text-center pt-3" style="width:170px;">
              <li class="nav-item">
                <a class="nav-link" href="${ pageContext.servletContext.contextPath }/ceo/reservation_current">예약 현황 관리</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="${ pageContext.servletContext.contextPath }/ceo/reservation_list">예약 리스트 보기</a>
              </li>
            </ul>
          </li>
          <li class="nav-item dropmenu  mt-4">
            <a class="nav-link px-5 fs-5" href="${ pageContext.servletContext.contextPath }/ceo/rest_restInfo">가게 관리</a>
            <ul class="nav flex-column text-center pt-3" style="width:175px;">
              <li class="nav-item">
                <a class="nav-link" href="${ pageContext.servletContext.contextPath }/ceo/rest_restInfo">가게 정보 관리</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="${ pageContext.servletContext.contextPath }/ceo/rest_notice">공지 관리</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="${ pageContext.servletContext.contextPath }/ceo/rest_review">리뷰 관리</a>
              </li>
            </ul>
          </li>
          <li class="nav-item dropmenu  mt-4">
            <a class="nav-link px-5 fs-5" href="#">마이페이지</a>
            <ul class="nav flex-column pt-3" style="width:188px;">
              <li class="nav-item">
                <a class="nav-link" href="#">개인 정보 수정</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">가게 정보 수정</a>
              </li>
            </ul>
          </li>
          <li class="nav-item">
            <a class="nav-link px-2 my-1 ms-5" href="#"><c:out value="${ sessionScope.loginMember.memberInfo.name }"/>님</a>
          </li>
          <li class="nav-item">
            <a class="nav-link px-2 my-1 me-3" href="${ pageContext.servletContext.contextPath }/member/ceo/login">로그아웃</a>
          </li>
        </ul>
      </div>
    </nav>
  </header>
</body>
</html>