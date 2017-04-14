package dataConverter;
//this is a rework of our assets class.  It is much more simplified, and is designed largely around the sql.  For future works it will need to be
//expanded, but for now, it does the job very well.
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
	public String getCode() {
		return Code;
	}


	public String getLabel() {
		return Label;
	}
	public String getAssetType(){
		return assetType;
	}
	public void setType(String assettype){
		assetType= assettype;
	}
	
	
}