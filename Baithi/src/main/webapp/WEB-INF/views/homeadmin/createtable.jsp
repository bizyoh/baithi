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
<h3>Wecome Admin</h3>
<h3><a href="${pageContext.request.contextPath }/homeadmin/tabletype/create">New Table Type</a></h3>

	<s:form method="post"  action="${pageContext.request.contextPath }/homeadmin/table/create"  >
			<h3>Seats</h3><br>
			<input type="number" value="seat" name="seat"/><br>
			<select name="tabletypeid">
				<c:forEach var="type" items="${tabletypes }">
					<option value="${type.id }">${type.name }</option>
				</c:forEach>
			</select>
			<td>&nbsp;</td>
			<td><input type="submit" value="save"></td>
	</s:form>
</body>
</html>