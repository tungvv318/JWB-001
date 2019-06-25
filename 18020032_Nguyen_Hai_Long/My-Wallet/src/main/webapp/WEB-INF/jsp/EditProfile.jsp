<!DOCTYPE> 

<html>
	<head>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
		<link rel="stylesheet" href='<c:url value="/css/bootstrap.css"/>' />
		<script type="text/javascript" src="<c:url value="/js/jquery.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/js/bootstrap.js"/>"></script> 
	</head>
	
	<body  class="bg-info" style="padding : 2rem ; ">
		<h1 class="container" style="text-align: center ; color : white ; padding : 1rem ; " > Edit User ${name} </h1>
		
		<form method="post" action="edit" class="container" style="width : 30% ; border : 1px white solid; border-radius : 25px ; padding : 2rem ;  ">
			
			<div class="form-group">
				<label style="color : white ; "> ID : </label>
				<input type="text" class="form-control" value="${ID }" name="ID" readonly/> 
			</div>
		
			 <div class="form-group">
		 		<label for="name-input" style="color : white ; "> Name : </label> 
	 	 		<input type="text" class="form-control" id="name-input" value="${name }" name="name" placeholder="Enter Name"/>
	 	 	</div>
	 	 	
	 	 	<div class="form-group">
	 	 		<label for="email-input" style="color : white ; "> Email address : </label> 
	 	 		<input type="email" class="form-control" value="${email }" name="email" placeholder="Enter email"/>
	 	 	</div>
	 	  
	 	 	<div class="form-group">	 	 
	 	 		<label for="phone-input" style="color : white ; "> Phone :  </label> 
	 	 		<input type="text" id ="phone-input" value="${phone } "class="form-control" name="phone" placeholder="Enter phone"/>
	 	 	</div>
	 	 
	 	 	<div class="form-group"> 
	 	 		<label for="balance-input" style="color : white ; "> Balance :  </label> 
	 	 		<input type="text" id="balance-input" value="${balance }" class="form-control" name="balance" placeholder="Enter Balance"/>
	 	 	</div>
	 	  
			<button type="submit" class="btn btn-outline-light" style="width : 100% ; "> Save </button>
		</form>
	</body>
</html>