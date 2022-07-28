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
  <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
  <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<%-- <script src="${ pageContext.servletContext.contextPath }/resources/js/ceo/summernote/summernote-lite.js"></script>
<script src="${ pageContext.servletContext.contextPath }/resources/js/ceo/summernote/lang/summernote-ko-KR.js"></script> --%>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/ceo/summernote/summernote-lite.css">


<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>
<jsp:include page="../common/ceo_header.jsp"/>
<!-- <script>
$(document).ready(function() {

	var toolbar = [
		    // 글꼴 설정
		    ['fontname', ['fontname']],
		    // 글자 크기 설정
		    ['fontsize', ['fontsize']],
		    // 굵기, 기울임꼴, 밑줄,취소 선, 서식지우기
		    ['style', ['bold', 'italic', 'underline','strikethrough', 'clear']],
		    // 글자색
		    ['color', ['forecolor','color']],
		    // 표만들기
		    ['table', ['table']],
		    // 글머리 기호, 번호매기기, 문단정렬
		    ['para', ['ul', 'ol', 'paragraph']],
		    // 줄간격
		    ['height', ['height']],
		    // 그림첨부, 링크만들기, 동영상첨부
		    ['insert',['picture']],
		    // 코드보기, 확대해서보기, 도움말
		    ['view', ['codeview', 'help']]
		  ];

	var setting = {
            height : 250,
            minHeight : null,
            maxHeight : null,
            focus : true,
            lang : 'ko-KR',
            placeholder : '가게나 메뉴 소개, 이벤트 등 눈에 띄었으면 하는 내용을 올려주세요.',
            toolbar : toolbar,
            callbacks : { //여기 부분이 이미지를 첨부하는 부분
            onImageUpload : function(files, editor,
            welEditable) {
            for (var i = files.length - 1; i >= 0; i--) {
            uploadSummernoteImageFile(files[i],
            this);
            		}
            	}
            }
         };

        $('#summernote').summernote(setting);
        });
</script> -->
<script>
$(document).ready(function() {
	//여기 아래 부분
	$('#summernote').summernote({
		  height: 300,                 // 에디터 높이
		  minHeight: null,             // 최소 높이
		  maxHeight: null,             // 최대 높이
		  focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
		  lang: "ko-KR",					// 한글 설정
		  placeholder: '최대 2048자까지 쓸 수 있습니다'	//placeholder 설정
          
	});
});
</script>


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
                <td style="width: 95%;"><input type="text" class="form-control mb-2" placeholder="제목을 입력해주세요." name="noticeTitle" id="noticeTitle"></td>
              </tr>
              <tr>
                <td class="d-flex align-content-start mt-2"><h5>내용</h5></td>
                <td><textarea id="summernote"  name="editordata"></textarea></td>
                <!-- <td><textarea class="form-control mb-2 ms-1" rows="10" name="content" id="content" placeholder="가게나 메뉴 소개, 이벤트 등 눈에 띄었으면 하는 내용을 올려주세요."></textarea></td> -->
              </tr>
            </table>
            <div class="mt-3 d-flex justify-content-center">
              <button type="button" class="btn btn-outline-danger me-2" value="삭제" data-bs-toggle="modal" data-bs-target="#modalDeleteq">삭제</button>
              <button type="button" class="btn btn-outline-primary" value="수정" data-bs-toggle="modal" data-bs-target="#modalSubmit">수정</button>
            </div>

            <!-- Modal (삭제) -->
            <div class="modal fade" id="modalDeleteq">
              <div class="modal-dialog">
                <div class="modal-content">
            
                  <!-- Modal Header -->
                  <div class="modal-header">
                    <h4 class="modal-title">공지 삭제</h4>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                  </div>
            
                  <!-- Modal body -->
                  <div class="modal-body">
                    공지를 삭제하시겠습니까?
                  </div>
            
                  <!-- Modal footer -->
                  <div class="modal-footer">
                    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modalDelete">확인</button>
                  </div>
                </div>
              </div>
            </div>

            <!-- Modal (삭제) -->
            <div class="modal fade" id="modalDelete">
              <div class="modal-dialog">
                <div class="modal-content">
            
                  <!-- Modal Header -->
                  <div class="modal-header">
                    <h4 class="modal-title">공지 삭제</h4>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                  </div>
            
                  <!-- Modal body -->
                  <div class="modal-body">
                    공지가 삭제되었습니다.
                  </div>
            
                  <!-- Modal footer -->
                  <div class="modal-footer">
                    <button type="submit" class="btn btn-primary" data-bs-dismiss="modal" onclick="history.go(-1)">확인</button>
                  </div>
                </div>
              </div>
            </div>

            <!-- Modal (수정) -->
            <div class="modal fade" id="modalSubmit">
              <div class="modal-dialog">
                <div class="modal-content">
            
                  <!-- Modal Header -->
                  <div class="modal-header">
                    <h4 class="modal-title">공지 수정</h4>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                  </div>
            
                  <!-- Modal body -->
                  <div class="modal-body">
                    공지 수정이 완료되었습니다.
                  </div>
            
                  <!-- Modal footer -->
                  <div class="modal-footer">
                    <button type="submit" class="btn btn-primary" data-bs-dismiss="modal" onclick="history.go(-1)">확인</button>
                  </div>
            
                </div>
              </div>
            </div>
          </form>
         
          
        </div>
       </aside>
    </section>
   
    <jsp:include page="../common/ceo_footer.jsp"/>

  </div>

 
</body>
</html>