package dataConverter;

public class Broker extends Persons{
		private String TypeOfBroker;
		private String SECcode;
		
		
		public Broker(String PersonCode, Name Name, Address address, String email, String fullLine){
			super(PersonCode, Name, address, email);
			String delim = ",";
			String[] pieces = new String[2];
			for(int i=0;i<2;i++){
				pieces = fullLine.split(delim);
			}
			this.TypeOfBroker = pieces[0];
			this.SECcode = pieces[1];
		}
		
		public String getTypeOfBroker() {
			return TypeOfBroker;
		}
		public void setTypeOfBroker(String typeOfBroker) {
			TypeOfBroker = typeOfBroker;
		}
		public String getSECcode() {
			return SECcode;
		}
		public void setSECcode(String sECcode) {
			SECcode = sECcode;
		}
		
}
