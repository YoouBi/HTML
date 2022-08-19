package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SaveDao {
	// 저장 기록 불러오기 -> 나중에 뭐 불러올건지 세분화해서 나누자
	public Savelog selectSavelog(Connection conn, String id) throws Exception {
		Savelog save = null;
		try (PreparedStatement pstmt = conn.prepareStatement("SELECT ");
				ResultSet rs = pstmt.executeQuery();) {
			// TODO 작성해야함
		}
		return save;
	}
	
	// 업적만 불러오기 -> 클래스도 세분화해야할듯
}