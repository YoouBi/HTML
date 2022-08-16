package loginpracServlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class boardServlet
 */
@WebServlet("/board")
public class boardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			List<String> articles = new ArrayList<>();

			for (int i = 0; i < 10; i++) {
				articles.add(i + "번째 게시글");
			}
			request.setAttribute("articles", articles);
			request.getRequestDispatcher("/WEB-INF/articles.jsp").forward(request, response);

	}
}
