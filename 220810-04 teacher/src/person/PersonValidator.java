package person;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonValidator {
	// 이름, 성 10자
	public Map<String, String> isValiName(String firstname, String lastname) {
		Map<String, String> map = new HashMap<>();
		
		Pattern p = Pattern.compile("[가-힣a-zA-Z]{1,10}");
		Matcher mf = p.matcher(firstname);
		Matcher ml = p.matcher(lastname);
		
		if(firstname == null || lastname == null) {
			map.put("nameNull", "이름을 입력해주세요.");
		} else {
			if (firstname.contains(" ") || lastname.contains(" ")) {
				map.put("nameSpace", "이름에 공백을 포함할 수 없습니다.");
			} else if (!(mf.matches() && ml.matches())) {
				if (firstname.length() > 10 || lastname.length() > 10) {
					map.put("namelength", "이름은 1~10자여야합니다.");
				} else {
					map.put("nameChar", "이름은 한글 또는 영문자여야합니다.");
				}
			}			
		}
		
		return map;
	}
	
	// 나이 정수
	public Map<String, String> isValiAge(String age) {
		Map<String, String> map = new HashMap<>();
		
		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(age);
		
		if(age == null || age.length() == 0) {
			map.put("ageNull", "나이를 입력해주세요.");
		} else {
			if(!m.matches()) {
				map.put("ageFormat", "나이는 숫자만 허용됩니다.");
			} else {
				try {
					int num = Integer.valueOf(age);
					if (15 < num && num < 115) {
						map.put("ageRang", "나이의 범위는 15-115세입니다.");
					}
				} catch (NumberFormatException e) {
					map.put("ageRang", "나이의 범위는 15-115세입니다.");
				}
			}
		}
		
		return map;
	}

	// 이메일 50자
	public Map<String, String> isValiEmail(String email) {
		Map<String, String> map = new HashMap<>();
		
		Pattern p = Pattern.compile("\\w+@\\w+.\\w+");
		Matcher m = p.matcher(email);
		
		if(email == null) {
			map.put("emailNull", "이메일을 입력해주세요.");
		} else {	
			if (email.contains(" ")) {
				map.put("emailSpace", "이메일에 공백을 입력할 수 없습니다.");
			} else if (email.length() > 50) {
				map.put("emailLength", "이메일의 길이는 50자를 넘을 수 없습니다.");
			} else if (!m.matches()) {
				map.put("emailFormat", "이메일 양식이 올바르지 않습니다.");
			}
		}
		
		return map;
	}
}
