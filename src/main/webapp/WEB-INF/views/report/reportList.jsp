<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객센터 리스트</title>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/notice/main.css">
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/notice/notice.css">
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/user/user_header.jsp"/>

 
   
 <div class="container">
        <section class="notice">
            <div class="page-title">
                  <div class="container">
                    
                      <h3>고객센터</h3>
                  </div>
              </div>

             <div id="board-list">
                  <div class="container">
                      <table class="board-table">
                          <thead>
                          <tr>
                              <th scope="col" class="th-num">번호</th>
                              <th scope="col" class="th-title">제목</th>
                              <th scope="col" class="th-date">등록일</th>
                          </tr>
                          </thead>
                          <tbody>
                    <c:forEach items="${ requestScope.reportList }" var="report">
					<tr>
						<td><c:out value="${ report.reportNo}"/></td>
						<td><c:out value="${ report.title }"/></td>
						<td><c:out value="${ report.regDate }"/></td>
					</tr>
				</c:forEach>
            
                         
                          </tbody>
                      </table>
                  </div>
            
            <jsp:include page="./paging.jsp"/>
             
            
            <div class="mt-3"></div>
            <!-- 검색 폼 -->
			<div class="search-area" align="center">
				<form id="loginForm" action="${ pageContext.servletContext.contextPath }/report/list" method="get" style="display:inline-block">
				<div class="input-group mb-3">
				<input type="hidden" class="form-control" name="currentPage" value="1">
				    <select id="searchCondition" name="searchCondition" class="form-control">
						<option value="reportTitle" ${ requestScope.selectCriteria.searchCondition eq "reportTitle"? "selected": "" }>제목</option>
					</select>
			        <input type="text" class="form-control" id="searchValue" name="searchValue" value="<c:out value="${ requestScope.selectCriteria.searchValue }"/>">
					<button type="submit" class="btn btn-primary">검색하기</button>
				</div>		
				    
				</form>
				
			</div>
             
        </div>
       </aside>
    </section>
                         
<jsp:include page="/WEB-INF/views/user/user_footer.jsp">  
  </div>
  <script>
    	
    	const detailLink = "${ pageContext.servletContext.contextPath}/admin/report/detail/session"
    
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