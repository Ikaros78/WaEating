<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>user_matziplist_category</title>
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
        <h4 class="mb-3 ms-1">맛집리스트</h4>
        <div class="list-group list-group-flush border-top border-bottom">
          <!-- 메뉴 세부 제목 -->
          <a href="${ pageContext.servletContext.contextPath }/user/matziplist/grade" class="list-group-item list-group-item-action py-3">평점별</a><!-- 상세 페이지에 select 클래스 넣어주기 -->
          <a href="${ pageContext.servletContext.contextPath }/user/matziplist/location" class="list-group-item list-group-item-action py-3">지역별</a>
          <a href="${ pageContext.servletContext.contextPath }/user/matziplist/category" class="list-group-item list-group-item-action py-3 select">종류별</a>
        </div>
       </aside>
       <!-- 오른쪽 (컨텐츠) -->
       <aside class="float-end col-9 mt-4 ms-3 border">
        <!-- 이미지 지우고 넣을 컨텐츠 써서 사용 -->

       
                <h3>종류별</h3>
                <br>
                <div class="container mt-3 row d-flex justify-content-center mb-5"><!--idcard1 시작-->
                  
                   <div class="card col-3" style="width:290px">
                    <img class="card-img-aside" src="${ pageContext.servletContext.contextPath }/resources/images/user/ddok.png" alt="Card image" style="width:100%;">
                    <div class="card-body">
                      <h4 class="card-title">또오겠지 분식점</h4>
                      <p class="card-text">영업시간) 10:00~ 21:00 <br> 휴무일) 월</p>
                     <a href="${ pageContext.servletContext.contextPath }/user/matzip/detail" class="btn btn-outline-dark">상세보기</a>
                      <a href="${ pageContext.servletContext.contextPath }/user/reservation" class="btn btn-danger">예약하기</a>
                    </div>
                  </div>
                  <br>
                  
                   <div class="card col-3" style="width:290px">
                    <img class="card-img-aside" src="${ pageContext.servletContext.contextPath }/resources/images/user/ddok.png" alt="Card image" style="width:100%;">
                    <div class="card-body">
                      <h4 class="card-title">또오겠지 분식점</h4>
                      <p class="card-text">영업시간) 10:00~ 21:00 <br> 휴무일) 월</p>
                     <a href="${ pageContext.servletContext.contextPath }/user/matzip/detail" class="btn btn-outline-dark">상세보기</a>
                      <a href="${ pageContext.servletContext.contextPath }/user/reservation" class="btn btn-danger">예약하기</a>
                    </div>
                  </div>
                  
      
                   <div class="card col-3" style="width:290px">
                    <img class="card-img-aside" src="${ pageContext.servletContext.contextPath }/resources/images/user/ddok.png" alt="Card image" style="width:100%;">
                    <div class="card-body">
                      <h4 class="card-title">또오겠지 분식점</h4>
                      <p class="card-text">영업시간) 10:00~ 21:00 <br> 휴무일) 월</p>
                     <a href="${ pageContext.servletContext.contextPath }/user/matzip/detail" class="btn btn-outline-dark">상세보기</a>
                      <a href="${ pageContext.servletContext.contextPath }/user/reservation" class="btn btn-danger">예약하기</a>
                    </div>
                  </div>
                  
      
                  
      
                </div><!--idcard1 끝-->
      
             
      
            

       </aside>
    </section>
   
	<jsp:include page="../user_footer.jsp"/>

  </div>

</body>
</html>