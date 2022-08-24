package article.service;

import java.sql.Connection;
import java.sql.SQLException;

import article.dao.ArticleContentDao;
import article.dao.ArticleDao;
import article.model.Article;
import article.model.ArticleContent;
import connection.ConnectionProvider;

public class ReadArticleService {
	private ArticleDao articleDao = new ArticleDao();
	private ArticleContentDao contentDao = new ArticleContentDao();
	
	public Article getArticle(int article_no, boolean increaseReadCount) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			Article article = articleDao.selectById(conn, article_no);
			if(article == null) {
				throw new ArticleNotFoundException();
			}
			ArticleContent content = contentDao.selectById(conn, article_no);
			if(content == null) {
				throw new ArticleContentNotFoundException();
			}
			if(increaseReadCount) {
				articleDao.increaseReadCount(conn, article_no);
			}
			return article;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
