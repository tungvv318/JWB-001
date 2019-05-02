<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>My Wallet - Đăng nhập </title>
<spring:url value="/resources/css/main.css" var="mainCss"/>
<link href="${mainCss}" rel="stylesheet"/>
</head>
<body>
<div class="header">
	<h1>MY WALLET</h1>
	<ul>
		<li><a href="/">Trang chủ</a></li>
	</ul>
</div>

<div class="form">
	<form action="/xu-li-dang-nhap" method="post" >
		<label>Đăng nhập </label><br>
		<input type="email" name="email"placeholder="Enter email" required><br/>
		<input type="password" name="password" placeholder="Enter password" required><br>
		<input type="submit" value="Đăng nhập"><br>
		Bạn chưa có tài khoản? <a href="/them-nguoi-dung">Đăng kí ngay </a>
	</form>

</div>
</body>
</html>