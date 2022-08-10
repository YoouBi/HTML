<%@page import="kr.co.greenart.Country"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록</title>
</head>
<body>
	<%-- 원래 이렇게 자바 식을 썼어야했는데
	<%
	List<Country> list = (List<Country>) request.getAttribute("list");
	%>
	<ul>
	<% 
		for (int i = 0; i < list.size(); i++) { %>
			<li><%= list.get(i).getName() %>
				인구 -
				<%= list.get(i).getPopulation() %>
			</li>
	<% }%>	
	</ul>
	태그로만 작성하도록 만들면
	el에서 사용할 수 있는 연산자 empty는 null이거나 오른쪽 객체의 값이 비어있다면 true로 반환,
	ex) null, 문자열의 경우 " "처럼 빈문자일 경우, 컬렉션의 경우 사이즈가 0 등이면 true
	원소값이 있다면 false를 반환하기 때문에 not을 붙임 --%>
	<c:if test = "${ not empty list }">
		<ul>
			<c:forEach var = "country" items = "${ list }">
			<%-- 순환을 할 객체 컬렉션 items에는 el을 적어줘야한다 --%>
				<li>${ country.name } ${ country.population }</li>
				<%-- el은 게터를 가지고 있는 필드면 생략 가능! --%>
			</c:forEach>
		</ul>
	</c:if>
</body>
</html>