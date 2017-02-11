package dataConverter;

public class Stock extends Assets{
	
	private String Code;
	private String Label;
	private String QuarterlyDividend;
	private double BaseRateOfReturn;
	private String BetaMeasure;
	private String StockSymbol;
	private String SharePrice;
	public Stock(String input, String string3, String string4, String string5, String string6,
			String string7, String string8) {
		super(input, string3, string4, string5, string6, string7, string8);
		// TODO Auto-generated constructor stub
		this.BaseRateOfReturn=(double)Integer.parseInt(string5);
	}
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	public String getLabel() {
		return Label;
	}
	public void setLabel(String label) {
		Label = label;
	}
	public String getQuarterlyDividend() {
		return QuarterlyDividend;
	}
	public void setQuarterlyDividend(String quarterlyDividend) {
		QuarterlyDividend = quarterlyDividend;
	}
	public double getBaseRateOfReturn() {
		return BaseRateOfReturn;
	}
	public void setBaseRateOfReturn(double baseRateOfReturn) {
		BaseRateOfReturn = baseRateOfReturn;
	}
	/**
	 * @return the betaMeasure
	 */
	public String getBetaMeasure() {
		return BetaMeasure;
	}
	/**
	 * @param betaMeasure the betaMeasure to set
	 */
	public void setBetaMeasure(String betaMeasure) {
		BetaMeasure = betaMeasure;
	}
	/**
	 * @return the stockSymbol
	 */
	public String getStockSymbol() {
		return StockSymbol;
	}
	/**
	 * @param stockSymbol the stockSymbol to set
	 */
	public void setStockSymbol(String stockSymbol) {
		StockSymbol = stockSymbol;
	}
	/**
	 * @return the sharePrice
	 */
	public String getSharePrice() {
		return SharePrice;
	}
	/**
	 * @param sharePrice the sharePrice to set
	 */
	public void setSharePrice(String sharePrice) {
		SharePrice = sharePrice;
	}

	@Override
	public String getOmegaMeasure() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getTotalValue() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public double getApr() {
		// TODO Auto-generated method stub
		return 0;
	}
}
