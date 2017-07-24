<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Menu Rate</title>

<link href="http://fonts.googleapis.com/css?family=Didact+Gothic"
	rel="stylesheet" />

	<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/app/css/menucss/offer.css"
	type="text/css" media="all" />
<style>

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
<script >
/* function changeRate(){
	/* var fare = document.menuForm.fare;
	model.addAttribute("fare",fare); */
	   var lolz;
	    function onload() { 
	        lolz = document.getElementById('lolz');
	    }
	    function kk(){
	        alert(lolz.value);
	    }
	
	} */


</script>
</head>
<body onload="onload();">
	<form name="menuForm" action="/takeMenuData">
		<TABLE align="center" BORDER="1">
			<TR>
				<TH>HOTEL ID</TH>
				<TH>MENU ID</TH>
				<TH>FOOD NAME</TH>
				<TH>VEG/NON-VEG</TH>
				<TH>CATEGORY</TH>
				<TH>RATE</TH>
			</TR>
			<c:forEach items="${data}" var="data">

				<tr>
					<td><c:out value="${data.hotel_id}" /></td>
					<td><c:out value="${data.menu_id}" /></td>
					<td><c:out value="${data.food_name}" /></td>
					<td><c:out value="${data.veg}" /></td>
					<td><c:out value="${data.category}" /></td>
					<td><c:out value="${data.rate}" /></td>
					<td><input type="text" name="fare"  placeholder="New Rate"/></td>
					<td>
					<a href="updateMenu/${data.hotel_id}/${data.menu_id}/${fare }" class="button" onclick="kk();">Update</a></td>
					
						<%-- <form action="#">
							<button type="submit" value=${ data.menu_id}>Update</button>
						</form> --%>
					
					<td><a href="deleteMenu/${data.hotel_id}/${data.menu_id}/" class="button">Delete</a></td>
				</tr>
			</c:forEach>
		</TABLE>
	</form>
</body>
</html>