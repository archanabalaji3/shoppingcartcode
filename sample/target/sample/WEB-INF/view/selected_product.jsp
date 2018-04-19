<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<img alt="" src="${selectedProductImage}"> <br>
<img alt="" src="resources/images/${selectedProduct.id}.PNG">
product name: ${selectedProduct.name} <br>
price : ${selectedProduct.price} <br>
Description : ${selectedProduct.description} <br>
<a href="cart/add/${selectedProduct.id}">Add to Cart</a><br>

</body>
</html>