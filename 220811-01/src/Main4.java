import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main4 {
	public static void main(String[] args) {
		String line1 = "lowercase";
		String line2 = "UPPERCASE";
		String line3 = "1q2w3e";
		
		Pattern p1 = Pattern.compile("[a-z]{9}");
		Matcher m1 = p1.matcher(line1);
		Pattern p2 = Pattern.compile("[A-Z]{9}");
		Matcher m2 = p2.matcher(line2);
		
		System.out.println(m1.matches()); // matches는 해당 정규 표현식과 비교하는 문자열이 일치할때 true값 반환
		System.out.println(m2.matches());
		
		Pattern p3 = Pattern.compile("[0-9a-z]{6}"); // 범위를 여러개 표현하는 것도 가능하다
		Matcher m = p3.matcher(line3);
		System.out.println(m.matches());
		
		// 아이디를 만드는데 영소문자와 숫자로 이루어져야하고 영문자로 시작되는 최소 6자, 최대 10자의 문자열이어야 함
		Scanner scan = new Scanner(System.in);
		System.out.println("아이디를 입력하세요.");
		String Id = scan.nextLine();
		Pattern IdP = Pattern.compile("[0-9a-z]{6,10}");
		Pattern IdAP = Pattern.compile("[a-z]{1,10}");
		Pattern IdNP = Pattern.compile("[0-9]{1,10}");
		Matcher IdM = IdP.matcher(Id);
		Matcher IdAM = IdAP.matcher(Id);
		Matcher IdNM = IdNP.matcher(Id);
		
		if(!IdM.matches()) {
			System.out.println("올바르지 않은 입력값입니다.");
		} else if(!IdAM.matches()) { // 영문자 필수로 넣어야함!
			System.out.println("영문자를 적어도 1개 포함해야합니다.");
		} else if(!IdNM.matches()) { // 숫자 필수로 넣어야함!
			System.out.println("숫자를 적어도 1개 포함해야합니다.");
		} else {
			System.out.println("올바른 아이디입니다.");
		}
		
		// 올바른 전화번호 (010-####-####)
		System.out.println("전화번호를 입력하세요.");
		String CallNum = scan.nextLine();
		Pattern CallS = Pattern.compile("010");
		Pattern CallP = Pattern.compile("[0-9]+[-]");
		Pattern CallCH = Pattern.compile("-");
		Matcher CallM = CallS.matcher(CallNum);
		Matcher CallMP = CallP.matcher(CallNum);
		Matcher CallMCH = CallCH.matcher(CallNum);
		
		String check = "";
		
		if(CallM.start() == 0 && CallMP.matches()) {
			for (int i = 0; i < CallNum.length(); i++) {
				if(CallMCH.find()) {
					check += CallMCH.start();
				}
			}
			
			if(check.equals("38")) {
				System.out.println("올바른 입력입니다.");
			}
		}
		
		// 올바른 전화번호 선생님꺼!!! 아...- 그냥 쓰면 되는구나...ㅠㅠㅠ
		String regex = "010-[0-9]{4}-[0-9]{4}";
		Pattern p = Pattern.compile(regex);
		System.out.println(p.matcher("010-1234-5678").matches());
		System.out.println(p.matcher("010-1234-aaaa").matches());
		System.out.println(p.matcher("010-@#$%-5678").matches());
		System.out.println(p.matcher("01012345678").matches());
		System.out.println(p.matcher("011-123-5678").matches());
	}

}
