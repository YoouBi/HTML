<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>${ requestScope.name1 }</p>
	<p>${ requestScope.name2 }</p>
	<p>${ applicationScope.name3 }</p>
	<p>${ requestScope.name4 }</p>
	<p>${ applicationScope.name4 }</p>
	<hr />
	<p>${ name1 }</p> <!-- 영역을 지정하지 않고 이름만 적어놓으면 el이 알아서 객체를 뒤져보는데 -->
	<p>${ name2 }</p>
	<p>${ name3 }</p>
	<p>${ name4 }</p> <!-- 이름을 가지고 살펴볼 때 좁은 영역을 가진 아이부터 살펴본다 -->
	<!-- page<req<session<app -->
	<hr />
	<p>${ none }</p> <!-- 없는 값을 달라고 하면 공백을 줌 -->
</body>
</html>