package businesslogic;
import pack_database.Database;

public class ManagerController {

	public TeamPlayer[] AddToTeamLeague(String id, String name, TeamPlayer leag[]) {
		TeamPlayer League_Players[] = new TeamPlayer[11];
		for(int i = 0 ; i < 11 ; i++) {
			League_Players[i] = new TeamPlayer();
		}
		League_Players = leag;
		
		//update database
		Database db = new Database();
		String query = "insert into league_players(player_id, name) values('" + id + "', '" + name + "')";
		db.dbExecuteQuery(query);
		
		//update class
		for(int i = 0 ; i < 11 ; i++) {
			if(League_Players[i].player_id.equals("")) {
				League_Players[i].SetTeamPlayer(id, name);
				break;
			}
		}
		return League_Players;
	}
	
	public TeamPlayer[] AddToTeamTournament(String id, String name, TeamPlayer tour[]) {
		TeamPlayer Tournament_Players[] = new TeamPlayer[11];
		for(int i = 0 ; i < 11 ; i++) {
			Tournament_Players[i] = new TeamPlayer();
		}
		Tournament_Players = tour;
		
		//update database
		Database db = new Database();
		String query = "insert into tournament_players(player_id, name) values('" + id + "', '" + name + "')";
		db.dbExecuteQuery(query);
		
		//update class
		for(int i = 0 ; i < 11 ; i++) {
			if(Tournament_Players[i].player_id.equals("")) {
				Tournament_Players[i].SetTeamPlayer(id, name);
				break;
			}
		}
		return Tournament_Players;
		
	}
	
	public TeamPlayer[] DeletefromLeague(String id, String name, TeamPlayer leag[]) {
		TeamPlayer League_Players[] = new TeamPlayer[11];
		for(int i = 0 ; i < 11 ; i++) {
			League_Players[i] = new TeamPlayer();
		}
		League_Players = leag;
		
		//update database
		String qry = "delete from league_players where player_id = '" + id + "' and name = '" + name + "'";
		Database db = new Database();
		db.dbExecuteQuery(qry);
		
		//update class
		for(int i = 0 ; i < 11 ; i++) {
			if(League_Players[i].player_id.equals(id) && League_Players[i].name.equals(name)) {
				League_Players[i].SetTeamPlayer("", "");
				break;
			}
		}
		return League_Players;
	}
	
	public TeamPlayer[] DeletefromTournament(String id, String name, TeamPlayer tour[]) {
		TeamPlayer Tournament_Players[] = new TeamPlayer[11];
		for(int i = 0 ; i < 11 ; i++) {
			Tournament_Players[i] = new TeamPlayer();
		}
		Tournament_Players = tour;

		//update database
		String qry = "delete from tournament_players where player_id = '" + id + "' and name = '" + name + "'";
		Database db = new Database();
		db.dbExecuteQuery(qry);
		
		//update class
		for(int i = 0 ; i < 11 ; i++) {
			if(Tournament_Players[i].player_id.equals(id) && Tournament_Players[i].name.equals(name))  {
				Tournament_Players[i].SetTeamPlayer("", "");
				break;
			}
		}

		return Tournament_Players;
	}
}













