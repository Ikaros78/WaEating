<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>업체</title>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/ceo/style.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="${ pageContext.servletContext.contextPath }/resources/js/ceo/address.js"></script>
</head>
<body>
<jsp:include page="../common/ceo_header.jsp"/>

  <div id="wrap">
    <!-- 왼쪽 (메뉴) -->
    <section class="row container-fluid px-5">
      <aside class="float-start col-2 mt-4 ms-5 px-3">
        <!-- 메뉴 제목 -->
        <h4 class="mb-3 ms-1">가게 관리</h4>
        <div class="list-group list-group-flush border-top border-bottom">
          <!-- 메뉴 세부 제목 -->
          <a href="${ pageContext.servletContext.contextPath }/ceo/rest_restInfo" class="list-group-item list-group-item-action py-3 select">가게 정보 관리</a>
          <a href="${ pageContext.servletContext.contextPath }/ceo/rest_notice" class="list-group-item list-group-item-action py-3">공지 관리</a>
          <a href="${ pageContext.servletContext.contextPath }/ceo/rest_review" class="list-group-item list-group-item-action py-3">리뷰 관리</a>
        </div>
       </aside>
       <!-- 오른쪽 (컨텐츠) -->
       <aside class="float-end col-9 mt-4 ms-3" style="min-height : 860px">
        <!-- 이미지 지우고 넣을 컨텐츠 써서 사용 -->
        <!-- <img src="img/visual.jpg" width="100%">  -->
        <div class="px-5 py-3">
          
            
            <div class="my-4 row mx-1 px-5">
              <form action="${ pageContext.servletContext.contextPath }/ceo/rest_restInfo_modify" method="post">
              	<!-- <input type="hidden" name="comNo" value="${ requestScope.comInfo.comNo }"> 업체 로그인 정보 넘기기 -->
              	<div class="container-fluid">
            		<div class="container my-3 d-flex justify-content-center" style="height : 300px">
              			 <c:forEach var="image" items="${ requestScope.comBoard }" >        
            			 <img src="${ pageContext.servletContext.contextPath }/resources/upload/com_info/${ image.fileName }" class="mx-2" width="280" height="300">
        		         </c:forEach>
            	   </div>
          	    </div>
              	<!-- <div class="container-fluid">
            		<div class="container my-3 d-flex justify-content-center">
              			<div class="content-img-area1" id="contentImgArea1"><img id="contentImg1" class="mx-2" width="350px" height="300px"><input type="file" id="thumbnailImg1" name="thumbnailImg1" onchange="loadImg(this,1)" style="width:350px" class="mx-2 mt-3"></div>
              			<div class="content-img-area2" id="contentImgArea2"><img id="contentImg2" class="mx-2" width="350px" height="300px"><input type="file" id="thumbnailImg2" name="thumbnailImg2" onchange="loadImg(this,2)" style="width:350px" class="mx-2 mt-3"></div>
              			<div class="content-img-area3" id="contentImgArea3"><img id="contentImg3" class="mx-2" width="350px" height="300px"><input type="file" id="thumbnailImg3" name="thumbnailImg3" onchange="loadImg(this,3)" style="width:350px" class="mx-2 mt-3"></div>
            	   </div>
          	    </div> -->
                <table width="100%">
                  <tr>
                    <td class="col-1">가게명</td>
                    <td class="col-4"><input type="text" class="form-control my-3" value="${ requestScope.comInfo.comName }" name="comName"></td>
                    <td class="col-1"></td>
                    <td class="col-1">전화번호</td>
                    <td class="col-4"><input type="text" class="form-control" value="${ requestScope.comInfo.comPhone }" name="comPhone"></td>
                  </tr>
                  <tr>
                    <td class="pb-3 col-1">주소</td>
                    <td class="pb-3 col-4">
                      <input type="text" id="address_kakao" class="form-control" value="${ requestScope.comInfo.comAddress }" name="comAddress">
                    </td>
                    <td class="col-1"></td>
                    <td class="pb-3 col-1">카테고리</td>
                    <td class="pb-3 col-4">
                    <c:set var = "category" value="${ requestScope.comInfo.category }"/>
                      <select class="form-select" name="category" id="category">
                      	<c:if test="${ category eq '한식' }">
                        <option selected>한식</option>
                        <option>분식</option>
                        <option>양식</option>
                        <option>일식</option>
                        <option>중식</option>
                        <option>기타</option>
                        <option>카페</option>                   	
                      	</c:if>
                      	<c:if test="${ category eq '분식' }">
                        <option>한식</option>
                        <option selected>분식</option>
                        <option>양식</option>
                        <option>일식</option>
                        <option>중식</option>
                        <option>기타</option>
                        <option>카페</option>                           	
                      	</c:if>
                      	<c:if test="${ category eq '양식' }">
                        <option>한식</option>
                        <option>분식</option>
                        <option selected>양식</option>
                        <option>일식</option>
                        <option>중식</option>
                        <option>기타</option>
                        <option>카페</option>                          	
                      	</c:if>
                      	<c:if test="${ category eq '일식' }">
                        <option>한식</option>
                        <option>분식</option>
                        <option>양식</option>
                        <option selected>일식</option>
                        <option>중식</option>
                        <option>기타</option>
                        <option>카페</option>                             	
                      	</c:if>
                      	<c:if test="${ category eq '중식' }">
                        <option>한식</option>
                        <option>분식</option>
                        <option>양식</option>
                        <option>일식</option>
                        <option selected>중식</option>
                        <option>기타</option>
                        <option>카페</option>                          	
                      	</c:if>
                      	<c:if test="${ category eq '기타' }">
                        <option>한식</option>
                        <option>분식</option>
                        <option>양식</option>
                        <option>일식</option>
                        <option>중식</option>
                        <option selected>기타</option>
                        <option>카페</option>                             	
                      	</c:if>
                      	<c:if test="${ category eq '카페' }">
                        <option>한식</option>
                        <option>분식</option>
                        <option>양식</option>
                        <option>일식</option>
                        <option>중식</option>
                        <option>기타</option>
                        <option selected>카페</option>                             	
                      	</c:if>
                      	<c:if test="${ empty category }">
                        <option selected>한식</option>
                        <option>분식</option>
                        <option>양식</option>
                        <option>일식</option>
                        <option>중식</option>
                        <option>기타</option>
                        <option>카페</option>                   	
                      	</c:if>
                      </select>
                    </td>
                  </tr>
                  <tr>
                    <td class="pb-3 col-1">영업시간</td>
                    <td class="pb-3 col-4">
                      <div class="input-group">
                        <input type="time" class="form-control" name="startTime" id="startTime" value="${ requestScope.comInfo.startTime }">
                        <input type="time" class="form-control" name="endTime" id="endTime" value="${ requestScope.comInfo.endTime }">
                      </div>
                    </td>
                    <td class="col-1"></td>
                    <td class="pb-3 col-1">휴일</td>
                    <td class="pb-3 col-4">
                    <c:set var = "holiday" value="${ requestScope.comInfo.holiday }"/>
                      <select class="form-select" name="holiday" id="holiday">
                      		<option value="연중무휴">-</option>
	                        <option value="월" selected>월</option>
	                        <option value="화">화</option>
	                        <option value="수">수</option>
	                        <option value="목">목</option>
	                        <option value="금">금</option>
	                        <option value="토">토</option>
	                        <option value="일">일</option>     
                        <c:if test="${fn:contains(holiday, '월')}">
	                      	<option value="연중무휴">-</option>
	                        <option value="월" selected>월</option>
	                        <option value="화">화</option>
	                        <option value="수">수</option>
	                        <option value="목">목</option>
	                        <option value="금">금</option>
	                        <option value="토">토</option>
	                        <option value="일">일</option>                          	
	                      </c:if>
	                      <c:if test="${fn:contains(holiday, '화')}">
	                        <option value="연중무휴">-</option>
	                        <option value="월">월</option>
	                        <option value="화" selected>화</option>
	                        <option value="수">수</option>
	                        <option value="목">목</option>
	                        <option value="금">금</option>
	                        <option value="토">토</option>
	                        <option value="일">일</option>                             	
	                      </c:if>
	                      <c:if test="${fn:contains(holiday, '수')}">
	                        <option value="연중무휴">-</option>
	                        <option value="월">월</option>
	                        <option value="화">화</option>
	                        <option value="수" selected>수</option>
	                        <option value="목">목</option>
	                        <option value="금">금</option>
	                        <option value="토">토</option>
	                        <option value="일">일</option>                       	
	                      </c:if>
	                      <c:if test="${fn:contains(holiday, '목')}">
	                        <option value="연중무휴">-</option>
	                        <option value="월">월</option>
	                        <option value="화">화</option>
	                        <option value="수">수</option>
	                        <option value="목" selected>목</option>
	                        <option value="금">금</option>
	                        <option value="토">토</option>
	                        <option value="일">일</option>                                        	
	                      </c:if>
	                      <c:if test="${fn:contains(holiday, '금')}">
	                        <option value="연중무휴">-</option>
	                        <option value="월">월</option>
	                        <option value="화">화</option>
	                        <option value="수">수</option>
	                        <option value="목">목</option>
	                        <option value="금" selected>금</option>
	                        <option value="토">토</option>
	                        <option value="일">일</option>                              	
	                      </c:if>
	                      <c:if test="${fn:contains(holiday, '토')}">
	                        <option value="연중무휴">-</option>
	                        <option value="월">월</option>
	                        <option value="화">화</option>
	                        <option value="수">수</option>
	                        <option value="목">목</option>
	                        <option value="금">금</option>
	                        <option value="토" selected>토</option>
	                        <option value="일">일</option>                          	
	                      </c:if>
	                      <c:if test="${fn:contains(holiday, '일')}">
	                        <option value="연중무휴">-</option>
	                        <option value="월">월</option>
	                        <option value="화">화</option>
	                        <option value="수">수</option>
	                        <option value="목">목</option>
	                        <option value="금">금</option>
	                        <option value="토">토</option>
	                        <option value="일" selected>일</option>                          	
	                      </c:if>
	                      <c:if test="${fn:contains(holiday, '연중무휴')}">
	                      	<option value="연중무휴" selected>-</option>
	                        <option value="월">월</option>
	                        <option value="화">화</option>
	                        <option value="수">수</option>
	                        <option value="목">목</option>
	                        <option value="금">금</option>
	                        <option value="토">토</option>
	                        <option value="일">일</option>                          	
	                      </c:if>
                      </select>
                    </td>
                  </tr>
                  <tr>
                    <td class="pb-3" rowspan="100">메뉴</td>
                      <td class="pb-3">
                        <div id="menugroup">
                          
                          <c:forEach items="${ requestScope.comMenuList }" var="menu" varStatus="status">
                          
                          <div class="input-group my-3" id="menu" >
                              <input type="text" name="menuName" id="menuName" class="form-control" value="${ menu.comMenu.menuName }">
                              <input type="text" name="price" id="menuPrice" class="form-control" value="${ menu.comMenu.price }">
                              <button class="btn btn-light border minus" type="button" id="minus">-</button>
                              <button class="btn btn-primary plus" type="button" id="plus">+</button>
                          </div>
                          
                          </c:forEach>
                          <div class="input-group my-3" id="menu" >
                              <input type="text" name="menuName" id="menuName" class="form-control" value="${ menu.comMenu.menuName }">
                              <input type="text" name="price" id="menuPrice" class="form-control" value="${ menu.comMenu.price }">
                              <button class="btn btn-light border minus" type="button" id="minus">-</button>
                              <button class="btn btn-primary plus" type="button" id="plus">+</button>
                          </div>
                     
                        </div>
                      </td>
                      
                  </tr>
                  
                 
                </table>
                <div class="col d-flex justify-content-center mt-4">
                  <button class="btn btn-light border me-1" type="reset" onclick="location.href='${ pageContext.servletContext.contextPath }/ceo/rest_restInfo'">취소</button>
                  <button class="btn btn-primary border ms-1" type="button" data-bs-toggle="modal" data-bs-target="#modalSubmit">확인</button>
                </div>
                <!-- Modal(수정) -->
                <div class="modal fade" id="modalSubmit">
                  <div class="modal-dialog">
                    <div class="modal-content">
                
                      <!-- Modal Header -->
                      <div class="modal-header">
                        <h4 class="modal-title">가게 정보 수정</h4>
                        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                      </div>
                
                      <!-- Modal body -->
                      <div class="modal-body">
                        가게 정보를 수정하시겠습니까?
                      </div>
                
                      <!-- Modal footer -->
                      <div class="modal-footer">
                        <button type="submit" class="btn btn-primary" data-bs-dismiss="modal">확인</button>
                      </div>
                
                    </div>
                  </div>
                </div>
              </form>
              
             <!-- <script>
             if(document.getElementById("plus")){
 	      		const $insert = document.getElementById("plus");
 	      		$insert.onclick = function(){
 	      			location.href = "${ pageContext.servletContext.contextPath}/ceo/rest_restInfo_modify/insertmenu?menuNo=${ requestScope.comSelectOneComMenu.menuNo }";
 	      		}
 	      	  }
	          if(document.getElementById("minus")){
	      		const $delete = document.getElementById("minus");
	      		$delete.onclick = function(){
	      			location.href = "${ pageContext.servletContext.contextPath}/ceo/rest_restInfo_modify/deletemenu?menuNo=${ requestScope.comSelectOneComMenu.menuNo }";
	      		}
	      	  }
          	</script> -->
                  
            
                      
            </div>
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
			
		</script>
            <script src="${ pageContext.servletContext.contextPath }/resources/js/ceo/addmenu.js"></script>
        </div>
       </aside>
    </section>
   
    <jsp:include page="../common/ceo_footer.jsp"/>

  </div>
</body>
</html>