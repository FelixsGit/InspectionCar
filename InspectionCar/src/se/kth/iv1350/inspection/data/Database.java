package se.kth.iv1350.inspection.data;
import java.util.Arrays;

import se.kth.iv1350.inspection.model.Vehicle;

public class Database {
	
	/**
	 * This Databse class represents a virtual database.
	 */
	public int currentInspectionCounter = 0;
	public int saveCurrentInspectionCounter = 0;
	
	private static final double cost = 1000;
	private String[] registerdVehicles = {"ABC123", "LKF245", "LDK424"};	
	private final String[][] inspectionChecklist = {{"check oil","check windows","check lights"},{"check oil","check seats","check wheels"},{"check oil","check engine","check dashboard"}};
	private final String[] inspectionsCompleted = new String[inspectionChecklist.length];
	private String finnalResults;
	private int foundVehicle = 0;
	private String currentInspectionChecklist;
	
	
	/**
	 * 
	 * @param vehicle. The object vehical that contains the car register number.
	 * @return if there is a match it will return the cost of the inspection, if not null. 
	 */
	
	public double fetchInspectionAndCost(Vehicle vehicle) throws InvalidVehicleException {
		for(int i = 0; i < registerdVehicles.length; i++){
			if(vehicle.getRegistrationNumber().equals(registerdVehicles[i])){
				foundVehicle++;
				return cost;
			}
		}
		if(foundVehicle == 0){
			throw new InvalidVehicleException(vehicle.getRegistrationNumber());
		}
		return 0;
	}

	/**
	 * 
	 * @param vehicle . The object that contains the car register number.
	 * @return returns the next inspection to do. 
	 */
	public String fetchInspectionChecklist(Vehicle vehicle){
		for(int i = 0; i < registerdVehicles.length; i++){
			if(vehicle.getRegistrationNumber().equals(registerdVehicles[i])){
				for(int j = currentInspectionCounter;j < inspectionChecklist.length; j++){
					String nextInspection = inspectionChecklist[i][j];
					System.out.println("Working on: "+nextInspection);
					currentInspectionCounter++;
					return nextInspection;
				}
			}
		}
		return  "Vehicle Not In System";
		
	}
	public String checklistReturn(Vehicle vehicle){
		for(int i = 0; i < registerdVehicles.length; i++){
			if(vehicle.getRegistrationNumber().equals(registerdVehicles[i])){
				currentInspectionChecklist = Arrays.toString(inspectionChecklist[i]);
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
		for(int i = saveCurrentInspectionCounter; i<inspectionChecklist.length; i++){
			if(currentCompletedInspection == "Vehicle Not In System"){
				break;
			}
			inspectionsCompleted[i] = currentCompletedInspection + " -PASS";
			System.out.println("saving results for-------"+currentCompletedInspection+"--------");
			saveCurrentInspectionCounter++;
			break;
		}
		finnalResults = Arrays.toString(inspectionsCompleted);
		return finnalResults;	
	}
	/**
	 * 
	 * @param vehicle. The object that contains the registernumber
	 * @return the finnal results of the completed inspectionlinked linked to the vehical given in the parameter. If the database dont have any 
	 * finnal results <code>"No results found"<code> will be returned. 
	 */
	public String collectFinnalResults(Vehicle vehicle){
		for(int i = 0; i < registerdVehicles.length; i++){
			if(vehicle.getRegistrationNumber().equals(registerdVehicles[i])){
				return finnalResults;
			}
		}
		return "No results found";
	}
}
