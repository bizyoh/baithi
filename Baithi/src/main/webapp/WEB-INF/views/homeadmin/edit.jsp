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
	<h3>Edit</h3>
	<s:form method="post"  modelAttribute="tabletype"
		action="${pageContext.request.contextPath }/homeadmin/edit">
		<table>
			
			<tr>
				<td>Name</td>
				<td><s:input type="password" name="password" /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="save"></td>
			</tr>
		</table>
	</s:form>

</body>
</html>