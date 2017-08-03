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
	<!-- ERROR MESSAGES -->
	<h5 class="fieldErrorMessage">${firstnameMSG}</h5>
	<h5 class="fieldErrorMessage">${lastnameMSG}</h5>
	<h5 class="fieldErrorMessage">${emailMSG}</h5>
	<h5 class="fieldErrorMessage">${usernameMSG}</h5>
	<h5 class="fieldErrorMessage">${passwordMSG}</h5>
	<h5 class="fieldErrorMessage">${cpasswordMSG}</h5>
	<h5 class="fieldErrorMessage">${cpasswordMMSG}</h5>
	
<!-- 	<form action="register" method="post">
		<input type="text" name="firstname" placeholder="Firstname" /><br>
		
		<input type="text" name="lastname" placeholder="Lastname" /><br>
		
		<input type="text" name="email" placeholder="Email" /><br>
		
		<input type="text" name="username" placeholder="Username" /><br>
		
		<input type="password" name="password" placeholder="Password" /><br>
		
		<input type="password" name="cpassword" placeholder="Confirm Password" /><br>
		
		<input type="submit" value="register" /><br>
	</form> -->
	
	<div class="login-page">
	  <div class="form">
	    <form class="login-form" action="register" method="POST" >
	    	<fieldset class="form-group">
	    		<div class="form-group">
		      		<label class="form-control-label" for="firstname">Firstname</label>
		      		<input class="form-control" type="text" name="firstname" id="firstname"/>
		      	</div>
		      	<div class="form-group">
		      		<label class="form-control-label" for="lastname">Lastname</label>
		      		<input class="form-control" type="text" name="lastname" id="lastname"/>
		      	</div>
		      	<div class="form-group">
		      		<label class="form-control-label" for="email">Email</label>
		      		<input class="form-control" type="text" name="email" id="email"/>
		      	</div>
		      	<div class="form-group">
		      		<label class="form-control-label" for="username">Username</label>
		      		<input class="form-control" type="text" name="username" id="username"/>
		      	</div>
		      	<div class="form-group">
		      		<label class="form-control-label" for="password">Password</label>
		      		<input class="form-control" type="password" name="password" id="password"/>
		      	</div>
		      	<div class="form-group">
		      		<label class="form-control-label" for="cpassword">Confirm Password</label>
		      		<input class="form-control" type="cpassword" name="cpassword" id="cpassword"/>
		      	</div>
	    	</fieldset>
	    	<button class="btn btn-primary" type="submit">Register</button>
	    </form>
	  </div>
	</div>
</body>
</html>