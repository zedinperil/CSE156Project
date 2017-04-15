package dataConverter;

import java.util.ArrayList;
import java.util.List;
//this interface contains various useful methods for calculations in a portfolio


public interface PortfolioInterface extends databaseinfoandmethods {
	List<Asset> Assets= databaseinfoandmethods.getAssets();
	//this is a very useful method we created to avoid having to iterate through assets that are not in a portfoliocode. Returns an asset list
	//that are only in a given portfolio code
	public static List<Asset> getRelevantAssets(String PortfolioCode){
		
		List<Asset> NewAssets= new ArrayList<Asset>();
		///takes a list of persons to run through.
		//iterates through to find the correct name, then returns the string
		int i = 0;
		for(i=0; i<Assets.size(); i++){
		if(PortfolioCode.equals(Assets.get(i).getPortfolioCode())){
			NewAssets.add(Assets.get(i));
		}
			
		}
		return NewAssets;
	}
	//Gets the owner name. Pretty simple, makes the output look nicer.
	public static Persons getOwner(String ownerCode){
		List<Persons> Persons= new ArrayList<Persons>();
		Persons = databaseinfoandmethods.getPersons();
		//takes a list of persons to run through.
		Persons owner= null; 
		int i = 0;
		for(i=0; i<Persons.size(); i++){
		if(ownerCode.equals(Persons.get(i).getCode())){
			owner=Persons.get(i);
		}	
		}
		return owner;
	}
	//Get the beneficary name. Same as the owner notes
	public static Persons getBeneficiary(String beneficiaryCode){
		List<Persons> Persons = databaseinfoandmethods.getPersons();
		///takes a list of persons to run through.
		Persons beneficiary= null;
		int i = 0;
		while(i<Persons.size()){		
				if(beneficiaryCode.equals(Persons.get(i).getCode())){
					beneficiary=Persons.get(i);
				}
			i++;	
			
		}
		//returns the sting of the beneficiary name.
		return beneficiary;
	
	}
	//same thing as the other name getters. returns the correct name once it iterates through
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
	//This method takes the assets in a portfolio and will sum the individual sums in a portfolio. Returns the sum which is a double
	public static double getTotalPortfolioValue(List<Asset> RelevantAssets){
		double Value = 0;
		//iterates through the list of relevant assets, checks the type, and does the according equation.
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
		//returns the sum of the values for each individual asset.
		return Value;
	}
	//Gets the sum of annual returns. Same process as the above method, just simplified as we saw a good way to make it easier. We left the above
	//method for the sake of knowing we can do it two different ways, and that the written out method could be useful for future use.
	public static double getAnnualReturnSum(List<Asset> RelevantAssets) {
		double AnnualReturnSum = 0;
		for(int k=0; k<RelevantAssets.size(); k++){
				AnnualReturnSum+= RelevantAssets.get(k).getAnnualReturn(RelevantAssets.get(k).getAssetCode());
			}
		return AnnualReturnSum;
	}
	//This is most likely useless. We left it here for potential use, but probably does nothing. Return rate is calculated individually, dont need 
	//a return rate of the sum.
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
	//calculates the aggregate risk. Pretty standard math. Takes in the list of assets in a portfolio and return the double.
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
	//gets the commisions for the portfolio. Pretty cool stuff. Pretty much the same thing. Have it take a managercode so we can tell if it is an
	//e or j to do calulations accordingly.
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
		//very similar to commisions. We take a manager code to get the type for the calcuation.
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