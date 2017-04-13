package dataConverter;

import java.util.List;
import java.util.ArrayList;
public class Asset implements databaseinfoandmethods{
	String portfolioCode;
	
	String assetCode; 
	String assetName; 
	String assetType; 
	double assetValue;
	double returnRate;
	double annualReturn;
	double risk;
	double assetModifier; 
	public Asset(String portfolio, String code, String Name, String Type, double Value, double RETURNRATE, double ANNUALRETURN, double RISK,double modifier) {
		this.portfolioCode= portfolio;
		this.assetCode = code;
		this.assetName= Name;
		this.assetType= Type;
		this.assetValue= Value;
		this.returnRate= RETURNRATE;
		this.annualReturn= ANNUALRETURN;
		this.risk= RISK;
		this.assetModifier= modifier;
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
	public String getAssetName() {
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
	public String getAssetType() {
		List<Deposit> Depositlist= new ArrayList<Deposit>();
		List<Stock> Stocklist= new ArrayList<Stock>();
		List<PrivateInvestment> PIlist= new ArrayList<PrivateInvestment>();
		Depositlist= getDeposits();
		Stocklist= getStocks();
		PIlist= getPrivateInvestments();
		int q=0;
		for(q=0; q<Depositlist.size(); q++){
			if(this.assetCode.equals(Depositlist(q).getAssetCode())){
				assetType="D";
			}
		}
		for(q=0; q<Stocklist.size(); q++){
			if(this.assetCode.equals(Stocklist(q).getAssetCode())){
				assetType="S";
			}
		}
		for(q=0; q<PIlist.size(); q++){
			if(this.assetCode.equals(PIlist(q).getAssetCode())){
				assetType="P";
			}
		}
		return assetType;
	}
	/**
	 * @param assetType the assetType to set
	 */
	public void setAssetType(String assetType) {
		this.assetType = assetType;
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
	/**
	 * @return the assetModifier
	 */
	public double getAssetModifier() {
		return assetModifier;
	}
	/**
	 * @param assetModifier the assetModifier to set
	 */
	public void setAssetModifier(double assetModifier) {
		this.assetModifier = assetModifier;
	}
}
