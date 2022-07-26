<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>아이디 찾기</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/user/user-login/user-find-detail.css">
    <!-- Bootstrap CSS -->
</head>
<body>
    <div class="container">
        <div class="input-form-backgroud row">
          <div class="input-form col-md-12">
            <h4 class="mb-3">전화번호로 찾기</h4>
            <form class="validation-form" novalidate>
              
              
              <div class="form-floating mb-3">
                  <input type="name" class="form-control" id="name" placeholder="이름 입력" required>
                  <label for="name">이름</label>
                  <div class="invalid-feedback">
                    이름을 입력해주세요.
                  </div>
              </div>

              <div class="col-md-4 mb-3">
                  <label for="birth">생년월일</label>
                  <input type="date" class="form-control" id="birth" placeholder="" required>
                  <div class="invalid-feedback">
                      생년월일을 입력해주세요.
                  </div>
              </div>

              <div class="col-md-4 mb-3">
                  <label for="gender">성별</label>
              <select class="custom-select d-block w-100" id="gender">
              <option value="">성별을 선택해주세요</option>
                  <option>남성</option>
                  <option>여성</option>
              </select>
              <div class="invalid-feedback">
                  성별을 선택해주세요.
              </div>
            </div>

            <div class="form-floating mb-3">
                <input type="tel" class="form-control" id="phone" placeholder="전화번호 입력" required>
                <label for="phone">전화번호</p></label>
                <div class="invalid-feedback">
                  전화번호를 입력해주세요.
                </div>
              </div> 

            <hr class="mb-4">
            <div class="col-md-12 mb-4"></div>
            <button class="btn btn-primary btn-lg btn-block" type="submit" id="completion">아이디 찾기</button>
            <a href="${ pageContext.servletContext.contextPath }/member/user/findid"><button class="btn btn-primary btn-lg btn-block" type="button" id="backBtn">뒤로가기</button></a>
            </form>
         </div>
        </div>
        <footer class="my-3 text-center text-small">
        <p class="mb-1" id="copyright">&copy; 2022 Wai-eating</p>
        </footer>
    </div>
</body>
</html>