<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>JSP Expression Language</p>
	${ "qwer" } <!-- 출력을 도와줌 -->
	${ 123 }
	${ 55.432 }
	${ true }
	<br />
	${ 1 + 2 } <!-- 연산, 관계 연산도 된다 -->
	${ true && false }
	<br />
	${ pageContext.request.requestURL }
	<!-- getter가 있는 속성이라면 get까지 쓸 필요 없이 request, requestURI만 적어도 된다 -->
</body>
</html>