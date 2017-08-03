<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Submit A New Topic</title>
</head>
<body>
	<form id="topicForm" action="/Atomicity/submitTopic" method="post">
		<input name="title" type="text" placeholder="Enter the Title " /> <br>
		<select name="category" form="topicForm">
			<option value="MISC">MISC</option>
		</select> <br>
		<textarea name="text" rows="4" cols="10" maxlength="100"
			form="topicForm"></textarea>
		<br> <br> <input type="submit" value="Submit New Topic" />
	</form>
	<a href="#" onclick="history.go(-1)">Go Back</a>
</body>
</html>