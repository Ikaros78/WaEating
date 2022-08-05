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
</head>
<body>
    <jsp:include page="/WEB-INF/views/user/user_header.jsp"/>
    
     <div id="wrap">
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
						<td colspan="3">"${requestScope.reportDetail.title }"</td>
		
					</tr>
					<tr>
						<td colspan="4" class="view_text">${requestScope.reportDetail.content }</td>
					
				
		
		            </tr>
		            
				</tbody>
			</table>
            
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
		               location.href = "${ pageContext.servletContext.contextPath }/repor/detail?no=" + no;
		            }
				
			}
			
		}
		
</script>
			
	
</body>
</html>

