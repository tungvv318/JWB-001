<!DOCTYPE>
<html>

<head>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
	<link rel="stylesheet" href='<c:url value="/css/bootstrap.css"/>' />
	<script type="text/javascript" src="<c:url value="/js/jquery.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/bootstrap.js"/>"></script> 
</head>

<body style="padding : 2rem ; " class="bg-info">

	<div class="container bg-info " style="width : 40% ; padding : 1.5rem ; ">  
	<h1 class="container" style="text-align: center ; color:white; " > User's Information</h1>
	<ul class="list-group" style="margin : 1rem ; ">
		<li class="list-group-item" style="font-size : 1rem"> Name : ${name} </li>
		<li class="list-group-item"> Email : ${email} </li>
		<li class="list-group-item"> Phone : ${phone} </li>
		<li class="list-group-item"> Balance : ${balance} </li>
	</ul>
	<a href="/transfer" class="btn btn-primary" style="width : 100% ; "> Transfer Money  </a>
	</div>
	
</body>

</html>