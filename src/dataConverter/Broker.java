package dataConverter;

public class Broker extends Persons{
		private String TypeOfBroker;
		private String SECcode;
		public BrokerType getTypeOfBroker() {
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
