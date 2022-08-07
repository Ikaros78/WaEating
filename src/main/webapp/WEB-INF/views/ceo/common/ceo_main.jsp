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
	<jsp:include page="ceo_header.jsp"/>
	<div id="wrap">
	<!-- <section style="min-height : 860px">
		컨텐츠
	</section> -->
	<img src="${ pageContext.servletContext.contextPath }/resources/images/ceo/ceomain.png" alt="ceomain" width="100%"> 
	<jsp:include page="ceo_footer.jsp"/>
  	</div>
</body>
</html>