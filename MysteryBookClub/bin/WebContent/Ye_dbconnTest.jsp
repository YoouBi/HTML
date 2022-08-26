<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="jdbc.connection.ConnectionProvider" %>
<%@ page import="java.sql.*" %>
<html>
<head><title>연결 테스트</title></head>
<body>

<%-- 이것도 그냥 복붙했읍니다....... 잘 되는걸 일단 0824 10:30 확인했는데,
문제는 web.xml에 DB user를 일단 나로 해뒀는데, 다른 컴퓨터에서도 똑같은 사용자로 했을때 되는지를 모르겠읍니다...  --%>
<%
	try (Connection conn = ConnectionProvider.getConnection()) {
		out.println("커넥션 연결 성공함");
	} catch(SQLException ex) {
		out.println("커넥션 연결 실패함 : " + ex.getMessage());
		application.log("커넥션 연결 실패", ex);
	}
%>
</body>
</html>
