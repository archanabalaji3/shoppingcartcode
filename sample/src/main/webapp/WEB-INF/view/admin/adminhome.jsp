<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Home</title>
</head>
<style>
container a:visited {
color:indigo;
}
</style>
<body>
<div id="container" style="padding:0px 20px;">
<br><br>

<h3><a href="managecategories"> Manage Categories</a>&nbsp;&nbsp;&nbsp;
	<a href="managesuppliers"> Manage Suppliers</a>&nbsp;&nbsp;&nbsp;
	<a href="manageproducts"> Manage Products</a>
	</h3>

<br></div>
<div style="padding:0px 20px;">

	<c:if test="${isAdminClickedManageCategories==true }">
		<jsp:include page="category.jsp"></jsp:include>
	</c:if>
	<c:if test="${isAdminClickedManageSuppliers==true }">
		<jsp:include page="supplier.jsp"></jsp:include>
	</c:if>
	<c:if test="${isAdminClickedManageProducts==true }">
		<jsp:include page="product.jsp"></jsp:include>
	</c:if>

</div>
</body>
</html>