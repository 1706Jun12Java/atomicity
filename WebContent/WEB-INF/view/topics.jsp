<%@page import="com.atomicity.domain.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:url value="/resources/css/normalize.css" var="normalize" />
<c:url value="/resources/css/mystyle.css" var="mystyle" />
<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" var="bootstrap" />

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${normalize}" />
<link rel="stylesheet" href="${bootstrap}" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
<link rel="stylesheet" href="${mystyle}" />
<title>${category} Section</title>
</head>
<body>
	<c:url value="/resources/img/atomlogobar.png" var="loginInBar" />
	<%
		User user = (User) session.getAttribute("user");
	%>
	<header> <!-- NAVIGATION BAR --> 
		<nav class="navbar bg-inverse navbar-inverse navbar-toggleable-sm">
	<div class="container">
		<a class="navbar-brand" href="/Atomicity/"> <img id="logoImg"
			src="${loginInBar}" alt="atomicity logo" style="width: 80px;"/> 
			<%=user.getUsername()%>
		</a>
		<div class="navbar-nav">
			<a class="nav-item nav-link active" href="/Atomicity/">Community</a>
			<a class="nav-item nav-link" href="/Atomicity/profile">Profile</a> <a
				class="nav-item nav-link" href="/Atomicity/addTopicPage">Submit
				a Topic</a> <a class="nav-item nav-link" href="/Atomicity/mailbox">Mailbox</a>
			<a class="nav-item nav-link" href="/Atomicity/logout">Logout</a>
		</div>
	</div>
	</nav> </header>
	
	<a href="/Atomicity/account">Go Back</a>	
	<div class="container">
		<div class="row">
			<h1 class="category-header">Topics</h1>
		</div>
		<c:forEach items="${topics}" var="top">
			<div class="row category row-topic">
				<div class ="row-topic-title">
					<a href="${top.url}">${top.title}</a>
				</div>
				
				<div class="row-topic-content">
					<c:out value="${top.author}" /><br>
					<c:out value="${top.firstPost}" /><br>
					<c:out value="${top.dateSubmitted}" /><br>
				</div>
				
			</div>
		</c:forEach>
		</div>
	</div>
	
	
<%-- 	<table>
		<c:forEach items="${topics}" var="top">
			<tr>
				<td><a href=${top.url} >${top.title}</a></td>
				<td><c:out value="${top.author}" /></td>
				<td><c:out value="${top.firstPost}" /></td>
				<td><c:out value="${top.dateSubmitted}" /></td>
			</tr>
		</c:forEach>
	</table> --%>

</body>
</html>