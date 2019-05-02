<%@ page import="com.uetcodecamp.vuvanhoc.objects.User" %>
<%@ page import="java.util.HashMap" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>My Wallet - Sửa đổi thông tin người dùng </title>
<spring:url value="/resources/css/main.css" var="mainCss"/>
<link href="${mainCss}" rel="stylesheet"/>
</head>
<body>
<div class="header">
	<h1>MY WALLET</h1>
	<ul>
		<li><a href="/">Trang chủ </a></li>
	</ul>
</div>

<div class="form">
	<%
		HashMap<Integer, User> results = (HashMap<Integer, User>) request.getAttribute("items");
		int key = (int) request.getAttribute("key");
	%>
	<form action="/sua-thong-tin/<%=key%>" method="post" >
		<label>Chỉnh sửa thông tin người dùng</label>
		<input type="text" name="name" id="name" placeholder="Enter name" required
			value="<%=results.get(key).getName()%>"><br/>
		<input type="email" name="email" id="email" placeholder="Enter email" required
			value="<%=results.get(key).getEmail()%>"><br/>
		<input type="tel" name="phone" id="phone" placeholder="Enter phone" required
			value="<%=results.get(key).getPhone()%>"><br/>
		<input type="number" name="balance" id="balance" placeholder="Enter balance" required
			value="<%=results.get(key).getBalance()%>"><br/>
		<input type="submit" value="Cập nhật" >
	</form>
</div>
</body>
</html>