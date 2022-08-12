<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage = "showerror.jsp" %>
<!-- 주소창을 보면 페이지 이름이 그대로 있음 즉, forword가 일어난 것이라 req 객체도 그대로 있을 것 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러를 발생시킬 페이지</title>
</head>
<body>
	<%
	// 톰캣이 만들어준 에러페이지는 내부 코드가 다 보임
	// 불필요한 코드를 제거하고 사용자 친화적인 에러페이지를 만들어보자
		String name = null;
		System.out.println(name.toString());
	%>
</body>
</html>