<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>History</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="http://fonts.googleapis.com/css?family=Didact+Gothic"
	rel="stylesheet" />

	<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/app/css/reviewcss/offer.css"
	type="text/css" media="all" />
<style>
body {
	font-size: 20px;
	color: teal;
	font-family: Calibri;
	 margin: 0px;
    padding: 0px;
}

td {
	font-size: 15px;
	color: black;
	width: 100px;
	height: 22px;
	text-align: center;
}

.heading {
	font-size: 18px;
	color: white;
	font: bold;
	background-color: orange;
	border: thick;
}

table {

    margin: 0px auto;
}

div.pos_right {
    position: relative;
    left: 500px;
}


</style>
</head>
<body>
<form action="reviews" method="get">

<div class="pos_right">
<center> 
  <div class="center">
		<h1><b> REVIEWS   </b></h1>
		<br>
		
	<table border="2" >
			<tr>
			<!-- 	<td class="heading">user_id</td>
				<td class="heading">booking_id</td>
				<td class="heading">hotel_id</td> -->
				<td class="heading">food_name</td>
			<!-- 	<td class="heading">quantity</td> -->
				<td class="heading">rating</td>
				<td class="heading">review</td>
			</tr>
			<c:forEach var="user" items="${data}">
				<tr>
					<%-- <td>${user.user_id}</td>
					<td>${user.booking_id}</td>
					<td>${user.hotel_id}</td> --%>
					<td>${user.food_name}</td>
					<%-- <td>${user.quantity}</td> --%>
					<td>${user.rating}</td>
					<td>${user.review}</td>
				</tr>
			</c:forEach>

		</table>
		</div>
		<p><a href="addreview.html"> Add New Review and Rating </a><br/>
		</p>
		</center>
	</div>
</form>
</body>
</html>