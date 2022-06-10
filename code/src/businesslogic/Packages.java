package businesslogic;

public class Packages {
	String price;
	String details; 
	String status;
	
	public void setPackage(String p, String d, String s) {
		price = p;
		details = d;
		status = s;
	}
	public void displayPackage() {
		System.out.println(price + "   " + details + "  " + status);
	}
	public String getPackagePrice() {
		return price;
	}
}
