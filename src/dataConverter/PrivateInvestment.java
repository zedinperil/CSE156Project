package dataConverter;

public class PrivateInvestment {
	private String Code;
	private String Label;
	private String QuarterlyDividend;
	private String BaseRateOfReturn;
	private String OmegaMeasure;
	private String TotalValue;
	
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
