<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="updateFirstname" method="POST">
		<input type ="text" name="" placeholder="firstname" />
		<input type="submit" value="Update" />
	</form>
	
	<form action="updateLastname" method="POST">
		<input type ="text" name="" placeholder="lastname" />
		<input type="submit" value="Update" />
	</form>
	
	<form action="updateEmail" method="POST">
		<input type ="text" name="email" placeholder="email" />
		<input type="submit" value="Update"/>
	</form>
	
		<form action="updatePassword" method="POST">
		<input type ="password" name="password" placeholder="password" />
		<input type="submit" value="Update" />
	</form>
</body>
</html>