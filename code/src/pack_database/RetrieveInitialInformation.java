package pack_database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import businesslogic.*;

public class RetrieveInitialInformation {
	public Packages[] getPackages() {
		Packages packlist[] =  new Packages[4];
		for(int i = 0 ; i < 4 ; i++) {
			packlist[i] = new Packages();
		}
		try {
		//1. Get connection to data base
			Connection myConn = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-B5G3II4:1521:orcl", "scott", "1234");
		//2. Make Statement
			Statement myStat = myConn.createStatement();
		//3. Execute Query
			String qry = "select * from packages";
			ResultSet res = myStat.executeQuery(qry);
			int i = 0;
			while(res.next()) {
				packlist[i].setPackage(res.getString("fee"), res.getString("details"), res.getString("status")) ;
				i++;
			}
			myConn.close();
			res.close();
		}
		catch(SQLException e){
			System.out.println("ERROR IN CONNECTION");
			e.printStackTrace();
		}
		return packlist;
	}
	
	public Player[] getPlayerList() {
		Player playerlist[] = new Player[100];
		for(int i = 0 ; i < 100; i++) {
			playerlist[i] = new Player();
		}
		
		try {
			//1. Get connection to data base
				Connection myConn = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-B5G3II4:1521:orcl", "scott", "1234");
			//2. Make Statement
				Statement myStat = myConn.createStatement();
			//3. Execute Query
				String qry = "select * from player";
				ResultSet res = myStat.executeQuery(qry);
				int i = 0;
				while(res.next()) {
					playerlist[i].SetPlayerData(res.getString("player_id"), res.getString("name"), res.getString("cnic"),  res.getString("age"),  res.getString("address"),  res.getString("phonenumber"),  res.getString("gender"),  res.getString("pack_id")) ;
					i++;
				}
				myConn.close();
				res.close();
			}
			catch(SQLException e){
				System.out.println("ERROR IN CONNECTION");
				e.printStackTrace();
			}
		
		return playerlist;
		
	}
	
	public PlayerProfile[] getPlayerProfile() {
		PlayerProfile profilelist[] = new PlayerProfile[100];
		for(int i = 0 ; i < 100 ; i++) {
			profilelist[i] = new PlayerProfile();
		}
		
		try {
			//1. Get connection to data base
				Connection myConn = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-B5G3II4:1521:orcl", "scott", "1234");
			//2. Make Statement
				Statement myStat = myConn.createStatement();
			//3. Execute Query
				String qry = "select * from playerprofile";
				ResultSet res = myStat.executeQuery(qry);
				int i = 0;
				while(res.next()) {
					profilelist[i].SetPlayerProfile(res.getString("player_id"), res.getString("teamname"), res.getString("agility"),  res.getString("redcard"),  res.getString("field_pos"),  res.getString("comments")) ;
					i++;
				}
				myConn.close();
				res.close();
			}
			catch(SQLException e){
				System.out.println("ERROR IN CONNECTION");
				e.printStackTrace();
			}
		
		return profilelist;
	}
	
	public Coach[] getCoachList() {
		Coach coachlist[] = new Coach[10];
		for(int i = 0 ; i < 10 ; i++) {
			coachlist[i] = new Coach();
		}
		
		try {
			//1. Get connection to data base
				Connection myConn = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-B5G3II4:1521:orcl", "scott", "1234");
			//2. Make Statement
				Statement myStat = myConn.createStatement();
			//3. Execute Query
				String qry = "select * from coachlist";
				ResultSet res = myStat.executeQuery(qry);
				int i = 0;
				while(res.next()) {
					coachlist[i].SetCoach(res.getString("coach_id"), res.getString("name"), res.getString("cnic"),  res.getString("phonenumber"),  res.getString("email")) ;
					i++;
				}
				myConn.close();
				res.close();
			}
			catch(SQLException e){
				System.out.println("ERROR IN CONNECTION");
				e.printStackTrace();
			}
		
		return coachlist;
	}
	
	public Account[] getAccounts() {
		Account accounts[] = new Account[150];
		for(int i = 0 ; i < 150 ; i++) {
			accounts[i] = new Account();
		}
		try {
			//1. Get connection to data base
				Connection myConn = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-B5G3II4:1521:orcl", "scott", "1234");
			//2. Make Statement
				Statement myStat = myConn.createStatement();
			//3. Execute Query
				String qry = "select * from Accounts";
				ResultSet res = myStat.executeQuery(qry);
				int i = 0;
				while(res.next()) {
					accounts[i].SetAccount(res.getString("Player_ID"), res.getString("pack_id"), res.getString("Fee"),  res.getString("paid"),  res.getString("payment_date"), res.getString("discount"), res.getString("due_date")) ;
					i++;
				}
				myConn.close();
				res.close();
			}
			catch(SQLException e){
				System.out.println("ERROR IN CONNECTION");
				e.printStackTrace();
			}
		
		return accounts;
	}
	
	public TeamPlayer[] getTeamPlayers(String team) {
		TeamPlayer teamplayers[] = new TeamPlayer[11];
		for(int i = 0 ; i < 11 ; i++) {
			teamplayers[i] = new TeamPlayer();
		}
		
		try {
			//1. Get connection to data base
				Connection myConn = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-B5G3II4:1521:orcl", "scott", "1234");
			//2. Make Statement
				Statement myStat = myConn.createStatement();
			//3. Execute Query
				String qry = "select * from "+ team;
				ResultSet res = myStat.executeQuery(qry);
				int i = 0;
				while(res.next()) {
					teamplayers[i].SetTeamPlayer(res.getString("Player_ID"), res.getString("name")) ;
					i++;
				}
				myConn.close();
				res.close();
			}
			catch(SQLException e){
				System.out.println("ERROR IN CONNECTION");
				e.printStackTrace();
			}
		return teamplayers;
	}
	
	public Schedule[] getSchedule() {
		Schedule schedule[] = new Schedule[50];
		for(int i = 0 ; i < 50 ; i++) {
			schedule[i] = new Schedule();
		}
		try {
			//1. Get connection to data base
				Connection myConn = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-B5G3II4:1521:orcl", "scott", "1234");
			//2. Make Statement
				Statement myStat = myConn.createStatement();
			//3. Execute Query
				String qry = "select * from schedule";
				ResultSet res = myStat.executeQuery(qry);
				int i = 0;
				while(res.next()) {
					schedule[i].SetSchedule( res.getString("type"),res.getString("date_"), res.getString("time"), res.getString("venue"), res.getString("coach"), res.getString("details") ) ;
					i++;
				}
				myConn.close();
				res.close();
			}
			catch(SQLException e){
				System.out.println("ERROR IN CONNECTION");
				e.printStackTrace();
			}
		return schedule;
		
	}
	
	public SeasonReview getSeasonReview() {
		SeasonReview latestseasonreview = new SeasonReview();
		try {
			//1. Get connection to data base
				Connection myConn = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-B5G3II4:1521:orcl", "scott", "1234");
			//2. Make Statement
				Statement myStat = myConn.createStatement();
			//3. Execute Query
				String qry = "select * from seasonreview";
				ResultSet res = myStat.executeQuery(qry);
				while(res.next()) {
					latestseasonreview.SetSeasonReview( res.getString("winningteam"),res.getString("runnerupteam"), res.getString("seasonplayer"), res.getString("runnerupplayer"), res.getString("player_mostgoals"), res.getString("player_mostassists"), res.getString("honourable_mentions") ) ;
				}
				myConn.close();
				res.close();
			}
			catch(SQLException e){
				System.out.println("ERROR IN CONNECTION");
				e.printStackTrace();
			}
		return latestseasonreview;
	}
	
	public String getManagerList(String id) {
		String store = "";
		try {
			//1. Get connection to data base
				Connection myConn = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-B5G3II4:1521:orcl", "scott", "1234");
			//2. Make Statement
				Statement myStat = myConn.createStatement();
			//3. Execute Query
				String qry = "";
				if(id.equals("all")) {
					qry = "select * from managerlist";
				}
				else {
					qry = "select * from managerlist where manager_id = '" + id + "' or name = '" + id + "'";
				}
				ResultSet res = myStat.executeQuery(qry);
				while(res.next()) {
					store = store + res.getString("manager_id")+ "-------------------------------\n" + res.getString("name") + "\n" + res.getString("cnic") + "\n" +  res.getString("phonenumber") + "\n" + res.getString("email") + "\n";
				}
				myConn.close();
				res.close();
			}
			catch(SQLException e){
				System.out.println("ERROR IN CONNECTION");
				e.printStackTrace();
			}	
		return store;
	}
}
