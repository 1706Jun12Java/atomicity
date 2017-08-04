<%@page import="com.atomicity.domain.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Account | Atomicity</title>
<link rel="stylesheet" href="resources/css/normalize.css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
<link rel="stylesheet" href="resources/css/mystyle.css" />
</head>
<body>
<%
	User user = (User) session.getAttribute("user");
%>
	<header>
		<!-- NAVIGATION BAR -->
		<nav class="navbar bg-inverse navbar-inverse navbar-toggleable-sm">
			<div class="container">
				<a class="navbar-brand" href="/Atomicity/">
					<img id="logoImg" src="resources/img/atomlogobar.png" alt="atomicity logo" style="width:80px;">
					<%=user.getUsername()%>
				</a>
				<div class="navbar-nav">
						<a class="nav-item nav-link active" href="/Atomicity/">Community</a>
						
						<a class="nav-item nav-link" href="">Profile</a>			
						
						<a class="nav-item nav-link" href="/Atomicity/logout">Logout</a>
	
						
				</div>
			</div>
		</nav>			
	</header>
	
	<div class="container">
		<div class="row">
			<h1>Categories</h1>
			<a href="/Atomicity/addTopicPage">Create A New Topic</a>
			<a href="/Atomicity/mailbox">MailBox</a>
		</div>
		<div class="row">			
			<a href="/Atomicity/MISC/topics">MISC</a>
			<p>Miscellaneous Section</p>
			
			<a href="/Atomicity/logout">Logout</a>
		</div>
	</div>	
</body>
</html>