import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import jdbc.connection.ConnectionProvider;
import sun.misc.Contended;

public class prologController {
	public ArrayList<String> getPrologText(int start, int end) throws Exception{
		ArrayList<String> res = new ArrayList<>();
		
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("");
			ResultSet rs = pstmt.executeQuery();) {
			
			while (rs.next()) {
				res.add(rs.getString(2));
			}
		}
		
		return res;
	}
}
