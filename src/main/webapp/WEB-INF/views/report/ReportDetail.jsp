<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ReportDetail</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/notice/notice_detail.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script> 
<script src="${ pageContext.servletContext.contextPath }/resources/js/summernote/summernote-lite.js"></script>
<script src="${ pageContext.servletContext.contextPath }/resources/js/summernote/lang/summernote-ko-KR.js"></script>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/summernote/summernote-lite.css">
</head>
<body>
    <jsp:include page="/WEB-INF/views/user/user_header.jsp"/>
    
     <div id="wrap">
    <section class="row container-fluid px-5">

       <aside class="float-end col-9 mt-4 ms-3" style="min-height: 700px">
        <table class="board_detail">
				<colgroup>
					<col width="15%"/>
					<col width="35%"/>
					<col width="15%"/>
					<col width="35%"/>
				</colgroup>
	          <caption>게시글 상세내용</caption>
				<tbody>
					<tr>
						<th scope="row">글 번호</th>
						<td class="report-num"><c:out value="${requestScope.reportDetail.reportNo }"/><td>
					</tr>
					<tr>
						<th scope="row">작성자</th>
						<td>${requestScope.reportDetail.id }</td>
						<th scope="row">작성일</th>
						<td>${requestScope.reportDetail.regDate }</td>
					</tr>
					<tr>
						<th scope="row">제목</th>
						<td colspan="3" class="report-title">${requestScope.reportDetail.title }</td>
		
					</tr>
					<tr>
						<td colspan="4" class="view_text">${requestScope.reportDetail.content }</td>
		            </tr>
				</tbody>
			</table>
			<div class="btn-box">
	            <button class="save-btn" onclick="saveEvent()">저장</button>	            
	            <button class="update-btn" onclick="updateEvent()">수정</button>
	            <button class="cancle-btn" onclick="cancleEvent()">취소</button>	            
    	        <button class="del-btn" onclick="delEvent()">삭제</button>
			</div>
			<form class="form-detail" action="/report/update" method="POST">
				<input type="number" name="reportNo" value="${requestScope.reportDetail.reportNo }">
				<input type="text" name="title">
				<input type="text" name="content">
				<input type="text" name="id" value="${requestScope.reportDetail.id }">
				<input type="date" name="regDate" value="${requestScope.reportDetail.regDate}">
			</form>
       </aside>
    </section>
   
    <jsp:include page="/WEB-INF/views/user/user_footer.jsp"/> 

  </div>
			 
 <script>
		
		if(document.getElementsByClassName('td')) {
			
			const $tds = document.getElementsByClassName('td');
			for(let i = 0; i < $tds.length; i++) {
				
				$tds[i].onmouseenter = function() {
					this.parentNode.style.cursor = "pointer";
				}
				
				 $tds[i].onclick = function() {
		               const no = this.parentNode.children[0].innerText;
		               location.href = "${ pageContext.servletContext.contextPath }/repor/detail?no=" + no;
		            }
				
			}
			
		}
		function updateEvent(){
		//<c:out value="${requestScope.reportDetail.reportNo }"/>
			$('.save-btn').css('display', 'block');
			$('.cancle-btn').css('display', 'block');
			$('.update-btn').css('display', 'none');
			$('.del-btn').css('display', 'none');
			$('.report-title').html('<input type="text" value="${requestScope.reportDetail.title }">');
			$('.view_text').html('<textarea id="summernote" rows="10" cols="40" name="content">${requestScope.reportDetail.content }</textarea>');
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
			    //['table', ['table']],
			    // 글머리 기호, 번호매기기, 문단정렬
			    ['para', ['ul', 'ol', 'paragraph']],
			    // 줄간격
			    ['height', ['height']],
			    // 그림첨부, 링크만들기, 동영상첨부
			    ['insert',['picture','link']],
			    // 코드보기, 확대해서보기, 도움말
			    //['view', ['codeview','fullscreen', 'help']]
			  ];

		var setting = {
	            height : 300,
	            minHeight : null,
	            maxHeight : null,
	            focus : true,
	            lang : 'ko-KR',
	            toolbar : toolbar,
	            placeholder : '문의 사항을 적어주세요.'
	            /* callbacks : { //여기 부분이 이미지를 첨부하는 부분
	            onImageUpload : function(files, editor,
	            welEditable) {
	            for (var i = files.length - 1; i >= 0; i--) {
	            uploadSummernoteImageFile(files[i],
	            this);
	            		}
	            	}
	            } */
	         };

	        $('#summernote').summernote(setting);
		}
		function cancleEvent(){
			$('.save-btn').css('display', 'none');
			$('.cancle-btn').css('display', 'none');
			$('.update-btn').css('display', 'block');
			$('.del-btn').css('display', 'block');
			$('.report-title').html("${requestScope.reportDetail.title }");
			$('.view_text').html('${requestScope.reportDetail.content }');
			
		}
		function delEvent(){
			const reportNum = $('.report-num').text();
			window.location.href = '/report/delete?reportNum='+reportNum;
		}
		function saveEvent(){
			 const title = $('.report-title > input').val();
			 $("input[name='title']")[0].value = title;
			 $("input[name='content']")[0].value= $('#summernote').val();
			 $(".form-detail").submit();
		}
</script>
			
	
</body>
</html>

