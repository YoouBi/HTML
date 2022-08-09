<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>context가 뭔가요?</p>
	<!-- 개발자들이 어플리케이션 개발에 필요한, 사용할 수 있는 정보들을 모아놓는 공간
	자바로 치자면 객체. 혹은 어플리케이션 하나라고 생각해도 되는데 모호하다
	각각의 개발 과정에 따라서 제공하는게 다를텐데 getter를 통해서 그 정보를 가져올 수 있도록 만들고 있다 -->
	<%
		ServletRequest req = pageContext.getRequest();
		out.println(req == request);
		out.println("<br />");
		ServletResponse resp = pageContext.getResponse();
		out.println(resp == response);		
	%>
</body>
</html>