<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="http://fonts.googleapis.com/css?family=Didact+Gothic"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/resources/app/css/usercss/default.css"
	rel="stylesheet" type="text/css" media="all" />
<link
	href="${pageContext.request.contextPath}/resources/app/css/usercss/fonts.css"
	rel="stylesheet" type="text/css" media="all" />
<title>User Details</title>



</head>
<body>


	    <form:form action="user" method="post" modelAttribute="loginBean">                                    <!-- instantiating a Java object and making it available -->
		<div id="header-wrapper">
		<div id="header" class="container">
		<div id="logo">
		<h1>
		<a href="#">BookMyTable</a>
		</h1>
		</div>
		<div id="menu">
		<ul>
		<li class="active"><a href="#" accesskey="1" title="">Homepage</a></li>
		<li><a href="hotelRegistration" accesskey="2" title="">Register New hotel</a></li>                     <!--Link for new hotel Registration -->
		<li><a href="customerRegistration" accesskey="3" title="">Register New user</a></li>                   <!--Link for new  user Registration -->
		
        </ul>
	    </div>
		</div>
		<div id="banner-wrapper">
	    <div id="banner" class="container">
		<div class="title">
	    <h2>Book My Table</h2>
		<span class="byline">Opening Hour 10:00 AM - 10:00 PM.</span>
		</div>
        </div>
	    </div>
		</div>
		<div id="wrapper">
		<div id="three-column" class="container">
		<div id="header" class="container">
		
 <!-- --------------------------------------------------------------------Displaying Form-------------------------------------------------------------->		
	    <center>
        <table >

		<tr>
		<td>Email ID:</td>
		<td><form:input path="username" class="resizedTextbox" />
		<form:errors path="username" cssclass="error"></form:errors></td>
		</tr>
        <tr>
		<td>Password:</td>
		<td><form:password path="password" class="resizedTextbox" />
		<form:errors path="password" cssclass="error"></form:errors></td>
		</tr>
		<tr>
		<tr>
		<td></td>
		<td colspan="2" align="center">
		<input type="submit" value="Submit" class="resizedTextbox" /></td>
		</tr>
		<tr>
		<tr>
		<td></td>
		<td>${message}</td>
	    </table>
        </center>
        
		</div>
	    </div>
		</div>
	    </form:form>
	

</body>
</html>