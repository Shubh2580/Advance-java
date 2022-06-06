<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Form</title>
</head>
<body>
	<%@include file="Header.jsp"%>

	<form action="login" method="post">
		<div align="center">
			<h1>LOGIN</h1>

			<%
				String err = (String) request.getAttribute("err");

				if (err != null) {
			%><font color="red"> <%=err%></font>
			<%
				}
			%>

			<table>
				<input type="hidden" name="uri" value=<%=session.getAttribute("uri")%>>

				<tr>
					<th>Login :</th>
					<td><input type="text" name="login"></td>
					<td>
						<%
							String err1 = (String) request.getAttribute("err1");
							if (err1 != null) {
						%><font color="red"> <%=err1%></font> <%
 	}
 %>
					</td>
				</tr>
				<tr>
					<th>Password :</th>
					<td><input type="password" name="pwd" style="margin-top: 20px"></td>
					<td>
						<%
							String err2 = (String) request.getAttribute("err2");
							if (err2 != null) {
						%><font color="red"> <%=err2%></font> <%
 	}
 %>
					</td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" value="Login"
						style="margin-top: 20px; margin-left: 20px">
						<button style="margin-left: 10px">
							<a href="UserRegistrationView.jsp">Sign-Up</a>
						</button> <br> <br> <a href="ForgetPasswordView.jsp"><center
								style="margin-bottom: 250px">Forget Password</center></a></td>
				</tr>
			</table>
		</div>
	</form>
	<nav class="navbar navbar-inverse navbar-fixed-bottom">
		<div class="navbar-footer">
			<%@include file="Footer.jsp"%>
		</div>
</body>
</html>