import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main2 {
	public static void main(String[] args) {
		String line = "1 He2llo. 3 Wor4ld! 5";
//		String line = "19 He28llo. 37 Wor4ld! 5"; // 이런 연속된 숫자는 char로 찾아짐
		
		// 뒤죽박죽인 문자열에서 숫자만 찾아내려면
		Pattern p = Pattern.compile("[0-9]"); // []로 문자 하나에 대한 '범위를 설정'할 수 있다
//		Pattern p = Pattern.compile("[3-4]");
//		Pattern p = Pattern.compile("[A-Z]");
		Matcher m = p.matcher(line);
		
		m.find();
		System.out.println(m.start());
		m.find();
		System.out.println(m.start());
		m.find();
		System.out.println(m.start());
		m.find();
		System.out.println(m.start());
		m.find();
		System.out.println(m.start());
		m.find();
		System.out.println(m.start());
	}
}
