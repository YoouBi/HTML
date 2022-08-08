<!--
	입력 폼
	숫자 1
	숫자 2
	
	연산자 + - * / 선택
	전송 
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
	<form action = "./calcresult.jsp">
		<input type = "number" name = "firstnum" />
		<label>연산자 선택 : +<input type = "radio" name = "calc" value = "plus" /></label>
		<label>-<input type = "radio" name = "calc" value = "minus" /></label>
		<label>*<input type = "radio" name = "calc" value = "multi" /></label>
		<label>/<input type = "radio" name = "calc" value = "divide" /></label>
		<input type = "number" name = "lastnum" />
		<input type = "submit" />
	</form>
</body>
</html>