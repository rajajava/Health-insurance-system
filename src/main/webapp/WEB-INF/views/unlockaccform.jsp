<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta charset="ISO-8859-1">
<title>SetPassword</title>
<script type="text/javascript">

function validatePwds(){
	
	var newPwd = $('#newPazzword').val();
	var confirmPwd =$('#confirmPazzword').val();
	 if (newPwd == '') 
         alert ("Please enter NewPassword"); 
           
     // If confirm password not entered 
     else if (confirmPwd == '') 
         alert ("Please enter confirm password");
     else if(newPwd!=confirmPwd){
		$('#errId').text('New password and confirm password should be same!')
		return false;
	}
	return true;
}


</script>
</head>
<body>
<form:form action="/him/unlockUserAcc" method="post" modelAttribute="unlockAcc">

<font color='red'><span id="errId"></span></font>
		<table>
			<tr>
				<td>YourEmail:</td>
				<td><form:input path="email"/>
			</tr>
			<tr>
				<td>Enter Temporary Password:</td>
				<td><form:input path="tempPazzword"/>
				<font color='red'>
				<div id="wrongpsw"></div>
				</font>
				</td>
			</tr>
			<tr>
				<td>Enter new Password:</td>
				<td><form:input path="newPazzword"/></td>
			</tr>
			<tr>
				<td>Enter confirmm Password:</td>
				<td><form:input path="confirmPazzword"/></td>
			</tr>
			
			 			<tr>
				<td></td>
				<td><input type="submit" value="Unlock"
					onclick="javascript:return validatePwds()" /></td>
			</tr>
		</table>
	</form:form>
<script>
<%@include file="/WEB-INF/js/app.js" %>
</script>
</body>
</html>