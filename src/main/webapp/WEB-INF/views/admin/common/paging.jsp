<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

    <!-- 부가적인 테마 -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

    <!-- 합쳐지고 최소화된 최신 자바스크립트 -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    <script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<div class="col-md-offset-2 col-md-7">
                <ul class="pagination">
                	<!-- 맨 앞으로 이동 버튼 -->
                	<li><a id="startPage"><<</a>
                	
                	<!-- 이전 페이지 버튼 -->
                	<c:if test="${ requestScope.selectCriteria.pageNo <= 1 }">
                		<li class="page-item disabled"><a><</a>
                	</c:if>
                	<c:if test="${ requestScope.selectCriteria.pageNo > 1 }">
                		<li><a id="prevPage"><</a>
                	</c:if>
                	
                	<!-- 숫자버튼 -->
                	<c:forEach var="p" begin="${ requestScope.selectCriteria.startPage }" end="${requestScope.selectCriteria.endPage }" step="1">
                		<c:if test="${ requestScope.selectCriteria.pageNo eq p }">
                			<li class="page-item active"><a><c:out value="${ p }"/></a>
                		</c:if>
                		<c:if test="${ requestScope.selectCriteria.pageNo ne p }">
                			<li><a onclick="pageButtonAction(this.innerText);"><c:out value="${ p }"/></a>
                		</c:if>
                	</c:forEach>

					<!-- 다음 페이지 버튼 -->
					<c:if test="${ requestScope.selectCriteria.pageNo >= requestScope.selectCriteria.maxPage }">
						<li class="page-item disabled"><a>></a>						
					</c:if>
					<c:if test="${ requestScope.selectCriteria.pageNo < requestScope.selectCriteria.maxPage }">
						<li><a id="nextPage">></a>
					</c:if>
					
					<!-- 마지막 페이지로 이동 버튼 -->
					<li><a id="maxPage">>></a>
                  </ul>
	</div>
	
	<script>
	
		const link = '${ requestScope.link }';
		let searchText = "";
		
		if(${ !empty requestScope.selectCriteria.searchCondition? true: false}){
			searchText += "&searchCondtion=${ requestScope.selectCriteria.searchCondition }"
		}
		
		if(${ !empty requestScope.selectCriteria.searchValue? true: false}){
			searchText += "&searchValue=${ requestScope.selectCrteira.searchValue}"
		}
		
		if(document.getElementById("startPage")) {
			const $startPage = document.getElementById("startPage");
			$startPage.onclick = function(){
				location.href = link + "?currentPage=1" + searchText;
			}
		}
		
		if(document.getElementById("prevPage")) {
			const $prevPage = document.getElementById("prevPage");
			$prevPage.onclick = function(){
				location.href = link + "?currentPage=${ requestScope.selectCriteria.pageNo - 1 }" + searchText;
			}
		}
		
		if(document.getElementById("nextPage")){
			const $nextPage = document.getElementById("nextPage");
			$nextPage.onclick = function(){
				location.href = link + "?currentPage=${ requestScope.selectCriteria.pageNo + 1 }" + searchText;
			}
		}
		
		if(document.getElementById("maxPage")){
			const $maxPage = document.getElementById("maxPage");
			$maxPage.onclick = function(){
				location.href = link + "?currentPage=${ requestScope.selectCriteria.maxPage }" + searchText;
			}
		}
		
		function pageButtonAction(text) {
			location.href = link + "?currentPage=" + text + searchText;
		}
	</script>
</body>
</html>