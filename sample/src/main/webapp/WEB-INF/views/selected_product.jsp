<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products selected by me</title>
</head>

<body>
	<form action="cart/add" method="post">
	
		<img alt="" src="${selectedProductImage}"><br>
<%-- 		${selectedProduct.id} --%>
<%-- 		<img alt="" src="resources/images/ShoppingCartImages/${selectedProduct.id}.png"><br> --%>
		
		Product Name: <input type="text" name="productName" readonly="readonly" value=${selectedProduct.name}><br>
		Price: 		  <input type="text" name="price" 		disabled="disabled" value=${selectedProduct.price}><br>
<!-- 	Quantity: 	  <input type="text" name="quantity"><br> -->
		
<%-- 	<a href="cart/add?productName=${selectedproduct.name}&price=${selectedproduct.price}&quantity=1">Add To Cart</a> --%>
		<a href="product/cart/add?productID=${selectedProduct.product_id}">Add To Cart</a>
		
<!-- 	<input type="submit" value="Add To Cart"> -->
	</form>
</body>
</html>