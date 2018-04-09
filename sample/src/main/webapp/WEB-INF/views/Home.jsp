<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home page of Shopping Kart</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}
.carousel-inner > .item > img, .carousel-inner > .item > a > img {
    width: 100%;
    margin: auto;
  }
</style>
</head>

<body>
	<center>
		<h1>Welcome to Shopping Cart</h1>
		${logoutmessage }	${success} 
	</center>
	<br>
	
	<jsp:include page="login_header.jsp"></jsp:include>
	<jsp:include page="bootstrap_product_menu.jsp"></jsp:include>
	<hr color="blue" size="4">


	<c:if test="${isAdmin== true}">
		<jsp:include page="admin/adminhome.jsp"></jsp:include>
	</c:if>

	<c:if test="${sinceUserClickedSignIn== true}">
		<jsp:include page="SignIn.jsp"></jsp:include>
	</c:if>

	<c:if test="${sinceUserClickedSignUp== true}">
		<jsp:include page="SignUp.jsp"></jsp:include>
	</c:if>
	
	
	<c:if test="${sinceUserClickedMyCart== true}">
	<jsp:include page="Cart.jsp"></jsp:include>
	</c:if>
	
	<c:if test="${isUserSelectedProduct}">
	<jsp:include page="selected_product.jsp"></jsp:include>
	</c:if>
	
	<br> ${fail}
	
	
	
	<div class="container">
  <br>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">

      <div class="item active">
        <img src="resources\images\ShoppingCartImages\offerontoys.jpg" alt="Offer on toys" width="100" height="100">
      </div>

      
  
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>
</body>
</html>