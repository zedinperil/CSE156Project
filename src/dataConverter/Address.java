package dataConverter;
import java.util.StringTokenizer;
public class Address{
	private String Street;
	private String City;
	private String State;
	private String Zipcode;
	private String Country;
	
	public Address(String fullAddress) {
		
	StringTokenizer tokenizer= new StringTokenizer(fullAddress, ",");
		if(tokenizer.hasMoreTokens()){		
			this.Street = tokenizer.nextToken();
		}
//		else{
//			this.Street=null;
//		}
		if(tokenizer.hasMoreTokens()){
			this.City = tokenizer.nextToken();
		}
//		else{
//			this.City=null;
//		}
		if(tokenizer.hasMoreTokens()){
			this.State = tokenizer.nextToken();		
		}
//		else{
//			this.State=null;
//		}
		if(tokenizer.hasMoreTokens()){
			this.Zipcode = tokenizer.nextToken();
		}
//		else{
//			this.Zipcode=null;
//		}
		if(tokenizer.hasMoreTokens()){
			this.Country = tokenizer.nextToken();
		}
//		else{
//			this.Country=null;
//		}
	}
	
	public String getStreet() {
		return Street;
	}
	public String getCity() {
		return City;
	}

	public String getState() {
		return State;
	}

	public String getZipcode() {
		return Zipcode;
	}
	public String getCountry() {
		return Country;
	}

}
