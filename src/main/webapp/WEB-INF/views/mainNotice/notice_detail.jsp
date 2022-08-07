<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>notice_detail</title>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/notice/notice_detail.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <jsp:include page="/WEB-INF/views/user/user_header.jsp"/>
    
     <div id="wrap">
     <div id="wrap">
    <!-- 왼쪽 (메뉴) -->
    <section class="row container-fluid px-5">
      <aside class="float-start col-2 mt-4 ms-5 px-3">
        <!-- 메뉴 제목 -->
        <h4 class="mb-3 ms-1">마이페이지</h4>
        <div class="list-group list-group-flush border-top border-bottom">
          <!-- 메뉴 세부 제목 -->
          <a href="${ pageContext.servletContext.contextPath }/notice/list" class="list-group-item list-group-item-action py-3 select">공지사항</a>
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
						<td><c:out value="${requestScope.noticeDetail.noticeNo }"/><td>
						
					</tr>
					<tr>
						<th scope="row">작성자</th>
						<td>${requestScope.noticeDetail.memberId }</td>
						<th scope="row">작성일</th>
						<td>${requestScope.noticeDetail.regDate }</td>
						
						
					</tr>
					<tr>
						<th scope="row">제목</th>
						<td colspan="3">${requestScope.noticeDetail.noticeTitle }</td>
			<!-- 	<input type="text" id="title" name="title" --><td>
						</td>
					</tr>
					<tr>
						<td colspan="4" class="view_text">${requestScope.noticeDetail.noticeContent }</td>
					
				 <!-- <textarea title="내용" id="contents" name="contents" --> 
		
		            </tr>
		            
				</tbody>
			</table>
            <c:if test="${ !empty requestScope.attachList}">
	            <table class="table table-bordered">
	            	<thead>
	            		<tr>
	            			<td>첨부사진</td>
	            		</tr>
	            	</thead>
	            	<tbody>
	            		<c:forEach var="file" items="${ requestScope.attachList }">
	            		<tr>
	            			<td><img src="${ pageContext.servletContext.contextPath }/resources/upload/notice/origin/${ file.fileName }"></td>
	            		</tr>
						</c:forEach>
	            	</tbody>
	            </table>
            </c:if>
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
		               location.href = "${ pageContext.servletContext.contextPath }/notice/ceodetail?no=" + no;
		            }
				
			}
			
		}
		
</script>
			
	
</body>
</html>

