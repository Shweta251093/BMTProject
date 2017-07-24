<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Seats In Hotel</title>
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
<style type="text/css">
form.button {
	text-align: center;
}


</style>
</head>
<body>
<%
							String username=(String)request.getSession().getAttribute("usernamevalue");
						
						%>
						
						
<form>
		<Table align="center" BORDER="1">
			<TR>
				<TH>HOTEL ID</TH>
				<th>DATE</th>
				<TH>TIME SLOT</TH>
				<TH>SEATS ALLOTED</TH>
				
			</TR>
			<c:forEach items="${data}" var="data">

				<tr>
					<td><c:out value="<%=username%>" /></td>
						<td><c:out value="${data.booking_date}" /></td>
					<td><c:out value="${data.booking_time}" /></td>
					<td><c:out value="${data.no_of_seats}" /></td>
					
				</tr>
			</c:forEach>
		</Table>
	</form><br><br>
	<form action="updateSeatsFormDisplay" class="button">
		<button type="submit" align="center">Update Seats</button>
	</form>

</body>
</html>