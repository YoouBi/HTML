<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>국가 목록</title>
</head>
<body>
	<!--
	<ul>
		<li>국가이름A</li>
		<li>국가이름B</li>
		<li>국가이름C</li>
	</ul>
	-->
	<%
		Class.forName("com.mysql.cj.jdbc.Driver"); // 패키지 이름과 클래스 이름
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		out.println("<ul>");
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "root");
			stmt = conn.createStatement();
// 			rs = stmt.executeQuery("SELECT 1");
			rs = stmt.executeQuery("SELECT name FROM country");
		
			/* if(rs.next()) {
				int result = rs.getInt(1); // 컬럼의 순서를 집어넣으면 되는데 첫번째 컬럼밖에 없으니까 첫번째 컬럼의 값
				out.println(result == 1 ? "연결 성공" : "연결 실패");
			} */
			
			
			while (rs.next()) {
				String name = rs.getString("name");
				// 한 행의 이름을 리스트로 출력하려면
				out.println("<li>" + name + "</li>");
			}
			
		} finally {
			if (rs != null) {
				rs.close();
			}
			
			if (stmt != null) {
				stmt.close();
			}
			
			if(conn != null) {
				conn.close();
			}
		}
		out.println("</ul>");
	%>
</body>
</html>