package dataConverter;

public class Beneficiaries extends Persons{
//a beneficiary is a very plain person	

	//constructor
	public Beneficiaries(String PersonCode, String name, String address, String email){
		super(PersonCode, name, address, email);
	//just uses superclass methods
	}
	//placeholder getter methods in the event someone tries to use broker methods on a beneficiary
	@Override
	public String getSecIdentifier() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}


}

