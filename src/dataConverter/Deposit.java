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

}
