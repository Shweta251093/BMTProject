<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Menu</title>
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
						
						
<form:form action="updateMenuForm" method="post" modelAttribute="menu">
<table>
			<tr>
				 <td>HOTEL ID:</td>
				<td><%=username%></td> 
				<%-- <td>HOTEL ID:</td>
				<td><form:input path="hotel_id" />
				<form:errors path="hotel_id" cssclass="error"></form:errors></td> --%>
			</tr>
			<tr>
				<td>MENU ID:</td>
				<td><form:input path="menu_id" />
				<form:errors path="menu_id" cssclass="error"></form:errors></td>
			</tr>

			
			<tr>
				<td>NEW RATE:</td>
				<td><form:input path="rate" />
				<form:errors path="rate" cssclass="error"></form:errors></td>
			</tr>
			
			
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Submit" /></td>
			</tr>
		</table>
</form:form>
</body>
</html>