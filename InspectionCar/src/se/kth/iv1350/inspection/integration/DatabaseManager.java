package se.kth.iv1350.inspection.integration;

import se.kth.iv1350.inspection.data.Database;


public class DatabaseManager {
	
	/**
	 * This Class is responsible for database calls, Database can only be called from here.
	 */
	
	Database database = new Database();

	/**
	 * Method to retrive registration numbers that are storred in the database.
	 * @return Returns the registration number of the vehicels in the database.
	 */
	public String[] retriveRegisterdVehicels(){
		return database.getRegisterdVehicles();
	}
	
	/**
	 * Method to retrive inspection checklists that are storred in the database.
	 * @return Returns 
	 */
	public String[][] retriveInspectionChecklist(){
		return database.getInspectionChecklist();
	}
	
	public double retriveCost(){
		return database.getCost();
	}
	public void saveCurrentResult(String[] currentResult){
		database.storeCurrentResult(currentResult);
	}
	public String retriveFinnalResult(){
		return database.getFinnalResult();
	}
}
