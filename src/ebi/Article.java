package ebi;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
@Root(name="Article")
public class Article {
	
	
	public String getArticleTitle() {
		return ArticleTitle;
	}

	public List<Author> getAuthorList() {
		return AuthorList;
	}
	
	@Element
	private String ArticleTitle;
	@ElementList
	private List<Author> AuthorList;
	
	public Article() {
		// TODO Auto-generated constructor stub
	}

}
