import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main6 {
	public static void main(String[] args) {
		String line = "(abc, 123) | (de, 6) | (qwer, 15)";
		Pattern p = Pattern.compile("\\((\\w+), (\\d+)\\)"); // 괄호도 \(인데 자바에서는 \ 한번 더 붙인다
		// 일반 문자 ()는 문자임을 표현하기 위해 \\를 썼지만 그룹을 짓기 위해서는 일반 ()로 값을 잘라낸다
		// 만약 전체를 그룹으로 감싼다면("\\((\\w+, \\d+)\\)") (1)
//		Pattern p = Pattern.compile("\\([a-zA-Z]+, [0-9]+\\)");
		Matcher m = p.matcher(line);
		
		while (m.find()) {
			System.out.println(m.start());
			System.out.println(m.end());
		}
		
		m = p.matcher(line);
		while (m.find()) {
			System.out.println(m.group(1)); // (1) (영문자,숫자) 형태의 그룹 1종류만 나오니까 인쇄는 group(1)만 하면 된다
			System.out.println(m.group(2)); // 이건 (영문자)그룹1과 (숫자)그룹2까지 출력하는 것
		}
	}
}
