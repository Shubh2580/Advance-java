<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Header</title>
</head>
<body>
	<center>
		<img src="logo.png">
	</center>
	<%
		String user = (String) session.getAttribute("user");
		if (user == null) {
			out.println("Hiii, Guest");
	%>


	<a href="UserRegistrationView.jsp">Sign-up</a>
	<%
		} else {
	%>
	Hiii,
	<%=user%>

	<a href="index.jsp">Index</a> |
	<a href="list.do">User List</a> |
	<a href="LoginView.jsp">Login</a> |
	<a href="LogoutView.jsp">Logout</a>

	<%
		}
	%>
	<hr>
</body>
</html>