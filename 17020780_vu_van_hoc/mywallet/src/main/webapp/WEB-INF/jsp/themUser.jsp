<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>My Wallet - Đăng ký tài khoản </title>
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
	<form action="/them-nguoi-dung" method="post" >
		<label>Đăng ký tài khoản mới </label><br>
		<input type="text" name="name" placeholder="Enter name" required><br/>
		<input type="email" name="email"placeholder="Enter email" required><br/>
		<input type="tel" name="phone" placeholder="Enter phone" required><br/>
		<input type="number" name="balance"placeholder="Enter balance" required><br/>
		<input type="submit" value="Đăng ký ">
	</form>

</div>
</body>
</html>