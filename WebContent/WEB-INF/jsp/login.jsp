<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="shortcut icon" href="favicon1.ico" />
<title>Login page</title>
<link rel="stylesheet" href="css/normalize.css" />
<link rel="stylesheet" href="css/mystyle.css" />
</head>
<body>


	<img id="logoImg2" src="img/atomicitylogo.png" alt="atomicity logo">
	
	<div class="login-page">
		<div class="form">
			<form:form action="/login" method="POST" commandName="login"
				class="register-form">
				<table>
					<tr>
						<td><form:label path="username">username:</form:label></td>
						<td><form:input path="username" /></td>
						<td><form:errors path="username" /></td>
					</tr>
					<tr>
						<td><form:label path="password">password:</form:label></td>
						<td><form:input path="password" /></td>
						<td><form:errors path="password" /></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Log In" />
							<p class="message">
					</tr>
				</table>
				<p>
					Not registered? <a href="register.html">Create an account</a>
				</p>
			</form:form>
		</div>
	</div>
	<h1>${message}</h1>
</body>
</html>
