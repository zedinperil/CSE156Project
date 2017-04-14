package dataConverter;
//a stock is a subclass of assets
public class Stock extends Assets{
	//variables specific to Stocks. 
	private double QuarterlyDividend;
	private double BaseRateOfReturn;
	private double BetaMeasure;
	private String StockSymbol;
	private double SharePrice;
	//constructor
	public Stock(String code, String label, double quarterlydividend, double baserateofreturn,double betameasure,String stocksymbol, double shareprice){
		super(code, label);
		//inherits three variables from superclass, the other variables are taken from input, and saved. Baserateofreturn string is parsed as a double and divided by 100 as it is a percent.
		this.QuarterlyDividend=quarterlydividend;
		this.BaseRateOfReturn=(baserateofreturn)/100;
		this.BetaMeasure=betameasure;
		this.StockSymbol=stocksymbol;
		this.SharePrice=shareprice;
	}
	//basic getters for the variables in the stock
	public double getQuarterlyDividend() {
		return QuarterlyDividend;
	}
	public double getBaseRateOfReturn() {
		return BaseRateOfReturn;
	}
	public double getBetaMeasure() {
		return BetaMeasure;
	}
	public String getStockSymbol() {
		return StockSymbol;
	}
	public double getSharePrice() {
		return SharePrice;
	}
	/**
	 * @param quarterlyDividend the quarterlyDividend to set
	 */
	public void setQuarterlyDividend(double quarterlyDividend) {
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
	public void setBetaMeasure(double betaMeasure) {
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
	public void setSharePrice(double sharePrice) {
		SharePrice = sharePrice;
	}

}
