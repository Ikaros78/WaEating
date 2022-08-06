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
  <c:if test="${ !empty requestScope.no}"><script>	alert("문의하기 게시물이 수정되었습니다");
	
	location.replace("/report/detail?no=" + ${requestScope.no})</script></c:if>

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
			case "insertCeo" : 
				successMessage = "회원 가입에 성공하셨습니다!";
				movePath = "${ pageContext.servletContext.contextPath }/member/ceo/login";
				break;
		
		    case "insertReport" : 
				successMessage = "문의하기 게시물을 등록하였습니다";
				movePath = "${ pageContext.servletContext.contextPath }/report/list";
				break;
				
		    case "deleteReport" : 
				successMessage = "문의하기 게시물이 삭제되었습니다";
				movePath = "${ pageContext.servletContext.contextPath }/report/list";
				break;
		      
		   /*  case "updateReport" : 
				successMessage = "문의하기 게시물이 수정되었습니다";
				if(${requestScope.no})
				{movePath = "${ pageContext.servletContext.contextPath }/report/detail?no=" + ${requestScope.no}
				}
				break; */
		}

    
		alert(successMessage);
		
		location.replace(movePath);
</script>
</body>
</html>