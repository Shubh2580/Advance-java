<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>
</head>
<body>
<%@include file="Header.jsp" %>
	<form action="reg" method="post">

		<div align="center">
			<h1>USER REGISTRATION</h1>
			<table>
				<tr>
					<th>First Name :</th>
					<td><input type="text" name="fname"></td>
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
					<th>Last Name :</th>
					<td><input type="text" name="lname"></td>
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
					<th>Login :</th>
					<td><input type="text" name="login"></td>
					<td>
						<%
							String err3 = (String) request.getAttribute("err3");
							if (err3 != null) {
						%><font color="red"> <%=err3%></font> <%
 	}
 %>
					</td>
				</tr>

				<tr>
					<th>Password :</th>
					<td><input type="password" name="pwd"></td>
					<td>
						<%
							String err4 = (String) request.getAttribute("err4");
							if (err4 != null) {
						%><font color="red"> <%=err4%></font> <%
 	}
 %>
					</td>
				</tr>

				<tr>
					<th>Gender :</th>
					<td><input type="radio" name="gender" value="male">Male <input
						type="radio" name="gender" value="female">female 
						<input type="radio" name="gender" value="other">other</td>
					<td>
						<%
							String err5 = (String) request.getAttribute("err5");
							if (err5 != null) {
						%><font color="red"> <%=err5%></font> <%
 	}
 %>
					</td>
				</tr>

				<tr>
					<th>DOB :</th>
					<td><input type="date" name="dob"></td>
					<td>
						<%
							String err6 = (String) request.getAttribute("err6");
							if (err6 != null) {
						%><font color="red"> <%=err6%></font> <%
 	}
 %>
					</td>
				</tr>

				<tr>
					<th>Mob No :</th>
					<td><input type="text" name="mob"></td>
					<td>
						<%
							String err7 = (String) request.getAttribute("err7");
							if (err7 != null) {
						%><font color="red"> <%=err7%></font> <%
 	}
 %>
					</td>
				</tr>

				<!--  <tr>
					<th>Address*</th>
					<td><textarea rows="5" cols="10" type="text" name="address" ></textarea>
					</td>
					<td>
						
					</td>
				</tr>-->

				<tr>
					<th></th>
					<td><input  type="submit" value="Register" >
					<button style="margin-left:10px"><a href="LoginView.jsp" >Sign-In</a></button>
					 </td>
			
				
				</tr>

			</table>
		</div>

	</form>
	 <nav class="navbar navbar-inverse navbar-fixed-bottom">
        <div class="navbar-footer">
           <%@include file="Footer.jsp" %>
        </div>

</body>
</html>