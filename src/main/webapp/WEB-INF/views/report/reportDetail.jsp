<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<body class="d-flex flex-column min-vh-100">
<jsp:include page="/WEB-INF/views/user/user_footer.jsp"/>

  <div id="wrap" >
    <!-- 왼쪽 (메뉴) -->
    <section class="row container-fluid px-5">
      <aside class="float-start col-2 mt-4 ms-5 px-3">
        <!-- 메뉴 제목 -->
        <h4 class="mb-3 ms-1">가게 관리</h4>
        <div class="list-group list-group-flush border-top border-bottom">
          <!-- 메뉴 세부 제목 -->
          <a href="${ pageContext.servletContext.contextPath }/report/main">문의 내용 조회</a>
        </div>
       </aside>
       <!-- 오른쪽 (컨텐츠) -->
       <aside class="float-end col-9 mt-4 ms-3">
        <!-- 이미지 지우고 넣을 컨텐츠 써서 사용 -->
        <!-- <img src="img/visual.jpg" width="100%">  -->
        <div class="px-5 py-3">
          <form action="${ pageContext.servletContext.contextPath }/report/reportDetail.jsp" method="post">
            <table width="100%">
              <tr>
                <td><h5>제목</h5></td>
                <td style="width: 95%;"><input type="text" class="form-control mb-2" placeholder="제목을 입력해주세요." name="noticeTitle" id="title"></td>
              </tr>
              <tr>
                <td class="d-flex align-content-start mt-2"><h5>내용</h5></td>
                <td><textarea id="summernote" name="reportContent"></textarea></td>
              </tr>
            </table>
            <div class="mt-3 d-flex justify-content-center">
            <a href="${ pageContext.servletContext.contextPath }/report/main">
              <button type="button" class="btn btn-light me-2" style="color: #6c757d;" value="취소">취소</button>            
            </a>
              <button type="button" class="btn btn-primary" value="등록" data-bs-toggle="modal" data-bs-target="#modalSubmit">등록</button>
            </div>
            <!-- Modal -->
            <div class="modal" id="modalSubmit">
              <div class="modal-dialog">
                <div class="modal-content">
            
                  <!-- Modal Header -->
                  <div class="modal-header">
                    <h4 class="modal-title">문의 등록</h4>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                  </div>
            
                  <!-- Modal body -->
                  <div class="modal-body">
                    문의 등록이 완료되었습니다.
                  </div>
            
                  <!-- Modal footer -->
                  <div class="modal-footer">
                    <button type="submit" class="btn btn-primary" data-bs-dismiss="modal">확인</button>
                  </div>
            
                </div>
              </div>
            </div>
          </form>
    
        </div>
       </aside>
    </section>
   
   <jsp:include page="/WEB-INF/views/user/user_footer.jsp"/>

  </div>
</body>
</html>