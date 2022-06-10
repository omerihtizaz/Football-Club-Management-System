package businesslogic;

import pack_database.Database;

public class PlayerController {
	public void GiveFeedback(String pid, String cid, String fb) {
		String qry = "insert into feedback(player_id, coach_id, feedback, date_) values ('" + pid + "', '" + cid + "', '"
				+ fb + "', TO_CHAR(sysdate, 'dd/mm/yy'))";
		Database db  = new Database();
		db.dbExecuteQuery(qry);
	}
}
