package dataConverter;

public class Asset {
	String assetCode; 
	String assetName; 
	String assetType; 
	double assetValue;
	double returnRate;
	double annualReturn;
	double risk;
	double assetModifier; 
	public Asset(String code, String Name, String Type, double Value, double RETURNRATE, double ANNUALRETURN, double RISK,double modifier) {
		this.assetCode = code;
		this.assetName= Name;
		this.assetType= Type;
		this.assetValue= Value;
		this.returnRate= RETURNRATE;
		this.annualReturn= ANNUALRETURN;
		this.risk= RISK;
		this.assetModifier= modifier;
	}	

}
