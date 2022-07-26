<%@ page language="java" contentType="text/html; charset=UTF-8
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/notice/main.css">
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/notice/notice.css">
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<body>
  <header>
    <nav class="navbar navbar-expand-sm navbar-light bg-white p-3">
      <div class="container-fluid">
        <a class="navbar-brand" href="ceo_main.html">
         <img src="${ pageContext.servletContext.contextPath }/resources/images/logo.png" alt="logo"></a>
        </a>
        <ul class="navbar-nav main align-content-end">
          <li class="nav-item dropmenu mt-4">
            <a class="nav-link px-5 fs-5" href="/ceo_notice.html">공지사항</a>
            <ul class="nav flex-column text-center pt-3" style="width:170px;">
              <li class="nav-item">
                <a class="nav-link" href="/ceo_notice.html">공지사항</a>
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
   

    <div class="container">
        <section class="notice">
            <div class="page-title">
                  <div class="container">
                    
                      <h3>공지사항</h3>
                  </div>
              </div>
          
              <!-- board seach area -->
              <div id="board-search">
                  <div class="container">
                      <div class="search-window">
                          <form action="">
                              <div class="search-wrap">
                                  <label for="search" class="blind">공지사항 내용 검색</label>
                                  <input id="search" type="search" name="" placeholder="검색어를 입력해주세요." value="">
                                  <button type="submit" class="btn btn-dark">검색</button>
                              </div>
                          </form>
                      </div>
                  </div>
              </div>
             
            <!-- board list area -->
              <div id="board-list">
                  <div class="container">
                      <table class="board-table">
                          <thead>
                          <tr>
                              <th scope="col" class="th-num">번호</th>
                              <th scope="col" class="th-title">제목</th>
                              <th scope="col" class="th-date">등록일</th>
                          </tr>
                          </thead>
                          <tbody>
                          <tr>
                              <td>3</td>
                              <th>
                                <a href="#!">[공지사항] 개인정보 처리방침 변경안내처리방침</a>
                                
                              </th>
                              <td>2022.07.25</td>
                          </tr>
          
                          <tr>
                              <td>2</td>
                              <th><a href="#!">이벤트관련 공지사항</a></th>
                              <td>2022.07.20</td>
                          </tr>
          
                          <tr>
                              <td>1</td>
                              <th><a href="#!">수수료 변경 공지사항</a></th>
                              <td>2022.07.13</td>
                          </tr>
                          </tbody>
                      </table>
                  </div>
              </div>
              <div class="list_number">
                <div>
                    <p><div class="list_n_menu"><span class="disabled"><  이전</span><span class="current">1</span><a href="#?page=2">2</a><a href="#?page=3">3</a><a href="#?page=4">4</a><a href="#?page=5">5</a><a href="#?page=6">6</a><a href="#?page=7">7</a>...<a href="#?page=199">20</a><a href="#?page=200">21</a><a href="#?page=2">다음  ></a></div></p>
                </div>
            </div>
          </section>
        
        </div>

   
    <footer class="container-fluid  mt-5 p-4 text-white">
      <div >
        
        <a class="navbar-brand float-end" href="#">
        <img src="${ pageContext.servletContext.contextPath }/resources/images/logo2.png" alt="Avartarlogo"></a>
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