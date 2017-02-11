//hey this is alex and tyler
//hello again
package dataConverter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.codehaus.jackson.util.DefaultPrettyPrinter;
import org.codehaus.jackson.map.ObjectMapper;
import java.util.Scanner;
import java.io.BufferedReader;
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
//			fileName[i]=args[i];
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
		int PersonSize=0;
		int AssetSize=0;
		int[] size= new int[NumOfFiles];
		int NumberOfLines[]= new int[NumOfFiles];
		int[] NumOfChars= new int[10000];
		for(i=0; i<NumOfFiles; i++){
			//gets the size of the file, we don't want to store it with the data
			BufferedReader Buff = new BufferedReader(new FileReader(fileName[i]));
	        String text = Buff.readLine();
	        size[i] = Integer.parseInt(text);
	        size[i] += 1;
	        if(IsPerson[i]){
	        	PersonSize=size[i];
	        }
	        if(IsAsset[i]){
	        	AssetSize=size[i];
	        }
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
				if(fullData[i][x].charAt(q)!='\u0000'){
					NumOfChars[x]++;	
				}
			}
			x++;
			
		}
		
		NumberOfLines[i]=Integer.parseInt(fullData[i][0]);
		s.close();
	    }
	//TODO: Enumerate person and assets classes, and create arrays for each.
		//DONE ELSEWHERE
		String DelimeteredData[][][]= new String[2][1000][100];
	//TODO: Based on what each is,  use methods to save delimetered strings into the correct spaces for whatever type the data is
	int[][] NumberOfDelims= new int[NumOfFiles][1000];
	for(i=0; i<NumOfFiles; i++){
		for( g=1; g<=NumberOfLines[i]; g++){
			for(x=0; x<=NumOfChars[g]; x++){
				if(fullData[i][g].charAt(x)==';'){
					DelimeteredData[i][g-1]=fullData[i][g].split(";");	
				}
				if(x==(NumOfChars[g])-1 && fullData[i][g].lastIndexOf(";")!=NumOfChars[g]-1){
						DelimeteredData[i][g-1]=fullData[i][g].split(";");						
				}	
					NumberOfDelims[i][g-1]=DelimeteredData[i][g-1].length;	
			}
//			if(NumberOfDelims[i][g-1]>1){
//				System.out.println("x is:"+x);
//				System.out.println("Num of delims is:"+NumberOfDelims[i][g-1]);
//				System.out.println("Number of chars:"+NumOfChars[g]);
//				System.out.println("THE BIT: "+DelimeteredData[i][g-1][0]+DelimeteredData[i][g-1][1]+DelimeteredData[i][g-1][2]);
//				}
		}
	}
	
//testing to ensure it is saved correctly;	
		Persons[][] PersonArray= new Persons[NumOfFiles][PersonSize];
		Assets[][] AssetsArray= new Assets[NumOfFiles][AssetSize];
		String HasNoData= "";
		for(i=0; i<NumOfFiles; i++){
			for(g=0; g<NumberOfLines[i]; g++){
					System.out.println(NumberOfLines[i]);
					if(IsPerson[i]){						
						if(NumberOfDelims[i][g]==5){	
							PersonArray[i][g]= new Persons(DelimeteredData[i][g][0], DelimeteredData[i][g][1], DelimeteredData[i][g][2], DelimeteredData[i][g][3], DelimeteredData[i][g][4]);
						}
						else{
							PersonArray[i][g]= new Persons(DelimeteredData[i][g][0], DelimeteredData[i][g][1], DelimeteredData[i][g][2], DelimeteredData[i][g][3], HasNoData);
						}
					}
					if(IsAsset[i]){
						if(DelimeteredData[i][g][1].contains("D")){
							AssetsArray[i][g]= new Deposit(DelimeteredData[i][g][0], DelimeteredData[i][g][1],DelimeteredData[i][g][2], DelimeteredData[i][g][3]);				
						}
						else if(DelimeteredData[i][g][1].contains("S")){
							AssetsArray[i][g]= new Stock(DelimeteredData[i][g][0], DelimeteredData[i][g][1], DelimeteredData[i][g][2], DelimeteredData[i][g][3], DelimeteredData[i][g][4], DelimeteredData[i][g][5], DelimeteredData[i][g][6], DelimeteredData[i][g][7]);
						}
						else if(DelimeteredData[i][g][1].contains("P")){
							AssetsArray[i][g]= new PrivateInvestment(DelimeteredData[i][g][0], DelimeteredData[i][g][1], DelimeteredData[i][g][2], DelimeteredData[i][g][3], DelimeteredData[i][g][4], DelimeteredData[i][g][5], DelimeteredData[i][g][6]);
						}			
					}	
			}
		}
//	//TODO: Store the Persons and Assets data into a JSON file. FORMAT IT
		ObjectMapper jsonMapper = new ObjectMapper();
		
		try {  
			DefaultPrettyPrinter pp= new DefaultPrettyPrinter();
//			pp.indentArraysWith(new Lf2SpacesIndenter());
			// Writing to a file
			 jsonMapper.writer(pp).writeValue(new File("./data/Persons.json"), PersonArray);
			 jsonMapper.writer(pp).writeValue(new File("./data/Assets.json"), AssetsArray);
		    } catch (IOException e) {  
		        e.printStackTrace();  
		    }  
		}
}
