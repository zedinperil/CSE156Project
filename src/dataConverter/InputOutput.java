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
	
	private static final double[] AnnualReturnSum = null;

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
		double TotalValueSum = 0;
		double FeesSum = 0;
		double CommissionsSum = 0;
		double AnnualReturnSum=0;
		double[] PortfolioAnnualReturnSum= new double[PortfolioList.size()];

		while( g<PortfolioList.size()){
			System.out.println("PORTFOLIO #"+(g+1)+"/"+PortfolioList.size());
			System.out.println();
			System.out.println("Portfolio Code :"+PortfolioList.get(g).getPortfolioCode());
			System.out.println("Owner :"+PortfolioList.get(g).getOwnerName());
			System.out.println("Owner Code :"+PortfolioList.get(g).getOwnerCode());
			System.out.println("Manager :"+PortfolioList.get(g).getManagerName());
			System.out.println("Manager Code :"+PortfolioList.get(g).getManagerCode());
			System.out.println("Beneficiary :"+PortfolioList.get(g).getBeneficiaryName());
			if(!(PortfolioList.get(g).getBeneficiaryName().equals("none"))){
				System.out.println("Beneficiary Code :"+PortfolioList.get(g).getBeneficiaryCode());
			}
			int NumOfAssetInPortfolio=0;
			for(int q=0; q<AssetList.size(); q++){
				if(AssetList.get(q).getPortfolioCode().equals(PortfolioList.get(g).getPortfolioCode())){
					NumOfAssetInPortfolio++;
				}
			}
			
			
			System.out.println("# Of Asset within the Portfolio :"+NumOfAssetInPortfolio);
			System.out.println();
			System.out.println("FINANCIAL INFORMATION");
			System.out.println();
			System.out.println("Individual Asset Information:");
			System.out.println();
			System.out.println("---------------------------------------------------------------------------------------------------------------------");
			System.out.println();
			int t=0;
		//need to get: Asset Code, Asset Name, Asset Type, Asset Value Modifier, Annual return, risk, value, and return rate for each asset for the given portfolio Also calculate the stuff you need to
			int a=0;
			while(t<AssetList.size()){
						if(AssetList.get(t).getPortfolioCode().equals(PortfolioList.get(g).getPortfolioCode())){
							System.out.println("Asset #"+(a+1)+"/"+AssetList.size());

							System.out.println("Asset Code :"+AssetList.get(t).getAssetCode());
							System.out.println("Asset Name :"+ AssetList.get(t).getAssetName());
							System.out.println("Asset Type :"+ AssetList.get(t).getAssetType());
							System.out.println("Asset Value Modifier :"+AssetList.get(t).getAssetValue());				
							System.out.println("Annual Return :$"+DoubleFormat.format(AssetList.get(t).getAnnualReturn()));
							PortfolioAnnualReturnSum[g]+=AssetList.get(t).getAnnualReturn();
						    AnnualReturnSum+= AssetList.get(t).getAnnualReturn();
						    System.out.println("Risk :"+DoubleFormat.format(AssetList.get(t).getRisk()));
						    System.out.println("Value :$"+DoubleFormat.format(AssetList.get(t).getAssetValue()));
						    System.out.println("Return Rate :"+DoubleFormat.format((AssetList.get(t).getReturnRate()*100))+"%");	
						    System.out.println();
						    System.out.println("---------------------------------------------------------------------------------------------------------------------");
						    System.out.println();  
						    a++;
						}
			t++;
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
			g++;
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
			
	}
}
//TODO: IMPLEMENT WHAT WE NEED TO WITH THE PORTFOLIO STUFF. WE MADE GOOD PROGRESS IN MAKING OUR CODE LESS SHIT