<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center><h2>Welcome to shopping cart</h2></center><br>
<a href="login">Existing User</a>
<a href="registration">New User</a>
<hr color="blue" size="4">

<jsp:include page="/WEB-INF/view/product-menu.jsp"></jsp:include>
${WelcomeMessage}
${ErrorMessage}

<c:if test="${isuserclickedlogin==true }">
<jsp:include page="/WEB-INF/view/login.jsp"></jsp:include>
</c:if>

<c:if test="${isuserclickedregistration==true }">
<jsp:include page="/WEB-INF/view/registration.jsp"></jsp:include>
</c:if>
 
</body>
</html>