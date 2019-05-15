<!DOCTYPE>

<html>
	
<head>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
	<link rel="stylesheet" href='<c:url value="/css/bootstrap.css"/>' />
	<script type="text/javascript" src="<c:url value="/js/jquery.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/bootstrap.js"/>"></script> 
</head>

<body style="padding : 2rem ; " class="bg-info">
	<div class="container bg-info rounded" style="width : 30% ; padding: 2rem ; "> 
	<h1 class="container" style="text-align : center ; color : white ; " > Transfer Money </h1>
	<form style="border : 1px white solid ; border-radius: 25px ; padding : 2rem ; " action="transfer" method="post">
		<div class="form-group"> 
			<label style="color : white ; "> ID : </label>
			<input class="form-control"type="text" name="ID" placeholder="Transfer to ? "> <br>
		</div>
		<div class="form-group"> 
		<label style="color : white ; "> Money : </label>
		<input class="form-control" type="text" name="money" placeholder="How many ? "> <br>
		</div> 
		<button class="btn btn-primary" style="width : 100% ; "type="submit"> Submit </button>
	</form>
	</div>
</body>

</html>