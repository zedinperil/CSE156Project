package dataConverter;

public class Assets {
	private String input;
	private String TypeOfAsset;
	private Deposit DepositAccount;
	private Stock Stocks;
	private PrivateInvestment PrivateInvestments;
	public Assets(String string, String string2, String string3, String string4, String string5, String string6,
			String string7) {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the input
	 */
	public String getInput() {
		return input;
	}
	/**
	 * @param input the input to set
	 */
	public void setInput(String input) {
		this.input = input;
	}
	/**
	 * @return the typeOfAsset
	 */
	public String getTypeOfAsset() {
		return TypeOfAsset;
	}
	/**
	 * @param typeOfAsset the typeOfAsset to set
	 */
	public void setTypeOfAsset(String typeOfAsset) {
		TypeOfAsset = typeOfAsset;
	}
	/**
	 * @return the depositAccount
	 */
	public Deposit getDepositAccount() {
		return DepositAccount;
	}
	/**
	 * @param depositAccount the depositAccount to set
	 */
	public void setDepositAccount(Deposit depositAccount) {
		DepositAccount = depositAccount;
	}
	/**
	 * @return the stocks
	 */
	public Stock getStocks() {
		return Stocks;
	}
	/**
	 * @param stocks the stocks to set
	 */
	public void setStocks(Stock stocks) {
		Stocks = stocks;
	}
	/**
	 * @return the privateInvestments
	 */
	public PrivateInvestment getPrivateInvestments() {
		return PrivateInvestments;
	}
	/**
	 * @param privateInvestments the privateInvestments to set
	 */
	public void setPrivateInvestments(PrivateInvestment privateInvestments) {
		PrivateInvestments = privateInvestments;
	}
}
