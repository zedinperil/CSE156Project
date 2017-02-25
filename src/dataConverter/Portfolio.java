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
	
	/**
	 * @return the risk
	 */
	public double getRisk() {
		return Risk;
	}

	/**
	 * @return the annualReturn
	 */
	public double getAnnualReturn() {
		return AnnualReturn;
	}

	/**
	 * @return the sumOfAnnualReturn
	 */
	public double getSumOfAnnualReturn() {
		return sumOfAnnualReturn;
	}

	/**
	 * @return the assetName
	 */
	public String[] getAssetName() {
		return AssetName;
	}

	/**
	 * @return the assetValue
	 */
	public double[] getAssetValue() {
		return AssetValue;
	}

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
		this.OccuranceOfAssetCount=i;
			for(k=0; k<i; k++){
				 StringTokenizer twokenizer= new StringTokenizer(temporaryString[k], ":");
					 if(twokenizer.hasMoreTokens()){
						 this.AssetName[k]= twokenizer.nextToken();
					 }
					 if(twokenizer.hasMoreTokens()){
						this.AssetValue[k]= Double.parseDouble(twokenizer.nextToken());
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
				k++;
			}
		}
		return ownerName;
	}
	
	public String getManagerName(){
		int i=0;
		int k=0;
				while(k<personcount){			
					if(Per[i][k].getPersonCode().equals(this.ManagerCode)){
						managerName=(Per[i][k].getFirstName()+" "+Per[i][k].getLastName());
					k=personcount;
					
					}
					k++;
				}
		return managerName;
	}
	
	public String getBeneficiaryName(){
		int i=0;
		int k=0;
		
			while(k<personcount){			
				if(Per[i][k].getPersonCode().equals(this.BeneficiaryCode)){
					beneficiaryName=(Per[i][k].getFirstName()+" "+Per[i][k].getLastName());
				k=personcount;
				
				}
				k++;
			}
		
		if(getBeneficiaryCode().equals("none")){
			beneficiaryName="none";
		}
		return beneficiaryName;
	}
	
	public String getManagerCode() {
		return ManagerCode;
	}

	public String getBeneficiaryCode() {
		
		if(BeneficiaryCode.equals("")){
		
			return "none";
			
		}
		else{
		
		return BeneficiaryCode;
		}
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
	int r=0;
		for(int i=1;i<2; i++){
		k=0;
			while(k<assetcount){
			o=0;
			while(o<=getManagerCount()){
				if(Ass[1][k].getCode().equals(AssetName[o])){
					for(int q=1; q<2; q++){
						r=0;
						while(r<assetcount){
							if(Ass[q][r].getType().equals("P")){
								if(Ass[q][r].getCode().equals(AssetName[o])){
								AnnualReturn = getAnnualReturn(r, o);
								sumOfAnnualReturn+= AnnualReturn;		
								}
							}
							if(Ass[q][r].getType().equals("S")){
								if(Ass[q][r].getCode().equals(AssetName[o])){
								AnnualReturn = getAnnualReturn(r, o);
								sumOfAnnualReturn+= AnnualReturn;
								}
							}
							if(Ass[q][r].getType().equals("D")){
								if(Ass[q][r].getCode().equals(AssetName[o])){
								AnnualReturn = getAnnualReturn(r, o);
								sumOfAnnualReturn+= AnnualReturn;		
								}
							}
						r++;
						}
					}
				}		
			o++;
			}
		k++;
		}
	}
	k=0; 
	while(k<personcount){
	if(Per[0][k].getPersonCode().equals(ManagerCode)){
		if(Per[0][k].getType().equals("E")){
			commisions = .05 * sumOfAnnualReturn;
		}
		if(Per[0][k].getType().equals("J")){
			commisions = .02 * sumOfAnnualReturn;
		}
	}
	k++;
	}	
		return commisions;
	}
	public double getRisk(int u) {
	int k;
	int i=1;	
			k=0;
			while(k<assetcount){
				if(Ass[i][k].getType().contains("P")){
					if(Ass[i][k].getCode().equals(AssetName[u]))
					Risk = Double.parseDouble(Ass[i][k].getOmegaMeasure())+ Math.pow(java.lang.Math.E,(-100000/(Double.parseDouble(Ass[i][k].getTotalValue())*AssetValue[k]*.01)));
				}
				if(Ass[i][k].getType().contains("S")){
					if(Ass[i][k].getCode().equals(AssetName[u]))
					Risk = Double.parseDouble(Ass[i][k].getBetaMeasure());
				}
				if(Ass[i][k].getType().contains("D")){
					if(Ass[i][k].getCode().equals(AssetName[u]))
					Risk = 0;
				}
			k++;
			}
		
		return Risk;
}
	public double getValue() {
		int i=1;
			for(int k=0; k<assetcount; k++){
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
		
		return Value;
	}

	public double getAnnualReturn(int k, int o) {
		int i=1;
				if(Ass[i][k].getType().contains("P")){
						if(Ass[i][k].getCode().equals(AssetName[o])){
							AnnualReturn = Ass[i][k].getBaseRateOfReturn()* (Double.parseDouble(Ass[i][k].getTotalValue()) * AssetValue[o] * .01)+ (4 *(Double.parseDouble(Ass[i][k].getQuarterlyDividend()) * AssetValue[o] * .01));
						}
					}
				if(Ass[i][k].getType().contains("S")){
						if(Ass[i][k].getCode().equals(AssetName[o])){
							AnnualReturn = (Ass[i][k].getBaseRateOfReturn()* (Double.parseDouble(Ass[i][k].getSharePrice()) * AssetValue[o])+ (4 *(Double.parseDouble(Ass[i][k].getQuarterlyDividend()) * AssetValue[o] )));
						}
				}
				if(Ass[i][k].getType().contains("D")){
						if(Ass[i][k].getCode().equals(AssetName[o])){
							AnnualReturn = (Math.pow(Math.E, Ass[i][k].getApr()) - 1)*AssetValue[o];
						}
				}
		
//		System.out.println("woo"+ AnnualReturn);
		return AnnualReturn;
	}

	public double getReturnRate() {
		int i=1;
			for(int k=0; k<assetcount; k++){
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
		int i=1; 
		for(int k=0; k<assetcount; k++){
					if(Ass[i][u].getCode().equals(AssetName[k])){
					g=k;
					}
			}
		
		return AssetName[g];
	}

	public double getAssetValue(int u) {
		int g=0;
		int i=1;
		for(int k=0; k<assetcount; k++){
					if(Ass[i][u].getCode().equals(AssetName[k])){
					g=k;
					}
			}
		
		return AssetValue[g];
	}

	public String[] getTemporaryString() {
		return temporaryString;
	}

	public int getOccuranceOfAssetCount() {
		return this.OccuranceOfAssetCount;
	}

	public int getManagerCount() {
		ManagerCount=0;
		int k=0;
		for(int i=0; i<2; i++){
			k=0;
			while(k<personcount){			
				if(Per[0][k].getPersonCode().equals(this.OwnerCode)){
					ManagerCount++;
				k=personcount;
				}
				k++;
			}
		}
		return ManagerCount;
	}

	

	
	

	
}	