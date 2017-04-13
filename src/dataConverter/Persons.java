
//NOTE, We wanted to make this abstract and create a subclass, but we had several problems with it and decided to keep it simpler
package dataConverter;
import java.util.StringTokenizer;

//persons is an abstract class with two subclasses: brokers and beneficiaries
public class Persons{
	//basic variables. Address has it's own class
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
		
	}
//getters for various relevant variables below. The address variables refer to getters within the address class.


}
