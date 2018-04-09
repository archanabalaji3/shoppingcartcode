<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<form:form action="AddProduct" method="post" modelAttribute="prdt" enctype="multipart/form-data">
				
			Product ID : <form:input type="text" path="id"/>
			<br/>
			Product Name : <form:input type="text" path="name"/>
			<br/>
			Product Description : <form:input type="text" path="description"/>
			<br/>
			Image : <form:input type="file" path="pimage"/>
			<br/>
			<input type="submit" value="SUBMIT"/>
		
		</form:form>

		
		
		
</body>
</html>