<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>업체</title>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/ceo/rest_detail_style.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<jsp:include page="../common/ceo_header.jsp"/>

  <div id="wrap">
    <!-- 왼쪽 (메뉴) -->
    <section class="row container-fluid px-5">
      <aside class="float-start col-2 mt-4 ms-5 px-3">
        <!-- 메뉴 제목 -->
        <h4 class="mb-3 ms-1">가게 관리</h4>
        <div class="list-group list-group-flush border-top border-bottom">
          <!-- 메뉴 세부 제목 -->
          <a href="${ pageContext.servletContext.contextPath }/ceo/rest_restInfo" class="list-group-item list-group-item-action py-3">가게 정보 관리</a>
          <a href="${ pageContext.servletContext.contextPath }/ceo/rest_notice" class="list-group-item list-group-item-action py-3">공지 관리</a>
          <a href="${ pageContext.servletContext.contextPath }/ceo/rest_review" class="list-group-item list-group-item-action py-3 select">리뷰 관리</a>
        </div>
       </aside>
       <!-- 오른쪽 (컨텐츠) -->
       <aside class="float-end col-9 mt-4 ms-3" style="min-height : 700px">
        <!-- 이미지 지우고 넣을 컨텐츠 써서 사용 -->
        <!-- <img src="img/visual.jpg" width="100%">  -->
        <div class="px-5 py-3">
          <form action="${ pageContext.servletContext.contextPath }/ceo/rest_review" method="post">
            <table width="100%">
              <tr>
                <td class="ps-3 col-1 text-center d-flex justify-content-start h5">abc12***</td>
                <td class="px-3 col-1 text-warning text-center h4" rowspan="2">★★★★☆</td>
              </tr>
              <tr>
                <td class="ps-3 text-center d-flex justify-content-start pb-3">2022.07.01</td>
              </tr>
              <tr>
                <td class="ps-3" colspan="2">입맛 없을 땐 여기가 제일 먼저 생각나요! 알싸하게 매콤한 게 입맛돌게 해주거든요. 너무 맛있게 잘 먹었습니다.</td>
              </tr>
              <tr>
                <td class="ps-3 py-3" colspan="2">
                    <img src="${ pageContext.servletContext.contextPath }/resources/images/ceo/rest1.jpg" alt="rest1" width="233px" height="200px" class="mx-1">
                    <img src="${ pageContext.servletContext.contextPath }/resources/images/ceo/rest2.jpg" alt="rest2" width="233px" height="200px" class="mx-1">
                    <img src="${ pageContext.servletContext.contextPath }/resources/images/ceo/rest3.jpg" alt="rest3" width="233px" height="200px" class="mx-1">
                </td>
              </tr>  
              <tr>
                <td colspan="2"><textarea class="form-control mb-2 ms-1" rows="5"name="review" id="review" placeholder="답변을 등록해주세요."></textarea></td>
              </tr>
            </table>
            <div class="d-flex justify-content-center">
              <button type="button" class="btn btn-outline-danger me-2" value="삭제" data-bs-toggle="modal" data-bs-target="#modalDeleteq">삭제</button>
              <button type="button" class="btn btn-outline-primary" value="수정" data-bs-toggle="modal" data-bs-target="#modalSubmit">수정</button>
            </div>

            <!-- Modal (삭제) -->
            <div class="modal fade" id="modalDeleteq">
              <div class="modal-dialog">
                <div class="modal-content">
            
                  <!-- Modal Header -->
                  <div class="modal-header">
                    <h4 class="modal-title">답변 삭제</h4>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                  </div>
            
                  <!-- Modal body -->
                  <div class="modal-body">
                    답변을 삭제하시겠습니까?
                  </div>
            
                  <!-- Modal footer -->
                  <div class="modal-footer">
                    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modalDelete">확인</button>
                  </div>
                </div>
              </div>
            </div>

            <!-- Modal (삭제) -->
            <div class="modal fade" id="modalDelete">
              <div class="modal-dialog">
                <div class="modal-content">
            
                  <!-- Modal Header -->
                  <div class="modal-header">
                    <h4 class="modal-title">답변 삭제</h4>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                  </div>
            
                  <!-- Modal body -->
                  <div class="modal-body">
                    답변이 삭제되었습니다.
                  </div>
            
                  <!-- Modal footer -->
                  <div class="modal-footer">
                    <button type="submit" class="btn btn-primary" data-bs-dismiss="modal" onclick="history.go(-1)">확인</button>
                  </div>
                </div>
              </div>
            </div>

            <!-- Modal (수정) -->
            <div class="modal fade" id="modalSubmit">
              <div class="modal-dialog">
                <div class="modal-content">
            
                  <!-- Modal Header -->
                  <div class="modal-header">
                    <h4 class="modal-title">답변 수정</h4>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                  </div>
            
                  <!-- Modal body -->
                  <div class="modal-body">
                    답변 수정이 완료되었습니다.
                  </div>
            
                  <!-- Modal footer -->
                  <div class="modal-footer">
                    <button type="submit" class="btn btn-primary" data-bs-dismiss="modal" onclick="history.go(-1)">확인</button>
                  </div>
            
                </div>
              </div>
            </div>
          </form>
          <!-- <div class="d-flex justify-content-center">
            <button type="button" class="btn btn-outline-secondary me-2" value="취소" onclick="history.go(-1)">취소</button>
            <button type="submit" class="btn btn-primary" value="등록">등록</button>
          </div> -->
        
          <!-- <div class="row">
            <h5 class="col-2">제목</h5>
            <input type="text" class="form-control mb-3" placeholder="제목을 입력해주세요." name="title" id="title">
          </div> -->
          
          <!-- <h5>내용</h5>
          <textarea class="form-control" rows="5"name="content" id="content" placeholder="가게나 메뉴 소개, 이벤트 등 눈에 띄었으면 하는 내용을 올려주세요."></textarea> -->
          
        </div>
       </aside>
    </section>
   
    <jsp:include page="../common/ceo_footer.jsp"/>

  </div>
</body>
</html>