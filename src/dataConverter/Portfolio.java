package dataConverter;

import java.util.StringTokenizer;

public class Portfolio {
	private String PortfolioCode;
	private String OwnerCode;
	private String ManagerCode;
	private String BeneficiaryCode;
	private String Asset;
	private Assets[][] Ass;
	private Persons[][] Per;
	
	private String ownerName;
	private double fees;
	private double commisions;
	
	private double Risk;
	private double Value;
	private double AnnualReturn;
	private double ReturnRate;
	
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
		if(tokenizer.hasMoreTokens()){
			while(tokenizer.hasMoreTokens()){
				temporaryString[i]= tokenizer.nextToken();
				i++;
			}
		}
		OccuranceOfAssetCount=i;
			for(k=0; k<i; k++){
				 StringTokenizer twokenizer= new StringTokenizer(temporaryString[k], ":");
					 if(twokenizer.hasMoreTokens()){
						 AssetName[k]= twokenizer.nextToken();
					 }
					 if(twokenizer.hasMoreTokens()){
						 AssetValue[k]= Double.parseDouble(twokenizer.nextToken());
					 }
				 }
	}
	
	public String getPortfolioCode() {
		return PortfolioCode;
	}

	public String getOwnerCode() {
		return OwnerCode;
	}
	
	public String getOwnerName(){
		int i;
		int k=0;
		for(i=0; i<2; i++){
			while(k<personcount){			
				if(Per[i][k].getPersonCode().equals(this.OwnerCode)){
					ownerName=(Per[i][k].getFirstName()+" "+Per[i][k].getLastName());
				k=personcount;
				}
			}
		}
		return ownerName;
	}
	
	public String getManagerName(){
		int i=0;
		int k=0;
		for(i=0; i<2; i++){
			for(i=0; i<2; i++){
				while(k<personcount){			
					if(Per[i][k].getPersonCode().equals(this.OwnerCode)){
						managerName=(Per[i][k].getFirstName()+" "+Per[i][k].getLastName());
					k=personcount;
					}
				}
			}
		}
		return managerName;
	}
	
	public String getBeneficiaryName(){
		int i=0;
		int k=0;
		for(i=0; i<2; i++){
			while(k<personcount){			
				if(Per[i][k].getPersonCode().equals(this.OwnerCode)){
					beneficiaryName=(Per[i][k].getFirstName()+" "+Per[i][k].getLastName());
				k=personcount;
				}
			}
		}
		if(BeneficiaryCode.equals("none")){
			return "none";
		}
		return beneficiaryName;
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
		int i=0;
		int k=0;
		for(i=0; i<2; i++){
			while(k<=personcount){				
				if(Per[i][k].getPersonCode().equals(ManagerCode)){
							if(Per[i][k].getType().equals("E")){
								fees = 20 * OccuranceOfAssetCount;
							}
							if(Per[i][k].getType().equals("J")){
								fees = 50 * OccuranceOfAssetCount;
							}
							k=personcount;
				}
				k++;	
			}		
		}
		return fees;
	}

	public double getCommisions() {
	int o=0;
	int k=0;
		for(int i=0;i<2; i++){
		while(k<assetcount){
			while(o<getManagerCount()){
				if(Ass[i][k].getCode().equals(AssetName[o])){
					for(int q=0; i<2; i++){
						for(int r=0; k<=assetcount; k++){
							if(Ass[q][r].getType().contains("P")){
								if(Ass[q][r].getCode().equals(AssetName[r]))
								AnnualReturn = Ass[q][r].getBaseRateOfReturn()* (Double.parseDouble(Ass[q][r].getTotalValue()) * AssetValue[r] * .01)
												+ 4 *(Double.parseDouble(Ass[q][r].getQuarterlyDividend()) * AssetValue[r] * .01);
							}
							if(Ass[q][r].getType().contains("S")){
								if(Ass[q][r].getCode().equals(AssetName[r]))
								AnnualReturn = Ass[q][r].getBaseRateOfReturn()* (Double.parseDouble(Ass[q][r].getSharePrice()) * AssetValue[r])
										+ 4 *(Double.parseDouble(Ass[q][r].getQuarterlyDividend()) * AssetValue[r] * .01);
							}
							if(Ass[q][r].getType().contains("D")){
								if(Ass[q][r].getCode().equals(AssetName[r]))
								AnnualReturn = (Math.pow(Math.E, Ass[q][r].getApr()) - 1);
							}
						}
					}
					sumOfAnnualReturn+= AnnualReturn;
						
				}
				if(Per[i][k].getPersonCode().equals(ManagerCode)){
					if(Per[i][k].getType().equals("E")){
						commisions = .05 * sumOfAnnualReturn;
					}
					if(Per[i][k].getType().equals("J")){
						commisions = .02 * sumOfAnnualReturn;
					}
				}
			o++;
			}
		k++;
		}
	}
		
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
		}
		return Risk;
}
	public double getValue() {
		for(int i=0; i<2; i++){
			for(int k=0; k<=assetcount; k++){
				if(Ass[i][k].getType().contains("P")){
					if(Ass[i][k].getCode().equals(AssetName[k]))
					Value = Double.parseDouble(Ass[i][k].getTotalValue()) * AssetValue[k] * .01;
				}
				if(Ass[i][k].getType().contains("S")){
					if(Ass[i][k].getCode().equals(AssetName[k]))
					Value = Double.parseDouble(Ass[i][k].getSharePrice()) * AssetValue[k];
				}
				if(Ass[i][k].getType().contains("D")){
					if(Ass[i][k].getCode().equals(AssetName[k]))
					Value = AssetValue[k];
				}
			}
		}
		return Value;
	}

	public double getAnnualReturn() {
		for(int i=0; i<2; i++){
			for(int k=0; k<=assetcount; k++){
				if(Ass[i][k].getType().contains("P")){
					if(Ass[i][k].getCode().equals(AssetName[k]))
					AnnualReturn = Ass[i][k].getBaseRateOfReturn()* (Double.parseDouble(Ass[i][k].getTotalValue()) * AssetValue[k] * .01)
									+ 4 *(Double.parseDouble(Ass[i][k].getQuarterlyDividend()) * AssetValue[k] * .01);
				}
				if(Ass[i][k].getType().contains("S")){
					if(Ass[i][k].getCode().equals(AssetName[k]))
					AnnualReturn = Ass[i][k].getBaseRateOfReturn()* (Double.parseDouble(Ass[i][k].getSharePrice()) * AssetValue[k])
							+ 4 *(Double.parseDouble(Ass[i][k].getQuarterlyDividend()) * AssetValue[k] * .01);
				}
				if(Ass[i][k].getType().contains("D")){
					if(Ass[i][k].getCode().equals(AssetName[k]))
					AnnualReturn = (Math.pow(Math.E, Ass[i][k].getApr()) - 1);
				}
			}
		}
		return AnnualReturn;
	}

	public double getReturnRate() {
		for(int i=0; i<2; i++){
			for(int k=0; k<=assetcount; k++){
				if(Ass[i][k].getType().contains("P")){
					if(Ass[i][k].getCode().equals(AssetName[k]))
					AnnualReturn = (Ass[i][k].getBaseRateOfReturn()* (Double.parseDouble(Ass[i][k].getTotalValue()) * AssetValue[k] * .01)
							+ 4 *(Double.parseDouble(Ass[i][k].getQuarterlyDividend()) * AssetValue[k] * .01))/(Double.parseDouble(Ass[i][k].getTotalValue()) * AssetValue[k] * .01);
					ReturnRate= AnnualReturn/this.getValue();
				}
				if(Ass[i][k].getType().contains("S")){
					if(Ass[i][k].getCode().equals(AssetName[k]))
					AnnualReturn = (Ass[i][k].getBaseRateOfReturn()* (Double.parseDouble(Ass[i][k].getSharePrice()) * AssetValue[k])
							+ 4 *(Double.parseDouble(Ass[i][k].getQuarterlyDividend()) * AssetValue[k] * .01))/(Double.parseDouble(Ass[i][k].getSharePrice()) * AssetValue[k]);
					ReturnRate= AnnualReturn/this.getValue();
				}
				if(Ass[i][k].getType().contains("D")){
					if(Ass[i][k].getCode().equals(AssetName[k]))
					AnnualReturn = Ass[i][k].getApr();
					ReturnRate= AnnualReturn/this.getValue();
				}
			}
		}
		
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

	public String getAssetName(int u) {
		int g=0;
		for(int i=0; i<2; i++){
			for(int k=0; k<=assetcount; k++){
					if(Ass[i][u].getCode().equals(AssetName[k])){
					g=k;
					}
			}
		}
		return AssetName[g];
	}

	public double getAssetValue(int u) {
		int g=0;
		for(int i=0; i<2; i++){
			for(int k=0; k<=assetcount; k++){
					if(Ass[i][u].getCode().equals(AssetName[k])){
					g=k;
					}
			}
		}
		return AssetValue[g];
	}

	public String[] getTemporaryString() {
		return temporaryString;
	}

	public int getOccuranceOfAssetCount() {
		return OccuranceOfAssetCount;
	}

	public int getManagerCount() {
		int k=0;
		for(int i=0; i<2; i++){
			while(k<personcount){			
				if(Per[i][k].getPersonCode().equals(this.OwnerCode)){
					ManagerCount++;
				k=personcount;
				}
			}
		}
		return ManagerCount;
	}

	

	
	

	
}	