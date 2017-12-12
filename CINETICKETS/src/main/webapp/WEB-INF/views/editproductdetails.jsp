<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<style>
.button {
	background-color: #4CAF50; /* Green */
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
}

.button3 {
	background-color: #f44336;
} /* Red */
</style>
<head>
<title>ELECTRONICS WORLD</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>


	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
		<div class="page-header">
			<h1>ELECTRONICS WORLD</h1>
		</div>
	</div>
	<br>

	<div class="container">

		<form action="editproductdetails" enctype="multipart/form-data">

			 <div class="form-group">
				<label for="pid">PRODUCT-ID :</label> <input type="text"
					class="form-control" id="pid" placeholder="Enter Product ID"
					name="pid" value="${product.id }" readonly="true">
			</div>
 

		     <!-- <div class="form-group">
			    <label class="col-md-4 control-label" for="textinput">PRODUCT-ID:-</label>
				<div class="col-md-4">
				<input id="textid" type="text" name="pid">
				</div>
				</div>
				  -->
			<br> <br>

			 <div class="form-group">
				<label for="pname">PRODUCT NAME :-</label> <input type="text"
					class="form-control" id="pname" placeholder="Enter Product Name "
					name="pname" value="${product.name }">
			</div>
			
			
			<!-- <div class="form-group">
				<label class="col-md-4 control-label" for="textinput">PRODUCT NAME:-</label>
				<div class="col-md-4">
				<input id="textname" type="text" name="pname">
			    </div>
				</div> --> 
			<br> <br>

		 <div class="form-group">
				<label for="pdescription">PRODUCT DESCRIPTION :</label> <input
					type="text" class="form-control" id="pdescription"
					name="pdescription" value="${product.description }">
			</div> 
			
			
			<!--  <div class="form-group">
							<label class="col-md-4 control-label" for="textarea">DESCRIPTION</label>
							<div class="col-md-4">
								<input id="textname" type="text" name="pdescription">
							</div>
						</div>  -->
			<br> <br> <br> <br>
			<div class="form-group">
				<label class="col-md-4 control-label" for="categoryitems">SELECT
					CATEGORY TO EDIT:-</label>
				<div class="col-md-4">
					<select id="categoryitems" class="form-control"
						name="categoryitems">
						
						<c:forEach var="cat" items="${catList}">
							<option value="${cat.categoryId}">${cat.categoryName}</option>
						</c:forEach>
					</select>
				</div>
			</div>
 
			<%--  <div class="form-group">
							<label class="col-md-4 control-label" for="ln">PRODUCT CATEGORY</label>
							<div class="col-md-4">
							<select name="categoryitems" id="categoryitems" style="width: 150px;">
							
		                    <c:forEach items="${catList}" var="cat">
		                    
		                    <option value="${cat.categoryId}">${cat.categoryName}</option>
		                    </c:forEach>
						    </select>
							</div>
						    </div> 

 --%>


			<br> <br> <br>


		<%-- 	 <div class="form-group">
				<label for="pquantity">PRODUCT DESCRIPTION :</label> <input
					type="number" class="form-control" id="pquantity" name="pquantity"
					value="${product.quantity }">
			</div>  --%>
			  <!--   <div class="form-group">
							<label class="col-md-4 control-label" for="selectbasic">QUANTITIES</label>
							<div class="col-md-4">
							<input id="textname" type="text" name="pquantity">
							
							</div>
						</div>  -->
			<br> <br> <br>

			 <div class="form-group">
				<label for="pprice">PRODUCT PRICE:-</label> <input type="number"
					class="form-control" id="pprice" placeholder="Enter Product Price "
					name="pprice" value="${Product.price }">
			</div> 
			<!--  <div class="form-group">
						<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">PRICE</label>
				<div class="col-md-4">
				<input id="textname" type="text" name="pprice">
			    </div>
				</div>  -->
			<br> <br>


			
			<div class="form-group">
				<label class="col-md-4 control-label" for="supplieritems">SELECT
					SUPPLIER TO EDIT:-</label>
				<div class="col-md-4">
					<select id="supplieritems" class="form-control"
						name="supplieritems">
						
						<c:forEach var="supplier" items="${supplierlist}">
							<option value="${supplier.supplierId }">${supplier.supplierName}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			
			 <%-- <div class="form-group">
							<label class="col-md-4 control-label" for="ln">PRODUCT SUPPLIER</label>
							<div class="col-md-4">
							<select name="supplieritems" id="supplieritems" style="width: 150px;">
							
		                    <c:forEach items="${supplierlist}" var="supplier">
		                    
		                    <option value="${supplier.supplierId}">${supplier.supplierName}</option>
		                    </c:forEach>
						    </select>
							</div>
						    </div> --%> 
			<br> <br> <br>


			<div class="form-group">
				<label class="control-label" for="productImage">UPLOAD
					PICTURES</label> <input name="file" id="fileToUpload" type="file" />
			</div>

		</form>
		<br> <br>

		<button type="submit">EDIT</button>
		<button type="reset">CANCEL</button>
	</div>

	<br>
	<br>
	<br>





	<jsp:include page="footer.jsp"></jsp:include>




</body>
</html>

