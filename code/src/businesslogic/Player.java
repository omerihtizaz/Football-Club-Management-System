package businesslogic;

public class Player {
	String Player_ID;
	String Name;
	String CNIC;
	String Age;
	String Address;
	String PhoneNumber;
	String Gender;
	String pack_id; 
	 
	public Player(){
		Player_ID = "";
	}
	public void SetPlayerData(String id, String n, String c, String a, String ad, String ph, String g, String pid) {
		Player_ID = id;
		Name = n;
		CNIC = c;
		Age = a;
		Address = ad;
		PhoneNumber = ph;
		Gender = g;
		pack_id = pid;
	}
	public void DisplayPlayerData() {
		System.out.println(Player_ID + "  " + Name + "  " + CNIC + "  " + Age + "  " + Address + "  " + PhoneNumber + "  " + Gender + "  " + pack_id );
	}
	public String GetPlayerData() {
		String toReturn = Player_ID + "  " + Name + "  " + CNIC + "  " + Age + "  " + Address + "  " + PhoneNumber + "  " + Gender + "  " + pack_id;
		return toReturn;
	}
	public String GetPlayer_ID() {
		String ID = Player_ID;
		return ID;
	}
	public String GetPlayer_Name() {
		String ID = Name;
		return ID;
	}
	 	
}
