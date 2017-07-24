<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Advance Operation</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/deleteAllPreviousBookings">DeleteAllPreviousBookings</a> 

<c:if test="${message !=null}">
   <h3> <c:out value="${message}"/></h3>
</c:if>
</body>
</html>