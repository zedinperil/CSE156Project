package dataConverter;

public class Persons {
	
	private String PersonCode;
	private Broker Brokerdata;
	private Name Name;
	private Address Address;
	private String Email;
	
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
