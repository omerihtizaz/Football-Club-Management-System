package businesslogic;

public class Account {
	String Player_ID;
	String pack_id;
	String Fee;
	String Paid;
	String payment_date; 
	String discount;
	String due_date;
	
	public Account(){
		Player_ID = "";
		pack_id = "";
		Fee = "";
		Paid = "0";
		payment_date = "";
		discount = "";
		due_date = "";
	}
	
	public void SetAccount(String pid, String pckid, String f, String pd, String pdate, String disc, String ddate) {
		Player_ID  = pid;
		pack_id = pckid;
		Fee = f;
		Paid = pd;
		payment_date = pdate;
		discount = disc;
		due_date = ddate;
	}
	public void displayAccount() {
		String display = Player_ID + "  " + pack_id + "  " + discount + "  " + Fee + "  " + due_date + "  " + Paid + "  "  + payment_date;
		System.out.println(display);
	}
	public String getAccount() {
		String display = "PLAYER ID: " + Player_ID + "\nPACKAGE: " + pack_id + "\nDISCOUNT: " + discount + "\nFEE: " + Fee + "\nDUE DATE: " 
	+ due_date + "\nPAID : " + Paid + "\n PAYMENT DATE: "  + payment_date;
		return display;
	}
}
