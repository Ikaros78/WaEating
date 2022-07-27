<%@ page language="java" contentType="text/html; charset=UTF-8
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>notice_detail</title>
</head>
<body>


<html lang="ko" xmlns:th="http://www.thymeleaf.org">
<head>
	<meta charset="UTF-8">
	<title>board</title>
	<link rel="stylesheet" href="./css/notice_detail.css">
</head>
<body>
<jsp:include page="/WEB-INF/views/ceo/common/ceo_header.jsp"/>
	<div class="container">
		<h2>게시글 상세 화면</h2>
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
						<td th:text="${board.boardIdx}"></td>
						<th scope="row">조회수</th>
						<td th:text="${board.hitCnt}"></td>
					</tr>
					<tr>
						<th scope="row">작성자</th>
						<td th:text="${board.creatorId}"></td>
						<th scope="row">작성일</th>
						<td th:text="${#temporals.format(board.createdDatetime, 'yyyy-MM-dd HH:mm:ss')}"></td>
					</tr>
					<tr>
						<th scope="row">제목</th>
						<td colspan="3">
							<input type="text" id="title" name="title" 
								th:value="${board.title }"/>
						</td>
					</tr>
					<tr>
						<td colspan="4" class="view_text">
							<textarea title="내용" id="contents" name="contents" 
								th:text="${board.contents }"></textarea>
						</td>
					</tr>
				</tbody>
			</table>
			<jsp:include page="/WEB-INF/views/ceo/common/ceo_header.jsp"/>
	</div>
</body>
</html>

