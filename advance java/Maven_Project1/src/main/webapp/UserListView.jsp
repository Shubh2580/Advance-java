<%@page import="in.co.rays.ctl.EditCtl"%>
<%@page import="java.util.Iterator"%>
<%@page import="in.co.rays.bean.LoginBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%@ include file="Header.jsp"%>

	<div align="center">
		<h1>User List</h1>


		<form action="list.do" method="post">
			<jsp:useBean id="bean" class="in.co.rays.bean.LoginBean" scope="request"></jsp:useBean>
			
			<input type="text" name="fname"> 
			<input type="submit" value="search" name="operation">
			<%
				Integer pageNo = (Integer) request.getAttribute("page");
			%>
			<input type="hidden" name="page" value="<%=pageNo%>">	 
			<%
				List<LoginBean> list = (List<LoginBean>) request.getAttribute("list");
				Iterator<LoginBean> it = list.iterator();
			%>



			<table border="1" style="width: 100%; border: groove;">
				<tr style="background-color: #e1e6f1e3;">

					<th style="width: 5%;">Serial No.</th>
					<th style="width: 13%;">FirstName</th>
					<th style="width: 30%;">LastName</th>
					<th style="width: 7%;">Login</th>
					<!--  <th style="width: 7%;">Password</th>-->
					<th style="width: 7%;">Gender</th>
					<th style="width: 7%;">DOB</th>
					<th style="width: 7%;">Mobile</th>
					<th style="width: 7%;">EDIT</th>
					<th style="width: 7%;">DELETE</th>

				</tr>

				<%
					int index = 0;
					while (it.hasNext()) {
						bean = it.next();
						index++;
				%>

				<tr>

					<td style="text-align: center; text-transform: capitalize;"><%=index%></td>
					<td style="text-align: center; text-transform: capitalize;"><%=bean.getFirstName()%></td>
					<td style="text-align: center; text-transform: capitalize;"><%=bean.getLastName()%></td>
					<td style="text-align: center; text-transform: capitalize;"><%=bean.getLogin()%></td>
					<!--  <td style="text-align: center; text-transform: capitalize;"><%=bean.getPassword()%></td>-->
					<td style="text-align: center; text-transform: capitalize;"><%=bean.getGender()%></td>
					<td style="text-align: center; text-transform: capitalize;"><%=bean.getDob()%></td>
					<td style="text-align: center; text-transform: capitalize;"><%=bean.getMobileNo()%></td>
					<td style="text-align: center; text-transform: capitalize;"><a
						href="edit.do?operation=edit&id=<%=bean.getId()%>">edit</a></td>
					<td style="text-align: center; text-transform: capitalize;"><a
						href="edit.do?operation=delete&id=<%=bean.getId()%>">delete</a></td>



					<%
						}
					%>
					<button style="margin-left: 10px">
						<a href="UserRegistrationView.jsp">Add</a>
					</button>
					<input type="submit" value="previous" name="operation"
						style="margin-left: 50px">
					<input type="submit" value="next" name="operation"
						style="margin-left: 50px">
			</table>
		</form>
	</div>


</body>
</html>