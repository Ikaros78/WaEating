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
<script src="${ pageContext.servletContext.contextPath }/resources/js/report/report.js"></script>
</head>
<body class="d-flex flex-column min-vh-100">
<jsp:include page="/WEB-INF/views/ceo/common/ceo_header.jsp"/> 
  <div id="wrap">
    <!-- 왼쪽 (메뉴) -->
    <section class="row container-fluid px-5">
      <aside class="float-start col-2 mt-4 ms-5 px-3">
        <!-- 메뉴 제목 -->
        <h4 class="mb-3 ms-1">마이페이지</h4>
        <div class="list-group list-group-flush border-top border-bottom">
          <!-- 메뉴 세부 제목 -->
         <a href="${ pageContext.servletContext.contextPath }/ceo/check/password" class="list-group-item list-group-item-action py-3">개인정보수정</a>
          <a href="${ pageContext.servletContext.contextPath }/report/ceo/list" class="list-group-item list-group-item-action py-3">고객센터</a>
        </div>
       </aside>
       <!-- 오른쪽 (컨텐츠) -->
       <aside class="float-end col-9 mt-4 ms-3 border">

	<div class="container" >  
		<form class="report-form" action="${ pageContext.servletContext.contextPath }/report/ceo/insert" method="post">
            <table>
                <tr>
                    <th>제목</th>
                    <td><input type="text" name="title"></td> 
                </tr>
                <tr>
                    <th>내용</th>
                    <td class="sum-td"><textarea id="summernote" rows="10" cols="40" name="content"></textarea></td>
                </tr>
                
            </table>
            <div id="button" style="text-align: center;">
                <button class="close-btn" onclick="closeEvent()">취소</button>
                <button class="insert-btn">등록</button>
                
           </div>
        </form></div>
       
   
     <jsp:include page="/WEB-INF/views/ceo/common/ceo_footer.jsp"/> 

 
</body>
</html>