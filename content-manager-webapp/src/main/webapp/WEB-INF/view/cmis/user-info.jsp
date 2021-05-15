<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>First name : ${connectedPerson.firstName}</p>
	<p>Last name : ${connectedPerson.lastName}</p>
	<p>User name : ${connectedPerson.userName}</p>
	<p>Date of birth : ${connectedPerson.dateOfBirth}</p>
</body>
</html>