import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import com.example.AppleSearchResult;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main3 {
	public static void main(String[] args) throws UnsupportedEncodingException, MalformedURLException {
//		String apiURL = "http://itunes.apple.com/search?limit=1&term=";
		String apiURL = "http://itunes.apple.com/search?term=";
		
		String requestURL = apiURL + URLEncoder.encode("아이유", "UTF-8");
		
		URL url = new URL(requestURL);
		HttpURLConnection conn = null;
		
		try {
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			
			int recponseCode = conn.getResponseCode();
			if(recponseCode == HttpURLConnection.HTTP_OK) {
				String respBody = readBody(conn.getInputStream()); // 응답 body 살펴보기
//				System.out.println(respBody);
				
				ObjectMapper mapper = new ObjectMapper();
				AppleSearchResult apple = mapper.readValue(respBody, AppleSearchResult.class);
				System.out.println(apple.getResultCount());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				conn.disconnect();
			}
		}
	}

	private static String readBody(InputStream inputStream) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
		StringBuilder sb = new StringBuilder();
		
		String line;
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		return sb.toString();
	}
}

// Plain Old Java Objects 
// 기본 생성자가 있고 게터세터가 있는 객체
