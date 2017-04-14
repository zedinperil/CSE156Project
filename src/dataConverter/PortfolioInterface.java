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
					Value = RelevantAssets.get(k).getPrivateValue(RelevantAssets.get(k).assetCode) * RelevantAssets.get(k).assetValue * .01;
				}
				if(RelevantAssets.get(k).getAssetType(RelevantAssets.get(k).assetCode).equals("S")){
					Value = RelevantAssets.get(k).getSharePrice(RelevantAssets.get(k).assetCode) * RelevantAssets.get(k).assetValue;
				}
				if(RelevantAssets.get(k).getAssetType(RelevantAssets.get(k).assetCode).equals("D")){
					Value = RelevantAssets.get(k).assetValue;
				}
			}
		return Value;
	}



	public static double getAnnualReturnSum(List<Asset> RelevantAssets) {
		double AnnualReturnSum = 0;
		for(int k=0; k<RelevantAssets.size(); k++){
				AnnualReturnSum+= RelevanAssets.get(k).getAnnualReturn(RelevantAssets.get(k).portfolioCode);
			}
		return AnnualReturnSum;
	}

	public static double getReturnRate(List<Asset> RelevantAssets) {
		int o=0;	
		double ReturnRate = 0;
				o=0;
				while(o<RelevantAssets.size()){
						
						double	AnnualReturn = getAnnualReturn(RelevantAssets);
							ReturnRate= AnnualReturn/ ValueMethod(RelevantAssets);			
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