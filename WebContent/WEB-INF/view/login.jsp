<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="shortcut icon" href="favicon1.ico" />
<title>Login page</title>
</head>
<body>
	<div class="login-page">
		<div class="form">
			<form action="login" method="POST">
				<input type="text" name="username" placeholder="Enter username" /><br/>
				<input type="password" name="password" placeholder="Enter Password" /><br/>
				<input type="submit" value="Sign In" />
			</form>
		</div>
	</div>
	<h1>${error}</h1>
</body>
</html>
