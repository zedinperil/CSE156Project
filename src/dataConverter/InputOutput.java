package dataConverter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
//implements our interface for jdbc
public class InputOutput implements databaseinfoandmethods{
	public static void main(String[] args) throws IOException {			
		//formatting for doubles
		DecimalFormat DoubleFormat = new DecimalFormat();
		DoubleFormat.setMaximumFractionDigits(2);
		DoubleFormat.setMinimumFractionDigits(2);
		//format just for the risks
		DecimalFormat RiskFormat = new DecimalFormat();
		RiskFormat.setMaximumFractionDigits(4);
		RiskFormat.setMinimumFractionDigits(4);
		List<Asset> AssetList= new ArrayList<Asset>();
		List<Portfolio> PortfolioList= new ArrayList<Portfolio>();

		//create two array lists, one of portfolios and one of assets, calling methods in our interface class
		PortfolioList= databaseinfoandmethods.getPortfolios();
		AssetList= databaseinfoandmethods.getAssets();
		
		//print formatted data. Many of the lines are formatting to make it look pretty.
		System.out.println("##########################################################################################################################");
		System.out.println();
		System.out.println("A Collection of "+PortfolioList.size()+" Portfolios");
		System.out.println();
		System.out.println("==========================================================================================================================");
		System.out.println();
		//g is used to increment through all portfolios
		int g=0;
		//this is the sum of the total values of all portfolios
		double TotalValueSum = 0;
		//this is the sum of the fees of all portfolios
		double FeesSum = 0;
		//this is the sum of the commissions of all portfolios
		double CommissionsSum = 0;
		//this is the sum of the annual returns of all portfolios
		double AnnualReturnSum=0;
		//while loop iterates through each portfolio
		while( g<PortfolioList.size()){
			//this little for loop is used to determine how many assets are within each portfolio, by checking the number of times in our asset arraylist has the same portfolio code as the current portfolio, and incrementing
			int NumOfAssetInPortfolio=0;
			for(int q=0; q<AssetList.size(); q++){
				if(AssetList.get(q).getPortfolioCode().equals(PortfolioList.get(g).getPortfolioCode())){
					NumOfAssetInPortfolio++;
				}
			}
			//printing relevant info we have retrieved from our database, formatted just the same as in phase 3 of our project
			//for retreiving information from our arraylists, we use the getter methods we have implemented into the relevant classes
			System.out.println("PORTFOLIO #"+(g+1)+"/"+PortfolioList.size());
			System.out.println();
			System.out.println("Portfolio Code :"+PortfolioList.get(g).getPortfolioCode());
			System.out.println("Owner :"+PortfolioList.get(g).getOwnerName());
			System.out.println("Owner Code :"+PortfolioList.get(g).getOwnerCode());
			System.out.println("Manager :"+PortfolioList.get(g).getManagerName());
			System.out.println("Manager Code :"+PortfolioList.get(g).getManagerCode());
			System.out.println("Beneficiary :"+PortfolioList.get(g).getBeneficiaryName());
			System.out.println("Beneficiary Code :"+PortfolioList.get(g).getBeneficiaryCode());
			System.out.print("Owner Emails: ");
			List<String>ownersEmails= PortfolioList.get(g).owner.getEmails(PortfolioList.get(g).getOwnerCode());
			for(int y=0; y<ownersEmails.size(); y++){
				System.out.print(ownersEmails.get(y)+" ");
			}
			System.out.println();
			System.out.println("# Of Assets within the Portfolio :"+NumOfAssetInPortfolio);
			System.out.println();
			System.out.println("FINANCIAL INFORMATION");
			System.out.println();
			System.out.println("Individual Asset Information:");
			System.out.println();
			System.out.println("---------------------------------------------------------------------------------------------------------------------");
			System.out.println();
			//t is a counter used to increment through the assetlist for each portfolio
			int t=0;
			//a is set to zero, and is used as a counter to show what the index is of the currently printed asset out of all assets within the portfolio
			int a=0;
			// loop increments through AssetList
			while(t<AssetList.size()){
				// if statement is used to print out information about an asset if it is known to contain the same portfolio code as the current portfolio  
						if(AssetList.get(t).getPortfolioCode().equals(PortfolioList.get(g).getPortfolioCode())){
							//printed information about asset which fulfilled above conditions
							System.out.println("Asset #"+(a+1)+"/"+NumOfAssetInPortfolio +" in portfolio "+AssetList.get(t).getPortfolioCode()+" (#"+(g+1)+"/"+PortfolioList.size()+")");
							System.out.println("Asset Code :"+AssetList.get(t).getAssetCode());
							System.out.println("Asset Name :"+ AssetList.get(t).getAssetName(AssetList.get(t).getAssetCode()));
							System.out.println("Asset Type :"+ AssetList.get(t).getAssetType(AssetList.get(t).getAssetCode()));
							System.out.println("Asset Value Modifier :"+AssetList.get(t).getAssetValue());
							//these are formatted using our formatter for doubles
							System.out.println("Annual Return :$"+DoubleFormat.format(AssetList.get(t).getAnnualReturn(AssetList.get(t).getAssetCode())));
						    System.out.println("Risk :"+RiskFormat.format(AssetList.get(t).getRisk(AssetList.get(t).getAssetCode())));
						    System.out.println("Value :$"+DoubleFormat.format(AssetList.get(t).getValue(AssetList.get(t).getAssetCode())));
						    System.out.println("Return Rate :"+DoubleFormat.format((AssetList.get(t).getReturnRate(AssetList.get(t).getAssetCode())*100))+"%");	
						    System.out.println();
						    System.out.println("---------------------------------------------------------------------------------------------------------------------");
						    System.out.println();  
						    //these are here to add the annual return of the asset to the sums for the portfolio, and for the total sum for all portfolios
						   //increment a
						    a++;
						}
			//increment t			
			t++;
			}
			//these are the summative informations for each portfolio, using the same method as above of using implemented getter methods from portfolio for our data, and also using our formatters
			System.out.println("SUMMATIVE FINANCIAL INFORMATION FOR PORTFOLIO "+PortfolioList.get(g).getPortfolioCode()+" #"+(g+1)+"/"+PortfolioList.size());
			System.out.println("Total Value :$"+DoubleFormat.format(+PortfolioList.get(g).getTotalValue()));
			//adds total value of current portfolio to the sum of total values for all portfolios
			TotalValueSum+=PortfolioList.get(g).getTotalValue();
			System.out.println("Aggregate Risk :"+RiskFormat.format(PortfolioList.get(g).getAggRisk()));
			System.out.println("Total Fees :$"+DoubleFormat.format(PortfolioList.get(g).getFees()));
			//adds the fees of current portfolio to the sum of fees for all portfolios
			FeesSum+=PortfolioList.get(g).getFees();
			System.out.println("Commissions :$"+DoubleFormat.format(PortfolioList.get(g).getCommissions()));
			//adds the commissions of current portfolio to the sum of commissions for all portfolios
			CommissionsSum+=PortfolioList.get(g).getCommissions();
			System.out.println("Portfolio Sum of Annual Returns :$"+DoubleFormat.format(PortfolioList.get(g).getAnnualReturnSum()));
			AnnualReturnSum += PortfolioList.get(g).getAnnualReturnSum();
			System.out.println("Value of Portfolio after Commissions and fees: $"+DoubleFormat.format(PortfolioList.get(g).getTotalValue()-PortfolioList.get(g).getFees()-PortfolioList.get(g).getCommissions()));
			System.out.println();
			System.out.println("END OF PORTFOLIO #"+(g+1)+"/"+PortfolioList.size());
			System.out.println("=======================================================================================================================");
			System.out.println("");
			g++;
		}
		//now that we have gone through all of our portfolios, we list off our total summative data for all portfolios
		System.out.println("ALL "+PortfolioList.size()+" PORTFOLIOS READ");
		System.out.println();
		System.out.println("SUMS OF PORTFOLIO VALUES");
		System.out.println();
		System.out.println("Sum of All Portfolio Total Asset Values :$"+DoubleFormat.format(TotalValueSum));		
		System.out.println("Sum of All Portfolio Annual Returns :$"+DoubleFormat.format(AnnualReturnSum));
		System.out.println("Sum of All Portfolio Commissions :$"+DoubleFormat.format(CommissionsSum));
		System.out.println("Sum of All Portfolio Fees :$"+DoubleFormat.format(FeesSum));
		System.out.println();
		System.out.println("##########################################################################################################################");			
	}
}
//TODO: ADD NOTES