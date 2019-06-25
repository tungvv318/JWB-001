<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>My Wallet - Đăng nhập </title>
<spring:url value="/resources/css/main.css" var="mainCss"/>
<link href="${mainCss}" rel="stylesheet"/>
<link href="webjars/bootstrap/3.4.1/css/bootstrap.min.css"
      rel="stylesheet">
</head>
<body>
<div class="page-header">
	<h1>MY WALLET</h1>
	<ul>
		<li><a href="/">Trang chủ</a></li>
	</ul>
</div>

<div class="form">
	<form action="/xu-li-dang-nhap" method="post" class="form-group" >
		<label style="color: #112386">ĐĂNG NHẬP</label><br><br>
		<label for="email">Email:</label>
		<input type="email" name="email"placeholder="Enter email" id="email" required><br/>
		<label for="password">Password:</label>
		<input type="password" name="password" placeholder="Enter password" id="password" required><br>
		<input type="submit" value="Đăng nhập"><br>
		Bạn chưa có tài khoản? <a href="/them-nguoi-dung">Đăng kí ngay </a>
	</form>

</div>
</body>
</html>