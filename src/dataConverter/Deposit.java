package dataConverter;

public class Deposit extends Assets{

private String Code;
 private String Label;
 private double Apr;
 public Deposit(String input, String code, String label, String apr, String string6,
			String string7, String string8) {
		super(input, code, label, apr, string6, string7, string8);
		this.Apr=(double)Integer.parseInt(apr)/100;
		// TODO Auto-generated constructor stub
	}
 /**
 * @return the code
 */
public String getCode() {
	return Code;
}
/**
 * @param code the code to set
 */
public void setCode(String code) {
	Code = code;
}
/**
 * @return the label
 */
public String getLabel() {
	return Label;
}
/**
 * @param label the label to set
 */
public void setLabel(String label) {
	Label = label;
}
/**
 * @return the apr
 */
public double getApr() {
	return Apr;
}
/**
 * @param apr the apr to set
 */
public void setApr(double apr) {
	Apr = apr;
}
@Override
public String getQuarterlyDividend() {
	// TODO Auto-generated method stub
	return null;
}
@Override
public double getBaseRateOfReturn() {
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
 
}
