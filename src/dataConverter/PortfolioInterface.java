package dataConverter;

import java.util.ArrayList;
import java.util.List;

public interface PortfolioInterface extends databaseinfoandmethods {
	
	
	
	public static List<Asset> gitGud(String PortfolioCode){
		List<Asset> Assets= new ArrayList<Asset>();
		Assets = databaseinfoandmethods.getAssets();
		List<Asset> NewAssets= new ArrayList<Asset>();
		int i = 0;
		for(i=0; i<Assets.size(); i++){
		if(PortfolioCode.equals(NewAssets.get(i).getPortfolioCode())){
			NewAssets.add(Assets.get(i));
		}
			
		}
		return NewAssets;
	}
	
	
	public static double ValueMethod(List<Asset> RelevantAssets){
		double Value = 0;
		
		for(int k=0; k<RelevantAssets.size(); k++){
				if(RelevantAssets.get(k).getAssetType(RelevantAssets.get(k).assetCode).equals("P")){
					Value = Double.parseDouble(RelevantAssets.getPrivateValue(RelevantAssets.get(k).assetCode)) * RelevantAssets.get(k).assetValue * .01;
				}
				if(RelevantAssets.get(k).getAssetType(RelevantAssets.get(k).assetCode).equals("S")){
					Value = Double.parseDouble(RelevantAssets.get(k).getSharePrice(RelevantAssets.get(k).assetCode)) * RelevantAssets.get(k).assetValue;
				}
				if(RelevantAssets.get(k).getAssetType(RelevantAssets.get(k).assetCode).equals("D")){
					Value = RelevantAssets.get(k).assetValue;
				}
			}
		return Value;
	}



	public static double getAnnualReturn(List<Asset> RelevantAssets) {
		double AnnualReturn = 0;
		for(int k=0; k<RelevantAssets.size(); k++){
				if(RelevantAssets.get(k).getAssetType(RelevantAssets.get(k).assetCode).equals("P")){
						AnnualReturn = RelevantAssets.get(k).getBaseRateOfReturn()* (Double.parseDouble(RelevantAssets.get(k).getTotalValue()) * AssetValue[o] * .01)+ (4 *(Double.parseDouble(RevelantAssets.get(k).getQuarterlyDividend()) * AssetValue[o] * .01));				
					}
				if(RelevantAssets.get(k).getAssetType(RelevantAssets.get(k).assetCode).equals("S")){
						AnnualReturn = (RelevantAssets.get(k).getBaseRateOfReturn()* (Double.parseDouble(RelevantAssets.get(k).getSharePrice()) * AssetValue[o])+ (4 *(Double.parseDouble(RevelantAssets.get(k).getQuarterlyDividend()) * AssetValue[o] )));	
				}
				if(RelevantAssets.get(k).getAssetType(RelevantAssets.get(k).assetCode).equals("D")){
						AnnualReturn = (Math.pow(Math.E, RelevantAssets.get(k).getApr()) - 1)*AssetValue[o];					
				}
			}
		
		return AnnualReturn;
	}

	public static double getReturnRate(List<Asset> RelevantAssets) {
		int o=0;	
		int r=0;
		double ReturnRate = 0;
				o=0;
				while(o<RelevantAssets.size()){
					r=0;
					while(r<assetcount){
						if(Ass[r].getCode().equals(AssetName[o])){
							AnnualReturn = getAnnualReturn(o);
							ReturnRate= AnnualReturn/getValue(o);			
						}
					r++;			
					}
				o++;
				}		
		return ReturnRate;
	}

	public double getAggRisk() {
		double temprisk=0;
		double risksum=0;
		AggRisk=0;
			for(int o=0; o<OccuranceOfAssetCount; o++){
					temprisk= (getRisk(o)*getValue(o))/getTotalValue();
					risksum+=temprisk;
				}
			AggRisk=risksum;
		return AggRisk;
	}
}