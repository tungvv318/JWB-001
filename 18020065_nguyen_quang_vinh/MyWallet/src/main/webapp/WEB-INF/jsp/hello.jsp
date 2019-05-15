<!DOCTYPE>

<html>
	<head>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<link rel="stylesheet" href='<c:url value="/css/bootstrap.css"/>' />
		<script type="text/javascript" src="<c:url value="/js/jquery.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/js/bootstrap.js"/>"></script> 
	</head>
	
<body class="bg-info">
	<div class="container" style="height : 25% ; "> </div>
	
	<div class="container"> 
		<h1 class="container" style="color : white ; text-align : center ; margin : 1rem ;  " > My Wallet app </h1>
		<div class="container" style="text-align: center ; margin : 1rem ; "> 
			<a class="btn btn-outline-light" href="/recent" style="text-align : center ; "> Show the recent accounts </a>
		</div> 
		<div class="container" style="text-align: center ; margin : 1rem ;"> 
			<a class="btn btn-outline-light" href="/login"> Login </a>
		</div>
	</div> 
</body>
</html>