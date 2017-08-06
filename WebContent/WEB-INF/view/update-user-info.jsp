<%@page import="com.atomicity.domain.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Your Information</title>
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
	<div class="container">
		<div class="login-page form-control float-left semi-transp">
		  <div class="form">
		    <form class="login-form" action="updateFirstname" method="POST" >
		    	<fieldset class="form-group">
		    		<div class="form-group">
		    			<input class="form-control" type ="text" name="firstname" placeholder="firstname" /> 
						<button class="btn btn-primary" type="submit">Update</button><p class="text-form, text-success">${updateMsg1}</p>
			      	</div>
			    </fieldset>
		    </form>
		  </div>
		</div>
		
		<div class="login-page form-control float-left semi-transp">
		  <div class="form">
		    <form class="login-form" action="updateLastname" method="POST" >
		    	<fieldset class="form-group">
		    		<div class="form-group">
		    			<input class="form-control" type ="text" name="lastname" placeholder="lastname" /> 
						<button class="btn btn-primary" type="submit">Update</button><p class="text-form, text-success">${updateMsg2}</p>
			      	</div>
			    </fieldset>
		    </form>
		  </div>
		</div>
		
		<div class="login-page form-control float-left semi-transp">
		  <div class="form">
		    <form class="login-form" action="updateEmail" method="POST" >
		    	<fieldset class="form-group">
		    		<div class="form-group">
		    			<input class="form-control" type ="text" name="email" placeholder="Email" /> 
						<button class="btn btn-primary" type="submit">Update</button><p class="text-form, text-success">${updateMsg3}</p>
			      	</div>
			    </fieldset>
		    </form>
		  </div>
		</div>
		<div class="login-page form-control float-left semi-transp">
		  <div class="form">
		    <form class="login-form" action="updatePassword" method="POST" >
		    	<fieldset class="form-group">
		    		<div class="form-group">
		    			<input class="form-control" type ="password" name="password" placeholder="Password" /> 
						<button class="btn btn-primary" type="submit">Update</button><p class="text-form, text-success">${updateMsg3}</p>
			      	</div>
			    </fieldset>
		    </form>
		  </div>
		</div>
		
		<div class="form-control float-left semi-transp">
			<form action="doneUpdate">
	    		<input class="btn btn-primary" type="submit" value="Done" />
			</form>
		</div>
<!-- 		<a class="float-right" href="/Atomicity/doneUpdate">Done</a> -->
	</div>


<%-- 	<form action="updateFirstname" method="POST">
		<input type ="text" name="firstname" placeholder="firstname" /> 
		<input type="submit" value="Update" /><p>${updateMsg1}</p>
	</form>
	
	<form action="updateLastname" method="POST">
		<input type ="text" name="lastname" placeholder="lastname" />
		<input type="submit" value="Update" /> <p>${updateMsg2}</p>

	</form>
	
	<form action="updateEmail" method="POST">
		<input type ="text" name="email" placeholder="email" />
		<input type="submit" value="Update" /><p>${updateMsg3}</p>
	</form>
	
		<form action="updatePassword" method="POST">
		<input type ="password" name="password" placeholder="password" />
		<input type="submit" value="Update" /><p>${updateMsg4}</p>
	</form> --%>
	
</body>
</html>