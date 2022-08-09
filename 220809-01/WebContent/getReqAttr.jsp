<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- request객체는 사용자의 '한번'의 요청에 대해서 유지되고 있음 -->
	<%= request.getAttribute("reqAttr") %>
	<%= request.getAttribute("reqInt") %>
</body>
</html>