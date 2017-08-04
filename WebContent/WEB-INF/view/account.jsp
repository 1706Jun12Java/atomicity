<%@page import="com.atomicity.domain.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Account | Atomicity</title>
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
	<header> <!-- NAVIGATION BAR --> <nav
		class="navbar bg-inverse navbar-inverse navbar-toggleable-sm">
	<div class="container">
		<a class="navbar-brand" href="/Atomicity/"> <img id="logoImg"
			src="resources/img/atomlogobar.png" alt="atomicity logo"
			style="width: 80px;"> <%=user.getUsername()%>
		</a>
		<div class="navbar-nav">
			<a class="nav-item nav-link active" href="/Atomicity/">Community</a>

			<a class="nav-item nav-link" href="">Profile</a> <a
				class="nav-item nav-link" href="/Atomicity/logout">Logout</a>


		</div>
	</div>
	</nav> </header>
	<h1>Categories</h1>
	<table>
		<tr>
			<td><a href="/Atomicity/general/topics">General</a></td>
			<td><p>General Section</p></td>
		</tr>
		<tr>
			<td><a href="/Atomicity/java/topics">JAVA</a></td>
			<td><p>Java Section</p></td>
		</tr>
		<tr>
			<td><a href="/Atomicity/sql/topics">SQL</a></td>
			<td><p>SQL Section</p></td>
		</tr>
		<tr>
			<td><a href="/Atomicity/web/topics">Web</a></td>
			<td><p>HTML/CSS/Javascript Section</p></td>
		</tr>
	</table>
	<a href="/Atomicity/addTopicPage">Create A New Topic</a>
	<a href="/Atomicity/mailbox">MailBox</a>
</body>
</html>