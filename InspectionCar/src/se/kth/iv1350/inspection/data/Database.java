package se.kth.iv1350.inspection.data;

import java.util.Arrays;

public class Database {
	
	/**
	 * This Databse class represents a virtual database.
	 * This class can only be called form the DatabaseManager class.
	 */
	
	/**
	 *  Here are some informations about registerd vehicels
	 */
	private static final double cost = 1000;
	private String[] registerdVehicles = {"ABC123", "LKF245", "LDK424"};	
	private final String[][] inspectionChecklist = {{"check oil","check windows","check lights"},{"check oil","check seats","check wheels"},{"check oil","check engine","check dashboard"}};
	private String[] currentResult;
	private String finnalResult;
	
	/**
	 * Method to get the diffrent vehicels in the database
	 * @return Returns registration number from the registerd vehicels that are in the database.
	 */
	public String[] getRegisterdVehicles() {
		return registerdVehicles;
	}

	/**
	 * Method to get the diffrent checklists that are in the database.
	 * @return Returns the inspection checklist that are to be performed on the vehicel. 
	 */
	public String[][] getInspectionChecklist() {
		return inspectionChecklist;
	}

	/**
	 * Method to get the cost of a single complete inspection.
	 * @return Retunrs the cost of a single complete inspection.
	 */
	public double getCost() {
		return cost;
	}	
	
	/**
	 * Method to store the current inspection result in the database.
	 * @param resultsToBeSaved as a string array. 
	 */
	public void storeCurrentResult(String[] resultsToBeSaved){
		currentResult = resultsToBeSaved;
	}

	/**
	 * Method to get the finnal result of a complete inspection. This method is called when its time to print the finnal results.  
	 * @return Returns the finnal result that are storred in the database. 
	 */
	public String getFinnalResult() {
		finnalResult = Arrays.toString(currentResult);
		return finnalResult;
	}

}
