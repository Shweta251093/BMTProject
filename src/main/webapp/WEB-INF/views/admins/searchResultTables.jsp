<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- searchResultTables.jsp -->
<title>Table</title>

<style>

h3 {color:black;}
p {color:blue;}
th {background-color:#F5F5F5;  height:45px; font-style: italic; font-size:15; color: black;}
table, th, td {
  /*   border: 1px solid black; */
    padding: 3px;
}
table {
    border-spacing: 10px;
}



</style>



</head>
<body>

<table style="font-size: 120%; height: 35px; width: 1000px;" cellpadding="3" >


	</table>
		
		<table style="font-size: 100%;" border="1" cellpadding="2" width=920>
			<tr>
				<th>CUSTOMER ID</th>
				<th>BOOKING ID</th>
				<th>NAME</th>
				<th>DATE</th>
				<th>TIME</th>
				<th>NO OF SEATS</th>
				<th>MOBILE NO</th>
				<th>USER STATUS</th>
				<th>CHECK IN</th>
			</tr>
	
			<c:forEach var="list" items="${adminSearchResults}">
				<tr>
					<td><c:out value="${list.getUser_id()}" />
					</td>
					<td><c:out value="${list.getBooking_id()}" />
					</td>
					<td><c:out value="${list.getFull_name()}" />
					</td>
					<td><c:out value="${list.getBooking_date()}" />
					</td>
					<td><c:out value="${list.getBooking_time()}" />
					</td>
					<td><c:out value="${list.getNo_of_seats()}" />
					</td>
					<td><c:out value="${list.getContact_no()}" />
					</td>
					<td><c:out value="${list.getStatus()}" />
					</td>
					<td ALIGN="CENTER">
					<FONT FACE="VERDANA" SIZE="+1">
					<A HREF="${pageContext.request.contextPath}/checkIn/${list.getBooking_id()}" TITLE="To CheckIn into Hotel userID <c:out value="${list.getUser_id()}" />"  name="<c:out value="${list.getUser_id()}" />" onMouseOver="window.status=('To CheckIn into Hotel userID '); return true;" onMouseOut="window.status=(' '); return true;"><input type="button" value="ChekIn"></A></FONT>
					</td>
				</tr>
			</c:forEach>
		</table>


		

<br>
<br>
<br>

<h1 ><c:if test="${searchError!=null}"> <c:out value="${searchError}"></c:out> </c:if></h1>

	

</body>
</html>