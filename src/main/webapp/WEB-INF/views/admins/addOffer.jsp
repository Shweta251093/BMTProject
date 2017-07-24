<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/css/adminCss/css/style.css" type="text/css" media="all" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/app/css/adminCss/css/offer.css"
	type="text/css" media="all" />
<title>Adding Offers</title>
</head>
<body>
<center>


 <%String hotel_id= (String) request.getSession().getAttribute("usernamevalue");
 %><% pageContext.setAttribute("hotel_id", hotel_id);%>
 


<div>
<h1>List of My Existing Offers</h1><br><br><br>
<table class="zebra" border=1 align="center">
<tr>
<th>Hotel Name</th>
<th>Offer Id</th>
<th>Menu Name</th>
<th>% age Discount on the Offer</th>
</tr>
<c:forEach var="listOfOffers" items="${listOfOffers}">
<c:if test="${hotel_id == listOfOffers.hotel_id}">
<c:set var="hotel_name" value="${listOfOffers.hotel_name}"/>
<tr>
<td><c:out value="${listOfOffers.hotel_name}"/></td>
<td><c:out value="${listOfOffers.offer_id}"/></td>
<td><c:out value="${listOfOffers.food_name}"/></td>
<td><c:out value="${listOfOffers.discount}"/></td>
<c:set var="offerIdCounter" value="${listOfOffers.offer_id+1}"/>
<td><a href="myOffers/${listOfOffers.hotel_id}/${listOfOffers.offer_id}/${listOfOffers.menu_id}/">Delete</a></td>
</tr>
</c:if>
</c:forEach>
</table>
</div>

<br><br><br><br><br><br><br><br><br>

<div align="center">
<h1> Adding an Offer</h1><br><br>
<table class="zebra" border=1 >
<form:form modelAttribute="offers" method="post" action="myOffers">
<tr><td>Hotel ID</td><td><form:select path="hotel_id"><option value="${hotel_id}"><c:out value="${hotel_id}" /></option></form:select>
<tr><td>Offer ID</td><td><form:select path="offer_id"><option value="${offerIdCounter}"><c:out value="${offerIdCounter}" /><option value="${1}"><c:out value="${1}" /></option></form:select></td></tr>
<tr><td>Food Name</td><td><form:select path="menu_id"><c:forEach var="listOfMenu" items="${listOfMenu}"> <c:if test="${hotel_id==listOfMenu.hotel_id}"><option value="${listOfMenu.menu_id}"><c:out value="${listOfMenu.food_name}"/></option></c:if></c:forEach></form:select></td></tr>
<tr><td>Discount %age </td><td><form:input path="discount"/></td></tr>
<tr><td></td><td colspan="2" align="center"><input type="submit" value="Add"></td></tr>
</form:form>
</table>
</div>

</center>
</body>
</html>