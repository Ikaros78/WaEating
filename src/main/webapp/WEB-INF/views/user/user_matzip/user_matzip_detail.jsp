<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>user_matzip_detail</title>
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
          <a href="${ pageContext.servletContext.contextPath }/user/matziplist/grade" class="list-group-item list-group-item-action py-3 select">평점별</a><!-- 상세 페이지에 select 클래스 넣어주기 -->
          <a href="${ pageContext.servletContext.contextPath }/user/matziplist/location" class="list-group-item list-group-item-action py-3">지역별</a>
          <a href="${ pageContext.servletContext.contextPath }/user/matziplist/category" class="list-group-item list-group-item-action py-3">종류별</a>
        </div>
       </aside>
       <!-- 오른쪽 (컨텐츠) -->
       <aside class="float-end col-9 mt-4 ms-3 border">
        <!-- 이미지 지우고 넣을 컨텐츠 써서 사용 -->

        <div class="img mx-4">
            <img src="${ pageContext.servletContext.contextPath }/resources/images/user/ddok1.png" width="250" height="300">
            <img src="${ pageContext.servletContext.contextPath }/resources/images/user/ddok2.jpg" width="250" height="300">
            <img src="${ pageContext.servletContext.contextPath }/resources/images/user/ddok3.png" width="250" height="300">
            <img src="${ pageContext.servletContext.contextPath }/resources/images/user/ddok4.jpg" width="250" height="300">
        </div><!--img-->
        
        <br>
        <br>
        <br>
        <h2 style="text-indent: 50px;">또 보겠지 떡볶이집 몽글몽글 청계점 &nbsp&nbsp&nbsp&nbsp <a style="text-indent: 20px; color:rgb(228, 106, 35);">4.5</a> </h2> 
        <br>
        <hr>

   
        
        <table>
           <tr>
                <th>주소</th>
                <td>서울특별시 종로구 관철동 6-4 2층</td>
            </tr>
            <tr>
                 <th>전화번호</th>
                 <td>0507-1402-4103</td>
            </tr>
           <tr>
                <th>영업시간</th>
                <td>11:00 - 21:00   (라스트오더 20:00)</td>
           </tr>
           <tr>
                <th>휴무</th>
                <td>매주 일요일</td>
           </tr>
           <tr>
                <th>카테고리</th>
                <td>분식</td>
           </tr>
           <tr>
                <th>메뉴</th>
                <td>깻잎떡볶이(1인분) : 7,500원</td>
           </tr>
           <tr>
                <th></th>            
                <td>깻잎떡볶이(2인분) : 14,000원</td>
           </tr>
           <tr>
                <th></th>
                <td>깻잎떡볶이(3인분) : 24,000원</td>
           </tr>
           <tr>
                <th></th>
                <td>버터갈릭 감자튀김 : 6,500원</td>
           </tr>
           <tr>
                <th></th>
                <td>날치알 볶음밥 : 3,500원</td>
           </tr>
           
        </table>

        <br><br>
        <hr>

        <h4 style="text-indent: 20px; color: gray;"> 리뷰(n)</h4>
        
        <div class="review_all m-5">

          <div class="review my-2 ">

            <div class="user">
              <img src="${ pageContext.servletContext.contextPath }/resources/images/user/panda.jpg" alt="panda" >
              <p>맛집판다</p>
            </div>
            <div class="content ">
              
              <div class="content_header">
                <p class="date">2022-07-17</p>
               <p class="point text-warning">★★★★☆</p>
              </div>
              <div class="content_body">
                <p>
                  떡볶이 짱 맛있었어요!! <br>
                  감자튀김도 꼭 드세요! 소스가 진해서 최고예여!! 
                </p>
                <img src="${ pageContext.servletContext.contextPath }/resources/images/user/ddok1.png" alt="">
                <img src="${ pageContext.servletContext.contextPath }/resources/images/user/ddok1.png" alt="">
                <img src="${ pageContext.servletContext.contextPath }/resources/images/user/ddok1.png" alt="">          
              </div>
              
            </div><!--content-->
            <div class="reply my-2  mx-5" style="border-radius: 8px; background-color: rgb(221, 220, 220); height: auto;">
              <img src="${ pageContext.servletContext.contextPath }/resources/images/user/right-arrow.png" alt="right-arrow" style="width:30px; height:30px; margin-left: 50px; float: left;">
              <p style="text-indent: 20px;">
                방문해주셔서 감사합니다.
              </p>
            </div><!--reply-->
          </div><!--review-->

          <div class="review my-2 ">

            <div class="user">
              <img src="${ pageContext.servletContext.contextPath }/resources/images/user/panda.jpg" alt="panda" >
              <p>맛집판다</p>
            </div>
            <div class="content ">
              
              <div class="content_header">
                <p class="date">2022-07-17</p>
                <p class="point text-warning">★★★★☆</p>
              </div>
              <div class="content_body">
                <p>
                  떡볶이 짱 맛있었어요!! <br>
                  감자튀김도 꼭 드세요! 소스가 진해서 최고예여!! 
                </p>
                <img src="${ pageContext.servletContext.contextPath }/resources/images/user/ddok1.png" alt="">
                <img src="${ pageContext.servletContext.contextPath }/resources/images/user/ddok1.png" alt="">
                <img src="${ pageContext.servletContext.contextPath }/resources/images/user/ddok1.png" alt="">          
              </div>
              
            </div><!--content-->
            <div class="reply my-2  mx-5">
              <p style="border-radius: 8px; background-color: rgb(221, 220, 220); ">
                dlskfjsaldjf;al
              </p>
            </div><!--reply-->
          </div><!--review-->

          <div class="review">

            <div class="user">
              <img src="${ pageContext.servletContext.contextPath }/resources/images/user/panda.jpg" alt="panda" >
              <p>맛집판다</p>
            </div>
            <div class="content ">
              
              <div class="content_header">
                <p class="date">2022-07-17</p>
                <p class="point text-warning">★★★★☆</p>
              </div>
              <div class="content_body">
                <p>
                  떡볶이 짱 맛있었어요!! <br>
                  감자튀김도 꼭 드세요! 소스가 진해서 최고예여!! 
                </p>
                <img src="${ pageContext.servletContext.contextPath }/resources/images/user/ddok1.png" alt="">
                <img src="${ pageContext.servletContext.contextPath }/resources/images/user/ddok1.png" alt="">
                <img src="${ pageContext.servletContext.contextPath }/resources/images/user/ddok1.png" alt="">          
              </div>
              
            </div><!--content-->
            
          </div><!--review-->

          <div class="review">

           <div class="user">
              <img src="${ pageContext.servletContext.contextPath }/resources/images/user/panda.jpg" alt="panda" >
              <p>맛집판다</p>
            </div>
            <div class="content ">
              
              <div class="content_header">
                <p class="date">2022-07-17</p>
                <p class="point text-warning">★★★★☆</p>
              </div>
              <div class="content_body">
                <p>
                  떡볶이 짱 맛있었어요!! <br>
                  감자튀김도 꼭 드세요! 소스가 진해서 최고예여!! 
                </p>
                <img src="${ pageContext.servletContext.contextPath }/resources/images/user/ddok1.png" alt="">
                <img src="${ pageContext.servletContext.contextPath }/resources/images/user/ddok1.png" alt="">
                <img src="${ pageContext.servletContext.contextPath }/resources/images/user/ddok1.png" alt="">          
              </div>
              
            </div><!--content-->
            
          </div><!--review-->

          <div class="review">

            <div class="user">
              <img src="${ pageContext.servletContext.contextPath }/resources/images/user/panda.jpg" alt="panda" >
              <p>맛집판다</p>
            </div>
            <div class="content ">
              
              <div class="content_header">
                <p class="date">2022-07-17</p>
                <p class="point text-warning">★★★★☆</p>
              </div>
              <div class="content_body">
                <p>
                  떡볶이 짱 맛있었어요!! <br>
                  감자튀김도 꼭 드세요! 소스가 진해서 최고예여!! 
                </p>
                <img src="${ pageContext.servletContext.contextPath }/resources/images/user/ddok1.png" alt="">
                <img src="${ pageContext.servletContext.contextPath }/resources/images/user/ddok1.png" alt="">
                <img src="${ pageContext.servletContext.contextPath }/resources/images/user/ddok1.png" alt="">          
              </div>
              
            </div><!--content-->
            
          </div><!--review-->

        </div> <!--review_all-->
       
        
        <p class="more">더보기</p>

        
      </aside>
    </section>
    
	<jsp:include page="../user_footer.jsp"/>

  </div>

</body>
</html>