package pack_database;

import java.sql.*;



public class Database {

	public void dbExecuteQuery(String query) {
		try {
		//1. Get connection to data base
			Connection myConn = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-B5G3II4:1521:orcl", "scott", "1234");
			
		//2. Make Statement
			Statement myStat = myConn.createStatement();
			
		//3. Execute the Query Statement
			myStat.executeQuery(query);
			
		//4.Close Connection
			myConn.close();
	
		}
		catch(SQLException e){
			System.out.println("ERROR IN CONNECTION");
			e.printStackTrace();
		}
		
	}
	
	public String getPlayerID(String cnic) {
		String qry = "Select player_id from player where cnic = '" + cnic + "'";
		try {
		//1. Get connection to data base
			Connection myConn = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-B5G3II4:1521:orcl", "scott", "1234");
		//2. Make Statement
			Statement myStat = myConn.createStatement();
		
		//3. Execute the Query Statement
			ResultSet res = myStat.executeQuery(qry);
			while(res.next()) {
				String store = res.getString("player_id");
				myConn.close();
				return store;
			}

		//4.Close Connection
			myConn.close();
			res.close();
			return "error";
		}
		catch(SQLException e) {
			System.out.println("ERROR IN CONNECTION");
			e.printStackTrace();
			return "error";
		}
	}
	public String getCoachID(String cnic) {
		String qry = "Select coach_id from coachlist where cnic = '" + cnic + "'";
		try {
		//1. Get connection to data base
			Connection myConn = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-B5G3II4:1521:orcl", "scott", "1234");
		//2. Make Statement
			Statement myStat = myConn.createStatement();
		
		//3. Execute the Query Statement
			ResultSet res = myStat.executeQuery(qry);
			while(res.next()) {
				String store = res.getString("coach_id");
				myConn.close();
				return store;
			}
			
		//4.Close Connection
			res.close();
			myConn.close();
			return "error";
		}
		catch(SQLException e) {
			System.out.println("ERROR IN CONNECTION");
			e.printStackTrace();
			return "error";
		}
	}
	public String getFeedback(String coachid) {
		String toreturn = "";
		String qry = "select * from feedback where coach_id = '" + coachid + "'";
		try {
			//1. Get connection to data base
				Connection myConn = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-B5G3II4:1521:orcl", "scott", "1234");
			//2. Make Statement
				Statement myStat = myConn.createStatement();
				
			//3. Execute the Query Statement
				ResultSet res = myStat.executeQuery(qry);
				while(res.next()) {
					toreturn = res.getString("coach_id") + "\n" +  res.getString("date_") + "\n" +  res.getString("feedback") + "\n----------------------\n";
				}
				
			//4.Close Connection
				myConn.close();
		
			}
			catch(SQLException e){
				System.out.println("ERROR IN CONNECTION");
				e.printStackTrace();
			}		
		return toreturn;
	}
	public void updateSchedule( String ot, String od, String ov, String d, String tm, String v, String c, String det) {
		String query = "select schedule_id from schedule where time = '" + ot + "' and date_ = '" + od + "' and venue = '" + ov + "'";
		try {
			//1. Get connection to data base
				Connection myConn = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-B5G3II4:1521:orcl", "scott", "1234");
				
			//2. Make Statement
				Statement myStat = myConn.createStatement();
				
			//3. Execute the Query Statement
				String id ="";
				ResultSet res = myStat.executeQuery(query);
				while(res.next()) {
					id = res.getString("schedule_id");
					System.out.println(id);
				}
				
			//4.Close Connection
				myConn.close();
				
				query = "update schedule set date_ = '" + d + "', time = '" + tm + "', venue = '" 
						+ v + "', coach = '" + c + "', details = '" + det + "' where schedule_id = '" + id + "'";
				Database db = new Database();
				db.dbExecuteQuery(query);
				
			}
			catch(SQLException e){
				System.out.println("ERROR IN CONNECTION");
				e.printStackTrace();
			}
	}
}
