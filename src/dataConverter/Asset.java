package dataConverter;

import java.util.List;
	//this is definitely our most complex organization of our methods. This class is essentially an instance of an asset in a portfolio. 
	//The other class, assets, is a general collection of all the available assets, which is a superclass of the 3 types. 

	//The downside of this is that getting data from the collection of assets becomes sightly more difficult. It was worth it however, as we 
	//totally restructured everything, and this outline makes the most sense in a database sense.
public class Asset implements databaseinfoandmethods{
	//This is what an asset object in a portfolio consists of.
	String portfolioCode;
	String assetCode; 
	String assetName; 
	String assetType; 
	double sharePrice;
	double assetValue;
	double returnRate;
	double annualReturn;
	double risk;
	double baseRateOfReturn;
	double privateValue;
	double quarterlyDividends;
	double apr;
	List<Assets>assetList=databaseinfoandmethods.getAssetList();
	
	//constructor
	public Asset(String PortfolioCode, String AssetCode, double Value) {
		this.portfolioCode= PortfolioCode;
		this.assetCode = AssetCode;
		this.assetValue= Value;
	}	
	//basic getters and setters
	/**
	 * @return the portfolioCode
	 */
	public String getPortfolioCode() {
		return portfolioCode;
	}
	/**
	 * @param portfolioCode the portfolioCode to set
	 */
	public void setPortfolioCode(String portfolioCode) {
		this.portfolioCode = portfolioCode;
	}
	/**
	 * @return the assetCode
	 */
	public String getAssetCode() {
		return assetCode;
	}
	/**
	 * @param assetCode the assetCode to set
	 */
	public void setAssetCode(String assetCode) {
		this.assetCode = assetCode;
	}
	/**
	 * @return the assetName
	 */
	public String getAssetName(String assetCode) {
		//this getter obtains the asset name with the corresponding assetCode
		for(int i=0; i<assetList.size();i++){
			if(assetList.get(i).getAssetCode().equals(assetCode)){
				assetName=assetList.get(i).getLabel();
			}	
		}
		return assetName;
	}
	/**
	 * @param assetName the assetName to set
	 */
	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}
	/**
	 * @return the assetType
	 */
	public String getAssetType(String assetCode) {
		//This is very important to work correctly for us, as it's essential when doing calculations. Getting the asset type here makes it easier
		//when using methods than going to find it in the other class
		for(int i=0; i<assetList.size();i++){
			if(assetList.get(i).getAssetCode().equals(assetCode)){
				assetType=assetList.get(i).getAssetType();
			}	
		}
		return assetType;
	}
	/**
	 * @param assetType the assetType to set
	 */
	public void setAssetType(String assettype) {

		this.assetType = assettype;
	}
	/**
	 * @return the assetValue
	 */
	public double getAssetValue() {
		return assetValue;
	}
	/**
	 * @param assetValue the assetValue to set
	 */
	public void setAssetValue(double assetValue) {
		this.assetValue = assetValue;
	}
	/**
	 * @return the returnRate
	 */
	public double getReturnRate(String assetcode) {
	//annual return /value of individual asset. Pretty simple stuff.
		returnRate= getAnnualReturn(assetcode)/getValue(assetcode);
			
		
		return returnRate;
	}
	/**
	 * @param returnRate the returnRate to set
	 */
	public void setReturnRate(double returnRate) {
		this.returnRate = returnRate;
	}
	
	/**
	 * @param annualReturn the annualReturn to set
	 */
	public void setAnnualReturn(double annualReturn) {
		this.annualReturn = annualReturn;
	}
	/**
	 * @return the risk
	 */
	public double getRisk() {
		return risk;
	}
	/**
	 * @param risk the risk to set
	 */
	public void setRisk(double risk) {
		this.risk = risk;
	}
	
	public double getPrivateValue(String assetcode){
	//this method will get the value of a private investment.This is very important to work correctly for us, as it's essential when doing calculations. Getting the asset type here makes it easier
		//when using methods than going to find it in the other class
		privateValue=0;
		assetType= getAssetType(assetcode);
		if(assetType.equals("P")){
			for(int i=0; i<assetList.size();i++){
				if(assetList.get(i).getAssetType().equals(assetType)&& assetList.get(i).getAssetCode().equals(assetcode)){
					PrivateInvestment Priv= (PrivateInvestment) assetList.get(i);	
					privateValue= Priv.getTotalValue();
				}
			}	
		}
		return privateValue;
	}
	public double getSharePrice(String assetcode){
	//this method will get the shareprice of a stock
	//This is very important to work correctly for us, as it's essential when doing calculations. Getting the asset type here makes it easier
	//when using methods than going to find it in the other class
		sharePrice=0;
		assetType= getAssetType(assetcode);
		if(assetType.equals("S")){
			for(int i=0; i<assetList.size();i++){
				if(assetList.get(i).getAssetType().equals(assetType)&& assetList.get(i).getAssetCode().equals(assetcode)){
					Stock Stok= (Stock) assetList.get(i);	
					sharePrice= Stok.getSharePrice();
				}
			}	
		}
		return sharePrice;
		
	}
	public double getBaseRateOfReturn(String assetcode){
	//this method will get the Base rate of return for stocks and private investments	
		baseRateOfReturn=0;
		assetType= getAssetType(assetcode);
		if(assetType.equals("P")){
			for(int i=0; i<assetList.size();i++){
				if(assetList.get(i).getAssetType().equals(assetType)&& assetList.get(i).getAssetCode().equals(assetcode)){
					PrivateInvestment Priv= (PrivateInvestment) assetList.get(i);	
					baseRateOfReturn= Priv.getBaseRateOfReturn();
				}
			}	
		}
		if(assetType.equals("S")){
			for(int i=0; i<assetList.size();i++){
				if(assetList.get(i).getAssetType().equals(assetType)&& assetList.get(i).getAssetCode().equals(assetcode)){
					Stock Stok= (Stock) assetList.get(i);	
					baseRateOfReturn= Stok.getBaseRateOfReturn();
				}
			}	
		}
		return baseRateOfReturn;
	}
	public double getQuarterlyDividend(String assetcode){
		//this method will get the quarterlydividend for stocks and private investments
		quarterlyDividends=0;
		assetType= getAssetType(assetcode);
		if(assetType.equals("P")){
			for(int i=0; i<assetList.size();i++){
				if(assetList.get(i).getAssetType().equals(assetType)&& assetList.get(i).getAssetCode().equals(assetcode)){
					PrivateInvestment Priv= (PrivateInvestment) assetList.get(i);	
					quarterlyDividends= Priv.getQuarterlyDividend();
				}
			}	
		}
		if(assetType.equals("S")){
			for(int i=0; i<assetList.size();i++){
				if(assetList.get(i).getAssetType().equals(assetType)&& assetList.get(i).getAssetCode().equals(assetcode)){
					Stock Stok= (Stock) assetList.get(i);	
					quarterlyDividends= Stok.getQuarterlyDividend();
				}
			}	
		}
		return quarterlyDividends;
	}
	
	public double getApr(String assetcode){
		//this method will get the apr for a deposit. It will find the correct Depoist apr value for the asset in the portfolio. Makes
		//the equations much easier to do down the road
		assetType= getAssetType(assetcode);
		if(assetType.equals("D")){
			for(int i=0; i<assetList.size(); i++){
				if(assetList.get(i).getAssetType().equals(assetType)&& assetList.get(i).getAssetCode().equals(assetcode)){
					Deposit Dep= (Deposit) assetList.get(i);
					apr= Dep.getApr();
				}
			}
		}
		return apr;
	}
	 public double getAnnualReturn(String assetcode){
		 //these methods will calculate the necessary values. The previous getters made these equations a lot easier to handle. it takes an
		 //assetcode and will find the data needed for it. the for loop iterates through the list of assets in the portfolio. Depending on the type,
		 //it will make the correct calculation
		 double AnnualReturn = 0;
		 assetType= getAssetType(assetcode);

		 for(int i=0; i<assetList.size(); i++){
			if(assetList.get(i).getAssetCode().equals(assetCode)){
				 if(assetType.equals("P")){
					 PrivateInvestment Priv= (PrivateInvestment) assetList.get(i);
					 AnnualReturn = getBaseRateOfReturn(assetcode)*(Priv.getTotalValue() * getValue(assetcode) * .01)+ (4 *(getQuarterlyDividend(assetcode) * getValue(assetcode) * .01));
				 }
				 if(assetType.equals("S")){
					 Stock Stok= (Stock) assetList.get(i);
					 AnnualReturn = (getBaseRateOfReturn(assetcode)* (Stok.getSharePrice() * getValue(assetcode) + (4 *(getQuarterlyDividend(assetcode) * getValue(assetcode) ))));
				 }
				 if(assetType.equals("D")){
					 Deposit Dep= (Deposit) assetList.get(i);
					 AnnualReturn = (Math.pow(Math.E, Dep.getApr() - 1)*getValue(assetcode));
				 }	 
			}
		 } 
		 return AnnualReturn;
		 }

	 public double getValue(String assetcode){
		//these methods will calculate the necessary values. The previous getters made these equations a lot easier to handle. it takes an
		 //assetcode and will find the data needed for it. the for loop iterates through the list of assets in the portfolio. Depending on the type,
		 //it will make the correct calculation
		 double Value = 0;
		 assetType= getAssetType(assetcode);
		 for(int k=0; k<assetList.size(); k++){
			if(assetList.get(k).getAssetCode().equals(assetCode)){
						if(assetType.equals("P")){
							PrivateInvestment Priv= (PrivateInvestment)assetList.get(k);
							Value = Priv.getTotalValue() * getAssetValue() * .01;
							 return Value;
						}
						if(assetType.equals("S")){
							Stock Stok= (Stock) assetList.get(k);
							Value = Stok.getSharePrice() * getAssetValue();							
							return Value;
						}
						if(assetType.equals("D")){
							Value = getAssetValue();
							 return Value;
						}	
			}
				
		
			
		 }
		 return Value;
	 }
	 public double getRisk(String assetcode) {
		//these methods will calculate the necessary values. The previous getters made these equations a lot easier to handle. it takes an
		 //assetcode and will find the data needed for it. the for loop iterates through the list of assets in the portfolio. Depending on the type,
		 //it will make the correct calculation
		 assetType= getAssetType(assetcode);
		 for(int i=0; i<assetList.size(); i++){
			 if(assetList.get(i).getAssetCode().equals(assetcode)){
				 if(assetType.equals("P")){
					 PrivateInvestment Priv= (PrivateInvestment) assetList.get(i);
					 risk = Priv.getOmegaMeasure()+ Math.pow(java.lang.Math.E,(-100000/Priv.getTotalValue()));
				 }
				 if(assetType.equals("S")){
					 Stock Stok= (Stock) assetList.get(i);
					 risk = Stok.getBetaMeasure();
				 }
				 if(assetType.equals("D")){
					 risk = 0;
				 } 
			 }
		 }
		 return risk;		 
	 }
}
