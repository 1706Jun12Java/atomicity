<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${title}</title>
</head>
<body>
	<p>${firstPost}</p>
	<table>
		<thead>
			<tr>
				<td></td>
				<td><c:out value="${firstPost}" /></td>
			</tr>
		</thead>
		<c:forEach items="${posts}" var="post">
			<tr>
				<td><c:out value="${post.author}" /></td>
				<td><c:out value="${post.text}" /></td>
			</tr>
		</c:forEach>
	</table>
	<form id="postForm" action="/Atomicity/submitPost" method="post">
		<input type="hidden" name="topicID" value=${id}> <input
			type="hidden" name="title" value=${title} >
		<textarea name="text" rows="4" cols="10" maxlength="1000"
			placeholder="Say something nice" form="postForm"></textarea>
		<br> <br> <input type="submit" value="Submit New Topic" />
	</form>
	<a href="#" onclick="history.go(-1)">Go Back</a>
</body>
</html>