package se.kth.iv1350.inspection.data;

public class Database {
	
	private String registrationNumber = "AFK442";
	private Double cost = (double) 2000;
	public Database(){
		
	}
	public void fetchInspection(String registrationNumber){
		if(this.registrationNumber == registrationNumber){
			System.out.println("Your cost for the inspection are: " + cost + "$");
		}
		else
			System.out.println("Invalid vehicle");
	}
}
