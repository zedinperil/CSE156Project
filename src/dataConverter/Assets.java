package dataConverter;
//this is a rework of our assets class.  It is much more simplified, and is designed largely around the sql.  It has been expanded very much from 
//our previous assignment, and fits the strcuture very well. It has 3 subclasses for the 3 types of assets.
public abstract class Assets {
	//variables that are used in the three types of assets
	private String Code;
	private String Label;
	private String assetType;
	//general constructor for an asset
	public Assets(String code, String label) {
		this.Code = code;
		this.Label = label;
	}

	//below are three getters for code, type, and label
	public String getLabel() {
		return Label;
	}
	public String getAssetType(){
		return assetType;
	}
	public void setType(String assettype){
		assetType= assettype;
	}

	public Object getAssetCode() {
		// TODO Auto-generated method stub
		return Code;
	}
	
	
}