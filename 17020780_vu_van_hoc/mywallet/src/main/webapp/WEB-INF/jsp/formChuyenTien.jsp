<%@ page import="com.uetcodecamp.vuvanhoc.objects.User" %>
<%@ page import="java.util.HashMap" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>My Wallet - Giao dịch </title>
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
	<%
		int key = (int) request.getAttribute("key");
	%>
	<form action="/xu-li-giao-dich/<%=key%>" method="post" >
		<label>CHUYỂN TIỀN</label><br><br>
		ID người nhận:<br>
		<input type="number" placeholder="ID người nhận " required name="id"><br>
		Số tiền :<br>
		<input type="number" placeholder="Số tiền " required name="amount"><br>
		<input type="submit" value="Giao dịch ">
	</form>

</div>
</body>
</html>