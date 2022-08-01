<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>업체</title>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/ceo/rest_detail_style.css">
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
        	<h1>${ requestScope.selectOneNotice.noticeTitle }</h1>
            <h6 class="text-end">${ requestScope.selectOneNotice.regDate }</h6>
            <hr>
            <div class="py-3" style="min-height: 450px">
              ${ requestScope.selectOneNotice.noticeContent }
            </div>
            <div class="d-flex justify-content-center">
              <button type="button" class="btn btn-outline-danger me-2" value="삭제" data-bs-toggle="modal" data-bs-target="#modalDeleteq">삭제</button>
              <button type="button" class="btn btn-outline-primary" value="수정" onclick="location.href='${ pageContext.servletContext.contextPath }/ceo/rest_notice_detail_modify?noticeNo=${ requestScope.selectOneNotice.noticeNo }'">수정</button>
            </div>
        </div>
        
        <div class="modal fade" id="modalDeleteq">
              <div class="modal-dialog">
                <div class="modal-content">
            
                  <div class="modal-header">
                    <h4 class="modal-title">공지 삭제</h4>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                  </div>
            
                  <div class="modal-body">
                    공지를 삭제하시겠습니까?
                  </div>
            
                  <div class="modal-footer">
                    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modalDelete">확인</button>
                  </div>
                </div>
              </div>
            </div>

            <div class="modal fade" id="modalDelete">
              <div class="modal-dialog">
                <div class="modal-content">
            
                  <div class="modal-header">
                    <h4 class="modal-title">공지 삭제</h4>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                  </div>
            
                  <div class="modal-body">
                    공지를 삭제합니다.
                  </div>
            
                  <div class="modal-footer">
                    <button type="submit" class="btn btn-primary" data-bs-dismiss="modal"  onclick="location.href='${ pageContext.servletContext.contextPath }/ceo/rest_notice_detail_delete?noticeNo=${ requestScope.selectOneNotice.noticeNo }'">확인</button>
                  </div>
                </div>
              </div>
            </div>
       </aside>
    </section>
   
    <jsp:include page="../common/ceo_footer.jsp"/>

  </div>

 
</body>
</html>