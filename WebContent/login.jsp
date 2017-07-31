<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="shortcut icon" href="favicon1.ico" />
<title>Login page</title>
<link rel="stylesheet" href="css/normalize.css" />
<link rel="stylesheet" href="css/mystyle.css" />
</head>
<body>
	<img id="logoImg2" src="img/atomicitylogo.png" alt="atomicity logo">
	<div class="login-page">
		<div class="form">
			<form:form action="login" method="post" commandName="login"
				class="register-form">
				<table>
					<tr>
						<td><form:label path="user">username:</form:label></td>
						<td><form:input path="user" /></td>
						<td><form:errors path="user" /></td>
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
					Not registered? <a href="register.html">Create an account</a>
				</p>
			</form:form>
		</div>
	</div>
</body>
</html>
