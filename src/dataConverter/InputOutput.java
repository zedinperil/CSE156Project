package dataConverter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
		boolean[] PortfolioHasNoBeneficiary = new boolean[size[2]];
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
								PortfolioHasNoBeneficiary[g]=true;
							}
						}
				}	
			}
			NumberOfDelims[i][g-1]=DelimeteredData[i][g-1].length;	//this is how many delimeters we have
		}
	}
//Temp variables for persons, deposits, stocks, and privateinvestments		
		
		String HasNoData= "";//this is a string to be put in the event that a person does not have an email address.
		JsonArrayBuilder Portfoliobuilder= Json.createArrayBuilder();
		JsonArrayBuilder Personbuilder= Json.createArrayBuilder();
		JsonArrayBuilder Assetbuilder= Json.createArrayBuilder();
		int Personcount=0;
		int Assetscount=0;
//Debug in case we need to use the arrays later;	
		Persons[][] PersonArray= new Persons[NumOfFiles][100];
		Assets[][] AssetsArray= new Assets[NumOfFiles][100];
		Portfolio[][] PortfolioArray= new Portfolio[NumOfFiles][100];
		for(i=0; i<NumOfFiles; i++){
			for(g=0; g<NumberOfLines[i]; g++){
				if(IsPortfolio[i]){
					if(PortfolioHasNoBeneficiary[g]){
					System.out.println("CHECK1");
						if(NumberOfDelims[i][g]==5){
							System.out.println("CHECK2");

							PortfolioArray[i][g]=new Portfolio(DelimeteredData[i][g][0], DelimeteredData[i][g][1], DelimeteredData[i][g][2], "none", DelimeteredData[i][g][3], PersonArray, AssetsArray, Personcount, Assetscount);
						}
						else if(NumberOfDelims[i][g]==4){
							System.out.println("CHECK3");

							PortfolioArray[i][g]=new Portfolio(DelimeteredData[i][g][0], DelimeteredData[i][g][1], DelimeteredData[i][g][2], "none", DelimeteredData[i][g][3], PersonArray, AssetsArray, Personcount, Assetscount);	
						}
						else{
							System.out.println("CHECK4");

							PortfolioArray[i][g]=new Portfolio(DelimeteredData[i][g][0], DelimeteredData[i][g][1], DelimeteredData[i][g][2], "none", HasNoData, PersonArray, AssetsArray, Personcount, Assetscount);
						}
					}
					else{
						System.out.println("CHECK5");

						if(NumberOfDelims[i][g]==5){
							System.out.println("CHECK6");

							PortfolioArray[i][g]=new Portfolio(DelimeteredData[i][g][0], DelimeteredData[i][g][1], DelimeteredData[i][g][2], DelimeteredData[i][g][3], DelimeteredData[i][g][4], PersonArray, AssetsArray, Personcount, Assetscount);
						}
						else if(NumberOfDelims[i][g]==4){
							System.out.println("CHECK7");

							PortfolioArray[i][g]=new Portfolio(DelimeteredData[i][g][0], DelimeteredData[i][g][1], DelimeteredData[i][g][2], "none", DelimeteredData[i][g][3], PersonArray, AssetsArray, Personcount, Assetscount);	
						}
						else{
							System.out.println("CHECK8");

							PortfolioArray[i][g]=new Portfolio(DelimeteredData[i][g][0], DelimeteredData[i][g][1], DelimeteredData[i][g][2], "none", HasNoData, PersonArray, AssetsArray, Personcount, Assetscount);
			
						}
					}
				System.out.println("NEW PORTFOLIO");
			
					
				System.out.println("portCode "+PortfolioArray[i][g].getPortfolioCode());
				System.out.println("Ownercode "+PortfolioArray[i][g].getOwnerCode());
				System.out.println("Ownername "+PortfolioArray[i][g].getOwnerName());
				System.out.println("Managername "+PortfolioArray[i][g].getManagerName());
				System.out.println("Beneficiaryname "+PortfolioArray[i][g].getBeneficiaryName());
				System.out.println("Managetcode "+PortfolioArray[i][g].getManagerCode());
				System.out.println("Beneficiarycode "+PortfolioArray[i][g].getBeneficiaryCode());
				System.out.println("Assetstring "+PortfolioArray[i][g].getAsset());
				System.out.println("ass "+PortfolioArray[i][g].getAss());
				System.out.println("per "+PortfolioArray[i][g].getPer());
				System.out.println("Fees "+PortfolioArray[i][g].getFees());
				System.out.println("Commisions "+PortfolioArray[i][g].getCommisions());
//				for(int u=0; u<PortfolioArray[i][g].getAssetcount(); u++){
//					System.out.println("U is"+u);
//						System.out.println("AssetName "+PortfolioArray[i][g].getAssetName(u));
//						System.out.println("AssetValue "+PortfolioArray[i][g].getAssetValue(u));
//						System.out.println("Risk "+PortfolioArray[i][g].getRisk(u));
//					//	System.out.println(PortfolioArray[i][g].getAnnualReturn(u, u));
//					}
				System.out.println("Value "+PortfolioArray[i][g].getValue());
				System.out.println("ReturnRate "+PortfolioArray[i][g].getReturnRate());
				System.out.println("Aggregaterisk "+PortfolioArray[i][g].getAggRisk());
				System.out.println("Personcount "+PortfolioArray[i][g].getPersoncount());
				System.out.println("Assetcount "+PortfolioArray[i][g].getAssetcount());
			

				System.out.println("Occurranceofassetcount "+PortfolioArray[i][g].getOccuranceOfAssetCount());
				System.out.println("managercount "+PortfolioArray[i][g].getManagerCount());
System.out.println("END OF PORTFOLIO");
System.out.println("");
				}
					if(IsPerson[i]){
						Personcount++;
						if(DelimeteredData[i][g][1].equals("")){
							if(NumberOfDelims[i][g]==5){	
								PersonArray[i][g]= new Beneficiaries(DelimeteredData[i][g][0],  DelimeteredData[i][g][2], DelimeteredData[i][g][3], DelimeteredData[i][g][4]);							
							}
							else{
								PersonArray[i][g]= new Beneficiaries(DelimeteredData[i][g][0],  DelimeteredData[i][g][2], DelimeteredData[i][g][3], HasNoData);
							}
								JsonObject tempmodel = Json.createObjectBuilder()
									   .add("code", PersonArray[i][g].getPersonCode())									
									   .add("firstName", PersonArray[i][g].getFirstName())
									   .add("lastName", PersonArray[i][g].getLastName())
									   .add("address", Json.createArrayBuilder()
									      .add(Json.createObjectBuilder()
									         .add("street", PersonArray[i][g].getStreet())
									         .add("city", PersonArray[i][g].getCity())
									         .add("state", PersonArray[i][g].getState())
									         .add("country", PersonArray[i][g].getCountry())
									         .add("zipcode", PersonArray[i][g].getZipcode())))
									   		 .add("emails", PersonArray[i][g].getEmail())
									   .build();
							Personbuilder.add(tempmodel);
						}
						else{
							if(NumberOfDelims[i][g]==5){	
								PersonArray[i][g]= new Broker(DelimeteredData[i][g][0], DelimeteredData[i][g][1], DelimeteredData[i][g][2], DelimeteredData[i][g][3], DelimeteredData[i][g][4]);							
							}
							else{
									PersonArray[i][g]= new Broker(DelimeteredData[i][g][0], DelimeteredData[i][g][1], DelimeteredData[i][g][2], DelimeteredData[i][g][3], HasNoData);
								}
								JsonObject tempmodel = Json.createObjectBuilder()
									   .add("code", PersonArray[i][g].getPersonCode())
									   .add("secIdentifier", PersonArray[i][g].getSecIdentifier())
									   .add("type", PersonArray[i][g].getType())
									   .add("firstName", PersonArray[i][g].getFirstName())
									   .add("lastName", PersonArray[i][g].getLastName())
									   .add("address", Json.createArrayBuilder()
									      .add(Json.createObjectBuilder()
									         .add("street", PersonArray[i][g].getStreet())
									         .add("city", PersonArray[i][g].getCity())
									         .add("state", PersonArray[i][g].getState())
									         .add("country", PersonArray[i][g].getCountry())
									         .add("zipcode", PersonArray[i][g].getZipcode())))
									   		 .add("emails", PersonArray[i][g].getEmail())
									   .build();
							Personbuilder.add(tempmodel);
						}
					}
				//check to see that it is an asset, and if so, check to see if the delimetered data for that asset that corresponds to type contains the character corresponding to each type of asset. Then, create a new asset of the correct type with the correct inputs for that type of asset
					if(IsAsset[i]){
						Assetscount++;
						if(DelimeteredData[i][g][1].contains("D")){
							AssetsArray[i][g]= new Deposit(DelimeteredData[i][g][0], DelimeteredData[i][g][1],DelimeteredData[i][g][2], DelimeteredData[i][g][3]);				
							//TODO: fix this for assets
							JsonObject tempmodel = Json.createObjectBuilder()
									   .add("code", AssetsArray[i][g].getCode())
									   .add("label", AssetsArray[i][g].getLabel())
									   .add("type", AssetsArray[i][g].getType())
									   .add("apr", AssetsArray[i][g].getApr())
									   .build();
							Assetbuilder.add(tempmodel);
						}
						else if(DelimeteredData[i][g][1].contains("S")){
							AssetsArray[i][g]= new Stock(DelimeteredData[i][g][0], DelimeteredData[i][g][1], DelimeteredData[i][g][2], DelimeteredData[i][g][3], DelimeteredData[i][g][4], DelimeteredData[i][g][5], DelimeteredData[i][g][6], DelimeteredData[i][g][7]);
							//TODO: fix this for assets
							JsonObject tempmodel = Json.createObjectBuilder()
									   .add("code", AssetsArray[i][g].getCode())
									   .add("label", AssetsArray[i][g].getLabel())
									   .add("type", AssetsArray[i][g].getType())
									   .add("baseRateOfReturn", AssetsArray[i][g].getBaseRateOfReturn())
									   .add("quarterlyDividend", AssetsArray[i][g].getQuarterlyDividend())
									   .add("sharePrice", AssetsArray[i][g].getSharePrice())
									   .add("symbol", AssetsArray[i][g].getStockSymbol())
									   .add("beta", AssetsArray[i][g].getBetaMeasure())
									   .build();
							Assetbuilder.add(tempmodel);
						}
						else if(DelimeteredData[i][g][1].contains("P")){
							AssetsArray[i][g]= new PrivateInvestment(DelimeteredData[i][g][0], DelimeteredData[i][g][1], DelimeteredData[i][g][2], DelimeteredData[i][g][3], DelimeteredData[i][g][4], DelimeteredData[i][g][5], DelimeteredData[i][g][6]);
							//TODO: fix this for assets
							JsonObject tempmodel = Json.createObjectBuilder()
									   .add("code", AssetsArray[i][g].getCode())
									   .add("label", AssetsArray[i][g].getLabel())
									   .add("type", AssetsArray[i][g].getType())
									   .add("baseRateOfReturn", AssetsArray[i][g].getBaseRateOfReturn())
									   .add("quarterlyDividend", AssetsArray[i][g].getQuarterlyDividend())
									   .add("omega", AssetsArray[i][g].getOmegaMeasure())
									   .add("value", AssetsArray[i][g].getTotalValue())
									   .build();
							Assetbuilder.add(tempmodel);
						}			
					}	
			}
			System.out.println("OUT OF PORTFOLIOS");
//build portfolio, add to portfoliobuilder
			JsonObject tempPort = Json.createObjectBuilder()
//					   .add("code", tempPrivateInvestment.getCode())
//					   .add("label", tempPrivateInvestment.getLabel())
//					   .add("type", tempPrivateInvestment.getType())
//					   .add("baseRateOfReturn", tempPrivateInvestment.getBaseRateOfReturn())
//					   .add("quarterlyDividend", tempPrivateInvestment.getQuarterlyDividend())
//					   .add("omega", tempPrivateInvestment.getOmegaMeasure())
//					   .add("value", tempPrivateInvestment.getTotalValue())
					   .build();
			Portfoliobuilder.add(tempPort);
		}
JsonArray Persons= Personbuilder.build();
JsonArray Assets= Assetbuilder.build();				
JsonArray Portfolio= Portfoliobuilder.build();
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
		  try (PrintWriter printWriter = new PrintWriter("data/Portfolio.txt");
					JsonWriter jsonWriter = Json.createWriterFactory(config).createWriter(printWriter)){
					     // Json object is being sent into file system
						  jsonWriter.write(Portfolio);					     
					  }
	}
}
//TODO: IMPLEMENT WHAT WE NEED TO WITH THE PORTFOLIO STUFF. WE MADE GOOD PROGRESS IN MAKING OUR CODE LESS SHIT