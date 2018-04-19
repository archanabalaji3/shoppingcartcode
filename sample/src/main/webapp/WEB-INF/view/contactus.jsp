<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
}
* {
    box-sizing: border-box;
}
/* Style inputs */
input[type=text], select, textarea {
    width: 100%;
    padding: 12px;
    border: 1px solid #ccc;
    margin-top: 6px;
    margin-bottom: 16px;
    resize: vertical;
}
input[type=submit] {
    background-color: #4CAF50;
    color: white;
    padding: 12px 20px;
    border: none;
    cursor: pointer;
}
input[type=submit]:hover {
    background-color: #45a049;
}
/* Style the container/contact section */
.container {
    border-radius: 5px;
    background-color: #f2f2f2;
    padding: 10px;
}
/* Create two columns that float next to eachother */
.column {
    float: left;
    width: 50%;
    margin-top: 6px;
    padding: 20px;
}
/* Clear floats after the columns */
.row:after {
    content: "";
    display: table;
    clear: both;
}
/* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 600px) {
    .column, input[type=submit] {
        width: 100%;
        margin-top: 0;
    }
}
</style>
</head>
<body>
<div class="container">
	<div class="row">
	
        <div class="col-md-6 col-md-offset-3">
  <div style="text-align:center">
    <h2>ContactUs</h2>
    <h5>Please enter your query details below:</h5>
  </div>
        <label for="fname">First Name</label>
        <input type="text" id="fname" name="firstname">
        
        <label for="femail">Email</label>
        <input type="text" id="email" name="firstname">
        <label for="mob"><b>Mobile number</b></label> 
			<input type="text" name="mob" maxlength="10" required>
           
        <label for="subject">Query</label>
        <textarea id="subject" name="subject" style="height:170px"></textarea>
		<br><center><a href="hom"><br>
		<button type="button" class="btn btn-primary">
 		 Submit
		</button></a></center>
   </div></div></div>


</body>
</html>