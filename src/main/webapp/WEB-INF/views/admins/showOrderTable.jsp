<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show Order Table</title>
<link href="http://fonts.googleapis.com/css?family=Didact+Gothic"
	rel="stylesheet" />

	<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/app/css/menucss/offer.css"
	type="text/css" media="all" />
<style>
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
table,th,td {
	border: 2px solid green;
	background-color: #eeffcc;
}

th,td {
	width: 100px;
	height: 40px;
}
</style>
</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<%
          String table_id=(String) request.getSession().getAttribute("takeOrder1_table_id");
	String hotel_id = (String) request.getSession().getAttribute(
			"usernamevalue");
          %>
	<form action="homeview">
	<center>
	table ID:<%=table_id%><br><br>
	hotel Id:<%=hotel_id%><br><br>
	</center>
		<TABLE align="center" BORDER="1">

			<h2 align="center">ORDERED MENU</h2>

			<TR>

				
				<TH>MENU_ID</TH>

				<TH>QUANTITY</TH>
				<TH>STATUS</TH>

			</TR>
			
			<c:forEach items="${orderList}" var="order">

				<tr>

					<%-- <td><c:out value="${order.hotel_id}" /></td> --%>

					<td><c:out value="${order.menu_id}" /></td>

					<td><c:out value="${order.quantity}" /></td>
					<td><c:out value="${order.status}" /></td>

				</tr>
			</c:forEach>

		</TABLE>
		<br>
		<br>
		<div style="text-align: center">
			<input type="submit" value="home" class="button">
		</div>
	</form>
</body>
</html>