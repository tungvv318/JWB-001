<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>My Wallet - Đăng ký tài khoản </title>
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
	<form action="/them-nguoi-dung" method="post" >
		<label style="color: #112386">ĐĂNG KÝ TÀI KHOẢN MỚI</label><br><br>
		<label for="name">Họ và tên</label>
		<input type="text" name="name" placeholder="Enter name" id="name" required><br/>
		<label for="email">Email</label>
		<input type="email" name="email"placeholder="Enter email" id="email" required><br/>
		<label for="phone">Số điện thoại </label>
		<input type="tel" name="phone" placeholder="Enter phone"id="phone" required><br/>
		<label for="balance">Số dư</label>
		<input type="number" name="balance"placeholder="Enter balance"id="balance" required><br/>
		<input type="submit" value="Đăng ký ">
	</form>

</div>
</body>
</html>