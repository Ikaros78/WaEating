<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객센터문의하기</title>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/notice/user_main.css">
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
<jsp:include page="/WEB-INF/views/user/user_header.jsp"/>
    <h2>고객센터 문의사항 작성</h2>
	<div style="
    margin: top;
    margin-top: 118px" >  
		<form action="${ pageContext.servletContext.contextPath }/report/insert" method="post">
            <table>
                <tr>
                    <th>제목</th>
                    <td><input type="text" name="title"></td> 
                </tr>
                <tr>
                    <th>내용</th>
                    <td><textarea class="notice-text" rows="10" cols="40" name="content"></textarea></td>
                </tr>
                
            </table>
            <div id="button" style="text-align: right;">
                <button>삭제</button>
                <button>수정</button>
                <button>확인</button>
                
           </div>
        </form></div>
       
   
   <jsp:include page="/WEB-INF/views/user/user_footer.jsp"/>

 
</body>
</html>