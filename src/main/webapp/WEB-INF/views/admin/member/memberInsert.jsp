<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 회원가입</title>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/admin/style.css">
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

    <!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="${ pageContext.servletContext.contextPath }/resources/js/user/user-sign_up.js" ></script>
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
            	<form action="${ pageContext.servletContext.contextPath }/admin/member/insert" method="post" id="frm" onsubmit="return ck_infor();">
                <table class="table table-bordered">
                	<thead>
	                	<tr>
	                		<td class="col-md-2">기본정보</td>
	                		<td>상세정보</td>
	                	</tr>
                	</thead>
                    <tbody>
                        <tr>
                            <td>아이디</td>
                            <td>
                            	<input type="text" id="id" name="id" placeholder="아이디" required>
                            	<input id="db_check" type="button" value="중복 확인"></input>
                      			<input type="hidden" id="hdCheckId">
                      		</td>
                        </tr>
                        <tr>
                            <td>비밀번호</td>
                            <td><input type="password" id="pw" name="pw" placeholder="비밀번호" required></td>
                        </tr>
                        <tr>
                            <td>비밀번호 확인</td>
                            <td><input type="password" id="re_pw" name="pw2" placeholder="비밀번호 확인" required></td>
                        </tr>
                        <tr>
                            <td>이름</td>
                            <td><input type="text" id="name" name="name" placeholder="이름" required></td>
                        </tr>
                        <tr>
                            <td>이메일</td>
                            <td><input type="text" name="email" placeholder="이메일" required></td>
                        </tr>
                        <tr>
                            <td>휴대폰번호</td>
                            <td><input type="text" id="phone" name="phone" placeholder="휴대폰번호" required></td>
                        </tr>
                    </tbody>
                </table>
                <div align="right">
					<button type="submit" class="btn btn-primary" id="insert">등록하기</button>                
	                <button type="button" class="btn btn-default" id="backToList">목록으로</button>
            	</div>
				</form>
            </div>
        </div>
        
    </div>
    <script>
     
		if(document.getElementById("backToList")){
			const $backToList = document.getElementById("backToList");
		 	$backToList.onclick = function(){
		 		location.href = "${ pageContext.servletContext.contextPath }/admin/member/list";
		 	}
		}
		
		$("#db_check").click(function(){
	    	
	    	const userId = $("#id").val();
	    	
	    	$.ajax({
	    		url: "${ pageContext.servletContext.contextPath }/member/user/ckeckId",
	    		type: "get",
	    		data: {
	    			userId : userId
	    		}, 
	    		success: function(result) {
	    			
	    			console.log(result);
	    			if(result == 0){
	    				alert("중복된 아이디가 없습니다.");
	    				$("#hdCheckId").val("check");
	    			} else {
	    				alert("중복된 아이디가 있습니다.");
	    				$("#userId").select();
	    				$("#hdCheckId").val("uncheck");
	    			}
	    		},
	    		error: function(error) {
	    			
	    			console.log(error);
	    		}
	    	});
	    });
	</script>
</body>
</html>