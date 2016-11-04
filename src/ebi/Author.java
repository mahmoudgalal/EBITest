package ebi;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
@Root(name="Author")
public class Author {
	
	public String getLastName() {
		return LastName;
	}
	public String getForeName() {
		return ForeName;
	}
	public String getInitials() {
		return Initials;
	}
	
	@Element
	private String LastName;
	@Element
	private String ForeName;
	@Element
	private String Initials;
	
	public Author() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return LastName+ForeName;
	}

}
