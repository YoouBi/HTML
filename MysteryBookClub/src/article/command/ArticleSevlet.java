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
import article.model.Articles;
import jdbc.connection.ConnectionProvider;

@WebServlet("/getArticle")
public class ArticleSevlet extends HttpServlet {
	private ArticleDao articleDao = new ArticleDao();
	
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
        
        String json = null;
		try (Connection conn = ConnectionProvider.getConnection();) {
			// 숫자 0일때 리프레쉬 되도록...
			int categoryNum = 0;
			int storyNum = Integer.valueOf(req.getParameter("storyNum"));
			int storyNumRefresh = Integer.valueOf(req.getParameter("storyNumRefresh"));
			
			if(req.getParameter("refresh").equals("on")) {
				categoryNum = Integer.valueOf(req.getParameter("categoryNum"));
				storyNumRefresh += 1;
				System.out.println(categoryNum + "계속 저장될까요?");
			} else {
				ServletContext application = req.getServletContext();
				categoryNum = Integer.valueOf(req.getParameter("categoryNum"));
				application.setAttribute("categoryNumSave", categoryNum);
				System.out.println(categoryNum + req.getParameter("refresh") + "카테고리 넘 저장될까?");
			}
			
			System.out.println(categoryNum + "엥... 안왔어...?" + storyNum + storyNumRefresh);
			Articles result = articleDao.select(conn, categoryNum, storyNum, storyNumRefresh);
//			Article result2 = articleDao.empLatestSelect(conn, storyNum); // 최신 공지
			
			if (result.getResult().size() != 0) { //db에서 담아온게 뭐라도 있으면!
//				map.put("articleList", articleDao.select(conn, categoryNum, storyNum, storyNumRefresh));
//				map.put("categoryNum", categoryNum);
				
//				json = mapper.writeValueAsString(map);
				json = mapper.writeValueAsString(result);
				System.out.println(json);
			}
			
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
    			if(arr[0].equals("999")) {//카테고리넘버를 999로 넘겨줬으면 공지글이란 소리임
        			content = articleDao.readEmpContent(conn, arr[1]);
        		} else {
        			content = articleDao.readArticleContent(conn, arr[0], arr[1]);
        		}
        		article = new Article(Integer.valueOf(arr[1]), arr[3], arr[2], content, arr[4], arr[5]);
    		}
    		
    		node.put("category", arr[0]);
    		node.put("article", mapper.writeValueAsString(article));
    		node.put("articleNumBefore", Integer.valueOf(arr[1]) - 1);
    		node.put("articleNumAfter", Integer.valueOf(arr[1]) + 1);
    		
    		json = mapper.writeValueAsString(node);
    		System.out.println("게시글: " + json);
    		out.print(json);
    	} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}