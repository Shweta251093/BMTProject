<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Home page for bookMyTable</title>
<link rel="stylesheet"
    href="${pageContext.request.contextPath}/resources/app/css/styles.css">
</head>
<body>
home page!!
    <div id="wrapper">
    	<%if(request.getParameter("dbconnectSuccess") != null) {%>
    	<h1>DB Connected</h1>
    	<%} %>
    	
        <h1>Hello!</h1>
        <p>The time on the server is ${serverTime}.</p>
        <p><a href="dbConnectCheck">Check DB Connection</a></p>
    </div>
</body>
</html>
