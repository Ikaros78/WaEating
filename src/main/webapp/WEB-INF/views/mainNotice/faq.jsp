<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>자주 묻는 질문</title>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/notice/faq.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/ceo/common/ceo_header.jsp"/>
<body>
   <body>
            <h1>자주 묻는 질문</h1>
            <div class="layout">
                <ul class="qna">
                    <li>
                        <input type="checkbox" id="qna-1">
                        <label for="qna-1">수수료 책정 질문</label>
                        <div>
                            <p>준비중 입니다</p>
                        </div>
                    </li>
                    <li>
                        <input type="checkbox" id="qna-2">
                        <label for="qna-2">매장 정보를 변경하고 싶어요</label>
                        <div>
                            <p>마이페이지에서 변경 가능합니다</p>
                            
                        </div>
                    </li>
                    <li>
                        <input type="checkbox" id="qna-3">
                        <label for="qna-3">질문3</label>
                        <div>
                            <p>질문 -> 생각하는것도.</p>
                            <p>어렵다.</p>
                        </div>
                    </li>
                    <li>
                        <input type="checkbox" id="qna-4">
                        <label for="qna-4">매장 노출 순서는 어떤 순서인가요?</label>
                        <div>
                            <p>고객들의 리뷰 및 조회 순서등을 기반으로 노출되며, 신규 매장일 경우 일정기간 동안 상단에 노출되게 됩니다</p>
                        </div>
                    </li>
                    <li>
                        <input type="checkbox" id="qna-5">
                        <label for="qna-5">질문5</label>
                        <div>
                            <p>1.</p>
                            <p>2</p>
                            <p>3</p>
                            <p>4</p>
                            <p>5</p>
                        </div>
                    </li>
                </ul>
            </div>
        </body>
       
         <jsp:include page="/WEB-INF/views/ceo/common/ceo_footer.jsp"/> 

 
   
</body>
</html>