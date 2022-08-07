<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>업체 상세 정보</title>
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
        <jsp:include page="../common/menubar.jsp"/>

        <div id="body">
            <div class="col-md-2">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>업체 관리</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                                <ul class="nav nav-stacked">
                                    <li role="presentation"><a href="${ pageContext.servletContext.contextPath }/admin/company/list">업체정보 조회</a></li>
                                </ul>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div class="col-md-9">
            	<form action="${ pageContext.servletContext.contextPath }/admin/company/update" method="post" id="frm">
                <table class="table table-bordered">
                	<thead>
	                	<tr>
	                		<td class="col-md-2">업체개인정보</td>
	                		<td>상세정보</td>
	                		<c:if test="${ !empty sessionScope.ifUpdate }">
                            	<td class="col-md-5">수정할 정보</td>
                            </c:if>
	                	</tr>
                	</thead>
                    <tbody>
                        <tr>
                        	<td>이름</td>
                        	<td><c:out value="${ com.memberInfo.name}"/></td>
                        	<c:if test="${ !empty sessionScope.ifUpdate }">
                            	<td><input type="text" placeholder="이름" name="updateName"></td>
                            </c:if>
                        </tr>
                        <tr>
                        	<td>아이디</td>
                        	<td><c:out value="${ com.memberId }"/></td>
                        </tr>
                        <tr>
                        	<td>비밀번호</td>
                        	<td><c:out value="${ com.memberInfo.pwd }"/></td>
                        	<c:if test="${ !empty sessionScope.ifUpdate }">
                            	<td><input type="password" placeholder="비밀번호" name="pw"></td>
                            </c:if>
                        </tr>
                        <tr>
                        	<td>이메일</td>
                        	<td><c:out value="${ com.memberInfo.email }"/></td>
                        	<c:if test="${ !empty sessionScope.ifUpdate }">
                            	<td><input type="text" placeholder="이메일" name="updateEmail"></td>
                            </c:if>
                        </tr>
                        <tr>
                        	<td>휴대폰번호</td>
                        	<td><c:out value="${ com.memberInfo.phone }"/></td>
                        	<c:if test="${ !empty sessionScope.ifUpdate }">
                            	<td><input type="text" placeholder="휴대폰번호" name="updatePhone"></td>
                            </c:if>
                        </tr>
                   </tbody>
                </table>   
                <table class="table table-bordered">
                	<thead>
	                	<tr>
	                		<td class="col-md-2">업체 정보</td>
	                		<td>상세정보</td>
	                		<c:if test="${ !empty sessionScope.ifUpdate }">
                            	<td class="col-md-5">수정할 정보</td>
                            </c:if>
	                	</tr>
                	</thead>     
                        <tr>
                        	<td>업체번호</td>
                        	<td><c:out value="${ com.comNo }"/></td>
                        </tr>
                        <tr>
                        	<td>업체명</td>
                        	<td><c:out value="${ com.comName }"/></td>
	                        <c:if test="${ !empty sessionScope.ifUpdate }">
	                            	<td><input type="text" placeholder="업체명" name="updateComName"></td>
	                        </c:if>
                        </tr>
                        <tr>
                        	<td>카테고리</td>
                        	<td><c:out value="${ com.category }"/></td>
	                        <c:if test="${ !empty sessionScope.ifUpdate }">
	                            	<td><input type="text" placeholder="카테고리" name="updateCategory"></td>
	                        </c:if>
                        </tr>
                        <tr>
                        	<td>주소</td>
                        	<td><c:out value="${ com.comAddress }"/></td>
	                        <c:if test="${ !empty sessionScope.ifUpdate }">
	                            	<td><input type="text" placeholder="주소" name="updateComAddress"></td>
	                        </c:if>
                        </tr>
                        <tr>
                        	<td>업체 연락처</td>
                        	<td><c:out value="${ com.comPhone }"/></td>
	                        <c:if test="${ !empty sessionScope.ifUpdate }">
	                            	<td><input type="text" placeholder="업체 연락처" name="updateComPhone"></td>
	                        </c:if>
                        </tr>
                        <tr>
                        	<td>사업자 등록번호</td>
                        	<td><c:out value="${ com.comRegist }"/></td>
	                        <c:if test="${ !empty sessionScope.ifUpdate }">
	                            	<td><input type="text" placeholder="사업자 등록번호" name="updateComRegist"></td>
	                        </c:if>
                        </tr>
                        <tr>
                        	<td>업체 승인이력번호</td>
                        	<td><c:out value="${ com.recordList[0].recordNo }"/></td>
                        </tr>
                        <tr>
                        	<td>업체 승인상태</td>
                        	<td><c:out value="${ com.recordList[0].status }"/></td>
                        	<c:if test="${ !empty sessionScope.ifUpdate }">
	                            	<td><select name="updateStatus">
	                            			<option>승인대기</option>
	                            			<option>승인</option>
	                            			<option>거절</option>
	                            		</select></td>
	                        </c:if>
                        </tr>
                       	<c:if test="${ com.recordList[0].status eq '거절' }">
                        <tr>
                        	<td>업체 거절이유</td>
                        	<td><c:out value="${ com.recordList[0].reason }"/></td>
	                        <c:if test="${ !empty sessionScope.ifUpdate }">
	                            	<td><input type="text" placeholder="거절 이유" name="updateReason"></td>
	                        </c:if>
                        </tr>
                        </c:if>
                       
                    </tbody>
                </table>
                <c:if test="${ !empty sessionScope.ifUpdate }">
                <div align="right">
					<button type="button" class="btn btn-primary" id="update">수정하기</button>
				</div>
                </c:if>
                </form>
            </div>
        </div>
        
        <c:if test="${ empty sessionScope.ifUpdate }">
        <div id="container">
			
            <div class="col-md-9 col-md-offset-2" align="right">
	            <c:if test="${ com.recordList[0].status eq '승인대기' }">
	            		<button type="button" class="btn btn-success" id="access">승인</button>
	            		<button type="button" class="btn btn-danger" id="refuse">거절</button>
	            </c:if>
                <button type="button" class="btn btn-primary" id="doUpdate">수정</button>
                <button type="button" class="btn btn-default" id="backToList">목록으로</button>
            </div>
        </div>
        </c:if>
        
        <c:if test="${ !empty sessionScope.ifUpdate }">
        <div id="container">

            <div class="col-md-9 col-md-offset-2" align="right">
                <button type="button" class="btn btn-danger" id="delete">삭제하기</button>
                <button type="button" class="btn btn-secondary" id="cancle">취소</button>
                <button type="button" class="btn btn-default" id="backToList">목록으로</button>
            </div>
        </div>
        </c:if>
        
    </div>
    <script>
    	
    	if(document.getElementById("doUpdate")){
    		const $doUpdate = document.getElementById("doUpdate");
    		$doUpdate.onclick = function(){
   				location.href = "${ pageContext.servletContext.contextPath }/admin/update/session";
    		}
    	}
    	
    	if(document.getElementById("cancle")){
    		const $cancle = document.getElementById("cancle");
    		$cancle.onclick = function(){
    			location.href = "${ pageContext.servletContext.contextPath }/admin/cancle/session";
    		}
    	}
    
    	if(document.getElementById("update")){
    		const $update = document.getElementById("update");
    		$update.onclick = function(){
    			
				var chkUpdate = confirm('수정하시겠습니까?');
    			
    			if(chkUpdate === true){
    				document.getElementById('frm').submit();
    			}
    		}
    	}
    	
    	if(document.getElementById("delete")){
    		const $delete = document.getElementById("delete");
    		$delete.onclick = function(){
    			
    			var chkDelete = confirm('삭제하시겠습니까?');
    			
    			if(chkDelete === true){
    				location.href = "${ pageContext.servletContext.contextPath }/admin/company/delete";
    			}
    		}
    	}
    
    	if(document.getElementById("backToList")){
    		const $backToList = document.getElementById("backToList");
    		$backToList.onclick = function(){
    			location.href = "${ pageContext.servletContext.contextPath }/admin/company/list";
    		}
    	}
    	
    	if(document.getElementById("access")){
    		const $access = document.getElementById("access");
    		$access.onclick = function(){
    			
    			var chkAccess = confirm('승인하시겠습니까?');
    			
    			if(chkAccess === true){
					location.href = "${ pageContext.servletContext.contextPath }/admin/company/access";
    			}
    		}
    	}
    	
    	if(document.getElementById("refuse")){
    		const $refuse = document.getElementById("refuse");
    		$refuse.onclick = function(){
    			
    			var chkRefuse = confirm('거절하시겠습니까?');
    			
    			if (chkRefuse === true){
    				var reason = prompt('거절 이유를 작성해주세요');
    				location.href = "${ pageContext.servletContext.contextPath }/admin/company/refuse" + "?reason=" + reason;
    			}
    		}
    	}
    </script>
</body>
</html>