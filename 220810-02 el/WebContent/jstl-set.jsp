<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% request.setAttribute("asdf", "zxcv"); %>
	<c:set var = "jjj" value = "value2" scope = "request" />
	
	${ asdf }
	${ jjj }
	<hr />
	
	<!-- 주소값을 만들어서 설정해줄수도 있는데 페이지 스코프는 이 페이지 안에서만 쓸 수 있다
	페이지는 제일 조그만 영역이라 이 페이지 안에서만! -->
	<c:url var = "searchGoogle" value = "http://google.com/search" >
		<c:param name = "q" value = "검색 파라미터"></c:param>
	</c:url>
	<!-- 한글을 집어넣어도 알아서 UTF 형식에 맞춰서 변경해줌 -->
	
	<c:out value = "출력할 때 쓰는데" />
	
	<a href = "${ searchGoogle }">구글 검색</a>
</body>
</html>