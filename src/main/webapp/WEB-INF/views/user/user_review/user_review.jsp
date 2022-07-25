<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>user_review</title>
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
          <a href="user_matziplist_grade.html" class="list-group-item list-group-item-action py-3 select">평점별</a><!-- 상세 페이지에 select 클래스 넣어주기 -->
          <a href="user_matziplist_location.html" class="list-group-item list-group-item-action py-3">지역별</a>
          <a href="user_matziplist_category.html" class="list-group-item list-group-item-action py-3">종류별</a>
        </div>
       </aside>
       <!-- 오른쪽 (컨텐츠) -->
       <aside class="float-end col-9 mt-4 ms-3 border">
        <!-- 이미지 지우고 넣을 컨텐츠 써서 사용 -->
       
        <br>
        <h2 style="text-indent: 30px;">리뷰 작성</h2>
        <hr>
        <div class="review1 mx-4">
            <h5>[또 보겠지 떡볶이집 몽글몽글 청계점]</h5>
            <p style="color: gray;">2022/07/17</p>
            <br>
            <h6><나의 예약 정보></h6>
            <p>번호 : 6번</p>
            <p>인원수 : 3명</p>
            <p>전화번호 : 010-1234-5678</p>
        </div>
        <br>
        <div class="review_write">
            <form action="/action_page.php">
            <br>
            <h5 style="text-align: center;">별점을 입력해주세요.</h5>
            <div class="star-rating space-x-4 mx-auto">
                <input type="radio" id="5-stars" name="rating" value="5" v-model="ratings"/>
                <label for="5-stars" class="star pr-4">★</label>
                <input type="radio" id="4-stars" name="rating" value="4" v-model="ratings"/>
                <label for="4-stars" class="star">★</label>
                <input type="radio" id="3-stars" name="rating" value="3" v-model="ratings"/>
                <label for="3-stars" class="star">★</label>
                <input type="radio" id="2-stars" name="rating" value="2" v-model="ratings"/>
                <label for="2-stars" class="star">★</label>
                <input type="radio" id="1-star" name="rating" value="1" v-model="ratings" />
                <label for="1-star" class="star">★</label>
            </div>
            <div class="container mt-3">
                
                <br>
                  <div class="mb-3 mt-3">
                    <label for="comment">리뷰를 입력해주세요:</label>
                    <textarea class="form-control" rows="5" id="comment" name="text"></textarea>
                  </div>
                  <button type="submit" class="btn btn-primary" style="margin-left: 43%;" >사진추가</button>
                  <button type="submit" class="btn btn-primary" >등록하기</button>
            </div>


            </form>
        </div>


       </aside>
    </section>
   
    <jsp:include page="../user_footer.jsp"/>
  </div>

</body>
</html>