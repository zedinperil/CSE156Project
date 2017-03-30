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
public class InputOutput {
	
	public static void main(String[] args) throws IOException {			
		//formatting for doubles
		DecimalFormat DoubleFormat = new DecimalFormat();
		DoubleFormat.setMaximumFractionDigits(2);
		DoubleFormat.setMinimumFractionDigits(2);
		//format just for the risks
		DecimalFormat RiskFormat = new DecimalFormat();
		RiskFormat.setMaximumFractionDigits(4);
		RiskFormat.setMinimumFractionDigits(4);
		

		List<Persons> PersonsList= new ArrayList<Persons>();
		List<Assets> AssetsList= new ArrayList<Assets>();
		List<Portfolio> PortfolioList= new ArrayList<Portfolio>();

		//revamp this to use list increments using the database information.
		for(Portfolio Portfolios : PortfolioList){
				
					if(PortfolioHasBeneficiary[g]){
//						System.out.println("CHECK1");
						if(NumberOfDelims[i][g]==5){
//							System.out.println("CHECK2");
							PortfolioList[g]=new Portfolio(DelimeteredData[i][g][0], DelimeteredData[i][g][1], DelimeteredData[i][g][2], DelimeteredData[i][g][3], DelimeteredData[i][g][4], PersonArray, AssetsList, Personcount, Assetscount);
						}
						else if(NumberOfDelims[i][g]==4){
//							System.out.println("CHECK3");
							PortfolioList[g]=new Portfolio(DelimeteredData[i][g][0], DelimeteredData[i][g][1], DelimeteredData[i][g][2], "none", DelimeteredData[i][g][3], PersonArray, AssetsList, Personcount, Assetscount);	
						}
						else{
//							System.out.println("CHECK4");
							PortfolioList[g]=new Portfolio(DelimeteredData[i][g][0], DelimeteredData[i][g][1], DelimeteredData[i][g][2], "none", HasNoData, PersonArray, AssetsList, Personcount, Assetscount);
						}
					}
					else{
//						System.out.println("CHECK5");
						if(NumberOfDelims[i][g]==5){
//							System.out.println("CHECK6");
							PortfolioList[g]=new Portfolio(DelimeteredData[i][g][0], DelimeteredData[i][g][1], DelimeteredData[i][g][2], DelimeteredData[i][g][3], DelimeteredData[i][g][4], PersonArray, AssetsList, Personcount, Assetscount);
						}
						else if(NumberOfDelims[i][g]==4){
//							System.out.println("CHECK7");
							PortfolioList[g]=new Portfolio(DelimeteredData[i][g][0], DelimeteredData[i][g][1], DelimeteredData[i][g][2], DelimeteredData[i][g][3], HasNoData,PersonArray, AssetsList, Personcount, Assetscount);	
						}
						else{
//							System.out.println("CHECK8");
							PortfolioList[g]=new Portfolio(DelimeteredData[i][g][0], DelimeteredData[i][g][1], DelimeteredData[i][g][2], "none", HasNoData, PersonArray, AssetsList, Personcount, Assetscount);
						}
					}
				}
	}
				//Same as above, but for persons. Additionally, we use methods from javax.json library to produce json objects for each person
					for(Persons Person: PersonsList){
						Personcount++;
						if(DelimeteredData[i][g][1].equals("")){
							if(NumberOfDelims[i][g]==5){	
								PersonArray[g]= new Beneficiaries(DelimeteredData[i][g][0],  DelimeteredData[i][g][2], DelimeteredData[i][g][3], DelimeteredData[i][g][4]);							
							}
							else{
								PersonArray[g]= new Beneficiaries(DelimeteredData[i][g][0],  DelimeteredData[i][g][2], DelimeteredData[i][g][3], HasNoData);
							}

						}
					}
					//Same as above, but for assets. We also use data that has been delimetered to determine the type of asset which we create, assets being an abstract class, just as person.
					
					for( Assets Asset: AssetsList){
						Assetscount++;
						if(Asset.Type.equals("D")){
							AssetsList[g]= new Deposit(DelimeteredData[i][g][0], DelimeteredData[i][g][1],DelimeteredData[i][g][2], DelimeteredData[i][g][3]);				
							

						}
						else if(DelimeteredData[i][g][1].contains("S")){
							AssetsList[g]= new Stock(DelimeteredData[i][g][0], DelimeteredData[i][g][1], DelimeteredData[i][g][2], DelimeteredData[i][g][3], DelimeteredData[i][g][4], DelimeteredData[i][g][5], DelimeteredData[i][g][6], DelimeteredData[i][g][7]);
							

						}
						else if(DelimeteredData[i][g][1].contains("P")){
							AssetsList[g]= new PrivateInvestment(DelimeteredData[i][g][0], DelimeteredData[i][g][1], DelimeteredData[i][g][2], DelimeteredData[i][g][3], DelimeteredData[i][g][4], DelimeteredData[i][g][5], DelimeteredData[i][g][6]);
							//TODO: fix this for assets

						}
					}			
					
			
		
		  //Takes our formatted console output and saves it as a portfolio.txt file
		double[] PortfolioAnnualReturnSum= new double[PortfolioList.size()];
 
		PrintStream portfolio = new PrintStream(new FileOutputStream("data/output.txt"));
		System.setOut(portfolio);
		System.out.println("##########################################################################################################################");
		System.out.println();
		System.out.println("A Collection of "+PortfolioList.size()+" Portfolios");
		System.out.println("# Of Persons from the Persons Datafile :"+NumberOfLines[0]);
		System.out.println("# Of Assets from the Assets Datafile :"+NumberOfLines[1]);
		System.out.println();
		System.out.println("==========================================================================================================================");
		System.out.println();
		for(g=0; g<PortfolioList.size(); g++){
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
			System.out.println("Assets List And Modifier Variables :"+PortfolioList[g].getAsset());
			System.out.println("# Of Assets within the Portfolio :"+PortfolioList[g].getOccuranceOfAssetCount());
			System.out.println();
			System.out.println("FINANCIAL INFORMATION");
			System.out.println();
			System.out.println("Individual Asset Information:");
			System.out.println();
			System.out.println("---------------------------------------------------------------------------------------------------------------------");
			System.out.println();
			int q=0;
			for(int u=0; u<PortfolioList[g].getOccuranceOfAssetCount(); u++){
					System.out.println("Asset #"+(u+1)+"/"+PortfolioList[g].getOccuranceOfAssetCount() +" Of Portfolio "+PortfolioList[g].getPortfolioCode()+" #"+(g+1)+"/"+PortfolioList.size() );
					System.out.println("Asset Code :"+PortfolioList[g].getAssetName(u));
					q=0;
					while(q<PortfolioList[g].getAssetcount()){
						if(PortfolioList[g].getAssetName(u).equals(AssetsList[q].getCode())){
							System.out.println("Asset Name :"+ AssetsList[q].getLabel());
							System.out.println("Asset Type :"+ AssetsList[q].getType());
							q++;
						}
						else{
							q++;
						}
					}
					System.out.println("Asset Value Modifier :"+PortfolioList[g].getAssetValue(u));
					q=0;
					while(q<PortfolioList[g].getAssetcount()){
						if(PortfolioList[g].getAssetName(u).equals(AssetsList[q].getCode())){
							System.out.println("Annual Return :$"+DoubleFormat.format(PortfolioList[g].getAnnualReturn(u)));
							PortfolioAnnualReturnSum[g]+=PortfolioList[g].getAnnualReturn(u);
							AnnualReturnSum+=PortfolioList[g].getAnnualReturn(u);
							q++;
						}
						else{
							q++;
						}
					}
					System.out.println("Risk :"+DoubleFormat.format(PortfolioList[g].getRisk(u)));
					System.out.println("Value :$"+DoubleFormat.format(PortfolioList[g].getValue(u)));
					System.out.println("Return Rate :"+DoubleFormat.format((PortfolioList[g].getReturnRate()[u]*100))+"%");	
					System.out.println();
					System.out.println("---------------------------------------------------------------------------------------------------------------------");
					System.out.println();
				}
			System.out.println("SUMMATIVE FINANCIAL INFORMATION FOR PORTFOLIO "+PortfolioList[g].getPortfolioCode()+" #"+(g+1)+"/"+PortfolioList.size());
			System.out.println("Total Value :$"+DoubleFormat.format(+PortfolioList[g].getTotalValue()));
			TotalValueSum+=PortfolioList[g].getTotalValue();
			System.out.println("Aggregate Risk :"+RiskFormat.format(PortfolioList[g].getAggRisk()));
			System.out.println("Total Fees :$"+DoubleFormat.format(PortfolioList[g].getFees()));
			FeesSum+=PortfolioList[g].getFees();
			System.out.println("Commissions :$"+DoubleFormat.format(PortfolioList[g].getCommissions()));
			CommissionsSum+=PortfolioList[g].getCommissions()/2;
			System.out.println("Portfolio Sum of Annual Returns :$"+DoubleFormat.format(PortfolioAnnualReturnSum[g]));
			System.out.println("Value of Portfolio after Commissions and fees: $"+DoubleFormat.format(PortfolioList[g].getTotalValue()-PortfolioList[g].getFees()-PortfolioList[g].getCommissions()));
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
		portfolio.close();
	}
}
//TODO: IMPLEMENT WHAT WE NEED TO WITH THE PORTFOLIO STUFF. WE MADE GOOD PROGRESS IN MAKING OUR CODE LESS SHIT