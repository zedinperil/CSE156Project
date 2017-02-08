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
import java.lang.Math;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
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
        System.out.println(text);
 		System.out.println(size);
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

	String DelimeteredData[][]= new String[NumberOfLines][];
		if(fileName.contains("Persons.dat")||fileName.contains("persons.dat")){
		System.out.println("ITS A PERSON");
			for(i=1; i<=NumberOfLines; i++){
				for(x=0; x<fullData[i].length(); x++){
					if(fullData[i].charAt(x)==';'){
						DelimeteredData[i-1]=fullData[i].split(";");
						System.out.println(DelimeteredData[i-1][k]);
						if(x==(fullData[i].length())-1){
							DelimeteredData[i-1]=fullData[i].split("");
							System.out.println(DelimeteredData[i-1][k+1]);
							System.out.println("TryinTomakeachange");
						}
						k++;
					}
		
				}
				k=0;
			}
		}
		else if(fileName.contains("Assets.dat")||fileName.contains("assets.dat")){
		System.out.println("ITS AN ASSET");
			for(i=1; i<=NumberOfLines; i++){
				
			}
		}
		else{
		System.out.println("I HAVE NO IDEA WHAT THIS iS");
		}
		
	//TODO: Based on what each is,  use methods to save delimetered strings into the correct spaces for whatever type the data is
	
	//TODO: Store the Persons and Assets data into a JSON file.
}
}
