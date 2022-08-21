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

		<table border="1">
			<tr>
				<th>Type</th>
				<th>Seats</th>
			</tr>
			<c:forEach var="type" items="${tabletypes}">
			<tr>
				<td valign="top">${type.id} </td>
				<td>${type.name}</td>
				<td>
					<a href="${page.Context.request.contextPath }/homeadmin/tabletype/edit?type=${type.id}">Edit</a>
				</td>
				<td>
					<a href="${page.Context.request.contextPath }/homeadmin/tabletype/delete?type=${type.id}">Delete</a>
				</td>
			</tr>
			</c:forEach>
			
		</table>
<h3><a href="${pageContext.request.contextPath }/homeadmin/index">Back</a></h3>
</body>
</html>