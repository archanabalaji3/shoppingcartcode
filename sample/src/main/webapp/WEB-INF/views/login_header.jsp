<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
  <title>Navigation Bar</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body style="height:1500px">
	<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <ul class="nav navbar-nav navbar-right">
	      <c:if test= "${ifLoggedIn==true}">
		      <li><a href="home">Home</a></li>
		      <li><a href="signout"><span class="glyphicon glyphicon-log-out"></span> Log out</a></li>
		      <li><a href="mycart"><span class="glyphicon glyphicon-shopping-cart"></span> My Cart(${size })</a></li>
	      </c:if>
	    </ul>
	    
	    <ul class="nav navbar-nav navbar-left">
	      <li><a href="signin"><span class="glyphicon glyphicon-log-in"></span> Log in</a></li>
	      <li><a href="signup"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li> 
	    </ul>
	  </div>
	</nav>
	
<!-- 	<nav class="navbar navbar-inverse navbar-fixed-top"> -->
<!--   <div class="container-fluid"> -->
<!--     <div class="navbar-header"> -->
<!--       <a class="navbar-brand" href="#">Shopping Kart</a> -->
<!--     </div> -->
<!--     <ul class="nav navbar-nav"> -->
<!--       <li class="active"><a href="home">Home</a></li> -->
<!--       <li><a href="#">Page 1</a></li> -->
<!--       <li><a href="#">Page 2</a></li> -->
<!--     </ul> -->
<!--     <button class="btn btn-danger navbar-btn">Home</button> -->
<!--     <form class="navbar-form navbar-left" action="/action_page.php"> -->
<!--       <div class="input-group"> -->
<!--         <input type="text" class="form-control" placeholder="Search" name="search"> -->
<!--         <div class="input-group-btn"> -->
<!--           <button class="btn btn-default" type="submit"> -->
<!--             <i class="glyphicon glyphicon-search"></i> -->
<!--           </button> -->
<!--         </div> -->
<!--       </div> -->
<!--     </form> -->
<!--   </div> -->
<!-- </nav> -->

</body>
</html>