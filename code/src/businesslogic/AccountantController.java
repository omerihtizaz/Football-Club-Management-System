package businesslogic;
import pack_database.Database;

public class AccountantController {
	public String UpdateAccount(Player plist[], Account acc[], int pcount,int acount,  String id, String ddate, String dis, String pd, String pdate) {
		String toReturn = "";
		boolean playerfound = false;
		
		for(int i = 0 ; i < pcount ; i++) {
			if(plist[i].Player_ID.equals(id)) {
				playerfound = true;
			}
		}
		
		if(playerfound) {
			toReturn = "player found";
			String qry = "update accounts set due_date = '" + ddate + "', discount = '" + dis + "', paid = '" + pd + "', payment_date = '" + pdate 
					+ "' where player_id = '" + id + "'";
			Database db = new Database();
			db.dbExecuteQuery(qry);
			
			for(int i = 0 ; i < acount ; i++) {
				if(acc[i].Player_ID.equals(id)) {
					acc[i].SetAccount(id, acc[i].pack_id, acc[i].Fee, pd, pdate, dis, ddate);
					break;
				}
			}
		}
		else {
			toReturn = "player not found";
		}
		
		
		return toReturn;
	}
	
	public String ViewAccount(Account acc[], int acount, String find) {
		String toReturn = "";
		for(int i = 0 ; i < acount; i++) {
			if(acc[i].Player_ID.equals(find)) {
				toReturn = acc[i].getAccount();
				break;
			}
			else if(acc[i].due_date.equals(find)) {
				toReturn = toReturn + acc[i].getAccount() + "\n-----------------------------------------------------------\\n";
			}
		}
		
		return toReturn;
	}
	public String ViewUnpaidAccounts(Account acc[], int acount) {
		String toReturn = "";
		for(int i = 0 ; i < acount ; i++) {
			if(acc[i].Paid.equals("0")) {
				toReturn = toReturn + acc[i].getAccount() + "\n-----------------------------------------------------------\n";
			}
		}
		
		return toReturn;
	}
}
