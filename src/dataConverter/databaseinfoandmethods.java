package dataConverter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import unl.cse.albums.Album;
import unl.cse.albums.Band;
import unl.cse.albums.DatabaseInfo;

public class databaseinfoandmethods {

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
	
	public static int getAssets(){
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
		
		String query = "select L.assetCode, L.assetName, L.assetType, a.assetValue, a.returnRate, a.annualReturn, a.risk, a.assetModifier"+
		"from Assets a JOIN Portfolio p ON p.portfolioId = a.portfolioId JOIN AssetsList L ON L.assetListId = a.assetListId Join Person q on"+
		"q.personId=p.ownerId join Person m on m.personId=p.managerId join Person b on b.personId=p.beneficiaryId where a.assetId=?";

		
	PreparedStatement ps = null;
	ResultSet rs = null;

	try {
		ps = conn.prepareStatement(query);
		ps.setInt(1, assetId);
		rs = ps.executeQuery();
		if(rs.next()) {
			String assetCode = rs.getString("assetCode");
			String assetName = rs.getString("assetName");
			String assetType  = rs.getString("assetType");
			String assetValue = rs.getString("assetValue");
			String returnRate = rs.getString("returnRate");
			String annualReturn = rs.getString("annualReturn");
			String risk = rs.getString("risk");
			String assetModifier = rs.getString("assetModifier");
			//remake assets
			a = new Assets(albumId, albumTitle, albumYear, b, albumNumber);
		} else {
			throw new IllegalStateException("No such asset in database with id = " + albumId);
		}
		rs.close();
		ps.close();
	} catch (SQLException e) {
		System.out.println("SQLException: ");
		e.printStackTrace();
		throw new RuntimeException(e);
	}
	


	return a;
	}
 select p.portfolioCode, p.portfolioId, p.ownerId, q.lastName as OwnerLastName, q.firstName as OwnerFirstName, m.lastName as ManagerLastName, m.firstName as ManagerFirstName, m.persontype, b.lastName as BeneficiaryLastName, b.firstName as BeneficiaryFirstName, p.managerId, p.beneficiaryId, p.fees, p.commissions, p.totalValue, p.sumOfAnnualReturns, p.aggRisk, L.assetCode, L.assetName, L.assetType, a.assetValue, a.returnRate, a.annualReturn, a.risk, a.assetModifier from Assets a JOIN Portfolio p ON p.portfolioId = a.portfolioId
	JOIN AssetsList L ON L.assetListId = a.assetListId Join Person q on q.personId=p.ownerId join Person m on m.personId=p.managerId join Person b on b.personId=p.beneficiaryId;

	public static ArrayList<Assets> getAssets(){
		ArrayList<Assets> AssetsList= new ArrayList<Assets>();
		select L.assetCode, L.assetName, L.assetType, a.assetValue, a.returnRate, a.annualReturn, a.risk, a.assetModifier from Assets a JOIN Portfolio p ON p.portfolioId = a.portfolioId
		 JOIN AssetsList L ON L.assetListId = a.assetListId Join Person q on q.personId=p.ownerId join Person m on m.personId=p.managerId join Person b on b.personId=p.beneficiaryId;

		
		
		return AssetsList;
	}
	 

}
