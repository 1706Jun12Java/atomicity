<%@page import="com.atomicity.domain.Users"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account</title>
    <link rel="stylesheet" href="css/normalize.css"/>
    <link rel="stylesheet" href="css/mystyle.css"/>
</head>
<body>
	<%
		Users user = (Users) session.getAttribute("user");
		System.out.println(user);
		String firstname = user.getFirstName();
		String lastname = user.getLastName();
		String fullname = firstname + " " + lastname;	
	%>
	<h1>Welcome to forum <%= fullname %></h1>
</body>
</html>