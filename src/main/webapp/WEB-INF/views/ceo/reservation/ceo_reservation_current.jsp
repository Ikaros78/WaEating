<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>업체</title>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/ceo/style.css">
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
        <h4 class="mb-3 ms-1">예약 관리</h4>
        <div class="list-group list-group-flush border-top border-bottom">
          <!-- 메뉴 세부 제목 -->
          <a href="${ pageContext.servletContext.contextPath }/ceo/reservation_current" class="list-group-item list-group-item-action py-3 select">예약 현황 관리</a>
          <a href="${ pageContext.servletContext.contextPath }/ceo/reservation_list" class="list-group-item list-group-item-action py-3">예약 리스트 보기</a>
         
        </div>
       </aside>
       <!-- 오른쪽 (컨텐츠) -->
       <aside class="float-end col-9 mt-4 ms-3">
        <!-- 이미지 지우고 넣을 컨텐츠 써서 사용 -->
        <!-- <img src="img/visual.jpg" width="100%">  -->
        <div class="px-5 py-3">
          <div class="container mt-3">
            <div class="row pb-4 pe-1">
              
              <div class="container col fs-5 text-start mb-1">
                  <span id="clock1"></span>
                  <span id="clock2"></span>
              </div><!-- 시간-->
              <div class="col fs-5">
                <div class="col form-check form-switch d-flex justify-content-end">
				  <label class="form-check-label" for="waitYn">예약 가능</label>
				  <input class="form-check-input ms-3" type="checkbox" id="waitYn" name="waitYn" value="yes" checked>
				</div>
              </div>
            </div>
            <div id="accordion">
              <div class="card">
                <div class="card-header">
                  <a class="btn container-fluid" data-bs-toggle="collapse" href="#collapse1">
                    <table width="100%">
                      <tr>
                        <td class="h1">1</td>
                        <td class="h4" colspan="2">홍길동</td>
                        <td class="col-8"></td>
                        <td class="text-end pe-1" rowspan="2"><button type="button" class="btn btn-warning text-white" value="고객 호출" data-bs-toggle="modal" data-bs-target="#call">고객 호출</button></td>
                        <td class="text-end ps-1" rowspan="2"><button type="button" class="btn btn-success" value="착석 완료" data-bs-toggle="modal" data-bs-target="#sit">착석 완료</button></td>
                      </tr>
                      <tr>
                        <td>18:20</td>
                        <td class="col-1 text-end pe-1">성인 02</td>
                        <td class="col-1 text-start ps-1">유아 02</td>
                      </tr>
                    </table>
                  </a>
                </div>
                <div id="collapse1" class="collapse" data-bs-parent="#accordion">
                  <div class="card-body">
                    <div class="row">
                      <div class="h5 col-1">홍길동</div>
                      <div class="h5 col-2">010-1234-5678</div>
                    </div>
                    <table width="100%">
                      <tr>
                        <th class="col-1">상태</th>
                        <th class="col-2">예약 취소 사유</th>
                        <th class="col-4">요청사항</th>
                        <th class="col-4">고객 메모</th>
                        <td class="px-3" rowspan="2"><button type="button" class="btn btn-light px-3" value="예약 취소">예약 취소</button></td>
                      </tr>
                      <tr>
                        <td class="col-1"><span class="badge bg-success">착석 완료</span></td>
                        <td class="col-2">-</td>
                        <!-- <span class="badge bg-warning">대기</span>
                        <span class="badge bg-danger">예약 취소</span> -->
                        <td class="col-4">창가자리로 부탁드립니다.</td>
                        <td class="col-4">땅콩 알레르기</td>
                      </tr>
                    </table>
                  </div>
                </div>
              </div>
              <div class="card">
                <div class="card-header">
                  <a class="collapsed btn container-fluid" data-bs-toggle="collapse" href="#collapse2">
                    <table width="100%">
                      <tr>
                        <td class="h1">2</td>
                        <td class="h4" colspan="2">홍길동</td>
                        <td class="col-8"></td>
                        <td class="text-end pe-1" rowspan="2"><button type="button" class="btn btn-warning text-white" value="고객 호출" data-bs-toggle="modal" data-bs-target="#call">고객 호출</button></td>
                        <td class="text-end ps-1" rowspan="2"><button type="button" class="btn btn-success" value="착석 완료" data-bs-toggle="modal" data-bs-target="#sit">착석 완료</button></td>
                      </tr>
                      <tr>
                        <td>18:22</td>
                        <td class="col-1 text-end pe-1">성인 02</td>
                        <td class="col-1 text-start ps-1">유아 00</td>
                      </tr>
                    </table>
                  </a>
                </div>
                <div id="collapse2" class="collapse" data-bs-parent="#accordion">
                  <div class="card-body">
                    <div class="row">
                      <div class="h5 col-1">홍길동</div>
                      <div class="h5 col-2">010-1234-5678</div>
                    </div>
                    <table width="100%">
                      <tr>
                        <th class="col-1">상태</th>
                        <th class="col-2">예약 취소 사유</th>
                        <th class="col-4">요청사항</th>
                        <th class="col-4">고객 메모</th>
                        <td class="px-3" rowspan="2"><button type="button" class="btn btn-light px-3" value="예약 취소">예약 취소</button></td>
                      </tr>
                      <tr>
                        <td class="col-1"><span class="badge bg-success">착석 완료</span></td>
                        <td class="col-2">-</td>
                        <!-- <span class="badge bg-warning">대기</span>
                        <span class="badge bg-danger">예약 취소</span> -->
                        <td class="col-4">창가자리로 부탁드립니다.</td>
                        <td class="col-4">땅콩 알레르기</td>
                      </tr>
                    </table>
                  </div>
                </div>
              </div>
              <div class="card">
                <div class="card-header">
                  <a class="collapsed btn container-fluid" data-bs-toggle="collapse" href="#collapse3">
                    <table width="100%">
                      <tr>
                        <td class="h1">3</td>
                        <td class="h4" colspan="2">홍길동</td>
                        <td class="col-8"></td>
                        <td class="text-end pe-1" rowspan="2"><button type="button" class="btn btn-warning text-white" value="고객 호출" data-bs-toggle="modal" data-bs-target="#call">고객 호출</button></td>
                        <td class="text-end ps-1" rowspan="2"><button type="button" class="btn btn-success" value="착석 완료" data-bs-toggle="modal" data-bs-target="#sit">착석 완료</button></td>
                      </tr>
                      <tr>
                        <td>18:25</td>
                        <td class="col-1 text-end pe-1">성인 04</td>
                        <td class="col-1 text-start ps-1">유아 00</td>
                      </tr>
                    </table>
                  </a>
                </div>
                <div id="collapse3" class="collapse" data-bs-parent="#accordion">
                  <div class="card-body">
                    <div class="row">
                      <div class="h5 col-1">홍길동</div>
                      <div class="h5 col-2">010-1234-5678</div>
                    </div>
                    <table width="100%">
                      <tr>
                        <th class="col-1">상태</th>
                        <th class="col-2">예약 취소 사유</th>
                        <th class="col-4">요청사항</th>
                        <th class="col-4">고객 메모</th>
                        <td class="px-3" rowspan="2"><button type="button" class="btn btn-light px-3" value="예약 취소">예약 취소</button></td>
                      </tr>
                      <tr>
                        <td class="col-1"><span class="badge bg-danger">예약 취소</span></td>
                        <td class="col-2">고객 요청</td>
                        <!-- <td class="col-2">고객 요청 or 대기 마감 or 재료 소진 or 영업 마감</td> -->
                        <!-- <span class="badge bg-warning">대기</span>
                        <span class="badge bg-danger">예약 취소</span> -->
                        <td class="col-4">창가자리로 부탁드립니다.</td>
                        <td class="col-4">땅콩 알레르기</td>
                      </tr>
                    </table>
                  </div>
                </div>
              </div>
              <div class="card">
                <div class="card-header">
                  <a class="btn container-fluid" data-bs-toggle="collapse" href="#collapse4">
                    <table width="100%">
                      <tr>
                        <td class="h1">4</td>
                        <td class="h4" colspan="2">홍길동</td>
                        <td class="col-8"></td>
                        <td class="text-end pe-1" rowspan="2"><button type="button" class="btn btn-warning text-white" value="고객 호출" data-bs-toggle="modal" data-bs-target="#call">고객 호출</button></td>
                        <td class="text-end ps-1" rowspan="2"><button type="button" class="btn btn-success" value="착석 완료" data-bs-toggle="modal" data-bs-target="#sit">착석 완료</button></td>
                      </tr>
                      <tr>
                        <td>18:30</td>
                        <td class="col-1 text-end pe-1">성인 02</td>
                        <td class="col-1 text-start ps-1">유아 02</td>
                      </tr>
                    </table>
                  </a>
                </div>
                <div id="collapse4" class="collapse" data-bs-parent="#accordion">
                  <div class="card-body">
                    <div class="row">
                      <div class="h5 col-1">홍길동</div>
                      <div class="h5 col-2">010-1234-5678</div>
                    </div>
                    <table width="100%">
                      <tr>
                        <th class="col-1">상태</th>
                        <th class="col-2">예약 취소 사유</th>
                        <th class="col-4">요청사항</th>
                        <th class="col-4">고객 메모</th>
                        <td class="px-3" rowspan="2"><button type="button" class="btn btn-danger px-3" value="예약 취소" data-bs-toggle="modal" data-bs-target="#cancel">예약 취소</button></td>
                      </tr>
                      <tr>
                        <td class="col-1"><span class="badge bg-warning">대기</span></td>
                        <td class="col-2">-</td>
                        <!-- 
                          <span class="badge bg-success">착석 완료</span>
                          <span class="badge bg-warning">대기</span>
                          <span class="badge bg-danger">예약 취소</span> 
                        -->
                        <td class="col-4">창가자리로 부탁드립니다.</td>
                        <td class="col-4">땅콩 알레르기</td>
                      </tr>
                    </table>
                  </div>
                </div>
              </div>
              <div class="card">
                <div class="card-header">
                  <a class="btn container-fluid" data-bs-toggle="collapse" href="#collapse5">
                    <table width="100%">
                      <tr>
                        <td class="h1">5</td>
                        <td class="h4" colspan="2">홍길동</td>
                        <td class="col-8"></td>
                        <td class="text-end pe-1" rowspan="2"><button type="button" class="btn btn-warning text-white" value="고객 호출" data-bs-toggle="modal" data-bs-target="#call">고객 호출</button></td>
                        <td class="text-end ps-1" rowspan="2"><button type="button" class="btn btn-success" value="착석 완료" data-bs-toggle="modal" data-bs-target="#sit">착석 완료</button></td>
                      </tr>
                      <tr>
                        <td>18:38</td>
                        <td class="col-1 text-end pe-1">성인 02</td>
                        <td class="col-1 text-start ps-1">유아 02</td>
                      </tr>
                    </table>
                  </a>
                </div>
                <div id="collapse5" class="collapse" data-bs-parent="#accordion">
                  <div class="card-body">
                    <div class="row">
                      <div class="h5 col-1">홍길동</div>
                      <div class="h5 col-2">010-1234-5678</div>
                    </div>
                    <table width="100%">
                      <tr>
                        <th class="col-1">상태</th>
                        <th class="col-2">예약 취소 사유</th>
                        <th class="col-4">요청사항</th>
                        <th class="col-4">고객 메모</th>
                        <td class="px-3" rowspan="2"><button type="button" class="btn btn-danger px-3" value="예약 취소" data-bs-toggle="modal" data-bs-target="#cancel">예약 취소</button></td>
                      </tr>
                      <tr>
                        <td class="col-1"><span class="badge bg-warning">대기</span></td>
                        <td class="col-2">-</td>
                        <!-- <span class="badge bg-warning">대기</span>
                        <span class="badge bg-danger">예약 취소</span> -->
                        <td class="col-4">창가자리로 부탁드립니다.</td>
                        <td class="col-4">땅콩 알레르기</td>
                      </tr>
                    </table>
                  </div>
                </div>
              </div>
            </div><!-- 아코디언 -->

            <!-- 고객 호출 modal -->
            <div class="modal fade" id="call">
              <div class="modal-dialog">
                <div class="modal-content">
            
                  <!-- Modal Header -->
                  <div class="modal-header">
                    <h4 class="modal-title">고객 호출</h4>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                  </div>
            
                  <!-- Modal body -->
                  <div class="modal-body">
                    고객을 호출합니다.
                  </div>
            
                  <!-- Modal footer -->
                  <div class="modal-footer">
                    <button type="button" class="btn btn-primary" data-bs-dismiss="modal">확인</button>
                  </div>
            
                </div>
              </div>
            </div>

            <!-- 착석 완료 modal -->
            <div class="modal fade" id="sit">
              <div class="modal-dialog">
                <div class="modal-content">
            
                  <!-- Modal Header -->
                  <div class="modal-header">
                    <h4 class="modal-title">착석 완료</h4>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                  </div>
            
                  <!-- Modal body -->
                  <div class="modal-body">
                    착석이 완료되었습니다.
                  </div>
            
                  <!-- Modal footer -->
                  <div class="modal-footer">
                    <button type="button" class="btn btn-primary" data-bs-dismiss="modal">확인</button>
                  </div>
            
                </div>
              </div>
            </div>
            
            <!-- 예약 취소 modal -->
            <div class="modal fade" id="cancel">
              <div class="modal-dialog">
                <div class="modal-content">
            
                  <!-- Modal Header -->
                  <div class="modal-header">
                    <h4 class="modal-title">예약 취소 사유를 선택해주세요.</h4>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                  </div>
            
                  <!-- Modal body -->
                  <div class="modal-body d-flex justify-content-center">
                    <button type="button" class="btn btn-light p-4 mx-3" data-bs-dismiss="modal">재료 소진</button>
                    <button type="button" class="btn btn-light p-4 mx-3" data-bs-dismiss="modal">대기 마감</button>
                    <button type="button" class="btn btn-light p-4 mx-3" data-bs-dismiss="modal">영업 종료</button>
                  </div>
            
                  <!-- Modal footer -->
                  <!-- <div class="modal-footer">
                    <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
                  </div> -->
            
                </div>
              </div>
            </div>

            <div class="d-flex justify-content-center my-3">
              <button type="button" class="btn btn-danger" style="background: #D94925; border: #D94925;">더보기</button>
            </div>
           
          </div>  
        </div>
       </aside>
    </section>
   
   <jsp:include page="../common/ceo_footer.jsp"/>

  </div>
  <script src="${ pageContext.servletContext.contextPath }/resources/js/ceo/clock.js"></script>
</body>
</html>