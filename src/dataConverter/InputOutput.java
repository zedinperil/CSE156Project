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
		int portfolioCount;
		int assetCount;
		
		PortfolioList= databaseinfoandmethods.getPortfolios();
		AssetList= databaseinfoandmethods.getAssets();
//		
//		
//
//			
//		
//		  //Takes our formatted console output and saves it as a portfolio.txt file
//		double[] PortfolioAnnualReturnSum= new double[PortfolioList.size()];
// 
//		PrintStream portfolio = new PrintStream(new FileOutputStream("data/output.txt"));
//		System.setOut(portfolio);
//		System.out.println("##########################################################################################################################");
//		System.out.println();
//		System.out.println("A Collection of "+PortfolioList.size()+" Portfolios");
//		System.out.println("# Of Persons from the Persons Datafile :"+NumberOfLines[0]);
//		System.out.println("# Of Asset from the Asset Datafile :"+NumberOfLines[1]);
//		System.out.println();
//		System.out.println("==========================================================================================================================");
//		System.out.println();
//		for(g=0; g<PortfolioList.size(); g++){
//			System.out.println("PORTFOLIO #"+(g+1)+"/"+PortfolioList.size());
//			System.out.println();
//			System.out.println("Portfolio Code :"+PortfolioList[g].getPortfolioCode());
//			System.out.println("Owner :"+PortfolioList[g].getOwnerName());
//			System.out.println("Owner Code :"+PortfolioList[g].getOwnerCode());
//			System.out.println("Manager :"+PortfolioList[g].getManagerName());
//			System.out.println("Manager Code :"+PortfolioList[g].getManagerCode());
//			System.out.println("Beneficiary :"+PortfolioList[g].getBeneficiaryName());
//			if(!(PortfolioList[g].getBeneficiaryName().equals("none"))){
//				System.out.println("Beneficiary Code :"+PortfolioList[g].getBeneficiaryCode());
//			}
//			System.out.println("# Of Asset within the Portfolio :"+PortfolioList[g].getOccuranceOfAssetCount());
//			System.out.println();
//			System.out.println("FINANCIAL INFORMATION");
//			System.out.println();
//			System.out.println("Individual Asset Information:");
//			System.out.println();
//			System.out.println("---------------------------------------------------------------------------------------------------------------------");
//			System.out.println();
//			int q=0;
//			for(int u=0; u<PortfolioList[g].getOccuranceOfAssetCount(); u++){
//					
//					System.out.println("Asset Code :"+PortfolioList[g].getAssetName(u));
//					q=0;
//					while(q<PortfolioList[g].getAssetcount()){
//						if(PortfolioList[g].getAssetName(u).equals(AssetList[q].getCode())){
//							System.out.println("Asset Name :"+ AssetList[q].getLabel());
//							System.out.println("Asset Type :"+ AssetList[q].getType());
//							q++;
//						}
//						else{
//							q++;
//						}
//					}
//					System.out.println("Asset Value Modifier :"+PortfolioList[g].getAssetValue(u));
//					q=0;
//					while(q<PortfolioList[g].getAssetcount()){
//						if(PortfolioList[g].getAssetName(u).equals(AssetList[q].getCode())){
//							System.out.println("Annual Return :$"+DoubleFormat.format(PortfolioList[g].getAnnualReturn(u)));
//							PortfolioAnnualReturnSum[g]+=PortfolioList[g].getAnnualReturn(u);
//							AnnualReturnSum+=PortfolioList[g].getAnnualReturn(u);
//							q++;
//						}
//						else{
//							q++;
//						}
//					}
//					System.out.println("Risk :"+DoubleFormat.format(PortfolioList[g].getRisk(u)));
//					System.out.println("Value :$"+DoubleFormat.format(PortfolioList[g].getValue(u)));
//					System.out.println("Return Rate :"+DoubleFormat.format((PortfolioList[g].getReturnRate()[u]*100))+"%");	
//					System.out.println();
//					System.out.println("---------------------------------------------------------------------------------------------------------------------");
//					System.out.println();
//				}
//			System.out.println("SUMMATIVE FINANCIAL INFORMATION FOR PORTFOLIO "+PortfolioList[g].getPortfolioCode()+" #"+(g+1)+"/"+PortfolioList.size());
//			System.out.println("Total Value :$"+DoubleFormat.format(+PortfolioList[g].getTotalValue()));
//			TotalValueSum+=PortfolioList[g].getTotalValue();
//			System.out.println("Aggregate Risk :"+RiskFormat.format(PortfolioList[g].getAggRisk()));
//			System.out.println("Total Fees :$"+DoubleFormat.format(PortfolioList[g].getFees()));
//			FeesSum+=PortfolioList[g].getFees();
//			System.out.println("Commissions :$"+DoubleFormat.format(PortfolioList[g].getCommissions()));
//			CommissionsSum+=PortfolioList[g].getCommissions()/2;
//			System.out.println("Portfolio Sum of Annual Returns :$"+DoubleFormat.format(PortfolioAnnualReturnSum[g]));
//			System.out.println("Value of Portfolio after Commissions and fees: $"+DoubleFormat.format(PortfolioList[g].getTotalValue()-PortfolioList[g].getFees()-PortfolioList[g].getCommissions()));
//			System.out.println();
//			System.out.println("END OF PORTFOLIO #"+(g+1)+"/"+PortfolioList.size());
//			System.out.println("=======================================================================================================================");
//			System.out.println("");
//		}
//		System.out.println("ALL "+PortfolioList.size()+" PORTFOLIOS READ");
//		System.out.println();
//		System.out.println("SUMS OF PORTFOLIO VALUES");
//		System.out.println();
//		System.out.println("Sum of All Portfolio Total Asset Values :$"+DoubleFormat.format(TotalValueSum));
//		System.out.println("Sum of All Portfolio Annual Returns :$"+DoubleFormat.format(AnnualReturnSum));
//		System.out.println("Sum of All Portfolio Commissions :$"+DoubleFormat.format(CommissionsSum));
//		System.out.println("Sum of All Portfolio Fees :$"+DoubleFormat.format(FeesSum));
//		System.out.println();
//		System.out.println("##########################################################################################################################");
//		portfolio.close();
	}
}
//TODO: IMPLEMENT WHAT WE NEED TO WITH THE PORTFOLIO STUFF. WE MADE GOOD PROGRESS IN MAKING OUR CODE LESS SHIT