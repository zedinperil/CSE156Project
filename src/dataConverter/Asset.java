package dataConverter;

import java.util.List;
import java.util.ArrayList;
public class Asset implements databaseinfoandmethods{
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
    List<Asset> assets= databaseinfoandmethods.getAssets();

	public Asset(String PortfolioCode, String AssetCode, double Value) {
		this.portfolioCode= PortfolioCode;
		this.assetCode = AssetCode;
		this.assetValue= Value;
	}	
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
		for(int i=0; i<assetList.size();i++){
			if(assetList.get(i).getAssetCode().equals(assetCode)){
				assetType=assetList.get(i).getLabel();
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
	public double getReturnRate() {
		return returnRate;
	}
	/**
	 * @param returnRate the returnRate to set
	 */
	public void setReturnRate(double returnRate) {
		this.returnRate = returnRate;
	}
	/**
	 * @return the annualReturn
	 */
	public double getAnnualReturn() {
		return annualReturn;
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
	 public double getAnnualReturn(String assetcode) {
		 double AnnualReturn = 0;
		 assetType= getAssetType(assetcode);

		 for(int i=0; i<assetList.size(); i++){
			if(assetList.get(i).getAssetCode().equals(assetCode)){
				 if(assetType.equals("P")){
					 PrivateInvestment Priv= (PrivateInvestment) assetList.get(i);
					 AnnualReturn = Priv.getBaseRateOfReturn()*(Priv.getTotalValue() * getValue(assetcode) * .01)+ (4 *(Priv.getQuarterlyDividend() * getValue(assetcode) * .01));
				 }
				 if(assetType.equals("S")){
					 Stock Stok= (Stock) assetList.get(i);
					 AnnualReturn = (Stok.getBaseRateOfReturn()* (Stok.getSharePrice() * getValue(assetcode) + (4 *(Stok.getQuarterlyDividend() * getValue(assetcode) ))));
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
		 double Value = 0;
		 assetType= getAssetType(assetcode);
		 for(int k=0; k<assetList.size(); k++){
			if(assetList.get(k).getAssetCode().equals(assetCode)){
				for(int i=0; i<assets.size(); i++){
					if(assets.get(i).getAssetCode().equals(assetCode)){
						if(assetType.equals("P")){
							PrivateInvestment Priv= (PrivateInvestment)assetList.get(k);
							Value = Priv.getTotalValue() * assets.get(i).getAssetValue() * .01;
							 return Value;
						}
						if(assetType.equals("S")){
							Stock Stok= (Stock) assetList.get(k);
							Value = Stok.getSharePrice() * assets.get(i).getAssetValue();
							 return Value;
						}
						if(assetType.equals("D")){
							Value = assets.get(i).getAssetValue();
							 return Value;
						}	
					}
				}
		
			}
		 }
		 return Value;
	 }
	 public double getRisk(String assetcode) {
		 assetType= getAssetType(assetcode);
		 for(int i=0; i<assetList.size(); i++){
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
		 return risk;		 
	 }
}
