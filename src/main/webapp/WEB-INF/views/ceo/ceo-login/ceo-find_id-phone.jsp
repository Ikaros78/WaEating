<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>업주 아이디 찾기</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/ceo/ceo-login/ceo-find-detail.css">
    <!-- Bootstrap CSS -->
</head>
<body>
    <div class="container">
        <div class="input-form-backgroud row">
          <div class="input-form col-md-12">
            <h4 class="mb-3">전화번호로 찾기</h4>
            <form class="validation-form" method="post">
              
              
              <div class="form-floating mb-3">
                  <input type="text" class="form-control" id="name" name="name" placeholder="이름 입력" required>
                  <label for="name">이름</label>
                  <div class="invalid-feedback">
                    이름을 입력해주세요.
                  </div>
              </div>

            <div class="form-floating mb-3">
                <input type="tel" class="form-control" id="phone" name="phone" placeholder="전화번호 입력" required>
                <label for="phone">전화번호</p></label>
                <div class="invalid-feedback">
                  전화번호를 입력해주세요.
                </div>
              </div> 

              <div class="form-floating mb-3">
                <input type="text" class="form-control" id="store_name" name="store_name" placeholder="업체 이름 입력" required>
                <label for="store_name">업체 이름</label>
                <div class="invalid-feedback">
                  업체 이름을 입력해주세요.
                </div>
            </div>
  
            <div class="form-floating mb-3">
                  <input type="tel" class="form-control" id="store_phone" name="store_phone" placeholder="업체 전화번호 입력" required>
                  <label for="store_phone">업체 전화번호</label>
                  <div class="invalid-feedback">
                    업체 전화번호를 입력해주세요.
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

            <hr class="mb-4">
            <div class="col-md-12 mb-4"></div>
            <button class="btn btn-primary btn-lg btn-block" type="submit" id="completion">아이디 찾기</button>
            <a href="${ pageContext.servletContext.contextPath }/member/ceo/findid"><button class="btn btn-primary btn-lg btn-block" type="button" id="backBtn">뒤로가기</button></a>
            </form>
         </div>
        </div>
        <footer class="my-3 text-center text-small">
        <p class="mb-1" id="copyright">&copy; 2022 Waeating</p>
        </footer>
    </div>
</body>
</html>