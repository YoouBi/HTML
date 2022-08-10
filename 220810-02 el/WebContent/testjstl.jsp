<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 사용할 태그 라이브러리를 설정, 이 라이브러리를 prefix의 이름(c)으로 쓰겠다 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var = "i" begin = "1" end = "10">
		<c:if test = "${ i % 2 == 0 }"> <!-- 흐름제어 if 태그도 사용 가능 -->
		<!-- test로 조건을 적었을 때 조건식(연산을 할 수 있는 el표현도 가능)이 true면 아래의 흐름 출력 -->
			<p>${ i }</p>
		</c:if>
	</c:forEach>
	<hr />
	<!-- 이프엘스가 없어서 대신할 수 있는 친구인데 swith case와 비슷하다 -->
	<c:choose>
		<c:when test = "true">
			<p>첫번째 조건이 참일 때</p>
		</c:when>
		<c:when test = "false">
			<p>두번째 조건이 참일 때</p>
		</c:when>
		<c:otherwise>
			<p>모든 조건이 참이 아닐 때</p>
		</c:otherwise>
	</c:choose>
	<!-- otherwise는 swith case의 defult와 비슷한데 없어도 된다 -->
</body>
</html>