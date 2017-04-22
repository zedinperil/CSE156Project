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
		List<Portfolio> PortfolioList= new ArrayList<Portfolio>();
		List<List<Portfolio>> PortfolioListList= new ArrayList<List<Portfolio>>();
		//create two array lists, one of portfolios and one of assets, calling methods in our interface class
		PortfolioListList= databaseinfoandmethods.getPortfolios();
		for(int i=0; i<PortfolioListList.size(); i++){
		
			if(i==0){
				//print formatted data. Many of the lines are formatting to make it look pretty.
				System.out.println("##########################################################################################################################");
				System.out.println();
				System.out.println("A Collection of "+PortfolioListList.get(i).size()+" Portfolios, sorted by Owner First Name");
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
				while( g<PortfolioListList.get(i).size()){
					//this little for loop is used to determine how many assets are within each portfolio, by checking the number of times in our asset arraylist has the same portfolio code as the current portfolio, and incrementing

					//printing relevant info we have retrieved from our database, formatted just the same as in phase 3 of our project
					//for retreiving information from our arraylists, we use the getter methods we have implemented into the relevant classes
					System.out.println("PORTFOLIO #"+(g+1)+"/"+PortfolioListList.get(i).size());
					System.out.println();
					System.out.println("Portfolio Code :"+PortfolioListList.get(i).get(g).getPortfolioCode());
					System.out.println("Owner :"+PortfolioListList.get(i).get(g).getOwnerFirstName()+" "+PortfolioListList.get(i).get(g).getOwnerLastName());
					System.out.println("Owner Code :"+PortfolioListList.get(i).get(g).getOwnerCode());
					System.out.println("Manager :"+PortfolioListList.get(i).get(g).getManagerFirstName()+" "+PortfolioListList.get(i).get(g).getManagerLastName());
					System.out.println("Manager Code :"+PortfolioListList.get(i).get(g).getManagerCode());
					System.out.println("Beneficiary :"+PortfolioListList.get(i).get(g).getBeneficiaryName());
					System.out.println("Beneficiary Code :"+PortfolioListList.get(i).get(g).getBeneficiaryCode());
					System.out.print("Owner Emails: ");
					List<String>ownersEmails= PortfolioListList.get(i).get(g).owner.getEmails(PortfolioListList.get(i).get(g).getOwnerCode());
					for(int y=0; y<ownersEmails.size(); y++){
						System.out.print(ownersEmails.get(y)+" ");
					}
	
					//these are the summative informations for each portfolio, using the same method as above of using implemented getter methods from portfolio for our data, and also using our formatters
					System.out.println("SUMMATIVE FINANCIAL INFORMATION FOR PORTFOLIO "+PortfolioListList.get(i).get(g).getPortfolioCode()+" #"+(g+1)+"/"+PortfolioList.size());
					System.out.println("Total Value :$"+DoubleFormat.format(+PortfolioListList.get(i).get(g).getTotalValue()));
					//adds total value of current portfolio to the sum of total values for all portfolios
					TotalValueSum+=PortfolioListList.get(i).get(g).getTotalValue();
					System.out.println("Aggregate Risk :"+RiskFormat.format(PortfolioListList.get(i).get(g).getAggRisk()));
					System.out.println("Total Fees :$"+DoubleFormat.format(PortfolioListList.get(i).get(g).getFees()));
					//adds the fees of current portfolio to the sum of fees for all portfolios
					FeesSum+=PortfolioListList.get(i).get(g).getFees();
					System.out.println("Commissions :$"+DoubleFormat.format(PortfolioListList.get(i).get(g).getCommissions()));
					//adds the commissions of current portfolio to the sum of commissions for all portfolios
					CommissionsSum+=PortfolioListList.get(i).get(g).getCommissions();
					System.out.println("Portfolio Sum of Annual Returns :$"+DoubleFormat.format(PortfolioListList.get(i).get(g).getAnnualReturnSum()));
					AnnualReturnSum += PortfolioListList.get(i).get(g).getAnnualReturnSum();
					System.out.println("Value of Portfolio after Commissions and fees: $"+DoubleFormat.format(PortfolioListList.get(i).get(g).getTotalValue()-PortfolioListList.get(i).get(g).getFees()-PortfolioListList.get(i).get(g).getCommissions()));
					System.out.println();
					System.out.println("END OF PORTFOLIO #"+(g+1)+"/"+PortfolioList.size());
					System.out.println("=======================================================================================================================");
					System.out.println("");
					g++;
				}
				//now that we have gone through all of our portfolios, we list off our total summative data for all portfolios
				System.out.println("ALL "+PortfolioListList.get(i).size()+" PORTFOLIOS READ");
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
			if(i==1){
				//print formatted data. Many of the lines are formatting to make it look pretty.
				System.out.println("##########################################################################################################################");
				System.out.println();
				System.out.println("A Collection of "+PortfolioListList.get(i).size()+" Portfolios, Sorted by Manager Type, and then by Manager Name");
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
				while( g<PortfolioListList.get(i).size()){
					//this little for loop is used to determine how many assets are within each portfolio, by checking the number of times in our asset arraylist has the same portfolio code as the current portfolio, and incrementing
				
					//printing relevant info we have retrieved from our database, formatted just the same as in phase 3 of our project
					//for retreiving information from our arraylists, we use the getter methods we have implemented into the relevant classes
					System.out.println("PORTFOLIO #"+(g+1)+"/"+PortfolioListList.get(i).size());
					System.out.println();
					System.out.println("Portfolio Code :"+PortfolioListList.get(i).get(g).getPortfolioCode());
					System.out.println("Owner :"+PortfolioListList.get(i).get(g).getOwnerFirstName()+" "+PortfolioListList.get(i).get(g).getOwnerLastName());
					System.out.println("Owner Code :"+PortfolioListList.get(i).get(g).getOwnerCode());
					System.out.println("Manager :"+PortfolioListList.get(i).get(g).getManagerFirstName()+" "+PortfolioListList.get(i).get(g).getManagerLastName());
					System.out.println("Manager Code :"+PortfolioListList.get(i).get(g).getManagerCode());
					System.out.println("Beneficiary :"+PortfolioListList.get(i).get(g).getBeneficiaryName());
					System.out.println("Beneficiary Code :"+PortfolioListList.get(i).get(g).getBeneficiaryCode());
					System.out.print("Owner Emails: ");
					List<String>ownersEmails= PortfolioListList.get(i).get(g).owner.getEmails(PortfolioListList.get(i).get(g).getOwnerCode());
					for(int y=0; y<ownersEmails.size(); y++){
						System.out.print(ownersEmails.get(y)+" ");
					}
			
					//these are the summative informations for each portfolio, using the same method as above of using implemented getter methods from portfolio for our data, and also using our formatters
					System.out.println("SUMMATIVE FINANCIAL INFORMATION FOR PORTFOLIO "+PortfolioListList.get(i).get(g).getPortfolioCode()+" #"+(g+1)+"/"+PortfolioList.size());
					System.out.println("Total Value :$"+DoubleFormat.format(+PortfolioListList.get(i).get(g).getTotalValue()));
					//adds total value of current portfolio to the sum of total values for all portfolios
					TotalValueSum+=PortfolioListList.get(i).get(g).getTotalValue();
					System.out.println("Aggregate Risk :"+RiskFormat.format(PortfolioListList.get(i).get(g).getAggRisk()));
					System.out.println("Total Fees :$"+DoubleFormat.format(PortfolioListList.get(i).get(g).getFees()));
					//adds the fees of current portfolio to the sum of fees for all portfolios
					FeesSum+=PortfolioListList.get(i).get(g).getFees();
					System.out.println("Commissions :$"+DoubleFormat.format(PortfolioListList.get(i).get(g).getCommissions()));
					//adds the commissions of current portfolio to the sum of commissions for all portfolios
					CommissionsSum+=PortfolioListList.get(i).get(g).getCommissions();
					System.out.println("Portfolio Sum of Annual Returns :$"+DoubleFormat.format(PortfolioListList.get(i).get(g).getAnnualReturnSum()));
					AnnualReturnSum += PortfolioListList.get(i).get(g).getAnnualReturnSum();
					System.out.println("Value of Portfolio after Commissions and fees: $"+DoubleFormat.format(PortfolioListList.get(i).get(g).getTotalValue()-PortfolioListList.get(i).get(g).getFees()-PortfolioListList.get(i).get(g).getCommissions()));
					System.out.println();
					System.out.println("END OF PORTFOLIO #"+(g+1)+"/"+PortfolioListList.get(i).size());
					System.out.println("=======================================================================================================================");
					System.out.println("");
					g++;
				}
				//now that we have gone through all of our portfolios, we list off our total summative data for all portfolios
				System.out.println("ALL "+PortfolioListList.get(i).size()+" PORTFOLIOS READ");
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
			if(i==2){
				//print formatted data. Many of the lines are formatting to make it look pretty.
				System.out.println("##########################################################################################################################");
				System.out.println();
				System.out.println("A Collection of "+PortfolioListList.get(i).size()+" Portfolios, sorted by Total Value");
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
				while( g<PortfolioListList.get(i).size()){
					//this little for loop is used to determine how many assets are within each portfolio, by checking the number of times in our asset arraylist has the same portfolio code as the current portfolio, and incrementing
			
					//printing relevant info we have retrieved from our database, formatted just the same as in phase 3 of our project
					//for retreiving information from our arraylists, we use the getter methods we have implemented into the relevant classes
					System.out.println("PORTFOLIO #"+(g+1)+"/"+PortfolioListList.get(i).size());
					System.out.println();
					System.out.println("Portfolio Code :"+PortfolioListList.get(i).get(g).getPortfolioCode());
					System.out.println("Owner :"+PortfolioListList.get(i).get(g).getOwnerFirstName()+" "+PortfolioListList.get(i).get(g).getOwnerLastName());
					System.out.println("Owner Code :"+PortfolioListList.get(i).get(g).getOwnerCode());
					System.out.println("Manager :"+PortfolioListList.get(i).get(g).getManagerFirstName()+" "+PortfolioListList.get(i).get(g).getManagerLastName());
					System.out.println("Manager Code :"+PortfolioListList.get(i).get(g).getManagerCode());
					System.out.println("Beneficiary :"+PortfolioListList.get(i).get(g).getBeneficiaryName());
					System.out.println("Beneficiary Code :"+PortfolioListList.get(i).get(g).getBeneficiaryCode());
					System.out.print("Owner Emails: ");
					List<String>ownersEmails= PortfolioListList.get(i).get(g).owner.getEmails(PortfolioListList.get(i).get(g).getOwnerCode());
					for(int y=0; y<ownersEmails.size(); y++){
						System.out.print(ownersEmails.get(y)+" ");
					}
	
					//these are the summative informations for each portfolio, using the same method as above of using implemented getter methods from portfolio for our data, and also using our formatters
					System.out.println("SUMMATIVE FINANCIAL INFORMATION FOR PORTFOLIO "+PortfolioListList.get(i).get(g).getPortfolioCode()+" #"+(g+1)+"/"+PortfolioList.size());
					System.out.println("Total Value :$"+DoubleFormat.format(+PortfolioListList.get(i).get(g).getTotalValue()));
					//adds total value of current portfolio to the sum of total values for all portfolios
					TotalValueSum+=PortfolioListList.get(i).get(g).getTotalValue();
					System.out.println("Aggregate Risk :"+RiskFormat.format(PortfolioListList.get(i).get(g).getAggRisk()));
					System.out.println("Total Fees :$"+DoubleFormat.format(PortfolioListList.get(i).get(g).getFees()));
					//adds the fees of current portfolio to the sum of fees for all portfolios
					FeesSum+=PortfolioListList.get(i).get(g).getFees();
					System.out.println("Commissions :$"+DoubleFormat.format(PortfolioListList.get(i).get(g).getCommissions()));
					//adds the commissions of current portfolio to the sum of commissions for all portfolios
					CommissionsSum+=PortfolioListList.get(i).get(g).getCommissions();
					System.out.println("Portfolio Sum of Annual Returns :$"+DoubleFormat.format(PortfolioListList.get(i).get(g).getAnnualReturnSum()));
					AnnualReturnSum += PortfolioListList.get(i).get(g).getAnnualReturnSum();
					System.out.println("Value of Portfolio after Commissions and fees: $"+DoubleFormat.format(PortfolioListList.get(i).get(g).getTotalValue()-PortfolioListList.get(i).get(g).getFees()-PortfolioListList.get(i).get(g).getCommissions()));
					System.out.println();
					System.out.println("END OF PORTFOLIO #"+(g+1)+"/"+PortfolioListList.get(i).size());
					System.out.println("=======================================================================================================================");
					System.out.println("");
					g++;
				}
				//now that we have gone through all of our portfolios, we list off our total summative data for all portfolios
				System.out.println("ALL "+PortfolioListList.get(i).size()+" PORTFOLIOS READ");
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
			
	}
}
//TODO: ADD NOTES