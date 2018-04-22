<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>

</head>
<body>


	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
	 <img src="resources/images/log.png" alt="website logo" style=";"> 
			<br>
		<ul class="nav navbar-nav navbar-left">
			<li><a href="login"><span class="glyphicon glyphicon-log-in"></span>
					Login</a></li>
			<c:if test="${isLoggedIn==true}">
				<li><a href="logout"><span
						class="glyphicon glyphicon-log-out"></span> Logout</a></li>
			</c:if>
		</ul>

		<ul class="nav navbar-nav navbar-right">
			<li><a href="registration"><span
					class="glyphicon glyphicon-user"></span> Sign Up</a></li>
			<c:if test="${isLoggedIn==true}">
				<li><a href="mycart"><span
						class="glyphicon glyphicon-shopping-cart"></span>
						MyCart(${cartSize})</a></li>
			</c:if>
		</ul>


	</div>
	</nav>
	${welcomeMessage}
</body>
</html> --%>


<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="h">Shopping fest</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="home"></a></li>
      <c:forEach items="${categories}" var="category">
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">${category.name}<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <c:forEach items="${category.products}" var="product">
<li><a href="product/get/${product.id}">${product.name}</a></li>
 </c:forEach>
        </ul></c:forEach>
      </li>
      
    </ul>
    <ul class="nav navbar-nav navbar-right">
    <li><a href="aboutus">AboutUs</a></li>
	<li><a href="contactus">ContactUs</a></li>
    <c:choose><c:when test="${isLoggedIn==true}">
				<li><a href="mycart"><span
						class="glyphicon glyphicon-shopping-cart"></span>
						MyCart(${cartSize})</a></li>

				<li><a href="logout"><span
						class="glyphicon glyphicon-log-out"></span> Logout</a></li>
						</c:when><c:otherwise>
			<li><a href="registration"><span
					class="glyphicon glyphicon-user"></span> Sign Up</a></li>
					<li><a href="login"><span class="glyphicon glyphicon-log-in"></span>
					Login</a></li></c:otherwise></c:choose>
    </ul>
  </div>
</nav>
  
${welcomeMessage}

</body>
</html>
