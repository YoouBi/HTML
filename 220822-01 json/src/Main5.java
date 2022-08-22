import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Main5 {
	public static void main(String[] args) {
		String apiUrl = "https://httpbin.org/get";
		
		OkHttpClient client = new OkHttpClient();
		Request req = new Request.Builder().url(apiUrl).build();
		// .Builder()는 요청 객체를 만들고자 할 때 설정해줄 수 있다
		
		try (Response resp = client.newCall(req).execute()) {
			if(resp.code() == 200) {
				System.out.println(resp.body().string());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
