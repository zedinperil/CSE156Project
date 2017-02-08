
package dataConverter;

public class Persons {
	
	private String PersonCode;
	private Broker Brokerdata;
	private Name Name;
	private Address Address;
	private String Email;
	
	public Persons(String string, String string2, String string3, String string4) {
		// TODO Auto-generated constructor stub
	}
	//hai
	private Persons Persons(String PersonCode, Broker Brokerdata, Name Name, Address address, String email){
		this.PersonCode= PersonCode;
		this.Brokerdata= Brokerdata;
		this.Name=Name;
		this.Address=address;
		this.Email=email;
	}
	public String getPersonCode() {
		return PersonCode;
	}
	public void setPersonCode(String personCode) {
		PersonCode = personCode;
	}
	public Broker getBrokerdata() {
		return Brokerdata;
	}
	public void setBrokerdata(Broker brokerdata) {
		Brokerdata = brokerdata;
	}
	public Name getName() {
		return Name;
	}
	public void setName(Name name) {
		Name = name;
	}
	public Address getAddress() {
		return Address;
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
