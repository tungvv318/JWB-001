<!DOCTYPE> 

<html>

<head>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<link rel="stylesheet" href='<c:url value="/css/bootstrap.css"/>' />
	<script type="text/javascript" src="<c:url value="/js/jquery.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/bootstrap.js"/>"></script> 
</head>

<body style="padding : 2rem ; " class="bg-info">

<h1 class="container" style="text-align: center ; height : 20% ; padding : 2rem ; color : white ;  "> Login </h1>

<form method="post" style="border : 1px white solid ; border-radius : 25px ; width : 25% ; padding: 2rem ; "  class="container bg-info" action="login" >
	<div class="form-group"> 
	<label style="color : white ; "> Email : </label>
	<input type="text" class="form-control" placeholder="Enter Email" name="email"/> <br>
	</div>
	
	<div class="form-group"> 
	<label style="color : white ; "> Password : </label>
	<input type="password" class="form-control" placeholder="Enter Password" name="pass"/> <br>
	</div>
	
	<button class="btn btn-outline-light" type="submit" style="width : 100% ; "> Login </button>
</form>

</body>
 
</html>