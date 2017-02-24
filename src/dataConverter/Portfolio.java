package dataConverter;

import java.util.StringTokenizer;
import java.math.*;
public class Portfolio {
	private String PortfolioCode;
	private String OwnerCode;
	private String ManagerCode;
	private String BeneficiaryCode;
	private String Asset;
	private Assets[][] Ass;
	private Persons[][] Per;
	
	private double fees;
	private double commisions;
	
	private double Risk;
	private double Value;
	private double AnnualReturn;
	private double ReturnRate;
	
	private double AggRisk;
	private int personcount;
	private int assetcount;
	
	private String[] AssetName= new String[100];
	private double[] AssetValue=new double[100];
	private String[] temporaryString=new String[1000];
	private int OccuranceOfAssetCount=0;
	
	public Portfolio(String portCode, String ownCode, String managCode, String beneficiaryCode, 
					 String assetsA, Persons[][] persons, Assets[][] asset, int PersonsCount, int AssetsCount) {
		super();
		
		this.PortfolioCode = portCode;
		this.OwnerCode = ownCode;
		this.ManagerCode = managCode;
		this.BeneficiaryCode = beneficiaryCode;
		this.Asset = assetsA;
		this.Ass = asset;
		this.Per = persons;
		this.personcount = PersonsCount;
		this.assetcount = AssetsCount;
		int i=0;
		int k;
		StringTokenizer tokenizer= new StringTokenizer(assetsA, ",");
		while(tokenizer.hasMoreTokens()){
			temporaryString[i]= tokenizer.nextToken();
			i++;
		}
		for(k=0; k<=i; k++){
			StringTokenizer twokenizer= new StringTokenizer(temporaryString[i], ":");
			AssetName[k]= twokenizer.nextToken();
			AssetValue[k]= Double.parseDouble(twokenizer.nextToken());
		}
		
	}

	public String getPortfolioCode() {
		return PortfolioCode;
	}

	public String getOwnerCode() {
		return OwnerCode;
	}

	public String getManagerCode() {
		return ManagerCode;
	}

	public String getBeneficiaryCode() {
		return BeneficiaryCode;
	}

	public String getAsset() {
		return Asset;
	}

	public Assets[][] getAss() {
		return Ass;
	}

	public Persons[][] getPer() {
		return Per;
	}

	public double getFees() {
		return fees;
	}

	public double getCommisions() {
		return commisions;
	}

	public double getRisk() {
		for(int i=0; i<2; i++){
			for(int k=0; k<=assetcount; k++){
				if(Ass[i][k].getType().contains("P")){
					if(Ass[i][k].getCode().equals(AssetName[k]))
					Risk = Double.parseDouble(Ass[i][k].getOmegaMeasure())+ Math.pow(java.lang.Math.E,(-100000/(Double.parseDouble(Ass[i][k].getTotalValue())*AssetValue[k]*.01)));
				}
				if(Ass[i][k].getType().contains("S")){
					if(Ass[i][k].getCode().equals(AssetName[k]))
					Risk = Double.parseDouble(Ass[i][k].getBetaMeasure());
				}
				if(Ass[i][k].getType().contains("D")){
					if(Ass[i][k].getCode().equals(AssetName[k]))
					Risk = 0;
			}
		}
		
		return Risk;
	}

	public double getValue() {
		return Value;
	}

	public double getAnnualReturn() {
		return AnnualReturn;
	}

	public double getReturnRate() {
		return ReturnRate;
	}

	public double getAggRisk() {
		return AggRisk;
	}

	public int getPersoncount() {
		return personcount;
	}

	public int getAssetcount() {
		return assetcount;
	}

	public String getAssetName() {
		return AssetName;
	}

	public double getAssetValue() {
		return AssetValue;
	}

	public String[] getTemporaryString() {
		return temporaryString;
	}

	public int getOccuranceOfAssetCount() {
		return OccuranceOfAssetCount;
	}

	
	

	
}	