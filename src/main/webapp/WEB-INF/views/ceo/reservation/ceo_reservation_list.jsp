<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
          <a href="${ pageContext.servletContext.contextPath }/ceo/reservation_current" class="list-group-item list-group-item-action py-3">예약 현황 관리</a>
          <a href="${ pageContext.servletContext.contextPath }/ceo/reservation_list" class="list-group-item list-group-item-action py-3 select">예약 리스트 보기</a>
         
        </div>
       </aside>
       <!-- 오른쪽 (컨텐츠) -->
       <aside class="float-end col-9 mt-4 ms-3" style="min-height : 840px">
        <!-- 이미지 지우고 넣을 컨텐츠 써서 사용 -->
        <!-- <img src="img/visual.jpg" width="100%">  -->
        <div class="px-5 py-3">
          <div class="container mt-3">
            <div class="row pb-3 pe-1">
              <div class="col">
                
              </div>
              <div class="container ">
                  <!-- <span id="clock1"></span>
                  <span id="clock2"></span> -->
                  <div class="input-group mb-2 d-flex justify-content-end">
	                <form id="loginForm" action="${ pageContext.servletContext.contextPath }/ceo/reservation_list" method="get" style="display:inline-block">
						<div class="input-group mb-3">
						<select id="searchCondition" name="searchCondition" class="form-control" style="display: none ">
							<option value="date" ${ requestScope.selectCriteria.searchCondition eq "date"? "selected": "" }>날짜</option>
						</select>
						<input style="width:150px" type="date" class="form-control" id="searchValue" name="searchValue" value="<c:out value="${ requestScope.selectCriteria.searchValue }"/>">
	                    <button class="btn btn-primary" type="submit">검색</button>
						</div>		
					</form>
                 </div>
              </div>
            </div><!-- 시간-->
            <div id="accordion" class="mb-3">
              <c:forEach var="waiting" items="${ requestScope.waitingRecordListDate }" varStatus="stu">
              <div class="card">
                <div class="card-header">
                  <a class="btn container-fluid" data-bs-toggle="collapse" href="#collapse${ stu.count }">
                    <table width="100%">
                      <tr>
                        <td class="h1">${ waiting.rNum }</td>
                        <td class="col-2 h4 text-center">${ waiting.memberInfo.name }</td>
                        <td class="col-9"></td>
                        <td class="text-end ps-1" rowspan="2">
                        	<c:if test="${ waiting.useStatus eq 'called' }">
                        		<button type="button" class="btn btn-success" value="착석 완료" style="width: 65px" onclick="location.href='${ pageContext.servletContext.contextPath }/ceo/reservation_current_sit?recordNo=${ waiting.recordNo }'">착석 완료</button>
                        	</c:if>
                        	<c:if test="${ waiting.useStatus ne 'called' }">
                        		<button type="button" class="btn btn-secondary" value="착석 완료" style="width: 65px; background: #bbb; border:0" disabled>착석 완료</button>
                        	</c:if>
                        </td>
                      </tr>
                      <tr>
                        <td>${ waiting.useTime }</td>
                        <td class="col-1 text-center">인원 ${ waiting.memberNum }</td>
                      </tr>
                    </table>
                  </a>
                </div>
                <div id="collapse${ stu.count }" class="collapse" data-bs-parent="#accordion">
                  <div class="card-body">
                    <table width="100%">
                      <tr>
                      	<td><h5>${ waiting.memberInfo.name }</h5></td>
                      	<td><h5>${ waiting.memberInfo.phone }</h5></td>
                      </tr>
                      <tr>
                        <th class="col-1">상태</th>
                        <th class="col-2">예약 취소 사유</th>
                        <th class="col-9">요청사항</th>
                        <td class="px-2" rowspan="2">
                        	<c:if test="${ waiting.useStatus eq 'called' }">
                        		<button type="button" class="btn btn-danger me-2" value="예약 취소" data-bs-toggle="modal" data-bs-target="#cancel" style="width: 65px">예약 취소</button>
                        	</c:if>
                        	<c:if test="${ waiting.useStatus ne 'called' }">
                        		<button type="button" class="btn btn-light me-2" value="예약 취소" style="width: 65px" disabled>예약 취소</button>
                        	</c:if>
                        </td>
                      </tr>
                      <tr>
                        <td class="col-1">
                        	<c:if test="${ waiting.useStatus eq 'called' }">
                        		<span class="badge bg-primary">호출 완료</span>
                        	</c:if>
                        	<c:if test="${ waiting.useStatus eq 'complete' }">
                        		<span class="badge bg-success">착석 완료</span>
                        	</c:if>
                        	<c:if test="${ waiting.useStatus eq 'waiting' }">
                        		<span class="badge bg-warning">대기</span>
                        	</c:if>
                        	<c:if test="${ waiting.useStatus eq 'cancel' }">
                        		<span class="badge bg-danger">예약 취소</span>
                        	</c:if>
                        </td>
                        <td class="col-2">
                        	<c:if test="${ waiting.useStatus ne 'cancel' }">
                        	-
                        	</c:if>
                        	<c:if test="${ waiting.useStatus eq 'cancel' }">
                        		<c:if test="${ waiting.refuseReason.refuseReason eq 'soldout' }">
                        			재료소진
                        		</c:if>
                        		<c:if test="${ waiting.refuseReason.refuseReason eq 'close' }">
                        			영업종료
                        		</c:if>
                        		<c:if test="${ waiting.refuseReason.refuseReason eq 'waitingclose' }">
                        			대기마감
                        		</c:if>
                        		<c:if test="${ waiting.refuseReason.refuseReason eq 'request' }">
                        			고객요청
                        		</c:if>
                        		<c:if test="${ waiting.refuseReason.refuseReason eq 'noshow' }">
                        			고객부재
                        		</c:if>
                        	</c:if>
                        </td>
                        <!-- <span class="badge bg-warning">대기</span>
                        <span class="badge bg-danger">예약 취소</span> -->
                        <td class="col-8">
                        	<c:if test="${ waiting.requirement eq null }">
                        		-
                        	</c:if>
                        	<c:if test="${ waiting.requirement ne null }">
                        		${ waiting.requirement }
                        	</c:if>
                        </td>
                      </tr>
                    </table>
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
                    <button type="button" class="btn btn-light p-4 mx-3" value="soldout" onclick="location.href='${ pageContext.servletContext.contextPath }/ceo/reservation_list_refuse?recordNo=${ waiting.recordNo }&refuseReason=noshow'">고객 부재</button>
                  </div>
            
                  <!-- Modal footer -->
                  <!-- <div class="modal-footer">
                    <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
                  </div> -->
            
                </div>
              </div>
            </div>
            
              </c:forEach>
              
            </div><!-- 아코디언 -->
			<jsp:include page="../common/paging_reservationl.jsp"/>
           
          </div>  
        </div>
       </aside>
    </section>
   
   <jsp:include page="../common/ceo_footer.jsp"/>

  </div>
</body>
</html>