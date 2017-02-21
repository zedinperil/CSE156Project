
//NOTE, We wanted to make this abstract and create a subclass, but we had several problems with it and decided to keep it simpler
package dataConverter;
import java.util.StringTokenizer;


public class Persons{
	
	private String Code;
	private Name Name;
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
		 
				this.Name= new Name(name);
//				StringTokenizer twokenizer= new StringTokenizer(name, ",");
//				if(twokenizer.hasMoreTokens()){		
//					this.LastName = twokenizer.nextToken();
//				}
//				else{
//					this.LastName="";
//				}
//				if(twokenizer.hasMoreTokens()){
//					this.FirstName = twokenizer.nextToken();
//				}
//				else{
//					this.FirstName="";
//				}
			
		this.Address=new Address(address);
		StringTokenizer twokenizer= new StringTokenizer(email, ",");
		String[] tokenarray= new String[200];
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
	public String getType(){
		return this.Type;
	}
	public String getSEC(){
		return this.secIdentifier;
	}

	public String getFirstName(){
		return this.Name.getFirstName();
	}
	public String getLastName(){
		return this.Name.getLastName();
	}

}
