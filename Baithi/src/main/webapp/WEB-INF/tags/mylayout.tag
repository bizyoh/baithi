<%@ tag language="java" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>
<%@ attribute name="content" fragment="true"%>


<table align="center" width="800">
	<tr>
		<td colspan="1">
			<h3>Welcome ${pageContext.request.userPrincipal.name }</h3> <br>
			<a href="${pageContext.request.contextPath }/account/logout">Logout</a>
		</td>
	</tr>

	<tr>
		<td width="300" align="top">
			<ul>
				<s:authorize access="hasRole('ROLE_SUPER_ADMIN')">
					<li>Category</li>
				</s:authorize>

				<s:authorize
					access="hasRole('ROLE_SUPER_ADMIN') or hasRole('ROLE_ADMIN')">
					<li>Product</li>
				</s:authorize>

				<s:authorize
					access="hasRole('ROLE_SUPER_ADMIN') or hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYEE')">
					<li>Invoice</li>
				</s:authorize>

			</ul>
		</td>

		<td align="top"><jsp:invoke fragment="content"></jsp:invoke></td>
	</tr>

</table>
