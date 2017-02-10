//hey this is alex and tyler
//hello again
package dataConverter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import org.codehaus.jackson.map.ObjectMapper;
import java.util.Scanner;
import java.io.BufferedReader;

public class InputOutput {
	public static void main(String[] args) throws IOException {		
		int NumOfFiles= args.length;
		int i=0;
		int g=0;
		int x=0;
		boolean[] IsPerson=new boolean[NumOfFiles];
		boolean[] IsAsset=new boolean[NumOfFiles];
		String[] fileName = new String[NumOfFiles];
		for(i=0; i<NumOfFiles; i++){
			fileName[i]=args[i];
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
		int PersonSize=0;
		int AssetSize=0;
		int[] size= new int[NumOfFiles];
		int NumberOfLines[]= new int[NumOfFiles];
		int[] NumOfChars= new int[10000];
		for(i=0; i<NumOfFiles; i++){
			BufferedReader Buff = new BufferedReader(new FileReader(args[i]));
	        String text = Buff.readLine();
	        size[i] = Integer.parseInt(text);
	        size[i] += 1;
	        if(IsPerson[i]){
	        	PersonSize=size[i];
	        }
	        if(IsAsset[i]){
	        	AssetSize=size[i];
	        }
	        Buff.close();
		}
		String fullData[][] = new String[NumOfFiles][1000];
	        Scanner s = null;
	    for(i=0; i<NumOfFiles; i++){
		try{
			s = new Scanner(new File(fileName[i]));
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
		x=0;		
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
		String DelimeteredData[][][]= new String[NumOfFiles][1000][5];
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
		ObjectMapper jsonMapper = new ObjectMapper();
//testing to ensure it is saved correctly;	
		Persons[][] PersonArray= new Persons[NumOfFiles][PersonSize];
		Assets[][] AssetsArray= new Assets[NumOfFiles][AssetSize];
		String HasNoData= "";
		for(i=0; i<NumOfFiles; i++){
			for(g=0; g<NumberOfLines[i]; g++){
					if(IsPerson[i]){						
						if(NumberOfDelims[i][g]==5){	
							PersonArray[i][g]= new Persons(DelimeteredData[i][g][0], DelimeteredData[i][g][1], DelimeteredData[i][g][2], DelimeteredData[i][g][3], DelimeteredData[i][g][4]);
						}
						else{
							PersonArray[i][g]= new Persons(DelimeteredData[i][g][0], DelimeteredData[i][g][1], DelimeteredData[i][g][2], DelimeteredData[i][g][3], HasNoData);
						}
					}
					if(IsAsset[i]){
						if(DelimeteredData[i][g][1].contains("D,")){
							AssetsArray[i][g-1]= new Deposit(DelimeteredData[i][g][0], DelimeteredData[i][g][2], DelimeteredData[i][g][3], HasNoData, HasNoData, HasNoData, HasNoData);				
						}
						else if(DelimeteredData[i][g][1].contains("S,")){
							AssetsArray[i][g-1]= new Stock(DelimeteredData[i][g][0], DelimeteredData[i][g][2], DelimeteredData[i][g][3], DelimeteredData[i][g][4], DelimeteredData[i][g][5], DelimeteredData[i][g][6], DelimeteredData[i][g][7]);
						}
						else if(DelimeteredData[i][g][1].contains("P,")){
							AssetsArray[i][g-1]= new PrivateInvestment(DelimeteredData[i][g][0], DelimeteredData[i][g][2], DelimeteredData[i][g][3], DelimeteredData[i][g][4], DelimeteredData[i][g][5], DelimeteredData[i][g][6], HasNoData);
						}			
					}	
			}
		}
	//TODO: Store the Persons and Assets data into a JSON file. FORMAT IT
for(g=0; g<NumOfFiles;g++){
	for(i=0; i<NumberOfLines[g]; i++){
//		System.out.println(PersonArray[g][i].getPersonCode()+", "+PersonArray[g][i].getType()+", "+PersonArray[g][i].getSEC()+", "+PersonArray[g][i].getLastName()+", "+PersonArray[g][i].getFirstName()+", "+ PersonArray[g][i].getStreet()+", "+PersonArray[g][i].getCity()+", "+PersonArray[g][i].getState()+", "+PersonArray[g][i].getZipcode()+", "+PersonArray[g][i].getCountry()+", "+PersonArray[g][i].getEmail());
	}		
}

		try {  
		       // Writing to a file
			 jsonMapper.writeValue(new FileOutputStream("./data/Persons.json"), PersonArray);
			 jsonMapper.writeValue(new File("./data/Assets.json"), AssetsArray);
		    } catch (IOException e) {  
		        e.printStackTrace();  
		    }  
		}
	
	

}
