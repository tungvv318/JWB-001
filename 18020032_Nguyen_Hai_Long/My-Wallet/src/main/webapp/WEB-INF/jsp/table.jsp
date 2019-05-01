<!DOCTYPE>

<html> 

<head> 
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
	<%@ page import="java.util.List" %>
	<%@ page import="com.anonyhostvn.model.InfoPattern" %>
	<link rel="stylesheet" href='<c:url value="/css/bootstrap.css"/>' />
	<script type="text/javascript" src="<c:url value="/js/jquery.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/bootstrap.js"/>"></script> 
</head>

<body class="bg-info" style="padding : 2rem ; ">
	<div class="container"> 
	<h1 style="text-align: center; color : white ; "> ${message}   </h1>
	</div> 
	
	<div class="container" style="color : white ; "> 
	<table class="table table-hover" style="color : white ; ">
		<thead> 
		<tr>
			<td scope="col"> ID </td>
			<td scope="col"> Name </td>
			<td scope="col"> Email </td>
			<td scope="col"> Phone </td>
			<td scope="col" colspan="2"> Balance </td>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${container}">
			<tr>
				<td> ${item.getID()} </td>
				<td> ${item.getName()} </td>
				<td> ${item.getEmail() } </td>
				<td> ${item.getPhone() } </td>
				<td scope="col"> ${item.getBalance() } </td>
				<td scope="col"> <a style="color : white ; "href="#"> Edit </a> </td> 
			</tr>
		</c:forEach>
		</tbody>
	</table>
		
	<a href="/page1/add" class="btn btn-outline-light"> Add </a>
	
	</div>	
	
</body>

</html>