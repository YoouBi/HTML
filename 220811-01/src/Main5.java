import java.util.regex.Pattern;

public class Main5 {
	public static void main(String[] args) {
		Pattern p = Pattern.compile("\\w?"); // \\w는 [a-zA-Z]영문자만 포함하는 걸 표현하는 것
		// 자바에서는 \w가 영문자 w 한개를 나타내는 기호라 \를 한번 더 붙여줘야한다.
		// {3,}로 최대값을 생략하면 3자 이상 최소값을 0으로 써도 된다
		// +를 붙이면 1자 이상
		// ?는 0이거나 1개
		// * 0이상
		
		// \w 문자
		// \d 숫자
		// \s 공백
	}
}
