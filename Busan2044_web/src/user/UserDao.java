package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {
	public User selectUser(Connection conn, String id) throws Exception {
		User user = null;
		try(PreparedStatement pstmt = conn.prepareStatement("SELECT id, password, name, birthday, callNum "
				+ "FROM busan.login_info");
				ResultSet rs = pstmt.executeQuery();) {
			while (rs.next()) {
				if(rs.getString("id").equals(id)) {
					user = new User(rs.getString("id"), 
							rs.getString("password"), 
							rs.getString("name"), 
							rs.getInt("birthday"), 
							rs.getString("callNum"));
				}
			}
		}
		return user;
	}
	
	public void insertUser(Connection conn, User user) throws Exception {
		try(PreparedStatement pstmt = conn.prepareStatement("INSERT INTO login_info "
				+ "(id, password, name, birthday, callNum) "
				+ "VALUES (?, ?, ?, ?, ?)");) {
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPw());
			pstmt.setString(3, user.getName());
			pstmt.setInt(4, user.getBirthday());
			pstmt.setString(5, user.getCallNum());
			pstmt.executeUpdate();
		}
	}
}
