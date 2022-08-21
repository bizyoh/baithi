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
<h3>Booking :  ${pageContext.request.userPrincipal.name }</h3>
<a href="${pageContext.request.contextPath }/homeadmin/index">Admin</a>
<hr>
<h3><a href="${pageContext.request.contextPath }/account/edit">Edit Profile</a></h3>
<hr>
<h3><a href="${pageContext.request.contextPath }/home/bookinglist">Booking List</a></h3>
<hr>
<h3>Booking list</h3>
	
		<table border="1">
			<tr>
				<th>ID</th>
				<th>Type</th>
				<th>Seats</th>
			</tr>
			<c:forEach var="booking" items="${bookings }">
			<tr>
				<td valign="top">${booking.id} </td>
				<td valign="top">${booking.restauranttable.tabletype.name} </td>
				<td valign="top">${booking.restauranttable.seat} </td>
			</tr>
			</c:forEach>
			
		</table>


</body>
</html>