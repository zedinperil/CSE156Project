package dataConverter;

public class Portfolio {
	private String PortfolioCode;
	private String OwnerCode;
	private String ManagerCode;
	private String BeneficiaryCode;
	private String Assetss;
	private Assets[][] Ass;
	private Persons[][] Per;
	
	public Portfolio(String portCode, String ownCode, String managCode, String beneficiaryCode, 
					 String assetsA, Persons[][] persons, Assets[][] asset) {
		super();
		
		this.PortfolioCode = portCode;
		this.OwnerCode = ownCode;
		this.ManagerCode = managCode;
		this.BeneficiaryCode = beneficiaryCode;
		this.Assetss = assetsA;
		this.Ass = asset;
		this.Per = persons;
		

		
	}


	public String getPortfolioCode() {
		return PortfolioCode;
	}

	public void setPortfolioCode(String portfolioCode) {
		PortfolioCode = portfolioCode;
	}

	public String getOwnerCode() {
		return OwnerCode;
	}

	public void setOwnerCode(String ownerCode) {
		OwnerCode = ownerCode;
	}

	public String getManagerCode() {
		return ManagerCode;
		
	}

	public void setManagerCode(String managerCode) {
		ManagerCode = managerCode;
	}

	public String getBeneficiaryCode() {
		return BeneficiaryCode;
	}

	public void setBeneficiaryCode(String beneficiaryCode) {
		BeneficiaryCode = beneficiaryCode;
	}

	public String getAssets() {
		return Assets;
	}

	public void setAssets(String assets) {
		Assets = assets;
	}

	

	
}	