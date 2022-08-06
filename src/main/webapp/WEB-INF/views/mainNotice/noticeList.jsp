<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>notice list</title>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/notice/main.css">
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/notice/notice.css">
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/user/user_header.jsp"/>

  <div id="wrap">
   
 <div class="container">
        <section class="notice">
            <div class="page-title">
                  <div class="container">
                    
                      <h3>공지사항</h3>
                  </div>
              </div>
          
              <!-- board seach area -->
            <!--   <div id="board-search">
                  <div class="container">
                      <div class="search-window">
                          <form action="">
                              <div class="search-wrap">
                                  <label for="search" class="blind">공지사항 내용 검색</label>
                                  <input id="search" type="search" name="" placeholder="검색어를 입력해주세요." value="">
                                  <button type="submit" class="btn btn-dark">검색</button>
                              </div>
                          </form>
                      </div>
                  </div>
              </div> -->
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
                          <c:forEach var="notice" items="${ requestScope.noticeList }" varStatus="status">
                          <tr>
                              <td><c:out value="${ notice.noticeNo }"/></td>
                              <th>
                                <a href="${ pageContext.servletContext.contextPath }/notice/detail?no=${ notice.noticeNo }"><c:out value="${ notice.noticeTitle }"/></a>
                                
                              </th>
                              <td><c:out value="${ notice.regDate }"/></td>
                          </tr>
           				</c:forEach>
            
                         
                          </tbody>
                      </table>
                  </div>
            
            <jsp:include page="./common/paging.jsp"/>
             
            
            <div class="mt-3"></div>
            <!-- 검색 폼 -->
			<div class="search-area" align="center">
				<form id="loginForm" action="${ pageContext.servletContext.contextPath }/notice/list" method="get" style="display:inline-block">
				<div class="input-group mb-3">
				<input type="hidden" class="form-control" name="currentPage" value="1">
				    <select id="searchCondition" name="searchCondition" class="form-control">
						<option value="noticeTitle" ${ requestScope.selectCriteria.searchCondition eq "noticeTitle"? "selected": "" }>제목</option>
					</select>
			        <input type="text" class="form-control" id="searchValue" name="searchValue" placeholder="검색어를 입력해주세요."value="<c:out value="${ requestScope.selectCriteria.searchValue }"/>">
					<button type="submit" class="btn btn-primary">검색하기</button>
				</div>		
				    
				</form>
				
			</div>
        </div>
       </aside>
    </section>
                         
  </div>
  <jsp:include page="/WEB-INF/views/user/user_footer.jsp"/>  
  <script>
		
		if(document.getElementsByClassName('td')) {
			
			const $tds = document.getElementsByClassName('td');
			for(let i = 0; i < $tds.length; i++) {
				
				$tds[i].onmouseenter = function() {
					this.parentNode.style.cursor = "pointer";
				}
				
				$tds[i].onclick = function() {
					/* 게시물 번호까지 알아왔으니 이제 상세보기는 할 수 있습니다. */
					
					/* alert(this.parentNode.children[1].innerText); */
					
					location.href = ""
					
				}
				
			}
			
		}
		
	</script>
</body>
</html>