<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	out.println("Dear, " + session.getAttribute("username") + " please Select the below Services");
	%>
	<br> <br>
	<a href = "addCarDetails.html">Add car details</a>
	<a href = "requestService.html">Request for a service</a>
	<a href = "ServiceStatus">Check service status</a>
	<a href = "">Logout</a>
</body>
</html>