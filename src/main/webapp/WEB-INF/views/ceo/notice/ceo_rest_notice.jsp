<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>업체</title>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/ceo/rest_detail_style.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<style type="text/css">
#searchCondition{
	width: 55px;
}

#searchValue{
	width : 250px;
}
</style>
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
          <a href="${ pageContext.servletContext.contextPath }/ceo/rest_restInfo" class="list-group-item list-group-item-action py-3">가게 정보 관리</a>
          <a href="${ pageContext.servletContext.contextPath }/ceo/rest_notice" class="list-group-item list-group-item-action py-3 select">공지 관리</a>
          <a href="${ pageContext.servletContext.contextPath }/ceo/rest_review" class="list-group-item list-group-item-action py-3">리뷰 관리</a>
        </div>
       </aside>
       <!-- 오른쪽 (컨텐츠) -->
       <aside class="float-end col-9 mt-4 ms-3" style="min-height : 860px">
        <!-- 이미지 지우고 넣을 컨텐츠 써서 사용 -->
        <!-- <img src="img/visual.jpg" width="100%">  -->
        <div class="px-5 py-3">
          <div class="row">
            <h3 class="col-6 ps-4">공지사항</h3>
            <div class="d-flex justify-content-end pe-4 col-6">
              <button type="button" class="btn btn-light"><a href="${ pageContext.servletContext.contextPath }/ceo/rest_notice_detail_new" style="color:#6c757d; text-decoration: none;">공지 등록하기</a></button>
            </div>
          </div>
            <div class="thead">
              <div class="tr">
                <div class="th col-1 text-center">번호</div>
                <div class="th">제목</div>
                <div class="th col-2 text-center">등록일자</div>
              </div>
            </div>
            <div class="tbody">
              <c:forEach var="notice" items="${ requestScope.selectAllNotice }" varStatus="status">
	              <div class="tr">
	                <div class="td col-1 text-center"><c:out value="${ notice.rNum }"/></div>
	                <div class="td fs-5"><a href="${ pageContext.servletContext.contextPath }/ceo/rest_notice_detail?noticeNo=${ notice.noticeNo }"><c:out value="${ notice.noticeTitle }"/></a></div>
	                <div class="td col-2 text-center"><c:out value="${ notice.regDate }"/></div>
	              </div>
              </c:forEach>
            </div>
            
            <jsp:include page="../common/paging_notice.jsp"/>
           
            <!-- <ul class="pagination justify-content-center">
              <li class="page-item"><a class="page-link" href="#" style="color: #6c757d;"><</a></li>
              <li class="page-item active"><a class="page-link" href="#" style="border:#D94925 1px solid; background-color: #D94925; color: #fff;">1</a></li>
              <li class="page-item"><a class="page-link" href="#" style="color: #6c757d;">2</a></li>
              <li class="page-item"><a class="page-link" href="#" style="color: #6c757d;">3</a></li>
              <li class="page-item"><a class="page-link" href="#" style="color: #6c757d;">></a></li>
            </ul> -->     
            
            <div class="mt-3"></div>
            <!-- 검색 폼 -->
			<div class="search-area" align="center">
				<form id="loginForm" action="${ pageContext.servletContext.contextPath }/ceo/rest_notice" method="get" style="display:inline-block">
				<div class="input-group mb-3">
				<input type="hidden" class="form-control" name="currentPage" value="1">
				    <select id="searchCondition" name="searchCondition" class="form-control">
						<option value="noticeTitle" ${ requestScope.selectCriteria.searchCondition eq "noticeTitle"? "selected": "" }>제목</option>
					</select>
			        <input type="text" class="form-control" id="searchValue" name="searchValue" value="<c:out value="${ requestScope.selectCriteria.searchValue }"/>">
					<button type="submit" class="btn btn-primary">검색하기</button>
				</div>		
				    
				</form>
				<%-- <c:if test="${ !empty sessionScope.loginMember }">
					<button id="writeBoard">작성하기</button>
				</c:if> --%>
			</div>
             
        </div>
       </aside>
    </section>
   
    <jsp:include page="../common/ceo_footer.jsp"/>
	
  </div>
  
  <script>
		
		if(document.getElementsByClassName('td')) {
			
			const $tds = document.getElementsByClassName('td');
			for(let i = 0; i < $tds.length; i++) {
				
				$tds[i].onmouseenter = function() {
					this.parentNode.style.cursor = "pointer";
				}
				
				$tds[i].onclick = function() {
					/* 게시물 번호까지 알아왔으니 이제 상세보기는 할 수 있습니다. */
					
					/* alert(this.parentNode.children[1].innerText); */
					
					//location.href = ""
					
				}
				
			}
			
		}
		
	</script>
</body>
</html>