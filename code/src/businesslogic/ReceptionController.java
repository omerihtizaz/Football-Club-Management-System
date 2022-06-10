package businesslogic;

import pack_database.*;

public class ReceptionController {
	
	public Player[] registerplayer(String name, String age, String cnic, String addr, String phone, String gender, String pack_id, Player pllist[], int pcount, Packages pklist[]) {
		Player playerlist[] = new Player[100];
		for(int i = 0 ; i < 100; i++) {
			playerlist[i] = new Player();
		}
		playerlist = pllist;
		Packages packlist[] = new Packages[4];
		for(int i = 0 ; i < 4 ; i++) {
			packlist[i] = new Packages();
		}
		packlist = pklist;
		
		//Send query to DataBase to enter value into Player 
		String qry = "insert into player (name, age, cnic, address, phonenumber, gender, pack_id) values ('" + name + "','" + age + "', '" + cnic + "', '" + addr +"','" + phone +"', '"+gender+"' , '" + pack_id + "')";
		Database db = new Database();
		db.dbExecuteQuery(qry);
		
		//Add player profile and open account for new registered player
		String checkerror = "error";
		Database db2 = new Database();
		String player_id = db2.getPlayerID(cnic);
		if(player_id == checkerror) {
			System.out.println("Error while getting player_id, PlayerProfile and Accounts not updates");
		}
		else {
			String qry2 = "insert into playerprofile (player_id) values ('" + player_id + "')";
			db.dbExecuteQuery(qry2);
			int packid = 0;
			if(pack_id == "1") packid = 0;
			if(pack_id == "2") packid = 1;
			if(pack_id == "3") packid = 2;
			if(pack_id == "4") packid = 3;
			
			String packprice = packlist[packid].getPackagePrice();
			String qry3 = "insert into Accounts (player_id , pack_id, fee, due_date, paid ) values ('" + player_id + "', '" + pack_id +" ' , ' " + packprice +"', TO_CHAR(ADD_MONTHS(sysdate,1),'dd/mm/yy'), '0')";
			Database db3 = new Database();
			db3.dbExecuteQuery(qry3);
		}
		playerlist[pcount].SetPlayerData(player_id, name, cnic, age, addr, phone, gender, pack_id);
		
		return playerlist;
	}
	
	public Player[] DeletePlayer(String id, Player pllist[], int pcount){
		Player playerlist[] = new Player[100];
		for(int i = 0 ; i < 100; i++) {
			playerlist[i] = new Player();
		}
		playerlist = pllist;
		
		//Delete Player by sending query to database
		String query = "delete from player where player_id = '" + id + "'";
		Database db = new Database();
		db.dbExecuteQuery(query);
		
		query = "delete from playerprofile where player_id = '" + id + "'";
		db.dbExecuteQuery(query);
		
		//update playerlist in our code as well
		int storeindex = 0;
		boolean found = false;
		for(int i = 0 ; i < pcount ; i++) {
			if(playerlist[i].GetPlayer_ID().equals(id)) {
				storeindex = i;
				found = true;
				break;
			}
		}
		if(found) {
			for(int i = storeindex; i < pcount-1 ; i++) {
				playerlist[i].SetPlayerData(playerlist[i+1].Player_ID, playerlist[i+1].Name, playerlist[i+1].CNIC, playerlist[i+1].Age, playerlist[i+1].Address, playerlist[i+1].PhoneNumber, playerlist[i+1].Gender, playerlist[i+1].pack_id);
			}
			playerlist[pcount-1].SetPlayerData("", "", "", "", "", "", "", "");
		}
		
		return playerlist;
	}

	public Coach[] DeleteCoach(String id, Coach clist[], int ccount) {
		Coach coachlist[] = new Coach[10];
		for(int i = 0 ; i < 10; i++) {
			coachlist[i] = new Coach();
		}
		coachlist = clist;

		//Delete Player by sending query to database
		String query = "delete from coachlist where coach_id = '" + id + "'";
		Database db = new Database();
		db.dbExecuteQuery(query);
				
		//update coachlist in our code as well
		int storeindex = 0;
		boolean found = false;
		for(int i = 0 ; i < ccount ; i++) {
			if(coachlist[i].GetCoachID().equals(id)) {
				storeindex = i;
				found = true;
				break;
			}
		}
		if(found) {
			for(int i = storeindex; i < ccount-1 ; i++) {
				coachlist[i].SetCoach(coachlist[i+1].coach_id, coachlist[i+1].name, coachlist[i+1].cnic, coachlist[i+1].phonenumber, coachlist[i+1].email);
			}
			coachlist[ccount-1].coach_id = "";
		}
				
		return coachlist;
	}

	public void DeleteManager(String id) {
		//Delete Player by sending query to database
		String query = "delete from managerlist where manager_id = '" + id + "'";
		Database db = new Database();
		db.dbExecuteQuery(query);
	}
	
	public Coach[] AddCoach(String name, String cnic, String phone, String email, Coach clist[], int ccount) {
		Coach coachlist[] = new Coach[10];
		for(int i = 0 ; i < 10; i++) {
			coachlist[i] = new Coach();
		}
		coachlist = clist;
		
		//update database
		String query = "insert into coachlist(name, cnic, phonenumber, email) values('" + name + "', '" + cnic + "', '" + phone + "', '" + email + "')";	
		Database db = new Database();
		db.dbExecuteQuery(query);
		
		//update coachlist in our code 
		String id = db.getCoachID(cnic);
		if(id != "error") {
			coachlist[ccount].SetCoach(id, name, cnic, phone, email);
		}
		return coachlist;
	}
	
	public void AddManager(String name, String cnic, String phone, String email) {
		String query = "insert into managerlist(name, cnic, phonenumber, email) values('" + name + "', '" + cnic + "', '" + phone + "', '" + email + "')";	
		Database db = new Database();
		db.dbExecuteQuery(query);
	}
	
	public String getManagerList(String id) {
		RetrieveInitialInformation db = new RetrieveInitialInformation();
		String toreturn = db.getManagerList(id);
		return toreturn;
	}
	
	public void UpdatePlayer(String id, String name, String age, String cnic, String addr, String phone, String gender, Player pllist[], int pcount) {
		Player playerlist[] = new Player[100];
		for(int i = 0 ; i < 100; i++) {
			playerlist[i] = new Player();
		}
		playerlist = pllist;
		
		Database db = new Database();
		String query = "Update player set name = '" + name + "', age = '" + age + "', cnic = '" + cnic + "', address = '" 
		+ addr + "', phonenumber = '" + phone + "', gender = '" + gender + "' where player_id = '" + id + "'";
		db.dbExecuteQuery(query);
		
		for(int i = 0 ; i < pcount ; i++) {
			if(playerlist[i].Player_ID.equals(id)) {
				playerlist[i].SetPlayerData(id, name, cnic, age, addr, phone, gender, playerlist[i].pack_id);
			}
		}
	}
	
	public void UpdateCoach(String id, String name, String cnic, String phone, String email, Coach clist[], int ccount) {
		Coach coachlist[] = new Coach[10];
		for(int i = 0 ; i < 10; i++) {
			coachlist[i] = new Coach();
		}
		coachlist = clist;
		
		String qry = "Update coachlist set name = '" + name + "', cnic = '" + cnic + "', phonenumber = '" + phone + "', email = '"
				+ email + "' where coach_id = '" + id + "'";
		Database db = new Database();
		db.dbExecuteQuery(qry);
		
		//update our own class in code as well
		for(int i = 0 ; i < ccount ; i++) {
			if(coachlist[i].coach_id.equals(id)) {
				coachlist[i].SetCoach(id, name, cnic, phone, email);
			}
		}
	}
	
	public void UpdateManager(String id, String name, String cnic, String phone, String email) {
		
		String qry = "Update managerlist set name = '" + name + "', cnic = '" + cnic + "', phonenumber = '" + phone + "', email = '"
				+ email + "' where manager_id = '" + id + "'";
		Database db = new Database();
		db.dbExecuteQuery(qry);
		
	}

	public String SearchCoach(String id, Coach coachlist[], int coachcount) {
		String toReturn = "";
		if(id.equals("all")) {
			for(int i = 0 ; i < coachcount ; i++) {
					toReturn = toReturn +  coachlist[i].GetCoachData() + "\n";
			}
		}
		else {
			for(int i = 0 ; i < coachcount ; i++) {
				if(id.equals(coachlist[i].GetCoachID()) || id.equals(coachlist[i].GetCoachName())) {
					toReturn = toReturn + coachlist[i].GetCoachData() + "\n";
				}
			}
		}
		
		return toReturn;
	}
	
	public String SearchPlayer(String id, Player playerlist[], int countplayers) {
		String toReturn = "";
		
		if(id.equals("all")) {
			for(int i = 0 ; i < countplayers ; i++) {
					toReturn = toReturn + playerlist[i].GetPlayerData() + "\n";
			}
		}
		else {
			for(int i = 0 ; i < countplayers ; i++) {
				if(id.equals(playerlist[i].GetPlayer_ID()) || id.equals(playerlist[i].GetPlayer_Name())) {
					toReturn = toReturn +  playerlist[i].GetPlayerData() + "\n";
				}
			}
		}
		return toReturn;
	}
}
