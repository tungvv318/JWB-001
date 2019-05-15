<!DOCTYPE>

<html> 

<head> 
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
	<%@ page import="java.util.List" %>
	<%@ page import="com.uetcodecamp.model.UserInfo" %>
	<link rel="stylesheet" href='<c:url value="/css/bootstrap.css"/>' />
	<script type="text/javascript" src="<c:url value="/js/jquery.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/bootstrap.js"/>"></script> 
</head>

<body class="bg-info" style="padding : 2rem ; ">
	<h1 style="color : white ; text-align: center ;"> ${message}   </h1> 
	
	<form onsubmit="return false ;" id = "search-engine" class="container" style="padding : 1rem ; display : flex ; flex-direction : row ;  "> 
		<input id="search-text" class="form-control" placeholder="Search name..."type="text" style="width : 50vh ; margin-right : 1rem ;  " />
		<button type="submit" class="btn btn-outline-primary" style="color : white ; border-radius: 25px ; ">  Search </button>
	</form>
	
	<script>
		$(document).ready (function () {
			$("#search-engine").submit(function () { 
				data = $("#search-text").val() ;
				$(".name-col").each(function () {
					if (!($(this).text()).trim().includes(data.trim())) {
						$(this).parents("tr").hide("slow",function() {
							$(this).remove() ; 
						}) ; 
					}; 
				}) ; 
			}) ; 
		}) ; 
 	</script>
	
	<div class="container" style="color : white ; "> 
	<table class="table table-hover" style="color : white ; ">
		<thead> 
		<tr style="font-size : 1.3vw ; ">
			<td scope="col"> ID </td>
			<td scope="col"> Name </td>
			<td scope="col"> Email </td>
			<td scope="col"> Phone </td>
			<td scope="col"> Balance </td>
			<td scope="col" colspan="2"> Action </td>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${container}">
			<tr id="row-${item.getID() }" style="font-size : 1.2vw ; ">
				<td> ${item.getID()} </td>
				<td class="name-col"> ${item.getName()} </td>
				<td> ${item.getEmail() } </td>
				<td> ${item.getPhone() } </td>
				<td scope="col"> ${item.getBalance() } </td>
				<td scope="col"> 
					<button id="edit-user" class="btn btn-outline-primary" onclick="Edit( ${item.getID()} )" style="color : white ; font-size : 1.2vw"> Edit </button> 
				</td> 
				<td scope="col"> 
					<button style="font-size : 1.2vw ;color : white ; " class="btn btn-outline-primary"  onclick="Delete(${item.getID()})"> Delete user </button> 
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
		
	<a href="/recent/add" class="btn btn-outline-light"> Add </a>
	
	</div>
	
	<script type="text/javascript">
	
		var url = "/delete" ;	
		
		function Edit(id) {
			var urlEdit = "/edit" ; 
			
			var data = {
				ID : id
			}	
			
			$.get(urlEdit , data , function(data , status) {
				console.log(data) ;
				if (data != "Failed") {
					alert("Start editing!") ;
					window.location.assign("/edit?ID=" + id.toString()) ;
				}
				else alert("You can not edit this user, please login to edit") ;
			}) ; 
		}
		
		function Delete(id) {
			if (!confirm("Do you want to delete ?")) return ;
			
			var data = {
				ID : id
			}
			
			$.post(url , data , function (data , status) {
				console.log(data) ;
				if (data == "success") {
					$("table tbody").find("#row-" + id).hide("slow" , function() {
						$(this).remove() ;
					}) ; 
				} 
			}) ;
		} 
	</script>
			
</body>

</html>