<%@page import="com.atomicity.domain.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Submit A New Topic</title>
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
					<a class="nav-item nav-link active" href="/Atomicity/addTopicPage">Submit a Topic</a>
					<a class="nav-item nav-link" href="/Atomicity/mailbox">Mailbox</a>
					<a class="nav-item nav-link" href="/Atomicity/logout">Logout</a>
				</div>
			</div>
		</nav> 
	</header>


	<div class="login-page">
	  <div class="form">
	    <form id ="topicForm" class="login-form" action="/Atomicity/submitTopic" method="POST" >
	    	<fieldset class="form-group">
	    		<div class="form-group">
	    			<label class="form-control-label" for="title-for-topic">Title</label>
	    			<input class="form-control" name="title" type="text" id="title-for-topic" />
		      	</div>
		      	<div class="form-group">
		    		<select class="form-control" name="category" form="topicForm">
						<option value="general">General</option>
						<option value="java">Java</option>
						<option value="sql">SQL</option>
						<option value="web">Web</option>
					</select>
		      	</div>
		      	<div class="form-group">
		      		<textarea class="form-control" name="text" rows="4" cols="10" maxlength="1000" placeholder="Say something nice" form="topicForm"></textarea>
		      	</div>
	    	</fieldset>
	    	<button class="btn btn-primary" type="submit">Submit New Topic</button>
	    </form>
	    <a href="#" onclick="history.go(-1)">Go Back</a>
	  </div>
	</div>
	
	<!-- <form id="topicForm" action="/Atomicity/submitTopic" method="post">
		<input name="title" type="text" placeholder="Enter the Title " /> <br>
		<select name="category" form="topicForm">
			<option value="general">General</option>
			<option value="java">Java</option>
			<option value="sql">SQL</option>
			<option value="web">Web</option>
		</select> <br>
		<textarea name="text" rows="4" cols="10" maxlength="100"
			form="topicForm"></textarea>
		<br> <br> <input type="submit" value="Submit New Topic" />
	</form> -->
	
</body>
</html>