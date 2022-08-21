<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Register</h3>

	<br>
	<s:form method="post" modelAttribute="account"
		action="${pageContext.request.contextPath }/account/register">
		<table>
			<tr>
				<td>UserName</td>
				<td><s:input path="username" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><s:password path="password" /></td>

			</tr>
		
		
	
			<tr>
				<td>&nbsp;</td>
				<td>
					<input type="submit" value="save" />
					<br>
					<a href="${pageContext.request.contextPath }/account/login">Login</a>
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>