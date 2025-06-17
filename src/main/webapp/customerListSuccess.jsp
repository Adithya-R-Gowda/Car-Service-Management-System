<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "com.gqt.model.AddCarDetails"%>
<%@ page import = "java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		ArrayList<AddCarDetails> carList = (ArrayList)session.getAttribute("carDetails");
		for(AddCarDetails x : carList) {
			out.println(x);
		}
	%>

</body>
</html>