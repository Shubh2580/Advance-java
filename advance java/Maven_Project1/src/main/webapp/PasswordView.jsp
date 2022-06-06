<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Password</title>
</head>
<body>
	<%
		String pass = (String) request.getAttribute("pass");
	%>
	Password =
	<%=pass%>

</body>
</html>