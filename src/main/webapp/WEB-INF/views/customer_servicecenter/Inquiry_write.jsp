<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>고객센터 문의작성</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet"  href="${ pageContext.servletContext.contextPath }./resources/css/notice/user_main.css">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

</head>

<body>

<header>
    <nav class="navbar navbar-expand-sm navbar-light bg-white p-3">
      <div class="container-fluid">
        <a class="navbar-brand" href="#">
          <img src="./images/logo_font.png" alt="Logo" style="width:150px;"> 
        </a>
        <ul class="navbar-nav main align-content-end">
          <li class="nav-item dropmenu mt-4">
            <a class="nav-link px-5 fs-5" href="#">공지사항</a>
            <ul class="nav flex-column text-center pt-3" style="width:170px;">
              <li class="nav-item">
                <a class="nav-link" href="./customer_servicecenter.html">공지사항</a>
              </li>
              
            </ul>
          </li>
          <li class="nav-item dropmenu mt-4">
            <a class="nav-link px-5 fs-5" href="#">맛집리스트</a>
            <ul class="nav flex-column text-center pt-3" style="width:190px;">
                <li class="nav-item">
                    <a class="nav-link" href="#">평점별</a>
                  </li>
                  <li class="nav-item">
                      <a class="nav-link" href="#">지역별</a>
                    </li>
                  <li class="nav-item">
                    <a class="nav-link" href="#">종류별</a>
                  </li>
            </ul>
          </li>
          <li class="nav-item dropmenu  mt-4">
            <a class="nav-link px-5 fs-5" href="#">나의 예약</a>
            <ul class="nav flex-column text-center pt-3" style="width:178px;">
              <li class="nav-item">
                <a class="nav-link" href="#">이전 예약</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">현재 예약</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">취소한 예약</a>
              </li>
            </ul>
          </li>
          <li class="nav-item dropmenu  mt-4">
            <a class="nav-link px-5 fs-5" href="#">마이페이지</a>
                <ul class="nav flex-column pt-3" style="width:188px;">
                  <li class="nav-item">
                    <a class="nav-link" href="#">즐겨찾기</a>
                  </li>
                  <li class="nav-item">
                      <a class="nav-link" href="#">고객센터</a>
                    </li>
                  <li class="nav-item">
                    <a class="nav-link" href="#">회원 정보 수정</a>
                  </li>
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
W
  <div id="wrap">
    <!-- 왼쪽 (메뉴) -->
    <section class="row container-fluid px-5">
      <aside class="float-start col-2 mt-4 ms-5 px-3">
        <!-- 메뉴 제목 -->
        <h4 class="mb-3 ms-1">맛집리스트</h4>
        <div class="list-group list-group-flush border-top border-bottom">
          <!-- 메뉴 세부 제목 -->
          <a href="#" class="list-group-item list-group-item-action py-3 select">평점별</a><!-- 상세 페이지에 select 클래스 넣어주기 -->
          <a href="#" class="list-group-item list-group-item-action py-3">지역별</a>
          <a href="#" class="list-group-item list-group-item-action py-3">종류별</a>
        </div>
       </aside>
       <!-- 오른쪽 (컨텐츠) -->
       <aside class="float-end col-9 mt-4 ms-3 border">
        <!-- 이미지 지우고 넣을 컨텐츠 써서 사용 -->
        <!-- <img src="./images/visual.jpg" width="100%">  -->
        <h2>고객센터 문의사항 작성</h2>

        <form>
            <table>
                <tr>
                    <th>제목</th>
                    <td><input type="text"></td> 
                </tr>
    
                <!-- <tr>
                    <th>비밀번호</th>
                    <td><input type="password"></td>
                </tr>
    
                <tr>
                    <th>이메일</th>
                    <td><input type="text">@<select><option>선택</option><option>naver.com</option><option>daum.com</option><option>google.com</option></select></td>
                </tr>
     -->
                <tr>
                    <th>내용</th>
                    <td><textarea rows="10" cols="80"></textarea></td>
                </tr>
                
        
            </table>
            <div id="button" style="text-align: right;">
                <th><button>삭제</button></th>
                <th ><button>수정</button></th>
                <th ><button>확인</button></th>
           </div>
        </form>
        
       </aside>
    </section>
   
    <!-- footer -->
    <footer class="container-fluid  mt-5 p-4 text-white">
      <div>
        <a class="navbar-brand float-end" href="#">
          <img src="./images/logo.png" alt="Avatar Logo" style="width:140px;"> 
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