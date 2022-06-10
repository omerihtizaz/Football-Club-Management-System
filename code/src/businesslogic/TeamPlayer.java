package businesslogic;

public class TeamPlayer {
	String player_id;
	String name;
	
	public TeamPlayer() {
		player_id = "";
	}
	public void SetTeamPlayer(String pid, String n) {
		player_id = pid;
		name = n;
	}
	public void DisplayTeamPlayer() {
		String display = player_id + "  " + name;
		System.out.println(display);
	}
	public String GetPlayer() {
		String display = player_id + "  " + name;
		return display;
	}
}
