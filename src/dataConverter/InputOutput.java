package dataConverter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.BufferedReader;
import javax.json.*;
import javax.json.stream.JsonGenerator;
//The plan
//Start with grabbing the file and making classes
//You have Persons and Assets
//Which are further broken down into their own subclasses
//So we bring the file in here
//BIG NOTE: We should have used array lists. We are simply stubborn to switch from arrays
public class InputOutput {
	

	public static void main(String[] args) throws IOException {			
		//ints for further use
		int NumOfFiles= 3;
		int i=0;
		int g=0;
		int x=0;
		//booleans to keep track if file is person or assett
		boolean[] IsPerson=new boolean[NumOfFiles];
		boolean[] IsAsset=new boolean[NumOfFiles];
		boolean[] IsPortfolio=new boolean[NumOfFiles];
	
		String[] fileName = new String[3];
		//the filenames
		fileName[0]= "data/Persons.dat";
		fileName[1]= "data/Assets.dat";
		fileName[2]= "data/Portfolios.dat";
		for(i=0; i<NumOfFiles; i++){
			//checks if file is a person or an asset
			if(fileName[i].contains("Portfolios")||fileName[i].contains("portfolios")){
			IsPortfolio[i]=true;	
			}
			else if(fileName[i].contains("Persons")||fileName[i].contains("persons")){
			IsPerson[i]=true;
			}
			else if(fileName[i].contains("Assets")||fileName[i].contains("assets")){
			IsAsset[i]=true;	
			}
			else{
			System.out.println("WRONG TYPE OF FILE");
			}
		}
		//variables/arrays for storing purposes
		//
		int[] size= new int[NumOfFiles];
		int NumberOfLines[]= new int[NumOfFiles];
		int[] NumOfChars= new int[10000];
		for(i=0; i<NumOfFiles; i++){
			//gets the size of the file, we don't want to store it with the data
			BufferedReader Buff = new BufferedReader(new FileReader(fileName[i]));
	        String text = Buff.readLine();
	        size[i] = Integer.parseInt(text);
	        size[i] += 1;

	        //close the buffer
	        Buff.close();
		}
		boolean[] PortfolioHasBeneficiary = new boolean[size[2]];
		//create a string to store every piece of data pulled in
		String fullData[][] = new String[NumOfFiles][1000];
	        Scanner s = null;
	    for(i=0; i<NumOfFiles; i++){
	    	//try catch to check there is a file
	    	try{
			s = new Scanner(new File(fileName[i]));
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
		x=0;
		//read file to the end of the line and remove the endline character
		while(s.hasNext()) {
			String line = s.nextLine(); //throw away the endline character
			fullData[i][x] = line;
			NumOfChars[x]=0;
		
			for(int q=0; q<=x; q++){	
			//this counts number of chars that are not null, to be used for later incrementing
				if(fullData[i][x].charAt(q)!='\u0000'){
					NumOfChars[x]++;	
				}
			}
			x++;//increment
		}
		NumberOfLines[i]=Integer.parseInt(fullData[i][0]);//number of lines
		s.close();//close s
			x++;	
			
		}   
	//TODO: Enumerate person and assets classes, and create arrays for each.
		//DONE ELSEWHERE
		String DelimeteredData[][][]= new String[4][1000][100];
	//TODO: Based on what each is,  use increments to save delimetered strings into the correct spaces for whatever type the data is
    int[][] NumberOfDelims= new int[NumOfFiles][1000];
	for(i=0; i<NumOfFiles; i++){
		for( g=1; g<=NumberOfLines[i]; g++){
			for(x=0; x<=NumOfChars[g]; x++){
				//split it every time a semicolon appears, and also at the end of the line if there is no semicolon
				if(fullData[i][g].charAt(x)==';'){
					DelimeteredData[i][g-1]=fullData[i][g].split(";");	
				}
				if(x==(NumOfChars[g])-1 && fullData[i][g].lastIndexOf(";")!=NumOfChars[g]-1){
						DelimeteredData[i][g-1]=fullData[i][g].split(";");	
						if(IsPortfolio[i]){
							if(DelimeteredData[i][g-1][DelimeteredData[i][g-1].length-2].equals("")){
								PortfolioHasBeneficiary[g]=true;
							}
						}
				}	
			}
			NumberOfDelims[i][g-1]=DelimeteredData[i][g-1].length;	//this is how many delimeters we have
		}
	}
//Temp variables for persons, deposits, stocks, and privateinvestments		
		
		String HasNoData= "";//this is a string to be put in the event that a person does not have an email address.
		JsonArrayBuilder Personbuilder= Json.createArrayBuilder();
		JsonArrayBuilder Assetbuilder= Json.createArrayBuilder();
		int Personcount=0;
		int Assetscount=0;
		double FeesSum=0;
		double CommissionsSum=0;
		double TotalValueSum=0;
		double AnnualReturnSum=0;
	
		Persons[] PersonArray= new Persons[NumberOfLines[0]];
		Assets[] AssetsArray= new Assets[NumberOfLines[1]];
		Portfolio[] PortfolioArray= new Portfolio[NumberOfLines[2]];
		
		for(i=0; i<NumOfFiles; i++){
			for(g=0; g<NumberOfLines[i]; g++){
				if(IsPortfolio[i]){
					System.out.println(g+1);
					if(PortfolioHasBeneficiary[g]){
						System.out.println("CHECK1");
						if(NumberOfDelims[i][g]==5){
							System.out.println("CHECK2");

							PortfolioArray[g]=new Portfolio(DelimeteredData[i][g][0], DelimeteredData[i][g][1], DelimeteredData[i][g][2], DelimeteredData[i][g][3], DelimeteredData[i][g][4], PersonArray, AssetsArray, Personcount, Assetscount);
						}
						else if(NumberOfDelims[i][g]==4){
							System.out.println("CHECK3");

							PortfolioArray[g]=new Portfolio(DelimeteredData[i][g][0], DelimeteredData[i][g][1], DelimeteredData[i][g][2], "none", DelimeteredData[i][g][3], PersonArray, AssetsArray, Personcount, Assetscount);	
						}
						else{
							System.out.println("CHECK4");

							PortfolioArray[g]=new Portfolio(DelimeteredData[i][g][0], DelimeteredData[i][g][1], DelimeteredData[i][g][2], "none", HasNoData, PersonArray, AssetsArray, Personcount, Assetscount);
						}
					}
					else{
						System.out.println("CHECK5");

						if(NumberOfDelims[i][g]==5){
							System.out.println("CHECK6");

							PortfolioArray[g]=new Portfolio(DelimeteredData[i][g][0], DelimeteredData[i][g][1], DelimeteredData[i][g][2], DelimeteredData[i][g][3], DelimeteredData[i][g][4], PersonArray, AssetsArray, Personcount, Assetscount);
						}
						else if(NumberOfDelims[i][g]==4){
							System.out.println("CHECK7");

							PortfolioArray[g]=new Portfolio(DelimeteredData[i][g][0], DelimeteredData[i][g][1], DelimeteredData[i][g][2], DelimeteredData[i][g][3], HasNoData,PersonArray, AssetsArray, Personcount, Assetscount);	
						}
						else{
							System.out.println("CHECK8");

							PortfolioArray[g]=new Portfolio(DelimeteredData[i][g][0], DelimeteredData[i][g][1], DelimeteredData[i][g][2], "none", HasNoData, PersonArray, AssetsArray, Personcount, Assetscount);
			
						}
					}
			
				}
					if(IsPerson[i]){
						Personcount++;
						if(DelimeteredData[i][g][1].equals("")){
							if(NumberOfDelims[i][g]==5){	
								PersonArray[g]= new Beneficiaries(DelimeteredData[i][g][0],  DelimeteredData[i][g][2], DelimeteredData[i][g][3], DelimeteredData[i][g][4]);							
							}
							else{
								PersonArray[g]= new Beneficiaries(DelimeteredData[i][g][0],  DelimeteredData[i][g][2], DelimeteredData[i][g][3], HasNoData);
							}
								JsonObject tempmodel = Json.createObjectBuilder()
									   .add("code", PersonArray[g].getPersonCode())									
									   .add("firstName", PersonArray[g].getFirstName())
									   .add("lastName", PersonArray[g].getLastName())
									   .add("address", Json.createArrayBuilder()
									      .add(Json.createObjectBuilder()
									         .add("street", PersonArray[g].getStreet())
									         .add("city", PersonArray[g].getCity())
									         .add("state", PersonArray[g].getState())
									         .add("country", PersonArray[g].getCountry())
									         .add("zipcode", PersonArray[g].getZipcode())))
									   		 .add("emails", PersonArray[g].getEmail())
									   .build();
							Personbuilder.add(tempmodel);
						}
						else{
							if(NumberOfDelims[i][g]==5){	
								PersonArray[g]= new Broker(DelimeteredData[i][g][0], DelimeteredData[i][g][1], DelimeteredData[i][g][2], DelimeteredData[i][g][3], DelimeteredData[i][g][4]);							
							}
							else{
									PersonArray[g]= new Broker(DelimeteredData[i][g][0], DelimeteredData[i][g][1], DelimeteredData[i][g][2], DelimeteredData[i][g][3], HasNoData);
								}
								JsonObject tempmodel = Json.createObjectBuilder()
									   .add("code", PersonArray[g].getPersonCode())
									   .add("secIdentifier", PersonArray[g].getSecIdentifier())
									   .add("type", PersonArray[g].getType())
									   .add("firstName", PersonArray[g].getFirstName())
									   .add("lastName", PersonArray[g].getLastName())
									   .add("address", Json.createArrayBuilder()
									      .add(Json.createObjectBuilder()
									         .add("street", PersonArray[g].getStreet())
									         .add("city", PersonArray[g].getCity())
									         .add("state", PersonArray[g].getState())
									         .add("country", PersonArray[g].getCountry())
									         .add("zipcode", PersonArray[g].getZipcode())))
									   		 .add("emails", PersonArray[g].getEmail())
									   .build();
							Personbuilder.add(tempmodel);
						}
					}
				//check to see that it is an asset, and if so, check to see if the delimetered data for that asset that corresponds to type contains the character corresponding to each type of asset. Then, create a new asset of the correct type with the correct inputs for that type of asset
					if(IsAsset[i]){
						Assetscount++;
						if(DelimeteredData[i][g][1].contains("D")){
							AssetsArray[g]= new Deposit(DelimeteredData[i][g][0], DelimeteredData[i][g][1],DelimeteredData[i][g][2], DelimeteredData[i][g][3]);				
							//TODO: fix this for assets
							JsonObject tempmodel = Json.createObjectBuilder()
									   .add("code", AssetsArray[g].getCode())
									   .add("label", AssetsArray[g].getLabel())
									   .add("type", AssetsArray[g].getType())
									   .add("apr", AssetsArray[g].getApr())
									   .build();
							Assetbuilder.add(tempmodel);
						}
						else if(DelimeteredData[i][g][1].contains("S")){
							AssetsArray[g]= new Stock(DelimeteredData[i][g][0], DelimeteredData[i][g][1], DelimeteredData[i][g][2], DelimeteredData[i][g][3], DelimeteredData[i][g][4], DelimeteredData[i][g][5], DelimeteredData[i][g][6], DelimeteredData[i][g][7]);
							//TODO: fix this for assets
							JsonObject tempmodel = Json.createObjectBuilder()
									   .add("code", AssetsArray[g].getCode())
									   .add("label", AssetsArray[g].getLabel())
									   .add("type", AssetsArray[g].getType())
									   .add("baseRateOfReturn", AssetsArray[g].getBaseRateOfReturn())
									   .add("quarterlyDividend", AssetsArray[g].getQuarterlyDividend())
									   .add("sharePrice", AssetsArray[g].getSharePrice())
									   .add("symbol", AssetsArray[g].getStockSymbol())
									   .add("beta", AssetsArray[g].getBetaMeasure())
									   .build();
							Assetbuilder.add(tempmodel);
						}
						else if(DelimeteredData[i][g][1].contains("P")){
							AssetsArray[g]= new PrivateInvestment(DelimeteredData[i][g][0], DelimeteredData[i][g][1], DelimeteredData[i][g][2], DelimeteredData[i][g][3], DelimeteredData[i][g][4], DelimeteredData[i][g][5], DelimeteredData[i][g][6]);
							//TODO: fix this for assets
							JsonObject tempmodel = Json.createObjectBuilder()
									   .add("code", AssetsArray[g].getCode())
									   .add("label", AssetsArray[g].getLabel())
									   .add("type", AssetsArray[g].getType())
									   .add("baseRateOfReturn", AssetsArray[g].getBaseRateOfReturn())
									   .add("quarterlyDividend", AssetsArray[g].getQuarterlyDividend())
									   .add("omega", AssetsArray[g].getOmegaMeasure())
									   .add("value", AssetsArray[g].getTotalValue())
									   .build();
							Assetbuilder.add(tempmodel);
						}			
					}	
			}
		
//build portfolio, add to portfoliobuilder
//			JsonObject tempPort = Json.createObjectBuilder()
//					   .add("code", tempPrivateInvestment.getCode())
//					   .add("label", tempPrivateInvestment.getLabel())
//					   .add("type", tempPrivateInvestment.getType())
//					   .add("baseRateOfReturn", tempPrivateInvestment.getBaseRateOfReturn())
//					   .add("quarterlyDividend", tempPrivateInvestment.getQuarterlyDividend())
//					   .add("omega", tempPrivateInvestment.getOmegaMeasure())
//					   .add("value", tempPrivateInvestment.getTotalValue())
//					   .build();
//			Portfoliobuilder.add(tempPort);
		}
		  //Takes our formatted console output and saves it as a portfolio.txt file
		double[] PortfolioAnnualReturnSum= new double[NumberOfLines[2]];
 
		PrintStream portfolio = new PrintStream(new FileOutputStream("data/Portfolios.txt"));
		  System.setOut(portfolio);
		System.out.println("############################################################################################################################################################################################################################################################################################################");
		System.out.println();
		System.out.println("A Collection of "+NumberOfLines[2]+" Portfolios");
		System.out.println("# Of Persons from the Persons Datafile :"+NumberOfLines[0]);
		System.out.println("# Of Assets from the Assets Datafile :"+NumberOfLines[1]);
		System.out.println();
		System.out.println("=================================================================================================================================================================================================================================================================================================");
		System.out.println();
		for(g=0; g<NumberOfLines[2]; g++){
		System.out.println("PORTFOLIO #"+(g+1)+"/"+NumberOfLines[2]);
		System.out.println();
		System.out.println("Portfolio Code :"+PortfolioArray[g].getPortfolioCode());
		System.out.println("Owner :"+PortfolioArray[g].getOwnerName());
		System.out.println("Owner Code :"+PortfolioArray[g].getOwnerCode());
		System.out.println("Manager :"+PortfolioArray[g].getManagerName());
		System.out.println("Manager Code :"+PortfolioArray[g].getManagerCode());
		System.out.println("Beneficiary :"+PortfolioArray[g].getBeneficiaryName());
		if(!(PortfolioArray[g].getBeneficiaryName().equals("none"))){
		System.out.println("Beneficiary Code :"+PortfolioArray[g].getBeneficiaryCode());
		}
		System.out.println("Assets List And Modifier Variables :"+PortfolioArray[g].getAsset());
		System.out.println("# Of Assets within the Portfolio :"+PortfolioArray[g].getOccuranceOfAssetCount());
		System.out.println();
		System.out.println("FINANCIAL INFORMATION");
		System.out.println();
		System.out.println("Individual Asset Information:");
		System.out.println();
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println();
		int q=0;
		for(int u=0; u<PortfolioArray[g].getOccuranceOfAssetCount(); u++){
				System.out.println("Asset #"+(u+1)+"/"+PortfolioArray[g].getOccuranceOfAssetCount() +" Of Portfolio "+PortfolioArray[g].getPortfolioCode()+" #"+(g+1)+"/"+NumberOfLines[2] );
				System.out.println("Asset Code :"+PortfolioArray[g].getAssetName(u));
				q=0;
				while(q<PortfolioArray[g].getAssetcount()){
					if(PortfolioArray[g].getAssetName(u).equals(AssetsArray[q].getCode())){
						System.out.println("Asset Name :"+ AssetsArray[q].getLabel());
						System.out.println("Asset Type :"+ AssetsArray[q].getType());
						q++;
					}
					else{
						q++;
					}
				}
				System.out.println("Asset Value Modifier :"+PortfolioArray[g].getAssetValue(u));
				q=0;
				while(q<PortfolioArray[g].getAssetcount()){
					if(PortfolioArray[g].getAssetName(u).equals(AssetsArray[q].getCode())){
						System.out.println("Annual Return :"+PortfolioArray[g].getAnnualReturn(u));
						PortfolioAnnualReturnSum[g]+=PortfolioArray[g].getAnnualReturn(u);
						AnnualReturnSum+=PortfolioArray[g].getAnnualReturn(u);
						q++;
					}
					else{
						q++;
					}
				}
				System.out.println("Risk :"+PortfolioArray[g].getRisk(u));
				System.out.println("Value :"+PortfolioArray[g].getValue(u));
				System.out.println("Return Rate :"+(PortfolioArray[g].getReturnRate()[u]*100)+"%");	
				System.out.println();
				System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.println();
			}
		System.out.println("SUMMATIVE FINANCIAL INFORMATION FOR PORTFOLIO #"+(g+1)+"/"+NumberOfLines[2]);
		System.out.println("Total Value :"+PortfolioArray[g].getTotalValue());
		TotalValueSum+=PortfolioArray[g].getTotalValue();
		System.out.println("Aggregate Risk :"+PortfolioArray[g].getAggRisk());
		System.out.println("Total Fees :"+PortfolioArray[g].getFees());
		FeesSum+=PortfolioArray[g].getFees();
		System.out.println("Commissions :"+PortfolioArray[g].getCommissions());
		
		CommissionsSum+=PortfolioArray[g].getCommissions();
		
		System.out.println("Portfolio Sum of Annual Returns :"+PortfolioAnnualReturnSum[g]);

		System.out.println();
		System.out.println("END OF PORTFOLIO #"+(g+1)+"/"+NumberOfLines[2]);
		System.out.println("=================================================================================================================================================================================================================================================================================================");
		System.out.println("");
		}
		System.out.println("ALL "+NumberOfLines[2]+" PORTFOLIOS READ");
		System.out.println();
		System.out.println("SUMS OF PORTFOLIO VALUES");
		System.out.println();
		System.out.println("Sum of All Portfolio Total Asset Values :"+TotalValueSum);
		System.out.println("Sum of All Portfolio Annual Returns :"+AnnualReturnSum);
		System.out.println("Sum of All Portfolio Commissions :"+CommissionsSum);
		System.out.println("Sum of All Portfolio Fees :"+FeesSum);
		System.out.println();
		System.out.println("################################################################################################################################################################################################33");
		portfolio.close();
JsonArray Persons= Personbuilder.build();
JsonArray Assets= Assetbuilder.build();				

		// config Map is created for pretty printing.
		  Map<String, Boolean> config = new HashMap<>();
		  // Pretty printing feature is added.
		  config.put(JsonGenerator.PRETTY_PRINTING, true);
		  // PrintWriter and JsonWriter is being created
		  // in try-with-resources
		  try (PrintWriter printWriter = new PrintWriter("data/Persons.json");
		JsonWriter jsonWriter = Json.createWriterFactory(config).createWriter(printWriter)){
		     // Json object is being sent into file system
			  jsonWriter.write(Persons);
		  }
		  try (PrintWriter printWriter = new PrintWriter("data/Assets.json");
					JsonWriter jsonWriter = Json.createWriterFactory(config).createWriter(printWriter)){
					     // Json object is being sent into file system
						  jsonWriter.write(Assets);
					  }
	
	}
}
//TODO: IMPLEMENT WHAT WE NEED TO WITH THE PORTFOLIO STUFF. WE MADE GOOD PROGRESS IN MAKING OUR CODE LESS SHIT