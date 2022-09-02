package article.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import article.dao.ArticleDao;
import article.model.Article;
import jdbc.connection.ConnectionProvider;

public class ListArticleService {
	private ArticleDao articleDao = new ArticleDao();
	private int size = 11;
	
	public ArticlePage getArticlePage(int pageNum, int categoryNum, int storyNum, int storyNumRefresh) {
		try (Connection conn = ConnectionProvider.getConnection()){
			int total = articleDao.selectCount(conn, categoryNum, storyNum, storyNumRefresh);
			List<Article> articles = articleDao.select(conn, categoryNum, storyNum, storyNumRefresh, (pageNum - 1) * size, size);
			return new ArticlePage(total, pageNum, size, articleDao.readEmpContent(conn, storyNum), articles);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
