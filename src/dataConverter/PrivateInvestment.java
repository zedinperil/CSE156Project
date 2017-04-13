package dataConverter;

public class PrivateInvestment extends Assets{
	//privateInvestment specific variables
	private String QuarterlyDividend;
	private double BaseRateOfReturn;
	private String OmegaMeasure;
	private String TotalValue;
	//constructor, inherits from asset abstract class
	public PrivateInvestment(String code,String label, String quarterlydividend, String baserateofreturn, String omegameasure, String totalvalue){
		super(code, label);
	//the constructor calls setter methods to set the various parts of a Private Investment
		this.setQuarterlyDividend(quarterlydividend);
		this.setBaseRateOfReturn(Double.parseDouble(baserateofreturn)/100);
		this.setOmegaMeasure(omegameasure);
		this.setTotalValue(totalvalue);
	}
//getter and setter methods for the above private investment variables. all pretty self-explanatory  
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

	

}
	
