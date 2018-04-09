<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>
input[type=text], input[type=password] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}
</style>
</head>

<body>
	<div class="container">
		<form action="product/save/" method="post" enctype="multipart/form-data">
			<table class="table table-bordered">
				<c:if test="${!empty selectedProduct.product_id}">
					<input type="hidden" name='product_id' value="${selectedProduct.product_id}" />
				</c:if>
				<c:if test="${empty selectedProduct.product_id}">
					<tr>
						<td>ID</td>
						<td><input type="text" name='product_id' /></td>
					</tr>
				</c:if>

				<tr>
					<td>Name</td>
					<td><input type="text" name='name' value="${selectedProduct.name}" required></td>
				</tr>
	
				<tr>
					<td>Price</td>
					<td><input type="text" name='price' value="${selectedProduct.price}" required></td>
				</tr>
				
				
	
				<tr>
					<td>Select Category</td>
					<td>
						<select name="category_id">
							<c:forEach var="category" items="${categories}">
								<option value="${category.category_id }"> ${category.name} </option>
							</c:forEach>
						</select>
					</td>
				</tr>
				
				<tr>
					<td>Select Supplier</td>
					<td>
						<select name="supplier_id">
							<c:forEach var="supplier" items="${suppliers}">
								<option value="${supplier.supplier_id }"> ${supplier.name} </option>
							</c:forEach>
						</select>
					</td>
				</tr>
			</table>
			<input type="file" name="file">	<br>
			<input type="submit" value='Submit Product'><br><br>
		</form>
	</div>
	
	${productsuccess}
	${producterror}
	${uploadmsg}
	
	<div class="container">
		<table class="table table-striped table-bordered table-hover">
				<tr><h4>
					<td>Product ID</td>
					<td>Product Name</td>
					<td>Product Price</td>
					<td>Category ID</td>
					<td>Supplier ID</td>
					<td>Image</td>
					<td>Action</td>
					</h4>
				</tr>
				<c:forEach var="product" items="${products}">
					<tr>
						<td>${product.product_id} </td>
						<td>${product.name} </td>
						<td>${product.price} </td>
						<td>${product.cat_id} </td>
						<td>${product.sup_id} </td>
						<td><img src="resources/images/ShoppingCartImages/${product.product_id}.png" height="100px" width="75px"> </td>
						<td>
							<button type="button" class="btn btn-danger btn-sm">
								<a href="product/delete/?id=${product.product_id}">Delete</a> | 
							</button>
							<button type="button" class="btn btn-info btn-sm">
								<a href="product/edit/?id=${product.product_id}">Edit</a>
							</button>
						</td>
					</tr>
				</c:forEach>
		</table>
	</div>
</body>
</html>
