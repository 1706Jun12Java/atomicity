<%@page import="com.atomicity.domain.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile</title>
<c:url value="/resources/css/normalize.css" var="normalize" />
<c:url value="/resources/css/mystyle.css" var="mystyle" />
<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" var="bootstrap" />
<link rel="stylesheet" href="${normalize}" />
<link rel="stylesheet" href="${bootstrap}" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
<link rel="stylesheet" href="${mystyle}" />
</head>
<body>
	<c:url value="/resources/img/atomlogobar.png" var="logoInBar" />
	<c:url value="/resources/img/medium-profile-pic.png" var="tempPP" />
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
	
	<div class="container">
		<figure class="text-center">
			<img class="fluid" src="${tempPP}">
			<a href="">Change Profile Picture</a>			
		</figure>
		
		<div class="form-group">
			<h5 class="form-text"><b>Username: </b><%=user.getUsername()%></h5>
			<h5 class="form-text"><b>Firstname: </b><%=user.getFirstName()%></h5>
			<h5 class="form-text"><b>Lastname: </b><%=user.getLastName()%></h5>
			<h5 class="form-text"><b>Email: </b><%=user.getEmail()%></h5>		
		</div>
		
		<div class="form-group">
			<a href="/Atomicity/update">Update user info</a>
		</div>
	</div>
</body>
</html>