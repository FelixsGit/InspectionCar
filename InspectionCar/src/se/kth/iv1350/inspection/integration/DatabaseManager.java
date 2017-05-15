package se.kth.iv1350.inspection.integration;

import se.kth.iv1350.inspection.data.Database;
import se.kth.iv1350.inspection.data.InvalidVehicleException;
import se.kth.iv1350.inspection.model.Vehicle;

public class DatabaseManager {
	
	//This Class is responsible for database calls, Database can only be called from here.
	
	/**
	 * new instance of the database class.
	 */
	Database database = new Database();

	/**
	 * 
	 * @param vehicle. Vehicle with a specific registrationNumber is entered to find the correspodning inspections in the database.
	 * @return If there is a inspection for the given vehicle given in (@param) this method will return the cost for the full inspection.
	 * @throws InvalidVehicleException 
	 */
	public double findInspection(Vehicle vehicle) throws InvalidVehicleException{
		return database.fetchInspectionAndCost(vehicle);
	}
	/**
	 * 
	 * @param vehicle. Vehicle with a specific registrationNumber is entered to find the correspodning inspectionCheckList in the database
	 * @return If there is a inspectionChecklist for the given vehicle the next inspection on that checklist will be returned.
	 */
	public String findInspectionChecklist(Vehicle vehicle){
		return database.fetchInspectionChecklist(vehicle);
	}
	/**
	 * 
	 * @param the current inspection on the inspectionChecklist.
	 */
	public void storeCurrentResult(String currentCompletedInspection){
		database.saveCurrentResult(currentCompletedInspection);
	}
	/**
	 * 
	 * @param vehicle. Vehicle with a specific registrationNumber is entered to find the correspoding finnal inspection result.
	 * @return Returns the corresponding finnal resolts for the given vehicle. 
	 */
	public String findFinnalResult(Vehicle vehicle){
		return database.collectFinnalResults(vehicle);
	}
	
	public String showChecklist(Vehicle vehicle){
		return database.checklistReturn(vehicle);
	}
	
}
