<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- ERROR MESSAGES -->
	<h5 class="fieldErrorMessage">${firstnameMSG}</h5>
	<h5 class="fieldErrorMessage">${lastnameMSG}</h5>
	<h5 class="fieldErrorMessage">${emailMSG}</h5>
	<h5 class="fieldErrorMessage">${usernameMSG}</h5>
	<h5 class="fieldErrorMessage">${passwordMSG}</h5>
	<h5 class="fieldErrorMessage">${cpasswordMSG}</h5>
	<h5 class="fieldErrorMessage">${cpasswordMMSG}</h5>
	
	<form action="register" method="post">
		<input type="text" name="firstname" placeholder="Firstname" /><br>
		
		<input type="text" name="lastname" placeholder="Lastname" /><br>
		
		<input type="text" name="email" placeholder="Email" /><br>
		
		<input type="text" name="username" placeholder="Username" /><br>
		
		<input type="password" name="password" placeholder="Password" /><br>
		
		<input type="password" name="cpassword" placeholder="Confirm Password" /><br>
		
		<input type="submit" value="register" /><br>
	
	</form>
</body>
</html>