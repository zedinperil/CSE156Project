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
	public void setStreet(String street) {
		Street = street;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getZipcode() {
		return Zipcode;
	}
	public void setZipcode(String zipcode) {
		Zipcode = zipcode;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	
}
