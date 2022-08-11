import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main3 {
	public static void main(String[] arge) {
		String line = "123 He234llo. 39 Wor48ld! 57";
		Pattern p = Pattern.compile("[0-9]{2,3}"); // 우측에 길이값을 줄 수 있음! 2자리에서 3자리 숫자를 찾아라
		Matcher m = p.matcher(line);
		
		m.find(); // 처음 123의 12를 두개의 숫자로 인식
		System.out.println(m.start());
		System.out.println(m.end());
		
		m.find();
		System.out.println(m.start());
		System.out.println(m.end());
	}
}
