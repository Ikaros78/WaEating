<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 등록하기</title>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/admin/style.css">
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

    <!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>

<!-- summernote -->
<script src="${ pageContext.servletContext.contextPath }/resources/js/summernote/summernote-lite.js"></script>
<script src="${ pageContext.servletContext.contextPath }/resources/js/summernote/lang/summernote-ko-KR.js"></script>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/summernote/summernote-lite.css">
</head>
<body>
	<div id="wrap">
        <jsp:include page="../common/menubar.jsp"/>
        <div id="body">
            <div class="col-md-2">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>공지사항</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                                <ul class="nav nav-stacked">
                                    <li role="presentation"><a href="${ pageContext.servletContext.contextPath }/admin/notice/list">공지사항 조회</a></li>
                                    <li role="presentation"><a href="${ pageContext.servletContext.contextPath }/admin/notice/insert">공지사항 등록</a></li>
                                </ul>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div class="col-md-9">
	           	<form action="${ pageContext.servletContext.contextPath }/admin/notice/insert" method="post" id="frm">
	            <table class="table table-bordered">
	            <thead>
	            		<tr>
	            			<td align="center">제목</td>
	            		</tr>
	            	</thead>
	            	<tbody>
	            		<tr>
	            			<td><input type="text" placeholder="제목" name="title"></td>
	            		</tr>
	            	</tbody>
	            </table>
	            <table class="table table-bordered">
		            <thead>
			           	<tr>
			           		<td>내용</td>
			           	</tr>
		            </thead>
		            <tbody>
			           	<tr>
			           		<td><textarea id="summernote" name="content" placeholder="내용"></textarea>
			           	</tr>
		            </tbody>
		        </table>
		        <div align="right">
					<button type="button" class="btn btn-primary" id="insert">등록하기</button>
					<button type="button" class="btn btn-default" id="backToList">목록으로</button>
				</div>
		   		</form>
		   	</div>
		</div>
	</div>
	<script>
			
		if(document.getElementById("insert")){
			const $update = document.getElementById("insert");
			$update.onclick = function(){
				
				var chkUpdate = confirm('등록하시겠습니까?');
				
				if(chkUpdate === true){
					document.getElementById('frm').submit();
				}
			}
		}
	
		if(document.getElementById("backToList")){
			const $backToList = document.getElementById("backToList");
			$backToList.onclick = function(){
				location.href = "${ pageContext.servletContext.contextPath }/admin/notice/list";
			}
		}
		
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
</body>
</html>