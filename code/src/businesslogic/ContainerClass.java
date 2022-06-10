package businesslogic;

import user_interface.*;
import pack_database.*;

public class ContainerClass {

	public static void main(String args[]) {
		
		MainHomePage mainpage = new MainHomePage();
		mainpage.displayMainHome();
	}
	
	public String checkpassword(String id, String pass) {
		//=====================================================================================================================
		//												RETRIEVE INFORMATION
		//======================================================================================================================
		RetrieveInitialInformation db = new RetrieveInitialInformation();
		
		//Get Packages
		Packages packageslist[] = new Packages[4];
		for(int i = 0 ; i < 4 ; i++) {
			packageslist[i] = new Packages();
		}
		packageslist = db.getPackages();
		//Get Player list
		Player playerlist[] = new Player[100];
		for(int i = 0 ; i < 100; i++) {
			playerlist[i] = new Player();
		}
		playerlist = db.getPlayerList();
		int c = 0;
		int countplayers = 0;
		while(playerlist[c].Player_ID != "") {
			c++;
			countplayers++;
		}
		//Get Player Profile
		PlayerProfile profilelist[] = new PlayerProfile[100];
		for(int i = 0 ; i < 100 ; i++) {
			profilelist[i] = new PlayerProfile();
		}
		profilelist = db.getPlayerProfile();
		//Get Coach List
		Coach coachlist[] = new Coach[10];
		for(int i = 0 ; i < 10 ; i++) {
			coachlist[i] = new Coach();
		}
		coachlist = db.getCoachList();
		c = 0;
		int coachcount = 0;
		while(coachlist[c].coach_id != "") {
			c++;
			coachcount++;
		}
		//Get Accounts Information
		Account accounts[] = new Account[150];
		for(int i = 0 ; i < 150 ; i++) {
			accounts[i] = new Account();
		}
		accounts = db.getAccounts();
		c = 0;
		int countaccount = 0;
		while(accounts[c].Player_ID != ""){
			c++;
			countaccount++;
		}
		//Get Team 1 Info
		TeamPlayer League_Players[] = new TeamPlayer[11];
		for(int i = 0 ; i < 11 ; i++) {
			League_Players[i] = new TeamPlayer();
		}
		League_Players = db.getTeamPlayers("League_Players");
		c= 0;
		//Get Team 2 Info
		TeamPlayer Tournament_Players[] = new TeamPlayer[11];
		for(int i = 0 ; i < 11 ; i++) {
			Tournament_Players[i] = new TeamPlayer();
		}
		Tournament_Players = db.getTeamPlayers("Tournament_Players");
		//Get Schedules
		Schedule schedule[] = new Schedule[50];
		for(int i = 0 ; i < 50 ; i++) {
			schedule[i] = new Schedule();
		}
		schedule = db.getSchedule();
		c = 0;
		int schedulecount = 0;
		while(schedule[c].type != "") {
			schedulecount++;
			c++;
		}
		//Get Season Review
		SeasonReview latestseasonreview = new SeasonReview();
		latestseasonreview = db.getSeasonReview();
		//Update Player Names in profile list
		for(int i = 0 ; i < countplayers ; i++) {
			for(int j = 0; j < countplayers; j++) {
				if(profilelist[i].Player_ID.equals(playerlist[j].Player_ID)) {
					profilelist[i].name = playerlist[j].Name;
					break;
				}
			}
		}
		
		
		//=====================================================================================================================
		//											GO TO CORRECT HOME PAGE
		//======================================================================================================================
				
		//receptionist---------------------------------------------------------------------------------------------------------------
		if(pass.equals("1111") && id.equals("11")) {
			ReceptionHome rcphome = new ReceptionHome();
			rcphome.displayReceptionHome(packageslist, playerlist, coachlist, countplayers, coachcount);
			return "done";
		}
		//admin----------------------------------------------------------------------------------------------------------------------
		if(pass.equals("1122") && id.equals("12")  ) {
			AdminHome adhome = new AdminHome();
			adhome.displayAdminHome(latestseasonreview, profilelist, League_Players, Tournament_Players, schedule, schedulecount, countplayers);
			return "done";
		}
		//accountant-----------------------------------------------------------------------------------------------------------------
		if(pass.equals("1133") && id.equals("13")) {
			AccountantHome acchome = new AccountantHome();
			acchome.displayAccountantHome(playerlist, accounts, countaccount, countplayers);
			return "done";
		}
		//player---------------------------------------------------------------------------------------------------------------------
		if(pass.equals("0000") && id.equals("0")) {
			PlayerHome plhome = new PlayerHome();
			plhome.playerhomemain(latestseasonreview, profilelist, League_Players, Tournament_Players, schedule, schedulecount, countplayers);
			return "done";
		}
		//coach----------------------------------------------------------------------------------------------------------------------
		if(pass.equals("2222") && id.equals("2")) {
			CoachHome chhome = new CoachHome();
			chhome.displaycoachhome(latestseasonreview, profilelist, League_Players, Tournament_Players, schedule, schedulecount, countplayers);
			return "done";
		}
		//manager--------------------------------------------------------------------------------------------------------------------
		if(pass.equals("3333") && id.equals("3")) {
			ManagerHome mghome = new ManagerHome();
			mghome.displaymanagerhome(latestseasonreview, profilelist, League_Players, Tournament_Players, schedule, schedulecount, countplayers);
			return "done";
		}
		else {
			return "incorrect";
			
		}
	}

	public String viewPlayerProfile(String id_name, int pcount, PlayerProfile profile[]) {
		String toReturn = "";
		if(id_name.equals("all")) {
			for(int i = 0 ; i < pcount ; i++) {
				toReturn = toReturn + profile[i].getPlayerProfile() + "\n--------------------------------------------------\n";
			}
		}
		else {
			for(int i = 0 ; i < pcount ; i++) {
				if(profile[i].Player_ID.equals(id_name) || profile[i].name.equals(id_name))
				toReturn = toReturn +  profile[i].getPlayerProfile() + "\n--------------------------------------------------\n";
			}
		}
		return toReturn;
	}
	
	public String viewSeasonReview(SeasonReview ssn) {
		SeasonReview ssnrvw = new SeasonReview();
		ssnrvw = ssn;
		String toReturn = "";
		toReturn = toReturn + ssnrvw.GetSeasonReview();
		return toReturn;
	}
	
	public String viewSchedule(Schedule sch[], int countsch, String ty, String id) {
		String toReturn = "";
		Schedule schedule[] = new Schedule[50];
		for(int i = 0 ; i < 50; i++) {
			schedule[i] = new Schedule();
		}
		schedule = sch;
		
		//if tournament and training session both being asked
		if(ty.equals("any")) {
			if(id.equals("all")) {
				for(int i = 0; i < countsch; i++) {
					toReturn = toReturn + schedule[i].getSchedule() + "\n";
				}
			}
			else {
				for(int i = 0 ; i < countsch; i++) {
					if(schedule[i].coach.equals(id) || schedule[i].date_.equals(id) || schedule[i].venue.equals(id)) {
						toReturn = toReturn + schedule[i].getSchedule();
					}
				}
			}
		}
		//if only tournament asked
		else if(ty.equals("tournament") || ty.equals("Tournament") || ty.equals("TOURNAMENT")) {
			if(id.equals("all")) {
				for(int i = 0; i < countsch; i++) {
					if(schedule[i].type.equals("tournament")) {
						toReturn = toReturn + schedule[i].getSchedule() + "\n";
					}
				}
			}
			else {
				for(int i = 0 ; i < countsch; i++) {
					if(schedule[i].type.equals("tournament")) {
						if(schedule[i].coach.equals(id) || schedule[i].date_.equals(id) || schedule[i].venue.equals(id)) {
							toReturn = toReturn + schedule[i].getSchedule();
						}
					}
				}
			}
		}
		//if only training session asked
		else if(ty.equals("training") || ty.equals("training session") || ty.equals("Training") || ty.equals("Training Session") || ty.equals("TRAINING") || ty.equals("TRAINING SESSION")) {
			if(id.equals("all")) {
				for(int i = 0; i < countsch; i++) {
					if(schedule[i].type.equals("training")) {
						toReturn = toReturn + schedule[i].getSchedule() + "\n";
					}
				}
			}
			else {
				for(int i = 0 ; i < countsch; i++) {
					if(schedule[i].type.equals("training")) {
						if(schedule[i].coach.equals(id) || schedule[i].date_.equals(id) || schedule[i].venue.equals(id)) {
							toReturn = toReturn + schedule[i].getSchedule();
						}
					}
				}
			}
		}
		return toReturn; 
	}

	public String ViewTeams(TeamPlayer t[]) {
		String toreturn = "";
		TeamPlayer team[] = new TeamPlayer[11];
		for(int i = 0 ; i < 11; i++) {
			team[i] = new TeamPlayer();
		}
		team = t;
		
		for(int i = 0 ; i < 11 ; i++) {
			toreturn = toreturn + team[i].GetPlayer() + "\n";
		}
		return toreturn;
	}
	
	public String ViewFeedback(String coachid) {
		String toreturn = "";
		Database db = new Database();
		toreturn = db.getFeedback(coachid); 
		return toreturn;
	}
}
