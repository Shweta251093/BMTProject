<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">


<link href="http://fonts.googleapis.com/css?family=Didact+Gothic"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/resources/app/css/usercss/default.css"
	rel="stylesheet" type="text/css" media="all" />
<link
	href="${pageContext.request.contextPath}/resources/app/css/usercss/fonts.css"
	rel="stylesheet" type="text/css" media="all" />

<title>Hotel Details</title>
<style>
table,th,td {
	border: 1px solid black;
}
</style>

</head>


<body>


	<div id="header-wrapper">
		<div id="header" class="container">
			<div id="logo">
				<h1>
					<a href="#">BookMyTable</a>
				</h1>
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

<!----------------------------------------------------------------------------Hotel Details------------------------------------------------------------------------------------------>

				Hotel Details Below
				<center>
					<table>
						<tr>
							<th>Hotel Id</th>
							<th>Hotel Name</th>
							<th>Location</th>
							<th>Contact no.</th>
						</tr>
						<tr>
							<td>${hotel}</td>
							<td>${hotel_name}</td>
							<td>${location}</td>
							<td>${contact_no}</td>
						</tr>
					</table>
					<a href="/mywebapp/superAdmin">Back to Previous Page</a>
				</center>

			</div>
		</div>
	</div>

</body>
</html>