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
<title>${title}</title>
<script type="text/javascript"
	src="http://cdnjs.cloudflare.com/ajax/libs/angular.js/1.4.8/angular.js"></script>
<script type="text/javascript" src="resources/javascript/time.js"></script>
<link rel="stylesheet" href="${normalize}" />
<link rel="stylesheet" href="${bootstrap}" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
<link rel="stylesheet" href="${mystyle}" />
</head>
<body>
	<c:url value="/resources/img/atomlogobar.png" var="logoInBar" />
	<c:url value="/resources/img/xsmall-profile-pic.png" var="tempPP" />

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
					<a class="nav-item nav-link active" href="/Atomicity/">Community</a>
					<a class="nav-item nav-link" href="/Atomicity/profile">Profile</a> 
					<a class="nav-item nav-link" href="/Atomicity/addTopicPage">Submit a Topic</a>
					<a class="nav-item nav-link" href="/Atomicity/mailbox">Mailbox</a>
					<a class="nav-item nav-link" href="/Atomicity/logout">Logout</a>
				</div>
			</div>
		</nav> 
	</header>
	
	<div class="container">
		<div class="row">
			<h1 class="post-header">
				<c:out value="${firstPost}" />
			</h1>
		</div>
		<c:forEach items="${posts}" var="post">
			<div class="row category row-post">
				<div class ="row-post-title">
					<img src="${tempPP}"/>
					<c:out value="${post.author}" />
				</div>
				
				<div class="row-post-content">
					<c:out value="${post.text}" />
				</div>
				
			</div>
		</c:forEach>
		</div>
	</div>
	
<%-- 	<p>${firstPost}</p>
	<table>
		<thead >
			<tr class="table-header">
				<th></th>
				<th><c:out value="${firstPost}" /></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${posts}" var="post">
			<tr>
				<td><strong><c:out value="${post.author}" /></strong></td>
				<td><c:out value="${post.text}" /></td>
			</tr>
		</c:forEach>
		</tbody>
	</table> --%>
<!-- 	<form id="postForm" action="/Atomicity/submitPost" method="post">
		<input type="hidden" name="topicID" value=${id} /> 
		<input type="hidden" name="title" value=${title} />
		<textarea name="text" rows="4" cols="10" maxlength="1000"
			placeholder="Say something nice" form="postForm"></textarea>
		<br> <br> <input type="submit" value="Submit" />
	</form> -->
	
	
	<!-- AFTER THIS -->
	<div class="login-page">
	  <div class="form">
	    <form id ="postForm" class="login-form" action="/Atomicity/submitPost" method="POST" >
	    	<fieldset class="form-group">
	    		<div class="form-group">
		      		<input class="form-control" type="hidden" name="topicID" value=${id} />
		      	</div>
		      	<div class="form-group">
		    		<input class="form-control" type="hidden" name="title" value=${title} />
		      	</div>
		      	<div class="form-group">
		      		<textarea class="form-control" name="text" rows="4" cols="10" maxlength="1000" placeholder="Say something nice" form="postForm"></textarea>
		      	</div>
	    	</fieldset>
	    	<button class="btn btn-primary" type="submit">Submit</button>
	    </form>
	    <a href="#" onclick="history.go(-1)">Go Back</a>
	  </div>
	</div>
</body>
</html>