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
          <form action="${ pageContext.servletContext.contextPath }/ceo/rest_notice" method="post">
            <table width="100%">
              <tr>
                <td><h5>제목</h5></td>
                <td style="width: 95%;"><input type="text" class="form-control mb-2 ms-1" placeholder="제목을 입력해주세요." name="title" id="title"></td>
              </tr>
              <tr>
                <td class="d-flex align-content-start mt-2"><h5>내용</h5></td>
                <td><textarea class="form-control mb-2 ms-1" rows="10" name="content" id="content" placeholder="가게나 메뉴 소개, 이벤트 등 눈에 띄었으면 하는 내용을 올려주세요."></textarea></td>
              </tr>
            </table>
            <div class="d-flex justify-content-center">
              <button type="button" class="btn btn-light me-2" style="color: #6c757d;" value="취소" onclick="history.go(-1)">취소</button>
              <button type="button" class="btn btn-primary" value="등록" data-bs-toggle="modal" data-bs-target="#modalSubmit">등록</button>
            </div>
            <!-- Modal -->
            <div class="modal" id="modalSubmit">
              <div class="modal-dialog">
                <div class="modal-content">
            
                  <!-- Modal Header -->
                  <div class="modal-header">
                    <h4 class="modal-title">공지 등록</h4>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                  </div>
            
                  <!-- Modal body -->
                  <div class="modal-body">
                    공지 등록이 완료되었습니다.
                  </div>
            
                  <!-- Modal footer -->
                  <div class="modal-footer">
                    <button type="submit" class="btn btn-primary" data-bs-dismiss="modal" onclick="history.go(-1)">확인</button>
                  </div>
            
                </div>
              </div>
            </div>
          </form>
          <!-- <div class="d-flex justify-content-center">
            <button type="button" class="btn btn-outline-secondary me-2" value="취소" onclick="history.go(-1)">취소</button>
            <button type="submit" class="btn btn-primary" value="등록">등록</button>
          </div> -->
        
          <!-- <div class="row">
            <h5 class="col-2">제목</h5>
            <input type="text" class="form-control mb-3" placeholder="제목을 입력해주세요." name="title" id="title">
          </div> -->
          
          <!-- <h5>내용</h5>
          <textarea class="form-control" rows="5"name="content" id="content" placeholder="가게나 메뉴 소개, 이벤트 등 눈에 띄었으면 하는 내용을 올려주세요."></textarea> -->
          
        </div>
       </aside>
    </section>
   
   <jsp:include page="../common/ceo_footer.jsp"/>

  </div>
</body>
</html>