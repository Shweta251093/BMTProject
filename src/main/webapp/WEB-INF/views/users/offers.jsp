<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> Current Offers</title>
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
	
	<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/app/css/usercss/offer.css"
	type="text/css" media="all" />
<style>
.hyper {
	font-size: 50px;
    text-decoration: none;
    color: #ffffff;
}
p{
	font-size: px;

}
td.container > div { width: 100%; height: 100%; overflow:hidden; }
td.container { height: 20px; }

.italic{ 
  font-style: italic; 
  font-size: 28px;
}

table{
color: #000000;
opacity: 0.2;
}

table:hover{
opacity:10;
}
div{
opacity: 0.4;

}
div:hover {
	color:#000000;
	font-size= 50px;
    opacity: 10.0;
   
}
th{

	opacity:5;
}
td,th:hover{
 -webkit-animation: mymove 5s infinite; 
    animation: mymove 5s infinite;
}

@-webkit-keyframes mymove {
    from {background-color: #fff6e6;}
    to {background-color: #ffedcc;}
}

/* Standard syntax */
@keyframes mymove {
    from {background-color: #fff6e6;}
    to {background-color: #ffedcc;}
}


a,u{
text-decoration: none;
color: #000000;
}



.myDiv {
  width: 1000px;
  height:750px;
  overflow: scroll;
}

.wrapper {
  width: 1000px;
  height: 750px;
  overflow: hidden;
  border: 1px solid black;
}






</style>
</head>
<body>
<center>

<div class="wrapper">
<div class="myDiv">
<table>
<tbody>
<tr><th style="min-height:100px; height:100px; background-color: #fff6e6; font-size: 70px;">Offers For YOU!!!</th></tr>
<c:forEach  var="listOfOffers" items="${listOfOffers}">
<tr >

<td style="min-height:100px; height:100px; background-color: #fff6e6;">
<div><a href="userHome#wrapper">
Hello Foodies we at <span class="italic">"<c:out value="${listOfOffers.hotel_name}"/>"</span> are pleased to inform you that your favourite and our special <span class="italic">"<c:out value="${listOfOffers.food_name}"/>"</span> is being served at an unbelievable discount of  <span class="italic"><c:out value="${listOfOffers.discount}"/></span> % so HURRY UP and grab this exciting offer immediately Coz who knows,will there be a tommorow or not?!
</a></div>
</td>
</tr>


</c:forEach>
</tbody>
</table>
</div>
</div>

</center>
</body>
</html>