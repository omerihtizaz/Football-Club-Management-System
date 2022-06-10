package businesslogic;
import pack_database.Database;

public class AdminController {
	public Schedule[] CreateSchedule(String ty, String d, String tm, String v, String c, String det , Schedule sch[], int scount) {
		Schedule schedule[] = new Schedule[50];
		for(int i = 0 ; i < 50 ; i++) {
			schedule[i] = new Schedule();
		}
		schedule = sch;
		
		boolean alreadybooked = false;
		//check if schedule overlapping with another
		for(int i = 0 ; i < scount ; i++) {
			if(schedule[i].date_.equals(d) && schedule[i].time.equals(tm) && schedule[i].venue.equals(v)){
				alreadybooked = true;
			}
		}
		
		if(scount <= 50 && alreadybooked == false) {
		
			//insert into database
			String qry = "insert into schedule(type, date_, time, venue, coach, details) values ('" + ty + "', '" + d + "', '" + tm + "', '" + v
					+ "', '" + c + "', '" + det + "')";

			Database db = new Database();
			db.dbExecuteQuery(qry);
		
			//update our schedule
			schedule[scount].SetSchedule( ty, d, tm, v, c, det);
		}
		return schedule;
	}
	
	public Schedule[] UpdateSchedule( String ot, String od, String ov, String d, String tm, String v, String c, String det, Schedule sch[], int scount) {
		Schedule schedule[] = new Schedule[50];
		for(int i = 0 ; i < 50 ; i++) {
			schedule[i] = new Schedule();
		}
		schedule = sch;
		
		boolean alreadybooked = false;
		//check if schedule overlapping with another
		for(int i = 0 ; i < scount ; i++) {
			if(schedule[i].date_.equals(d) && schedule[i].time.equals(tm) && schedule[i].venue.equals(v)){
				alreadybooked = true;
			}
		}
		
		if(alreadybooked == false) {
			//insert into database
			Database db = new Database();
			db.updateSchedule(ot, od, ov, d, tm, v, c, det);
		
			//update our schedule
			for(int i = 0 ; i < scount; i++) {
				if(schedule[i].date_.equals(od) && schedule[i].time.equals(ot) && schedule[i].venue.equals(ov)) {
					String storetype = schedule[i].type;
					schedule[i].SetSchedule( storetype, d, tm, v, c, det);
					break;
				}
			}
			
		}
		
		return schedule;		
	}
		
	public Schedule[] DeleteSchedule(String d, String tm, String v , Schedule sch[], int scount) {
		Schedule schedule[] = new Schedule[50];
		for(int i = 0 ; i < 50 ; i++) {
			schedule[i] = new Schedule();
		}
		schedule = sch;
		
		//update database
		String query = "delete from schedule where time = '" + tm + "' and date_ = '" + d + "' and venue = '" + v + "'";
		Database db = new Database();
		db.dbExecuteQuery(query);
		
		//update our own class
		int storeindex = 0;
		boolean found = false;
		for(int i = 0 ; i < scount ; i++) {
			if(schedule[i].date_.equals(d) && schedule[i].time.equals(tm) && schedule[i].venue.equals(v)) {
				storeindex = i;
				found = true;
				break;
			}
		}
		if(found) {
			for(int i = storeindex; i < scount-1 ; i++) {
				schedule[i].SetSchedule(schedule[i+1].type, schedule[i+1].date_,schedule[i+1].time, schedule[i+1].venue, schedule[i+1].coach, schedule[i+1].details);
			}
			schedule[scount-1].SetSchedule("", "", "", "", "", "");
		}
		return schedule;
	}
}
