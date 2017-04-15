package dataConverter;

import java.util.ArrayList;
import java.util.List;

public interface PortfolioInterface extends databaseinfoandmethods {
	List<Asset> Assets= databaseinfoandmethods.getAssets();
	
	public static List<Asset> getRelevantAssets(String PortfolioCode){
		
		List<Asset> NewAssets= new ArrayList<Asset>();
		int i = 0;
		for(i=0; i<Assets.size(); i++){
		if(PortfolioCode.equals(Assets.get(i).getPortfolioCode())){
			NewAssets.add(Assets.get(i));
		}
			
		}
		return NewAssets;
	}
	public static Persons getOwner(String ownerCode){
		List<Persons> Persons= new ArrayList<Persons>();
		Persons = databaseinfoandmethods.getPersons();
		Persons owner= null; 
		int i = 0;
		for(i=0; i<Persons.size(); i++){
		if(ownerCode.equals(Persons.get(i).getCode())){
			owner=Persons.get(i);
		}	
		}
		return owner;
	}
	public static Persons getBeneficiary(String beneficiaryCode){
		List<Persons> Persons = databaseinfoandmethods.getPersons();
		Persons beneficiary= null;
		int i = 0;
		while(i<Persons.size()){		
				if(beneficiaryCode.equals(Persons.get(i).getCode())){
					beneficiary=Persons.get(i);
				}
			i++;	
			
		}
		return beneficiary;
	
	}
	public static Persons getManager(String managerCode){
		List<Persons> Persons= new ArrayList<Persons>();
		Persons = databaseinfoandmethods.getPersons();
		Persons manager= null; 
		int i = 0;
		for(i=0; i<Persons.size(); i++){
		if(managerCode.equals(Persons.get(i).getCode())){
			manager=Persons.get(i);
		}
			
		}
		return manager;
	}
	public static double getTotalPortfolioValue(List<Asset> RelevantAssets){
		double Value = 0;
		
		for(int k=0; k<RelevantAssets.size(); k++){
				if(RelevantAssets.get(k).getAssetType(RelevantAssets.get(k).assetCode).equals("P")){
					Value += RelevantAssets.get(k).getPrivateValue(RelevantAssets.get(k).assetCode) * RelevantAssets.get(k).assetValue * .01;
				}
				if(RelevantAssets.get(k).getAssetType(RelevantAssets.get(k).assetCode).equals("S")){
					Value += RelevantAssets.get(k).getSharePrice(RelevantAssets.get(k).assetCode) * RelevantAssets.get(k).assetValue;
				}
				if(RelevantAssets.get(k).getAssetType(RelevantAssets.get(k).assetCode).equals("D")){
					Value += RelevantAssets.get(k).assetValue;
				}
			}
		return Value;
	}
	public static double getAnnualReturnSum(List<Asset> RelevantAssets) {
		double AnnualReturnSum = 0;
		for(int k=0; k<RelevantAssets.size(); k++){
				AnnualReturnSum+= RelevantAssets.get(k).getAnnualReturn(RelevantAssets.get(k).getAssetCode());
			}
		return AnnualReturnSum;
	}

	public static double getReturnRate(List<Asset> RelevantAssets) {
		int o=0;	
		double ReturnRate = 0;
				o=0;
				while(o<RelevantAssets.size()){
						
						double	AnnualReturn = RelevantAssets.get(o).getAnnualReturn(RelevantAssets.get(o).getAssetCode());
							ReturnRate+= AnnualReturn/ getTotalPortfolioValue(RelevantAssets);			
				o++;
				}		
		return ReturnRate;
	}

	public static double getAggRisk(List<Asset> RelevantAssets) {
		double temprisk=0;
		double risksum=0;
		double AggRisk=0;
			for(int o=0; o<RelevantAssets.size(); o++){
					temprisk= (RelevantAssets.get(o).getRisk(RelevantAssets.get(o).getAssetCode())*RelevantAssets.get(o).getValue(RelevantAssets.get(o).getAssetCode()))/getTotalPortfolioValue(RelevantAssets);
					risksum+=temprisk;
				}
			AggRisk=risksum;
		return AggRisk;
	}
	public static double getCommissions(List<Asset>RelevantAssets, String ManagerCode){
		double commissions=0;
		int k=0;	
		List<Persons> Person= databaseinfoandmethods.getPersons();
		while(k<Person.size()){
		if(Person.get(k).getCode().equals(ManagerCode)){
			if(Person.get(k).getPersonType().equals("E")){
				commissions = (.05 * getAnnualReturnSum(RelevantAssets));
			}
			if(Person.get(k).getPersonType().equals("J")){
				commissions = (.02 * getAnnualReturnSum(RelevantAssets));
			}
		}
		k++;
		}	

		return commissions;
	}
	public static double getFees(List<Asset>RelevantAssets, String ManagerCode){
		double fees=0;
		int k=0;
		List<Persons> Person= databaseinfoandmethods.getPersons();

		while(k<Person.size()){
			if(Person.get(k).getCode().equals(ManagerCode)){
						if(Person.get(k).getPersonType().equals("E")){
							fees = 10 * RelevantAssets.size();
						}
						if(Person.get(k).getPersonType().equals("J")){
							fees = 50 * RelevantAssets.size();
						}
			}
			k++;		
		}
		return fees;
	}
}