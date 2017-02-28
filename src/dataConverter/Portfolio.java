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
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
	
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
		return round(fees,2);
	}

	public double getCommissions() {
	int o=0;
	int k=0;
	
			while(o<getManagerCount()){
			
			while(k<assetcount){
						if(Ass[k].getCode().equals(AssetName[o])){	
							
								if(Ass[k].getType().equals("P")){
									AnnualReturn = getAnnualReturn(o);
									sumOfAnnualReturn+= AnnualReturn;		
	
								}
								if(Ass[k].getType().equals("S")){
									AnnualReturn = getAnnualReturn(o);
									sumOfAnnualReturn+= AnnualReturn;
								}
								if(Ass[k].getType().equals("D")){
									AnnualReturn = getAnnualReturn(o);
									sumOfAnnualReturn+= AnnualReturn;		
								}						
											
							}
			k++;
			}
		o++;
		}
	
	k=0; 
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
		return round(commissions,2);
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
		
		return round(Risk,4);
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
		
		return round(Value,2);
	}
	public double getTotalValue(){
		double tempvalue=0;
		for(int o=0; o<OccuranceOfAssetCount; o++){
			tempvalue+=getValue(o);
		}
		TotalValue= tempvalue;
		return round(TotalValue,2);
	}
	
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
		return round(AnnualReturn,2);
	}

	public double[] getReturnRate() {
		int o=0;	
		int r=0;
				o=0;
				while(o<OccuranceOfAssetCount){
					r=0;
					while(r<assetcount){
						if(Ass[r].getCode().equals(AssetName[o])){
								if(Ass[r].getType().equals("P")){
									AnnualReturn = getAnnualReturn(o);
									ReturnRate[o]= round((AnnualReturn/getValue(o)),2);			
								}
								if(Ass[r].getType().equals("S")){
										AnnualReturn = getAnnualReturn(o);
										ReturnRate[o]= round((AnnualReturn/getValue(o)),2);		
								}
								if(Ass[r].getType().equals("D")){
										AnnualReturn = getAnnualReturn(o);
										ReturnRate[o]= round((AnnualReturn/getValue(o)),2);		
								}
						}
					r++;			
					}
				o++;
				}		
		return ReturnRate;
	}

	public double getAggRisk() {
		double temprisk=0;
		AggRisk=0;
		int o=0;	
				while(o<OccuranceOfAssetCount){
					temprisk= (getRisk(o)*getValue(o))/getTotalValue();
					AggRisk+= temprisk;					
					o++;
				}
		return round(AggRisk,4);
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