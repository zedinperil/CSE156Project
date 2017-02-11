package dataConverter;

public abstract class Assets {
	private String input;


	public Assets(String input, String string3, String string4, String string5, String string6,
			String string7, String string8) {
		super();
		this.input= input;
	
	}
	
	public abstract String getCode();
	public abstract String getLabel();
	public abstract double getApr();
	public abstract String getQuarterlyDividend();
	public abstract double getBaseRateOfReturn();
	public abstract String getBetaMeasure();
	public abstract String getStockSymbol();
	public abstract String getSharePrice();
	public abstract String getOmegaMeasure();
	public abstract String getTotalValue();
	
	
	public String getInput() {
		return input;
	}
}
