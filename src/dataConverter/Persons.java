
//NOTE, We wanted to make this abstract and create a subclass, but we had several problems with it and decided to keep it simpler
package dataConverter;
import java.util.StringTokenizer;

//persons is an abstract class with two subclasses: brokers and beneficiaries
public abstract class Persons{
	//basic variables. Address has it's own class
private String Code;
private Name Name;
private Address Address;
private String Email;
	//constructor
	public Persons(String PersonCode, String name, String address, String email){
		super();
		this.Code= PersonCode;		 
		this.Name= new Name(name);						
		this.Address=new Address(address);
		//string tokenizer tokenizes on commas to get each email
		StringTokenizer twokenizer= new StringTokenizer(email, ",");
		String[] tokenarray= new String[20];
		String temparray = "";
		//loop used  in combination with line separators and string tokenizer to createa well-formatted emails
		for(int i=0; i<200; i++){
			if(i==0){
				temparray= "[ ";
			}
		if(twokenizer.hasMoreTokens()){		
			
			tokenarray[i] = twokenizer.nextToken();
		if(i==0){
			temparray+= tokenarray[i];
		}
			
			if(i>0)
				temparray+= ",  " +System.lineSeparator() +tokenarray[i];
		}
		}
		temparray+= " ]";
		this.Email=String.format(temparray);
	}
//getters for various relevant variables below. The address variables refer to getters within the address class.
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
	public String getFirstName(){
		return this.Name.getFirstName();
	}
	public String getLastName(){
		return this.Name.getLastName();
	}
	public abstract String getSecIdentifier();
	public abstract String getType();

}
