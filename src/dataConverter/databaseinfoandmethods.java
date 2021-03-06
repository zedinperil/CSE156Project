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
public interface databaseinfoandmethods extends PortfolioSorter {
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
	public static List<List<Portfolio>> getPortfolios(){
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
		String query =  "select p.portfolioCode,  "
				+ "q.personCode as OwnerCode, m.personCode as ManagerCode, "
				+ "b.personCode as BeneficiaryCode "
				+ "from Portfolio p join Person q on q.personCode=p.ownerCode "
				+ "LEFT JOIN Person m on m.personCode=p.managerCode "
				+ "LEFT JOIN Person b on b.personCode=p.beneficiaryCode;";
		//declare a new portfolio arraylist
		List<List<Portfolio>> portfolioListList= new ArrayList<List<Portfolio>>();
		List<Portfolio> portfoliosSortedByOwner= new ArrayList<Portfolio>();
		List<Portfolio> portfoliosSortedByManagerType= new ArrayList<Portfolio>();
		List<Portfolio> portfoliosSortedByTotalValue= new ArrayList<Portfolio>();

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
			String ownerCode= rs.getString("OwnerCode");
			String managerCode= rs.getString("ManagerCode");
			
			String beneficiaryCode=null;
			beneficiaryCode= rs.getString("BeneficiaryCode");
			if(beneficiaryCode==null){
				beneficiaryCode="none";
			}
			Portfolio port = new Portfolio(PortfolioCode, ownerCode, managerCode, beneficiaryCode);
			portfoliosSortedByOwner= PortfolioSorter.addPortfolioSortedByOwnerName(portfoliosSortedByOwner, port);
			portfoliosSortedByManagerType= PortfolioSorter.addPortfolioSortedByManagerTypeAndName(portfoliosSortedByManagerType, port);
			portfoliosSortedByTotalValue= PortfolioSorter.addPortfolioSortedByTotalValue(portfoliosSortedByTotalValue, port);
		} 
		portfolioListList.add(portfoliosSortedByOwner);
		portfolioListList.add(portfoliosSortedByManagerType);
		portfolioListList.add(portfoliosSortedByTotalValue);
		//close the result set and preparedstatement
		 if ( rs != null && ! rs . isClosed () )
			 rs . close () ;
			 if ( ps != null && ! ps . isClosed () )
			 ps . close () ;
			 if ( conn != null && ! conn . isClosed () )
			 conn . close () ;
		//catch a potential fatal error
		}catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	//return the portfolio arraylist
	return portfolioListList;
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
		Connection conn = connectionMethod();
		//this query will gather all the asset information
		String query = "select p.portfolioCode, L.assetCode,"
				+ "a.assetModifier from Assets a JOIN Portfolio p ON p.portfolioCode = a.portfolioCode "
				+ "JOIN AssetsList L ON L.assetCode = a.assetCode;";
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
		
			double assetValue = rs.getDouble("assetModifier");
			//remake assets
			Asset a = new Asset(assetPortfolioCode, assetCode, assetValue);
	
			assets.add(a);
		}
		//close ps and rs
		 if ( rs != null && ! rs . isClosed () )
			 rs . close () ;
			 if ( ps != null && ! ps . isClosed () )
			 ps . close () ;
			 if ( conn != null && ! conn . isClosed () )
			 conn . close () ;
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
			String query = "select p.personCode, p.firstName, p.lastName, p.persontype, p.secId, p.street, p.city, p.state, p.country, p.zip from Person p;";
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


				String personCode = rs.getString("personCode");
				String firstName = rs.getString("firstName");
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
			 if ( rs != null && ! rs . isClosed () )
				 rs . close () ;
				 if ( ps != null && ! ps . isClosed () )
				 ps . close () ;
				 if ( conn != null && ! conn . isClosed () )
				 conn . close () ;
			//catch any fatal erros in the sql
		} catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		//return the persons arraylist
		return persons;
		}
		
		
		//this is a very similar method. We are gathering all the data for assetsList
		public static List<Assets> getAssetList(){
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
			//this query will gather all the asset information
			String query = "select L.assetType from AssetsList L;";
			//declare a new array list of type asset
		List<Assets> assetList= new ArrayList<Assets>();	
			//new ps and rs
		PreparedStatement ps = null;
		ResultSet rs = null;
		//this try statement will execute the query.  Using this, we are able to define our variables and store the variables into an a new 
			//asset object. Then we store the object into the arraylist.
		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				// MAKE SOME NEW QUERIES FOR THIS SERIOUSLY MAKE IT TO GET THEM FROM EACH THING REEEEEEEEEEEEEEEEEEEEEEEEEEEEEE
				String assetType  = rs.getString("assetType");
				String query2= new String();
				//remake assets
				if(assetType.equals("P")){
					query2="select P.assetCode, P.assetName, P.quarterlyDividend, P.baseRateofReturn, "
							+ "P.pValue, P.omegaMeasure FROM PrivateInvestment P";
				
				}
				if(assetType.equals("S")){
					query2="select S.assetCode, S.assetName, S.quarterlyDividend, S.baseRateofReturn, "
							+ "S.betaMeasure, S.stockSymbol, S.sharePrice FROM Stock S";
				
				}
				if(assetType.equals("D")){
					query2="select D.assetCode, D.assetName, D.apr FROM Deposit D";
				
				}
				//EXECUTE ORDER 66, WHICH MEANS TO RUN THE SECOND QUERY, DUN DUN DUUUNES BOY
				
				PreparedStatement ps2 = null;
				ResultSet rs2 = null;
				//this try statement will execute the query.  Using this, we are able to define our variables and store the variables into an a new 
					//asset object. Then we store the object into the arraylist.
				try {
					ps2 = conn.prepareStatement(query2);
					rs2 = ps2.executeQuery();
					while(rs2.next()) {
				
				
						
						String code=rs2.getString("assetCode");
						String label=rs2.getString("assetName");
						
				Assets b= null;
				if(assetType.equals("P")){
					
					double quarterlydividend=rs2.getDouble("quarterlyDividend");
					double baserateofreturn=rs2.getDouble("baseRateOfReturn");
					double totalvalue=rs2.getDouble("pValue");
					double omegameasure=rs2.getDouble("omegaMeasure");
					
					
					
					 b= new PrivateInvestment(code, label, quarterlydividend, baserateofreturn, omegameasure, totalvalue);
					 b.setType("P");
				}
				if(assetType.equals("S")){
					double quarterlydividend=rs2.getDouble("quarterlyDividend");
					double baserateofreturn=rs2.getDouble("baseRateOfReturn");
					double shareprice=rs2.getDouble("sharePrice");
					double betameasure=rs2.getDouble("betaMeasure");
					String stocksymbol= rs2.getString("stockSymbol");
					
					
					 b= new Stock(code,label, quarterlydividend,baserateofreturn, betameasure,stocksymbol, shareprice);
					 b.setType("S");
				}
				if(assetType.equals("D")){
				
					double apr= rs2.getDouble("apr");
					 b = new Deposit(code,label, apr);
					 b.setType("D");
				}
				b.setType(assetType);
				assetList.add(b);
				
				}
				//close ps and rs
				rs2.close();
				ps2.close();
				//catch any fatal erros in the sql
			} catch (SQLException e) {
				System.out.println("SQLException: ");
				e.printStackTrace();
				throw new RuntimeException(e);
			}
				
			}
			//close ps and rs
			 if ( rs != null && ! rs . isClosed () )
				 rs . close () ;
				 if ( ps != null && ! ps . isClosed () )
				 ps . close () ;
				 if ( conn != null && ! conn . isClosed () )
				 conn . close () ;
			//catch any fatal erros in the sql
		} catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		//return the asset arraylist
		return assetList;
		}
		

		//this is a very similar method. We are gathering all the data for persons
			public static List<Email> getEmail(){
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
				String query = "select e.personCode, e.email from Emails e;";
				//declare a new array list of type persons
			List<Email> emails= new ArrayList<Email>();	
				//new ps and rs
			PreparedStatement ps = null;
			ResultSet rs = null;
			//this try statement will execute the query.  Using this, we are able to define our variables and store the variables into an a new 
				//persons object. Then we store the object into the arraylist.
			try {
				ps = conn.prepareStatement(query);
				rs = ps.executeQuery();
				while(rs.next()) {


					String personCode = rs.getString("personCode");
					String email = rs.getString("email");
		
					//remake persons
					Email e= new Email(personCode,email);
					emails.add(e);
				}
				//close ps and rsry {
				 if ( rs != null && ! rs . isClosed () )
					 rs . close () ;
					 if ( ps != null && ! ps . isClosed () )
					 ps . close () ;
					 if ( conn != null && ! conn . isClosed () )
					 conn . close () ;
				
				//catch any fatal erros in the sql
			} catch (SQLException e) {
				System.out.println("SQLException: ");
				e.printStackTrace();
				throw new RuntimeException(e);
			}
			//return the persons arraylist
			return emails;
			}
		
		

}
