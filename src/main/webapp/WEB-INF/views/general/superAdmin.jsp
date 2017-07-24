
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<title>Super Admin Login</title>

<link href="http://fonts.googleapis.com/css?family=Didact+Gothic"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/resources/app/css/usercss/default.css"
	rel="stylesheet" type="text/css" media="all" />
<link
	href="${pageContext.request.contextPath}/resources/app/css/usercss/fonts.css"
	rel="stylesheet" type="text/css" media="all" />

<style>
table,th,td {
	border: 1px solid grey;
}
</style>

<script type="text/javascript">
bajb_backdetect.OnBack = function()
{
alert('You clicked it!');
}
</script>

<script>
function myFunction() {
    alert("View Hotel Details");
}

function deleteHotel() {
    alert("Hotel Deleted Successfully");
}

function confirmHotel() {
    alert("Hotel Confirmed Successfully");
}

</script>

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


	<!-- Header -->
	<div id="header">
		<div class="shell">
			<!-- Logo + Top Nav -->
			<div id="top">
				<h1>Welcome</h1>
				<div id="top-navigation">
					Welcome <strong>Administrator</strong> <span>|</span> <span>|</span>
					<a href="logout">Log out</a>
				</div>
			</div>
		</div>
	</div>

	<div id="wrapper">
		<div id="three-column" class="container">
			<div id="header" class="container">
				<h2>Current Request</h2>
				<h2>Click on Hotel Name to view its details</h2>
			</div>
			<!-- Table -->
			<div class="table">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<th>Name of Hotel</th>

						<th>Added by</th>
						<th width="110" class="ac">Content Control</th>
					</tr>
					
	<!--------------------------------------------------------------------------- <Temporary Hotel List> ----------------------------------------------------------------------------------------------->				

					<c:forEach var="hotel" items="${tempHotelList}">
						<tr>
							<td><h3>
									<a
										href="hotelDetails/${hotel.getHotel_id()}/${hotel.getHotel_name()}/${hotel.getLocation()}/${hotel.getContact_no()}/${hotel.getPassword()}/" onclick="myFunction()" ><c:out
											value="${hotel.getHotel_name()}" /> </a>
								</h3></td>

							<td><c:out value="${hotel.getHotel_id()}" /></td>
							<td><a href="cancel/${hotel.getHotel_id()}/" onclick="deleteHotel()">Cancel</a>
								<a
								href="confirm/${hotel.getHotel_id()}/${hotel.getHotel_name()}/${hotel.getLocation()}/${hotel.getContact_no()}/${hotel.getPassword()}/"
								onclick="confirmHotel()">Confirm</a></td>
						</tr>
					</c:forEach>

				</table>
			</div>
		</div>
	</div>

	<span class="left">&copy; 2016 - BookMyTable.com</span>

</body>
</html>