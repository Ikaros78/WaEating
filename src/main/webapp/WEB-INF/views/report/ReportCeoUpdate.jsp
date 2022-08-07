<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ReportDetail</title>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/notice/notice_detail.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
 <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<!-- summernote -->
<script src="${ pageContext.servletContext.contextPath }/resources/js/summernote/summernote-lite.js"></script>
<script src="${ pageContext.servletContext.contextPath }/resources/js/summernote/lang/summernote-ko-KR.js"></script>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/summernote/summernote-lite.css">
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/notice/cs.css">
<!-- summernote script -->
<script src="${ pageContext.servletContext.contextPath }/resources/js/report/report.js"></script>
</head>
<body>
  <jsp:include page="/WEB-INF/views/ceo/common/ceo_header.jsp"/> 
    
     <div id="wrap">
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
						<td><c:out value="${requestScope.reportDetail.reportNo }"/><td>
						
					</tr>
					<tr>
						<th scope="row">작성자</th>
						<td>${requestScope.reportDetail.id }</td>
						<th scope="row">작성일</th>
						<td>${requestScope.reportDetail.regDate }</td>
						
						
					</tr>
					<tr>
						<th scope="row">제목</th>
						<td colspan="3"><input value="${requestScope.reportDetail.title }"></td>
		
					</tr>
					<tr>
						<td colspan="4" class="view_text">
						<textarea id="summernote">${requestScope.reportDetail.content }</textarea></td>
		            </tr>
		            <input button=>
				</tbody>
			</table>
            
       </aside>
    </section>
   
   <jsp:include page="/WEB-INF/views/ceo/common/ceo_footer.jsp"/> 

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
		               location.href = "${ pageContext.servletContext.contextPath }/repor/ceo/detail?no=" + no;
		            }
				
			}
			
		}
		
</script>
			
	
</body>
</html>

