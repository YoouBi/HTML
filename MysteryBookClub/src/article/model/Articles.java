package article.model;

import java.util.ArrayList;
import java.util.List;

public class Articles {
	private List<Article> result = new ArrayList<Article>();

	public Articles() {}
	
	public Articles(List<Article> result) {
		this.result = result;
	}

	public List<Article> getResult() {
		return result;
	}

	public void setResult(List<Article> result) {
		this.result = result;
	}
}