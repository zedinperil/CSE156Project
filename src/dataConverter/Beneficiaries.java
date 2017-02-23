package dataConverter;

public class Beneficiaries extends Persons{
	

	
	public Beneficiaries(String PersonCode, String name, String address, String email){
		super(PersonCode, name, address, email);
	
	}

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

