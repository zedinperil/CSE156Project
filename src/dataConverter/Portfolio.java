package dataConverter;

public class Portfolio {
	private String PortfolioCode;
	private String OwnerCode;
	private String ManagerCode;
	private String BeneficiaryCode;
	private String Asset;
	private Assets[][] Ass;
	private Persons[][] Per;
	
	private double fees;
	private double commisions;
	
	private double Risk;
	private double Value;
	private double AnnualReturn;
	private double ReturnRate;
	
	private double AggRisk;
	private int personcount;
	private int assetcount;
	
	public Portfolio(String portCode, String ownCode, String managCode, String beneficiaryCode, 
					 String assetsA, Persons[][] persons, Assets[][] asset, int PersonsCount, int AssetsCount) {
		super();
		
		this.PortfolioCode = portCode;
		this.OwnerCode = ownCode;
		this.ManagerCode = managCode;
		this.BeneficiaryCode = beneficiaryCode;
		this.Asset = assetsA;
		this.Ass = asset;
		this.Per = persons;
		this.personcount = PersonsCount;
		this.assetcount = AssetsCount;
		

		
	}

	public String getPortfolioCode() {
		return PortfolioCode;
	}

	public String getOwnerCode() {
		return OwnerCode;
	}

	public String getManagerCode() {
		return ManagerCode;
	}

	public String getBeneficiaryCode() {
		return BeneficiaryCode;
	}

	public String getAsset() {
		return Asset;
	}

	public Assets[][] getAss() {
		return Ass;
	}

	public Persons[][] getPer() {
		return Per;
	}

	public double getFees() {
		return fees;
	}

	public double getCommisions() {
		return commisions;
	}

	public double getRisk() {
		for(int i=0; i<2; i++){
			for(int k=0; k<=assetcount; k++){
				if(Ass[i][k].getType().contains("P")){
					if(Ass[i][k].getCode().equals())
					Riskp= Ass[i][k].getOmegaMeasure()+ exp(e,(-100000/(Ass[i][k].getTotalValue()*PercentOwned)));
				}
			}
		}
		
		return Risk;
	}

	public double getValue() {
		return Value;
	}

	public double getAnnualReturn() {
		return AnnualReturn;
	}

	public double getReturnRate() {
		return ReturnRate;
	}

	public double getAggRisk() {
		return AggRisk;
	}

	public int getPersoncount() {
		return personcount;
	}

	public int getAssetcount() {
		return assetcount;
	}


	
	

	
}	