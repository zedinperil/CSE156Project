//hey this is alex
//hello again
package dataConverter;
import java.io.File;
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
        System.out.println(text);
 		System.out.println(size);
		try{
			s = new Scanner(new File(fileName));
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
		String fullData[] = new String[size];
		int i = 0;
		while(s.hasNext()) {
			String line = s.nextLine(); //throw away the endline character
			//System.out.println(line);
			fullData[i] = line;
			i++;
		}
		for(i=1;i<size;i++){
			System.out.println(fullData[i]);
		}
	
	//TODO: Enumerate person and assets classes, and create arrays for each.
		//DONE ELSEWHERE
	//TODO: Determine whether or not the string we have pertains to persons or assets
<<<<<<< HEAD
=======
		boolean IsPerson = false;
		boolean IsAsset = false;
		if(title.contains("Persons.dat")||title.contains("persons.dat")){
		System.out.println("ITS A PERSON");
		IsPerson=true;
		}
		else if(title.contains("Assets.dat")||title.contains("assets.dat")){
		System.out.println("ITS AN ASSET");
		IsAsset=true;
		}
		else{
		System.out.println("I HAVE NO IDEA WHAT THIS iS");
		}
		//delimeter each thing into individual arguments.
		String delims= "[;]";
<<<<<<< HEAD
String[][] Arguments= new String[InputArrayLength][10000000];
=======
 String[] Arguments= new String[InputArrayLength];
>>>>>>> origin/master
//		String Argument;
		for(int i=0; i<InputArrayLength; i++){
			for(x=0; x<6; x++){
				Arguments[i]=InputArray[i].split(delims);
				System.out.println(Arguments[i][0]);
			}
	
		}
>>>>>>> origin/master
		
		//delimeter each thing into individual arguments.
		String delims= "[;]";		
		
	//TODO: Based on what each is,  use methods to save delimetered strings into the correct spaces for whatever type the data is
		
	//TODO: Store the Persons and Assets data into a JSON file.
}
}
