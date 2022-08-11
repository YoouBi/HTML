import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 정규 표현식
// 특정한 값에 대해서 값이 맞는지,
public class Main {
	public static void main(String[] args) {
		String line = "This is a book."; // 인덱스는 0부터 시작
		Pattern p = Pattern.compile("is"); // compile은 static method로 문자열 형태를 넣어줌
		Matcher m = p.matcher(line); // 패턴 객체로 () 안에 검사하고자하는 문자를 넣어줌
		
//		System.out.println(m.lookingAt()); // lookingAt을 호출하면 p와 line의 '시작부분이 같은지' 물어본다
		
		boolean find = m.find();
		if (find) {
			System.out.println(m.start()); // 시작점은 is의 i의 2인데
			System.out.println(m.end()); // 끝점은 is 뒤의 공백 위치인 4이다
		}
		
		find = m.find(); // find에 실행위치를 지정해주고 거기서부터 찾을수도 있다
		if (find) {
			System.out.println(m.start());
			System.out.println(m.end());
		}
		
		find = m.find();
		if (!find) {
			System.out.println("없음");
		}
	}
}
