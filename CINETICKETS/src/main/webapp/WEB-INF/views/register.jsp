<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>REGISTRATION PAGE</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    /* Add a gray background color and some padding to the footer */
    footer {
      background-color: #f2f2f2;
      padding: 25px;
    }
    
  .carousel-inner img {
      width: 100%; /* Set width to 100% */
      margin: auto;
      height:200px;
  }
  
 
  /* Hide the carousel text when the screen is less than 600 pixels wide */
  @media (max-width: 400px) {
    .carousel-caption {
      display: none; 
    }
  }
  
 form {
    border: 3px solid #f1f1f1;
}
input[type=text], input[type=password],input[type=email],input[type=number] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}
button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 30%;
}
button:hover {
    opacity: 0.8;
}
.cancelbtn {
    width: auto;
    padding: 10px 18px;
    background-color: #f44336;
}
.imgcontainer {
    text-align: center;
    margin: 24px 0 12px 0;
}
.container {
    padding: 8px;
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
<body style="background-color:YELLOW ">
<jsp:include page="header.jsp" />
<!-- <form action="register" method="post"> -->

<form action="addUser" method="post">

  <div class="container-">
    <label><b>NAME</b></label>
    <input type="text" placeholder="ENTER UR NAME" name="name" required="required">
     <label><b>AGE</b></label>
    <input type="number" placeholder="ENTER UR AGE" name="age"  pattern="[18-99]" title="enter age between 18-99" required="required" >
     <label><b>EMAIL</b></label>
    <input type="email" placeholder="ENTER E-MAIL" name="mail" required="required" >
	 <label><b>PASSWORD</b></label>
    <input type="password" placeholder="ENTER PASSWORD" name="passwd" maxlength="10" title="enter valid password" required="required" >
     <label><b>PHONE NUMBER</b></label>
      <input type="text" placeholder="ENTER PHONE NO." name="phone"  title="enter valid number" required="required">
      <label><b>ADDRESS</b></label><br>
    <textarea rows="4" cols="200" name="address"></textarea>
    </div>
     <button type="submit">SIGN-UP</button>
     
</form>
<br/>
<br/>
<br/>
<br/>
<jsp:include page="footer.jsp" />
</body>
</html>
