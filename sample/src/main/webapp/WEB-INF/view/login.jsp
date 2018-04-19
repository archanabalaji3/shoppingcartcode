<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Sign up</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<title>Login Form</title>
<style>
body{
margin:0;
padding:0;
background-size:cover;
background-position:center;
font-family:sans-serif;
}
.loginbox{
width:600px;
height:400px;
background:#66ccff;
color:#000;
top:1%;
left:50%;
position:absolute;
transform:translate(-50%, 50%);
box-sizing:border-box;
padding:50px 30px;
}

.avatar{
width:100px;
height:100px;
border-radius:50%;
position:absolute;
top:-50%;
left:calc(50% -50px);
}

h1{

margin:0;
padding: 0 0 20px;
text-align:center;
font-size:22px;
}

.loginbox p{
margin:0;
padding:0;
font-weight:bold;
}

.loginbox input{
width:100%;
margin-bottom:10px;
}

.loginbox input[type="text"], input[type="password"]
{
border:none;
border-bottom:1px solid #fff;
background:transparent;
outline:none;
height:40px;
color:#fff;
font-size:16px;
}


.loginbox input[type="submit"]
{
border:none;
outline:none;
height:40px;
background:#003399;
color:#fff;
font-size:18px;
border-radius:20px;
}

.loginbox input[type="submit"]:hover
{
cursor:pointer;
background:#ffc107;
color:#000;
}

.loginbox a{
text-decoration:none;
font-size:12px;
line-height:20Px;
color:darkgray;
}

.loginbox a:hover{
color:#ffc107;
}
</style>
</head>
<body>
<div class="loginbox">

<h1>Login Here</h1>
<form action = "validate" method = "post">


<label for="uname"><p>Email</p></label> 
<input type="text" name="uname" placeholder="Enter EmailId" required="" autofocus="">
 <label for="psw"><p>Password</p></label> 

<input type="password" name="psw" placeholder="Enter Password" required="">
<input type="submit" name="validate" value="Login">
<a href="#">Lost Your Password?</a><br>
</form>

</div>
</body>

</html>




