<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Compose</title>
</head>
<body>
	<p>${error}</p>
	<form id="mailForm" action="/Atomicity/submitMail" method="post">
		<input type="text" name="receiver" placeholder="Enter Recipient" /><br />
		<input type="text" name="title" placeholder="Enter Title" /><br />
		<textarea name="text" rows="4" cols="10" maxlength="1000"
			placeholder="Say something nice" form="mailForm"></textarea>
		<br> <br> <input type="submit" value="Submit New Topic" />
	</form>
	<a href="#" onclick="history.go(-1)">Go Back</a>
</body>
</html>