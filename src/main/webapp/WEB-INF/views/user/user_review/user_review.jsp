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
        <h4 class="mb-3 ms-1">맛집리스트</h4>
        <div class="list-group list-group-flush border-top border-bottom" >
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
        <h2 style="text-indent: 30px;">리뷰 작성</h2>
        <hr>
        <div class="review1 mx-4">
            <h5>${ requestScope.waitingRecord.comInfo.comName }</h5>
            <p style="color: gray;">${ requestScope.waitingRecord.useDate }</p>
            <br>
            <h6><나의 예약 정보></h6>
            <p>인원수 : ${ requestScope.waitingRecord.memberNum } </p>
            <p>전화번호 : ${ requestScope.waitingRecord.memberInfo.phone }</p>
        </div>
        <br>
        <div class="review_write">
            <form name ="review"action="${ pageContext.servletContext.contextPath }/user/review/image/insert" method="post" encType="multipart/form-data">
            <input type="hidden" class="comNo" name="comNo" value="${ requestScope.waitingRecord.comNo }">
			<input type="hidden" class="recordNo" name="recordNo" value="${ requestScope.waitingRecord.recordNo }">
            <br>
            <h5 style="text-align: center;">별점을 입력해주세요.</h5>
            <div class="star-rating space-x-4 mx-auto">
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
            </div>
            <div class="container mt-3">
                
                <br>
            <table>
            	<tr>
            		<td>
            			<div class="content-img-area1" id="contentImgArea1">
								<img id="contentImg1" width="120" height="100">
						</div>
            		</td>
            		<td>
            			<div class="content-img-area2" id="contentImgArea2">
								<img id="contentImg2" width="120" height="100">
						</div>
            		</td>
            		<td>
            			<div class="content-img-area3" id="contentImgArea3">
								<img id="contentImg3" width="120" height="100">
						</div>
            		</td>
            	</tr>
            </table>
			    <div class="thumbnail-file-area">
					<input type="file" id="thumbnailImg1" name="thumbnailImg1" onchange="loadImg(this,1)">
					<input type="file" id="thumbnailImg2" name="thumbnailImg2" onchange="loadImg(this,2)">
					<input type="file" id="thumbnailImg3" name="thumbnailImg3" onchange="loadImg(this,3)">
				</div>
                  <div class="mb-3 mt-3">
                    <label for="reviewContent">리뷰를 입력해주세요</label>
                    <textarea class="form-control" rows="5" id="summernote" name="reviewContent" ></textarea>
                  </div>
            </div>
            
            <div class="col text-center">
                  <button type="submit" class="btn btn-primary" >등록하기</button>
    		</div>
            

            </form>
            
            <script>
			const $contentImgArea1 = document.getElementById("contentImgArea1");
			const $contentImgArea2 = document.getElementById("contentImgArea2");
			const $contentImgArea3 = document.getElementById("contentImgArea3");
			
			$titleImgArea1.onclick = function() { 
				document.getElementById("thumbnailImg1").click(); 
			}
			
			$contentImgArea2.onclick = function() {
				document.getElementById("thumbnailImg2").click();
			}
			
			$contentImgArea3.onclick = function() {
				document.getElementById("thumbnailImg3").click();
			}
			
			
			function loadImg(value, num) {
				if (value.files && value.files[0]) {
					const reader = new FileReader();
					reader.onload = function(e) {
						switch(num){
						case 1:
							document.getElementById("contentImg1").src = e.target.result;
							break;
						case 2:
							document.getElementById("contentImg2").src = e.target.result;
							break;
						case 3:
							document.getElementById("contentImg3").src = e.target.result;
							break;
						}
					}
					reader.readAsDataURL(value.files[0]);
				}
			}
			
			
			
			function check(){
			    var sum=0;
			    for(i=0;i<document.review.ratings.length;i++){
			          if(document.review.ratings[i].checked == false){
			              sum +=sum;
			          }
			          else{
			              sum = sum+1;
			          }
			    }
			    if(sum ==0){
			alert("별점을 입력해주세요!");
			return false;
			    }
			    else{document.review.submit();}
			}
			
		</script>
        </div>


       </aside>
    </section>
   
    <jsp:include page="../user_footer.jsp"/>
  </div>

</body>
</html>