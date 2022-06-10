package businesslogic;

public class Schedule {
 		String type ;
		String date_ ;
		String time ;
		String venue; 
		String coach;
		String details;
		
		public Schedule() {
			type = "";
		}
		public void SetSchedule( String t, String d, String tm, String ven, String c, String det) {
			type = t;
			date_ = d;
			time = tm;
			venue = ven;
			coach = c;
			details = det;
		}
		public void DisplaySchedule() {
			String display = type + " - " + date_ + " - " + time + " - " + venue + " - " + coach;
			System.out.println(display);
		}
		public String getSchedule() {
			String display =  type + "\n" + date_ + "\n" + time + "\n" + venue + "\n" + coach + "\n" + details
					+ "\n-------------------------------------------------------------------------------\n";
			return display;
		}
		public String getType() {
			String toret = type;
			return toret;
		}
}
