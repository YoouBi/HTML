package article.service;

import java.util.Map;

public class WriteRequest {
	private String user_name;
	private String title;
	private String content;
	
	public WriteRequest(String user_name, String title, String content) {
		super();
		this.user_name = user_name;
		this.title = title;
		this.content = content;
	}
	
	public String getUser_name() {
		return user_name;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	
	public void validate(Map<String, Boolean> errors) {
		if(title == null || title.trim().isEmpty()) {
			errors.put("title", Boolean.TRUE);
		}
	}
}
