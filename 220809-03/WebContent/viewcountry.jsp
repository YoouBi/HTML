<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- ul, li 목록 표현 -->
	<%
		List<String> list = (List<String>)request.getAttribute("countries");
	%>
	<ul>
	<% for (int i = 0; i < list.size(); i++) { %>
		<li><%= list.get(i) %></li>
	<% } %> <!-- jsp 표현을 더 배우면 이런 것도 없애고 순수하게 태그로만 이루어진 jsp를 만들 수 있다 -->
	</ul>
</body>
</html>