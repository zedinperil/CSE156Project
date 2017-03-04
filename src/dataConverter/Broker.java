package dataConverter;

import java.util.StringTokenizer;
//broker is an extension of person
public class Broker extends Persons{
//secidentifier and type are variables used specifically by brokers.
	private String secIdentifier;
		private String Type;
		//constructor
		public Broker(String Code, String TypeofPerson, String Name, String address, String email){
			super(Code, Name, address, email);
			//string tokenizer used to delimeter typeofperson string on commas, and return type followed by secidentifier. else statements are for cases in which for whatever reason a broker lacks either of those things.
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
	 
		}
		//simple getters and setters for secidentifier and type.
		public String getSecIdentifier() {
			return secIdentifier;
		}

		public void setSecIdentifier(String secIdentifier) {
			this.secIdentifier = secIdentifier;
		}

		public String getType() {
			return Type;
		}

		public void setType(String type) {
			Type = type;
		}
	
	
}
