package dataConverter;

public abstract class Assets {
	private String Code;
	private String Type;
	private String Label;
	private String secIdentifier;
	
	public Assets(String code, String type, String label) {
		super();
		this.Code = code;
		this.Type = type;
		this.Label = label;
	}

	public String getCode() {
		return Code;
	}


	public String getType() {
		return Type;
	}

	public String getLabel() {
		return Label;
	}
	public abstract double getApr();
	public abstract double getBaseRateOfReturn();
	public abstract String getBetaMeasure();
	public abstract String getStockSymbol();
	public abstract String getSharePrice();
	public abstract String getQuarterlyDividend();
	public abstract String getOmegaMeasure();
	public abstract String getTotalValue();

	
	
	
}