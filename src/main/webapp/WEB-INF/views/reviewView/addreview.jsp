<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>	Add Review and rating</title>
<style>
body {
	font-size: 20px;
	color: teal;
	font-family: Calibri;
}

td {
	font-size: 15px;
	color: black;
	width: 100px;
	height: 22px;
	text-align: center;
}


h3 {color:orange;}
h3 {color:orange;}
td
{
    padding:0 25px 0 15px;
}
table tr td:empty {
    width: 50px;
}

table tr td {
    padding-top: 10px;
    padding-bottom: 30px;
}
</style>
</head>
<body>
	<center>

<form:form action="reviews"  modelAttribute="history"  method="get">
 <h1> User Id : ${usernamevalue } </h1>
 <br>
 
	<h3>Booking Id</h3><form:input path="booking_id" size="20"/>
	<br>
	<br>	   	
	<table  border="1">
		
		
		
		  <%-- <form:input path="user_id" size="10" > ${usernamevalue }</form:input> --%>
		 <%--  <form:label path="user_id">${usernamevalue }</form:label> --%>
		 
		 
		            	<tr>
                        <td><h3>Add your review:</h3><form:input path="reviewText" size="100"/></td>
                         <td><h3>Add your rating:</h3><form:input path="ratingText" size="10"/></td>
                       </tr>       
                            
	
		<tr>
			
			<%-- <td> 
				<form:select path="ratings.colorCode">
            		<form:option value="" label="--Please Select"/>
            		<form:options items="${rateList}" itemValue="colorCode" itemLabel="ratingNumber"/>
        		</form:select>
			</td> --%>
		</tr>		
		
	</table>
<br>

		
				<input type="submit" value="Submit" />	
			
		
</form:form>
 </center>
</body>
</html>