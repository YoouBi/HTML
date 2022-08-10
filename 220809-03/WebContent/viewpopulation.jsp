<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%= request.getParameter("continent") %></title>
</head>
<body>
	<%
		String continent = request.getParameter("continent");
		List<String> clist = (List<String>)request.getAttribute("countries");
		List<Integer> plist = (List<Integer>)request.getAttribute("populations");
	%>
	<ul>
	<%= "대륙 " + continent + "에 속한" %><br /><br />
	<% for (int i = 0; i < clist.size(); i++) { %>
		<li><%= clist.get(i) + "의 인구 수는 " + plist.get(i) + "명이다." %></li>
	<% } %>
</body>
</html>