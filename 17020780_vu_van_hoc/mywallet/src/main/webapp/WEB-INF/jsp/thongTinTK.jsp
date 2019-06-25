<%@ page import="com.uetcodecamp.vuvanhoc.objects.User" %>
<%@ page import="java.util.HashMap" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>My Wallet - Thông tin tài khoản </title>
<spring:url value="/resources/css/main.css" var="mainCss"/>
<link href="${mainCss}" rel="stylesheet"/>
<link href="webjars/bootstrap/3.4.1/css/bootstrap.min.css"
      rel="stylesheet">
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
		HashMap<Integer, User> results = (HashMap<Integer, User>) request.getAttribute("items");
		int key = (int) request.getAttribute("key");
	%>
	<form action="/giao-dich/<%=key%>" method="post" >
		<label>Thông tin tài khoản</label><br><br>
		ID: <%=results.get(key).getId()%><br><br>
		Tên: <%=results.get(key).getName()%><br><br>
		Email: <%=results.get(key).getEmail()%><br><br>
		Phone: <%=results.get(key).getPhone()%><br><br>
		Số dư khả dụng: <%=results.get(key).getBalance()%> VNĐ<br><br>
		<input type="submit" value="Chuyển tiền ">
	</form>

</div>
</body>
</html>