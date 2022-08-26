import java.util.Date;

public class Article {
	private int article_no;
	private String user_name;
	private String title;
	private String content;
	private String record_time;
	
	public Article() {}
	
	public Article(int article_no, String user_name, String title, String content, String record_time) {
		super();
		this.article_no = article_no;
		this.user_name = user_name;
		this.title = title;
		this.content = content;
		this.record_time = record_time;
	}

	public int getArticle_no() {
		return article_no;
	}

	public void setArticle_no(int article_no) {
		this.article_no = article_no;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRecord_time() {
		return record_time;
	}

	public void setRecord_time(String record_time) {
		this.record_time = record_time;
	}

	@Override
	public String toString() {
		return "Article [article_no=" + article_no + ", user_name=" + user_name + ", title=" + title + ", content="
				+ content + ", record_time=" + record_time + "]";
	}
}
