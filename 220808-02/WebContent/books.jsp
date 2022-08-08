<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%
	List<String> list = new ArrayList<>();
	for (int i = 0; i < 100; i++) {
		list.add("book" + i);
	}
%>

<!-- 
	사용자가 1 입력 시 book0 ~ book9
	사용자가 2 입력 시 book10 ~ book19
 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	int pagenum = Integer.valueOf(request.getParameter("page"));
	int pagestart = (pagenum - 1) * 10;
	
	for(int i = pagestart; i < pagestart + 10; i++) {
		out.println(list.get(i) + "<br/>");
		// 브라우저의 특징 때문에 println임에도 문자열을 자기가 알아서 해석해서
		// 여러줄을 적어도 여러 공백의 흐름을 한개로 치환시킬 수 있다
	}
	
	%>
</body>
</html>