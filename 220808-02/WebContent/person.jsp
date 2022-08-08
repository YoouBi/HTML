<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인적정보</title>
</head>
<body>
	<!--
		입력폼.
		사용자 이름 (필수!!!!!)
		사용자 나이 (필수!!!!!)
	 -->
	 <form action = "./choice.jsp">
	 	<label>이름 : <input type = "text" name = "name" /></label>
	 	<% 
		String progress = request.getParameter("progress");
	 	String name = request.getParameter("name");
	 	if (progress != null) {
			if(progress.equals("failed")) {
				out.println("<p>이름이 입력되지 않았습니다.</p>");
			}
		} else if (name != null) {
			if(name.equals("failed")) {
				out.println("<p>이름이 입력되지 않았습니다.</p>");
			}
		} else {
			out.println("<p></p>");
		}
	 	%>
	 	<br />
	 	<label>나이 : <input type = "number" name = "age" /></label>
	 	<%
	 	String age = request.getParameter("age");
	 	if (progress != null) {
			if(progress.equals("failed")) {
				out.println("<p>나이가 입력되지 않았습니다.</p>");
			}
		} else if (age != null) {
			if(age.equals("failed")) {
				out.println("<p>나이가 입력되지 않았습니다.</p>");
			}
		} else {
			out.println("<p></p>");
		}
	 	%>
	 	<br />
	 	<input type = "submit" />
	 </form>
</body>
</html>