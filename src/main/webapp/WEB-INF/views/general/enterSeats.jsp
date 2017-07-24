<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Register Seats</title>
<link href="http://fonts.googleapis.com/css?family=Didact+Gothic"
	rel="stylesheet" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/app/css/menucss/offer.css"
	type="text/css" media="all" />
<style>
table,th,td {
	border: 2px solid green;
	background-color: #eeffcc;
}

.button {
	font: bold 11px Arial;
	text-decoration: none;
	background-color: #EEEEEE;
	color: #333333;
	padding: 2px 6px 2px 6px;
	border-top: 1px solid #CCCCCC;
	border-right: 1px solid #333333;
	border-bottom: 1px solid #333333;
	border-left: 1px solid #CCCCCC;
}
</style>
</head>
<body>



	<center>

		<!-- 	Get the admin email id from session -->

		<%
			String adminName = (String) request.getSession().getAttribute(
					"adminvalue");
		%>



		<form:form action="enterseats" method="post" modelAttribute="seats">

			<h2>${status }</h2>

			<h2>Seats Registration Form</h2>



			<table>
				<tr>
					<td>Email Id:</td>
					<td><form:label path="hotel_id"><%=adminName%></form:label></td>
				</tr>

				<tr>
					<td>No. of Seats:</td>
					<td><form:input path="no_of_seats" /></td>
					<td><form:errors path="no_of_seats" cssclass="error"></form:errors></td>

				</tr>

				<tr>
					<td>Date :</td>
					<td><form:select path="booking_date" items="${dateList}" /></td>
				</tr>

				<tr>
					<td>Time :</td>
					<td><form:input path="booking_time" /></td>					
					<td><h6>Must be between 10 and 22(24 Hour Format)</h6></td>
					<td><form:errors path="booking_time" cssclass="error"></form:errors></td>
				</tr>

			</table>

			<input type="submit" name="submit" value="Register" class="button"></input>
		</form:form>
		<br />
		<form action="homeAdminView">
			<input type="submit" value="Return to Main Page" class="button" />
		</form>

	</center>



</body>
</html>