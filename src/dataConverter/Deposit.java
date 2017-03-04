package dataConverter;
//deposit extends assets
public class Deposit extends Assets{
//apr is a double variable unique to deposit.
 private double Apr;
  //constructor
 public Deposit(String input, String code, String label, String apr) {
		super(input, code, label);
		//apr double is a percentage, so we divide by 100 and parse apr input string as a double
		this.Apr=(Double.parseDouble(apr)/100);
		
	}
//basic getter for the apr variable
public double getApr() {
	return Apr;
}
//basically just placeholder getters for asset variables unused by deposit.
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
