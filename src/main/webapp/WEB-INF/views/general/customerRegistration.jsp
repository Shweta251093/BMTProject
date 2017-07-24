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
<title>Customer Registration</title>
</head>
<body>



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

					<!--Link for new hotel Registration -->

					<li><a href="hotelRegistration" accesskey="2" title="">Register
							New hotel</a></li>

					<!--Link for new  user Registration -->

					<li><a href="customerRegistration" accesskey="3" title="">Register
							New user</a></li>

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


				<!-- --------------------------------------------------------------------Displaying Form-------------------------------------------------------------->


				<center>
					<form:form action="customerRegistration" method="post"
						modelAttribute="users">

						<h2>Customer Registration Form</h2>


						<table>
							<tr>
								<td>Email Id:</td>
								<td><form:input path="user_id" /></td>
								<td><form:errors path="user_id" cssclass="error"></form:errors></td>
							</tr>

							<tr>
								<td>Full Name:</td>
								<td><form:input path="full_name" /></td>
								<td><form:errors path="full_name" cssclass="error"></form:errors></td>
							<tr>
								<td>Contact No. :</td>
								<td><form:input path="contact_no" /></td>
								<td><form:errors path="contact_no" cssclass="error"></form:errors></td>
							</tr>

							<tr>
								<td>Password:</td>
								<td><form:password path="password" /></td>
								<td><form:errors path="password" cssclass="error"></form:errors></td>
							</tr>

						</table>

						<br>
						<br>

						<input type="submit" name="submit" value="Register">

					</form:form>
					
					
				</center>

			</div>
		</div>
	</div>




</body>
</html>