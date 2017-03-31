package dataConverter;

import java.util.StringTokenizer;
//the portfolio is a class with a lot of variables and getter functions in which those variables are calculated
public class Portfolio {
	//these variables are all parts of a portfolio or inputs into a portfolio
	private String PortfolioCode;
	private String OwnerCode;
	private String ManagerCode;
	private String BeneficiaryCode;
	private Assets[] Ass;
	private Persons[] Per;
	private String ownerName;
	private double fees;
	private double commissions;
	private double Risk;
	private double Value;
	private double TotalValue;
	private double AnnualReturn;
	private double[] ReturnRate; 
	private double AggRisk;
	private int personcount;
	private int assetcount;
	private String managerName;
	private String beneficiaryName;
	private int ManagerCount=0;
	private double sumOfAnnualReturn;	
	private String[] AssetName= new String[100];
	private double[] AssetValue=new double[100];
	private String[] temporaryString=new String[1000];
	private int OccuranceOfAssetCount=0;
	private String managerType;
	//constructor
	public Portfolio(String portCode, String ownCode, String managCode, String beneficiaryCode, 
					 String assetsA, Persons[] persons, Assets[] asset, int PersonsCount, int AssetsCount) {
		super();	
		this.PortfolioCode = portCode;
		this.OwnerCode = ownCode;
		this.ManagerCode = managCode;
		this.BeneficiaryCode = beneficiaryCode;
		this.Ass = asset;
		this.Per = persons;
		this.personcount = PersonsCount;
		this.assetcount = AssetsCount;
		int i=0;
		int k;
		//tokenizer takes in assets string, delimeters into useful info, that being, the assets and their values
		StringTokenizer tokenizer= new StringTokenizer(assetsA, ",");
		if(tokenizer.hasMoreTokens()){
			while(tokenizer.hasMoreTokens()){
				temporaryString[i]= tokenizer.nextToken();
				i++;
			}
		}
		this.OccuranceOfAssetCount=i;
		//for as many assets as there are, we delimeter each asset into the asset code and it's asset value
			for(k=0; k<OccuranceOfAssetCount; k++){
				 StringTokenizer twokenizer= new StringTokenizer(temporaryString[k], ":");
					 if(twokenizer.hasMoreTokens()){
						 this.AssetName[k]= twokenizer.nextToken();

					 }
					 if(twokenizer.hasMoreTokens()){
						this.AssetValue[k]= Double.parseDouble(twokenizer.nextToken());
					 }
				 }
			
			ReturnRate =new double[OccuranceOfAssetCount+1];
	}
	//these are basic getters
	public String getPortfolioCode() {
		return PortfolioCode;
	}
	public String getOwnerCode() {
		return OwnerCode;	
	} 	 
	public String[] getAssetName() {
		return AssetName;
	} 
	public double[] getAssetValue() {
		return AssetValue;
	}
	//end of basic getters
	//this gets owner name by iterating through all persons until the personcode of the person is equal to ownercode
	public String getOwnerName(){
		int k=0;
			while(k<personcount){			
				if(Per[k].getPersonCode().equals(this.OwnerCode)){
					ownerName=(Per[k].getFirstName()+" "+Per[k].getLastName());			
					k=personcount;
				}
				k++;
			}
		return ownerName;
	}
	//this gets manager name by iterating through all persons until the personcode of the person is equal to managercode

	public String getManagerName(){
		int k=0;
				while(k<personcount){			
					if(Per[k].getPersonCode().equals(this.ManagerCode)){
						managerName=(Per[k].getFirstName()+" "+Per[k].getLastName());
					k=personcount;
					
					}
					k++;
				}
		return managerName;
	}
	//this gets beneficiary name by iterating through all persons until the personcode of the person is equal to beneficiarycode
	public String getBeneficiaryName(){
		int k=0;
		
			while(k<personcount){			
				if(Per[k].getPersonCode().equals(this.BeneficiaryCode)){
					beneficiaryName=(Per[k].getFirstName()+" "+Per[k].getLastName());
				k=personcount;
				}
				k++;
			}
		//edge case for when your beneficiary code is "none"
		if(getBeneficiaryCode().equals("none")){
			beneficiaryName="none";
		}
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
		int k=0;
			while(k<personcount){				
				if(Per[k].getPersonCode().equals(ManagerCode)){
							if(Per[k].getType().equals("E")){
								fees = 10 * OccuranceOfAssetCount;
							}
							if(Per[k].getType().equals("J")){
								fees = 50 * OccuranceOfAssetCount;
							}
							k=personcount;
				}
				k++;	
			}		
		return fees;
	}
	//this getter returns commissions, which goes through the number of assets which we have, denoted by occuranceofassetcount
	public double getCommissions() {
	int o=0;
	int k=0;	
			while(o<OccuranceOfAssetCount){
			k=0;
			while(k<assetcount){
				if(Ass[k].getCode().equals(AssetName[o])){	
					AnnualReturn = getAnnualReturn(o);
					sumOfAnnualReturn+= AnnualReturn;
				}
			k++;
			}
		o++;
		}
	k=0; 
	//iterates through all persons, if the person is the manager, then calculate commissions based on whether the manager is expert or junior
	while(k<personcount){
	if(Per[k].getPersonCode().equals(ManagerCode)){
		if(Per[k].getType().equals("E")){
			commissions = (.05 * sumOfAnnualReturn);
		}
		if(Per[k].getType().equals("J")){
			commissions = (.02 * sumOfAnnualReturn);
		}
	}
	k++;
	}	
		return commissions;
	}
	//risk getter function,c, then we check to see the type of asset, and calculate risk based on what type of asset it is.
	public double getRisk(int u) {
			for(int k=0; k<assetcount; k++){
				if(Ass[k].getCode().equals(AssetName[u])){
					if(Ass[k].getType().equals("P")){
						Risk = Double.parseDouble(Ass[k].getOmegaMeasure())+ Math.pow(java.lang.Math.E,(-100000/(Double.parseDouble(Ass[k].getTotalValue()))));
					}
					if(Ass[k].getType().equals("S")){
						Risk = Double.parseDouble(Ass[k].getBetaMeasure());
					}
					if(Ass[k].getType().equals("D")){
						Risk = 0;
					}
				}
			}
		return Risk;
}
	//returns value, takes in integer o.  iterates through assets until it is equal to the assetname specified in the assetname array by the input integer "o". if the assetname matches the assetcode of the ass[] asset, we use gettype to find the type and calculate risk based on the type of asset
	public double getValue(int o) {
			for(int k=0; k<assetcount; k++){
				if(Ass[k].getCode().equals(AssetName[o])){
					if(Ass[k].getType().equals("P")){
						Value = Double.parseDouble(Ass[k].getTotalValue()) * AssetValue[o] * .01;
					}
					if(Ass[k].getType().equals("S")){
						Value = Double.parseDouble(Ass[k].getSharePrice()) * AssetValue[o];
					}
					if(Ass[k].getType().equals("D")){
						Value = AssetValue[o];
					}
				}
			}
		return Value;
	}
	//for every value of o until o is the same as the number of assets in the portfolio, add the value of the asset o, return the sum.
	public double getTotalValue(){
		double tempvalue=0;
		for(int o=0; o<OccuranceOfAssetCount; o++){
			tempvalue+=getValue(o);
		}
		TotalValue= tempvalue;
		return TotalValue;
	}
	//returns annual return. Takes in int o, iterates through assets until assetcode is equal to the assetname at index o, then, check what type of asset it is, and calculate annual return based on the type of asset. return it.
	public double getAnnualReturn(int o) {
		for(int k=0; k<assetcount; k++){
				if(Ass[k].getCode().equals(AssetName[o])){
					if(Ass[k].getType().equals("P")){
							AnnualReturn = Ass[k].getBaseRateOfReturn()* (Double.parseDouble(Ass[k].getTotalValue()) * AssetValue[o] * .01)+ (4 *(Double.parseDouble(Ass[k].getQuarterlyDividend()) * AssetValue[o] * .01));				
						}
					if(Ass[k].getType().equals("S")){
							AnnualReturn = (Ass[k].getBaseRateOfReturn()* (Double.parseDouble(Ass[k].getSharePrice()) * AssetValue[o])+ (4 *(Double.parseDouble(Ass[k].getQuarterlyDividend()) * AssetValue[o] )));	
					}
					if(Ass[k].getType().equals("D")){
							AnnualReturn = (Math.pow(Math.E, Ass[k].getApr()) - 1)*AssetValue[o];					
					}
				}
		}
		return AnnualReturn;
	}
	//returns return rate. For all assets in the portfolio, iterated through a loop, goes through a loop of all assets, if the assetcode is equal to the name of the asset in the portfolio, then we get annual return with input o. then, we calculate the return rate array by dividing annual return by the value of the asset for every asset.
	public double[] getReturnRate() {
		int o=0;	
		int r=0;
				o=0;
				while(o<OccuranceOfAssetCount){
					r=0;
					while(r<assetcount){
						if(Ass[r].getCode().equals(AssetName[o])){
							AnnualReturn = getAnnualReturn(o);
							ReturnRate[o]= AnnualReturn/getValue(o);			
						}
					r++;			
					}
				o++;
				}		
		return ReturnRate;
	}
	//using loop, for every asset in the portfolio, we find a temp risk by taking risk multiplied by value over total value, and then summing them together for each asset.
	public double getAggRisk() {
		double temprisk=0;
		double risksum=0;
		AggRisk=0;
			for(int o=0; o<OccuranceOfAssetCount; o++){
					temprisk= (getRisk(o)*getValue(o))/getTotalValue();
					risksum+=temprisk;
				}
			AggRisk=risksum;
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
	//for every asset, we iterate until the assetcode of the asset is equal to the assetname from our portfolio. then we return the assetname at index u in which this occurs.
	public String getAssetName(int u) {
		int g=0;
		for(int k=0; k<assetcount; k++){
					if(Ass[k].getCode().equals(AssetName[u])){
						g=u;
					}
			}
		return AssetName[g];
	}
	//for every asset, we iterate until the assetcode of the asset is equal to the assetname from our portfolio. then we return the assetvalue at index u in which this occurs.
	public double getAssetValue(int u) {
		int g=0;
		for(int k=0; k<assetcount; k++){
					if(Ass[k].getCode().equals(AssetName[u])){
					g=u;
					}
			}		
		return AssetValue[g];
	}
	//simple getter for the occurance of asset count in the portfolio
	public int getOccuranceOfAssetCount() {
		return this.OccuranceOfAssetCount;
	}
	//for every person, we iterate until the personcode of the person is equal to the ownercode from our portfolio. then we increase the counter variable by one. After all persons have been gone through, we return managercount
	public int getManagerCount() {
		ManagerCount=0;
		int k=0;
		for(int i=0; i<2; i++){
			k=0;
			while(k<personcount){			
				if(Per[k].getPersonCode().equals(this.OwnerCode)){
					ManagerCount++;
				k=personcount;
				}
				k++;
			}
		}
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
		this.sumOfAnnualReturn=SUMOFANNUALRETURNS;
	}
}	