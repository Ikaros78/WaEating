<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 상세 정보</title>
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
                            <th>게시글 관리</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                                <ul class="nav nav-stacked">
                                    <li role="presentation"><a href="">게시글 첨부파일 조회</a></li>
                                    <li role="presentation"><a href="${ pageContext.servletContext.contextPath }/admin/review/list">리뷰글 조회</a></li>
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
	                		<td class="col-md-2">리뷰정보</td>
	                		<td>상세정보</td>
	                	</tr>
                	</thead>
                    <tbody>
                        <tr>
                            <td>리뷰번호</td>
                            <td><c:out value="${ review.reviewNo }"/></td>
                        </tr>
                        <tr>
                            <td>내용</td>
                            <td><c:out value="${ review.reviewContent }"/></td>
                        </tr>
                        <tr>
                            <td>평점</td>
                            <td><c:out value="${ review.ratings }"/></td>
                        </tr>
                        <tr class="recordNo">
                            <td>이용이력번호</td>
                            <td><c:out value="${ review.recordNo }"/></td>
                        </tr>
                        <tr class="comNo">
                            <td>업체번호</td>
                            <td><c:out value="${ review.comNo }"/></td>
                        </tr>
                        <c:if test="${ !empty sessionScope.attachList }">
                        <c:forEach var= "reviewAttach" items="${ sessionScope.attachList }">
                    	<tr>
                            <td>첨부파일</td>
                            <td><img src="${ pageContext.servletContext.contextPath }/resources/upload/review/${ reviewAttach.fileName }"></td>
                        </tr>
                        </c:forEach>
                        </c:if>
                    </tbody>
                </table>
                
                <c:if test="${sessionScope.review.reviewAns.ansNo ne 0}">
                <table class="table table-bordered">
                	<thead>
	                	<tr>
	                		<td class="col-md-2">리뷰 답글 정보</td>
	                		<td>상세정보</td>
	                	</tr>
                	</thead>
                    <tbody>
                        <tr>
                            <td>리뷰 답변 번호</td>
                            <td><c:out value="${ review.reviewAns.ansNo }"/></td>
                        </tr>
                        <tr>
                            <td>답변 내용</td>
                            <td><c:out value="${ review.reviewAns.ansContent }"/></td>
                        </tr>
                        <tr>
                            <td>답변 시간</td>
                            <td><c:out value="${ review.reviewAns.regDate }"/></td>
                        </tr>
                    </tbody>
                </table>
                </c:if>
            </div>
            
        </div>
        
        
        
        <div id="container">

            <div class="col-md-9 col-md-offset-2" align="right">
                <button type="button" class="btn btn-danger" id="delete">삭제하기</button>
                <button type="button" class="btn btn-default" id="backToList">목록으로</button>
            </div>
        </div>
        
	</div>
    <script>
    	
    	if(document.getElementById("delete")){
    		const $delete = document.getElementById("delete");
    		$delete.onclick = function(){
    			var chkDelete = confirm('삭제하시겠습니까?');
    			
    			if(chkDelete === true){
    				location.href = "${ pageContext.servletContext.contextPath }/admin/review/delete";
    			}
    		}
    	}
    
    	if(document.getElementById("backToList")){
    		const $backToList = document.getElementById("backToList");
    		$backToList.onclick = function(){
    			location.href = "${ pageContext.servletContext.contextPath }/admin/review/list";
    		}
    	}
    	
    	if(document.getElementsByClassName("comNo")){
    		const $comtr = document.getElementsByClassName("comNo");
    		for(let i = 0; i < $comtr.length; i++){
    			
    			$comtr[i].onmouseenter = function(){
    				this.style.backgroundColor = "lightgrey";
    				this.style.cursor = "pointer";
    			}
    			
    			$comtr[i].onmouseout = function(){
    				this.style.backgroundColor = "white";
    			}
    			
	    		$comtr[i].onclick = function(){
	    			var comNo = $(this).children().eq(1).text();
	    			location.href = "${ pageContext.servletContext.contextPath }/admin/company/detail/session?comNo=" + comNo;
    			}
    		}
    	}
    	
    	if(document.getElementsByClassName("recordNo")){
    		const $recordtr = document.getElementsByClassName("recordNo");
    		for(let i = 0; i < $recordtr.length; i++){
    			
    			$recordtr[i].onmouseenter = function(){
    				this.style.backgroundColor = "lightgrey";
    				this.style.cursor = "pointer";
    			}
    			
    			$recordtr[i].onmouseout = function(){
    				this.style.backgroundColor = "white";
    			}
    			
	    		$recordtr[i].onclick = function(){
	    			var recordNo = $(this).children().eq(1).text();
	    			location.href = "${ pageContext.servletContext.contextPath }/admin/usageLog/detail/session?recordNo=" + recordNo;
    			}
    		}
    	}
    </script>                  
             
</body>
</html>