package dataConverter;

public class Stock extends Assets{
	
	private String QuarterlyDividend;
	private double BaseRateOfReturn;
	private String BetaMeasure;
	private String StockSymbol;
	private String SharePrice;
	
	public Stock(String code, String type, String label, String quarterlydividend, String baserateofreturn,String betameasure,String stocksymbol, String shareprice){
		super(code,type,label);
		this.QuarterlyDividend=quarterlydividend;
		this.BaseRateOfReturn=Double.parseDouble(baserateofreturn)/100;
		this.BetaMeasure=betameasure;
		this.StockSymbol=stocksymbol;
		this.SharePrice=shareprice;
	}
	public void setQuarterlyDividend(String quarterlyDividend) {
		QuarterlyDividend = quarterlyDividend;
	}
	public void setBaseRateOfReturn(double baseRateOfReturn) {
		BaseRateOfReturn = baseRateOfReturn;
	}
	public void setBetaMeasure(String betaMeasure) {
		BetaMeasure = betaMeasure;
	}
	public void setStockSymbol(String stockSymbol) {
		StockSymbol = stockSymbol;
	}
	public void setSharePrice(String sharePrice) {
		SharePrice = sharePrice;
	}
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
	
}
