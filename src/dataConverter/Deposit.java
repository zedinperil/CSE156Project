package dataConverter;

public class Deposit extends Assets{

 
 private double Apr;
  
 public Deposit(String input, String code, String label, String apr) {
		super(input, code, label);
		this.Apr=(Double.parseDouble(apr)/100);
		// TODO Auto-generated constructor stub
	}

public double getApr() {
	return Apr;
}

public void setApr(double apr) {
	Apr = apr;
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
public String getQuarterlyDividend() {
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
