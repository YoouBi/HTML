package article.command;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import article.dao.ArticleDao;
import article.model.Articles;
import jdbc.connection.ConnectionProvider;


@WebServlet("/jsonServlet2")
public class JsonServlet2 extends HttpServlet {
	private ArticleDao articleDao = new ArticleDao();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doHandle(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doHandle(request,response);
    }

    protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("왔냐");
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        
        PrintWriter out = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
		try (Connection conn = ConnectionProvider.getConnection();) {
			int categoryNum = Integer.valueOf(request.getParameter("categoryNum"));
			int storyNum = Integer.valueOf(request.getParameter("storyNum"));
//			System.out.println(categoryNum + "엥... 안왔어...?" + storyNum);
			Articles result = articleDao.select(conn, categoryNum, storyNum);
//			Articles result = articleDao.select(conn, 3);
			String json = mapper.writeValueAsString(result); 
			System.out.println(json);
			out.print(json);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
//        List<Member> list = Arrays.asList(new Member("김네임",25,"하하"), new Member("박네임",45,"엉엉"));
//        Members members = new Members(list);
//        Member member = new Member("김네임",25,"하하");
    }
}