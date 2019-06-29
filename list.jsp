<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Vendor List</h3>
	<h4>${sessionScope.status}</h4>
	<h4>  ${sessionScope.dltd_id}</h4>
	
	<table style="background-color: cyan; margin: auto;">
		<c:forEach var="v" items="${requestScope.vendor_list}">

			<tr>
				<td>${v.name}</td>
				<td>${v.email}</td>
				<td>${v.city}</td>
				<td>${v.phoneNo}</td>
				<td><a href="<spring:url value='/admin/update?id=${v.id}'/>">Update</a></td>
				<td><a href="<spring:url value='/admin/delete?id=${v.id}'/>">Delete</a></td>

			</tr>
		</c:forEach>
	</table>
	<h5>
		<a href="<spring:url value='/admin/add'/>">Add New Vendor</a>
	</h5>

</body>
</html>