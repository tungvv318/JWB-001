<!DOCTYPE>
<html>
	
<head>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
	<link rel="stylesheet" href='<c:url value="/css/bootstrap.css"/>' />
	<script type="text/javascript" src="<c:url value="/js/jquery.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/bootstrap.js"/>"></script> 
</head>
	
<body style="padding : 2rem; " class="bg-info"> 
	<h1 class="container" style="text-align : center ;color : white ; padding : 2rem;  "> Add User </h1>
	
	<form method="post" action="add" class="container bg-info" style="width : 25% ; padding : 2rem ; border: 1px white solid ; border-radius: 25px ; ">
	
		 <div class="form-group">
		 <label for="name-input" style="color : white ; "> Name : </label> 
	 	 <input type="text" class="form-control" id="name-input" name="user" placeholder="Enter Name"/>
	 	 </div>
	 	 	
	 	 <div class="form-group">
	 	 <label for="email-input" style="color : white ; "> Email address : </label> 
	 	 <input type="email" class="form-control" name="email" placeholder="Enter email"/>
	 	 </div>
	 	  
	 	 <div class="form-group">	 	 
	 	 <label for="phone-input" style="color : white ; "> Phone :  </label> 
	 	 <input type="text" id ="phone-input" class="form-control" name="phone" placeholder="Enter phone"/>
	 	 </div>
	 	 
	 	 <div class="form-group"> 
	 	 <label for="balance-input" style="color : white ; "> Balance :  </label> 
	 	 <input type="text" id="balance-input" class="form-control" name="balance" placeholder="Enter Balance"/>
	 	 </div>
	 	  
		<button type="submit" class="btn btn-outline-light" style="width : 100% ; "> Add </button>
	</form>
</body>

</html>