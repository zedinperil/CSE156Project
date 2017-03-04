package dataConverter;
import java.util.StringTokenizer;
public class Address{
	//string variables for various parts of an address
	private String Street;
	private String City;
	private String State;
	private String Zipcode;
	private String Country;
	//constructor
	public Address(String fullAddress) {
	//string tokenizer that will get the various parts of an address based on if the stringtokenizer has more tokens. if it doesn't, we set each part as a blank space	
	StringTokenizer tokenizer= new StringTokenizer(fullAddress, ",");
		if(tokenizer.hasMoreTokens()){		
			this.Street = tokenizer.nextToken();
		}
		else{
			this.Street="";
		}
		if(tokenizer.hasMoreTokens()){
			this.City = tokenizer.nextToken();
		}
		else{
			this.City="";
		}
		if(tokenizer.hasMoreTokens()){
			this.State = tokenizer.nextToken();		
		}
		else{
			this.State="";
		}
		if(tokenizer.hasMoreTokens()){
			this.Zipcode = tokenizer.nextToken();
		}
		else{
			this.Zipcode="";
		}
		if(tokenizer.hasMoreTokens()){
			this.Country = tokenizer.nextToken();
		}
		else{
			this.Country="";
		}
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
