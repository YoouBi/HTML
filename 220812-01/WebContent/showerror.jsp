<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage = "true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러를 보여줄 페이지</title>
</head>
<body>
	<p>요청 처리 중 에러가 발생했습니다. 다시 시도해주세요.</p>
	<%--
	<%= exception.getCause() %>
	<%= exception.getLocalizedMessage() %> 
	<%= exception.getClass().getName() %>
	exception 객체로 확인도 가능
	--%>
</body>
</html>