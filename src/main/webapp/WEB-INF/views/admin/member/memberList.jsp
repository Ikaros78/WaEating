<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 관리</title>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/admin/style.css">
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

    <!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>
<body>
	<div id="wrap">
        <jsp:include page ="../common/menubar.jsp"/>
        <div id="body">              
            <div class="col-md-2">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>회원 관리</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                                <ul class="nav nav-stacked">
                                    <li role="presentation"><a href="${ pageContext.servletContext.contextPath }/admin/member/list">회원정보 조회</a></li>
                                    <li role="presentation"><a href="${ pageContext.servletContext.contextPath }/admin/member/insert">관리자 회원가입</a></li>
                                </ul>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div class="col-md-9">
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th width="150px">아이디</th>
                        <th width="100px">이름</th>
                        <th width="300px">이메일</th>
                        <th width="150px">전화번호</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="member" items="${ requestScope.memberList }">
                    <tr class="rowClick">
                    	<td class="details"><c:out value="${ member.id }"/></td>
                    	<td class="details"><c:out value="${ member.name }"/></td>
                    	<td class="details"><c:out value="${ member.email }"/></td>
                    	<td class="details"><c:out value="${ member.phone }"/></td>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>    

		<!-- 검색 폼 -->
		
		<div class="col-md-offset-7 col-md-4" align="right" id="searchArea">
			<form id="loginForm" action="${ pageContext.servletContext.contextPath }/admin/member/list" method="get" style="display:inline-block">		
			    <input type="hidden" name="currentPage" value="1">
			    <select id="searchCondition" name="searchCondition">
					<option value="id" ${ requestScope.selectCriteria.searchCondition eq "id"? "selected": "" }>아이디</option>
					<option value="name" ${ requestScope.selectCriteria.searchCondition eq "name"? "selected": "" }>이름</option>
					<option value="email" ${ requestScope.selectCriteria.searchCondition eq "email"? "selected": "" }>이메일</option>
					<option value="phone" ${ requestScope.selectCriteria.searchCondition eq "phone"? "selected": "" }>전화번호</option>
				</select>
		        <input type="search" id="searchValue" name="searchValue" value="<c:out value="${ requestScope.selectCriteria.searchValue }"/>">

				<button type="submit">검색하기</button>
			</form>
		</div>

        <div id="container">
            <!-- 페이지 처리 -->
            <jsp:include page="../common/paging.jsp"/>
        </div>
        
    </div>
    
    <!-- 상세 보기 이동 -->
    <script>
    	
    	const detailLink = "${ pageContext.servletContext.contextPath}/admin/member/detail/session"
    
    	if(document.getElementsByTagName("td")) {
    		
    		const $tds = document.getElementsByClassName("details");
    		for(let i = 0; i < $tds.length; i++){
    			
    			$tds[i].onmouseenter = function(){
    				this.parentNode.style.backgroundColor = "lightgrey";
    				this.parentNode.style.cursor = "pointer";
    			}
    			
    			$tds[i].onmouseout = function(){
    				this.parentNode.style.backgroundColor = "white";
    			}
    		}
    		const $trs = document.getElementsByClassName("rowClick");
    		for(let j = 0; j < $trs.length; j++){
    			
    			$trs[j].onclick = function(){
    				/* alert($(this).children().eq(0).text()); */
    				var memberId = $(this).children().eq(0).text();
    				location.href = detailLink + "?memberId=" + memberId; 
    			}
    		}
    	}
    	

    </script>
</body>
</html>