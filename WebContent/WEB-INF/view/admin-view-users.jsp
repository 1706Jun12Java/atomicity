
<%@page import="com.atomicity.domain.User"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Users</title>
<c:url value="/resources/css/normalize.css" var="normalize" />
<c:url value="/resources/css/mystyle.css" var="mystyle" />
<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" var="bootstrap" />
<link rel="stylesheet" href="${normalize}" />
<link rel="stylesheet" href="${bootstrap}" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
<link rel="stylesheet" href="${mystyle}" />
</head>
<body>
<c:url value="/resources/img/atomlogobar.png" var="logoInBar" />

	<%
		User user = (User) session.getAttribute("user");
	%>
	<!-- NAVIGATION BAR --> 
	<header> 
		<nav class="navbar bg-inverse navbar-inverse navbar-toggleable-sm">
			<div class="container">
				<a class="navbar-brand" href="/Atomicity/"> 
				<img id="logoImg" src="${logoInBar}" alt="atomicity logo" style="width: 80px;" /> 
				<%=user.getUsername()%>
				</a>
				<div class="navbar-nav">
					<a class="nav-item nav-link" href="/Atomicity/">Community</a>
					<a class="nav-item nav-link active" href="/Atomicity/profile">Profile</a> 
					<a class="nav-item nav-link" href="/Atomicity/addTopicPage">Submit a Topic</a>
					<a class="nav-item nav-link" href="/Atomicity/mailbox">Mailbox</a>
					<a class="nav-item nav-link" href="/Atomicity/logout">Logout</a>
				</div>
			</div>
		</nav> 
	</header>
	<table class="table-fill">
		<thead>
			<th class="text-left">User</th>
			<th class="text-left">First name</th>
			<th class="text-left">Last name</th>
			<th class="text-left">Email</th>
			<th class="text-left">Role</th>
			<th class="text-left">Blocked</th>
		</thead>
		<tbody class="table-hover">
		<c:forEach items="${allUsers}" var="user">
    	<tr>      
	        <td class="text-left">${user.username}</td>
	        <td class="text-left">${user.firstName}</td>
	        <td class="text-left">${user.lastName}</td>
	        <td class="text-left">${user.email}</td>
	        <td class="text-left">${user.role}</td>
	        <td class="text-left">${user.blockedStr}</td>
    	</tr>
		</c:forEach>
		</tbody>
	</table>
		<div class="login-page form-control float-left semi-transp">
		  <div class="form">
		    <form class="login-form" action="block" method="POST" >
		    	<input class="form-control" type="text" name="userToBlock" placeholder="Enter username" />
				<button type="submit">Block</button>
		    </form>
		  </div>
		</div>
		
		<div class="login-page form-control float-left semi-transp">
		  <div class="form">
		    <form class="login-form" action="unBlock" method="POST" >
		    	<input class="form-control" type="text" name="userToUnBlock" placeholder="Enter username" />
				<button type="submit">UnBlock</button>
		    </form>
		  </div>
		</div>		
<!-- 		<form action="block" method="GET">
			<input type="text" name="userToBlock" placeholder="Enter username" />
			<input type="submit" value="Block"/>
		</form> -->
<!-- 		
		<form action="unBlock" method="GET">
			<input type="text" name="userToUnBlock" placeholder="Enter username" />
			<input type="submit" value="UnBlock"/>			
						
		</form> -->
</body>
</html>