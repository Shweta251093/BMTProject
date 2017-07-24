
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="http://fonts.googleapis.com/css?family=Didact+Gothic"
	rel="stylesheet" />

	<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/app/css/menucss/offer.css"
	type="text/css" media="all" />
<style>
table,th,td {
	border: 2px solid green;
	colour: red;
	background-color: #eeffcc;
    margin: 0px auto;
}

th,td {
	width: 100px;
	height: 40px;
}
</style>
<style>
/* div {
    background-color: lightgrey;
    width: 150px;
    padding: 25px;
    border: 15px solid navy;
    margin: 5px;
}
 */
.dropbtn {
	background-color: #4CAF50;
	color: white;
	padding: 16px;
	font-size: 16px;
	border: none;
	cursor: pointer;
}

.dropbtn:hover,.dropbtn:focus {
	background-color: #3e8e41;
}

.dropdown {
	position: relative;
	display: inline-block;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f9f9f9;
	min-width: 160px;
	overflow: auto;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
}

.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

.dropdown a:hover {
	background-color: #f1f1f1
}

.show {
	display: block;
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
.heading {
	font-size: 18px;
	color: white;
	font: bold;
	background-color: orange;
	border: thick;
}
</style>


<title>Menu Display</title>
</head>
<body>
	<form action="menuDisplay" method="GET">
		<br>
		<br>
		<br>
		<center>
		<TABLE align="right" BORDER="1">
			<h2 >MENU DISPLAY</h2>
			<TR>
				<TH>HOTEL ID</TH>
				<TH>MENU ID</TH>
				<TH>FOOD NAME</TH>

				<TH>VEG/NON-VEG</TH>
				<TH>CATEGORY</TH>
				<TH>RATE</TH>

			</TR>
			<c:forEach items="${data}" var="menu">

				<tr>
					<td><c:out value="${menu.hotel_id}" /></td>
					<td><c:out value="${menu.menu_id}" /></td>

					<td><c:out value="${menu.food_name}" /></td>

					<td><c:out value="${menu.veg}" /></td>
					<td><c:out value="${menu.category}" /></td>
					<td><c:out value="${menu.rate}" /></td>

				</tr>
			</c:forEach>

		</TABLE>
		</center>
	</form>
	<form action="takeOrder">
	<center>
	
		<div style="text-align: center">
			 TABLE ID :<select
				name="table_id">
				<c:forEach items="${listOfTableBook}" var="tableId">
					<option value="${tableId.getTable_id()}">TABLE NO
						${tableId.getTable_id()}</option>
				</c:forEach>
			</select>

		</div>
		<br>
		<div style="text-align: center">
			<br> <input type="submit" value="TakeOrder"
				style="height: 30px; width: 90px" class="button" />
		</div>
		
		</center>
	</form>

</body>
</html>