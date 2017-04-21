package com.sdb; //DO NOT CHANGE THIS


// This is a collection of utility methods that define a general API for
// interacting with the database supporting this application.
//package unl.cse.financial;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;

// For the past 3 hours, my work partner and I have been trying to figure out an unresolved compilation error that happens when the webgrader clears all portfolios. We don't know why.
// We've tinkered endlessly with debugging, package stuff, and other things, and are frustrated to no end.
// All we want to know is what we are doing wrong. We just can't figure it out. Please, if you can just tell us where we went wrong on our grade sheet, we would be happy.
// it is so difficult to tell exactly what is wrong when it is the webgrader's main method which doesn't compile, and what should be a very simple method becomes the bane of our existence.
// If you would like us to demonstrate it at some point, I can show that our code would work with a test case, like we did a stage ago in the project. I don't know what in the world
// causes the unknown error code for java.lang. 
// With all this in mind, we recognize that we did not do proper checks for PortfolioData.java methods. We planned on doing that once we got the base functionality working, but alas, this was never to be.
// We do feel proud for our work in redoing everything else, from the database to our java program structure, to work well with the methods in PortfolioData, however. 
// It was a complete overhaul.

public class PortfolioData{
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
	public static void removeAllPersons() {

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
	//we will try to create a connection with the server, if a connection fails, a runtime exception is thrown
		String query = "truncate Person";
		String query2 = "truncate Portfolio";
		String query3 = "truncate Assets";
		String query4 = "truncate Emails";
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		PreparedStatement ps3 = null;
		PreparedStatement ps4 = null;
		try {
			conn=  connectionMethod();

			ps = conn.prepareStatement(query);
			ps.executeUpdate();
			ps.close();
			ps2 = conn.prepareStatement(query2);
			ps2.executeUpdate();
			ps2.close();
			ps3 = conn.prepareStatement(query3);
			ps3.executeUpdate();
			ps3.close();
			ps4 = conn.prepareStatement(query4);
			ps4.executeUpdate();
			conn.close();
			ps4.close();
			
		}catch(SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
			
		}
		
	}
				

	public static void removePerson(String personCode) {

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
		//we will try to create a connection with the server, if a connection fails, a runtime exception is thrown
			String query = "delete Emails from Emails where Emails.personId = '"+personCode+"'";
			String query2 = "DELETE Pesron FROM Person P WHERE P.personCode EQUALS '"+personCode+"'";
			String query3 = "DELETE p, a from Portfolio p join Assets a on p.portfolioCode=a.portfolioCode where p.ownerCode = '"+personCode+"'";
			String query4 = "delete Portfolio, Assets from Portfolio where Portfolio.managerCode = '"+personCode+"'";
			String query5 = "delete Portfolio, Assets from Portfolio where Portfolio.beneficiaryCode = '"+personCode+"'";
			
			PreparedStatement ps = null;
			PreparedStatement ps2 = null;
			PreparedStatement ps3 = null;
			PreparedStatement ps4 = null;
			PreparedStatement ps5 = null;
			
			try {
				conn=  connectionMethod();

				ps = conn.prepareStatement(query);
				ps2 = conn.prepareStatement(query2);
				ps3 = conn.prepareStatement(query3);
				ps4 = conn.prepareStatement(query4);
				ps5 = conn.prepareStatement(query5);
				ps.executeUpdate();
				ps2.executeUpdate();
				ps3.executeUpdate();
				ps4.executeUpdate();
				ps5.executeUpdate();
				conn.close();
				ps.close();
				ps2.close();
				ps3.close();
				ps4.close();
				ps5.close();
			}catch(SQLException e) {
				System.out.println("SQLException: ");
				e.printStackTrace();
				throw new RuntimeException(e);
				
			}
	}
	
	/**
	 * Method to add a person record to the database with the provided data. The
	 * <code>brokerType</code> will either be "E" or "J" (Expert or Junior) or 
	 * <code>null</code> if the person is not a broker.
	 * @param personCode
	 * @param firstName
	 * @param lastName
	 * @param street
	 * @param city
	 * @param state
	 * @param zip
	 * @param country
	 * @param brokerType
	 */
		
	public static void addPerson(String personCode, String firstName, String lastName, String street, String city, String state, String zip, String country, String brokerType, String secBrokerId) {
		if(personCode==null){
			personCode="None";
		}
		if(firstName==null){
			firstName="None";
		}
		if(lastName==null){
			lastName="None";
		}
		if(street==null){
			street="None";
		}
		if(city==null){
			city="None";
		}
		if(state==null){
			state="None";
		}
		if(zip==null){
			zip="None";
		}
		if(country==null){
			country="None";
		}
		if(brokerType==null){
			brokerType="None";
		}
		if(secBrokerId==null){
			secBrokerId="None";
		}


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
		//we will try to create a connection with the server, if a connection fails, a runtime exception is thrown

			String query = "insert into Person(personCode, firstName, lastName, persontype, secId, street, city, state, country, zip) values('"+personCode+"','"+firstName+"','"+lastName+"','"+brokerType+"','"+secBrokerId+"','"+street+"','"+city+"','"+state+"','"+country+"','"+zip+"');";
			PreparedStatement ps = null;
			try {
				conn=  connectionMethod();

				ps = conn.prepareStatement(query);
				ps.executeUpdate();
				conn.close();
				ps.close();
			}catch(SQLException e) {
				System.out.println("SQLException: ");
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		
	}
	
	/**
	 * Adds an email record corresponding person record corresponding to the
	 * provided <code>personCode</code>
	 * @param personCode
	 * @param email
	 */
	public static void addEmail(String personCode, String email) {
		if(personCode==null){
			personCode="None";
		}
		if(email==null){
			email="None";
		}
	

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
		//we will try to create a connection with the server, if a connection fails, a runtime exception is thrown


			String query = " insert into Emails(personCode, email) values ('"+personCode+"','"+email+"');";
			PreparedStatement ps = null;
			try {
				conn=  connectionMethod();

				ps = conn.prepareStatement(query);
				ps.executeUpdate();
				conn.close();
				ps.close();
			}catch(SQLException e) {
				System.out.println("SQLException: ");
				e.printStackTrace();
				throw new RuntimeException(e);
				
			}
		
	}

	/**
	 * Removes all asset records from the database
	 */
	public static void removeAllAssets() {

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

		//we will try to create a connection with the server, if a connection fails, a runtime exception is thrown

			String query = "truncate PrivateInvestment;";
			String query2= "truncate Stock;";
			String query3= "truncate Deposit;";
			String query4= "truncate AssetsList;";
			String query5= "truncate Assets;";
			
			PreparedStatement ps = null;
			PreparedStatement ps2= null;
			PreparedStatement ps3= null;
			PreparedStatement ps4= null;
			PreparedStatement ps5= null;
			try {
				conn=  connectionMethod();

				ps = conn.prepareStatement(query);
				ps2= conn.prepareStatement(query2);
				ps3= conn.prepareStatement(query3);
				ps4= conn.prepareStatement(query4);
				ps5= conn.prepareStatement(query5);
				ps.executeUpdate();
				ps2.executeUpdate();
				ps3.executeUpdate();
				ps4.executeUpdate();
				ps5.executeUpdate();
				conn.close();
				ps.close();
				ps2.close();
				ps3.close();
				ps4.close();
				ps5.close();
			}catch(SQLException e) {
				System.out.println("SQLException: ");
				e.printStackTrace();
				throw new RuntimeException(e);
				
			}
		
	}

	/**
	 * Removes the asset record from the database corresponding to the
	 * provided <code>assetCode</code>
	 * @param assetCode
	 */
	public static void removeAsset(String assetCode) {

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
		//we will try to create a connection with the server, if a connection fails, a runtime exception is thrown

			String query = "delete privateInvestment FROM PrivateInvestment WHERE privateInvestment.assetCode EQUALS '"+assetCode+"'";
			String query2 = "delete stock FROM Stock WHERE stock.assetCode EQUALS '"+assetCode+"'";
			String query3 = "delete deposit FROM Deposit WHERE deposit.assetCode EQUALS '"+assetCode+"'";
			String query4 = "delete AnAsset From AssetsList WHERE AnAsset.assetCode EQUALS '"+assetCode+"'";
			String query5 = "delete aAsset From Assets WHERE aAsset.assetCode EQUALS '"+assetCode+"'";
			PreparedStatement ps = null;
			PreparedStatement ps2 = null;
			PreparedStatement ps3 = null;
			PreparedStatement ps4 = null;
			PreparedStatement ps5 = null;
			try {
				conn=  connectionMethod();

				ps = conn.prepareStatement(query);
				ps2 = conn.prepareStatement(query2);
				ps3 = conn.prepareStatement(query3);
				ps4 = conn.prepareStatement(query4);
				ps5 = conn.prepareStatement(query5);
				
				ps.executeUpdate();
				ps2.executeUpdate();
				ps3.executeUpdate();
				ps4.executeUpdate();
				ps5.executeUpdate();
				conn.close();
				ps.close();
				ps2.close();
				ps3.close();
				ps4.close();
				ps5.close();
			}catch(SQLException e) {
				System.out.println("SQLException: ");
				e.printStackTrace();
				throw new RuntimeException(e);
				
			}
		
	}
	
	/**
	 * Adds a deposit account asset record to the database with the
	 * provided data. 
	 * @param assetCode
	 * @param label
	 * @param apr
	 */
	public static void addDepositAccount(String assetCode, String label, double apr) {
		if(assetCode==null){
			assetCode="None";
		}
		if(label==null){
			label="None";
		}

	
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
		//we will try to create a connection with the server, if a connection fails, a runtime exception is thrown
			
			String query = "insert into Deposit( assetCode, assetName, apr) values('"+assetCode+"', '"+label+"',"+apr+");";
			String query2= "insert into AssetsList(assetCode, assetType, assetName) values('"+assetCode+"','D','"+label+"');";
			PreparedStatement ps = null;
			PreparedStatement ps2= null;
			try {
				conn=  connectionMethod();
				ps = conn.prepareStatement(query);
				ps2 = conn.prepareStatement(query2);
				ps.executeUpdate();
				ps2.executeUpdate();
				conn.close();
				ps.close();
				ps2.close();
			}catch(SQLException e) {
				System.out.println("SQLException: ");
				e.printStackTrace();
				throw new RuntimeException(e);
				
			}
		
	}
	
	/**
	 * Adds a private investment asset record to the database with the
	 * provided data.  The <code>baseRateOfReturn</code> is assumed to be on the
	 * scale [0, 1].
	 * @param assetCode
	 * @param label
	 * @param quarterlyDividend
	 * @param baseRateOfReturn
	 * @param baseOmega
	 * @param totalValue
	 */
	public static void addPrivateInvestment(String assetCode, String label, Double quarterlyDividend, 
			Double baseRateOfReturn, Double baseOmega, Double totalValue) {
		if(assetCode==null){
			assetCode="None";
		}
		if(label==null){
			label="None";
		}
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
		//we will try to create a connection with the server, if a connection fails, a runtime exception is thrown
			String query = "insert into PrivateInvestment(assetCode, assetName, quarterlyDividend, baseRateOfReturn, omegaMeasure, pValue) values('"+assetCode+"','"+label+"',"+quarterlyDividend+","+baseRateOfReturn+","+baseOmega+","+totalValue+");";
			String query2= "insert into AssetsList(assetCode, assetType, assetName) values('"+assetCode+"','P','"+label+"');";

			PreparedStatement ps = null;
			PreparedStatement ps2=null;
			try {					
				conn=  connectionMethod();
				ps = conn.prepareStatement(query);
				ps2= conn.prepareStatement(query2);
				ps.executeUpdate();
				ps2.executeUpdate();
				conn.close();
				ps.close();
				ps2.close();
			}catch(SQLException e) {
				System.out.println("SQLException: ");
				e.printStackTrace();
				throw new RuntimeException(e);
				
			}
	}
	
	/**
	 * Adds a stock asset record to the database with the
	 * provided data.  The <code>baseRateOfReturn</code> is assumed to be on the 
	 * scale [0, 1].
	 * @param assetCode
	 * @param label
	 * @param quarterlyDividend
	 * @param baseRateOfReturn
	 * @param beta
	 * @param stockSymbol
	 * @param sharePrice
	 */
	public static void addStock(String assetCode, String label, Double quarterlyDividend, 
			Double baseRateOfReturn, Double beta, String stockSymbol, Double sharePrice) {
		if(assetCode==null){
			assetCode="None";
		}
		if(label==null){
			label="None";
		}
		if(stockSymbol==null){
			stockSymbol="None";
		}
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
		//we will try to create a connection with the server, if a connection fails, a runtime exception is thrown

			String query = "insert into Stock(assetCode, assetName, quarterlyDividend, baseRateOfReturn, betaMeasure, stockSymbol, sharePrice) values('"+assetCode+"','"+label+"',"+quarterlyDividend+","+baseRateOfReturn+","+beta+",'"+stockSymbol+"',"+sharePrice+");";
			String query2= "insert into AssetsList(assetCode, assetType, assetName) values('"+assetCode+"','S','"+label+"');";

			PreparedStatement ps = null;
			PreparedStatement ps2 = null;
			try {
				conn=  connectionMethod();
				ps = conn.prepareStatement(query);
				ps2 = conn.prepareStatement(query2);
				ps.executeUpdate();
				ps2.executeUpdate();
				
				conn.close();
				ps.close();
				ps2.close();
			}catch(SQLException e) {
				System.out.println("SQLException: ");
				e.printStackTrace();
				throw new RuntimeException(e);
				
			}
	}

	/**
	 * Removes all portfolio records from the database
	 */
	public static void removeAllPortfolios() {
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
		//we will try to create a connection with the server, if a connection fails, a runtime exception is thrown
	
			String query = "truncate Portfolio;";
			String query2 = "truncate Assets;";
	
			PreparedStatement ps = null;
			PreparedStatement ps2 = null;
		
			try {
	
				conn=  connectionMethod();

				ps = conn.prepareStatement(query);
				ps2 = conn.prepareStatement(query2);
				ps.executeUpdate();
				ps2.executeUpdate();
	

				conn.close();
				ps.close();
				ps2.close();
	

			}catch(SQLException e) {
				System.out.println("SQLException: ");
				e.printStackTrace();
				throw new RuntimeException(e);
				
			}
	

	}
	
	/**
	 * Removes the portfolio record from the database corresponding to the
	 * provided <code>portfolioCode</code>
	 * @param portfolioCode
	 */
	public static void removePortfolio(String portfolioCode) {


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
		//we will try to create a connection with the server, if a connection fails, a runtime exception is thrown
			String query = "DELETE portfolio FROM Portfolio WHERE portfolio.portfolioCode EQUALS "+portfolioCode+"";
			String query2 = "DELETE aAsset FROM Assets WHERE aAsset.portfolioCode EQUALS "+portfolioCode+"";
			PreparedStatement ps = null;
			PreparedStatement ps2 = null;
			try {
				conn=  connectionMethod();

				ps = conn.prepareStatement(query);
				ps2 = conn.prepareStatement(query2);
				ps.executeUpdate();
				ps2.executeUpdate();
				conn.close();
				ps.close();
				ps2.close();
			}catch(SQLException e) {
				System.out.println("SQLException: ");
				e.printStackTrace();
				throw new RuntimeException(e);
				
			}
	}
	
	/**
	 * Adds a portfolio records to the database with the given data.  If the portfolio has no
	 * beneficiary, the <code>beneficiaryCode</code> will be <code>null</code>
	 * @param portfolioCode
	 * @param ownerCode
	 * @param managerCode
	 * @param beneficiaryCode
	 */
	public static void addPortfolio(String portfolioCode, String ownerCode, String managerCode, String beneficiaryCode) {
		if(portfolioCode==null){
			ownerCode="None";
		}
		if(ownerCode==null){
			ownerCode="None";
		}
		if(managerCode==null){
			managerCode="None";
		}
		if(beneficiaryCode==null){
			beneficiaryCode="None";
		}
		
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
		//we will try to create a connection with the server, if a connection fails, a runtime exception is thrown
	
			String query = " insert into Portfolio(portfolioCode, ownerCode, managerCode, beneficiaryCode) values('"+portfolioCode+"','"+ownerCode+"','"+managerCode+"','"+beneficiaryCode+"');";
			PreparedStatement ps = null;
			try {
				conn=  connectionMethod();

				ps = conn.prepareStatement(query);
				ps.executeUpdate();
				conn.close();
				ps.close();
			}catch(SQLException e) {
				System.out.println("SQLException: ");
				e.printStackTrace();
				throw new RuntimeException(e);
				
			}
		
	}
	
	/**
	 * Associates the asset record corresponding to <code>assetCode</code> with the 
	 * portfolio corresponding to the provided <code>portfolioCode</code>.  The third 
	 * parameter, <code>value</code> is interpreted as a <i>balance</i>, <i>number of shares</i>
	 * or <i>stake percentage</i> (on the scale [0, 1]) depending on the type of asset the <code>assetCode</code> is
	 * associated with.  
	 * @param portfolioCode
	 * @param assetCode
	 * @param value
	 */
	public static void addAsset(String portfolioCode, String assetCode, double value) {
		if(portfolioCode==null){
			portfolioCode="None";
		}
		if(assetCode==null){
			assetCode="None";
		}
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
		//we will try to create a connection with the server, if a connection fails, a runtime exception is thrown
	
			String query = " insert into Assets(portfolioCode, assetCode, assetModifier) values('"+portfolioCode+"','"+assetCode+"',"+value+");";
			PreparedStatement ps = null;
			try {

				conn=  connectionMethod();
				ps = conn.prepareStatement(query);
				ps.executeUpdate();
				conn.close();
				ps.close();
			}catch(SQLException e) {
				System.out.println("SQLException: ");
				e.printStackTrace();
				throw new RuntimeException(e);
				
			}
	}
	
	
}

