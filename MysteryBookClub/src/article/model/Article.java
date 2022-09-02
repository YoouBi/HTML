package article.model;
import java.util.Date;

public class Article {
	private int category;//추가
	private int article_no;
	private String user_name;
	private String title;
	private String content;
	private String record_date;
	private String record_time;
	
	public Article() {}
	
	//공지용 생성자
	public Article(int article_no, String title) {
		this.category = 2;
		this.article_no = article_no;
		this.user_name = "avanger";
		this.title = title;
	}
	
	public Article(int category, int article_no, String user_name, String title, String record_date,
			String record_time) {
		super();
		this.category = category;
		this.article_no = article_no;
		this.user_name = user_name;
		this.title = title;
		this.record_date = record_date;
		this.record_time = record_time;
	}

	public Article(int category, int article_no, String user_name, String title, String content, String record_date,
			String record_time) {
		super();
		this.category = category;
		this.article_no = article_no;
		this.user_name = user_name;
		this.title = title;
		this.content = content;
		this.record_date = record_date;
		this.record_time = record_time;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
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
	
	public String getRecord_date() {
		return record_date;
	}

	public void setRecord_date(String record_date) {
		this.record_date = record_date;
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
				+ content + ", record_date=" + record_date + ", record_time=" + record_time + "]";
	}
}