<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성공 메시지</title>
</head>
<body>
 <script>
		var successCode = "${ requestScope.success }";
		
		let successMessage = "";
		let movePath = "";
		
		switch(successCode){
			case "insertUser" : 
				successMessage = "회원 가입에 성공하셨습니다!";
				movePath = "${ pageContext.servletContext.contextPath }/member/user/login";
				break;
			case "findId" :
				successMessage = "아이디는 ${ requestScope.userId }입니다.";
				movePath = "${ pageContext.servletContext.contextPath }/member/user/login";
				break;
			case "updatePwd" :
				successMessage = "비밀번호가 변경되었습니다.";
				movePath = "${ pageContext.servletContext.contextPath }/member/user/login";
				break;
			case "updateUser" :
				successMessage = "회원정보가 수정되었습니다.";
				movePath = "${ pageContext.servletContext.contextPath }/member/user/login";
				break;
			case "insertCeo" : 
				successMessage = "회원 가입에 성공하셨습니다!";
				movePath = "${ pageContext.servletContext.contextPath }/member/ceo/login";
				break;
			case "findCeoId" :
				successMessage = "아이디는 ${ requestScope.ceoId }입니다.";
				movePath = "${ pageContext.servletContext.contextPath }/member/ceo/login";
				break;
			case "updateCeoPwd" :
				successMessage = "비밀번호가 변경되었습니다.";
				movePath = "${ pageContext.servletContext.contextPath }/member/ceo/login";
				break;
		}

		alert(successMessage);
		
		location.replace(movePath);
</script>
</body>
</html>