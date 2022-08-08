<!-- 
	계산 결과 출력 페이지
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
	<%
	int firstnum = Integer.valueOf(request.getParameter("firstnum"));
	int lastnum = Integer.valueOf(request.getParameter("lastnum"));
	String calc = request.getParameter("calc");
	String result = firstnum + " ";
	
	if (calc.equals("plus")) {
		result += "+ " + lastnum + " = " + (firstnum + lastnum);
	} else if (calc.equals("minus")) {
		result += "- " + lastnum + " = " + (firstnum - lastnum);
	} else if (calc.equals("multi")) {
		result += "* " + lastnum + " = " + (firstnum * lastnum);
	} else if (calc.equals("divide")) {
		result += "/ " + lastnum + " = " + (firstnum / lastnum);
	}
	
	out.println(result);
	%>
</body>
</html>