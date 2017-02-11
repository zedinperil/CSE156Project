package dataConverter;

public class Deposit extends Assets{

 
 private double Apr;
  
 public Deposit(String input, String code, String label, String apr) {
		super(input, code, label);
		this.setApr((double)Integer.parseInt(apr)/100);
		// TODO Auto-generated constructor stub
	}

public double getApr() {
	return Apr;
}

public void setApr(double apr) {
	Apr = apr;
}
 
}
