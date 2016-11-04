package ebi;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class Main {

	private static List<String> names = new ArrayList<>();
	private static List<Author> authors = new ArrayList<>();
	private static HashMap<AuthorPair,Integer> map = new HashMap<>();
	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Serializer serializer = new Persister();
		File source = new File("testdata.xml");

		try {
			MedlineCitationSet example = serializer.read(MedlineCitationSet.class, source);
			printOutput(example);
			// Print the matrix to stdout			
			/*Set<Entry<AuthorPair,Integer>> set = map.entrySet();
			for(Entry<AuthorPair,Integer> entry:set){
				AuthorPair pair = entry.getKey();
				int val = entry.getValue();
				String auth1 = pair.author1.getLastName()+","+pair.author1.getForeName();
				String auth2 = pair.author2.getLastName()+","+pair.author2.getForeName();
				String st = auth1+":"+auth2+":"+val;
				System.out.println(st);
			}*/
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private static void printOutput(MedlineCitationSet example){
		List<Article> articles = example.getArticles();
		
		for(Article article:articles){
			//System.out.println(article.getArticleTitle());
			for(Author author:article.getAuthorList()){
				String st = author.getLastName()+","+ author.getForeName();
				//System.out.println(st);
				if(!names.contains(st)){
					names.add(st);
					authors.add(author);
				}
			}
		}
		
		System.out.print("\t\t");
		for(Author author:authors)
			//System.out.print(author+"\t\t");
			System.out.format("%12s",author);
		System.out.println();
		
		for(Author author:authors){
			//System.out.print(author+"\t\t");
			System.out.format("%12s",author);
			for(Author coAuthor:authors){
				AuthorPair pair = new AuthorPair();
				pair.author1 = author ;
				pair.author2 = coAuthor ;
				int count = 0;
				map.put(pair, count);
				for(Article article:articles){
					List<Author> articleAuthors = article.getAuthorList();
					Author firstAuthor = articleAuthors.get(0);
					if(!isEqual(author, firstAuthor))
						continue;
					for(int i= 0;i<articleAuthors.size();i++){
						if(isEqual(articleAuthors.get(i), coAuthor))
							map.put(pair, ++count);
					}
				}
				System.out.format("%12d",count);		
				
			}
			System.out.println();			
		}
	}
	
	static boolean isEqual(Author author1,Author author2){
		return author1.toString().equals(author2.toString());
	}
	
	static class AuthorPair{
		Author author1;
		Author author2;
	}

}
