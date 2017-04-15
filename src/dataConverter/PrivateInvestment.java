package dataConverter;

public class PrivateInvestment extends Assets{
	//privateInvestment specific variables
	private double QuarterlyDividend;
	private double BaseRateOfReturn;
	private double OmegaMeasure;
	private double TotalValue;
	//constructor, inherits from asset class
	public PrivateInvestment(String code,String label, double quarterlydividend, double baserateofreturn, double omegameasure, double totalvalue){
		super(code, label);
	//the constructor calls setter methods to set the various parts of a Private Investment
		this.setQuarterlyDividend(quarterlydividend);
		this.setBaseRateOfReturn((baserateofreturn)/100);
		this.setOmegaMeasure(omegameasure);
		this.setTotalValue(totalvalue);
	}
//getter and setter methods for the above private investment variables. all pretty self-explanatory  

	public double getQuarterlyDividend() {
		return QuarterlyDividend;
	}

	public void setQuarterlyDividend(double quarterlyDividend) {
		QuarterlyDividend = quarterlyDividend;
	}

	public double getBaseRateOfReturn() {
		return BaseRateOfReturn;
	}

	public void setBaseRateOfReturn(double baseRateOfReturn) {
		BaseRateOfReturn = baseRateOfReturn;
	}

	public double getOmegaMeasure() {
		return OmegaMeasure;
	}

	public void setOmegaMeasure(double omegaMeasure) {
		OmegaMeasure = omegaMeasure;
	}

	public double getTotalValue() {
		return TotalValue;
	}

	public void setTotalValue(double totalValue) {
		TotalValue = totalValue;
	}

	

}
	
