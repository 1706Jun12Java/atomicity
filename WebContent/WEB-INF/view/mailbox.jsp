<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MailBox</title>
</head>
<body>
	<a href="/Atomicity/composeMail">Compose</a>
	<table>
		<thead>
			<tr>
				<td><p>Subject</p></td>
				<td><p>Sender</p></td>
				<td><p>Send Date</p></td>
			</tr>
		</thead>
		<c:forEach items="${mail}" var="mail">
			<tr>
				<td><c:out value="${mail.title}" /></td>
				<td><c:out value="${mail.sender}" /></td>
				<td><c:out value="${mail.dateSubmitted}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>