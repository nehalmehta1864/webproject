<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Electronics World</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
  <script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

  <script>
function sum() {
      var txtFirstNumberValue = document.getElementById('txt1').value;
      var txtSecondNumberValue = document.getElementById('txt2').value;
      var result = parseInt(txtFirstNumberValue) * parseInt(txtSecondNumberValue);
      if (!isNaN(result)) {
         document.getElementById('txt3').value = result;
      }
}
</script>
 
  
  
  
 <style>.carousel-inner > .item > img { width:100%; height:350px; } </style>
 <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css" rel="stylesheet"/>
</head>
<br>
<body style="background-color:Aquamarine ">
	
	 <jsp:include page="header.jsp" />	
	<div class="container-fluid">		
			<div class="col-md-12 product-info">
					<ul id="myTab" class="nav nav-tabs nav_tabs">
						
						<li class="active"><a href="#service-one" data-toggle="tab">DESCRIPTION</a></li>
						 <li><a href="#service-two" data-toggle="tab">PRODUCT INFO</a></li>
						<li><a href="#service-three" data-toggle="tab">REVIEWS</a></li> 
						
					</ul>
				
					
				</div>
				<hr>
				
    <div class="container-fluid">
    <div class="content-wrapper">	
		<div class="item-container">	
			<form action="addCart">
			<div class="container">	
				<div class="col-md-12">
					<div class="product col-md-3 service-image-left">
                    <br>
                    <br>
						<center>
<img id="item-display" src="${pageContext.request.contextPath}/resources/${product.pImage}" alt="" width="150" height="150"></img>
						</center>
					</div>
						
				</div>
					
				<div class="col-md-7">
				<div class="product-title">${product.name}</div>
				
					<div class="product-rating"><i class="fa fa-star gold"></i> <i class="fa fa-star gold"></i> <i class="fa fa-star gold"></i> <i class="fa fa-star gold"></i> <i class="fa fa-star-o"></i> </div>
					<hr>
				
				
					<input type="hidden"  name="prodid" value="${product.id}"  onkeyup="sum();"/><br>
					ProductPrice:
					<input type="text" id="txt1" name="prodprice" value="${product.price }" readonly onkeyup="sum();"/><br>
					ProductQuantity:<input type="text" id="txt2" name="prodquantity" value="" onkeyup="sum();"/>
					
					TotalPrice:<input type="text"  id="txt3" name="pricetot" value=""/>
					</div>
					<div class="product-stock">In Stock</div>
					<hr>
					
					

                                <%-- <input type="hidden" value="${prodDetail.id }" name="cartpid"/>
                                <input type="hidden" value="${prodDetail.price}" name="cartprice"/>
                                <input type="hidden" value="${prodDetail.pImage}" name="cartImage"/>
                                <input type="hidden" value="${prodDetail.name}" name="cartProdName"/> --%>
                                   <!-- <input type="number" class="form-control" name="cartquant"  required/><br> -->
                               <!--  <input class="btn btn-primary btn-lg" type="submit" value="AddToCart"> -->
                               
                               <input class="btn btn-primary btn-lg" type="submit"
									value="AddToCart">
                               </div>
                         
					
				
					<div class="btn-group wishlist">
					<a href="viewcart">
						  <button type="button" class="btn btn-success">View Cart </button>
					</a>
					
                                      </div>
                                         </form>
				</div>
			</div> 
		
			</div>
		</div>
		
	
	<br>
	<br>
	<br>
	<br>
	<br>
	
	<jsp:include page="footer.jsp" />
</body>
</html>