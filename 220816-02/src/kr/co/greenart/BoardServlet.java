package kr.co.greenart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/board")
public class BoardServlet extends HttpServlet {
	private final static Logger logger = LoggerFactory.getLogger(BoardServlet.class);
	
	private BoardService service;
	// 객체가 하나 초기화되어있어야하는데 이걸 객체 의존성이라고 부른다	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		service = new BoardService(new BoardDAO());
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("사용자가 GET방식의 요청을 하였습니다. (게시판 목록)");
		logger.info("logger를 통해 메세지를 남깁니다.");
		logger.info("사용자가 Get 요청함. (게시판 목록)");
		
		// slf4j - FATAL / ERROR / WARM / INFO / DEBUG
		// 디버그는 기록을 남겨놓고 개발할 때 볼지 안볼지를 선택할 수 있음
		
//		List<String> articles = new ArrayList<>(Arrays.asList("글1", "글2", "글3"));
		List<BoardArticle> articles = service.게시글목록보기서비스();
		req.setAttribute("articles", articles);
		
		req.getRequestDispatcher("/WEB-INF/articles.jsp").forward(req, resp);
	}
}