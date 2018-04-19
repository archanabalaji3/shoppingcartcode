<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Manage Product</title>
</head>
<body>
	${productSuccessMessage} ${productErrorMessage} ${uploadMessage}
	<!-- create 3 text fields -->
	<div class="container">
		<form action="product/save/" method="post"
			enctype="multipart/form-data">
			<table class="table table-bordered">
				<tr>
					<td>PRODUCT ID</td>
					<td><input style="width:100%;border:0;" type="text" name='id' value="${selectedProduct.id}"></td>

				</tr>

				<tr>
					<td>PRODUCT NAME</td>

					<td><input style="width:100%;border:0;" type="text" name='name'
						value="${selectedProduct.name}"></td>

				</tr>
				<tr>
					<td>PRODUCT DESCRIPTION</td>

					<td><input style="width:100%;border:0;"type="text" name='description'
						value="${selectedProduct.description}"></td>
				</tr>
				<tr>
					<td>PRODUCT PRICE</td>
					<td><input style="width:100%;border:0;"type="text" name="price"
						value= "${selectedProduct.price}">
				</tr>
				
				<tr>
					<td>SELECT CATEGORY</td>
					<td><select style="width:100%;border:0;"name="categoryID">
							<c:forEach var="category" items="${categories}">
								<option value="${category.id}">${category.name}</option>
							</c:forEach>
					</select></td>
				</tr>
				
				<tr>
					<td>PRODUCT IMAGE</td>
					<td><input type="file" name="file"></td>

				</tr>
				<tr>
					<td>SELECT SUPPLIER</td>
					<td><select style="width:100%;border:0;" name="supplierID">
							<c:forEach var="supplier" items="${suppliers}">
								<option value="${supplier.id}">${supplier.name}</option>
							</c:forEach>
					</select></td>
				</tr>
			</table>
			 <tr>
        <td></td>
        <td><button type="submit" class="btn btn-primary">SAVE/UPDATE</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button type="reset" class="btn btn-warning">CLEAR</button></td>
      </tr>
		</form>
	</div>
	<br>
	<br>
	<!--  display all the categories -->
	<div class="container">
		<table class="table table-bordered" style="text-align:center;" border="3px" >
			<tr>
			<td bgcolor="DarkSalmon"><b>PRODUCT ID</b></td>
			<td bgcolor="DarkSalmon" style="width:20%;"><b>PRODUCT NAME</b></td>
			<td bgcolor="DarkSalmon" style="width:30%;"><b>PRODUCT DESCRIPTION</b></td>
			<td bgcolor="DarkSalmon"><b>PRICE</b></td>
			<td bgcolor="DarkSalmon" style="width:20%;"><b>ACTION</b></td>
			<!-- 
				<td>Product ID</td>
				<td>Product Name</td>
				<td>Product Description</td>
				<td>Price</td>
				<td>Action</td> -->
			</tr>
			<c:forEach var="product" items="${products}">
				<tr>
					<td>${product.id}</td>
					<td>${product.name}</td>
					<td>${product.description}</td>
					<td>${product.price} Rupees </td>
					<td><a href="product/delete/?id=${product.id}"><button type="button"  class="btn btn-danger" >Delete</button>
					<a href="product/edit/?id=${product.id}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button type="button" class="btn btn-info">Edit</button></a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>