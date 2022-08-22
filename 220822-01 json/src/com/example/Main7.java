package com.example;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main7 {
	private static String getSaraminINfo(String url) throws IOException {
		Document doc = Jsoup.connect(url).timeout(5000).get(); // timeout은 기본값이 30초로 요청 응답하는 걸 30초동안 계속 기다린다. 오랫동안 기다려야해서 줄인 것
		String info = doc.select("meta[name=description]").first().attr("content"); // css로 first줘도 되고 meta에도 first가 있다...??
		// select 자체가 무조건 리턴값이 여러개를 주기 때문에(element's') first로 '한개'를 들고오는 것
		return info;
	}
	
	public static void main(String[] args) throws IOException {
		String searchURL = "https://www.saramin.co.kr/zf_user/search?search_area=main&search_done=y&search_optional_item=n&searchType=search&searchword=java";
		String startString = "/zf_user/jobs/relay/view";
		
		Document doc = Jsoup.connect(searchURL).timeout(5000).get(); // timeout은 이 요청을 최대한 기다려줄 시간
		Elements links = doc.select("a[href]");
		
		Set<String> set = new HashSet<>();
		for (Element e : links) {
			String attr = e.attr("href");
			if (attr.startsWith(startString)) {
				set.add("http://www.saramin.co.kr" + attr);
			}
		}
		// 헤더 부분에
		// description이라는 요약 정보가 있으니 이걸 가져오면 정보를 볼 수 있겠다
		
//		for (String url : set) {
//			System.out.println(getSaraminINfo(url));
//		}
		
		// 좀 더 빨리 받는 표현
		set.parallelStream().map(url -> { // 아직 배우지 않은 표현이지만 한번에 여러개의 요청을 하고...
			try {
				return getSaraminINfo(url);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			return null;
		}).forEach(System.out::println); // 사람인 클라이언트가 여러개의 요청을 하면 블락해버림
		
		System.out.println(set);
	}
}
