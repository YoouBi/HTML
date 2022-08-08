<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>뭘 보고 싶니?</title>
</head>
<body>
	<form action = "./switchpath.jsp">
		<input type = "radio" name = "choice" value = "persons" />사람
		<input type = "radio" name = "choice" value = "fruit" />과일
		<input type = "submit" />
	</form>
	<% 
	String d = request.getParameter("progress");

	if (d != null) {
		if(d.equals("failed")) {
			out.println("<p>failed</p>");
		} else {
			out.print("<p></p>");
		}
	}
	%>
</body>
</html>