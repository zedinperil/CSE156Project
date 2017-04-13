package dataConverter;
//deposit extends assets
public class Deposit extends Assets{
//apr is a double variable unique to deposit.
 private double Apr;
  //constructor
 public Deposit(String code, String label, double apr) {
		super(code, label);
		//apr double is a percentage, so we divide by 100 and parse apr input string as a double
		this.Apr=apr;
		
	}
//basic getter for the apr variable
public double getApr() {
	return Apr;
}
/**
 * @param apr the apr to set
 */
public void setApr(double apr) {
	Apr = apr;
}

}
