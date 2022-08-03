<%@ page language="java" contentType="text/html; charset=UTF-8
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>notice_detail</title>
<link rel="stylesheet" href="./css/notice_detail.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/ceo/common/ceo_header.jsp"/>
	<div class="container">
		<h2>게시글 상세 화면</h2>
	    	<table class="notice_detail">
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
						<td th:text="${notice.noticeId}"></td>
					</tr>
					<tr>
						<th scope="row">작성자</th>
						<td th:text="${notice.memberId}"></td>
						<th scope="row">작성일</th>
						<td th:text="${notice.regDate}"></td>
					</tr>
					<tr>
						<th scope="row">제목</th>
						<td colspan="3">
							<input type="text" id="title" name="title" 
								th:value="${notice.title }"/>
						</td>
					</tr>
					<tr>
						<td colspan="4" class="view_text">
							<textarea title="내용" id="contents" name="contents" 
								th:text="${notice.contents }"></textarea>
						</td>
					</tr>
				</tbody>
			</table>
			<jsp:include page="/WEB-INF/views/ceo/common/ceo_header.jsp"/>
<script>
		
		if(document.getElementsByClassName('td')) {
			
			const $tds = document.getElementsByClassName('td');
			for(let i = 0; i < $tds.length; i++) {
				
				$tds[i].onmouseenter = function() {
					this.parentNode.style.cursor = "pointer";
				}
				
				 $tds[i].onclick = function() {
		               const no = this.parentNode.children[0].innerText;
		               location.href = "${ pageContext.servletContext.contextPath }/notice/detail?no=" + no;
		            }
				
			}
			
		}
		
</script>
			
	</div>
</body>
</html>

