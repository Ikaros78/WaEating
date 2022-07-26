<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
          <a href="${ pageContext.servletContext.contextPath }/ceo/rest_notice" class="list-group-item list-group-item-action py-3 select">공지 관리</a>
          <a href="${ pageContext.servletContext.contextPath }/ceo/rest_review" class="list-group-item list-group-item-action py-3">리뷰 관리</a>
        </div>
       </aside>
       <!-- 오른쪽 (컨텐츠) -->
       <aside class="float-end col-9 mt-4 ms-3">
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
              <div class="tr">
                <div class="td col-1 text-center">2</div>
                <div class="td fs-5"><a href="${ pageContext.servletContext.contextPath }/ceo/rest_notice_detail_modify">방문고객 이벤트</a></div>
                <div class="td col-2 text-center">2022.07.01</div>
              </div>
              <div class="tr">
                <div class="td col-1 text-center">1</div>
                <div class="td fs-5"><a href="${ pageContext.servletContext.contextPath }/ceo/rest_notice_detail_modify">공지사항</a></div>
                <div class="td col-2 text-center">2022.06.23</div>
              </div>
            </div>
           
            <ul class="pagination justify-content-center">
              <li class="page-item"><a class="page-link" href="#" style="color: #6c757d;"><</a></li>
              <li class="page-item active"><a class="page-link" href="#" style="border:#D94925 1px solid; background-color: #D94925; color: #fff;">1</a></li>
              <!-- <li class="page-item"><a class="page-link" href="#" style="color: #6c757d;">2</a></li>
              <li class="page-item"><a class="page-link" href="#" style="color: #6c757d;">3</a></li> -->
              <li class="page-item"><a class="page-link" href="#" style="color: #6c757d;">></a></li>
            </ul>     
             
        </div>
       </aside>
    </section>
   
    <jsp:include page="../common/ceo_footer.jsp"/>

  </div>
</body>
</html>