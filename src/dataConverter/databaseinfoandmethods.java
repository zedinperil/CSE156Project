package dataConverter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mysql.*;
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
	
}
