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
</head>

<body>
	<h3>
		<a href="managecategories">Manage categories</a> 
		<a href="managesuppliers">Manage suppliers</a> 
		<a href="manageproducts">Manage products</a>
	</h3>

	<c:if test="${isadminClickCategories== true}">
		<jsp:include page="category.jsp"></jsp:include>
	</c:if>

	<c:if test="${isadminClickSuppliers== true}">
		<jsp:include page="supplier.jsp"></jsp:include>
	</c:if>

	<c:if test="${isadminClickProducts== true}">
		<jsp:include page="product.jsp"></jsp:include>
	</c:if>
</body>
</html>