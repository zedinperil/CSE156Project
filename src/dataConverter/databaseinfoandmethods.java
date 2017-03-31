package dataConverter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mysql.*;

public interface databaseinfoandmethods {

	public static final String url = "jdbc:mysql://cse.unl.edu/tzinsmaster";
	public static final String username = "tzinsmaster";
	public static final String password = "c8Mxbo";
	
	public static Connection connectionMethod(){
		
		Connection conn = null;

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
		
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(url, username,password);
		} catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		String query =  "select p.portfolioCode, p.portfolioId, q.personCode as OwnerCode, m.personCode as ManagerCode, b.personCode as BeneficiaryCode,s q.lastName as OwnerLastName, q.firstName as OwnerFirstName,"
				+ " m.lastName as ManagerLastName, m.firstName as ManagerFirstName, m.persontype as ManagerType, b.lastName as BeneficiaryLastName, b.firstName as BeneficiaryFirstName,"
				+ " p.fees, p.aggRisk, p.commissions, p.totalValue, p.sumOfAnnualReturns from Portfolio p"
				+ " join Person q on q.personId=p.ownerId join Person m on m.personId=p.managerId join Person b on b.personId=p.beneficiaryId";
		
		List<Portfolio> portfolios= new ArrayList<Portfolio>();
		
	PreparedStatement ps = null;
	ResultSet rs = null;

	try {
		ps = conn.prepareStatement(query);
		rs = ps.executeQuery();
		if(rs.next()) {
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
		} else {
			throw new IllegalStateException("No such Portfolios in database");
		}
		rs.close();
		ps.close();
	} catch (SQLException e) {
		System.out.println("SQLException: ");
		e.printStackTrace();
		throw new RuntimeException(e);
	}
	return portfolios;
	}
	
	public static List<Asset> getAssets(){
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
		
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(url, username,password);
		} catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		String query = "select p.portfolioCode L.assetCode, L.assetName, L.assetType, a.assetValue, a.returnRate, a.annualReturn, a.risk, a.assetModifier"+
		"from Assets a JOIN Portfolio p ON p.portfolioId = a.portfolioId JOIN AssetsList L ON L.assetListId = a.assetListId Join Person q on"+
		"q.personId=p.ownerId join Person m on m.personId=p.managerId join Person b on b.personId=p.beneficiaryId";

	List<Asset> assets= new ArrayList<Asset>();	
	PreparedStatement ps = null;
	ResultSet rs = null;
	
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
		} else {
			throw new IllegalStateException("No such asset in database with asset ");
		}
		rs.close();
		ps.close();
	} catch (SQLException e) {
		System.out.println("SQLException: ");
		e.printStackTrace();
		throw new RuntimeException(e);
	}
	


	return assets;
	}
 
}
