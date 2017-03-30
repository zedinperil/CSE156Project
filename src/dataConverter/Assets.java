package dataConverter;

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

	
	
	
}