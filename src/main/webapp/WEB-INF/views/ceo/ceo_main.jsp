<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>업체 메인</title>
<link rel="stylesheet" href="css/style.css">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<header>
    <nav class="navbar navbar-expand-sm navbar-light bg-white p-3">
      <div class="container-fluid">
        <a class="navbar-brand" href="ceo_main.html">
          <img src="img/logo.png" alt="Logo" style="width:150px;"> 
        </a>
        <ul class="navbar-nav main align-content-end">
          <li class="nav-item dropmenu mt-4">
            <a class="nav-link px-5 fs-5" href="#">공지사항</a>
            <ul class="nav flex-column text-center pt-3" style="width:170px;">
              <li class="nav-item">
                <a class="nav-link" href="#">공지사항</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">자주 묻는 질문</a>
              </li>
            </ul>
          </li>
          <li class="nav-item dropmenu mt-4">
            <a class="nav-link px-5 fs-5" href="ceo_reservation_current.html">예약관리</a>
            <ul class="nav flex-column text-center pt-3" style="width:170px;">
              <li class="nav-item">
                <a class="nav-link" href="ceo_reservation_current.html">예약 현황 관리</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="ceo_reservation_list.html">예약 리스트 보기</a>
              </li>
            </ul>
          </li>
          <li class="nav-item dropmenu  mt-4">
            <a class="nav-link px-5 fs-5" href="ceo_rest_restInfo.html">가게 관리</a>
            <ul class="nav flex-column text-center pt-3" style="width:175px;">
              <li class="nav-item">
                <a class="nav-link" href="ceo_rest_restInfo.html">가게 정보 관리</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="ceo_rest_notice.html">공지 관리</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="ceo_rest_review.html">리뷰 관리</a>
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
              <li class="nav-item">
                <a class="nav-link" href="#">고객센터</a>
              </li>
            </ul>
          </li>
          <li class="nav-item">
            <a class="nav-link px-2 my-1 ms-5" href="#">로그인</a>
          </li>
          <li class="nav-item">
            <a class="nav-link px-2 my-1 me-3" href="#">회원가입</a>
          </li>
        </ul>
      </div>
    </nav>
  </header>

  <div id="wrap">

   
    <footer class="container-fluid  mt-5 p-4 text-white">
      <div >
        
        <a class="navbar-brand float-end" href="#">
          <img src="img/logo2.png" alt="Avatar Logo" style="width:140px;"> 
        </a>
        웨잇-팅<br>
        서울특별시 종로구 <br>
        사업자 등록번호 : 111-11-11111 <br>
        고객센터 : 02-1111-1111 <br>
        <br>
        copyright 2022 Wai-eating Co., Ltd. All rights reserved
      </div>
    </footer> 
  </div>
</body>
</html>