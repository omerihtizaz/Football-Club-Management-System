package businesslogic;

public class Coach {
	String coach_id;
	String name;
	String cnic;
	String phonenumber;
	String email;
	
	public Coach() {
		coach_id = "";
	}
	public void SetCoach(String ch_id, String n, String cn, String ph, String em) {
		coach_id = ch_id;
		name = n;
		cnic = cn;
		phonenumber = ph;
		email = em;
	}
	
	public void DisplayCoach() {
		String display = "Name: " + name + "\nPhone Number: " + phonenumber + "\nEmail: " + email;
		System.out.println(display);
	}
	public String GetCoachData() {
		String display = coach_id + "------------------------------------------------\nName: " + name + "\nPhone Number: " + phonenumber + "\nEmail: " + email;
		return display;
	}
	public String GetCoachID() {
		String idtoreturn = coach_id;
		return idtoreturn;
	}
	public String GetCoachName() {
		String idtoreturn = name;
		return idtoreturn;
	}
	 
}
