<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Drop down of all items</title>
</head>

<body>
<!-- 	<div class="container"> -->
<!-- 		<ul class="nav nav-pills" role="tablist"> -->
<%-- 			<c:forEach items="${categories}" var="category"> --%>
<!-- 				<li class="dropdown"> -->
<!-- 					<a class="dropdown-toggle" data-toggle="dropdown" href="javascript:void(0)"> -->
<%-- 						<span class="caret"> ${category.name} </span> --%>
<!-- 					</a> -->
					
<!-- 					<ul class="dropdown-menu" role="menu"> -->
<%-- 						<c:forEach var="product" items="${category.products}"> --%>
<!-- 							<div class="dropdown-content"> -->
<!-- 								<li> -->
<%-- 									<a href="product/get/${product.product_id}">${product.name}</a> --%>
<!-- 								</li> -->
<!-- 							</div> -->
<%-- 						</c:forEach> --%>
<!-- 					</ul> -->
<!-- 				</li> -->
<%-- 			</c:forEach> --%>
<!-- 		</ul> -->
<!-- 	</div>    -->
	
	<div class="container">
		<c:forEach items="${categories}" var="category">
			<div class="dropdown col-md-1">
			    <button class="btn btn-default dropdown-toggle" type="button" id="menu1" data-toggle="dropdown">${category.name}
					<span class="caret"></span>
				</button>
					
				<ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
					<c:forEach var="product" items="${category.products}">
						<li><a href="product/get/${product.product_id}">${product.name}</a></li>
					</c:forEach>  
	   			</ul>
	   		</div>
  		</c:forEach>
	</div>

</body>
</html>