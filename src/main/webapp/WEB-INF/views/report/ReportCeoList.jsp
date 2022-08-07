<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>report list</title>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/notice/main.css">
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/notice/notice.css">
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
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
   
 <div class="container">
        <section class="notice">
            <div class="page-title">
                  <div class="container">
                    
                      <h3>고객센터</h3>
                  </div>
              </div>
          
              <!-- board seach area -->
              <div id="board-search">
                  <div class="container">
                      <div class="search-window">
                          <form action="">
                              <div class="search-wrap">
                                  <label for="search" class="blind">고객센터 내용 검색</label>
                                  <input id="search" type="search" name="" placeholder="검색어를 입력해주세요." value="">
                                  <button type="submit" class="btn btn-dark">검색</button>
                              </div>
                          </form>
                      </div>
                  </div>
              </div>
             <div id="board-list">
                  <div class="container">
                      <table class="board-table">
                          <thead>
                          <tr>
                              <th scope="col" class="th-num">번호</th>
                              <th scope="col" class="th-title">제목</th>
                              <th scope="col" class="th-date">작성자</th>
                              <th scope="col" class="th-date">등록일</th>
                          </tr>
                          </thead>
                          <tbody>
                          <c:forEach var="report" items="${ requestScope.reportList }" varStatus="status">
                          <tr>
                              <td><c:out value="${ report.reportNo }"/></td>
                              <td><a href="${ pageContext.servletContext.contextPath }/report/ceo/detail?no=${ report.reportNo }"><c:out value="${ report.title }"/></a></td>
                              <td><c:out value="${ report.id }"/><td><c:out value="${ report.regDate }"/></td>
                              <td><c:out value="${ report.regDate }"/></td>
                              
                              
                          </tr>
           				</c:forEach>
             
                          </tbody>
                      </table>
                  </div>
            
            <jsp:include page="./paging.jsp"/>
             
            
            <div class="mt-3"></div>
            <!-- 검색 폼 -->
		 	<div class="write" align="right">
				<form id="loginForm" action="${ pageContext.servletContext.contextPath }/report/ceo/list" method="get" style="display:inline-block">
				<div class="input-group mb-3">
				<input type="hidden" class="form-control" name="currentPage" value="1">
				<!-- <button type="submit" class="btn btn-primary">문의하기</button> -->
				<a class="btn black mr5" href="${ pageContext.servletContext.contextPath }/report/ceo/insert">문의하기</a>
				</div>		
				    
				</form>
				
			</div> 
             
        </div>
    </section>
       <jsp:include page="/WEB-INF/views/ceo/common/ceo_footer.jsp"/>              
  </div>
  <script>
    	
    	const detailLink = "${ pageContext.servletContext.contextPath}//report/ceo/detail/session"
    
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
    				var reportNo = $(this).children().eq(0).text();
    				location.href = detailLink + "?reportNo=" + reportNo; 
    			}
    		}
    		
    	}

    </script>
</body>
</html>