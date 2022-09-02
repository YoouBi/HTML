package article.service;

import java.util.List;

import article.model.Article;

public class ArticlePage {
	private int total;
	private int currentPage;
	private Article noticeArticle; // 최신 공지글
	private String categoryText;
	private List<Article> content; // 각 게시판의 리스트
	private int totalPages;
	private int startPage;
	private int endPage;
	
	public ArticlePage(int total, int currentPage, int size, Article noticeArticle, List<Article> content) {
		this.total = total;
		this.currentPage = currentPage;
		this.noticeArticle = noticeArticle;
		this.content = content;
		if(total == 0) {
			totalPages = 0;
			startPage = 0;
			endPage = 0;
		} else {
			totalPages = total / size;
			if(total % size > 0) {
				totalPages++;
			}
			int modVal = currentPage % 5;
			startPage = currentPage / 5 * 5 + 1;
			if(modVal == 0) startPage -=5;
			
			endPage = startPage +4;
			if(endPage > totalPages) endPage = totalPages;
		}
		int categoryNum = content.get(0).getCategory();
		switch (categoryNum) {
		case 1:
			categoryText = "내 글 보기";
			break;
		case 2:
			categoryText = "공지사항";
			break;
		case 3:
			categoryText = "주간도서";
			break;
		case 4:
			categoryText = "가입인사";
			break;
		case 5:
			categoryText = "자유게시판";
			break;
		case 6:
			categoryText = "우리 모여요!";
			break;
		default:
			break;
		}
	}

	public int getTotal() {
		return total;
	}
	
	public boolean hasNoArticles() {
		return total == 0;
	}
	
	public boolean hasArticles() {
		return total > 0;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getTotalPages() {
		return totalPages;
	}
	
	public Article getNoticeArticle() {
		return noticeArticle;
	}

	public void setNoticeArticle(Article noticeArticle) {
		this.noticeArticle = noticeArticle;
	}
	
	public String getCategoryText() {
		return categoryText;
	}

	public void setCategoryText(String categoryText) {
		this.categoryText = categoryText;
	}

	public List<Article> getContent() {
		return content;
	}

	public void setContent(List<Article> content) {
		this.content = content;
	}

	public int getStartPage() {
		return startPage;
	}
	public int getEndPage() {
		return endPage;
	}
}
