package dataConverter;

public class PrivateInvestment extends Assets{
	private String Code;
	private String Label;
	private String QuarterlyDividend;
	private double BaseRateOfReturn;
	private String OmegaMeasure;
	private String TotalValue;
	
	public PrivateInvestment(String input, String code, String label, String quarterlydividend, String baserateofreturn, String omegameasure, String totalvalue){
		super(input, code, label, quarterlydividend, baserateofreturn, omegameasure, totalvalue);
		this.Code=code;
		this.Label=label;
		this.QuarterlyDividend=quarterlydividend;
		this.BaseRateOfReturn=(double)Integer.parseInt(baserateofreturn)/100;
		this.OmegaMeasure=omegameasure;
		this.TotalValue=totalvalue;
	}
		
	@Override
	public String getCode() {
		return Code;
	}

	@Override
	public String getLabel() {
		return Label;
	}
	
	@Override
	public String getQuarterlyDividend() {
		return QuarterlyDividend;
	}

	@Override
	public double getBaseRateOfReturn() {
		return BaseRateOfReturn;
	}
	
	@Override
	public String getOmegaMeasure() {
		return OmegaMeasure;
	}

	@Override
	public String getTotalValue() {
		return TotalValue;
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
