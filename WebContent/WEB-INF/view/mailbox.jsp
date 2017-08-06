<%@page import="com.atomicity.domain.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MailBox</title>
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
					<a class="nav-item nav-link" href="/Atomicity/profile">Profile</a> 
					<a class="nav-item nav-link" href="/Atomicity/addTopicPage">Submit a Topic</a>
					<a class="nav-item nav-link active" href="/Atomicity/mailbox">Mailbox</a>
					<a class="nav-item nav-link" href="/Atomicity/update">Update Info</a>
					<a class="nav-item nav-link" href="/Atomicity/logout">Logout</a>
				</div>
			</div>
		</nav> 
	</header>
	<a href="/Atomicity/account">Go Back</a>

		<div class="login-page">
	  <div class="form">
	    <form class="login-form" action="/Atomicity/composeMail" method="POST" >
	    	<button class="btn btn-primary" type="submit">Compose</button>
	    </form>
	  </div>
	</div>
	
<!-- 	<a href="/Atomicity/composeMail">Compose</a> -->
	<div class="table-title">
		<h3><%=user.getUsername() %>'s messages</h3>
	</div>
	<table class="table-fill">
		<thead>
			<tr>
				<th class="text-left">Subject</th>
				<th class="text-left">Sender</th>
				<th c>Send Date</th>
			</tr>
		</thead>
		<tbody class="table-hover">
			<c:forEach items="${mail}" var="mail">
				<tr>
					<td class="text-left"><c:out value="${mail.title}" /></td>
					<td class="text-left"><c:out value="${mail.sender}" /></td>
					<td class="text-left"><c:out value="${mail.dateSubmitted}" /></td>
				</tr>
				<tr>
					<td class="text-left" colspan="3"><c:out value="${mail.text}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>