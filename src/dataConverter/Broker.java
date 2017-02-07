package dataConverter;

public class Broker extends Persons{
		private BrokerType TypeOfBroker;
		private String SECcode;
		public BrokerType getTypeOfBroker() {
			return TypeOfBroker;
		}
		public void setTypeOfBroker(BrokerType typeOfBroker) {
			TypeOfBroker = typeOfBroker;
		}
		public String getSECcode() {
			return SECcode;
		}
		public void setSECcode(String sECcode) {
			SECcode = sECcode;
		}
		
}
