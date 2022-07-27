<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>고객센터</title>
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/user/user.css">
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
 <jsp:include page="../user/user_header.jsp"/>
 <div id="wrap">
    <!-- 왼쪽 (메뉴) -->
    <section class="row container-fluid px-5">
      <aside class="float-start col-2 mt-4 ms-5 px-3">
        <!-- 메뉴 제목 -->
        <h4 class="mb-3 ms-1">맛집리스트</h4>
        <div class="list-group list-group-flush border-top border-bottom">
          <!-- 메뉴 세부 제목 -->
          <a href="#" class="list-group-item list-group-item-action py-3 select">평점별</a><!-- 상세 페이지에 select 클래스 넣어주기 -->
          <a href="#" class="list-group-item list-group-item-action py-3">지역별</a>
          <a href="#" class="list-group-item list-group-item-action py-3">종류별</a>
        </div>
       </aside>
       <!-- 오른쪽 (컨텐츠) -->
       <aside class="float-end col-9 mt-4 ms-3 border">
        <!-- 이미지 지우고 넣을 컨텐츠 써서 사용 -->
        <!-- <img src="./images/visual.jpg" width="100%">  -->
        <body>

            <!-- 검색 폼 영역 -->
     
            <form name="searchForm" action="" method="get" >
            <div class="table">
            <p>
     
                <select name="searchType">
     
                    <option value="ALL">전체검색</option>
     
                    <option value="SUBJECT">제목</option>
     
                    <option value="WRITER">작성자</option>
     
                    <option value="CONTENTS">내용</option>
     
                </select>
     
                <input type="text" name="searchText" value="" />
     
                <input type="submit" value="검색" />
     
            </p>
     
            </form> 
     
            <!-- //검색 폼 영역 -->
     
            <!-- 게시판 목록 영역 -->
     
            <table border ="1" summary="게시판 목록">
     
             <a href="./user_oftenQuest.html">자주 묻는 질문</a>
     
                <colgroup class="list">
     
                    <col width="50" />
     
                    <col width="300" />
     
                    <col width="80" />
     
                    <col width="100" />
     
                    <col width="70" />
     
               
     
                <thead>
     
                    <tr>
     
                         <th>번호</th>
     
                         <th>제목</th>
     
                         <th>작성자</th>
     
                         <th>등록 일시</th>
     
                         <th>조회수</th>
     
                    </tr>
     
                </thead>
     
                <tbody>
                 
                 <tr>
     
                         <td text-align="center">1</td>
     
                         <td><a href="boardView.jsp">웨잇-팅 질문</a></td>
     
                         <td text-align="center">김연서</td>
     
                         <td text-align="center">2022.07.12</td>
     
                         <td text-align="center">10</td>
     
                    </tr>
     
                    <tr>
     
                     <td text-align="center">2</td>
     
                     <td><a href="boardView.jsp">웨잇-팅 질문2</a></td>
     
                     <td text-align="center">김연서1</td>
     
                     <td text-align="center">2022.07.12</td>
     
                     <td text-align="center">10</td>
     
                </tr>
     
                <tr>
     
                 <td text-align="center">3</td>
     
                 <td><a href="boardView.jsp">웨잇-팅 질문3</a></td>
     
                 <td text-align="center">김연서2</td>
     
                 <td text-align="center">2022.07.12</td>
     
                 <td text-align="center">10</td>
     
            </tr>
     
                </tbody>
                  
                <tfoot>
     
                    <tr>
     
                         <td text-align="center" colspan="5">1</td>
     
                    </tr>
     
                </tfoot>
                  
            </table>
         </colgroup>  
         </div>
             <!-- 버튼 영역 -->
             <div class="button" >
              <p >
                 
      
               <!-- <input type="button" value="목록" onclick="goUrl('boardList.jsp');" />
     -->
               
               <a href="./고객센터 문의사항 작성.html"><input type="button" value="글쓰기"></a>
              
               <input type="button" value="삭제" onclick="goUrl('boardWriteDelet.jsp');" />
    
               <input type="button" value="답변확인" onclick="goUrl('boardWriteCheck.jsp');" />
    
           </p>
            <!-- //버튼 영역 -->
            
          <!-- //게시판 목록 영역 -->
   
        
      </div>
         <div class="list_number" style="margin-left: 90px;">
             <div>
                 <p><div class="list_n_menu"><span class="disabled"></span><span class="current">1</span><a href="#?page=2">2</a><a href="#?page=3">3</a><a href="#?page=4">4</a><a href="#?page=5">5</a><a href="#?page=6">6</a><a href="#?page=7">7</a>...<a href="#?page=199">30</a><a href="#?page=200">31</a><a href="#?page=2">다음  ></a></div></p>
             </div>
         </div>
       
       </aside>
    </section>
    
    <jsp:include page="../user/user_footer.jsp"/>

</body>
</html>