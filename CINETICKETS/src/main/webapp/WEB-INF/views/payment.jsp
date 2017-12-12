<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<c:set var="cp" value="${pageContext.request.contextPath}" />



<jsp:include page="header.jsp"></jsp:include>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment</title>
<div class="container">
	<div class="row">

		<div class="col-xs-12 col-md-4">
			<div class="panel panel-default credit-card-box">
				<div class="panel-heading display-table">
					<div class="row display-tr">
						<h3 class="panel-title display-td">Payment Details</h3>
						<div class="display-td">
							<img class="img-responsive pull-right"
								src="http://i76.imgup.net/accepted_c22e0.png">
						</div>
					</div>
				</div>
			</div>
			<div class="panel-body">
				<form:form modelAttribute="payment" method="POST" action="${cp}/Payment/insert">
					<div class="row">
						<div class="col-xs-12">
							<div class="form-group">
								<form:label path="name" >Name On Card</form:label>
								<div class="input-group">
									<form:input path="name" class="form-control"
										placeholder="Name On Card" type="text" required="required" />
									<span class="input-group-addon"><i
										class="fa fa-credit-card"></i></span>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12">
							<div class="form-group">
								<form:label path="cNo" >Card Number</form:label>
								<div class="input-group">
									<form:input path="cNo" class="form-control"
										placeholder="Card Number" type="text" required="required" />
									<span class="input-group-addon"><i
										class="fa fa-credit-card"></i></span>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-xs-12">
							<div class="form-group">
								<form:label path="exDate" >Expiration Date</form:label>
								<div class="input-group">
									<form:input path="exDate" class="form-control"
										placeholder="MM / YY"  type="tel" required="required" />
									<span class="input-group-addon"><i
										class="fa fa-credit-card"></i></span>
								</div>
							</div>
						</div>
					</div>
						<div class="row">
						<div class="col-xs-12">
							<div class="form-group">
								<form:label path="cvv" >CVV(?)</form:label>
								<div class="input-group">
									<form:input path="cvv" class="form-control"
										placeholder="Name On Card" type="text" required="required" />
									<span class="input-group-addon"><i
										class="fa fa-credit-card"></i></span>
								</div>
							</div>
						</div>
					</div>
							<form:hidden path="payId"></form:hidden>
							
								<div class="form-group-center">
									<div class="col-xs-offset-2 col-xs-10">
									<a class="btn btn-lg btn-info" href="${cp}/Payment/confirm/${pageContext.request.userPrincipal.name}" > Submit</a>
										
										<form:button type="reset" class="btn btn-lg btn-info">RESET</form:button>
									</div>
								</div>
							</div>
						</div>
						</div></div>
				</form:form>
				</html>
				<br/>
				<br/>
				<br/><br/>
				<jsp:include page="footer.jsp"></jsp:include>