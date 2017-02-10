package dataConverter;
import java.util.StringTokenizer;
public class Name{
 private String FirstName;
 private String LastName;
public Name(String name) {
	StringTokenizer tokenizer= new StringTokenizer(name, ",");
		if(tokenizer.hasMoreTokens()){		
			this.LastName = tokenizer.nextToken();
		}
		else{
			this.LastName="";
		}
		if(tokenizer.hasMoreTokens()){
			this.FirstName = tokenizer.nextToken();
		}
		else{
			this.FirstName="";
		}
	}
	public String getFirstName(){
		return this.FirstName;
	}
	public String getLastName(){
		return this.LastName;
	}

}

