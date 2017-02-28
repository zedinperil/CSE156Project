package dataConverter;

import java.util.StringTokenizer;

public class Portfolio {
	private String PortfolioCode;
	private String OwnerCode;
	private String ManagerCode;
	private String BeneficiaryCode;
	private String Asset;
	private Assets[] Ass;
	private Persons[] Per;
	private String ownerName;
	private double fees;
	private double commisions;
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
	
	
	public Portfolio(String portCode, String ownCode, String managCode, String beneficiaryCode, 
					 String assetsA, Persons[] persons, Assets[] asset, int PersonsCount, int AssetsCount) {
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
	
	public String getPortfolioCode() {
		return PortfolioCode;
	}

	public String getOwnerCode() {
		return OwnerCode;
		
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

	
	public String getOwnerName(){
		int i=1;
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
	
	public String getManagerName(){
		int i=0;
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
	
	public String getBeneficiaryName(){
		int i=0;
		int k=0;
		
			while(k<personcount){			
				if(Per[k].getPersonCode().equals(this.BeneficiaryCode)){
					beneficiaryName=(Per[k].getFirstName()+" "+Per[k].getLastName());
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

	public Assets getAss(int i) {
		return Ass[i];
	}

	public Persons getPer(int i) {
		return Per[i];
	}

	public double getFees() {
		int i=0;
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

	public double getCommissions() {
	int o=0;
	int k=0;
	int r=0;
			while(k<assetcount){
			o=0;
			while(o<=getManagerCount()){
				if(Ass[k].getCode().equals(AssetName[o])){
						r=0;
						while(r<assetcount){
							if(Ass[r].getType().equals("P")){
								if(Ass[r].getCode().equals(AssetName[o])){
								AnnualReturn = getAnnualReturn(o);
								sumOfAnnualReturn+= AnnualReturn;		
								}
							}
							if(Ass[r].getType().equals("S")){
								if(Ass[r].getCode().equals(AssetName[o])){
								AnnualReturn = getAnnualReturn(o);
								sumOfAnnualReturn+= AnnualReturn;
								}
							}
							if(Ass[r].getType().equals("D")){
								if(Ass[r].getCode().equals(AssetName[o])){
								AnnualReturn = getAnnualReturn(o);
								sumOfAnnualReturn+= AnnualReturn;		
								}
							}
						r++;
						}
				}		
			o++;
			}
		k++;
		}
	
	k=0; 
	while(k<personcount){
	if(Per[k].getPersonCode().equals(ManagerCode)){
		if(Per[k].getType().equals("E")){
			commisions = .05 * sumOfAnnualReturn;
		}
		if(Per[k].getType().equals("J")){
			commisions = .02 * sumOfAnnualReturn;
		}
	}
	k++;
	}	
		return commisions;
	}
	public double getRisk(int u) {
	int k=0;
			while(k<assetcount){
				if(Ass[k].getType().contains("P")){
					if(Ass[k].getCode().equals(AssetName[u]))
					Risk = Double.parseDouble(Ass[k].getOmegaMeasure())+ Math.pow(java.lang.Math.E,(-100000/(Double.parseDouble(Ass[k].getTotalValue()))));
				}
				if(Ass[k].getType().contains("S")){
					if(Ass[k].getCode().equals(AssetName[u]))
					Risk = Double.parseDouble(Ass[k].getBetaMeasure());
				}
				if(Ass[k].getType().contains("D")){
					if(Ass[k].getCode().equals(AssetName[u]))
					Risk = 0;
				}
			k++;
			}
		
		return Risk;
}
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
	public double getTotalValue(){
	for(int o=0; o<=OccuranceOfAssetCount; o++){
		TotalValue+=getValue(o);
		}
		return TotalValue;
	}
	
	public double getAnnualReturn(int o) {
		int i=1;
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

	public double[] getReturnRate() {
		int o=0;	
		int r=0;
				o=0;
				while(o<=OccuranceOfAssetCount){
					r=0;
					while(r<assetcount){
				
								if(Ass[r].getType().equals("P")){
									if(Ass[r].getCode().equals(AssetName[o])){
				//						System.out.println("YO "+getAnnualReturn(r,o));
									AnnualReturn = getAnnualReturn(o);
									ReturnRate[o]= AnnualReturn/getValue(o);		
									
									}
								}
								if(Ass[r].getType().equals("S")){
									if(Ass[r].getCode().equals(AssetName[o])){
				//						System.out.println("YO "+getAnnualReturn(r,o));

										AnnualReturn = getAnnualReturn(o);
										ReturnRate[o]= AnnualReturn/getValue(o);		
									

									}
								}
								if(Ass[r].getType().equals("D")){
									if(Ass[r].getCode().equals(AssetName[o])){
				//						System.out.println("YO "+getAnnualReturn(r,o));

										AnnualReturn = getAnnualReturn(o);
										ReturnRate[o]= AnnualReturn/getValue(o);		
											

									}
								}
					r++;			
					}
				o++;
				}		
		return ReturnRate;
	}

	public double getAggRisk() {
		double temprisk;
		int o=0;	
		int r=0;
				o=0;
				while(o<=OccuranceOfAssetCount){
					r=0;
					while(r<assetcount){							
									if(Ass[r].getCode().equals(AssetName[o])){
									temprisk= (getRisk(o)*getValue(o))/getTotalValue();
									AggRisk+= temprisk;		
									}
					r++;			
					}
				o++;
				}
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
					if(Ass[k].getCode().equals(AssetName[u])){
						g=u;
					}
			}
		return AssetName[g];
	}

	public double getAssetValue(int u) {
		int g=0;
		int i=1;
		for(int k=0; k<assetcount; k++){
					if(Ass[k].getCode().equals(AssetName[u])){
					g=u;
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
				if(Per[k].getPersonCode().equals(this.OwnerCode)){
					ManagerCount++;
				k=personcount;
				}
				k++;
			}
		}
		return ManagerCount;
	}

	

	
	

	
}	