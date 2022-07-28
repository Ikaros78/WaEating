<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 상세 정보</title>
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
                            <th>회원 관리</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                                <ul class="nav nav-stacked">
                                    <li role="presentation"><a href="${ pageContext.servletContext.contextPath }/admin/member/list">회원정보 조회</a></li>
                                    <li role="presentation"><a href="#">회원정보 등록</a></li>
                                </ul>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div class="col-md-9">
            	<form action="${ pageContext.servletContext.contextPath }/admin/member/update" method="post" id="frm">
                <table class="table table-bordered">
                	<thead>
	                	<tr>
	                		<td class="col-md-2">기본정보</td>
	                		<td>상세정보</td>
	                		<c:if test="${ !empty sessionScope.ifUpdate }">
                            	<td>수정할 정보</td>
                            </c:if>
	                	</tr>
                	</thead>
                    <tbody>
                        <tr>
                            <td>이름</td>
                            <td><c:out value="${ member.name }"/></td>
                            <c:if test="${ !empty sessionScope.ifUpdate }">
                            	<td><input type="text" placeholder="이름" name="updateName"></td>
                            </c:if>
                        </tr>
                        <tr>
                            <td>아이디</td>
                            <td><c:out value="${ member.id }"/></td>
                        </tr>
                        <tr>
                            <td>비밀번호</td>
                            <td><c:out value="${ member.pwd }"/></td>
                            <c:if test="${ !empty sessionScope.ifUpdate }">
                            	<td><input type="password" placeholder="비밀번호" name="updatePwd"></td>
                            </c:if>
                        </tr>
                        <tr>
                            <td>이메일</td>
                            <td><c:out value="${ member.email }"/></td>
                            <c:if test="${ !empty sessionScope.ifUpdate }">
                            	<td><input type="text" placeholder="이메일" name="updateEmail"></td>
                            </c:if>
                        </tr>
                        <tr>
                            <td>생년월일</td>
                            <td><c:out value="${ member.userInfo.birth }"/></td>
                            <c:if test="${ !empty sessionScope.ifUpdate }">
                            	<td><input type="text" placeholder="생일" name="updateBirth"></td>
                            </c:if>
                        </tr>
                        <tr>
                            <td>성별</td>
                            <td><c:out value="${ member.userInfo.gender }"/></td>
                            <c:if test="${ !empty sessionScope.ifUpdate }">
                            	<td><select name="updateGender">
	                            		<option>없음</option>
	                            		<option>남</option>
	                            		<option>여</option>
                            		</select></td>
                            </c:if>
                        </tr>
                        <tr>
                            <td>휴대폰번호</td>
                            <td><c:out value="${ member.phone }"/></td>
                            <c:if test="${ !empty sessionScope.ifUpdate }">
                            	<td><input type="text" placeholder="휴대폰번호" name="updatePhone"></td>
                            </c:if>
                        </tr>
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
    				location.href = "${ pageContext.servletContext.contextPath }/admin/member/delete";
    			}
    		}
    	}
    
    	if(document.getElementById("backToList")){
    		const $backToList = document.getElementById("backToList");
    		$backToList.onclick = function(){
    			location.href = "${ pageContext.servletContext.contextPath }/admin/member/list";
    		}
    	}
    </script>
</body>
</html>