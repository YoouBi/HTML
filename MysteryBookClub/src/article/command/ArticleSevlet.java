package article.command;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import article.dao.ArticleDao;
import article.model.Article;
import article.service.ArticlePage;
import article.service.ListArticleService;
import jdbc.connection.ConnectionProvider;

@WebServlet("/getArticle")
public class ArticleSevlet extends HttpServlet {
	private ArticleDao articleDao = new ArticleDao();
	private ListArticleService listService = new ListArticleService();
	
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	getList(req,resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	getContent(req,resp);
    }

    protected void getList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	System.out.println("왔냐");
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        
        PrintWriter out = resp.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = new HashMap<>();
        
        String json = "";
		try (Connection conn = ConnectionProvider.getConnection();) {
			// 숫자 0일때 리프레쉬 되도록...
			String type = req.getParameter("categoryNum");
			int categoryNum;
			int pageNum = 1;
			System.out.println(req.getParameter("categoryNum"));
			if(type.contains("/")) {
				categoryNum = Integer.valueOf(req.getParameter("categoryNum").split("/")[0]);
				pageNum = Integer.valueOf(req.getParameter("categoryNum").split("/")[1]);
			} else {
				categoryNum = Integer.valueOf(req.getParameter("categoryNum"));
			}
			int storyNum = Integer.valueOf(req.getParameter("storyNum"));
			int storyNumRefresh = Integer.valueOf(req.getParameter("storyNumRefresh"));
			
			if(req.getParameter("refresh").equals("on")) {
				storyNumRefresh += 1;
				System.out.println(categoryNum + "새로고침");
			} else {
				System.out.println(categoryNum + req.getParameter("refresh") + "카테고리 그대로 들어옴");
			}
			System.out.println(categoryNum + "엥... 안왔어...?" + storyNum + storyNumRefresh);
    		
			ArticlePage articlePage = listService.getArticlePage(pageNum, categoryNum, storyNum, storyNumRefresh);
			json += mapper.writeValueAsString(articlePage);
			System.out.println(json);
			out.print(json); //아무것도 select된게 없으면 null을 반환함
		} catch (SQLException e) {
			e.printStackTrace();	
		}
//        List<Member> list = Arrays.asList(new Member("김네임",25,"하하"), new Member("박네임",45,"엉엉"));
//        Members members = new Members(list);
//        Member member = new Member("김네임",25,"하하");
    }
    
    private void getContent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	System.out.println("내용 얻으러 왔냐");
    	req.setCharacterEncoding("utf-8");
    	resp.setContentType("application/json;charset=utf-8");
    	
    	PrintWriter out = resp.getWriter();
    	ObjectMapper mapper = new ObjectMapper();
    	ObjectNode node = mapper.createObjectNode();
    	Map<String, Object> map = new HashMap<String, Object>();
    	
    	String json = null;
    	try (Connection conn = ConnectionProvider.getConnection();) {
    		Article article = null;
    		String contentinfo = String.valueOf(req.getParameter("contentinfo"));
    		System.out.println(contentinfo);
    		String[] arr = contentinfo.split("/"); //arr[0]:카테고리넘버, arr[1]:아티클넘버, arr[2]:제목, arr[3]:작성자, arr[4]:작성일, arr[5]:작성시간
    		String content = "";
    		if(arr.length == 2) {
    			article = articleDao.readBAContent(conn, arr[0], arr[1]);
    		} else {
    			if(arr[0].equals("2")) {//카테고리넘버를 2로 넘겨줬으면 공지글이란 소리임
        			content = articleDao.readArticleContent(conn, "2", arr[1]);
        		} else {
        			content = articleDao.readArticleContent(conn, arr[0], arr[1]);
        		}
        		article = new Article(Integer.valueOf(arr[0]), Integer.valueOf(arr[1]), arr[3], arr[2], content, arr[4], arr[5]);
    		}
    		
    		json = mapper.writeValueAsString(article);
    		System.out.println("게시글: " + json);
    		out.print(json);
    	} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}