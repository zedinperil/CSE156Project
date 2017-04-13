package dataConverter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//This will be where our jdbc will be done, bringing in our sql data from the previous assignment and storing it for later output use
//The plan is to read 2 querries, one that will gather all the data from the Assets, and the gathering portfolio information and names of 
//owners, managers, and beneficiaries. Both of these will be stored into arraylists.
public interface databaseinfoandmethods {
	//these there strings simply store login information so we can access the mysql database
	public static final String url = "jdbc:mysql://cse.unl.edu/tzinsmaster";
	public static final String username = "tzinsmaster";
	public static final String password = "c8Mxbo";
	public static Connection connectionMethod(){
		//this method is just to save some clutter.  It will make a connection for us when called
		Connection conn = null;
		//we will try to create a connection with the server, if a connection fails, a runtime exception is thrown
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}	
		return conn;
	}
	public static List<Portfolio> getPortfolios(){
		//this method will get store the information we need for portfolios.	
		//these are a series of try catch statements meant to catch fatal errors.  It will help us for bug testing tremendously
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException e) {
			System.out.println("InstantiationException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			System.out.println("IllegalAccessException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		//calling our method to create a connection
		Connection conn = connectionMethod();
		//this is our portfolio querry. It gathers all portfolio information, along with the names for the codes to eliminate the need to 
		//generate a person arraylist for information
		String query =  "select p.portfolioCode, p.portfolioId, q.personCode as OwnerCode, m.personCode as ManagerCode, b.personCode as BeneficiaryCode, q.lastName as OwnerLastName, q.firstName as OwnerFirstName, m.lastName as ManagerLastName, m.firstName as ManagerFirstName, m.persontype as ManagerType, b.lastName as BeneficiaryLastName, b.firstName as BeneficiaryFirstName, p.fees, p.aggRisk, p.commissions, p.totalValue, p.sumOfAnnualReturns from Portfolio p join Person q on q.personId=p.ownerId LEFT JOIN Person m on m.personId=p.managerId LEFT JOIN Person b on b.personId=p.beneficiaryId;";
		//declare a new portfolio arraylist
		List<Portfolio> portfolios= new ArrayList<Portfolio>();
		//declare a result set and preparedstatement to use the querry and get the information
	PreparedStatement ps = null;
	ResultSet rs = null;
	//this try statement will execute the query.  Using this, we are able to define our variables and store the variables into an a new 
	//portfolio object. Then we store the object into the arraylist.
	try {
		ps = conn.prepareStatement(query);
		rs = ps.executeQuery();
		while(rs.next()) {
			String PortfolioCode = rs.getString("portfolioCode");
			String OwnerLastName = rs.getString("OwnerLastName");
			String ownerCode= rs.getString("OwnerCode");
			String managerCode= rs.getString("ManagerCode");
			String beneficiaryCode= rs.getString("BeneficiaryCode");
			String OwnerFirstName = rs.getString("OwnerFirstName");
			String managerType= rs.getString("ManagerType");
			String ManagerLastName = rs.getString("ManagerLastName");
			String ManagerFirstName = rs.getString("ManagerFirstName");
			String BeneficiaryLastName = rs.getString("BeneficiaryLastName");
			String BeneficiaryFirstName = rs.getString("BeneficiaryFirstName");
			double fees= rs.getDouble("fees");
			double AggRisk= rs.getDouble("aggRisk");
			double commissions= rs.getDouble("commissions");
			double totalValue= rs.getDouble("totalValue");
			double sumOfAnnualReturns= rs.getDouble("sumOfAnnualReturns");
			Portfolio port = new Portfolio(PortfolioCode, ownerCode, managerCode, beneficiaryCode);
			port.setOwnerName(OwnerFirstName+" "+OwnerLastName);
			port.setManagerName(ManagerFirstName+" "+ManagerLastName);
			port.setManagerType(managerType);
			port.setBeneficiaryName(BeneficiaryFirstName+" "+BeneficiaryLastName);
			port.setFees(fees);
			port.setAggRisk(AggRisk);
			port.setCommissions(commissions);
			port.setTotalValue(totalValue);
			port.setSumOfAnnualReturns(sumOfAnnualReturns);
			portfolios.add(port);
		} 
		//close the result set and preparedstatement
		rs.close();
		ps.close();
		//catch a potential fatal error
		}catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	//return the portfolio arraylist
	return portfolios;
	}
	//this is a very similar method. We are gathering all the data for assets
	public static List<Asset> getAssets(){
		//these are a series of try catch statements meant to catch fatal errors.  It will help us for bug testing tremendously
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException e) {
			System.out.println("InstantiationException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			System.out.println("IllegalAccessException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}	
		//call connection method
		Connection conn = connectionMethod();;
		//this query will gather all the asset information
		String query = "select p.portfolioCode, L.assetCode, L.assetName, L.assetType, a.assetValue, a.returnRate, a.annualReturn, a.risk, a.assetModifier from Assets a JOIN Portfolio p ON p.portfolioId = a.portfolioId JOIN AssetsList L ON L.assetListId = a.assetListId;";
		//declare a new array list of type asset
	List<Asset> assets= new ArrayList<Asset>();	
		//new ps and rs
	PreparedStatement ps = null;
	ResultSet rs = null;
	//this try statement will execute the query.  Using this, we are able to define our variables and store the variables into an a new 
		//asset object. Then we store the object into the arraylist.
	try {
		ps = conn.prepareStatement(query);
		rs = ps.executeQuery();
		while(rs.next()) {
			String assetPortfolioCode = rs.getString("portfolioCode");
			String assetCode = rs.getString("assetCode");
			String assetName = rs.getString("assetName");
			String assetType  = rs.getString("assetType");
			double assetValue = rs.getDouble("assetValue");
			double returnRate = rs.getDouble("returnRate");
			double annualReturn = rs.getDouble("annualReturn");
			double risk = rs.getDouble("risk");
			double assetModifier = rs.getDouble("assetModifier");
			//remake assets
			if(assetType.equals("P")){
				Asset a= new PrivateInvestment()
			}
			if(assetType.equals("S")){
				Asset a= new  Stock()
			}
			if(assetType.equals("D")){
				Asset a = new Deposit()
			}
			
			
			Asset a = new Asset(assetPortfolioCode, assetCode, assetName, assetType, assetValue, returnRate, annualReturn, risk, assetModifier);
			assets.add(a);
		}
		//close ps and rs
		rs.close();
		ps.close();
		//catch any fatal erros in the sql
	} catch (SQLException e) {
		System.out.println("SQLException: ");
		e.printStackTrace();
		throw new RuntimeException(e);
	}
	//return the asset arraylist
	return assets;
	}
	
	
	//this is a very similar method. We are gathering all the data for persons
		public static List<Persons> getPersons(){
			//these are a series of try catch statements meant to catch fatal errors.  It will help us for bug testing tremendously
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
			} catch (InstantiationException e) {
				System.out.println("InstantiationException: ");
				e.printStackTrace();
				throw new RuntimeException(e);
			} catch (IllegalAccessException e) {
				System.out.println("IllegalAccessException: ");
				e.printStackTrace();
				throw new RuntimeException(e);
			} catch (ClassNotFoundException e) {
				System.out.println("ClassNotFoundException: ");
				e.printStackTrace();
				throw new RuntimeException(e);
			}	
			//call connection method
			Connection conn = connectionMethod();
			//this query will gather all the persons information
			String query = "select p.personCode, p.firstName, p.lastName, p.persontype, p.secId, p.street, p.city, p.state, p.country, p.zip from persons p;";
			//declare a new array list of type persons
		List<Persons> persons= new ArrayList<Persons>();	
			//new ps and rs
		PreparedStatement ps = null;
		ResultSet rs = null;
		//this try statement will execute the query.  Using this, we are able to define our variables and store the variables into an a new 
			//persons object. Then we store the object into the arraylist.
		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {

//create table Person (
//  personId integer not null primary key auto_increment,
//  #primary key is auto incremented, the work is done for us and gurantees no repeats
//  #basic data, personCode must be unique and everyone must have names
//  personCode varchar(10) not null unique,
//  firstName varchar(10) not null,
//  lastName varchar(50) not null,
//  persontype varchar(50),
//  secId varchar(15),
//  street varchar(100),
//  city varchar(70),
//  state varchar(2),
//  country varchar(50),
//  zip varchar(10)
//);

				String personCode = rs.getString("personCode");
				String firstName = rs.getString("lastName");
				String lastName = rs.getString("lastName");
				String street = rs.getString("street");
				String city = rs.getString("city");
				String state =rs.getString("state");
				String zip =rs.getString("zip");
				String country =rs.getString("country");
				String brokerType = rs.getString("persontype");
				String secBrokerId = rs.getString("secId");
		
				//remake persons
				Persons p= new Persons(personCode,firstName,lastName,street,city,state,zip,country,brokerType,secBrokerId);
				persons.add(p);
			}
			//close ps and rs
			rs.close();
			ps.close();
			//catch any fatal erros in the sql
		} catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		//return the persons arraylist
		return persons;
		}
		
		
		//this is a very similar method. We are gathering all the data for Deposits
		public static List<Deposit> getDeposits(){
			//these are a series of try catch statements meant to catch fatal errors.  It will help us for bug testing tremendously
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
			} catch (InstantiationException e) {
				System.out.println("InstantiationException: ");
				e.printStackTrace();
				throw new RuntimeException(e);
			} catch (IllegalAccessException e) {
				System.out.println("IllegalAccessException: ");
				e.printStackTrace();
				throw new RuntimeException(e);
			} catch (ClassNotFoundException e) {
				System.out.println("ClassNotFoundException: ");
				e.printStackTrace();
				throw new RuntimeException(e);
			}	
			//call connection method
			Connection conn = connectionMethod();;
			//this query will gather all the Deposit information
			String query = "select p.portfolioCode, L.DepositCode, L.DepositName, L.DepositType, a.DepositValue, a.returnRate, a.annualReturn, a.risk, a.DepositModifier from Deposits a JOIN Portfolio p ON p.portfolioId = a.portfolioId JOIN DepositsList L ON L.DepositListId = a.DepositListId;";
			//declare a new array list of type Deposit
		List<Deposit> Deposits= new ArrayList<Deposit>();	
			//new ps and rs
		PreparedStatement ps = null;
		ResultSet rs = null;
		//this try statement will execute the query.  Using this, we are able to define our variables and store the variables into an a new 
			//Deposit object. Then we store the object into the arraylist.
//		public static void addDepositAccount(String assetCode, String label, double apr) {}
//		create table Deposit (
//				  depositId int not null primary key auto_increment,
//				  assetListId int not null,
//				  FOREIGN KEY (assetListId) REFERENCES AssetsList(assetListId),
//				  apr double not null
//				  );
		
		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				String DepositPortfolioCode = rs.getString("portfolioCode");
				String DepositCode = rs.getString("DepositCode");
				String DepositName = rs.getString("DepositName");
				String DepositType  = rs.getString("DepositType");
				double DepositValue = rs.getDouble("DepositValue");
				double returnRate = rs.getDouble("returnRate");
				double annualReturn = rs.getDouble("annualReturn");
				double risk = rs.getDouble("risk");
				double DepositModifier = rs.getDouble("DepositModifier");
				//remake Deposits
				Deposit a = new Deposit(DepositPortfolioCode, DepositCode, DepositName, DepositType, DepositValue, returnRate, annualReturn, risk, DepositModifier);
				Deposits.add(a);
			}
			//close ps and rs
			rs.close();
			ps.close();
			//catch any fatal erros in the sql
		} catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		//return the Deposit arraylist
		return Deposits;
		}
		
		
		//this is a very similar method. We are gathering all the data for Stocks
		public static List<Stock> getStocks(){
			//these are a series of try catch statements meant to catch fatal errors.  It will help us for bug testing tremendously
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
			} catch (InstantiationException e) {
				System.out.println("InstantiationException: ");
				e.printStackTrace();
				throw new RuntimeException(e);
			} catch (IllegalAccessException e) {
				System.out.println("IllegalAccessException: ");
				e.printStackTrace();
				throw new RuntimeException(e);
			} catch (ClassNotFoundException e) {
				System.out.println("ClassNotFoundException: ");
				e.printStackTrace();
				throw new RuntimeException(e);
			}	
			//call connection method
			Connection conn = connectionMethod();;
			//this query will gather all the Stock information
			String query = "select p.portfolioCode, L.StockCode, L.StockName, L.StockType, a.StockValue, a.returnRate, a.annualReturn, a.risk, a.StockModifier from Stocks a JOIN Portfolio p ON p.portfolioId = a.portfolioId JOIN StocksList L ON L.StockListId = a.StockListId;";
			//declare a new array list of type Stock
		List<Stock> Stocks= new ArrayList<Stock>();	
			//new ps and rs
		PreparedStatement ps = null;
		ResultSet rs = null;
		//this try statement will execute the query.  Using this, we are able to define our variables and store the variables into an a new 
			//Stock object. Then we store the object into the arraylist.
///		public static void addStock(String assetCode, String label, Double quarterlyDividend, 
//				Double baseRateOfReturn, Double beta, String stockSymbol, Double sharePrice) {}
//		create table Stock (
//				  stockId int not null primary key auto_increment,
//				  assetListId int not null,
//				  FOREIGN KEY (assetListId) REFERENCES AssetsList(assetListId),
//				  quarterlyDividend double not null,
//				  baseRateOfReturn double not null,
//				  betaMeasure double not null,
//				  stockSymbol varchar(10) not null,
//				  sharePrice double not null
//				  );
		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				String StockPortfolioCode = rs.getString("portfolioCode");
				String StockCode = rs.getString("StockCode");
				String StockName = rs.getString("StockName");
				String StockType  = rs.getString("StockType");
				double StockValue = rs.getDouble("StockValue");
				double returnRate = rs.getDouble("returnRate");
				double annualReturn = rs.getDouble("annualReturn");
				double risk = rs.getDouble("risk");
				double StockModifier = rs.getDouble("StockModifier");
				//remake Stocks
				Stock a = new Stock(StockPortfolioCode, StockCode, StockName, StockType, StockValue, returnRate, annualReturn, risk, StockModifier);
				Stocks.add(a);
			}
			//close ps and rs
			rs.close();
			ps.close();
			//catch any fatal erros in the sql
		} catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		//return the Stock arraylist
		return Stocks;
		}
		
		
		//this is a very similar method. We are gathering all the data for PrivateInvestments
		public static List<PrivateInvestment> getPrivateInvestments(){
			//these are a series of try catch statements meant to catch fatal errors.  It will help us for bug testing tremendously
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
			} catch (InstantiationException e) {
				System.out.println("InstantiationException: ");
				e.printStackTrace();
				throw new RuntimeException(e);
			} catch (IllegalAccessException e) {
				System.out.println("IllegalAccessException: ");
				e.printStackTrace();
				throw new RuntimeException(e);
			} catch (ClassNotFoundException e) {
				System.out.println("ClassNotFoundException: ");
				e.printStackTrace();
				throw new RuntimeException(e);
			}	
			//call connection method
			Connection conn = connectionMethod();;
			//this query will gather all the PrivateInvestment information
			String query = "select p.portfolioCode, L.PrivateInvestmentCode, L.PrivateInvestmentName, L.PrivateInvestmentType, a.PrivateInvestmentValue, a.returnRate, a.annualReturn, a.risk, a.PrivateInvestmentModifier from PrivateInvestments a JOIN Portfolio p ON p.portfolioId = a.portfolioId JOIN PrivateInvestmentsList L ON L.PrivateInvestmentListId = a.PrivateInvestmentListId;";
			//declare a new array list of type PrivateInvestment
		List<PrivateInvestment> PrivateInvestments= new ArrayList<PrivateInvestment>();	
			//new ps and rs
		PreparedStatement ps = null;
		ResultSet rs = null;
		//this try statement will execute the query.  Using this, we are able to define our variables and store the variables into an a new 
			//PrivateInvestment object. Then we store the object into the arraylist.
		
		//	public static void addPrivateInvestment(String assetCode, String label, Double quarterlyDividend, 
		//			Double baseRateOfReturn, Double baseOmega, Double totalValue) {}
//		create table PrivateInvestment (
//				  privateInvestmentId int not null primary key auto_increment,
//				  assetListId int not null,
//				  FOREIGN KEY (assetListId) REFERENCES AssetsList(assetListId),
//				  quarterlyDividend double not null,
//				  baseRateOfReturn double not null,
//				  omegaMeasure double not null,
//				  pValue double not null
//				  );
		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				String PrivateInvestmentPortfolioCode = rs.getString("portfolioCode");
				String PrivateInvestmentCode = rs.getString("PrivateInvestmentCode");
				String PrivateInvestmentName = rs.getString("PrivateInvestmentName");
				String PrivateInvestmentType  = rs.getString("PrivateInvestmentType");
				double PrivateInvestmentValue = rs.getDouble("PrivateInvestmentValue");
				double returnRate = rs.getDouble("returnRate");
				double annualReturn = rs.getDouble("annualReturn");
				double risk = rs.getDouble("risk");
				double PrivateInvestmentModifier = rs.getDouble("PrivateInvestmentModifier");
				//remake PrivateInvestments
				PrivateInvestment a = new PrivateInvestment(PrivateInvestmentPortfolioCode, PrivateInvestmentCode, PrivateInvestmentName, PrivateInvestmentType, PrivateInvestmentValue, returnRate, annualReturn, risk, PrivateInvestmentModifier);
				PrivateInvestments.add(a);
			}
			//close ps and rs
			rs.close();
			ps.close();
			//catch any fatal erros in the sql
		} catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		//return the PrivateInvestment arraylist
		return PrivateInvestments;
		}
		
}
