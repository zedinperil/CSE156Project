//hey this is alex and tyler
//hello again
package dataConverter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
//import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import java.util.Scanner;
import java.io.BufferedReader;

public class InputOutput {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {		
		int NumOfFiles= args.length;
		String[] fileName = new String[NumOfFiles];
		int i=0;
		int g=0;
		int x = 0;
		int k = 0;	
		int[] size= new int[NumOfFiles];
		int NumberOfLines[]= new int[NumOfFiles];
		int sizable=0;
		int[] NumOfChars= new int[10000];
		for(i=0; i<NumOfFiles; i++){
			fileName[i]=args[i];
			BufferedReader Buff = new BufferedReader(new FileReader(args[i]));
	        String text = Buff.readLine();
	        size[i] = Integer.parseInt(text);
	        size[i] += 1;
	        sizable += size[i];
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
			//System.out.println(line);
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
	//TODO: Determine whether or not the string we have pertains to persons or assets
		boolean[] IsPerson=new boolean[NumOfFiles];
		boolean[] IsAsset=new boolean[NumOfFiles];
		boolean[][]DontAddBlankEmail=new boolean[NumOfFiles][sizable];
		for(i=0; i<NumOfFiles; i++){
			for(x=0; x<sizable; x++){
				DontAddBlankEmail[i][x]=false;
			}
		}
	String DelimeteredData[][][]= new String[NumOfFiles][1000][5];
		for(i=0; i<NumOfFiles; i++){

			if(fileName[i].contains("Persons.dat")||fileName[i].contains("persons.dat")){
			System.out.println("ITS A PERSON");
			IsPerson[i]=true;
			
			}
			else if(fileName[i].contains("Assets.dat")||fileName[i].contains("assets.dat")){
			System.out.println("ITS AN ASSET");
			IsAsset[i]=true;	
		
			}
			else{
			System.out.println("I HAVE NO IDEA WHAT THIS iS");
			}
		}
		//Persons[] PersonArray= new Persons[NumberOfLines];
		//Assets[] AssetsArray= new Assets[NumberOfLines];
	//TODO: Based on what each is,  use methods to save delimetered strings into the correct spaces for whatever type the data is
	int[][] NumberOfDelims= new int[NumOfFiles][1000];
	boolean test=false;
	int testing;
	for(i=0; i<NumOfFiles; i++){
		for( g=1; g<=NumberOfLines[i]; g++){
			for(x=0; x<NumOfChars[g]; x++){
			
				if(fullData[i][g].charAt(x)==';'){
					DelimeteredData[i][g-1]=fullData[i][g-1].split(";");	
					k++;
					test=true;
				}
				
				else if(x==(NumOfChars[g-1])-1 && fullData[i][g-1].lastIndexOf(";")!=NumOfChars[g-1]-1){
						DelimeteredData[i][g-1]=fullData[i][g-1].split(";");
						DontAddBlankEmail[i][g-1]=true;
						k++;	
						test=true;
				testing=g-1;
						System.out.println("g is:"+testing+ " and k is "+k);
				}
					
					NumberOfDelims[i][g-1]=k;
				//	System.out.println("x is:"+x);
				//	System.out.println("k is:"+k);
				//	System.out.println("g is:"+g);
				
				
				}	
//			if(test){
//				int q=0;
//				for(q=0; q<DelimeteredData[i][g-1].length; q++){
//					if(g-1>0)
//					System.out.println(DelimeteredData[i][g-1][q]);
//					
//					}
//				if(g-1>0)
//				System.out.println("Q is"+q);
//			}
			test=false;
			k=0;
		}

	}
	
		ObjectMapper jsonMapper = new ObjectMapper();


//testing to ensure it is saved correctly;	
		Persons[][] PersonArray= new Persons[NumOfFiles][1000];
		Assets[][] AssetsArray= new Assets[NumOfFiles][1000];
		String HasNoData= "";
		for(i=0; i<NumOfFiles; i++){
			for(g=1; g<NumberOfLines[i]; g++){
				for(x=0; x<NumberOfDelims[i][g]; x++){
					if(IsPerson[i]){
						if(DontAddBlankEmail[i][g]){
							if(DelimeteredData[i][g].length>4){
								System.out.println("G IS:" +g);
								PersonArray[i][g]= new Persons(DelimeteredData[i][g][0], DelimeteredData[i][g][1], DelimeteredData[i][g][2], DelimeteredData[i][g][3], DelimeteredData[i][g][4]);
							}
						}
						else{
							PersonArray[i][g]= new Persons(DelimeteredData[i][g][0], DelimeteredData[i][g][1], DelimeteredData[i][g][2], DelimeteredData[i][g][3], HasNoData);
						}
					}
					if(IsAsset[i]){
						if(DelimeteredData[i][g][1].contains("D,")){
							AssetsArray[i][g]= new Deposit(DelimeteredData[i][g][0], DelimeteredData[i][g][2], DelimeteredData[i][g][3], HasNoData, HasNoData, HasNoData, HasNoData);				
						}
						else if(DelimeteredData[i][g][1].contains("S,")){
							AssetsArray[i][g]= new Stock(DelimeteredData[i][g][0], DelimeteredData[i][g][2], DelimeteredData[i][g][3], DelimeteredData[i][g][4], DelimeteredData[i][g][5], DelimeteredData[i][g][6], DelimeteredData[i][g][7]);
						}
						else if(DelimeteredData[i][g][1].contains("P,")){
							AssetsArray[i][g]= new PrivateInvestment(DelimeteredData[i][g][0], DelimeteredData[i][g][2], DelimeteredData[i][g][3], DelimeteredData[i][g][4], DelimeteredData[i][g][5], DelimeteredData[i][g][6], HasNoData);
						}			
					}	
				}
			}
		}
	
	
	//TODO: Store the Persons and Assets data into a JSON file. FORMAT IT
//for(i=0; i<NumberOfLines; i++){
//	System.out.println( PersonArray[i].getStreet()+PersonArray[i].getCity()+PersonArray[i].getState()+PersonArray[i].getZipcode()+PersonArray[i].getCountry());
//}		
	for(i=0; i<NumOfFiles; i++){
//		for(g=0; g<NumberOfLines[i]; g++){
//		System.out.println(PersonArray[i][g]);
//		System.out.println(AssetsArray[i][g]);
//		}
		try {  
	
		       // Writing to a file   
		 
			 jsonMapper.writeValue(new File("./data/Persons.json"), PersonArray[i]);
		 
		 
			 jsonMapper.writeValue(new File("./data/Assets.json"), AssetsArray[i]);
		 
	
		    } catch (IOException e) {  
		        e.printStackTrace();  
		    }  
		}
	}

}
