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
		int NumOfFiles= 2;
		int i=0;
		int g=0;
		int x=0;
		//booleans to keep track if file is person or assett
		boolean[] IsPerson=new boolean[NumOfFiles];
		boolean[] IsAsset=new boolean[NumOfFiles];
		String[] fileName = new String[2];
		//the filenames
		fileName[0]= "data/Persons.dat";
		fileName[1]= "data/Assets.dat";
		for(i=0; i<NumOfFiles; i++){
			//checks if file is a person or an asset
			if(fileName[i].contains("Persons")||fileName[i].contains("persons")){
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
	    }
	//TODO: Enumerate person and assets classes, and create arrays for each.
		//DONE ELSEWHERE
		String DelimeteredData[][][]= new String[2][1000][100];
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
				}	
			}
			NumberOfDelims[i][g-1]=DelimeteredData[i][g-1].length;	//this is how many delimeters we have
		}
	}
//Temp variables for persons, deposits, stocks, and privateinvestments		
		Persons tempPerson;
		Deposit tempDeposit;
		Stock tempStock;
		PrivateInvestment tempPrivateInvestment;
		String HasNoData= "";//this is a string to be put in the event that a person does not have an email address.
		JsonArrayBuilder Portfoliobuilder= Json.createArrayBuilder();
		JsonArrayBuilder Personbuilder= Json.createArrayBuilder();
		JsonArrayBuilder Assetbuilder= Json.createArrayBuilder();
		for(i=0; i<NumOfFiles; i++){
			for(g=0; g<NumberOfLines[i]; g++){
				//check to see that it is a person, if so, check to see how many delimeters the delimetered data corresponding to the person has, and put construct a person with the appropriate inputs
					if(IsPerson[i]){						
						if(NumberOfDelims[i][g]==5){	
							tempPerson= new Persons(DelimeteredData[i][g][0], DelimeteredData[i][g][1], DelimeteredData[i][g][2], DelimeteredData[i][g][3], DelimeteredData[i][g][4]);							
						}
						else{
							tempPerson= new Persons(DelimeteredData[i][g][0], DelimeteredData[i][g][1], DelimeteredData[i][g][2], DelimeteredData[i][g][3], HasNoData);
						}
							JsonObject tempmodel = Json.createObjectBuilder()
								   .add("code", tempPerson.getPersonCode())
								   .add("secIdentifier", tempPerson.getSEC())
								   .add("type", tempPerson.getType())
								   .add("firstName", tempPerson.getFirstName())
								   .add("lastName", tempPerson.getLastName())
								   .add("address", Json.createArrayBuilder()
								      .add(Json.createObjectBuilder()
								         .add("street", tempPerson.getStreet())
								         .add("city", tempPerson.getCity())
								         .add("state", tempPerson.getState())
								         .add("country", tempPerson.getCountry())
								         .add("zipcode", tempPerson.getZipcode())))
								   		 .add("emails", tempPerson.getEmail())
								   .build();
						Personbuilder.add(tempmodel);
					}
				//check to see that it is an asset, and if so, check to see if the delimetered data for that asset that corresponds to type contains the character corresponding to each type of asset. Then, create a new asset of the correct type with the correct inputs for that type of asset
					if(IsAsset[i]){
						if(DelimeteredData[i][g][1].contains("D")){
							tempDeposit= new Deposit(DelimeteredData[i][g][0], DelimeteredData[i][g][1],DelimeteredData[i][g][2], DelimeteredData[i][g][3]);				
							//TODO: fix this for assets
							JsonObject tempmodel = Json.createObjectBuilder()
									   .add("code", tempDeposit.getCode())
									   .add("label", tempDeposit.getLabel())
									   .add("type", tempDeposit.getType())
									   .add("apr", tempDeposit.getApr())
									   .build();
							Assetbuilder.add(tempmodel);
						}
						else if(DelimeteredData[i][g][1].contains("S")){
							tempStock= new Stock(DelimeteredData[i][g][0], DelimeteredData[i][g][1], DelimeteredData[i][g][2], DelimeteredData[i][g][3], DelimeteredData[i][g][4], DelimeteredData[i][g][5], DelimeteredData[i][g][6], DelimeteredData[i][g][7]);
							//TODO: fix this for assets
							JsonObject tempmodel = Json.createObjectBuilder()
									   .add("code", tempStock.getCode())
									   .add("label", tempStock.getLabel())
									   .add("type", tempStock.getType())
									   .add("baseRateOfReturn", tempStock.getBaseRateOfReturn())
									   .add("quarterlyDividend", tempStock.getQuarterlyDividend())
									   .add("sharePrice", tempStock.getSharePrice())
									   .add("symbol", tempStock.getStockSymbol())
									   .add("beta", tempStock.getBetaMeasure())
									   .build();
							Assetbuilder.add(tempmodel);
						}
						else if(DelimeteredData[i][g][1].contains("P")){
							tempPrivateInvestment= new PrivateInvestment(DelimeteredData[i][g][0], DelimeteredData[i][g][1], DelimeteredData[i][g][2], DelimeteredData[i][g][3], DelimeteredData[i][g][4], DelimeteredData[i][g][5], DelimeteredData[i][g][6]);
							//TODO: fix this for assets
							JsonObject tempmodel = Json.createObjectBuilder()
									   .add("code", tempPrivateInvestment.getCode())
									   .add("label", tempPrivateInvestment.getLabel())
									   .add("type", tempPrivateInvestment.getType())
									   .add("baseRateOfReturn", tempPrivateInvestment.getBaseRateOfReturn())
									   .add("quarterlyDividend", tempPrivateInvestment.getQuarterlyDividend())
									   .add("omega", tempPrivateInvestment.getOmegaMeasure())
									   .add("value", tempPrivateInvestment.getTotalValue())
									   .build();
							Assetbuilder.add(tempmodel);
						}	
				
					}	
			}
		}

JsonArray Persons= Personbuilder.build();
JsonArray Assets= Assetbuilder.build();				
				//A simple object containing Json array
//				JsonObject personObject = Json.createObjectBuilder()
//				.add("Person", (JsonValue)PersonsArray)
//				.build();
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

//	//TODO: Store the Persons and Assets data into a JSON file. FORMAT IT. We use Objectwriter to write values to the desired output and use prettyprinter to make it look (Marginally) better
//use prettyprinter to make this more well formatted (Although we know that there are still nulls. We honestly could not find the source of it.
//		ObjectMapper jsonMapper = new ObjectMapper();
//		try {  
//			DefaultPrettyPrinter pp= new DefaultPrettyPrinter();
//			// Writing to a file
//			//write person and assets arrays into json files
//			 jsonMapper.writer(pp).writeValue(new File("data/Persons.json"), PersonArray);
//			 jsonMapper.writer(pp).writeValue(new File("data/Assets.json"), AssetsArray);
//		    } 
//		//exception handling
//		catch (IOException e) {  
//		        e.printStackTrace();  
//		    }  
//		}
}}
