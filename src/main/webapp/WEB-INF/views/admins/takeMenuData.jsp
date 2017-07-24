
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Take Menu Data</title>
<link href="http://fonts.googleapis.com/css?family=Didact+Gothic"
	rel="stylesheet" />

	<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/app/css/menucss/offer.css"
	type="text/css" media="all" />
	<style>
	form{
	text-align: center;
	}
	table,th,td {
	border: 2px solid green;
	background-color: #eeffcc;
}
	.button {
	width: 105px;
	height: 20px;
	background-image: url('tiny.gif');
	background-color: #eeffcc;
	line-height: 20px;
	padding-bottom: 2px;
	vertical-align: middle;
	font-family: "Lucida Grande", Geneva, Verdana, Arial, Helvetica,
		sans-serif;
	font-size: 13px; <!--
	font-weight: bold; -->
	text-transform: none;
	border: 1px pink;
}
	</style>
</head>

<body>
<br><br><br><br>
	<form>
		<TABLE align="center" BORDER="1">
			<TR>
				<!-- <TH>HOTEL ID</TH> -->
				<TH>MENU ID</TH>
				<TH>FOOD NAME</TH>
				<TH>VEG/NON-VEG</TH>
				<TH>CATEGORY</TH>
				<TH>RATE</TH>
			</TR>
			<c:forEach items="${menu}" var="menu">

				<tr>
					<%-- <td><c:out value="${menu.hotel_id}" /></td> --%>
					<td><c:out value="${menu.menu_id}" /></td>
					<td><c:out value="${menu.food_name}" /></td>
					<td><c:out value="${menu.veg}" /></td>
					<td><c:out value="${menu.category}" /></td>
					<td><c:out value="${menu.rate}" /></td>
				</tr>
			</c:forEach>
		</TABLE>
	</form><br>
	<form action="insertNewMenu">
		<input type="Submit" align="center" class="button" value="Insert Menu">
	</form><br>
	
<form action="updateMenu2">
		<button type="submit" align="center" class="button">Update Price</button>
	</form><br>
	<%-- <form action="redirect:/homeAdminView">
		<button type="submit" align="center" class="button">Home</button>
	</form> --%>
</body>
</html>
