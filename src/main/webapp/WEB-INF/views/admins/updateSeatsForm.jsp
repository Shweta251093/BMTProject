<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Menu</title>
<style type="text/css">
form{
text-align: center;
}
</style>
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
<%
							String username=(String)request.getSession().getAttribute("usernamevalue");
						
						%>
						
						
<table>
 <form action="updateSeatsForm123" method="get">
    	HOTEL ID:<%=username%><br><br>
    	DATE<input type="text" name="date" value="${date}" /><br><br>
    	TIME SLOTS<!-- <input type="text" name="timeslots" placeholder="Destination" required/> -->
    	<select name="time" class="field">
		<option value="10:00:00">10:00:00</option>
		<option value="11:00:00">11:00:00</option>
		<option value="12:00:00">12:00:00</option>
		<option value="13:00:00">13:00:00</option>
		<option value="14:00:00">14:00:00</option>
		<option value="15:00:00">15:00:00</option>
		<option value="16:00:00">16:00:00</option>
		<option value="17:00:00">17:00:00</option>
		<option value="18:00:00">18:00:00</option>
		<option value="19:00:00">19:00:00</option>
		<option value="20:00:00">20:00:00</option>
		<option value="21:00:00">21:00:00</option>
		<option value="22:00:00">22:00:00</option>
	
	    </select><br><br>
    	NEW SEATS:<input type="text" name="newseats" placeholder="Seats" required/>
    	<br><br>
    	
    	<h1></h1>
    	
        <button type="submit" >Submit</button>
        
    </form> 
</table>



























<%-- /*<form:form action="updateSeatsForm" method="post" modelAttribute="seats">
<table>
			<tr>
				<td>HOTEL ID:</td>
				<td>${user.id}</td>
				<td>HOTEL ID:</td>
				<td><form:input path="hotel_id" />
				<form:errors path="hotel_id" cssclass="error"></form:errors></td>
			</tr>
			<tr>
				<td>DATE:</td>
				<td><form:input path="booking_date" />
				<form:errors path="booking_date" cssclass="error"></form:errors></td>
			</tr>
			<tr>
				<td>TIME SLOT:</td>
				<td><form:input path="booking_time" />
				<form:errors path="booking_time" cssclass="error"></form:errors></td>
			</tr>

			
			<tr>
				<td>NEW SEATS:</td>
				<td><form:input path="no_of_seats" />
				<form:errors path="no_of_seats" cssclass="error"></form:errors></td>
			</tr>
			
			
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Submit" /></td>
			</tr>
		</table>
</form:form> */ --%>
</body>
</html>