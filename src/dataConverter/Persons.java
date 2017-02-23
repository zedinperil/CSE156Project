
//NOTE, We wanted to make this abstract and create a subclass, but we had several problems with it and decided to keep it simpler
package dataConverter;
import java.util.StringTokenizer;


public class Persons{
	
	private String Code;
	private Name Name;
	private Address Address;
	private String Email;
	
	
	public Persons(String PersonCode, String name, String address, String email){
		this.Code= PersonCode;		 
		this.Name= new Name(name);						
		this.Address=new Address(address);
		StringTokenizer twokenizer= new StringTokenizer(email, ",");
		String[] tokenarray= new String[20];
		String temparray = "";
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
	public String getFirstName(){
		return this.Name.getFirstName();
	}
	public String getLastName(){
		return this.Name.getLastName();
	}

}
