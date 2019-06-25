<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>My Wallet </title>
<spring:url value="/resources/css/main.css" var="mainCss"/>
<link href="${mainCss}" rel="stylesheet"/>
<link href="webjars/bootstrap/3.4.1/css/bootstrap.min.css"
      rel="stylesheet">
</head>
<body>
<div class="page-header">
	<h1>MY WALLET</h1>
	<ul>
		<li><a href="/">Trang chủ </a></li>
		<li><a href="/dang-nhap">Đăng nhập </a></li>
	</ul>
</div>

<div>
	<h3>ID người nhận không tồn tại</h3>
</div>
</body>
</html>