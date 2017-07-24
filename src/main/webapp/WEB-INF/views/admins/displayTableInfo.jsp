<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>diplayTableInfo</title>
</head>
<body>
<br>
	<h2>Hotel Table Information..!!! <span></span></h2>
	<br>
	<h2 style="color:blue;">TABLE NO :  ${table_id}<span></span></h2>
	<br>
		<div class="box-content">
		<table >
				<tr>
					<td>BOOKING ID : <c:out value="${tableInfo.getBooking_id()}"/></td>
				</tr>
				<tr/>
				<tr>
					<td>USER ID : <c:out value="${tableInfo.getUser_id()}" /></td>
				</tr>
				<tr/>
				<tr>
					<td>FULL NAME : <c:out value="${tableInfo.getFull_name()}" /></td>
				</tr>
				<tr/>
				<tr>
					<td>CONTACT NO : <c:out value="${tableInfo.getContact()}" /></td>
				</tr>
				<tr/>
				<tr>
					<td>NO OF SEATS : <c:out value="${tableInfo.getNo_of_seat()}" /></td>
				</tr>
				<tr/>
				<tr/>
			</table>
			<form action="${pageContext.request.contextPath}/diplayTableInfoOk" method="get">
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