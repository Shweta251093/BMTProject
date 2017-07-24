<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="http://fonts.googleapis.com/css?family=Didact+Gothic"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/resources/app/css/usercss/default.css"
	rel="stylesheet" type="text/css" media="all" />
<link
	href="${pageContext.request.contextPath}/resources/app/css/usercss/fonts.css"
	rel="stylesheet" type="text/css" media="all" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User detaails </title>
</head>
<body>
	<form:form action="user" method="post" modelAttribute="loginBean">
		<table>
			<tr>
				<td>User:</td>
				<td>${user.id}</td>
			</tr>
			<tr>
				<td>First Name:</td>
				<td><form:input path="firstName" />
				<form:errors path="firstName" cssclass="error"></form:errors></td>
			</tr>

			<tr>
				<td>Last Name:</td>
				<td><form:input path="lastName" />
				<form:errors path="lastName" cssclass="error"></form:errors></td>
			</tr>
			<tr>
				<td>Date of Birth:</td>
				
				<td>
				<spring:bind path="user.dateOfBirth">
				<input name="dateOfBirth" value="${status.value}" />
				</spring:bind>
				<form:errors path="dateOfBirth" cssclass="error"></form:errors></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Submit" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>