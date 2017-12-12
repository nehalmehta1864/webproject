
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="images" value="/resources/images" />

<!DOCTYPE html>
<html lang="en">
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
<body style="background-color:yellow;">

<marquee behavior="scroll" direction="left">
<img
src="http://electronics-world.net/images/ElectronicsWorld-logo_03.1370472687.png"
width="220" height="200" alt="Natural" />
</marquee>



<nav class="navbar navbar-inverse">
<div class="container-fluid">
<div class="navbar-header">
<a class="navbar-brand" href="#">ELECTRONICS WORLD</a>
</div>

<ul class="nav navbar-nav">
<li class="active"><a href="#">HOME</a></li>
<li class="dropdown"><a class="dropdown-toggle"
data-toggle="dropdown" href="#">SHOP BY CATEGORIES<span
class="caret"></span></a>
<ul class="dropdown-menu">
<c:forEach items="${catList}" var="cat">

<li><a
href="<c:url value="/productslist?cid=${cat.categoryId}"/>">${cat.categoryName}</a></li>
</c:forEach>
</ul></li>

<li class="dropdown"><a class="dropdown-toggle"
data-toggle="dropdown" href="#">LIST<span class="caret"></span></a>
<ul class="dropdown-menu">
<li><a href="categorylist"><span
class="glyphicon glyphicon"></span> CATEGORIES</a></li>
<li><a href="supplierlist"><span
class="glyphicon glyphicon"></span> SUPPLIERS</a></li>
<li><a href="adminproductlist"><span
class="glyphicon glyphicon"></span> PRODUCTS</a></li>
</ul></li>


</ul>

<c:if test="${pageContext.request.userPrincipal.name  == 'admin'}">
<li><a href="<c:url value="/admin" />">ADMIN</a></li>
</c:if>
<ul class="nav navbar-nav navbar-right">




<c:if test="${pageContext.request.userPrincipal.name  == 'admin@gmail.com'}">
<li><a id="ad" style="color: white;"
href="<c:url value="/admin/add"/>" role="button" aria-haspopup="true"
aria-expanded="false">ADD</a></li>
</c:if>
<c:if test="${pageContext.request.userPrincipal.name  == null}">
<li><a style="color: white;"
href="<c:url value="/login"/>" role="button"
aria-haspopup="true" aria-expanded="false">LOGIN</a></li>
</c:if>

<c:if test="${pageContext.request.userPrincipal.name == null }">

<li><a href="register">SIGN UP<span
class="glyphicon glyphicon-log-in"></span></a></li>
<li><a href="categories"><span
class="glyphicon glyphicon-log-in"></span> ADD</a></li>

</c:if>
</ul>
<c:if test="${pageContext.request.userPrincipal.name  != null}">
<li><a>Welcome: ${pageContext.request.userPrincipal.name}</a></li>
<li><a href='<c:url value="/logout" />'>SIGN OUT</a></li>
</c:if>

</div>
</nav>


</body>
</html>


