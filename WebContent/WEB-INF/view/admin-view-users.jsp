
<%@page import="com.atomicity.domain.User"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table>
		<tr>
			<th>User</th>
			<th>First name</th>
			<th>Last name</th>
			<th>Email</th>
			<th>Role</th>
			<th>Blocked</th>
		</tr>
		<c:forEach items="${allUsers}" var="user">
    	<tr>      
	        <td>${user.username}</td>
	        <td>${user.firstName}</td>
	        <td>${user.lastName}</td>
	        <td>${user.email}</td>
	        <td>${user.role}</td>
	        <td>${user.blockedStr}</td>
    	</tr>
		</c:forEach>		
	</table>		
		<form action="block" method="GET">
			<input type="text" name="userToBlock" placeholder="Enter username" />
			<input type="submit" value="Block"/>
		</form>
		
		<form action="unBlock" method="GET">
			<input type="text" name="userToUnBlock" placeholder="Enter username" />
			<input type="submit" value="UnBlock"/>			
						
		</form>
</body>
</html>