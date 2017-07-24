<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form>
<TABLE align="center" BORDER="1">
            <TR>
                <TH>Hotel Name</TH>
                <TH>Location</TH>
                <TH>Contact_No.</TH>
               
                <TH>No. of Seats</TH>
                <TH>Date</TH>
                 <TH>Time</TH>
                
          </TR>
 <c:forEach items="${listHotel}" var="findtable">

       <tr>
       <td><c:out value="${findtable.hotel_name}" /></td>
          <td><c:out value="${findtable.location}" /></td>
           
         <td><c:out value="${findtable.contact_no}" /></td>
       
         <td><c:out value="${findtable.no_of_seats}" /></td>
         <td><c:out value="${findtable.booking_date}" /></td>
           <td><c:out value="${findtable.booking_time}" /></td>
           
        </tr>
       </c:forEach>
       </TABLE>
</form>
</body>
</html>