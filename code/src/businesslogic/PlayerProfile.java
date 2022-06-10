package businesslogic;

public class PlayerProfile {
 	String Player_ID;
 	String name;
 	String teamname;
	String agility;
	String redcard;
	String field_pos;
	String comments;
 
	public PlayerProfile(){
		Player_ID = "";
	}
	public void SetPlayerProfile( String p_id, String tname, String ag, String rc, String fpos, String comm) {
		Player_ID = p_id;
		teamname = tname;
		agility = ag;
		redcard = rc;
		field_pos = fpos;
		comments = comm;
	}
	public void SetPlayerProfilewName(String n, String p_id, String tname, String ag, String rc, String fpos, String comm) {
		name = n;
		Player_ID = p_id;
		teamname = tname;
		agility = ag;
		redcard = rc;
		field_pos = fpos;
		comments = comm;
	}
	public void DisplayPlayerProfile() {
		String display = "Name: " + name + "\nPlayer_ID: " + Player_ID + "\nTeam: " + teamname + "\nAgility: " + agility + "\nRed Cards: " + redcard
				+ "\nField Position: "
							+ field_pos + "\nComments: " + comments;
		System.out.println(display);
	}
	public void UpdatePlayerProfile(String tname, String ag, String rc, String fpos, String comm) {
		teamname = tname;
		agility = ag;
		redcard = rc;
		field_pos = fpos;
		comments = comm;
	}
	public String getPlayerProfile() {
		String display = "Name: " + name + "\nPlayer_ID: " + Player_ID + "\nTeam: " + teamname + "\nAgility: " + agility + "\nRed Cards: " + redcard
				+ "\nField Position: "
							+ field_pos + "\nComments: " + comments;
		return display;
	}
}
