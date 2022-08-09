<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
Class.forName("com.mysql.cj.jdbc.Driver");

Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

List<String> clist = new ArrayList<>();
List<Integer> plist = new ArrayList<>(); 

String continent = request.getParameter("continent");
String orderBy = request.getParameter("OrderBy");
String query = "SELECT * FROM country WHERE continent = '" + continent + "' order by population " + orderBy;

try {
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "root");
	pstmt = conn.prepareStatement(query);
	rs = pstmt.executeQuery();
	
// 	pstmt.setString(1, continent);
	//pstmt.setString(2, orderBy);
	
	while (rs.next()) {
		clist.add(rs.getString("name"));
		plist.add(rs.getInt("population"));
	}
} finally {
	if (rs != null) {
		rs.close();
	}
	
	if (pstmt != null) {
		pstmt.close();
	}
	
	if (conn != null) {
		conn.close();
	}
}

request.setAttribute("countries", clist);
request.setAttribute("populations", plist);
request.getRequestDispatcher("viewpopulation.jsp").forward(request, response);
%>