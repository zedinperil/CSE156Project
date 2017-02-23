package dataConverter;

import java.util.StringTokenizer;

public class Broker extends Persons{
	
		public Broker(String Code, String TypeofPerson, String Name, String address, String email){
			super(Code, TypeofPerson, Name, address, email);
			StringTokenizer tokenizer= new StringTokenizer(TypeofPerson, ",");
			if(tokenizer.hasMoreTokens()){		
				this.Type = tokenizer.nextToken();
				
				if(tokenizer.hasMoreTokens()){
					this.secIdentifier = tokenizer.nextToken();
				}
				else{
					this.secIdentifier="";
				}
			}
			else{
				this.Type="";
				this.secIdentifier="";
			}
	 
			this.Name= new Name(name);
		}
		
	
}
