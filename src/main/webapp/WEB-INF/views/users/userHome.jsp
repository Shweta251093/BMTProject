
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/app/css/usercss/images/favicon.ico" type="image/x-icon" media="all" />
<title>BookMyTable</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="http://fonts.googleapis.com/css?family=Didact+Gothic"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/resources/app/css/usercss/default.css"
	rel="stylesheet" type="text/css" media="all" />
<link
	href="${pageContext.request.contextPath}/resources/app/css/usercss/fonts.css"
	rel="stylesheet" type="text/css" media="all" />
<style>
.hyper {
	font-size: 50px;
	text-decoration: none;
	color: #ffffff;
	
}
.hyper:hover{
text-decoration:none;
font-size:55px;
font-weight:bold;
}
</style>



<script>

function popUpFunction(){
	alert("Your Seats are booked. \n Be On time.!!!");
}
</script>

</head>
<body>
	<form:form action="userHome" method="post" commandName="hotelList">
		<div id="header-wrapper" >
			<div id="header" class="container">
				<div id="logo">
					<h1>
						<a href="#">BookMyTable</a>
					</h1>
				</div>
				<div id="menu">
					<ul>
						<li class="active"><a href="#" accesskey="1" title="">Homepage</a></li>
						<li><a href="${pageContext.request.contextPath}/logout" accesskey="3" title="">logout</a></li>
						<li><a href="${pageContext.request.contextPath}/addreview.html" accesskey="4" title="">Review</a></li>
						<li><a href="${pageContext.request.contextPath}/aboutUs" onclick="" accesskey="4" title="">About US</a></li>
					</ul>
				</div>
			</div>

			<div id="banner-wrapper">
				<div id="banner" class="container">
					<div class="title">
						<h2>Book My Table</h2>
						<span class="byline">Opening Hour 10:00 AM - 10:00 PM.</span>

						<%
							String username = (String) request.getSession().getAttribute(
										"usernamevalue");
						%>

						<h3>
							Welcome
							<%=username%></h3>
					</div>
					<a href="viewOffers" class="hyper"><h2>Exciting Offers</h2></a>
				</div>
			</div>
		</div>
		<div id="wrapper">
			<div id="three-column" class="container">
				<div id="header" class="container">
					<center>
						<select name="no_of_seats" tabindex="1" class="resizedTextbox">
							<option value="1">1 person</option>
							<option value="2">2 people</option>
							<option value="3">3 people</option>
							<option value="4">4 people</option>
							<option value="5">5 people</option>
							<option value="6">6 people</option>
							<option value="7">7 people</option>
							<option value="8">8 people</option>
							<option value="9">9 people</option>
							<option value="10">10 people</option>
							<option value="11">11 people</option>
							<option value="12">12 people</option>
							<option value="13">13 people</option>
							<option value="14">14 people</option>
							<option value="15">15 people</option>
							<option value="16">16 people</option>
							<option value="17">17 people</option>
							<option value="18">18 people</option>
							<option value="19">19 people</option>
							<option value="20">20 people</option>

						</select> <input type="date" name="booking_date" class="resizedTextbox">

						<select name="booking_time" tabindex="3" class="resizedTextbox">
							<option value="10:00">10:00 AM</option>
							<option value="11:00">11:00 AM</option>
							<option value="12:00">12:00 PM</option>
							<option value="13:00">01:00 PM</option>
							<option value="14:00">02:00 PM</option>
							<option value="15:00">03:00 PM</option>
							<option value="16:00">04:00 PM</option>
							<option value="17:00">05:00 PM</option>
							<option value="18:00">06:00 PM</option>
							<option value="19:00">07:00 PM</option>
							<option value="20:00">08:00 PM</option>
							<option value="21:00">09:00 PM</option>
							<option value="22:00">10:00 PM</option>

						</select> <input type="submit" value="FindTable" class="resizedTextbox">
					</center>
				</div>
			</div>
		</div>
		<div id="header" class="container">
			<center>
				<h1 id="listOfTables">List of Hotel With Available Seats</h1>
			</center>
			<br>
			<TABLE align="center" BORDER="1">
				<TR>
					<TH>Hotel Id</TH>
					<TH>Hotel Name</TH>
					<TH>Location</TH>
					<TH>Contact_No.</TH>
					<TH>No. of Seats</TH>
					<TH>Date</TH>
					<TH>Time</TH>
					<TH>Book This Hotel</TH>

				</TR>
				<c:forEach items="${listHotel}" var="findtable">
					<tr>
						<td><c:out value="${findtable.hotel_id}" /></td>
						<td><c:out value="${findtable.hotel_name}" /></td>
						<td><c:out value="${findtable.location}" /></td>
						<td><c:out value="${findtable.contact_no}" /></td>
						<td><c:out value="${findtable.no_of_seats}" /></td>
						<td><c:out value="${findtable.booking_date}" /></td>
						<td><c:out value="${findtable.booking_time}" /></td>
						<%-- <td><input type="radio" name="bookhotel" id="bookhotel" value="${findtable.hotel_id}"/></td> --%>
						<td><a
							href="userHome/${findtable.hotel_id}/${findtable.no_of_seats}/"
							class="ico del" onclick="popUpFunction()">BookHotel</a>
					</tr>
				</c:forEach>
			</TABLE>
		</div>
	</form:form>
</body>
</html>