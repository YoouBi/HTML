<%@page import="java.time.LocalDate"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.time.LocalTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오늘 날짜와 시간</title>
</head>
<body>
	<%
		// scriptlet 영역
		System.out.println("사용자가 jsp 페이지를 요청했습니다.");
		int a = 10;
	%>
	<p>jsp 페이지입니다.</p>
	
	<%= LocalDate.now() %>
	<string><%= java.time.LocalTime.now() %></string><br />
	<%= Calendar.DAY_OF_MONTH %>
	
	<p>a의 값은 <%= a %>입니다.</p>
	<%-- jsp 해석하는 실행 흐름에서 이 부분은 건너뜀
		<p>b의 값은 <%= b %>입니다.</p>
		int b = 20;
	--%>
</body>
</html>