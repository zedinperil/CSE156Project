
//NOTE, We wanted to make this abstract and create a subclass, but we had several problems with it and decided to keep it simpler
package dataConverter;

import java.util.List;
import java.util.ArrayList;


public class Persons{
	//We completely reworked our Persons class again. We think this should be the final version of it. It is much more streamlined than ever.
	//It consists of everything a person has. While address could be its own class, it is uneccesary complication.
	
	//everything a person consists of
private String code;
private String firstName;
private String lastName;
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
	this.code= personCode;
	this.firstName= FirstName;
	this.lastName= LastName;
	this.Street= street;
	this.City=city;
	this.State=state;
	this.Zip=zip;
	this.Country=country;
	this.personType=persontype;
	this.SECID=secId;
	
}
/**
 * @return the code
 */
//GETTERS AND SETTERS AUTO GENERATED
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

//getters for various relevant variables below. The address variables refer to getters within the address class.
public List<String> getEmails(String personcode){
	List<Email> emailList= databaseinfoandmethods.getEmail();
	List<String> emails= new ArrayList<String>();
	for(int i=0; i<emailList.size(); i++){
		if(emailList.get(i).getPersonCode().equals(personcode)){
			emails.add(emailList.get(i).getEmail());
		}
	}	
	return emails; 
}
    

}
