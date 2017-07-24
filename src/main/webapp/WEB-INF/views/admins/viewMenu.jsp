<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Menu</title>
</head>
<body>
<form action="insertNewMenu.jsp">
<TABLE align="center" BORDER="1">
            <TR>
                <TH>HOTEL ID</TH>
                <TH>MENU ID</TH>
                <TH>FOOD NAME</TH>
               
                <TH>VEG/NON-VEG</TH>
                <TH>CATEGORY</TH>
                 <TH>RATE</TH>
                
          </TR>
          <tr>
 <td>hyatt@gmail.com</td>
<td>NM101 </td>
<td>Chicken Handi</td>

 <td>Veg</td>
 <td>Veg Starter</td>
 <td>250 </td>
 
 </tr> 
          </TABLE>
         <button type="submit" class="btn btn-primary btn-block btn-large">Insert New Menu</button>
         </form>
          <form action="updateMenu.jsp"><button type="submit" class="btn btn-primary btn-block btn-large">Update Rate</button></form>
</body>
</html>