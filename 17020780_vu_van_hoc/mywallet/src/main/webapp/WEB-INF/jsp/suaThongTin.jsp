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
<link href="webjars/bootstrap/3.4.1/css/bootstrap.min.css"
      rel="stylesheet">
</head>
<body>
<div class="page-header">
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
	<form action="/xu-li-form-sua-thong-tin/<%=key%>" method="post" >
		<label style="color: #112386">CHỈNH SỬA THÔNG TIN NGƯỜI DÙNG</label><br>
		<label for="name">Họ tên:</label>
		<input type="text" name="name" id="name" placeholder="Enter name" required
			value="<%=results.get(key).getName()%>"><br/>
		<label for="email">Email:</label>
		<input type="email" name="email" id="email" placeholder="Enter email" required
			value="<%=results.get(key).getEmail()%>"><br/>
		<label for="phone">Phone:</label>
		<input type="tel" name="phone" id="phone" placeholder="Enter phone" required
			value="<%=results.get(key).getPhone()%>"><br/>
		<label for="balance">Số dư:</label>
		<input type="number" name="balance" id="balance" placeholder="Enter balance" required
			value="<%=results.get(key).getBalance()%>"><br/>
		<input type="submit" value="Cập nhật" id="btn_submit">
	</form>
	<script src="webjars/jquery/2.1.4/jquery.min.js"></script>
	<script>
		$(function () {
			$("#btn_submit").click(function () {
				alert("Bạn đã cập nhật thành công !");
            })
        })
	</script>
</div>
</body>
</html>