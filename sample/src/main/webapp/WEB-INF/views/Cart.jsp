<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Cart</title>
</head>

<body>
	<c:forEach var="a" items="${cartList}">
	
	<img alt="" src="${ImagesFolder}${a.productId}.png">
	<img alt="" src="resources/images/ShoppingCartImages/${a.productID}.png">
	
	Name: <input type="text" name="productName" value="${a.productName}"><br>
	Price: <input type="text" name="price" value="${a.price}"><br>
	Quantity: <input type="text" name="quantity" value="${a.quantity}"><br>
	
	</c:forEach>
</body>
</html>