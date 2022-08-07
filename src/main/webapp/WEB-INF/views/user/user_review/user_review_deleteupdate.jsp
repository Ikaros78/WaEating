<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>user_review_delete&update</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/user/user.css">
   <!-- bootstrap -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- jquery -->
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<!-- summernote -->
	<script src="${ pageContext.servletContext.contextPath }/resources/js/summernote/summernote-lite.js"></script>
	<script src="${ pageContext.servletContext.contextPath }/resources/js/summernote/lang/summernote-ko-KR.js"></script>
	<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/summernote/summernote-lite.css">
	<!-- summernote script -->
	<script src="${ pageContext.servletContext.contextPath }/resources/js/summernote/summernote.js"></script>
</head>
<body>
  <jsp:include page="../user_header.jsp"/>

  <div id="wrap">
    <!-- 왼쪽 (메뉴) -->
    <section class="row container-fluid px-5">
      <aside class="float-start col-2 mt-4 ms-5 px-3" style="min-height:700px;">
        <!-- 메뉴 제목 -->
        <h4 class="mb-3 ms-1">나의 예약</h4>
        <div class="list-group list-group-flush border-top border-bottom">
          <!-- 메뉴 세부 제목 -->
          <a href="${ pageContext.servletContext.contextPath }/user/reservation/finish" class="list-group-item list-group-item-action py-3 select">이전 예약</a><!-- 상세 페이지에 select 클래스 넣어주기 -->
          <a href="${ pageContext.servletContext.contextPath }/user/reservation/now" class="list-group-item list-group-item-action py-3 ">현재 예약</a>
          <a href="${ pageContext.servletContext.contextPath }/user/reservation/cancel" class="list-group-item list-group-item-action py-3">취소한 예약</a>
        </div>
       </aside>
       <!-- 오른쪽 (컨텐츠) -->
       <aside class="float-end col-9 mt-4 ms-3 border">
        <!-- 이미지 지우고 넣을 컨텐츠 써서 사용 -->
       
        <br>
        <h2 style="text-indent: 30px;">내가 쓴 리뷰</h2>
        <hr>
        <div class="review mx-4 ">
            <h5>[${ requestScope.waitingRecord.comInfo.comName }]</h5>
            <p style="color: gray;">${ requestScope.waitingRecord.useDate }</p>
            <br>
            <h6><나의 예약 정보></h6>
            <p>인원수 : ${ requestScope.waitingRecord.memberNum }</p>
            <p>전화번호 : ${ requestScope.waitingRecord.memberInfo.phone }</p>
        </div> <!-- review -->
        <br>
        <form action="${ pageContext.servletContext.contextPath }/user/review/selecteupdate" method="post">
        <div class="review_write">
        <br>
      
            <div class="container mt-3">

                <div class="content_header">
                    <%-- <p class="date">${ requestScope.review.waitingRecord.useDate }</p> --%>
                    
                <div class="star-rating space-x-4 mx-auto">
                   <c:if test="${ requestScope.review.ratings eq '5' }">
	                <input type="radio" id="5-stars" name="ratings" value="5" checked/>
	                <label for="5-stars" class="star pr-4">★</label>
	                <input type="radio" id="4-stars" name="ratings" value="4"/>
	                <label for="4-stars" class="star">★</label>
	                <input type="radio" id="3-stars" name="ratings" value="3"/>
	                <label for="3-stars" class="star">★</label>
	                <input type="radio" id="2-stars" name="ratings" value="2"/>
	                <label for="2-stars" class="star">★</label>
	                <input type="radio" id="1-star" name="ratings" value="1"/>
	                <label for="1-star" class="star">★</label>
                   </c:if>
                   <c:if test="${ requestScope.review.ratings eq '4' }">
	                <input type="radio" id="5-stars" name="ratings" value="5"/>
	                <label for="5-stars" class="star pr-4">★</label>
	                <input type="radio" id="4-stars" name="ratings" value="4" checked/>
	                <label for="4-stars" class="star">★</label>
	                <input type="radio" id="3-stars" name="ratings" value="3"/>
	                <label for="3-stars" class="star">★</label>
	                <input type="radio" id="2-stars" name="ratings" value="2"/>
	                <label for="2-stars" class="star">★</label>
	                <input type="radio" id="1-star" name="ratings" value="1"/>
	                <label for="1-star" class="star">★</label>
                   </c:if>
                   <c:if test="${ requestScope.review.ratings eq '3' }">
	                 <input type="radio" id="5-stars" name="ratings" value="5"/>
	                <label for="5-stars" class="star pr-4">★</label>
	                <input type="radio" id="4-stars" name="ratings" value="4"/>
	                <label for="4-stars" class="star">★</label>
	                <input type="radio" id="3-stars" name="ratings" value="3" checked/>
	                <label for="3-stars" class="star">★</label>
	                <input type="radio" id="2-stars" name="ratings" value="2"/>
	                <label for="2-stars" class="star">★</label>
	                <input type="radio" id="1-star" name="ratings" value="1"/>
	                <label for="1-star" class="star">★</label>
                   </c:if>
                   <c:if test="${ requestScope.review.ratings eq '2' }">
	                 <input type="radio" id="5-stars" name="ratings" value="5"/>
	                <label for="5-stars" class="star pr-4">★</label>
	                <input type="radio" id="4-stars" name="ratings" value="4"/>
	                <label for="4-stars" class="star">★</label>
	                <input type="radio" id="3-stars" name="ratings" value="3"/>
	                <label for="3-stars" class="star">★</label>
	                <input type="radio" id="2-stars" name="ratings" value="2" checked/>
	                <label for="2-stars" class="star">★</label>
	                <input type="radio" id="1-star" name="ratings" value="1"/>
	                <label for="1-star" class="star">★</label>
                   </c:if>
                   <c:if test="${ requestScope.review.ratings eq '1' }">
	                 <input type="radio" id="5-stars" name="ratings" value="5"/>
	                <label for="5-stars" class="star pr-4">★</label>
	                <input type="radio" id="4-stars" name="ratings" value="4"/>
	                <label for="4-stars" class="star">★</label>
	                <input type="radio" id="3-stars" name="ratings" value="3"/>
	                <label for="3-stars" class="star">★</label>
	                <input type="radio" id="2-stars" name="ratings" value="2"/>
	                <label for="2-stars" class="star">★</label>
	                <input type="radio" id="1-star" name="ratings" value="1" checked/>
	                <label for="1-star" class="star">★</label>
                   </c:if>
                   
	                
            	</div>
             	
                </div><!-- content_header -->
                 <textarea class="form-control" rows="5" id="summernote" name="reviewContent" required>
                 	${requestScope.review.reviewContent }
                 </textarea>
              	<c:forEach var="reviewImg" items="${ requestScope.reviewAttach }">
                	<img src="${ pageContext.servletContext.contextPath }/resources/upload/review/origin/${ reviewImg.fileName }" alt="" style="width:150px; height:150px; margin:20px;">
              	</c:forEach>
     
                 
            </div><!-- container -->
            <div class="d-flex justify-content-end">
                  <button type="submit" class="btn btn-primary me-3" style="margin-top: 10px;" >수정하기</button>
                  <button type="button" id="ReviewDelete" class="btn btn-danger me-4" style="margin-top: 10px;">삭제하기</button>
            </div>
        </div><!-- review_writer -->
        </form>
          <script>
          	if(document.getElementById("ReviewDelete")){
          		const $delete = document.getElementById("ReviewDelete");
          		$delete.onclick = function(){
          			location.href = "${ pageContext.servletContext.contextPath }/user/review/delete?recordNo=${ requestScope.review.recordNo }";
          		}
          	}
          </script>
      </aside>
    </section>
   
        


    <jsp:include page="../user_footer.jsp"/>
  </div><!-- wrap -->

</body>
</html>