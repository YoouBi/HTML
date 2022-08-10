package hello;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class PersonDAO {
	public List<persons> getPerson() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<persons> list = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_db", "root", "root");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM persons");
			
			while (rs.next()) {
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				int age = rs.getInt("age");
				String email = rs.getString("email");
				list.add(new persons(firstname, lastname, age, email));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(rs != null){
				rs.close();
			}
			if(stmt != null){
				stmt.close();
			}
			if(conn != null){
				conn.close();
			}
		}
		return list;
	}
	
	public void setPerson(String firstname, String lastname, int age, String email) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_db", "root", "root");
			pstmt = conn.prepareStatement("INSERT INTO persons(firstname, lastname, age, email)"
					+ " VALUES (?, ?, ?, ?)");
			
			pstmt.setString(1, firstname);
			pstmt.setString(2, lastname);
			pstmt.setInt(3, age);
			pstmt.setString(4, email);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(pstmt != null){
				pstmt.close();
			}
			if(conn != null){
				conn.close();
			}
		}
	}
}
