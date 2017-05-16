package se.kth.iv1350.inspection.integration;

import se.kth.iv1350.inspection.data.Database;


public class DatabaseManager {
	
	/**
	 * This Class is responsible for database calls, Database can only be called from here.
	 */
	
	/**
	 * new instance of the database class.
	 */
	Database database = new Database();

	public String[] retriveRegisterdVehicels(){
		return database.getRegisterdVehicles();
	}
	
	public String[][] retriveInspectionChecklist(){
		return database.getInspectionChecklist();
	}
	
	public double retriveCost(){
		return database.getCost();
	}
	public void saveCurrentResult(String[] currentResult){
		database.storeCurrentResult(currentResult);
	}
}
