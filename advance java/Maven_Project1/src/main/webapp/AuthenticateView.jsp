<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Authenticate User</title>
</head>
<body>

	<h1>Congratulations....!!!!</h1>
	<%
		String user = (String) request.getAttribute("user");
		RequestDispatcher rd = request.getRequestDispatcher("Header.jsp");
		request.setAttribute("user", user);
		rd.forward(request, response);
	%>
	Hiii.....
	<%=user%>
</body>
</html>