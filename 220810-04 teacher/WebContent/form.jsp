<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입력 폼</title>
</head>
<body>
	<form action = "./addperson.do" method = "post">
		<label>firstname <input type = "text" name = "firstname" /></label><br />
		<label>lastname <input type = "text" name = "lastname" /></label><br />
		<label>age	<input type = "number" name = "age" /></label><br />
		<label>email	<input type = "text" name = "email" /></label><br />
		<input type = "submit" />
		<c:if test = "${ not empty errors }">
			<div>
				<c:forEach var = "message" items = "${ errors }">
					<p>${ message.value }</p>
				</c:forEach>
			</div>
		</c:if>
	</form>
</body>
</html>