<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>웨잇-팅 업주 회원가입</title>
    <!-- 부트스트랩 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- 파일 -->
    <script src="${ pageContext.servletContext.contextPath }/resources/js/ceo/ceo-sign_up.js"></script>
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/ceo/ceo-login/ceo-sign_up.css">
    <script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
    <div class="container">
        <div class="input-form-backgroud row">
          <div class="input-form col-md-12">
            <h4 class="mb-3">업주 회원가입</h4>
            <form class="validation-form" method="post">
              <div class="row">
                  <div class="form-floating col-md-6 mb-3">
                      <input type="text" class="form-control" id="id" name="name" placeholder="아이디 입력" required>
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
                    <label for="pw">비밀번호</label>
                    <div class="invalid-feedback">
                      비밀번호를 입력해주세요.
                    </div>
                </div>
                <div class="form-floating">
                    <input type="password" class="form-control" id="re_pw" name="re_pw" placeholder="비밀번호 재입력"style="margin-top : 5px"  required>
                     <label for="pw">비밀번호 재입력</label>
                </div>
                </div>
              
                <div class="form-floating mb-3">
                  <input type="tel" class="form-control" id="phone" name="phone" placeholder="전화번호 입력" required>
                  <label for="phone">업주 전화번호</p></label>
                  <div class="invalid-feedback">
                    업주 전화번호를 입력해주세요.
                  </div>
                </div>

                <div class="form-floating mb-3">
                  <input type="email" class="form-control" id="email" name="email" placeholder="you@example.com" required>
                  <label for="email">이메일</label>
                  <div class="invalid-feedback">
                    이메일을 입력해주세요.
                  </div>
                </div>
                
                <hr class="mb-4">
                <h5 class="mb-3">업체 정보 추가 입력</h5>

                <div class="form-floating mb-3">
                  <input type="text" class="form-control" id="store_name" name="store_name" placeholder="업체 이름 입력" required>
                  <label for="store_name">업체 이름</label>
                  <div class="invalid-feedback">
                    업체 이름을 입력해주세요.
                  </div>
              </div>

                <div class="form-floating mb-3">
                  <input type="tel" class="form-control" id="store_phone" name="store_phone" placeholder="업체 전화번호 입력" required>
                  <label for="store_phone">업체 전화번호</p></label>
                  <div class="invalid-feedback">
                    업체 전화번호를 입력해주세요.
                  </div>
                </div>

                <div class="form-floating mb-3">
                  <input type="text" class="form-control" id="strore_address" name="strore_address" placeholder="업체 주소 입력" required>
                  <label for="strore_address">업체 주소</label>
                  <div class="invalid-feedback">
                    업체 주소를 입력해주세요.
                  </div>
              </div>
              
              <div class="col-md-4 mb-3">
                  <label for="category">카테고리</label>
              <select class="custom-select d-block w-100" id="category" name="category">
              <option value="">카테고리를 선택해주세요</option>
                  <option>한식</option>
                  <option>분식</option>
                  <option>일식</option>
                  <option>양식</option>
                  <option>중식</option>
                  <option>카페</option>
                  <option>기타</option>
              </select>
              <div class="invalid-feedback">
                  카테고리를 선택해주세요.
              </div>
            </div>

              <div class="col-md-6 mb-3">
                <label for="business">사업자 등록증</label>
                <input type="file" class="form-control" id="business" name="business" accept=".jpg, .jpeg, .png, .pdf" required multiple>
                <div class="invalid-feedback">
                  사업자 등록증을 등록해주세요
                </div>
            </div>
                  
            <hr class="mb-4">
            <div class="custom-control custom-checkbox">
                <input type="checkbox" class="custom-control-input" id="aggrement" required>
                <label class="custom-control-label" for="aggrement">개인정보 수집 및 이용에 동의합니다.</label>
            </div>
            <div class="col-md-12 mb-4"></div>
            <button class="btn btn-primary btn-lg btn-block" type="submit" id="completion">가입 완료</button>
            <a href="${ pageContext.servletContext.contextPath }/member/ceo/login"><button class="btn btn-primary btn-lg btn-block" type="button" id="backBtn">뒤로가기</button></a>
            </form>
         </div>
        </div>
        <footer class="my-4 text-center text-small">
        <p class="mb-1" id="copyright">&copy; 2022 Waeating</p>
        </footer>
    </div>
    <!-- 아이디 중복확인 -->
    <script>
    $("#db_check").click(function(){
    	
    	const ceoId = $("#id").val();
    	
    	$.ajax({
    		url: "${ pageContext.servletContext.contextPath }/member/ceo/ckeckId",
    		type: "get",
    		data: {
    			ceoId : ceoId
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