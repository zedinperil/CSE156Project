package dataConverter;
//this is a rework of our assets class.  It is much more simplified, and is designed largely around the sql.  For future works it will need to be
//expanded, but for now, it does the job very well.
public abstract class Assets {
	//variables that are used in the three types of assets
	private String Code;
	private String Type;
	private String Label;
	//general constructor for an asset
	public Assets(String code, String type, String label) {
		super();
		this.Code = code;
		this.Type = type;
		this.Label = label;
	}

	//below are three getters for code, type, and label
	public String getCode() {
		return Code;
	}
	public String getType() {
		return Type;
	}

	public String getLabel() {
		return Label;
	}
	//below are several abstract getter variables for use with subclasses.
	public abstract double getApr();
	public abstract double getBaseRateOfReturn();
	public abstract String getBetaMeasure();
	public abstract String getStockSymbol();
	public abstract String getSharePrice();
	public abstract String getQuarterlyDividend();
	public abstract String getOmegaMeasure();
	public abstract String getTotalValue();

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		Code = code;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		Type = type;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		Label = label;
	}

	
	
	
}