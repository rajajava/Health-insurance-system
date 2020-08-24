<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Registration Page</h1>

	<form:form action="/him/userAccReg" method="post" modelAttribute="user">
		<table>
			<tr>
				<th>First Name:</th>
				<td><form:input path="userFristName" /></td>
			</tr>
			<tr>
				<th>Last Name:</th>
				<td><form:input path="userLastName" /></td>
			</tr>
			<tr>
				<th>Email:</th>
				<td><form:input path="userEmail" />
				<font color='red'>
				<div id="dupEmail"></div>
				</font>
				</td>
			</tr>
			<tr>
				<th>Mobile:</th>
				<td><form:input path="userPhoneNo" /></td>
			</tr>
			 
			<tr>
				<th>Gender:</th>
				<td>Male:<form:radiobutton path="gender" value="M"
						id="gender" /> Female:<form:radiobutton path="gender"
						value="F" id="gender" />
				</td>
			</tr>
			<tr>
				<th>UserRole:</th>
				<td><form:select path="roleId">
						<form:option value="">-Select-</form:option>
						<form:options items="${roles}" />
					</form:select></td>
			</tr>
			 
			 

			<tr>
				<th></th>
				<td><input type="submit" value="Reset">&nbsp;<input
					type="submit" value="save"></td>
			</tr>
		</table>
	</form:form>
	 
 <script>
<%@include file="/WEB-INF/js/app.js" %>
</script>
</body>
</html>


 



