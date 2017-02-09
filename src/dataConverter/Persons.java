
package dataConverter;

public class Persons{
	
	private String PersonCode;
	private String firstName;
	private String lastName;
	private Address Address;
	private String Email;
	private String Typeofperson;
	
	
	public Persons(String PersonCode, String TypeofPerson, String Name, String address, String email){
		this.PersonCode= PersonCode;
		this.Typeofperson=TypeofPerson;
		this.firstName=getFirstName(Name);
		this.lastName=getLastName(Name);
		this.Address=new Address(address);
		this.Email=email;
	}
	public String getPersonCode() {
		return PersonCode;
	}
	public void setPersonCode(String personCode) {
		PersonCode = personCode;
	}
	public String getFirstName(String Name) {
		String delim = ",";
		String[] tempName = new String[2];
		for(int i=0;i<2; i++){
			tempName = Name.split(delim);
		}
		this.firstName= tempName[0];
		return this.firstName;
	}
	
	public String getLastName(String Name){
		String delim = ",";
		String[] tempName = new String[2];
		for(int i=0;i<2; i++){
			tempName = Name.split(delim);
		}
		this.lastName= tempName[0];
		return this.lastName;
	}
	public Address getAddress(){
		return this.Address;
	}
		
	public void setAddress(Address address) {
		Address = address;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	
}
