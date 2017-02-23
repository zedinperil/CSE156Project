package dataConverter;

public class Beneficiaries extends Persons{
		
	private String PersonCode;
	private Name Name;
	private Address Address;
	private String Email;
	
	public Beneficiaries(String PersonCode, Name Name, Address address, String email){
		super(PersonCode, Name, address, email);
		
	}
	public String getPersonCode() {
		return PersonCode;
	}
	public void setPersonCode(String personCode) {
		PersonCode = personCode;
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

