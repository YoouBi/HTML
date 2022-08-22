import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;

// post 방식으로 json을 써보자!
public class Main4 {
	public static void main(String[] args) throws MalformedURLException {
		String apiURL = "https://httpbin.org/post";
		URL url = new URL(apiURL);
		HttpURLConnection conn = null;
		try {
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-type", "application/json; charset=utf-8");
			// header에는 media type(= MIME type)이 들어가는데...
			// f12로 헤더를 보면 Content-type이 있다
			// 이를 설정하기 위해서 
			conn.setRequestProperty("Accept", "application/json"); // 보내는게 json인데 받고자하는 것도 json이면 좋겠다고 설정하는 것
			conn.setDoOutput(true); // DoOutput은 리퀘스트 바디에 뭔가를 담아갈 때, 출력하고자 할 때 설정해줘야한다
			// post일 때 쓰는거니 get일때는 안건드려도 된다
			
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(new Person("홍길동", 22));
			
			byte[] body = json.getBytes();
			
			conn.getOutputStream().write(body, 0 ,body.length);
			
			if(conn.getResponseCode() == 200) {
				System.out.println(readBody(conn.getInputStream()));
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