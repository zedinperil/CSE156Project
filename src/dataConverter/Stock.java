package dataConverter;
//a stock is a subclass of assets
public class Stock extends Assets{
	//variables specific to Stocks. 
	private String QuarterlyDividend;
	private double BaseRateOfReturn;
	private String BetaMeasure;
	private String StockSymbol;
	private String SharePrice;
	//constructor
	public Stock(String code, String type, String label, String quarterlydividend, String baserateofreturn,String betameasure,String stocksymbol, String shareprice){
		super(code,type,label);
		//inherits three variables from superclass, the other variables are taken from input, and saved. Baserateofreturn string is parsed as a double and divided by 100 as it is a percent.
		this.QuarterlyDividend=quarterlydividend;
		this.BaseRateOfReturn=Double.parseDouble(baserateofreturn)/100;
		this.BetaMeasure=betameasure;
		this.StockSymbol=stocksymbol;
		this.SharePrice=shareprice;
	}
	//basic getters for the variables in the stock
	public String getQuarterlyDividend() {
		return QuarterlyDividend;
	}
	public double getBaseRateOfReturn() {
		return BaseRateOfReturn;
	}
	public String getBetaMeasure() {
		return BetaMeasure;
	}
	public String getStockSymbol() {
		return StockSymbol;
	}
	public String getSharePrice() {
		return SharePrice;
	}
	/**
	 * @param quarterlyDividend the quarterlyDividend to set
	 */
	public void setQuarterlyDividend(String quarterlyDividend) {
		QuarterlyDividend = quarterlyDividend;
	}
	/**
	 * @param baseRateOfReturn the baseRateOfReturn to set
	 */
	public void setBaseRateOfReturn(double baseRateOfReturn) {
		BaseRateOfReturn = baseRateOfReturn;
	}
	/**
	 * @param betaMeasure the betaMeasure to set
	 */
	public void setBetaMeasure(String betaMeasure) {
		BetaMeasure = betaMeasure;
	}
	/**
	 * @param stockSymbol the stockSymbol to set
	 */
	public void setStockSymbol(String stockSymbol) {
		StockSymbol = stockSymbol;
	}
	/**
	 * @param sharePrice the sharePrice to set
	 */
	public void setSharePrice(String sharePrice) {
		SharePrice = sharePrice;
	}

}
