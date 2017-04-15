package dataConverter;

import java.util.ArrayList;
import java.util.List;

//the portfolio is a class with a lot of variables and getter functions in which those variables are calculated
//this is a complete rework of our old portfolio, which was severly complicated and incredibly redundant.  For future versions, it will need to 
//be expanded upon for more complicated procedures.  For future edits, where more person data will want to be pulled,
//we will need to slightly rework this class and how it pulls its data. 
//But for now, it does a good job of getting the information we need to get from our data
public class Portfolio {
	//these variables are some parts of a portfolio or inputs into a portfolio
	//it is ugly and needs a some cleaning up, as many of these are now being addressed in our asset class. To be frank, we are somewhat short on
	//time and are working on more urgent matters. These will get cleaned up next assignment.
	private String PortfolioCode;
	private String OwnerCode;
	private String ManagerCode;
	private String BeneficiaryCode;

	private String ownerName;
	private double fees;
	private double commissions;
	private double TotalValue;
	private double AnnualReturnSum;
	private double AggRisk;
	private int personcount;
	private int assetcount;
	private String managerName;
	private String beneficiaryName;
	private int ManagerCount=0;
	private double sumOfAnnualReturns;	
	private String managerType;
	List<Asset> PortfolioAssets= new ArrayList<Asset>();
	Persons owner;
	Persons manager;
	Persons beneficiary;
	
	//constructor
	public Portfolio(String portCode, String ownCode, String managCode, String beneficiaryCode) {
		this.PortfolioCode = portCode;
		this.OwnerCode = ownCode;
		this.ManagerCode = managCode;
		this.BeneficiaryCode = beneficiaryCode;
		this.PortfolioAssets = PortfolioInterface.getRelevantAssets(this.PortfolioCode);
		this.owner= PortfolioInterface.getOwner(ownCode);		
		this.manager= PortfolioInterface.getManager(managCode);
		this.beneficiary= PortfolioInterface.getBeneficiary(beneficiaryCode);
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
		ownerName= owner.getFirstName()+" "+owner.getLastName();
		return ownerName;
	}
	//this gets manager name by iterating through all persons until the personcode of the person is equal to managercode

	public String getManagerName(){
		managerName= manager.getFirstName()+" "+manager.getLastName();
		return managerName;
	}
	//this gets beneficiary name by iterating through all persons until the personcode of the person is equal to beneficiarycode
	public String getBeneficiaryName(){
		if(getBeneficiaryCode().equals("none")){
			return "none";
		}
		else{
			beneficiaryName= beneficiary.getFirstName()+" "+beneficiary.getLastName();
			return beneficiaryName;
		}
	}
	//basic getter for managercode
	public String getManagerCode() {
		return ManagerCode;
	}
	//getter for beneficiary code. ha
	public String getBeneficiaryCode() {
		if(BeneficiaryCode==null){
			return "none";
		}
		else{
		return BeneficiaryCode;
		}
	}

	//this getter returns fees, 
	public double getFees() {
		fees= PortfolioInterface.getFees(PortfolioAssets, ManagerCode);
		
		return fees;
	}
	//this getter returns commissions
	public double getCommissions() {
		commissions= PortfolioInterface.getCommissions(PortfolioAssets, ManagerCode);

		return commissions;
	}

	//for every value of
	public double getTotalValue(){
	TotalValue= PortfolioInterface.getTotalPortfolioValue(PortfolioAssets);
		return TotalValue;
	}
	//e of asset it is, and calculate annual return based on the type of asset. return it.
	public double getAnnualReturnSum() {
		AnnualReturnSum= PortfolioInterface.getAnnualReturnSum(PortfolioAssets);

		return AnnualReturnSum;
	}

	//ng them together for each asset.
	public double getAggRisk() {
		AggRisk= PortfolioInterface.getAggRisk(PortfolioAssets);

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
	//these getters are all very basic getters to get names that are stored in the portfolio.
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