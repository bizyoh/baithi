<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Login</h3> ${msg }
	<form method="post"
		action="${pageContext.request.contextPath }/account/processLogin">
		username <input type="text" name="username"> <br>
		password <input type="password" name="password"> <br> 
		<input type="submit" value="Login">
		<a href="${pageContext.request.contextPath }/account/register">register</a>

	</form>
</body>
</html>