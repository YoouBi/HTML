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
	String[] numArr = request.getParameterValues("num");
	
	for(int i = 0; i < numArr.length; i++) {
		out.println("<img src = './images/chunsik/춘식" + numArr[i] + ".png' />");
	}
	%>
</body>
</html>