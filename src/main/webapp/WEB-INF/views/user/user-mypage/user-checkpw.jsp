<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 정보 수정</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/user/user-mypage/user-update.css">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	
	<jsp:include page="../user_header.jsp"></jsp:include>  
  <div id="wrap">
    <!-- 왼쪽 (메뉴) -->
    <section class="row container-fluid px-5">
      <aside class="float-start col-2 mt-4 ms-5 px-3">
        <!-- 메뉴 제목 -->
        <h4 class="mb-3 ms-1">마이페이지</h4>
        <div class="list-group list-group-flush border-top border-bottom">
          <!-- 메뉴 세부 제목 -->
          <a href="#" class="list-group-item list-group-item-action py-3">즐겨찾기</a><!-- 상세 페이지에 select 클래스 넣어주기 -->
          <a href="#" class="list-group-item list-group-item-action py-3">고객센터</a>
          <a href="${ pageContext.servletContext.contextPath }/check/password/user" class="list-group-item list-group-item-action py-3 select">회원 정보 수정</a>
        </div>
       </aside>
       <!-- 오른쪽 (컨텐츠) -->
       <aside class="float-end col-9 mt-4 ms-3 border">
        <!-- 이미지 지우고 넣을 컨텐츠 써서 사용 -->
      <div id="checkuser">
        <form action="">
          <label for="id" id="nowid">아이디</label><input type="text" value="hong" readonly="readonly">
        <br>
        <label for="pw" id="nowpw" style="margin-top: 20px;">비밀번호</label> <input type="password" placeholder="비밀번호를 입력해주세요." style="margin-top: 10px;">
        <a href="${ pageContext.servletContext.contextPath }/update/information/user"><input type="button" value="확인" id="ckbtn"></a>
        </form>
      </div>

       </aside>
    </section>
   

  </div>
</body>
 <!-- footer -->
	<footer class="container-fluid  mt-5 p-4 text-white" id="checkpw_footer">
      <div >
        
        <a class="navbar-brand float-end" href="#">
          <img src="${ pageContext.servletContext.contextPath }/resources/images/user/logo.png" alt="Avatar Logo" style="width:140px;"> 
        </a>
        웨잇-팅<br>
        서울특별시 종로구 <br>
        사업자 등록번호 : 111-11-11111 <br>
        고객센터 : 02-1111-1111 <br>
        <br>
        copyright 2022 Waeating Co., Ltd. All rights reserved
      </div>
    </footer> 
</html>