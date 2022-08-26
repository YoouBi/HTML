import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcUtil;

public class ArticleDao {
	//지정범위의 게시글을 읽어오기 위한 select메소드
		public Articles select(Connection conn, int categoryNum, int storyNum) throws SQLException {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String query = "SELECT * FROM mbc.article WHERE article_id LIKE '0"+categoryNum +"%' AND story_num = "+storyNum+" order by article_id desc;";
			
			try {
				pstmt = conn.prepareStatement(query);
				
				System.out.println(query);
//				pstmt.setInt(1, categoryNum);
//				pstmt.setInt(2, storyNum);
				rs = pstmt.executeQuery();
				Articles articles = new Articles();
				
				// while문으로 돌리는게 아니라... 아닌가? 순서 될 것 같은데
				// 일단 id 뒷부분만 잘라넣기 해보자
				while (rs.next()) {
					articles.getResult().add(convertArticle(rs));
				}
				return articles;
			} finally {
				JdbcUtil.close(rs);
				JdbcUtil.close(conn);
			}
		}

		private Article convertArticle(ResultSet rs) throws SQLException {	
			return new Article(articleNumSplit(rs.getString("article_id")), rs.getString("user_name"), rs.getString("title"), rs.getString("content"), rs.getString("record_time"));
		}
		
		public int articleNumSplit(String article_id) {
			String[] arr = article_id.split("_");
			int articleNum = Integer.valueOf(arr[1]);
			
			return articleNum;
		}
}
