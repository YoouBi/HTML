<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자가 볼 페이지</title>
<!-- 공개되어있는 리소스라서 원했던 흐름과 다르게 사용자가 주소를 입력해서 이 페이지로 들어올 수 있다
	그래서 보여줄 수 없도록 WEB-INF 폴더로 넣어주면 된다 -->
</head>
<body>
	<p>정보</p>
	<p>연산의 결과</p>
	<!-- <%= request.getParameter("result") %> -->
	<!-- <%= application.getAttribute("result") %> -->
	<%= request.getAttribute("result") %>
</body>
</html>