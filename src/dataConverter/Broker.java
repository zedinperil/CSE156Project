package dataConverter;

import java.util.StringTokenizer;

public class Broker extends Persons{

	private String secIdentifier;
		private String Type;
		
		public Broker(String Code, String TypeofPerson, String Name, String address, String email){
			super(Code, Name, address, email);
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
