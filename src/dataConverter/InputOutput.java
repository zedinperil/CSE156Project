//hey this is alex and tyler
//hello again
package dataConverter;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.io.IOException;
//import org.codehaus.jackson.JsonGenerationException;
//import org.codehaus.jackson.map.JsonMappingException;
//import org.codehaus.jackson.map.ObjectMapper;
//import java.lang.Math;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
import java.util.Scanner;
import java.io.BufferedReader;
//DOING A TESTING
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
public class InputOutput {
	public static void main(String[] args) throws IOException {		
		
		String fileName = args[0];
		Scanner s = null;
		BufferedReader Buff = new BufferedReader(new FileReader(args[0]));
        String text = Buff.readLine();
        int size = Integer.parseInt(text);
        size += 1;
        int NumberOfLines;
//      System.out.println(text);
//		System.out.println(size);
		try{
			s = new Scanner(new File(fileName));
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
		String fullData[] = new String[size];
		int i = 0;
		int x = 0;
		int k = 0;
		while(s.hasNext()) {
			String line = s.nextLine(); //throw away the endline character
			//System.out.println(line);
			fullData[i] = line;
			i++;
			
		}
		NumberOfLines=Integer.parseInt(fullData[0]);

		for(i=1;i<size;i++){
		//	System.out.println(fullData[i]);
		}
	
	//TODO: Enumerate person and assets classes, and create arrays for each.
		//DONE ELSEWHERE
	//TODO: Determine whether or not the string we have pertains to persons or assets
		boolean IsPerson=false;
		boolean IsAsset=false;
		boolean[]AddBlankEmail=new boolean[NumberOfLines];
	String DelimeteredData[][]= new String[NumberOfLines][5];
		if(fileName.contains("Persons.dat")||fileName.contains("persons.dat")){
		System.out.println("ITS A PERSON");
		IsPerson=true;
		
		}
		else if(fileName.contains("Assets.dat")||fileName.contains("assets.dat")){
		System.out.println("ITS AN ASSET");
		IsAsset=true;	
	
		}
		else{
		System.out.println("I HAVE NO IDEA WHAT THIS iS");
		}
		//Persons[] PersonArray= new Persons[NumberOfLines];
		//Assets[] AssetsArray= new Assets[NumberOfLines];
	//TODO: Based on what each is,  use methods to save delimetered strings into the correct spaces for whatever type the data is
	int[] NumberOfDelims= new int[NumberOfLines];
		for(i=1; i<=NumberOfLines; i++){
			for(x=0; x<fullData[i].length(); x++){
				if(fullData[i].charAt(x)==';'){
					DelimeteredData[i-1]=fullData[i].split(";");
//					System.out.println(DelimeteredData[i-1][k]);	
					k++;
					}
					if(x==(fullData[i].length())-1 && fullData[i].lastIndexOf(";")!=fullData[i].length()-1){
						DelimeteredData[i-1]=fullData[i].split(";");
//					System.out.println(DelimeteredData[i-1][k]);
						AddBlankEmail[i-1]=false;
						k++;	
					}
					NumberOfDelims[i-1]=k;
				}	
			k=0;
		}
	
		for(i=0;i<NumberOfLines;i++){
			for(int j=0;j<1;j++){
				if(DelimeteredData[i][2]!= " "){
					Address tempaddress = new Address(DelimeteredData[i][3]);
					Name tempName = new Name(DelimeteredData[i][2]);
					Beneficiaries b = new Beneficiaries(DelimeteredData[i][j], tempName, tempaddress, DelimeteredData[i][j+4]);
					System.out.println(tempName.getFirstName());
					
				}
			}
		}	
//testing to ensure it is saved correctly;		
		//String HasNoData= "";
		//for(i=0; i<NumberOfLines; i++){
		//	for(x=0; x<NumberOfDelims[i]; x++){
		//		
		//		if(IsPerson){
		//			if(AddBlankEmail[i]){
		//				PersonArray[i]= new Persons(DelimeteredData[i][0], DelimeteredData[i][1], DelimeteredData[i][2], HasNoData);
		//			}
		//			else{
		//				PersonArray[i]= new Persons(DelimeteredData[i][0], DelimeteredData[i][1], DelimeteredData[i][2], DelimeteredData[i][3]);
		//			}
		//		}
				//if(IsAsset){
				//	if(DelimeteredData[i][1].contains("D,")){
				//		AssetsArray[i]= new Assets(DelimeteredData[i][0], DelimeteredData[i][1], DelimeteredData[i][3], HasNoData, HasNoData, HasNoData, HasNoData);
				//	}
				//	else if(DelimeteredData[i][1].contains("S,")){
				//		AssetsArray[i]= new Assets(DelimeteredData[i][0], DelimeteredData[i][1], DelimeteredData[i][3], DelimeteredData[i][4], DelimeteredData[i][5], DelimeteredData[i][6], DelimeteredData[i][7]);
				//	}
				//	else if(DelimeteredData[i][1].contains("P,")){
				//		AssetsArray[i]= new Assets(DelimeteredData[i][0], DelimeteredData[i][1], DelimeteredData[i][3], DelimeteredData[i][4], DelimeteredData[i][5], DelimeteredData[i][6], HasNoData);
				//	}			
				//}
				//System.out.println(DelimeteredData[i][x]);
			}
		//}
	
	//TODO: Store the Persons and Assets data into a JSON file.
}

