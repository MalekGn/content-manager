<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="result" modelAttribute="user">
		login <form:input path="userName"/>
		<br>
		password <form:password path="password"/>
		<br><br>
		<input type="submit" value="connect"/>
	</form:form>
	
	<p style="color : red;">${errorMessage}</p>
</body>
</html>