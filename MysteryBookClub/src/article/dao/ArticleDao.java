package article.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import article.model.Article;
import jdbc.JdbcUtil;

public class ArticleDao {
	private final int ARTICLELIST = 1;
	private final int EMPLIST = 3;
	//지정범위의 게시글을 읽어오기 위한 select메소드
		//Articles 객체를 삭제하고 아예 list<Article>로 뱉어냄
		public List<Article> select(Connection conn, int categoryNum, int storyNum, int storyNumRefresh, int startRow, int size) throws SQLException {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String query = "SELECT * FROM mbc.article WHERE article_id LIKE '0" 
					+ categoryNum + "%' AND article_id <= (SELECT article_id FROM mbc.article WHERE article_id LIKE '0" 
					+ categoryNum + "%' AND story_num <= '" + storyNum + "_" + storyNumRefresh + "' ORDER BY article_id DESC LIMIT 1)"
					+ " ORDER BY article_id DESC LIMIT " + startRow + ", " + size;
					
			try {
				List<Article> listArticle = new ArrayList<Article>();
				
				// 공지 글 추가
//				pstmt = conn.prepareStatement(emplistquery);
//				rs = pstmt.executeQuery();
//				
//				while (rs.next()) {
//					listArticle.add(converter(rs, EMPLIST));
//				}
//				JdbcUtil.close(rs);
//				JdbcUtil.close(pstmt);
				
				// 게시글 추가
				pstmt = conn.prepareStatement(query);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					if (storyNum == 1) { // 이것도 처리해줘야함!
						listArticle.add(converter(rs, ARTICLELIST));
					} else {
						int storyNumLeft = Integer.valueOf(rs.getString("story_num").split("_")[0]);
						int storyNumRight = Integer.valueOf(rs.getString("story_num").split("_")[1]);
						
						
							listArticle.add(new Article(categoryNum
									, articleNumSplit(rs.getString("article_id"))
									, rs.getString("user_name")
									, rs.getString("title")
									, articleRecordDate(rs.getString("record_time"))[0]
									, articleRecordDate(rs.getString("record_time"))[1]));
						
					}
				}
				
				System.out.println(categoryNum+ "카테고리랑 스토리넘" + storyNum + "이건 스토리 뒤" +storyNumRefresh
						+ "어디서 시작?" + startRow + "어느정도 크기?" + size);
				System.out.println(listArticle);
				return listArticle;
			} finally {
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
			}
		}
		
		public String readArticleContent(Connection conn, String categoryNum, String articleNumS) throws SQLException {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String query = "SELECT content FROM mbc.article WHERE article_id = ?";
			if(categoryNum == "2") {
				query = "SELECT content FROM mbc.notice WHERE notice_no = " + articleNumS;
			}
			
			try {
				pstmt = conn.prepareStatement(query);
				if(categoryNum != "2") {
					pstmt.setString(1, articleIdSum(categoryNum, articleNumS));
				}
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
					article = new Article(categotyNumSplit(rs.getString("article_id"))
							, articleNumSplit(rs.getString("article_id"))
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
		public Article readEmpContent(Connection conn, int storyNum) throws SQLException {
			Article article = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String query = "SELECT * FROM mbc.notice WHERE notice_no = ?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, storyNum);
				rs = pstmt.executeQuery();
				String s = null;
				if (rs.next()) {
					article = new Article(storyNum
							, rs.getString("title"));
				}
				return article;
			} finally {
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
			}
		}

		private Article converter(ResultSet rs, int convertNum) throws SQLException {	
			Article a = new Article();
			if (convertNum == ARTICLELIST) { // ARTICLELIST를 넣으면 내용을 뺀 게시글을 가져오고
				a = new Article(categotyNumSplit(rs.getString("article_id")),
						articleNumSplit(rs.getString("article_id")),
						rs.getString("user_name"),
						rs.getString("title"),
						articleRecordDate(rs.getString("record_time"))[0],
						articleRecordDate(rs.getString("record_time"))[1]);
			} else if (convertNum == EMPLIST) { // EMPLIST를 넣으면 공지글을 가져옴
				String[] arr = LocalDateTime.now().toString().replace("-", ".").split("T");
				a = new Article(2,
						rs.getInt("notice_no"),
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
		public int categotyNumSplit(String article_id) {
			String[] arr = article_id.split("_");
			int categotyNum = Integer.valueOf(arr[0]);
			
			return categotyNum;
		}
		
		//레코드 타임도 현재날짜에서 - 년, 월, 일 한 값은 집어넣는 가공절차
		public String[] articleRecordDate(String record_time) {
			String[] timeArr = null;
			if(record_time.contains("_")) {
				String[] splitArr = record_time.split("_");
				int[ ] intArr = Arrays.stream(splitArr).mapToInt(Integer::parseInt).toArray();
				
				LocalDateTime recordDateTime 
						= LocalDateTime.now().minusYears(intArr[0])
						.minusMonths(intArr[1])
						.minusDays(intArr[2])
						.minusHours(intArr[3])
						.minusMinutes(intArr[4]);
				
				timeArr = String.valueOf(recordDateTime).replace("-", ".").split("T");
			} else {
				timeArr = new String[2];
				timeArr[0] = "0";
				timeArr[1] = "0";
			}
			
			return timeArr;
		}
		
		// 전체 글 수 카운트 -> 페이지 계산
		public int selectCount(Connection conn,  int categoryNum, int storyNum, int storyNumRefresh) throws SQLException {
			Statement stmt = null;
			ResultSet rs = null;
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery("SELECT count(*) FROM mbc.article WHERE article_id LIKE '0" 
				+ categoryNum + "%' AND article_id <= (SELECT article_id FROM article WHERE article_id LIKE '0" 
						+ categoryNum + "%' AND story_num = '" + storyNum + "_" + storyNumRefresh + "');");
				
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