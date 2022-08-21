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
	<h3>
		<a
			href="${pageContext.request.contextPath }/homeadmin/tabletype/create">New
			Table Type</a>
	</h3>

	<s:form method="post" modelAttribute="restauranttable"
		action="${pageContext.request.contextPath }/homeadmin/table/edit">
		<h3>Seats</h3>
		<br>
		<s:input path="seat" />
		<br>
		<select name="tabletypeid">
			<c:forEach var="type" items="${tabletypes }">
				<c:choose>
					<c:when test="${type.id == restauranttable.tabletype.id }">
        				<option value="${type.id }" selected>${type.name }</option>
					</c:when>
					<c:otherwise>
      					<option value="${type.id }">${type.name }</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select>
		<td>&nbsp;</td>
		<td><input type="submit" value="save"></td>
		<s:hidden path="id"></s:hidden>
	</s:form>


</body>
</html>