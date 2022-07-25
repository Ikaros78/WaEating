<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>user_reservation_finish</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/user/user.css">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
 <jsp:include page="../user_header.jsp"/>

  <div id="wrap">
    <!-- 왼쪽 (메뉴) -->
    <section class="row container-fluid px-5">
      <aside class="float-start col-2 mt-4 ms-5 px-3">
        <!-- 메뉴 제목 -->
        <h4 class="mb-3 ms-1">나의 예약</h4>
        <div class="list-group list-group-flush border-top border-bottom">
          <!-- 메뉴 세부 제목 -->
          <a href="${ pageContext.servletContext.contextPath }/user/reservation/finish" class="list-group-item list-group-item-action py-3 ">이전 예약</a><!-- 상세 페이지에 select 클래스 넣어주기 -->
          <a href="${ pageContext.servletContext.contextPath }/user/reservation/now" class="list-group-item list-group-item-action py-3 select">현재 예약</a>
          <a href="${ pageContext.servletContext.contextPath }/user/reservation/cancel" class="list-group-item list-group-item-action py-3">취소한 예약</a>
        </div>
       </aside>
       <!-- 오른쪽 (컨텐츠) -->
       <aside class="float-end col-9 mt-4 ms-3 border">
        <!-- 이미지 지우고 넣을 컨텐츠 써서 사용 -->
       
        <br>
        <h2 style="text-indent: 30px;">이전 예약</h2>
        <hr>
        <div class="reservation finish">
            <h5>[또 보겠지 떡볶이집 몽글몽글 청계점]</h5>
            <p style="color: gray;">2022/07/17</p>
            <br>
            <h6><나의 예약 정보></h6>
            <p>번호 : 6번</p>
            <p>인원수 : 3명</p>
            <p>전화번호 : 010-1234-5678</p>
            
              <button type="button" class="btn btn-outline-success" disabled>방문 완료</button>
            
            <a href="${ pageContext.servletContext.contextPath }/user/review">
              <button type="button" class="btn btn-success">리뷰 쓰기</button> 
            </a>
        </div>

        <div class="reservation finish">
            <h5>[또 보겠지 떡볶이집 몽글몽글 청계점]</h5>
            <p style="color: gray;">2022/07/17</p>
            <br>
            <h6><나의 예약 정보></h6>
            <p>번호 : 6번</p>
            <p>인원수 : 3명</p>
            <p>전화번호 : 010-1234-5678</p>

            <button type="button" class="btn btn-outline-success" disabled>방문 완료</button>
            <a href="${ pageContext.servletContext.contextPath }/user/review/deleteupdate">
              <button type="button" class="btn btn-success">내가 쓴 리뷰 보기</button>
            </a>
        </div>








       </aside>
    </section>
   
    <jsp:include page="../user_footer.jsp"/>

  </div>

</body>
</html>