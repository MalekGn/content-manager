<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Content</title>
</head>
<body>

	<ol>
		<li>show documents list :: search + button</li>
		<li>download document</li>
		<li>upload document</li>
		<li>show document and folder properties</li>
	</ol>

	<form action="content" method="get">
		<input type="search" name="item"> <input type="submit">
	</form>

	<c:forEach var="item" items="${items}">
		<p>
			<c:out value="${item}"></c:out> <input type="button" value="show info"> <input type="button" value="download">
		</p>
	</c:forEach>
</body>
</html>