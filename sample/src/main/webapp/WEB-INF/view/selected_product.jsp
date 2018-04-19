<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">
		<div class="row">
			<div class="list-group">
				<div class="media col-md-4">
					<img alt="" src="resources/images/${selectedProduct.id}.PNG">
				</div>
				<div class="col-md-6">
					<table class="table">
						<tr>
							<td>Product Name:</td>
							<td>${selectedProduct.name}</td>
						</tr>
						<tr>
							<td>Price:</td>
							<td>${selectedProduct.price}</td>
						</tr>
						<tr>
							<td>Description</td>
							<td>${selectedProduct.description}</td>

						</tr>
						<tr>
						<td></td>
							<td><a href="cart/add/${selectedProduct.id}"><button>Add to Cart</button></a></td></tr>
					</table>
				</div>
			</div>
		</div>
	</div>
	<br>
	<br>
	<br>
</body>
</html>