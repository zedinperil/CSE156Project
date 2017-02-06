//hey this is alex
//hello again
package dataConverter;
import java.io.File;
import java.io.IOException;
//import org.codehaus.jackson.JsonGenerationException;
//import org.codehaus.jackson.map.JsonMappingException;
//import org.codehaus.jackson.map.ObjectMapper;
import java.lang.Math;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
//DOING A TESTING
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
public class InputOutput {
	public static void main(String[] args) throws IOException {		
		//basic io with bytestream, to be converted to char.
		String title= args[0];
		File f = null;
		f= new File(title);
		FileInputStream fin=null;
		fin= new FileInputStream(f);
		byte fileContent[]= new byte[(int)f.length()];
		fin.read(fileContent);
		fin.close();
		
		char[] SpecialChars= new char[6];
		SpecialChars[0]='\t';
		SpecialChars[1]='\f';
		SpecialChars[2]='\\';
		SpecialChars[3]='\b';
		SpecialChars[4]='\n';
		SpecialChars[5]='\r';
		
		
		
//string array for inputs
		int x=0;//iteration variable, used in turning characterized bytecode into strings
		int g=0;//var used to  keep track of where the end of a line is in the bytestream.
		int d=0;//var used to keep track of where "x" is at relative to the length of the bytestream
		int InputArrayLength=0;//used later as the count of the string input array that is filled.
		boolean Sentinal;//boolean sentinal that says if a bytecode from the fileContent array is a special character or not
		String[] InputArray= new String[10000];//string input array
		//convert stream into chars and remove special chars.
		//for loop that iterates until fileContent is out of bytes.
		for(int i=0; i< fileContent.length; i++){
				if((char)fileContent[i]==SpecialChars[4]||i==fileContent.length-1){ //Checks to see if there is a newline character or if we are at the end of the data file
					g=i;//g acts as the intger to which x will iterate
					InputArrayLength++;	//this means a newline has been detected, and so the length of the input array goes up one
					//Stringbuilder is used to create a string out of the characters in the fileContent array		
					StringBuilder sb = new StringBuilder();		
							x=d;//x is set at d so that we can continue to go through the fileContent array where we left off after making the last string
							while(x<=g){
								Sentinal=false;//automatically sets the sentinal to false
								for(int q=0; q<6; q++){//q iterates so as to cover all possible special characters
									if((char)fileContent[x]==SpecialChars[q]){
										Sentinal=true;//sentinal is true, this thing is a special character.
									}
								}
								if(Sentinal==false){ //this way, only nonspecial characters are appended to the string
									sb.append((char)fileContent[x]);//adds current nonspecial character to the stringbuilder
								}	
								x++;//iterate x
							}
							InputArray[x] = sb.toString();//save the stringbuilder string into the InputArray Location
							System.out.println(InputArray[x]);//testing
							d=x;//d is set at x, so that we may reference it next loop.	
				}				
		}
		//SUCCESS
	
	//TODO: Enumerate person and assets classes, and create arrays for each.
		//STUFF
	//TODO: Determine whether or not the string we have pertains to persons or assets
		boolean IsPerson;
		boolean IsAsset;
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
	//TODO: Based on what each is,  use methods to save delimetered strings into the correct spaces for whatever type the data is
		
	//TODO: Store the Persons and Assets data into a JSON file.
		
}
	
}