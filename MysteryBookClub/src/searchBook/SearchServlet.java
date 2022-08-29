package searchBook;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@WebServlet("/search") // 슬러쉬가 있어야 http://localhost:8080/MBC/search
public class SearchServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("여기옴?");
		req.setCharacterEncoding("UTF-8"); //이건 req.getParameter("title")할 때 한글 읽어내기 위해서 함!!!
		String apiURL = "https://dapi.kakao.com/v3/search/book?target=title&size=1&query="; //단 한권만 검색!
		String title = req.getParameter("title");
		System.out.println(title);
		String requestURL = apiURL + URLEncoder.encode(title, "UTF-8"); //이건 그 title을 OkHttpClient써서 url에 한글 담기 위해 함!!!!
//		String requestURL = apiURL + title; //이래하면 한글 인식못해서 주소에 깨진문자가 들어감
		System.out.println(requestURL);

		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().addHeader("Authorization", "KakaoAK 38cf7b285a37d7aacda85a8b16bca119").url(requestURL).build();

		try (Response response = client.newCall(request).execute()) {
			if (response.code() == 200) {
//				System.out.println(response.body().string());
				String result = response.body().string();
				resp.setContentType("application/json; charset=utf-8");
				resp.getWriter().print(result); // 전송이 되는 부분
				//json으로 받아온걸 json으로 바로 전달해줘버리면 됨!! mapper도 필요없음
				
//				ObjectMapper mapper = new ObjectMapper();
//				Books books = mapper.readValue(result, Books.class);
//				if (books.getDocuments().size() != 0) {
//					req.setAttribute("istrue", true);
//					req.setAttribute("bookResult", books.getDocuments().get(0)); //단 한권만 있음
//					System.out.println(books.getDocuments().toString()); //하나 들은 배열
//					System.out.println(books.getDocuments().get(0).toString()); //그 하나를 가져옴
//					System.out.println(books.getDocuments().get(0).getTitle()); //걔의 타이틀
//					System.out.println(books.getDocuments().get(0).getContents()); //걔의 설명
//					
//				} else {
//					req.setAttribute("isfalse", true);
//				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
//		req.getRequestDispatcher("bin_board.jsp").forward(req, resp);
//		resp.sendRedirect("searchform.jsp"); // 슬러쉬가 없어야 http://localhost:8080/MBC/searchform.jsp
	}

}
