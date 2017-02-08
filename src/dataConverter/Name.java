package dataConverter;

public class Name extends Persons{
	private String FirstName;
	private String LastName;
	
	private String fullName;
	
	public Name(String fullName) {
		super();
		String delim = ",/s";
		String[] tempName = new String[2];
		String[] = fullName.spilt(delim)
		this.FirstName = String[0];
		this.LastName = String[1];
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
