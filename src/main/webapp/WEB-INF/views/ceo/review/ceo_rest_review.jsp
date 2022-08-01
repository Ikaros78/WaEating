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
          <a href="${ pageContext.servletContext.contextPath }/ceo/rest_notice" class="list-group-item list-group-item-action py-3">공지 관리</a>
          <a href="${ pageContext.servletContext.contextPath }/ceo/rest_review" class="list-group-item list-group-item-action py-3 select">리뷰 관리</a>
        </div>
       </aside>
       <!-- 오른쪽 (컨텐츠) -->
       <aside class="float-end col-9 mt-4 ms-3" style="min-height : 700px">
        <!-- 이미지 지우고 넣을 컨텐츠 써서 사용 -->
        <!-- <img src="img/visual.jpg" width="100%">  -->
        <div class="px-5 py-3">
          <h3 class="ps-2">리뷰(${ requestScope.totalCount })</h3>
          <table width="100%" class="table table-borderless">
           	  <c:forEach var="review" items="${ requestScope.selectAllReview }">
           	  <tr class="border-bottom">
                <td class="col-10 pt-3"><c:out value="${ review.reviewContent }"/></td>
                <td class="d-flex justify-content-end"><button type="button" class="btn btn-primary"><a href="${ pageContext.servletContext.contextPath }/ceo/rest_review_detail_new?reviewNo=${ review.reviewNo }" style="color:#fff; text-decoration: none;">답변 등록</a></button></td>         
              </tr>
              </c:forEach>
            
             <%--  <tr class="border-bottom">
                <td class="col-10 pt-3">웨이팅이 있었지만 금방 들어갔어요. 돈까스도 맛있고 다음에 또 오고싶어요!</td>
                <td class="d-flex justify-content-end"><button type="button" class="btn btn-primary"><a href="${ pageContext.servletContext.contextPath }/ceo/rest_review_detail_new" style="color:#fff; text-decoration: none;">답변 등록</a></button></td>         
              </tr>
              <tr class="border-bottom">
                <td class="col-10 pt-3">메뉴가 다양해서 가족들이랑 오기 좋았어요.</td>
                <td class="d-flex justify-content-end"><button type="button" class="btn btn-primary"><a href="${ pageContext.servletContext.contextPath }/ceo/rest_review_detail_new" style="color:#fff; text-decoration: none;">답변 등록</a></button></td>
              </tr>
              <tr class="border-bottom">
                <td class="col-10 pt-3">돈까스도 바삭바삭하고 수프가 맛있었어요.</td>
                <td class="d-flex justify-content-end"><button type="button" class="btn btn-primary"><a href="${ pageContext.servletContext.contextPath }/ceo/rest_review_detail_new" style="color:#fff; text-decoration: none;">답변 등록</a></button></td>
              </tr>
              <tr class="border-bottom">
                <td class="col-10 pt-3">너무 맛있게 잘 먹고 갑니다.</td>
                <td class="d-flex justify-content-end"><button type="button" class="btn btn-light"><a href="${ pageContext.servletContext.contextPath }/ceo/rest_review_detail_modify" style="color: #6c757d; text-decoration: none;">답변 완료</a></button></td>
              </tr> --%>
            
          </table>
          
          <jsp:include page="../common/paging_review.jsp"/>
          
          <!-- <ul class="pagination justify-content-center">
            <li class="page-item"><a class="page-link" href="#" style="color: #6c757d;"><</a></li>
            <li class="page-item active"><a class="page-link" href="#" style="border:#D94925 1px solid; background-color: #D94925; color: #fff;">1</a></li>
            <li class="page-item"><a class="page-link" href="#" style="color: #6c757d;">2</a></li>
            <li class="page-item"><a class="page-link" href="#" style="color: #6c757d;">3</a></li>
            <li class="page-item"><a class="page-link" href="#" style="color: #6c757d;">></a></li>
          </ul> -->     
           
        </div>
       </aside>
    </section>
   
    <jsp:include page="../common/ceo_footer.jsp"/>

  </div>
</body>
</html>