package dataConverter;

public class Stock {
	private String Code;
	private String Label;
	private String QuarterlyDividend;
	private String BaseRateOfReturn;
	private String BetaMeasure;
	private String StockSymbol;
	private String SharePrice;
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
	public String getBaseRateOfReturn() {
		return BaseRateOfReturn;
	}
	public void setBaseRateOfReturn(String baseRateOfReturn) {
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
}
