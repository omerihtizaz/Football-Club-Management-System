package businesslogic;
 import pack_database.Database;
 
public class CoachController {
	public void UpdatePlayerProfile(String id, String tn, String ag, String rc, String fp, String com, int pcount, PlayerProfile pro[]) {
		PlayerProfile profilelist[] = new PlayerProfile[100];
		for(int i = 0 ; i < 100 ; i++) {
			profilelist[i] = new PlayerProfile();
		}
		profilelist = pro;
		
		String qry = "Update playerprofile set teamname = '" + tn + "', agility = '" + ag + "', redcard = '" + rc 
				+ "', field_pos = '" + fp + "', comments = '" + com + "' where player_id = '" + id + "'";
		Database db = new Database();
		db.dbExecuteQuery(qry);
		
		//update the profile array in code as well
		for(int i = 0 ; i < pcount ; i++) {
			if(profilelist[i].Player_ID.equals(id)) {
				profilelist[i].UpdatePlayerProfile(tn, ag, rc, fp, com);
				break;
			}
		}
	}
	
	public void createseasonreview(String wteam, String rteam, String splayer, String rplayer, String mostg, String mostass, String hmen, SeasonReview ssnrvw) {
		SeasonReview seasonrvw = new SeasonReview();
		seasonrvw = ssnrvw;
		
		String qry = "Insert into seasonreview(winningteam, runnerupteam, seasonplayer,runnerupplayer,player_mostgoals, player_mostassists, honourable_mentions)"
				+ " values('" + wteam + "', '" + rteam + "', '" + splayer + "', '" + rplayer + "', '" + mostg + "', '" + mostass + "', '" + hmen + "')";
		Database db = new Database();
		db.dbExecuteQuery(qry);
		
		//update our class
		seasonrvw.SetSeasonReview(wteam, rteam, splayer, rplayer, mostg, mostass, hmen);
	}
}
