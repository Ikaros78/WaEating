<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 정보 수정</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="${ pageContext.servletContext.contextPath }/resources/js/user/user-update.js" ></script>
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/user/user-mypage/user-update.css">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
  <!-- header -->
 
 <jsp:include page="../common/ceo_header.jsp"/>

  <div id="wrap">
    <!-- 왼쪽 (메뉴) -->
    <section class="row container-fluid px-5">
      <aside class="float-start col-2 mt-4 ms-5 px-3">
        <!-- 메뉴 제목 -->
        <h4 class="mb-3 ms-1">마이 페이지</h4>
        <div class="list-group list-group-flush border-top border-bottom">
          <!-- 메뉴 세부 제목 -->
          <a href="${ pageContext.servletContext.contextPath }/ceo/check/password" class="list-group-item list-group-item-action py-3 select">개인 정보 수정</a>
          <a href="${ pageContext.servletContext.contextPath }/ceo/rest_notice" class="list-group-item list-group-item-action py-3">고객센터</a>
        </div>
       </aside>
       <!-- 오른쪽 (컨텐츠) -->
       <aside class="float-end col-9 mt-4 ms-3 border">
        <div id="container">
        <h1>회원 정보 수정</h1>
        <hr id="con_hr">
        <form action="" id="user_update" method="post" onsubmit="return ck_infor();">
            <div class="profile">
              <div class="profile_img">
                <img src="../img/profile.png" alt="프로필">
              </div>
              <input type="file" accept=".jpg,.jpeg,.png" name="upload" id="upload">
            </div>

            <label for="id">아이디</label>
            <input type="text" name="id" id="id" value="${ sessionScope.loginMember.id }" readonly="readonly"><br>

            <label for="name">이름</label>
            <input type="text" name="name" id="name" placeholder="${ sessionScope.loginMember.name }" ><br>

            
            <table class="update_pwd">
              <tr>
                <td  rowspan="3"><label for="password" style="margin-bottom: 0;">비밀번호</label></td>
              </tr>
              <tr>
                <td><input type="password" name="pw" class="pw" placeholder="새 비밀번호를 입력하세요" style="margin-bottom: 3px;"><br></td>
              </tr>
              <tr>
                <td><input type="password" name="newPw" class="pw" placeholder="새 비밀번호를 다시 입력하세요"><br></td>
              </tr>
            </table>
           
            <label for="phone">전화번호</label>
            <input type="tel" name="phone" id="phone" placeholder="${ sessionScope.loginMember.phone }" ><br>
            

            <label for="email">이메일</label>
            <input type="email" name="email" id="email" placeholder="${ sessionScope.loginMember.email }"><br>


			<label for="name">사업자 번호</label>
            <input type="text" name="business" id="business" placeholder="${ sessionScope.loginMember.comInfo.comRegist }" ><br>
			
			<input type="submit" value="회원수정" id="updatebtn">
        </form>

       </aside>
    </section>
   
	<jsp:include page="../common/ceo_footer.jsp"/>
  </div>
  

</body>
</html>