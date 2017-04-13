
//NOTE, We wanted to make this abstract and create a subclass, but we had several problems with it and decided to keep it simpler
package dataConverter;
import java.util.StringTokenizer;

//persons is an abstract class with two subclasses: brokers and beneficiaries
public class Persons{
	//basic variables. Address has it's own class
private String code;
private String firstName;
private String lastName;
/**
 * @return the code
 */
public String getCode() {
	return code;
}

/**
 * @param code the code to set
 */
public void setCode(String code) {
	this.code = code;
}

/**
 * @return the firstName
 */
public String getFirstName() {
	return firstName;
}

/**
 * @param firstName the firstName to set
 */
public void setFirstName(String firstName) {
	this.firstName = firstName;
}

/**
 * @return the lastName
 */
public String getLastName() {
	return lastName;
}

/**
 * @param lastName the lastName to set
 */
public void setLastName(String lastName) {
	this.lastName = lastName;
}

/**
 * @return the street
 */
public String getStreet() {
	return Street;
}

/**
 * @param street the street to set
 */
public void setStreet(String street) {
	Street = street;
}

/**
 * @return the city
 */
public String getCity() {
	return City;
}

/**
 * @param city the city to set
 */
public void setCity(String city) {
	City = city;
}

/**
 * @return the state
 */
public String getState() {
	return State;
}

/**
 * @param state the state to set
 */
public void setState(String state) {
	State = state;
}

/**
 * @return the zip
 */
public String getZip() {
	return Zip;
}

/**
 * @param zip the zip to set
 */
public void setZip(String zip) {
	Zip = zip;
}

/**
 * @return the country
 */
public String getCountry() {
	return Country;
}

/**
 * @param country the country to set
 */
public void setCountry(String country) {
	Country = country;
}

/**
 * @return the personType
 */
public String getPersonType() {
	return personType;
}

/**
 * @param personType the personType to set
 */
public void setPersonType(String personType) {
	this.personType = personType;
}

/**
 * @return the sECID
 */
public String getSECID() {
	return SECID;
}

/**
 * @param sECID the sECID to set
 */
public void setSECID(String sECID) {
	SECID = sECID;
}

private String Street;
private String City;
private String State;
private String Zip;
private String Country;
private String personType;
private String SECID;

	//constructor
    public Persons(String personCode, String FirstName, String LastName, String street, String city, String state, String zip, String country, String persontype, String secId){
		super();
		
	}
//getters for various relevant variables below. The address variables refer to getters within the address class.


}
