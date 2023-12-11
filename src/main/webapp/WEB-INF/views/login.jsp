<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Movies</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">

<style>
.footer {
	position: absolute;
	bottom: 0;
	width: 100%;
	height: 60px;
	background-color: #f5f5f5;
}
</style>
</head>

<body>

	<div id="menu">
    <p class="menulinks">
    <!-- <strong class="hide">Main menu:</strong> -->
    <a class="menulink active" href="index.jsp">Home</a><span class="hide"> | </span>
    <!-- <a class="menulink" href="ListFilmServlet">Movie</a><span class="hide"> | </span>
    <a class="menulink" href="ListActorServlet">Actor</a><span class="hide"> | </span>
    <a class="menulink" href="ListCategoryServlet">Category</a><span class="hide"> | </span>
    <a class="menulink" href="ListCustomerServlet">Customer</a><span class="hide"> | </span>
    <a class="menulink" href="LogoutServlet">Logout</a>
     -->
    </p>
	</div>

	<div class="container">
		<form action="/films" method="post">
			<p>
				<font color="red">${errorMessage}</font>
			</p>
			Name:    <input type="text" name="name" required/> 
			Password:<input	type="password" name="password" /> <input type="submit" value="Login" />
		</form>

	</div>

	<footer class="footer">
		<div>footer content</div>
	</footer>

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>

</html>