<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8" />
<title>BookMyTable</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/app/css/adminCss/css/style.css"
	type="text/css" media="all" />
<!--[if lte IE 6]><link rel="stylesheet" href="css/ie6.css" type="text/css" media="all" /><![endif]-->

<meta name="keywwords"
	content="Shop Around - Great free html template for on-line shop. Use it as a start point for your on line business. The template can be easily implemented in many open source E-commerce platforms" />
<meta name="description"
	content="Shop Around - Great free html template for on-line shop. Use it as a start point for your on line business. The template can be easily implemented in many open source E-commerce platforms" />

<!-- JS -->
<script
	src="${pageContext.request.contextPath}/resources/app/css/adminCss/js/jquery-1.4.1.min.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/resources/app/css/dminCss/js/jquery.jcarousel.pack.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/resources/app/css/dminCss/js/jquery-func.js"
	type="text/javascript"></script>
<!-- End JS -->


<script>
	function showDate() {
		var searchSelect = document.searchForm.searchSelect;
		var dateDropdown = document.searchForm.date;
		var inputeKey = document.searchForm.key;
		if (searchSelect.selectedIndex == 1) {
			dateDropdown.style.visibility = "visible";
			inputeKey.style.visibility = "hidden";
		} else {
			inputeKey.style.visibility = "visible";
			dateDropdown.style.visibility = "hidden";
		}
	}
</script>
<script>
function onContact(){
	alert("Hello !! For any queries regarding BookMyTable mail us at queries@bookmytable.com and we will try to get back to you as early as possible.");
	
}
</script>
</head>
<body>

	<!-- Shell -->
	<div class="shell">

		<!-- Header -->
		<div id="header">
			<h1 id="logo">
				<a href="#">BookMyTable</a>
			</h1>

			<!-- Cart -->
			<div id="cart">

				<%
					String username = (String) request.getSession().getAttribute(
							"usernamevalue");
				%>



				<a href="#" class="cart-link">User Id : <%=username%></a> <br>
				<a href="${pageContext.request.contextPath}/logout" class="cart-link">Log Out</a>

			</div>
			<!-- End Cart -->

			<!-- Navigation -->
			<div id="navigation">
				<ul>
					<li><a href="${pageContext.request.contextPath}/homeAdminView"
						class="active">Home</a></li>
					<li><a href="${pageContext.request.contextPath}/takeMenuData">My Menu</a></li>
					<li><a href="${pageContext.request.contextPath}/menuDisplay">Take Order</a></li>
					<li><a href="${pageContext.request.contextPath}/customerBill">Billing</a></li>
					<li><a href="${pageContext.request.contextPath}/seatsDisplay">Seats</a></li>
					<li><a href="${pageContext.request.contextPath}/enterseats">Register Seats</a></li>
					<li><a href="myOffers">My Offers</a></li>
					<li><a href="#" onclick="onContact()">Contact</a></li>

				</ul>
			</div>
			<!-- End Navigation -->
		</div>
		<!-- End Header -->

		<!-- Main -->
		<div id="main">
			<div class="cl">&nbsp;</div>

			<!-- Content -->
			<div id="content">

				<!-- Content Slider -->
				<div id="mainslider" class="mainbox">
					<div id="mainslider-holder">
						<jsp:include page="/WEB-INF/views/${containtPage}" />

					</div>

				</div>


			</div>
			<!-- End Content -->

			<!-- Sidebar -->
			<div id="sidebar">

				<!-- Search -->
				<div class="box search">
					<br> <br>
					<h2>
						Search by <span></span>
					</h2>
					<div class="box-content">
						<form:form name="searchForm"
							action="${pageContext.request.contextPath}/searchOperation"
							method="post">



							<select name="searchSelect" class="field" onchange="showDate()">
								<option value="selectOption">-- Select Search Option --</option>
								<option value="date">Date</option>
								<option value="bookingID">Booking ID</option>
								<option value="userID">User ID</option>
							</select>

							<label>Keyword</label>
							<input type="text" name="key" class="field" />

							<select name="date" class="field">
								<c:forEach items="${dateList}" var="date">
									<option value="${date}">${date}</option>
								</c:forEach>
							</select>

							<input type="submit" class="search-submit" value="Search" />

							<p>
								<a href="${pageContext.request.contextPath}/advanceOperation" class="bul">Advanced Operation</a><br />

							</p>

						</form:form>
					</div>
				</div>
				<!-- End Search  -->

				<!--Hotel Tables -->
				<div class="box categories">


					<jsp:include page="/WEB-INF/views/${sidebarPage}" />


				</div>
				<!--End Hotel Tables -->

			</div>
			<!-- End Sidebar -->

			<div class="cl">&nbsp;</div>
		</div>
		<!-- End Main -->



		<!-- Footer -->
		<div id="footer">
			<p class="left">
				<a href="${pageContext.request.contextPath}/homeAdminView">Home</a> <span>|</span> <a href="${pageContext.request.contextPath}/takeMenuData">My Menu</a> <span>|</span>
				<a href="${pageContext.request.contextPath}/menuDisplay">Take Order</a> <span>|</span> <a href="${pageContext.request.contextPath}/customerBill">Billing</a> <span>|</span>
				<a href="${pageContext.request.contextPath}/seatsDisplay">Seats</a> <span>|</span> <a href="#" onclick="onContact()">Contact</a>
			</p>
			<p class="right">
				&copy; 2016 BookMyTable. Design by <a href="#" target="_blank"
					title="BookMyTable">BookMyTable.com</a>
			</p>
		</div>
		<!-- End Footer -->

	</div>
	<!-- End Shell -->


</body>
</html>