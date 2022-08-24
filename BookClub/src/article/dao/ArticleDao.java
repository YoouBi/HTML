package article.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import article.model.Article;
import jdbc.JdbcUtil;

public class ArticleDao {
	public Article insert(Connection conn, Article article) throws SQLException {
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement("insert into free_article"
					+ " (user_name, title, content, reg_date, mod_date, notice_no)"
					+ " values (?, ?, ?, ?, ?, 0)");
			
			pstmt.setString(1, article.getUser_name());
			pstmt.setString(2, article.getTitle());
			pstmt.setString(3, article.getContent());
			pstmt.setTimestamp(4, toTimestamp(article.getReg_date()));
			pstmt.setTimestamp(5, toTimestamp(article.getMod_date()));
			int insertedCount = pstmt.executeUpdate();
			
			if(insertedCount > 0) {
				stmt = conn.createStatement();
				rs = stmt.executeQuery("select last_insert_id() from free_article");
				if(rs.next()) {
					Integer newNo = rs.getInt(1);
					return new Article(newNo, 
							article.getUser_name(), 
							article.getTitle(),
							article.getContent(),
							article.getReg_date(), 
							article.getMod_date(),
							0);
				}
			}
			return null;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(pstmt);
		}
	}
	
	private Timestamp toTimestamp(Date date) {
		return new Timestamp(date.getTime());
	}
	
	// 게시글 전체 수
	public int selectCount(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from free_article");
			if(rs.next()) {
				return rs.getInt(1);
			}
			
			return 0;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}
	
	// 게시글 페이지 만들 때 쓰려는 리스트
	public List<Article> select(Connection conn, int startRow, int size) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement("select * from free_article order by article_no desc limit ?, ?");
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, size);
			rs = pstmt.executeQuery();
			List<Article> result = new ArrayList<>();
			while (rs.next()) {
				result.add(convertArticle(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	// 게시글 DB에서 불러오기
	private Article convertArticle(ResultSet rs) throws SQLException {
		return new Article(rs.getInt("article_no"),
				rs.getString("user_name"),
				rs.getString("title"),
				rs.getNString("content"),
				toDate(rs.getTimestamp("reg_date")),
				toDate(rs.getTimestamp("mod_date")),
				rs.getInt("notice_no"));
	}

	private Date toDate(Timestamp timestamp) {
		return new Date(timestamp.getTime());
	}
	
	// 게시글 번호로 찾기
	public Article selectById(Connection conn, int no) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from free_article where article_no = ?");
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			Article article = null;
			if(rs.next()) {
				article = convertArticle(rs);
			}
			return article;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	// 조회수 1 추가
	public void increaseReadCount(Connection conn, int no) throws SQLException {
		try (PreparedStatement pstmt = conn.prepareStatement(
				"update free_article set notice_no = notice_no + 1 where article_no = ?")) {
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
		}
	}
	
	// 업로드 시간 업데이트
	public int update(Connection conn, int no, String title) throws SQLException {
		try (PreparedStatement patmt = conn.prepareStatement("update free_article set title = ?, mod_date = now() where article_no = ?")) {
			patmt.setString(1, title);
			patmt.setInt(2, no);
			return patmt.executeUpdate();
		}
	}
}
