<%@ page import = "java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p><%= session.getId() %></p>
	<p>세션 생성시간<%= new Date(session.getCreationTime()) %></p>
	<p>마지막으로 세션에 접근한 시간 <%= new Date(session.getLastAccessedTime()) %></p>
	<!-- 시간 단위로 정보 유지. 시간은 서버마다 다름. 톰캣의 경우에 30분. 30분동안 정보가 유지됨. -->
	<!-- 브라우저를 껐다 켜면 세션이 날라가고 새 세션이 생김. 세션은 브라우저 단위로 유지. -->
</body>
</html>