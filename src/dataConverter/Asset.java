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
	public String getAssetName(Asset theAsset) {
	
		
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
		List<Assets> assetList=	databaseinfoandmethods.getAssetList();
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
			List<Assets> assetList=	databaseinfoandmethods.getAssetList();
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
			List<Assets> assetList=	databaseinfoandmethods.getAssetList();
			for(int i=0; i<assetList.size();i++){
				if(assetList.get(i).getAssetType().equals(assetType)&& assetList.get(i).getAssetCode().equals(assetcode)){
					Stock Stok= (Stock) assetList.get(i);	
					sharePrice= Stok.getSharePrice();
				}
			}	
		}
		return sharePrice;
		
	}
}
