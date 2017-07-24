<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
hello i m login!!

<div id="wrapper">
    	<%if(request.getParameter("dbconnectSuccess") != null) {%>
    	<h1>DB Connected</h1>
    	<%} %>
    	
        <h1>Hello world!</h1>
        <p>The time on the server is ${serverTime}.</p>
        <p><a href="dbConnectCheck">Check DB Connection</a></p>
    </div>
</body>
</html>