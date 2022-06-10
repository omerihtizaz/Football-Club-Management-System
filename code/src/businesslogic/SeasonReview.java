package businesslogic;

public class SeasonReview {
		String winningteam ;
		String runnerupteam ;
		String seasonplayer ; 
		String runnerupplayer;
		String player_mostgoals;
		String player_mostassists; 
		String honourable_mentions; 
	
		public void SetSeasonReview( String wt, String rt, String spl, String  rpl, String plmgl, String plmass, String hmen) {
			winningteam = wt;
			runnerupteam = rt;
			seasonplayer = spl;
			runnerupplayer = rpl;
			player_mostgoals = plmgl;
			player_mostassists = plmass;
			honourable_mentions = hmen;
		}
		public void DisplaySeasonReview() {
			String display = winningteam + "\n" + runnerupteam + "\n" + player_mostgoals + "\n" + player_mostassists + "\n" + honourable_mentions;
			System.out.println(display);
		}
		public String GetSeasonReview() {
			String display = "WINNING TEAM: " + winningteam + "\nRUNNER UP TEAM: " + runnerupteam +"\nSEASON PLAYER: " + seasonplayer + "\nRUNNER UP PLAYER: "+ runnerupplayer + "\nMOST GOALS: " + player_mostgoals + "\nMOST ASSISTS: " + player_mostassists + "\nHONOURABLE MENTIONS: " + honourable_mentions;
			return display;
		}
}
