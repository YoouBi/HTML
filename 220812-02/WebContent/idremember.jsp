<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 이 스크립트도 servlet으로 옮겨두는게 좋음! -->
	<%
		Cookie[] cookies = request.getCookies();
		for (Cookie c : cookies) {
			if (c.getName().equals("rememberme")) {
				request.setAttribute("idvalue", URLDecoder.decode(c.getValue(), "utf-8"));
			}
		}
	%>
	<form action="./login" method="post">
<%-- 		<input type="text" name="id" value="${ cookie.rememberme.value }"/> --%>
		<input type="text" name="id" value="${ idvalue }"/>
		<input type="password" name="password"/>
		<input type="checkbox" name="rememberme"/>
		<input type="submit"/>
	</form>
	<a href = "./testlogin">로그인 해야만 들어갈 수 있는 페이지!</a>
</body>
</html>