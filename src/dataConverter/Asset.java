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
	double baseRateOfReturn;
	double assetModifier; 
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
