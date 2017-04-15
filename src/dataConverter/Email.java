package dataConverter;

public class Email {
	//This is a very simple class for emails. It was the best/only design choice to use. An email consists of a string Personcode and Email.
	//The personCode serves as a link to a person.
private String personCode;
private String email;
	//constructor
	public Email(String PCODE, String EMAIL) {
		this.setPersonCode(PCODE);
		this.setEmail(EMAIL);
	}
	/**
	 * @return the personCode
	 */
	public String getPersonCode() {
		return personCode;
	}
	/**
	 * @param personCode the personCode to set
	 */
	public void setPersonCode(String personCode) {
		this.personCode = personCode;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}
