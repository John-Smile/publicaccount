package dto.message.response;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class NewsMessage extends BaseMessage {
	@XStreamAlias("ArticleCount")
	private int articleCount;
	@XStreamAlias("Articles")
	private List<Article> articles;
	
	public int getArticleCount() {
		return articleCount;
	}
	public void setArticleCount(int articleCount) {
		this.articleCount = articleCount;
	}
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
}
