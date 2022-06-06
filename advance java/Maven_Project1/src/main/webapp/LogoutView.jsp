<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout</title>
</head>
<body>
<%@include file="Header.jsp" %>
<%session.invalidate();
response.sendRedirect("LoginView.jsp");
%>

<center><h1>LogOut</h1></center>

 <nav class="navbar navbar-inverse navbar-fixed-bottom">
        <div class="navbar-footer">
           <%@include file="Footer.jsp" %>
        </div>

</body>
</html>