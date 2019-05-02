<%@ page import="com.uetcodecamp.vuvanhoc.objects.User" %>
<%@ page import="java.util.HashMap" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>My Wallet - Trang chủ </title>
<spring:url value="/resources/css/main.css" var="mainCss"/>
<link href="${mainCss}" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<div class="header">
	<h1>MY WALLET</h1>
	<ul>
		<li><a href="/">Trang chủ </a></li>
		<li><a href="/dang-nhap">Đăng nhập </a></li>
		<li><a href="/them-nguoi-dung">Đăng ký</a></li>
	</ul>
</div>

<div class="home">
	<h3>Danh sách người dùng </h3>
		<div class="search-container">
			<form action="/" class="search">
				<input type="text" placeholder="Search.." name="search">
				<input type="submit" value="Tìm kiếm " style="width: auto" >
			</form>
		</div>
	<table id="customers">
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Email</th>
				<th>Phone</th>
				<th>Balance</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
		
			<%
				HashMap<Integer, User> results = (HashMap<Integer, User>) request.getAttribute("items");
				for(int key : results.keySet()) {
			%>
			<tr>
				<td style="text-align: center"><%=results.get(key).getId()%>
				</td>
				<td><%=results.get(key).getName()%>
				</td>
				<td><%=results.get(key).getEmail()%>
				</td>
				<td><%=results.get(key).getPhone()%>
				</td>
				<td style="text-align: right"><%=results.get(key).getBalance()%>
				</td>
				<td><a href="/sua-thong-tin/<%=results.get(key).getId()%>">Edit</a>
					<button type="button" class="btn btn-danger">Xóa </button>
				</td>
			</tr>
			<%
				}
			%>
			
		</tbody>
	</table>
</div>


</body>
</html>