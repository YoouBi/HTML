<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인덱스</title>
</head>
<body>
	<header>
		<h2>메뉴메뉴</h2>
	</header>
	<nav>
		<ul>
		<c:if test="${ empty loginid }">
			<li><a href = "./loginform.jsp">로그인 하기</a></li>
		</c:if>
		<c:if test="${ not empty loginid }">
			<li><a href = "../board">게시글 보기</a></li>
			<li><a href = "./logout.jsp">로그아웃 하기</a></li>
		</c:if>
		</ul>
	</nav>
</body>
</html>