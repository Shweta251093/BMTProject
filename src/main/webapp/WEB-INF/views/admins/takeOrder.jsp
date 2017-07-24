
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Take Order</title>


<link href="http://fonts.googleapis.com/css?family=Didact+Gothic"
	rel="stylesheet" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/app/css/menucss/offer.css"
	type="text/css" media="all" />
<style>
.button {
	width: 205px;
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
<%
          String table_id=(String) request.getSession().getAttribute("takeOrder1_table_id");
	String hotel_id = (String) request.getSession().getAttribute(
			"usernamevalue");
          %>
	<script type="text/javascript">
		function checkMenu() {
			//alert("pooja"); 
			for (count = 0; count < 5; count++) {

				if (myForm.select[count].checked) {

					var abc = myForm.select[count].value;
					var xyz = myForm.quantity[count].value;

					alert("u ordered" + abc + "quantity" + xyz);
					break;

				} else {
					alert("Select atleast one menu and its quantity");
					break;
				}

			}

		}
	</script>

	<form name="myForm" onsubmit="getCheckboxValues(this); return false;"
		action="takeOrder1">
		<br> <br> <br> <br> <br> <br>
		<center>
	table ID:<%=table_id%><br><br>
	hotel Id:<%=hotel_id%><br><br>
	</center>
		<TABLE align="center" BORDER="1">


			<h2 align="center">SELECT YOUR DISH</h2>
			<TR>

				<TH>MENU ID</TH>
				<TH>FOOD NAME</TH>


				<TH>RATE</TH>
				<TH>SELECT MENU</TH>
				<TH>quantity</TH>
			</TR>

			<c:forEach items="${data}" var="menu">

				<tr>

					<td><c:out value="${menu.menu_id}" /></td>

					<td><c:out value="${menu.food_name}" /></td>


					<td><c:out value="${menu.rate}" /></td>
					<td><input type="checkbox" name="select"
						value="${menu.menu_id}"><br></td>
					<td><input type="text" name="quantity" value="null" /></td>

				</tr>
			</c:forEach>

		</TABLE>

		<div style="text-align: center">
			<br> <input type="button" value="show order"
				onclick="checkMenu()" class="button" /> <input type="submit"
				value="Insert Order" class="button">
		</div>
	</form>

	<form action="showOrderTable">
		<div style="text-align: center">
			<br> <input type="submit" value="SHOW ORDER TABLE"
				class="button">

		</div>
	</form>





</body>
</html>
