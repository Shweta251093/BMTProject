<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CheckIn</title>
<style type="text/css">
select {
	width:120px; 
}

</style>

</head>
<body>
	<br>
	<h2>For CheckIn Please Enter Table ID <span></span></h2>
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
		</table>
			<form action="${pageContext.request.contextPath}/checkInProcess/${checkInData.getBooking_id()}" method="post">
			     
				<table>
				<tr>
					<td>TABLE ID :<select name="table_id" class="field" >
				<!-- 	<option value="1">TABLE NO 1</option>
					<option value="2">TABLE NO 2</option>
					<option value="3">TABLE NO 3</option> -->
				     	<c:forEach items="${tableIdList}" var="tableId">
    					<option value="${tableId}">TABLE NO ${tableId}</option>
						</c:forEach> 
						</select></td>
				</tr>
				<tr>
				<td><input type="submit" name="checkInAct" class="search-submit" value="Confirm" />
				<input type="submit" name="checkInAct" class="search-submit" value="Cancel" /></td>
				</tr>
				</table>
			</form>
		</div>
</body>
</html>