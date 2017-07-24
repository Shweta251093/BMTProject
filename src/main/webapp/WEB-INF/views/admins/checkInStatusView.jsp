<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<br>
	<h2>CheckIn Successful..!!! <span></span></h2>
		<div class="box-content">
		<table >
				<tr>
					<td>BOOKING ID : <c:out value="${checkInData.getBooking_id()}"/></td>
				</tr>
				<tr>
					<td>USER ID : <c:out value="${checkInData.getUser_id()}" /></td>
				</tr>
				<tr>
					<td>FULL NAME : <c:out value="${checkInData.getFull_name()}" /></td>
				</tr>
				<tr>
					<td>BOOKING DATE : <c:out value="${checkInData.getBooking_date()}" /></td>
				</tr>
				<tr>
					<td>BOOKING TIME : <c:out value="${checkInData.getBooking_time()}" /></td>
				</tr>
				<tr>
					<td>NO OF SEATS : <c:out value="${checkInData.getNo_of_seats()}" /></td>
				</tr>
				<tr/>
				<tr/>
				<tr><td style="color:Blue;">TABLE NO: ${table_id}</td></tr>
			</table>
			<form action="${pageContext.request.contextPath}/checkInProcessOk" method="get">
			     
				<table>
				<tr>
				</tr>
				<tr>
				<td/>
				<td><input type="submit" name="checkInActOk" class="search-submit" value="Ok" />
				</tr>
				</table> 
			</form>
		</div>
</body>
</html>