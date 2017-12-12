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
}
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

		<ul class="nav nav-tabs">
			<li class="active"><a data-toggle="tab" href="#home">CATEGORIES</a></li>
			<li><a data-toggle="tab" href="#menu1">SUPPLIERS</a></li>
			<li><a data-toggle="tab" href="#menu2">PRODUCTS</a></li>

		</ul>
		<br>

		<div class="tab-content">
			<div id="home" class="tab-pane fade in active">
				<h3>ADD CATEGORIES:-</h3>

				<br> <br>

				<form action="addCategory" method="post">
					<div class="container">


						<div class="form-group">
							<label class="col-md-4 control-label" for="textinput">CATEGORY
								ID:-</label>
							<div class="col-md-4">
								<input id="textid" type="text" name="cid">

							</div>
						</div>
						<br>
						<div class="form-group">
							<label class="col-md-4 control-label" for="textinput">CATEGORY
								NAME:-</label>
							<div class="col-md-4">
								<input id="textname" type="text" name="cname">
							</div>
						</div>
						<br> <br>
						<button type="submit">ADD</button>
						<button type="reset">CANCEL</button>
					</div>
					<br> <br> <br>

					<jsp:include page="footer.jsp"></jsp:include>
					<br> <br>

				</form>
			</div>
			<div id="menu1" class="tab-pane fade">
				<h3>ADD SUPPLIERS:-</h3>

				<br> <br>

				<form action="addSupplier" method="post">
					<div class="container">


						<div class="form-group">
							<label class="col-md-4 control-label" for="textinput">SUPPLIER-ID:-</label>
							<div class="col-md-4">
								<input id="textid" type="text" name="sid">

							</div>
						</div>
						<br>
						<div class="form-group">
							<label class="col-md-4 control-label" for="textinput">SUPPLIER
								NAME:-</label>
							<div class="col-md-4">
								<input id="textname" type="text" name="sname">
							</div>
						</div>
						<br> <br>
						<button type="submit">ADD</button>
						<button type="reset">CANCEL</button>
					</div>
					<br> <br> <br>
					<jsp:include page="footer.jsp"></jsp:include>
				</form>





			</div>
			<div id="menu2" class="tab-pane fade">
				<form action="addProduct" method="post"
					enctype="multipart/form-data">
					<div class="container">

						<h3>ADD PRODUCTS:-</h3>
						<br> <br>
						<div class="form-group">
							<label class="col-md-4 control-label" for="textinput">PRODUCT-ID:-</label>
							<div class="col-md-4">
								<input id="textid" type="text" name="pid">
							</div>
						</div>
						<br> <br>
						<div class="form-group">
							<label class="col-md-4 control-label" for="textinput">PRODUCT
								NAME:-</label>
							<div class="col-md-4">
								<input id="textname" type="text" name="pname">
							</div>
						</div>
						<br> <br>
						<div class="form-group">
							<label class="col-md-4 control-label" for="textarea">DESCRIPTION</label>
							<div class="col-md-4">
								<input id="textname" type="text" name="pdescription">
							</div>
						</div>
						<br> <br> <br> <br>

						<div class="form-group">
							<label class="col-md-4 control-label" for="selectbasic">QUANTITIES</label>
							<div class="col-md-4">
								<input id="textname" type="text" name="pquantity">

							</div>
						</div>
						<br> <br> <br>
						<div class="form-group">
							<label class="col-md-4 control-label" for="textinput">PRICE</label>
							<div class="col-md-4">
								<input id="textname" type="text" name="pprice">
							</div>
						</div>
						<br> <br> <br> <br>
						<div class="form-group">
							<label class="col-md-4 control-label" for="ln">PRODUCT
								CATEGORY</label>
							<div class="col-md-4">
								<select name="categoryitems" id="categoryitems"
									style="width: 150px;">

									<c:forEach items="${categorylist}" var="cat">

										<option value="${cat.categoryId}">${cat.categoryName}</option>
									</c:forEach>
								</select>
							</div>
						</div>


						<br> <br>





						<div class="form-group">
							<label class="col-md-4 control-label" for="ln">PRODUCT
								SUPPLIER</label>
							<div class="col-md-4">
								<select name="supplieritems" id="supplieritems"
									style="width: 150px;">

									<c:forEach items="${supplierlist}" var="supplier">
										<option value="${supplier.supplierId}">${supplier.supplierName}</option>
									</c:forEach>
								</select>
							</div>
						</div>


						<br> <br>

						<div class="form-group">
							<label class="control-label" for="productImage">UPLOAD
								PICTURES</label> <input name="file" id="fileToUpload" type="file" />
						</div>
					</div>



					<br> <br>

					<button type="submit">ADD</button>
					<button type="reset">CANCEL</button>

					<br> <br> <br>


					<jsp:include page="footer.jsp"></jsp:include>
				</form>
			</div>

		</div>
	</div>





</body>
</html>


