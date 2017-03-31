package dataConverter;

//the portfolio is a class with a lot of variables and getter functions in which those variables are calculated
public class Portfolio {
	//these variables are all parts of a portfolio or inputs into a portfolio
	private String PortfolioCode;
	private String OwnerCode;
	private String ManagerCode;
	private String BeneficiaryCode;

	private String ownerName;
	private double fees;
	private double commissions;
	private double Risk;
	private double TotalValue;
	private double AnnualReturn;
	private double ReturnRate; 
	private double AggRisk;
	private int personcount;
	private int assetcount;
	private String managerName;
	private String beneficiaryName;
	private int ManagerCount=0;
	private double sumOfAnnualReturns;	
	private String managerType;
	//constructor
	public Portfolio(String portCode, String ownCode, String managCode, String beneficiaryCode) {
		super();	
		this.PortfolioCode = portCode;
		this.OwnerCode = ownCode;
		this.ManagerCode = managCode;
		this.BeneficiaryCode = beneficiaryCode;
	}
	//these are basic getters
	public String getPortfolioCode() {
		return PortfolioCode;
	}
	public String getOwnerCode() {
		return OwnerCode;	
	} 	 
	public String getManagerType(){
		return managerType;
	}
	//end of basic getters
	//this gets owner name by iterating through all persons until the personcode of the person is equal to ownercode
	public String getOwnerName(){
		return ownerName;
	}
	//this gets manager name by iterating through all persons until the personcode of the person is equal to managercode

	public String getManagerName(){
		return managerName;
	}
	//this gets beneficiary name by iterating through all persons until the personcode of the person is equal to beneficiarycode
	public String getBeneficiaryName(){
		return beneficiaryName;
	}
	//basic getter for managercode
	public String getManagerCode() {
		return ManagerCode;
	}
	//getter for beneficiary code. has edge case for when it is blank, makes it "none"
	public String getBeneficiaryCode() {
		
		if(BeneficiaryCode.equals("")){
			return "none";
		}
		else{
		
		return BeneficiaryCode;
		}
	}

	//this getter returns fees, which iterates through persons, and checks when a persons personcode is euqal to manager code, and then calculates the fees based on whether the type of the person is expert or junior, denoted by 'E' or 'J', respectively
	public double getFees() {
		return fees;
	}
	//this getter returns commissions, which goes through the number of assets which we have, denoted by occuranceofassetcount
	public double getCommissions() {
		return commissions;
	}
	//risk getter function,c, then we check to see the type of asset, and calculate risk based on what type of asset it is.
	public double getRisk(int u) {
		return Risk;
}

	//for every value of o until o is the same as the number of assets in the portfolio, add the value of the asset o, return the sum.
	public double getTotalValue(){
		return TotalValue;
	}
	//returns annual return. Takes in int o, iterates through assets until assetcode is equal to the assetname at index o, then, check what type of asset it is, and calculate annual return based on the type of asset. return it.
	public double getAnnualReturn(int o) {
		return AnnualReturn;
	}
	//returns return rate. For all assets in the portfolio, iterated through a loop, goes through a loop of all assets, if the assetcode is equal to the name of the asset in the portfolio, then we get annual return with input o. then, we calculate the return rate array by dividing annual return by the value of the asset for every asset.
	public double getReturnRate() {	
		return ReturnRate;
	}
	//using loop, for every asset in the portfolio, we find a temp risk by taking risk multiplied by value over total value, and then summing them together for each asset.
	public double getAggRisk() {
		return AggRisk;
	}
	//basic getter for persons count
	public int getPersoncount() {
		return personcount;
	}
	//basic getter for assets count
	public int getAssetcount() {
		return assetcount;
	}

	public double getSumOfAnnualReturns(){
		return sumOfAnnualReturns;
	}
	//for every person, we iterate until the personcode of the person is equal to the ownercode from our portfolio. then we increase the counter variable by one. After all persons have been gone through, we return managercount
	public int getManagerCount() {
		return ManagerCount;
	}	
	public void setPortfolioCode(String PORTFOLIOCODE){
		this.PortfolioCode=PORTFOLIOCODE;
	}
	public void setOwnerName(String OWNERNAME){
		this.ownerName=OWNERNAME;
	}
	public void setManagerName(String MANAGERNAME){
		this.managerName=MANAGERNAME;
	}
	public void setManagerType(String MANAGERTYPE){
		this.managerType=MANAGERTYPE;
	}
	public void setBeneficiaryName(String BENEFICIARYNAME){
		this.beneficiaryName=BENEFICIARYNAME;
	}
	public void setFees(double FEES){
		this.fees=FEES;
	}
	public void setAggRisk(double AGGRISK){
		this.AggRisk=AGGRISK;
	}
	public void setCommissions(double COMMISSIONS){
		this.commissions=COMMISSIONS;
	}
	public void setTotalValue(double TOTALVALUE){
		this.TotalValue=TOTALVALUE;
	}
	public void setSumOfAnnualReturns(double SUMOFANNUALRETURNS){
		this.sumOfAnnualReturns=SUMOFANNUALRETURNS;
	}
}	