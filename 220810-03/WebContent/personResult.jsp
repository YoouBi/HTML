<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test = "${ not empty list }">
		<ul>
			<c:forEach var = "persons" items = "${ list }">
				<li>${ persons.lastname } ${ persons.firstname }</li>
			</c:forEach>
		</ul>
	</c:if>
</body>
</html>