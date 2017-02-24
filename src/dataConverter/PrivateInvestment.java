package dataConverter;

public class PrivateInvestment extends Assets{
	
	private String QuarterlyDividend;
	private double BaseRateOfReturn;
	private String OmegaMeasure;
	private String TotalValue;
	
	public PrivateInvestment(String code, String type, String label, String quarterlydividend, String baserateofreturn, String omegameasure, String totalvalue){
		super(code, type, label);
		this.setQuarterlyDividend(quarterlydividend);
		this.setBaseRateOfReturn(Double.parseDouble(baserateofreturn)/100);
		this.setOmegaMeasure(omegameasure);
		this.setTotalValue(totalvalue);
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

	public String getOmegaMeasure() {
		return OmegaMeasure;
	}

	public void setOmegaMeasure(String omegaMeasure) {
		OmegaMeasure = omegaMeasure;
	}

	public String getTotalValue() {
		return TotalValue;
	}

	public void setTotalValue(String totalValue) {
		TotalValue = totalValue;
	}

	@Override
	public double getApr() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getBetaMeasure() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getStockSymbol() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSharePrice() {
		// TODO Auto-generated method stub
		return null;
	}
		
	

	

}
	
