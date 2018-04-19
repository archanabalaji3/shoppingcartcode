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
  <style>
  
</style>
</head>

<body>

<c:forEach items="${products}" var="product">
<div class="col-md-3">
<div class="well">
<div class="row">

    <div class="thumbnail">
    
 <img src="resources/images/${product.id}.PNG"  alt="products" style="height:180px; width:180px">
  <div class="caption">
  <h5>${product.name}</h5>
<a href="product/get/${product.id}">View</a>
</div>


          
     </div>
          </div>
        
      </div></div></c:forEach>
    







</body>
</html>