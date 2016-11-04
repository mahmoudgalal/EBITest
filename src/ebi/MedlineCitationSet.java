package ebi;

import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name="MedlineCitationSet")
public class MedlineCitationSet {
	@ElementList(inline=true)
	private List<Article> articles;
	
	
	public List<Article> getArticles() {
		return articles;
	}
	
	public MedlineCitationSet() {
		// TODO Auto-generated constructor stub
	}

}
