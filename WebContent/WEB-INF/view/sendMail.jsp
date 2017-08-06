<%@page import="com.atomicity.domain.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Compose</title>
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
					<a class="nav-item nav-link " href="/Atomicity/addTopicPage">Submit a Topic</a>
					<a class="nav-item nav-link active" href="/Atomicity/mailbox">Mailbox</a>
					<a class="nav-item nav-link" href="/Atomicity/logout">Logout</a>
				</div>
			</div>
		</nav> 
	</header>
	
	<p>${error}</p>
	<div class="login-page">
	  <div class="form">
	    <form id ="mailForm" class="login-form" action="/Atomicity/submitMail" method="POST" >
	    	<fieldset class="form-group">
	    		<div class="form-group">
	    			<label class="form-control-label" for="mail-recipient">Recipient</label>
	    			<input class="form-control" type="text" name="receiver" id="mail-recipient"/><br />
		      	</div>
		      	<div class="form-group">
		      		<label class="form-control-label" for="mail-title">Title</label>
		    		<input class="form-control" type="text" name="title" id="mail-title" /><br />
		    	</div>
		      	<div class="form-group">
		      		<textarea class="form-control" name="text" rows="4" cols="10" maxlength="1000" placeholder="Say something nice" form="mailForm"></textarea>
		      	</div>
	    	</fieldset>
	    	<button class="btn btn-primary" type="submit">Submit</button>
	    </form>
	    <a href="#" onclick="history.go(-1)">Go Back</a>
	  </div>
	</div>


<%-- 
	<p>${error}</p>
	<form id="mailForm" action="/Atomicity/submitMail" method="post">
		<input type="text" name="receiver" placeholder="Enter Recipient" /><br />
		<input type="text" name="title" placeholder="Enter Title" /><br />
		<textarea name="text" rows="4" cols="10" maxlength="1000"
			placeholder="Say something nice" form="mailForm"></textarea>
		<br> <br> <input type="submit" value="Submit New Topic" />
	</form>
	<a href="/Atomicity/addTopicPage">Go Back</a>
	 --%>
</body>
</html>