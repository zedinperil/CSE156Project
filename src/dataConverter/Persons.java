
//NOTE, We wanted to make this abstract and create a subclass, but we had several problems with it and decided to keep it simpler
package dataConverter;
import java.util.StringTokenizer;
public class Persons{
	
	private String Code;
	private String FirstName;
	private String LastName;
	private Address Address;
	private String Email;
	private String Type;
	private String secIdentifier;

	
	public Persons(String PersonCode, String TypeofPerson, String name, String address, String email){
		this.Code= PersonCode;
				StringTokenizer tokenizer= new StringTokenizer(TypeofPerson, ",");
				if(tokenizer.hasMoreTokens()){		
					this.Type = tokenizer.nextToken();
					
					if(tokenizer.hasMoreTokens()){
						this.secIdentifier = tokenizer.nextToken();
					}
					else{
						this.secIdentifier="";
					}
				}
				else{
					this.Type="";
					this.secIdentifier="";
				}
		 
				StringTokenizer twokenizer= new StringTokenizer(name, ",");
				if(twokenizer.hasMoreTokens()){		
					this.LastName = twokenizer.nextToken();
				}
				else{
					this.LastName="";
				}
				if(twokenizer.hasMoreTokens()){
					this.FirstName = twokenizer.nextToken();
				}
				else{
					this.FirstName="";
				}
		this.Address=new Address(address);
		
		this.Email=email;
	}
	public Persons(String personCode2, dataConverter.Name name, dataConverter.Address address2, String email2) {
		// TODO Auto-generated constructor stub
	}
	public String getPersonCode(){
		return this.Code;
	}
	public String getStreet() {
		return Address.getStreet();
	}
	public String getCity() {
		return Address.getCity();
	}

	public String getState() {
		return Address.getState();
	}

	public String getZipcode() {
		return Address.getZipcode();
	}
	public String getCountry() {
		return Address.getCountry();
	}
	public String getEmail() {
		return this.Email;
	}
	public String getType(){
		return this.Type;
	}
	public String getSEC(){
		return this.secIdentifier;
	}

	public String getFirstName(){
		return this.FirstName;
	}
	public String getLastName(){
		return this.LastName;
	}
}
