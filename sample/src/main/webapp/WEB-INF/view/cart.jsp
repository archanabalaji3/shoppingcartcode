<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>My Cart</title>

<style>
hr {
height: 1px;
background-color:black;
border: 0 none;
}
input[type="text"] {
border:0;
background-color:ghostwhite;
padding:5px;
}
th {
font-family:calibri;
text-align:center;
font-size:20px;
}
</style>
</head>
<body>
<p style="margin:0px 50px;font-size:30px;font-family:tahoma;">Items in Your Cart</p>
${noItems}
<div class="container">
<hr>
<form action="checkout" method="post">
  <table style="text-align:center;" class="table-striped">
    <thead>
      <tr>
        <th style="width:10%;">Cart id</th>
        <th style="text-align:center;">Product</th>
        <th style="width:30%;">Product Name</th>
        <th>Quantity</th>
        <th style="width:10%;">Price</th>
        <th></th>
      </tr>
    </thead>
    
    <tbody>
    <c:forEach var="cart" items="${cartList}">
      <tr>
     	 <td>${cart.id}</td>
     	 <td style="width:15%;"><img style="height:130px;width:220px;padding:20px;" alt="${cart.productName}" src="resources/images/${cart.productID}.PNG"></td>
     	 <td style="padding:10px 20px;">${cart.productName}</td>
      	 <td style="width:15%;">
      	 <button class="btn btn-primary" formaction="editcartqtym/${cart.id}" method="post">-</button>
			<input type="text" style="text-align:center;width:20%;" name="cartquantity" value="${cart.quantity}">
			<button class="btn btn-primary" formaction="editcartqty/${cart.id}" method="post">+</button>
		</td>
		<td>${cart.price}</td>
		<td><button style="width:50%;" class="btn btn-danger" formaction="deleteFromCart?id=${cart.id}" method="post"> Delete </button></td>
		
      </tr>
    </c:forEach>
    </tbody>
    
  </table>
  <hr><br>
  <div class="container">
  <a href="h">
  <span class="glyphicon glyphicon-arrow-left"></span>
  Continue Shopping</a>
  <p style="text-align:right;margin:0px 80px;"><font size="4" face="verdana"><b><i>Total : ${cartsum} </i></b></font></p></div><br>
  <p style="text-align:right;margin:0px 80px;">
					<button style="width:10%;" formaction="checkout" method="post"> Check Out </button></p>

</form></div>
</body>
</html>