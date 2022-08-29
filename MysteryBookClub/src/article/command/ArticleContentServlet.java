package article.command;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.dao.ArticleDao;
import article.model.Article;
import jdbc.connection.ConnectionProvider;

@WebServlet("/read.do")
public class ArticleContentServlet extends HttpServlet {
	ArticleDao articleDao = new ArticleDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
		
		int categoryNum = Integer.valueOf(req.getParameter("categoryNum"));
		int articleNum = Integer.valueOf(req.getParameter("no"));
		
		try(Connection conn = ConnectionProvider.getConnection()) {
			Article article = articleDao.readArticleContent(conn, categoryNum, articleNum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
