<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="http://fonts.googleapis.com/css?family=Didact+Gothic"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/resources/app/css/usercss/default.css"
	rel="stylesheet" type="text/css" media="all" />
<link
	href="${pageContext.request.contextPath}/resources/app/css/usercss/fonts.css"
	rel="stylesheet" type="text/css" media="all" />
<title>Notification</title>
</head>
<body>


	<!-- CSS code -->

	<div id="header-wrapper">
		<div id="header" class="container">
			<div id="logo">
				<h1>
					<a href="#">BookMyTable</a>
				</h1>
			</div>
			<div id="menu">
				<ul>

					<!--Link for Login -->

					<li class="active"><a href="user" accesskey="1" title="">Homepage</a></li>

				</ul>
			</div>
		</div>
		<div id="banner-wrapper">
			<div id="banner" class="container">
				<div class="title">
					<h2>Book My Table</h2>
					<span class="byline">Opening Hour 10:00 AM - 10:00 PM.</span>
				</div>
			</div>
		</div>
	</div>



	<div id="wrapper">
		<div id="three-column" class="container">
			<div id="header" class="container">




				<!-- Actual Body -->




				<h3>${message }</h3>
				<h2>
					<a href="user">Login</a>
				</h2>


			</div>
		</div>

	</div>

</body>
</html>