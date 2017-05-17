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
	* @return Returns the checklist for a specific vechicle
	*/
	public String[][] retriveInspectionChecklist(){
		return database.getInspectionChecklist();
	}
	
	/**
	* Method retrive the cost of one full complete inspection from the database.
	* @return Returns the cost of one full complete inspection from the database.
	*/
	public double retriveCost(){
		return database.getCost();
	}
	
	/**
	* Method saves the current result of the current inspection(not the result from the whole inspection) in the database.
	* @param currentResult The current result that are to be saved in the database.
	*/
	public void saveCurrentResult(String[] currentResult){
		database.storeCurrentResult(currentResult);
	}
	
	/**
	* Method retrives the finnal result from one full completed inspection from the database.
	* @return Returs the finnal result from one full completd inspection that are stored in the database.
	*/
	public String retriveFinnalResult(){
		return database.getFinnalResult();
	}
}
