<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>웨잇-팅 회원가입</title>
<!-- 부트 스트랩 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- 파일 -->
<script src="${ pageContext.servletContext.contextPath }/resources/js/user/user-sign_up.js" ></script>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/user/user-login/user-sign_up.css">
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>

	<div class="container">
        <div class="input-form-backgroud row">
          <div class="input-form col-md-12">
            <h4 class="mb-3">회원가입</h4>
            <form action="${ pageContext.servletContext.contextPath }/member/user/signup" class="validation-form"  method="post" onsubmit="return ck_infor();">
              <div class="row">
                  <div class="form-floating col-md-6 mb-3">
                      <input type="text" class="form-control" id="id" name = "id" placeholder="아이디 입력" required>
                      <label for="id" style="margin-left:10px">아이디</label>
                      <div class="invalid-feedback">
                        아이디를 입력해주세요.
                      </div>
                  </div>
                  <div class="form-floating col-md-4 mb-3">
                      <input id="db_check" type="button" value="중복 확인"></input>
                      <input type="hidden" id="hdCheckId">
                  </div>
                  
              </div>
              
              <div class="form-floating mb-3">
                  <input type="text" class="form-control" id="name" name="name" placeholder="이름 입력" required>
                  <label for="name">이름</label>
                  <div class="invalid-feedback">
                    이름을 입력해주세요.
                  </div>
              </div>
              <div class="mb-3">
                <div class="form-floating">
                    <input type="password" class="form-control" id="pw" name="pw" placeholder="비밀번호 입력" required>
                    <label for="pwd">비밀번호</label>
                    <div class="invalid-feedback">
                      비밀번호를 입력해주세요.
                    </div>
                </div>
                <div class="form-floating">
                    <input type="password" class="form-control" id="re_pw" name="re_pw" placeholder="비밀번호 재입력" style="margin-top : 5px" required>
                     <label for="pw">비밀번호 재입력</label>
                </div>
                </div>
              
                <div class="form-floating mb-3">
                  <input type="tel" class="form-control" id="phone" name="phone" placeholder="전화번호 입력" required>
                  <label for="phone">전화번호</label>
                  <div class="invalid-feedback">
                    전화번호를 입력해주세요.
                  </div>
                </div>

              <div class="form-floating mb-3">
                <input type="email" class="form-control" id="email" name="email" placeholder="you@example.com" required>
                <label for="email">이메일</label>
                <div class="invalid-feedback">
                  이메일을 입력해주세요.
                </div>
              </div>
    
              <div class="col-md-4 mb-3">
                  <label for="birth">생년월일</label>
                  <input type="date" class="form-control" id="birth" name="birth" required>
                  <div class="invalid-feedback">
                      생년월일을 입력해주세요.
                  </div>
              </div>
              <div class="col-md-4 mb-3">
                  <label for="gender">성별</label>
              <select class="custom-select d-block w-100" id="gender" name="gender">
              <option value="">성별을 선택해주세요</option>
                  <option>남성</option>
                  <option>여성</option>
              </select>
              <div class="invalid-feedback">
                  성별을 선택해주세요.
              </div>
            </div>
                  
            <hr class="mb-4">
            <div class="custom-control custom-checkbox">
                <input type="checkbox" class="custom-control-input" id="aggrement" required>
                <label class="custom-control-label" for="aggrement">개인정보 수집 및 이용에 동의합니다.</label>
            </div>
            <div class="col-md-12 mb-4"></div>
            <input class="btn btn-primary btn-lg btn-block" type="submit" id="completion"  value="가입 완료"></input>
            <a href="${ pageContext.servletContext.contextPath }/member/user/login"><button class="btn btn-primary btn-lg btn-block" type="button" id="backBtn">뒤로가기</button></a>
            </form>
         </div>
        </div>
        <footer class="my-3 text-center text-small">
        <p class="mb-1" id="copyright">&copy; 2022 Waeating</p>
        </footer>
    </div>
    
    <!-- 아이디 중복확인 -->
    <script>
    $("#db_check").click(function(){
    	
    	const userId = $("#id").val();
    	
    	$.ajax({
    		url: "${ pageContext.servletContext.contextPath }/member/user/ckeckId",
    		type: "get",
    		data: {
    			userId : userId
    		}, 
    		success: function(data) {
    			
    			console.log(data);
    			if(data == true){
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