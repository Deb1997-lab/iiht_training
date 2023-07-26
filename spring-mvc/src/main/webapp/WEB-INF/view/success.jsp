<%@page import="org.example.model.Employee"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success Page</title>
</head>
<body>

	Hello ${emp.empName }<br/>
	Your age is ${emp.empAge }</br>
	<a href="http://localhost:8081/spring-mvc"> goto main page</a>
</body>
</html>