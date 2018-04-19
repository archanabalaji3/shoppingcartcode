<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
function matchpass(){
	var firstpassword=document.registration.psw.value;
	var secondpassword=document.registration.psw_repeat.value;
	
	var x=document.registration.email.value;
	var atposition=x.indexOf("@");  
	var dotposition=x.lastIndexOf(".");
	
	var letters = /^[a-zA-Z]+$/;
	var word=document.registration.name.value;
	
	var phoneno = /^\d{10}$/;
	var no=document.registration.mob.value;
	
    if(!word.match(letters)){
    alert('Name should be in Alphabet only');
    return false;
    }
    
    if (atposition<1 || dotposition<atposition+2 || dotposition+2>=x.length){  
	  alert("Please enter a valid e-mail address \n atpostion:"+atposition+"\n dotposition:"+dotposition);  
	  return false;  
	  }  
	
    if(firstpassword!=secondpassword){
	alert("Password must be same!");
	return false;
	}
    
    if(!no.match(phoneno)){
    alert('Please Enter only 10 digit moblie number');
    return false;
    }
	}
   </script>
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}
* {
	box-sizing: border-box
}
/* Full-width input fields */
input[type=text], input[type=password] ,input[type=email]{
	width: 100%;
	padding: 15px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
}
input[type=text]:focus, input[type=password]:focus, input[type=email]:focus {
	background-color: #ddd;
	outline: none;
}
hr {
	border: 1px solid #f1f1f1;
	margin-bottom: 25px;
}
/* Set a style for all buttons */
button {
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
	opacity: 0.9;
}
button:hover {
	opacity: 1;
}
/* Extra styles for the cancel button */
.cancelbtn {
	padding: 14px 20px;
	background-color: #f44336;
}
/* Float cancel and signup buttons and add an equal width */
.cancelbtn, .signupbtn {
	float: left;
	width: 50%;
}
/* Add padding to container elements */
.container {
	padding: 16px;
}
/* Clear floats */
.clearfix::after {
	content: "";
	clear: both;
	display: table;
}
/* Change styles for cancel button and signup button on extra small screens */
@media screen and (max-width: 300px) {
	.cancelbtn, .signupbtn {
		width: 100%;
	}
}
</style>
</head>

<body>
	<form name="registration" action="registration" method="post" style="border: 1px solid #ccc" onsubmit="return matchpass()">
		<div class="container">
			<h1>Sign Up</h1>
			<hr>

			<label for="name"><b>Full Name</b></label> 
			<input type="text" placeholder="Enter Name" name="name" required> 
			
			<label for="email"><b>Email</b></label> 
			<input type="text" placeholder="Enter Email" name="email" required> 
			
			<label for="psw"><b>Password</b></label> 
			<input type="password" placeholder="Enter Password" name="psw" required> 
			
			<label for="psw_repeat"><b>Repeat Password</b></label> 
			<input type="password" placeholder="Repeat Password" name="psw_repeat"required> 
			
			<label for="mob"><b>Mobile number</b></label> 
			<input type="text" name="mob" placeholder="Enter mobile no" maxlength="10" required>
			<div class="clearfix">
				<button type="submit" class="signupbtn">Sign Up</button>
			</div>
			
			
		</div>
	</form>
</body>
</html>