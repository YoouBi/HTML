package article.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import article.dao.ArticleContentDao;
import article.dao.ArticleDao;
import article.model.Article;
import article.model.ArticleContent;
import jdbc.JdbcUtil;
import connection.ConnectionProvider;

public class WriteArticleService {
	private ArticleDao articleDao = new ArticleDao();
	private ArticleContentDao contentDao = new ArticleContentDao();
	
	public Integer write(WriteRequest req) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			Article article = toArticle(req);
			Article savedArticle = articleDao.insert(conn, article);
			if(savedArticle == null) {
				throw new RuntimeException("fail to insert free_article");
			}
			System.out.println(req.getContent());
			ArticleContent content = new ArticleContent(savedArticle.getArticle_no(), req.getContent());
			ArticleContent savedContent = contentDao.insert(conn, content);
			if(savedContent == null) {
				throw new RuntimeException("fail to insert free_article_content");
			}
			
			conn.commit();
		
			return savedArticle.getArticle_no();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} catch (RuntimeException e) {
			JdbcUtil.rollback(conn);
			throw e;
		} finally {
			JdbcUtil.close(conn);
		}
	}

	private Article toArticle(WriteRequest req) {
		Date now = new Date();
		return new Article(null, req.getUser_name(), req.getTitle(), req.getContent(), now, now, 0);
	}
}
