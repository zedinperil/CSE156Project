package dataConverter;

public class Address extends Persons {
	private String Street;
	private String City;
	private String State;
	private String Zipcode;
	private String Country;
	private String fullAddress;
	
	public Address(String fullAddress) {
		super();
		String delim = ",";
		String[] tempAddress = new String[5];
		for(int i=0;i<5; i++){
			tempAddress = fullAddress.split(delim);
		}
		this.Street = tempAddress[0];
		this.City = tempAddress[1];
		this.State = tempAddress[2];
		this.Zipcode = tempAddress[3];
		this.Country = tempAddress[4];
		this.fullAddress = tempAddress[5];
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
