package dataConverter;

public class Broker extends Persons{
		private String TypeOfBroker;
		private String SECcode;
		
		
		public Broker(String Code, String Type, String Name, String address, String email){
			super(Code, Type, Name, address, email);
			String delim = ",";
			String[] pieces = new String[2];
			for(int i=0;i<2;i++){
				
			}
			this.TypeOfBroker = pieces[0];
			this.SECcode = pieces[1];
		}
		
		public String getTypeOfBroker() {
			return TypeOfBroker;
		}
	
		public String getSECcode() {
			return SECcode;
		}
	
		
}
