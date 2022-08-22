import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Main {
	public static void main(String[] args) throws JsonProcessingException {
		// 사람
		// 이름 = 홍길동
		// 나이 = 22
		
		ObjectMapper mapper = new ObjectMapper();	
		ObjectNode node = mapper.createObjectNode();
		
		node.put("name", "홍길동");
		node.put("age", 22);
		node.put("boolean", true); // 문자열, 숫자, boolean도 가능
		
		ObjectNode node2 = mapper.createObjectNode();
		node2.put("이름", "둘리");
		node2.put("나이", 23);
		
		node.set("bf", node2); // json 객체 안에 다른 객체가 포함될 수 있다
		// diprecated
		// 해당 라이브러리에서 사용했던 게 다음에는 사용하지 않을 수 있으니까(삭제될 수 있으니까)
		// 이미 사용한게 있다면 바꾸라고...? 알려주는...?
		
		String json = mapper.writeValueAsString(node);
		System.out.println(json);
	}
}
