package article.model;

import java.util.Date;

public class Article {
	private Integer article_no;
	private String user_name;
	private String title;
	private String content;
	private Date reg_date;
	private Date mod_date;
	private int notice_no;
	
	public Article(Integer article_no, String user_name, String title, String content, Date reg_date, Date mod_date,
			int notice_no) {
		this.article_no = article_no;
		this.user_name = user_name;
		this.title = title;
		this.reg_date = reg_date;
		this.mod_date = mod_date;
		this.notice_no = notice_no;
	}
	
	public Integer getArticle_no() {
		return article_no;
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

	public Date getReg_date() {
		return reg_date;
	}
	
	public Date getMod_date() {
		return mod_date;
	}
	
	public int getNotice_no() {
		return notice_no;
	}
}
