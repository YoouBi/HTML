<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인적정보</title>
</head>
<body>
<%
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	
	if ((name == null || name.length() == 0) 
			&&(age == null || age.length() == 0)) {
		response.sendRedirect("./person.jsp?progress=failed");
	} else if (name == null || name.length() == 0) {
		response.sendRedirect("./person.jsp?name=failed");
	} else if (age == null || age.length() == 0) {
		response.sendRedirect("./person.jsp?age=failed");
	} else {
		out.println(name + "님 환영합니다!");
	}
%>
</body>
</html>