<%@page import="com.atomicity.domain.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register | Atomicity</title>
<link rel="stylesheet" href="resources/css/normalize.css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
<link rel="stylesheet" href="resources/css/mystyle.css" />
</head>
<body>
	<header>
		<!-- NAVIGATION BAR -->
		<nav class="navbar bg-inverse navbar-inverse navbar-toggleable-sm">
			<div class="container">
				<a class="navbar-brand" href="/atomicity/index">
					<img id="logoImg" src="resources/img/atomlogobar.png" alt="atomicity logo" style="width:80px;">
				</a>
				<div class="navbar-nav">					
						<a class="nav-item nav-link" href="/Atomicity/">Sign in</a>
	
						<a class="nav-item nav-link active" href="registerLink">Register</a>
	
						<a class="nav-item nav-link disabled" href="">About Us</a>
				</div>
			</div>
		</nav>			
	</header>
	
		
<!-- 	<form action="register" method="post">
		<input type="text" name="firstname" placeholder="Firstname" /><br>
		
		<input type="text" name="lastname" placeholder="Lastname" /><br>
		
		<input type="text" name="email" placeholder="Email" /><br>
		
		<input type="text" name="username" placeholder="Username" /><br>
		
		<input type="password" name="password" placeholder="Password" /><br>
		
		<input type="password" name="cpassword" placeholder="Confirm Password" /><br>
		
		<input type="submit" value="register" /><br>
	</form> -->
	<%
		String firstnameR = (String) session.getAttribute("firstnameR");
		String lastnameR = (String) session.getAttribute("lastnameR");
		String emailR = (String) session.getAttribute("emailR");
		String usernameR = (String) session.getAttribute("usernameR");
		
		firstnameR = (firstnameR == null) ? "" : firstnameR;
		lastnameR = (lastnameR == null) ? "" : lastnameR;
		emailR = (emailR == null) ? "" : emailR;
		usernameR = (usernameR == null) ? "" : usernameR;
		
	%>
	<div class="login-page">
	  <div class="form">
	    <form class="login-form" action="register" method="POST" >
	    	<fieldset class="form-group">
	    		<div class="form-group ${firstnameDIV}">
		      		<label class="form-control-label" for="firstname">Firstname</label>
		      		<small class="form-text text-danger">${firstnameMSG}</small>
		      		<input class="form-control" type="text" name="firstname" id="firstname" value="<%=firstnameR%>"/>
		      	</div>
		      	<div class="form-group ${lastnameDIV}">
		      		<label class="form-control-label" for="lastname">Lastname</label>
		      		<small class="form-text text-danger">${lastnameMSG}</small>
		      		<input class="form-control" type="text" name="lastname" id="lastname" value="<%=lastnameR%>"/>
		      	</div>
		      	<div class="form-group ${emailDIV}">
		      		<label class="form-control-label" for="email">Email</label>
		      		<small class="form-text text-danger">${emailMSG}</small>
		      		<input class="form-control" type="text" name="email" id="email" value="<%=emailR%>"/>
		      	</div>
		      	<div class="form-group ${usernameDIV}">
		      		<label class="form-control-label" for="username">Username</label>
		      		<small class="form-text text-danger">${usernameMSG}</small>
		      		<input class="form-control" type="text" name="username" id="username" value="<%=usernameR%>"/>
		      	</div>
		      	<div class="form-group ${passwordDIV}">
		      		<label class="form-control-label" for="password">Password</label>
		      		<small class="form-text text-danger">${passwordMSG}</small>
		      		<input class="form-control" type="password" name="password" id="password"/>
		      	</div>
		      	<div class="form-group ${cpasswordDIV}">
		      		<label class="form-control-label" for="cpassword">Confirm Password</label>
		      		<small class="form-text text-danger">${cpasswordMSG}</small>
		      		<small class="form-text text-danger">${cpasswordMMSG}</small>
		      		<input class="form-control" type="password" name="cpassword" id="cpassword"/>
		      	</div>
	    	</fieldset>
	    	<button class="btn btn-primary" type="submit">Register</button>
	    </form>
	  </div>
	</div>
</body>
</html>