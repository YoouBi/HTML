package article.model;

public class EmpPlusArticles {
	private Articles articles;
	private Article empLatest;
	
	public EmpPlusArticles(){}
	
	public EmpPlusArticles(Articles articles, Article empLatest) {
		this.articles = articles;
		this.empLatest = empLatest;
	}
	
	public Articles getArticles() {
		return articles;
	}
	public void setArticles(Articles articles) {
		this.articles = articles;
	}
	public Article getEmpLatest() {
		return empLatest;
	}
	public void setEmpLatest(Article empLatest) {
		this.empLatest = empLatest;
	}
}
