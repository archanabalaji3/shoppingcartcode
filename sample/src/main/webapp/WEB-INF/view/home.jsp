<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
	<jsp:include page="loginheader.jsp"></jsp:include>
	
${successMessage} 
	<c:choose>
	
		<c:when test="${loginerror==true}">
		<jsp:include page="login.jsp"></jsp:include>
		</c:when>	
		<c:when test="${isUserClickedAboutus==true}">
		<jsp:include page="aboutus.jsp"></jsp:include>
		</c:when>
		
		<c:when test="${isUserClickedContact==true}">
		<jsp:include page="contactus.jsp"></jsp:include>
		</c:when>	
	
		<c:when test="${isAdmin==true}">
		<jsp:include page="admin/adminhome.jsp"></jsp:include>
		</c:when>

		<c:when test="${isUserClickedLogin==true}">
		<jsp:include page="login.jsp"></jsp:include>
		</c:when>
	
		<c:when test="${isUserClickedRegister==true}">
		<jsp:include page="registration.jsp"></jsp:include>
		</c:when>
	
		<c:when test="${isUserSelectedProduct==true}">
		<jsp:include page="selected_product.jsp"></jsp:include>
		</c:when>
		
		<c:when test="${isUserClickedMyCart==true}">
		<jsp:include page="cart.jsp"></jsp:include>
		</c:when>
	
		<c:when test="${deleteCartSuccess==true}">
		<jsp:include page="cart.jsp"></jsp:include>
		</c:when>
	
		<c:when test="${checkoutClicked==true}">
		<jsp:include page="checkout.jsp"></jsp:include>
		</c:when>
		
		<c:when test="${clickedPlaceOrder==true}">
		<jsp:include page="placeOrder.jsp"></jsp:include>
		</c:when>

			<c:otherwise>
				<jsp:include page="carousel.jsp"></jsp:include>
				<jsp:include page="productdisplay.jsp"></jsp:include>
			</c:otherwise>
	</c:choose>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>