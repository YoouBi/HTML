package article.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Arrays;

import article.model.Article;
import article.model.Articles;
import jdbc.JdbcUtil;

public class ArticleDao {
	private final int ARTICLELIST = 1;
	private final int EMPLIST = 3;
	//지정범위의 게시글을 읽어오기 위한 select메소드
		public Articles select(Connection conn, int categoryNum, int storyNum, int storyNumRefresh) throws SQLException {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String emplistquery = "SELECT * FROM mbc.notice WHERE notice_no = " + storyNum ;
			String articlelistquery = "SELECT * FROM mbc.article WHERE article_id LIKE '0" + categoryNum 
						+ "%' ORDER BY article_id DESC;";
					
			try {
				Articles articles = new Articles();
				
				// 공지 글 추가
				pstmt = conn.prepareStatement(emplistquery);
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					articles.getResult().add(converter(rs, EMPLIST));
				}
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
				
				// 게시글 추가
				pstmt = conn.prepareStatement(articlelistquery);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					if (storyNum == 1) {
						articles.getResult().add(converter(rs, ARTICLELIST));
					} else {
						int storyNumLeft = Integer.valueOf(rs.getString("story_num").split("_")[0]);
						int storyNumRight = Integer.valueOf(rs.getString("story_num").split("_")[1]);
						
						if (storyNumLeft <= storyNum && storyNumRight <= storyNumRefresh) {
							articles.getResult().add(converter(rs, ARTICLELIST));
						}
					}
				}
				return articles;
			} finally {
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
			}
		}
		
		public String readArticleContent(Connection conn, String categoryNum, String articleNumS) throws SQLException {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String query = "SELECT content FROM mbc.article WHERE article_id = ?";
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, articleIdSum(categoryNum, articleNumS));
				rs = pstmt.executeQuery();
				String s = null;
				if (rs.next()) {
					s = rs.getString(1);
				}
				return s;
			} finally {
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
			}
		}
		
		public Article readBAContent(Connection conn, String categoryNum, String articleNumS) throws SQLException {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			Article article = null;
			String query = "SELECT * FROM mbc.article WHERE article_id = ?";
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, articleIdSum(categoryNum, articleNumS));
				rs = pstmt.executeQuery();
				
				if (rs.next()) {
					article = new Article(articleNumSplit(rs.getString("article_id"))
							, rs.getString("user_name")
							, rs.getString("title")
							, rs.getString("content")
							, articleRecordDate(rs.getString("record_time"))[0]
							, articleRecordDate(rs.getString("record_time"))[1]);
				}
				
				return article;
			} finally {
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
			}
		}
		
		// 아티클 아이디 자동합성
		public String articleIdSum(String categoryNum, String articleNumS) {
			String articleId = "0" + categoryNum + "_";
			
			int articleNum = Integer.valueOf(articleNumS);
			if(articleNum / 100 >= 1) {
				articleId += articleNum;
			} else if (articleNum / 10 >= 1) {
				articleId += "0" + articleNum;
			} else {
				articleId += "00" + articleNum;
			}
			
			return articleId;
		}
		
		// 최신공지 읽어오기
		public String readEmpContent(Connection conn, String storyNum) throws SQLException {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String query = "SELECT content FROM mbc.notice WHERE notice_no = ?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, storyNum);
				rs = pstmt.executeQuery();
				String s = null;
				if (rs.next()) {
					s = rs.getString(1);
				}
				return s;
			} finally {
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
			}
		}

		private Article converter(ResultSet rs, int convertNum) throws SQLException {	
			Article a = new Article();
			if (convertNum == ARTICLELIST) { // ARTICLELIST를 넣으면 내용을 뺀 게시글을 가져오고
				a = new Article(articleNumSplit(rs.getString("article_id")),
						rs.getString("user_name"),
						rs.getString("title"),
						articleRecordDate(rs.getString("record_time"))[0],
						articleRecordDate(rs.getString("record_time"))[1]);
			} else if (convertNum == EMPLIST) { // EMPLIST를 넣으면 공지글을 가져옴
				String[] arr = LocalDateTime.now().toString().replace("-", ".").split("T");
				a = new Article(rs.getInt("notice_no"),
						"revenger",
						rs.getString("title"),
						arr[0],
						arr[1]);
			} 
			return a;
		}
		
		public int articleNumSplit(String article_id) {
			String[] arr = article_id.split("_");
			int articleNum = Integer.valueOf(arr[1]);
			
			return articleNum;
		}
		
		//레코드 타임도 현재날짜에서 - 년, 월, 일 한 값은 집어넣는 가공절차
		public String[] articleRecordDate(String record_time) {
			String[] splitArr = record_time.split("_");
			int[ ] intArr = Arrays.stream(splitArr).mapToInt(Integer::parseInt).toArray();
			
			LocalDateTime recordDateTime 
					= LocalDateTime.now().minusYears(intArr[0])
					.minusMonths(intArr[1])
					.minusDays(intArr[2])
					.minusHours(intArr[3])
					.minusMinutes(intArr[4]);
			
			String[] timeArr = String.valueOf(recordDateTime).replace("-", ".").split("T");
			
			return timeArr;
		}
		
		// 전체 글 수 카운트 -> 페이지 계산
		public int selectCount(Connection conn,  int categoryNum, int storyNum) throws SQLException {
			Statement stmt = null;
			ResultSet rs = null;
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery("select count(*) from article WHERE article_id LIKE '0" + categoryNum
										+ "%' AND story_num LIKE '" + storyNum + "%'");
				if(rs.next()) {
					return rs.getInt(1);
				}
				
				return 0;
			} finally {
				JdbcUtil.close(rs);
				JdbcUtil.close(stmt);
			}
		}
}