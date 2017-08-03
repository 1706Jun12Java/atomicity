<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Atomicity Home page</title>
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
						<a class="nav-item nav-link active" href="loginVerify">Sign in</a>
	
						<a class="nav-item nav-link" href="registerLink">Register</a>
	
						<a class="nav-item nav-link disabled" href="">About Us</a>
				</div>
			</div>
		</nav>			
	</header>
	
<!-- 	<div>
		<form action="login" method="POST">
			<fieldset class="form-group">
				<legend>Sign in</legend>
				<div class="form-group">
					<label class="form-control-label" for="username">Username</label>
					<input class="form-control" type="text" name="username" id="username"/>
				</div>
				
				<div class="form-group">
					<label class="form-control-label" for="password">Password</label>
					<input class="form-control" type="password" name="password" id="password"/>
				</div>							
			</fieldset>
			<button class="btn btn-primary" type="submit">Sign in</button>
		</form>
	</div> -->
  	<div class="login-page">
	  <div class="form">
	    <form class="login-form" action="login" method="POST" >
	    	<fieldset class="form-group">
	    		<div class="form-group">
		      		<label class="form-control-label" for="username">Username</label>
		      		<input class="form-control" type="text" name="username" id="username"/>
		      	</div>
		      	<div class="form-group">
		      		<label class="form-control-label" for="password">Password</label>
		      		<input class="form-control" type="password" name="password" id="password"/>
		      	</div>
		      	<button class="btn btn-primary" type="submit">login</button>
		      	<p class="message"><a href="#">Forgot password?</a></p>
	    	</fieldset>
	    </form>
	  </div>
	</div>
	
	
	
</body>
</body>
</html>