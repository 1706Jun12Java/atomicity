<%@page import="com.atomicity.domain.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="timeApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Account | Atomicity</title>
<script type="text/javascript"
	src="http://cdnjs.cloudflare.com/ajax/libs/angular.js/1.4.8/angular.js"></script>
<script type="text/javascript" src="resources/javascript/time.js"></script>
<link rel="stylesheet" href="resources/css/normalize.css" />

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
	integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ"
	crossorigin="anonymous">
<link rel="stylesheet" href="resources/css/mystyle.css" />
</head>
<body>
	<%
		User user = (User) session.getAttribute("user");
	%>
	<header> <!-- NAVIGATION BAR --> 
		<nav class="navbar bg-inverse navbar-inverse navbar-toggleable-sm">
	<div class="container">
		<a class="navbar-brand" href="/Atomicity/"> <img id="logoImg"
			src="resources/img/atomlogobar.png" alt="atomicity logo"
			style="width: 80px;"/> <%=user.getUsername()%>
		</a>
		<div class="navbar-nav">
			<a class="nav-item nav-link active" href="/Atomicity/">Community</a>
			<a class="nav-item nav-link" href="/Atomicity/profile">Profile</a> <a
				class="nav-item nav-link" href="/Atomicity/addTopicPage">Submit
				a Topic</a> <a class="nav-item nav-link" href="/Atomicity/mailbox">Mailbox</a>
			<a class="nav-item nav-link" href="/Atomicity/update">Update Info</a>
			<a class="nav-item nav-link" href="/Atomicity/logout">Logout</a>
		</div>
	</div>
	</nav> </header>

	<div class="container">
		<div class="row">
			<h1 class="category-header">Categories</h1>
		</div>

		<div class="row">
			<!-- 			<div class="category-action-row">
				<a href="/Atomicity/addTopicPage">Create A New Topic</a>
			</div> -->

		</div>
		<div class="row category">
			<div class="category-title">
				<a href="/Atomicity/general/topics">General</a>
			</div>
			<div class="category-info">
				<p>General Section</p>
			</div>
		</div>
		<div class="row category">
			<div class="category-title">
				<a href="/Atomicity/java/topics">JAVA</a>
			</div>
			<div class="category-info">
				<p>Java Section</p>
			</div>
		</div>
		<div class="row category">
			<div class="category-title">
				<a href="/Atomicity/sql/topics">SQL</a>
			</div>
			<div class="category-info">
				<p>SQL Section</p>
			</div>
		</div>
		<div class="row category">
			<div class="category-title">
				<a href="/Atomicity/web/topics">Web</a>
			</div>
			<div class="category-info">
				<p>HTML/CSS/Javascript Section</p>
			</div>
		</div>
	</div>
</body>
</html>