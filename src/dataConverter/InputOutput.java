package dataConverter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
//The plan
//IMPLEMENT JDBC, CONVERT TO LISTS. ESSENTIALLY THATS WHAT WE NEED TO DO.
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

		//revamp this to use list increments using the database information.
	
		
		PortfolioList= databaseinfoandmethods.getPortfolios();
		AssetList= databaseinfoandmethods.getAssets();

		System.out.println("##########################################################################################################################");
		System.out.println();
		System.out.println("A Collection of "+PortfolioList.size()+" Portfolios");
		System.out.println();
		System.out.println("==========================================================================================================================");
		System.out.println();
		int g=0;
		double TotalValueSum;
		double FeesSum;
		double CommissionsSum;
		while( g<PortfolioList.size()){
			System.out.println("PORTFOLIO #"+(g+1)+"/"+PortfolioList.size());
			System.out.println();
			System.out.println("Portfolio Code :"+PortfolioList[g].getPortfolioCode());
			System.out.println("Owner :"+PortfolioList[g].getOwnerName());
			System.out.println("Owner Code :"+PortfolioList[g].getOwnerCode());
			System.out.println("Manager :"+PortfolioList[g].getManagerName());
			System.out.println("Manager Code :"+PortfolioList[g].getManagerCode());
			System.out.println("Beneficiary :"+PortfolioList[g].getBeneficiaryName());
			if(!(PortfolioList[g].getBeneficiaryName().equals("none"))){
				System.out.println("Beneficiary Code :"+PortfolioList[g].getBeneficiaryCode());
			}
			System.out.println("# Of Asset within the Portfolio :"+PortfolioList[g].getOccuranceOfAssetCount());
			System.out.println();
			System.out.println("FINANCIAL INFORMATION");
			System.out.println();
			System.out.println("Individual Asset Information:");
			System.out.println();
			System.out.println("---------------------------------------------------------------------------------------------------------------------");
			System.out.println();
			int q=0;
			for(int u=0; u<PortfolioList.size(); u++){
					
					System.out.println("Asset Code :"+PortfolioList.get(g).getAssetName(u));
					q=0;
					while(q<PortfolioList.get(g).getAssetcount()){
						if(PortfolioList.get(g).getAssetName(u).equals(AssetList.get(q).getCode())){
							System.out.println("Asset Name :"+ AssetList.get(q).getLabel());
							System.out.println("Asset Type :"+ AssetList.get(q).getType());
							q++;
						}
						else{
							q++;
						}
					}
					System.out.println("Asset Value Modifier :"+PortfolioList.get(g).getAssetValue(u));
					q=0;
					while(q<PortfolioList.get(g).getAssetcount()){
						if(PortfolioList.get(g).getAssetName(u).equals(AssetList.get(q).getCode())){
							System.out.println("Annual Return :$"+DoubleFormat.format(PortfolioList.get(g).getAnnualReturn(u)));
							PortfolioAnnualReturnSum[g]+=PortfolioList.get(g).getAnnualReturn(u);
							AnnualReturnSum+=PortfolioList.get(g).getAnnualReturn(u);
							q++;
						}
						else{
							q++;
						}
					}
					System.out.println("Risk :"+DoubleFormat.format(PortfolioList.get(g).getRisk(u)));
					System.out.println("Value :$"+DoubleFormat.format(PortfolioList.get(g).getValue(u)));
					System.out.println("Return Rate :"+DoubleFormat.format((PortfolioList.get(g).getReturnRate()*100))+"%");	
					System.out.println();
					System.out.println("---------------------------------------------------------------------------------------------------------------------");
					System.out.println();
				}
			System.out.println("SUMMATIVE FINANCIAL INFORMATION FOR PORTFOLIO "+PortfolioList.get(g).getPortfolioCode()+" #"+(g+1)+"/"+PortfolioList.size());
			System.out.println("Total Value :$"+DoubleFormat.format(+PortfolioList.get(g).getTotalValue()));
			TotalValueSum+=PortfolioList.get(g).getTotalValue();
			System.out.println("Aggregate Risk :"+RiskFormat.format(PortfolioList.get(g).getAggRisk()));
			System.out.println("Total Fees :$"+DoubleFormat.format(PortfolioList.get(g).getFees()));
			FeesSum+=PortfolioList.get(g).getFees();
			System.out.println("Commissions :$"+DoubleFormat.format(PortfolioList.get(g).getCommissions()));
			CommissionsSum+=PortfolioList.get(g).getCommissions()/2;
			System.out.println("Portfolio Sum of Annual Returns :$"+DoubleFormat.format(PortfolioAnnualReturnSum[g]));
			System.out.println("Value of Portfolio after Commissions and fees: $"+DoubleFormat.format(PortfolioList.get(g).getTotalValue()-PortfolioList.get(g).getFees()-PortfolioList.get(g).getCommissions()));
			System.out.println();
			System.out.println("END OF PORTFOLIO #"+(g+1)+"/"+PortfolioList.size());
			System.out.println("=======================================================================================================================");
			System.out.println("");
		}
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
			g++;
	}
}
//TODO: IMPLEMENT WHAT WE NEED TO WITH THE PORTFOLIO STUFF. WE MADE GOOD PROGRESS IN MAKING OUR CODE LESS SHIT