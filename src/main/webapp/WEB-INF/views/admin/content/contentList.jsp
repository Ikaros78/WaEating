<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 관리</title>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/admin/style.css">
    <!-- 합쳐지고 최소화된 최신 CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

    <!-- 부가적인 테마 -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

    <!-- 합쳐지고 최소화된 최신 자바스크립트 -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    <script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<div id="wrap">
        <jsp:include page ="../common/menubar.jsp"/>

        <div id="body">
            <div class="col-md-2">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>게시글 관리</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                                <ul class="nav nav-stacked">
                                    <li role="presentation"><a href="adminContentControl.html">게시글 조회</a></li>
                                    <li role="presentation"><a href="adminReviewControl.html">리뷰글 조회</a></li>
                                </ul>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div class="col-md-9">
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>Numbering</th>
                        <th>PK</th>
                        <th>여기에 뭐넣지</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>1</td>
                        <td>Doe</td>
                        <td>john@example.com</td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>Moe</td>
                        <td>mary@example.com</td>
                    </tr>
                    <tr>
                        <td>3</td>
                        <td>Dooley</td>
                        <td>july@example.com</td>
                    </tr>
                    <tr>
                        <td>4</td>
                        <td>Dooley</td>
                        <td>july@example.com</td>
                    </tr>
                    <tr>
                        <td>5</td>
                        <td>Dooley</td>
                        <td>july@example.com</td>
                    </tr>
                    <tr>
                        <td>6</td>
                        <td>Dooley</td>
                        <td>july@example.com</td>
                    </tr>
                    <tr>
                        <td>7</td>
                        <td>Dooley</td>
                        <td>july@example.com</td>
                    </tr>
                    <tr>
                        <td>8</td>
                        <td>Dooley</td>
                        <td>july@example.com</td>
                    </tr>
                    <tr>
                        <td>9</td>
                        <td>Dooley</td>
                        <td>july@example.com</td>
                    </tr>
                    <tr>
                        <td>10</td>
                        <td>Dooley</td>
                        <td>july@example.com</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>

        <div id="searchContainer">
            <div class="row">
                <div class="col-md-offset-7 col-md-4" align="right">
                        <select class="form-select" id="option">
                            <option value="이름">이름</option>
                            <option value="나이">나이</option>
                            <option value="휴대폰">휴대폰</option>
                            <option value="아이디">아이디</option>
                            <option value="옵션5">옵션5</option>
                        </select>
                        <input type="text">
                        <input type="submit" value="검색">
                </div>
            </div>
        </div>
        
        <div id="container">
            <div class="col-md-offset-2 col-md-7">
                <ul class="pagination">
                    <li><a href="#">1</a></li>
                    <li class="active"><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                  </ul>
            </div>
        </div>

        
    </div>
</body>
</html>