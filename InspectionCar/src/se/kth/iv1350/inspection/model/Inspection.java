package se.kth.iv1350.inspection.model;

import java.util.Arrays;

import se.kth.iv1350.inspection.integration.DatabaseManager;
import se.kth.iv1350.inspection.integration.Observer;
import se.kth.iv1350.inspection.view.InspectionStatsView;

public class Inspection {
	
	Observer observer = new InspectionStatsView();
	DatabaseManager databaseManager = new DatabaseManager(); 
	public int currentInspectionCounter = 0;
	public int saveCurrentInspectionCounter = 0;
	private String finnalResults;
	private int foundVehicle = 0;
	private final String[] inspectionsCompleted = new String[databaseManager.retriveInspectionChecklist().length];
	private String currentInspectionChecklist;
	private String result = "-PASS";
	
	/**
	 * @param vehicle. The object vehical that contains the car register number.
	 * @return if there is a match it will return the cost of the inspection, if not null. 
	 */
	public double fetchInspectionAndCost(Vehicle vehicle) throws InvalidVehicleException {
		for(int i = 0; i < databaseManager.retriveRegisterdVehicels().length; i++){
			if(vehicle.getRegistrationNumber().equals(databaseManager.retriveRegisterdVehicels()[i])){
				foundVehicle++;
				return databaseManager.retriveCost();
			}
		}
		if(foundVehicle == 0){
			throw new InvalidVehicleException(vehicle.getRegistrationNumber());
		}
		return 0;
	}

	/**
	 * @param vehicle . The object that contains the car register number.
	 * @return returns the next inspection to do. 
	 */
	public String fetchNextInspection(Vehicle vehicle){
		for(int i = 0; i < databaseManager.retriveRegisterdVehicels().length; i++){
			if(vehicle.getRegistrationNumber().equals(databaseManager.retriveRegisterdVehicels()[i])){
				for(int j = currentInspectionCounter;j < databaseManager.retriveInspectionChecklist().length; j++){
					String nextInspection = databaseManager.retriveInspectionChecklist()[i][j];
					currentInspectionCounter++;
					return nextInspection;
				}
			}
		}
		return  "Vehicle Not In System";
		
	}
	public String checklistReturn(Vehicle vehicle){
		for(int i = 0; i < databaseManager.retriveRegisterdVehicels().length; i++){
			if(vehicle.getRegistrationNumber().equals(databaseManager.retriveRegisterdVehicels()[i])){
				currentInspectionChecklist = Arrays.toString(databaseManager.retriveInspectionChecklist()[i]);
				return currentInspectionChecklist;
			}
		}
		return  "Vehicle Not In System";
		
	}
	/**
	 * @param currentCompletedInspection. The inspections that was just performed
	 * @return The finnal results of the completed inspections
	 */
	public String saveCurrentResult(String currentCompletedInspection) {
		for(int i = saveCurrentInspectionCounter; i<databaseManager.retriveInspectionChecklist().length; i++){
			if(currentCompletedInspection == "Vehicle Not In System"){
				break;
			}
			inspectionsCompleted[i] = currentCompletedInspection + result;
			System.out.println("\nsaving results for-------"+currentCompletedInspection+"--------");
			observer.CountPassOrFail(result);
			saveCurrentInspectionCounter++;
			break;
		}
		databaseManager.saveCurrentResult(inspectionsCompleted);
		finnalResults = Arrays.toString(inspectionsCompleted);
		return finnalResults;	
	}
	/**
	 * @param vehicle. The object that contains the registernumber
	 * @return the finnal results of the completed inspectionlinked linked to the vehical given in the parameter. If the database dont have any 
	 * finnal results <code>"No results found"<code> will be returned. 
	 */
	public String collectFinnalResults(Vehicle vehicle){
		for(int i = 0; i < databaseManager.retriveRegisterdVehicels().length; i++){
			if(vehicle.getRegistrationNumber().equals(databaseManager.retriveRegisterdVehicels()[i])){
				return databaseManager.retriveFinnalResult();
			}
		}
		return "No results found";
	}
	
}
