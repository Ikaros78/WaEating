<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>user_reservation</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/user/user.css">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

  <link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body>
 <jsp:include page="../user_header.jsp"/>
  <div id="wrap">
    <!-- 왼쪽 (메뉴) -->
    <section class="row container-fluid px-5">
      <aside class="float-start col-2 mt-4 ms-5 px-3">
        <!-- 메뉴 제목 -->
        <h4 class="mb-3 ms-1">맛집 리스트</h4>
        <div class="list-group list-group-flush border-top border-bottom">
          <!-- 메뉴 세부 제목 -->
          <a href="${ pageContext.servletContext.contextPath }/user/matziplist/grade" class="list-group-item list-group-item-action py-3 select">평점별</a> <!-- 상세 페이지에 select 클래스 넣어주기 -->
          <a href="${ pageContext.servletContext.contextPath }/user/matziplist/location" class="list-group-item list-group-item-action py-3">지역별</a>
          <a href="${ pageContext.servletContext.contextPath }/user/matziplist/category" class="list-group-item list-group-item-action py-3">종류별</a>
        </div>
       </aside>
       <!-- 오른쪽 (컨텐츠) -->
       <aside class="float-end col-9 mt-4 ms-3 border">
        <!-- 이미지 지우고 넣을 컨텐츠 써서 사용 -->
        
        <br>
        <h2 style="text-indent: 30px;">또 보겠지 떡볶이집 몽글몽글 청계점</h2> 
        <hr>

        <form action="" name="reservation">

          <p style="text-indent: 30px;">현재 대기중</p>
          <p style="text-indent: 30px; color: #D94925;">5팀</p>

            <!-- <p style="margin-left: 32px;">예약날짜</p>
            <input id ="datepicker" placeholder="날짜를 선택하세요." type="text" style="border: 1px solid gray; border-radius: 2px;">
            <script>
                $(function(){
                    $('#datepicker').datepicker({
                        dateFormat: 'yy-mm-dd' //달력 날짜 형태
                    ,showOtherMonths: true //빈 공간에 현재월의 앞뒤월의 날짜를 표시
                    ,showMonthAfterYear:true // 월- 년 순서가아닌 년도 - 월 순서
                    ,changeYear: true //option값 년 선택 가능
                    ,changeMonth: true //option값  월 선택 가능                
                    ,buttonImage: "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif" //버튼 이미지 경로
                    ,buttonImageOnly: true //버튼 이미지만 깔끔하게 보이게함
                    ,buttonText: "선택" //버튼 호버 텍스트              
                    ,yearSuffix: "년" //달력의 년도 부분 뒤 텍스트
                    ,monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 텍스트
                    ,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 Tooltip
                    ,dayNamesMin: ['일','월','화','수','목','금','토'] //달력의 요일 텍스트
                    ,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'] //달력의 요일 Tooltip
                    ,minDate: "-5Y" //최소 선택일자(-1D:하루전, -1M:한달전, -1Y:일년전)
                    ,maxDate: "+5y" //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)  
                     });
                })
            </script>

            <div class="container mt-3">
                <label for="sel1" class="form-label" style="width: 300px;">시간</label>
                <select class="form-select" id="sel1" name="sellist1">
                    <option>11:00</option>
                    <option>12:00</option>
                    <option>13:00</option>
                    <option>14:00</option>
                    <option>15:00</option>
                    <option>16:00</option>
                    <option>17:00</option>
                    <option>18:00</option>
                    <option>19:00</option>
                    <option>20:00</option>
                </select>
            </div> -->

            <div class="container mt-3">
                <label for="sel1" class="form-label col-11" >성인</label>
                <select class="form-select" id="sel1" name="sellist1">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option>5</option>
                    <option>6</option>
                    <option>7</option>
                    <option>8</option>
                    <option>9</option>
                    <option>10</option>
                </select>
                <br>
                <label for="sel1" class="form-label" >유아</label>
                <select class="form-select  col-11" id="sel1" name="sellist1">
                    <option>0</option>
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                </select>
                <br>
                <label for="phone" style="margin-bottom: 7px;">전화번호</label>
                <input type="phone" class="form-control" id="phone" placeholder="전화번호를 입력하세요." name="phone" style="margin-bottom: 15px;">
            </div>

            <!-- <div class="mb-3 mt-3 ms-4 col-11"  >

            </div> -->


            <button type="submit" class="btn btn-primary" style="margin-left: 29px; margin-bottom: 25px;">예약하기</button>
        </form>

</aside>
</section>

    <jsp:include page="../user_footer.jsp"/>

  </div>

</body>
</html>