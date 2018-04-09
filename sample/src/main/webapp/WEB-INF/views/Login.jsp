<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}
form {
	border: 3px solid #f1f1f1;
}
input[type=text], input[type=password] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}
button {
	background-color: white;
	color: black;
	padding: 14px 20px;
	margin: 8px 0;
	border: 2px solid #008CBA;
	cursor: pointer;
	width: 100%;
}
button:hover {
	background-color: #008CBA;
    color: white;
}
.cancelbtn {
	width: auto;
	padding: 10px 18px;
	background-color: lightblue;
}
.imgcontainer {
	text-align: center;
	margin: 6px 0 3px 0;
}
img.avatar {
	width: auto;
	border-radius: 50%;
}
.container {
	padding: 16px;
}
span.psw {
	float: right;
	padding-top: 16px;
}
/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
	span.psw {
		display: block;
		float: none;
	}
	.cancelbtn {
		width: 100%;
	}
}
</style>
</head>

<body>
	<h2>Login Form</h2>

	<form action="validate" method="post">
		<div class="imgcontainer">
			<img src="resources/images/avatar1.png" alt="Avatar" class="avatar">
		</div>

		<div class="container">
			<label for="mailid"><b>Username / Email id</b></label> 
			<input type="text" placeholder="Enter Username" name="mailid" required>

			<label for="psw"><b>Password</b></label> 
			<input type="password" placeholder="Enter Password" name="psw" required>

			<button type="submit">Login</button>
			<label> <input type="checkbox" checked="checked" name="remember"> Remember me </label>
		</div>

		<div class="container" style="background-color: white">
			<button type="button" class="cancelbtn">Cancel</button>
			<span class="psw">Forgot <a href="#">password?</a></span>
		</div>
	</form>
</body>
</html>