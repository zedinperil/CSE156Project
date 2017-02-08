
package dataConverter;

public class Name extends Persons{
	private String FirstName;
	private String LastName;
	
	private String fullName;
	
	public Name(String fullName) {
		super();
		String delim = ",/s";
		String[] tempName = new String[2];
		for(int i=0;i<2; i++){
			tempName = fullName.split(delim);
		}
		this.FirstName = tempName[1];
		this.LastName = tempName[0];
	}
	
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	
	
	
}
